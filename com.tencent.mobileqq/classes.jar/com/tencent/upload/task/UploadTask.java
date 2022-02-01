package com.tencent.upload.task;

import SLICE_UPLOAD.FileBatchCommitRsp;
import SLICE_UPLOAD.FileBatchControlRsp;
import SLICE_UPLOAD.FileControlRsp;
import SLICE_UPLOAD.FileUploadRsp;
import SLICE_UPLOAD.stResult;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.Parcel;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.tencent.upload.common.UploadConfiguration;
import com.tencent.upload.common.UploadGlobalConfig;
import com.tencent.upload.impl.BaseUploadService;
import com.tencent.upload.network.route.IUploadRouteStrategy;
import com.tencent.upload.network.route.IUploadRouteStrategy.RouteCategoryType;
import com.tencent.upload.network.route.ServerRouteTable;
import com.tencent.upload.network.route.UploadRoute;
import com.tencent.upload.network.session.IUploadSession;
import com.tencent.upload.network.session.IUploadSession.RequestListener;
import com.tencent.upload.network.session.SessionPool;
import com.tencent.upload.network.session.UploadSession;
import com.tencent.upload.network.session.cache.CacheUtil;
import com.tencent.upload.report.Report;
import com.tencent.upload.request.IActionRequest;
import com.tencent.upload.request.UploadRequest;
import com.tencent.upload.request.UploadResponse;
import com.tencent.upload.request.impl.FileControlRequest;
import com.tencent.upload.request.impl.FileUploadRequest;
import com.tencent.upload.task.data.UploadDataSource;
import com.tencent.upload.task.data.UploadDataSource.ByteDataSource;
import com.tencent.upload.task.data.UploadDataSource.FileDataSource;
import com.tencent.upload.uinterface.IUploadConfig;
import com.tencent.upload.utils.Const.UploadRetCode;
import com.tencent.upload.utils.FileUtils;
import com.tencent.upload.utils.JceEncoder;
import com.tencent.upload.utils.StringUtils;
import com.tencent.upload.utils.UploadLog;
import com.tencent.upload.utils.pool.ThreadPool;
import com.tencent.upload.utils.pool.UploadThreadManager;
import com.tencent.upload.utils.watcher.UploadFlowTracker;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Future;

public abstract class UploadTask
  extends BaseTask
  implements IUploadSession.RequestListener
{
  protected static final int DEFAULT_MAX_NETWORK_RETRY_TIMES = 8;
  protected static final int DEFAULT_MAX_RETRY_TIMES = 3;
  protected static final int DEFAULT_MD5_FILE_LIMIT = 5;
  protected static final int DEFAULT_PHOTO_SLICE_SIZE = 32;
  protected static final int DEFAULT_VIDEO_SLICE_SIZE = 64;
  private static final int POLLSESSION_RETRYTIME = 2;
  public static final String REPORT_MSG_DIVIDER = " || ";
  protected static final String SPEED_TAG = "[speed] ";
  protected static final int STEP_SECONDS_UPLOAD = 2;
  protected static final int STEP_SEND_CONTROL_REQ = 0;
  protected static final int STEP_SEND_FILESLICE_REQ = 1;
  protected static final String TAG = "UploadTask";
  private static final int WHAT_COMPLETE_TIME_OUT = 1001;
  public int flowId;
  public int iAppid;
  protected String mAppid;
  private AtomFile mAtomFile;
  protected String mClientIp;
  protected String mConnectedIp = "";
  protected int mConnectedPort = 0;
  long mControlPkgEndTime;
  long mControlPkgStartTime;
  private int mCurrControlReqId = 0;
  protected long mDataLength;
  long mDataPkgEndTime;
  long mDataPkgStartTime;
  protected UploadDataSource mDataSource;
  long mEndTime;
  protected String mFilePath;
  protected long mFileRecvOffset;
  protected long mFileSendOffset;
  protected volatile boolean mFinish;
  protected boolean mFlagError = false;
  protected Handler mHandler;
  boolean mIsFastUpload = false;
  protected long mLastSendOffset;
  protected long mLastSliceSize;
  protected String mMd5;
  protected IUploadSession[] mMultiSession;
  private ArrayList<UploadTask.UploadThread> mMultiThreads = new ArrayList(5);
  protected boolean mNeedReset;
  protected int mNetworkRetryCount = 0;
  protected Report mReportObj = new Report();
  protected volatile boolean mReported = false;
  protected int mRetryCount = 0;
  protected IUploadSession mSavedSession;
  protected boolean mSecondUpload;
  protected FileControlRsp mSecondUploadRsp;
  protected String mServerIp;
  protected IUploadSession mSession;
  protected String mSessionId;
  protected SessionPool mSessionPool;
  protected String mSha1;
  protected int mSliceSize;
  long mStartTime;
  protected volatile int mStep = 0;
  protected TaskStateListener mTaskStateListener;
  protected UploadRoute mUploadRoute;
  
  public UploadTask(Parcel paramParcel)
  {
    this.mTaskId = paramParcel.readInt();
    this.mDataSource = ((UploadDataSource)paramParcel.readParcelable(UploadDataSource.class.getClassLoader()));
    this.mSessionId = paramParcel.readString();
    TaskState localTaskState = TaskState.getStateFromCode(paramParcel.readInt());
    if (localTaskState != TaskState.CONNECTING)
    {
      paramParcel = localTaskState;
      if (localTaskState != TaskState.SENDING) {}
    }
    else
    {
      paramParcel = TaskState.WAITING;
    }
    setTaskStatus(paramParcel);
  }
  
  public UploadTask(String paramString)
  {
    this.mFilePath = paramString;
    this.mDataSource = new UploadDataSource.FileDataSource(paramString);
  }
  
  public UploadTask(byte[] paramArrayOfByte)
  {
    this.mDataSource = new UploadDataSource.ByteDataSource(paramArrayOfByte);
  }
  
  private void clearCompleteTimer()
  {
    this.mHandler.removeMessages(this.flowId + 1001);
  }
  
  private int getConnectionNum()
  {
    return BaseUploadService.getFileSocketNumber();
  }
  
  private boolean multiThreadSendFilePkg()
  {
    int j = 0;
    if ((getTaskState() == TaskState.PAUSE) || (getTaskState() == TaskState.CANCEL)) {
      return false;
    }
    this.mAtomFile = new AtomFile(this.mFilePath);
    this.mAtomFile.setSliceSize(this.mSliceSize).setSessionId(this.mSessionId).setOffset(this.mFileSendOffset).setStartTime(System.currentTimeMillis());
    UploadLog.d("UploadTask", "taskId:" + this.mTaskId + ", filePkg, begin to wait available session ----> ");
    int k = getConnectionNum();
    IUploadSession[] arrayOfIUploadSession = new IUploadSession[k];
    int i = 0;
    if (i < k)
    {
      if ((i == 0) && (this.mSession != null)) {
        arrayOfIUploadSession[i] = this.mSession;
      }
      for (;;)
      {
        i += 1;
        break;
        arrayOfIUploadSession[i] = pollSessionWithRetry(2);
      }
    }
    if (this.mFinish)
    {
      UploadLog.w("UploadTask", "taskId:" + this.mTaskId + ", filePkg, after poll task has been finished !");
      return false;
    }
    this.mMultiSession = arrayOfIUploadSession;
    this.mSavedSession = this.mMultiSession[0];
    if ((arrayOfIUploadSession == null) || (arrayOfIUploadSession.length <= 0) || (!sessionsValidCheck(arrayOfIUploadSession)))
    {
      UploadLog.e("UploadTask", "taskId:" + this.mTaskId + ", filePkg, multi session == null! no session to upload");
      UploadFlowTracker.trackFlow(this, "无可用session");
      onError(Const.UploadRetCode.NO_SESSION.getCode(), Const.UploadRetCode.NO_SESSION.getDesc());
      return false;
    }
    long l = System.currentTimeMillis();
    this.mStartTime = l;
    this.mDataPkgStartTime = l;
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("taskId:").append(this.mTaskId).append(", sendFilePkg, mDataLength:").append(this.mDataLength).append(", use sessions size:").append(arrayOfIUploadSession.length).append(", sessions detail:");
    k = arrayOfIUploadSession.length;
    i = 0;
    while (i < k)
    {
      IUploadSession localIUploadSession = arrayOfIUploadSession[i];
      if (localIUploadSession != null) {
        ((StringBuffer)localObject).append(localIUploadSession.getUploadRoute().toString() + " ");
      }
      i += 1;
    }
    UploadLog.d("[iplist] UploadTask", ((StringBuffer)localObject).toString());
    UploadFlowTracker.trackFlow(this, "数据包开始发送");
    this.mMultiThreads.clear();
    k = arrayOfIUploadSession.length;
    i = j;
    while (i < k)
    {
      localObject = arrayOfIUploadSession[i];
      if (localObject != null)
      {
        localObject = new UploadTask.UploadThread(this, this.mAtomFile, (IUploadSession)localObject);
        this.mMultiThreads.add(localObject);
        ((UploadTask.UploadThread)localObject).tFuture = UploadThreadManager.getInstance().getDataThreadPool().submit((Runnable)localObject);
      }
      i += 1;
    }
    return true;
  }
  
  private void onFileUploadResponse(FileUploadRsp paramFileUploadRsp, UploadResponse paramUploadResponse)
  {
    int i = 0;
    if ((paramFileUploadRsp == null) || (paramUploadResponse == null)) {
      if ("onFileUploadResponse " + paramFileUploadRsp == null)
      {
        paramFileUploadRsp = "rsp == null";
        UploadLog.e("UploadTask", paramFileUploadRsp);
        onError(Const.UploadRetCode.RESPONSE_IS_NULL.getCode(), Const.UploadRetCode.RESPONSE_IS_NULL.getDesc());
      }
    }
    do
    {
      do
      {
        return;
        paramFileUploadRsp = "response == null";
        break;
        UploadLog.d("[transfer] UploadTask", "recv FileUploadResponse taskId=" + getTaskId() + " reqId=" + paramUploadResponse.getRequestSequence() + " cmd=" + paramUploadResponse.getCmd() + " ret=" + paramFileUploadRsp.result.ret + " flag=" + paramFileUploadRsp.result.flag + " msg=" + paramFileUploadRsp.result.msg + " sid=" + paramUploadResponse.getSid() + " retry=" + this.mRetryCount + " offset=" + paramFileUploadRsp.offset + " totalSize=" + this.mDataLength + " sendOffset=" + this.mFileSendOffset + " session=" + paramFileUploadRsp.session + " mFlagError=" + this.mFlagError);
      } while ((paramUploadResponse.getRequestSequence() < this.mCurrControlReqId) || (this.mFlagError));
      clearCompleteTimer();
      if (paramFileUploadRsp.result.ret != 0)
      {
        this.mFlagError = true;
        if (this.mRetryCount < getMaxRetryTimes())
        {
          switch (paramFileUploadRsp.result.flag)
          {
          default: 
            onError(paramFileUploadRsp.result.ret, paramFileUploadRsp.result.msg);
            return;
          case 11: 
          case 12: 
            this.mRetryCount += 1;
            quitMultiThreadUpload();
            postExecute(0, true);
            return;
          case 13: 
            this.mRetryCount += 1;
            this.mSessionId = "";
            quitMultiThreadUpload();
            postExecute(0, true);
            return;
          }
          this.mRetryCount += 1;
          resetWaitState();
          quitMultiThreadUpload();
          resetSessionPool(true);
          this.mSessionId = "";
          return;
        }
        onError(paramFileUploadRsp.result.ret, paramFileUploadRsp.result.msg);
        return;
      }
      if ((paramFileUploadRsp.result.flag == 1) || (paramFileUploadRsp.result.flag == 2)) {
        i = 1;
      }
      if (i != 0)
      {
        this.mFinish = true;
        long l1 = System.currentTimeMillis();
        this.mEndTime = l1;
        this.mDataPkgEndTime = l1;
        onUploadProgress(this.mDataLength, this.mDataLength);
        processFileUploadFinishRsp(paramFileUploadRsp.biz_rsp);
        l1 = this.mEndTime;
        long l2 = this.mStartTime;
        paramFileUploadRsp = (float)this.mDataLength * 1.0F * 1000.0F / (float)((l1 - l2) * 1024L) + "KB/s";
        UploadLog.d("UploadTask", "[speed] taskId:" + getTaskId() + ", control pkg cost: " + (this.mControlPkgEndTime - this.mControlPkgStartTime));
        UploadLog.d("UploadTask", "[speed] taskId:" + getTaskId() + ", data pkg cost: " + (this.mDataPkgEndTime - this.mDataPkgStartTime));
        UploadLog.d("UploadTask", "[speed] taskId:" + getTaskId() + ", finish -- speed: " + paramFileUploadRsp + " length: " + this.mDataLength / 1024L + "K");
        this.mFileRecvOffset = this.mDataLength;
        return;
      }
      startCompleteTimer();
    } while (this.mFileRecvOffset >= paramFileUploadRsp.offset);
    this.mFileRecvOffset = paramFileUploadRsp.offset;
    onUploadProgress(this.mDataLength, this.mFileRecvOffset);
    UploadLog.d("UploadTask", "taskId:" + getTaskId() + ", UploadProgress: [" + paramFileUploadRsp.offset + "," + this.mDataLength + "]");
  }
  
  private void onTaskInfoChanged()
  {
    if (this.mTaskStateListener != null) {
      this.mTaskStateListener.onTaskInfoChanged(this);
    }
  }
  
  private IUploadSession pollSessionWithRetry(int paramInt)
  {
    if (this.mSessionPool == null) {
      return null;
    }
    IUploadSession localIUploadSession2 = this.mSessionPool.poll();
    IUploadSession localIUploadSession1 = localIUploadSession2;
    if (localIUploadSession2 == null)
    {
      localIUploadSession1 = localIUploadSession2;
      if (paramInt > 0)
      {
        UploadLog.e("UploadTask", "pollSessionWithRetry session == null ! retry poll session. retryTime:" + paramInt);
        do
        {
          localIUploadSession2 = this.mSessionPool.poll();
          paramInt -= 1;
          localIUploadSession1 = localIUploadSession2;
          if (localIUploadSession2 != null) {
            break;
          }
          localIUploadSession1 = localIUploadSession2;
          if (paramInt <= 0) {
            break;
          }
        } while (!this.mFinish);
        localIUploadSession1 = localIUploadSession2;
      }
    }
    UploadFlowTracker.trackRoute(this, localIUploadSession1);
    return localIUploadSession1;
  }
  
  private void resetSessionPool(String paramString, int paramInt)
  {
    UploadLog.d("UploadTask", "resetSessionPool taskId=" + getTaskId() + " delete mSessionId:" + this.mSessionId);
    CacheUtil.deleteSessionId(this, this.mSessionId);
    this.mSessionPool.reset(new UploadRoute(paramString, paramInt, IUploadRouteStrategy.RouteCategoryType.REDIRECT));
  }
  
  private void resetSessionPool(boolean paramBoolean)
  {
    UploadLog.d("UploadTask", "resetSessionPool taskId=" + getTaskId() + " delete:" + paramBoolean + " mSessionId:" + this.mSessionId);
    if (paramBoolean) {
      CacheUtil.deleteSessionId(this, this.mSessionId);
    }
    if (this.mSessionPool != null) {
      this.mSessionPool.reset();
    }
  }
  
  private boolean sendControlPkg()
  {
    if ((getTaskState() == TaskState.PAUSE) || (getTaskState() == TaskState.CANCEL) || (getTaskState() == TaskState.SUCCEED)) {
      return false;
    }
    if (!this.mDataSource.exists())
    {
      UploadFlowTracker.trackFlow(this, "上传文件不存在");
      onError(Const.UploadRetCode.FILE_NOT_EXIST.getCode(), Const.UploadRetCode.FILE_NOT_EXIST.getDesc());
      return false;
    }
    if (this.mDataSource.getDataLength() <= 0L)
    {
      UploadFlowTracker.trackFlow(this, "上传文件长度异常");
      onError(Const.UploadRetCode.FILE_LENGTH_INVALID.getCode(), Const.UploadRetCode.FILE_LENGTH_INVALID.getDesc());
      return false;
    }
    setState(TaskState.CONNECTING);
    IUploadSession localIUploadSession = pollSessionWithRetry(2);
    if (this.mFinish)
    {
      UploadLog.w("UploadTask", "after poll task has been finished !");
      return false;
    }
    if (localIUploadSession == null)
    {
      UploadFlowTracker.trackFlow(this, "获取session失败");
      onError(Const.UploadRetCode.NO_SESSION.getCode(), Const.UploadRetCode.NO_SESSION.getDesc());
      return false;
    }
    this.mSession = localIUploadSession;
    this.mSavedSession = localIUploadSession;
    UploadLog.d("UploadTask", "[sendControlPkg] taskId=" + getTaskId() + ", getIdleSession=" + localIUploadSession.hashCode() + ", sessionId=" + this.mSessionId);
    UploadRequest localUploadRequest = getControlRequest();
    this.mCurrControlReqId = localUploadRequest.getRequestId();
    this.mFlagError = false;
    UploadLog.d("UploadTask", "sendControlPkg taskId=" + getTaskId() + " reqId=" + this.mCurrControlReqId + " retry=" + this.mRetryCount + " route=" + localIUploadSession.getUploadRoute() + " mDataLength=" + this.mDataLength);
    long l = System.currentTimeMillis();
    this.mControlPkgStartTime = l;
    this.mStartTime = l;
    setTaskStatus(TaskState.SENDING);
    UploadFlowTracker.trackFlow(this, "开始发送控制包");
    boolean bool = localIUploadSession.send(localUploadRequest, this);
    UploadLog.d("UploadTask", "taskId=" + getTaskId() + ", sendControlPkg result=" + bool);
    return true;
  }
  
  private boolean sessionsValidCheck(IUploadSession[] paramArrayOfIUploadSession)
  {
    if ((paramArrayOfIUploadSession == null) || (paramArrayOfIUploadSession.length == 0)) {}
    for (;;)
    {
      return false;
      int i = 0;
      while (i < paramArrayOfIUploadSession.length)
      {
        if (paramArrayOfIUploadSession[i] != null) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  private void startCompleteTimer()
  {
    this.mHandler.removeMessages(this.flowId + 1001);
    Message localMessage = Message.obtain(this.mHandler, new UploadTask.1(this));
    localMessage.what = (this.flowId + 1001);
    this.mHandler.sendMessageDelayed(localMessage, UploadSession.getSendTimeout(0));
  }
  
  protected void abortSession(IUploadSession paramIUploadSession)
  {
    UploadLog.i("UploadTask", "abort session:" + paramIUploadSession.hashCode());
    if ((this.mSession != null) && (this.mSession.equals(paramIUploadSession))) {
      this.mSession = null;
    }
    if (this.mMultiSession != null)
    {
      int i = 0;
      while (i < this.mMultiSession.length)
      {
        if ((this.mMultiSession[i] != null) && (this.mMultiSession[i].equals(paramIUploadSession))) {
          this.mMultiSession[i] = null;
        }
        i += 1;
      }
    }
  }
  
  public void bindHandler(Handler paramHandler)
  {
    this.mHandler = paramHandler;
  }
  
  public void bindSessionPool(SessionPool paramSessionPool)
  {
    this.mSessionPool = paramSessionPool;
  }
  
  public boolean cancel()
  {
    UploadLog.w("[transfer]UploadTask", "task canceled by user, taskId:" + getTaskId());
    if (getTaskState() == TaskState.SUCCEED) {
      return false;
    }
    super.cancel();
    resetTask();
    setTaskStatus(TaskState.CANCEL);
    this.mRetryCount = 0;
    this.mFinish = true;
    onTaskFinished(Const.UploadRetCode.CANCELED.getCode(), Const.UploadRetCode.CANCELED.getDesc());
    return true;
  }
  
  protected final void cancelForError(int paramInt, String paramString)
  {
    UploadLog.w("[transfer] UploadTask", "cancelForError taskId:" + getTaskId() + " errorCode=" + paramInt + " retryCount:" + this.mRetryCount + " mNetworkRetryCount:" + this.mNetworkRetryCount + " errorMsg=" + paramString + " mFinish=" + this.mFinish);
    if ((paramInt == 0) || (this.mFinish)) {
      return;
    }
    super.cancel();
    this.mFinish = true;
    this.mSliceSize = 0;
    onUploadError(paramInt, paramString);
    setTaskStatus(TaskState.FAILED);
    onTaskFinished(paramInt, paramString);
  }
  
  protected abstract int getBucketSize();
  
  protected abstract UploadRequest getControlRequest();
  
  public UploadDataSource getDataSource()
  {
    return this.mDataSource;
  }
  
  public String getFilePath()
  {
    return this.mFilePath;
  }
  
  protected FileUploadRequest getFileUploadRequest(AtomFile paramAtomFile)
  {
    return null;
  }
  
  protected int getMaxNetworkRetryTimes()
  {
    return 8;
  }
  
  protected int getMaxRetryTimes()
  {
    return 3;
  }
  
  public String getMd5()
  {
    return this.mMd5;
  }
  
  public UploadRoute getRoute()
  {
    return this.mUploadRoute;
  }
  
  public String getSessionId()
  {
    return this.mSessionId;
  }
  
  public String getSha1()
  {
    return this.mSha1;
  }
  
  public int getSliceSize()
  {
    return this.mSliceSize;
  }
  
  public float getUploadProgress()
  {
    if (this.mDataLength <= 0L) {
      this.mDataLength = this.mDataSource.getDataLength();
    }
    if ((this.mFileSendOffset >= this.mDataLength) || (this.mDataLength <= 0L) || (getTaskState() == TaskState.SUCCEED)) {
      return 100.0F;
    }
    return 100.0F * (float)this.mFileSendOffset / (float)this.mDataLength;
  }
  
  public boolean isDataSourceValid()
  {
    if (this.mDataSource != null) {
      return this.mDataSource.isValid();
    }
    return false;
  }
  
  public void onError(int paramInt, String paramString)
  {
    UploadLog.e("UploadTask", "taskId:" + getTaskId() + " onError errCode:" + paramInt + " desc:" + paramString);
    cancelForError(paramInt, paramString);
  }
  
  protected void onFileControlResponse(JceStruct paramJceStruct, UploadResponse paramUploadResponse)
  {
    long l = 0L;
    if (paramJceStruct == null)
    {
      UploadLog.d("UploadTask", "onFileControlResponse rsp == null " + hashCode());
      onError(Const.UploadRetCode.RESPONSE_IS_NULL.getCode(), Const.UploadRetCode.RESPONSE_IS_NULL.getDesc());
    }
    do
    {
      return;
      if ((paramJceStruct instanceof FileBatchControlRsp))
      {
        onFileControlResponse((FileControlRsp)((FileBatchControlRsp)paramJceStruct).control_rsp.get("1"), paramUploadResponse);
        return;
      }
      paramJceStruct = (FileControlRsp)paramJceStruct;
      UploadLog.d("[transfer] UploadTask", "recv FileControlResponse taskId=" + getTaskId() + " reqId=" + paramUploadResponse.getRequestSequence() + " cmd=" + paramUploadResponse.getCmd() + " ret=" + paramJceStruct.result.ret + " flag=" + paramJceStruct.result.flag + " msg=" + paramJceStruct.result.msg + " retry=" + this.mRetryCount + " offset=" + paramJceStruct.offset + " slice_size=" + paramJceStruct.slice_size + " session=" + paramJceStruct.session);
      this.mControlPkgEndTime = System.currentTimeMillis();
      if (paramJceStruct.result.ret != 0)
      {
        if (this.mRetryCount < getMaxRetryTimes())
        {
          switch (paramJceStruct.result.flag)
          {
          default: 
            onError(paramJceStruct.result.ret, paramJceStruct.result.msg);
            return;
          case 11: 
          case 12: 
            this.mRetryCount += 1;
            postExecute(0, true);
            return;
          case 13: 
            this.mRetryCount += 1;
            this.mSessionId = "";
            postExecute(0, true);
            return;
          }
          this.mRetryCount += 1;
          resetWaitState();
          resetSessionPool(true);
          this.mSessionId = "";
          return;
        }
        onError(paramJceStruct.result.ret, paramJceStruct.result.msg);
        return;
      }
      if (paramJceStruct.result.flag == 0) {
        break;
      }
    } while ((paramJceStruct.result.flag != 1) && (paramJceStruct.result.flag != 2));
    UploadLog.d("UploadTask", "taskId=" + getTaskId() + "rsp.result.flag=" + paramJceStruct.result.flag + " upload success !");
    l = System.currentTimeMillis();
    this.mEndTime = l;
    this.mDataPkgEndTime = l;
    onUploadProgress(this.mDataLength, this.mDataLength);
    this.mIsFastUpload = true;
    processFileUploadFinishRsp(paramJceStruct.biz_rsp);
    return;
    if (!TextUtils.isEmpty(paramJceStruct.redirect_ip))
    {
      this.mSessionId = "";
      paramJceStruct = paramJceStruct.redirect_ip;
      if (this.mUploadRoute != null) {}
      for (int i = this.mUploadRoute.getPort();; i = 443)
      {
        resetSessionPool(paramJceStruct, i);
        return;
      }
    }
    UploadLog.d("UploadTask", "slicesize=" + paramJceStruct.slice_size);
    this.mSliceSize = ((int)paramJceStruct.slice_size);
    this.mSessionId = paramJceStruct.session;
    UploadLog.d("UploadTask", "cacheSessionId :" + this.mSessionId);
    CacheUtil.cacheSessionId(this, this.mSessionId);
    if (paramJceStruct.offset < 0L) {}
    for (;;)
    {
      this.mFileSendOffset = l;
      this.mFileRecvOffset = l;
      this.mDataPkgStartTime = System.currentTimeMillis();
      postExecute(1, false);
      return;
      l = paramJceStruct.offset;
    }
  }
  
  public void onRequestError(IActionRequest paramIActionRequest, Const.UploadRetCode paramUploadRetCode, IUploadSession paramIUploadSession)
  {
    boolean bool = paramIActionRequest.getTag() instanceof UploadTask.UploadThread;
    if (bool) {}
    for (String str = ((UploadTask.UploadThread)paramIActionRequest.getTag()).tTAG;; str = "")
    {
      UploadLog.d("UploadTask", str + "onRequestError taskId=" + getTaskId() + " reqId=" + paramIActionRequest.getRequestId() + " CMD=" + paramIActionRequest.getCmdId() + " mNetworkRetryCount=" + this.mNetworkRetryCount + " session=" + paramIUploadSession.hashCode() + " code: " + paramUploadRetCode + " mCurrControlReqId=" + this.mCurrControlReqId + " mFlagError:" + this.mFlagError + " mFinish:" + this.mFinish);
      abortSession(paramIUploadSession);
      if ((paramIActionRequest.getRequestId() >= this.mCurrControlReqId) && (!this.mFlagError) && (!this.mFinish)) {
        break;
      }
      UploadLog.d("UploadTask", "onRequestError return");
      return;
    }
    this.mFlagError = true;
    if (bool) {
      quitMultiThreadUpload();
    }
    if ((paramUploadRetCode == Const.UploadRetCode.OOM) || (paramUploadRetCode == Const.UploadRetCode.SESSION_REQUEST_ENCODE_ERROR) || (paramUploadRetCode == Const.UploadRetCode.SESSION_CONN_SEND_FAILED))
    {
      cancelForError(paramUploadRetCode.getCode(), paramUploadRetCode.getDesc());
      return;
    }
    if (paramUploadRetCode == Const.UploadRetCode.NETWORK_NOT_AVAILABLE)
    {
      cancelForError(Const.UploadRetCode.NETWORK_NOT_AVAILABLE.getCode(), Const.UploadRetCode.NETWORK_NOT_AVAILABLE.getDesc());
      return;
    }
    if (this.mNetworkRetryCount < getMaxNetworkRetryTimes())
    {
      this.mNetworkRetryCount += 1;
      postExecute(0, true);
      return;
    }
    cancelForError(paramUploadRetCode.getCode(), paramUploadRetCode.getDesc());
  }
  
  public void onRequestSended(IActionRequest paramIActionRequest)
  {
    if (getTaskState() == TaskState.CANCEL) {}
    do
    {
      do
      {
        do
        {
          return;
          boolean bool = paramIActionRequest.getTag() instanceof UploadTask.UploadThread;
          if (bool) {}
          for (String str = ((UploadTask.UploadThread)paramIActionRequest.getTag()).tTAG;; str = "")
          {
            UploadLog.d("[transfer] UploadTask", str + " onRequestSended taskId=" + getTaskId() + ", reqId=" + paramIActionRequest.getRequestId());
            if (!bool) {
              break;
            }
            ((UploadTask.UploadThread)paramIActionRequest.getTag()).notifySendend();
            return;
          }
        } while (paramIActionRequest.getRequestId() < this.mCurrControlReqId);
        switch (UploadTask.2.$SwitchMap$com$tencent$upload$task$TaskState[getTaskState().ordinal()])
        {
        default: 
          return;
        }
        if ((paramIActionRequest instanceof FileUploadRequest))
        {
          UploadLog.d("[transfer] UploadTask", "send over reqId=" + paramIActionRequest.getRequestId() + " offset=" + this.mLastSendOffset + " slice=" + this.mLastSliceSize + " total=" + this.mDataLength);
          this.mDataPkgEndTime = System.currentTimeMillis();
          postExecute(1, false);
          return;
        }
      } while (!(paramIActionRequest instanceof FileControlRequest));
      paramIActionRequest = (FileControlRequest)paramIActionRequest;
    } while (paramIActionRequest.getFileDataLength() <= 0L);
    onUploadProgress(this.mDataLength, paramIActionRequest.getFileDataLength());
    this.mFileSendOffset = paramIActionRequest.getFileDataLength();
  }
  
  public void onRequestTimeout(IActionRequest paramIActionRequest, IUploadSession paramIUploadSession)
  {
    boolean bool = paramIActionRequest.getTag() instanceof UploadTask.UploadThread;
    if (bool) {}
    for (String str = ((UploadTask.UploadThread)paramIActionRequest.getTag()).tTAG;; str = "")
    {
      UploadLog.d("UploadTask", str + "onRequestTimeout taskId=" + getTaskId() + " reqId=" + paramIActionRequest.getRequestId() + " CMD=" + paramIActionRequest.getCmdId() + " mNetworkRetryCount=" + this.mNetworkRetryCount + " session=" + paramIUploadSession.hashCode() + " mCurrControlReqId=" + this.mCurrControlReqId + " mFlagError:" + this.mFlagError);
      UploadFlowTracker.trackFlow(this, "回包超时");
      abortSession(paramIUploadSession);
      if ((paramIActionRequest.getRequestId() >= this.mCurrControlReqId) && (!this.mFlagError) && (!this.mFinish)) {
        break;
      }
      return;
    }
    this.mFlagError = true;
    if (bool) {
      quitMultiThreadUpload();
    }
    if (this.mNetworkRetryCount < getMaxNetworkRetryTimes())
    {
      this.mNetworkRetryCount += 1;
      UploadFlowTracker.trackFlow(this, "重试发控制包，重试次数" + this.mNetworkRetryCount);
      quitMultiThreadUpload();
      postExecute(0, true);
      return;
    }
    cancelForError(Const.UploadRetCode.REQUEST_TIMEOUT.getCode(), Const.UploadRetCode.REQUEST_TIMEOUT.getDesc());
  }
  
  public void onResponse(IActionRequest paramIActionRequest, UploadResponse paramUploadResponse)
  {
    String str;
    if ((paramIActionRequest.getTag() instanceof UploadTask.UploadThread))
    {
      str = ((UploadTask.UploadThread)paramIActionRequest.getTag()).tTAG;
      UploadLog.d("[transfer] UploadTask", str + "recv --- taskId=" + this.mTaskId + ", reqId=" + paramIActionRequest.getRequestId());
      if ((getTaskState() != TaskState.SUCCEED) && (getTaskState() != TaskState.FAILED) && (getTaskState() != TaskState.CANCEL)) {
        break label110;
      }
    }
    label110:
    while (paramUploadResponse.getRequestSequence() < this.mCurrControlReqId)
    {
      return;
      str = "";
      break;
    }
    switch (paramUploadResponse.getCmd())
    {
    default: 
      return;
    case 1: 
      if (this.mAppid.equalsIgnoreCase("mobilelog")) {}
      for (paramIActionRequest = JceEncoder.decode(FileControlRsp.class, paramUploadResponse.getReponseData());; paramIActionRequest = JceEncoder.decode(FileBatchControlRsp.class, paramUploadResponse.getReponseData()))
      {
        onFileControlResponse(paramIActionRequest, paramUploadResponse);
        return;
      }
    case 2: 
      onFileUploadResponse((FileUploadRsp)JceEncoder.decode(FileUploadRsp.class, paramUploadResponse.getReponseData()), paramUploadResponse);
      return;
    }
    releaseSession();
    processFileBatchCommitRsp((FileBatchCommitRsp)JceEncoder.decode(FileBatchCommitRsp.class, paramUploadResponse.getReponseData()));
  }
  
  public boolean onRun()
  {
    this.mFinish = false;
    this.mStep = 0;
    if (this.mSecondUpload) {
      this.mStep = 2;
    }
    for (;;)
    {
      UploadLog.d("UploadTask", "onRun --- step: " + this.mStep + " taskId:" + getTaskId());
      switch (this.mStep)
      {
      default: 
        return true;
        if ((!TextUtils.isEmpty(this.mSessionId)) && (this.mSliceSize != 0) && (!this.mNeedReset)) {
          this.mStep = 1;
        } else if (this.mNeedReset) {
          this.mNeedReset = false;
        }
        break;
      }
    }
    UploadFlowTracker.trackFlow(this, "准备发送控制包");
    return sendControlPkg();
    UploadFlowTracker.trackFlow(this, "准备发送数据包");
    return multiThreadSendFilePkg();
    UploadResponse localUploadResponse = new UploadResponse();
    onFileControlResponse(this.mSecondUploadRsp, localUploadResponse);
    return true;
  }
  
  protected void onTaskFinished(int paramInt, String paramString)
  {
    releaseSession();
    if (this.mSavedSession != null)
    {
      this.mUploadRoute = this.mSavedSession.getUploadRoute();
      this.mConnectedIp = this.mSavedSession.getConnectedIp();
      if (this.mUploadRoute != null) {
        this.mConnectedPort = this.mUploadRoute.getPort();
      }
    }
    int i;
    if (paramInt == Const.UploadRetCode.SUCCEED.getCode())
    {
      i = paramInt;
      if (this.mSessionPool != null)
      {
        i = paramInt;
        if (this.mUploadRoute != null)
        {
          this.mSessionPool.saveRoute(this.mUploadRoute);
          i = paramInt;
        }
      }
    }
    for (;;)
    {
      if ((getTaskState() != TaskState.CANCEL) && (getTaskState() != TaskState.PAUSE)) {
        report(i, paramString);
      }
      if (this.mTaskStateListener != null) {
        this.mTaskStateListener.onTaskFinished(this, i, paramString);
      }
      return;
      i = paramInt;
      if (paramInt == Const.UploadRetCode.FAST_SUCCEED.getCode()) {
        i = Const.UploadRetCode.SUCCEED.getCode();
      }
    }
  }
  
  protected abstract void onUploadError(int paramInt, String paramString);
  
  protected abstract void onUploadProgress(long paramLong1, long paramLong2);
  
  protected abstract void onUploadStateChange(TaskState paramTaskState);
  
  protected abstract void onUploadSucceed(Object paramObject);
  
  public void onWaitCompleteTimeOut()
  {
    UploadLog.d("UploadTask", "onWaitCompleteTimeOut");
    UploadFlowTracker.trackFlow(this, "回包完整确认超时");
    if ((this.mFlagError) || (this.mFinish)) {
      return;
    }
    this.mFlagError = true;
    if (this.mRetryCount < getMaxRetryTimes())
    {
      UploadFlowTracker.trackFlow(this, "重试发发完整文件");
      UploadLog.d("UploadTask", "retry to send all file data");
      this.mRetryCount += 1;
      resetWaitState();
      quitMultiThreadUpload();
      resetSessionPool(true);
      this.mSessionId = "";
      return;
    }
    cancelForError(Const.UploadRetCode.DATA_COMPLETE_TIMEOUT.getCode(), Const.UploadRetCode.DATA_COMPLETE_TIMEOUT.getDesc());
  }
  
  public boolean pause()
  {
    if ((getTaskState() == TaskState.SUCCEED) || (getTaskState() == TaskState.FAILED) || (getTaskState() == TaskState.PAUSE) || (getTaskState() == TaskState.CANCEL)) {}
    while ((getTaskState() == TaskState.SENDING) && (this.mFileSendOffset >= this.mDataLength)) {
      return false;
    }
    super.pause();
    setTaskStatus(TaskState.PAUSE);
    onTaskFinished(Const.UploadRetCode.PAUSED.getCode(), Const.UploadRetCode.PAUSED.getDesc());
    return true;
  }
  
  protected void postExecute(int paramInt, boolean paramBoolean)
  {
    UploadLog.i("UploadTask", "postExecute taskId:" + getTaskId() + ", postExecute newStep:" + paramInt + " needReset:" + paramBoolean);
    try
    {
      if (this.mStep != paramInt) {
        this.mStep = paramInt;
      }
      this.mNeedReset = paramBoolean;
      if (paramBoolean)
      {
        quitMultiThreadUpload();
        super.cancel();
      }
      start();
      return;
    }
    finally {}
  }
  
  protected void processFileBatchCommitRsp(FileBatchCommitRsp paramFileBatchCommitRsp)
  {
    setTaskStatus(TaskState.SUCCEED);
    onTaskFinished(Const.UploadRetCode.SUCCEED.getCode(), Const.UploadRetCode.SUCCEED.getDesc());
  }
  
  protected void processFileUploadFinishRsp(byte[] paramArrayOfByte)
  {
    setTaskStatus(TaskState.SUCCEED);
    onTaskFinished(Const.UploadRetCode.SUCCEED.getCode(), Const.UploadRetCode.SUCCEED.getDesc());
  }
  
  protected void quitMultiThreadUpload()
  {
    synchronized (this.mMultiThreads)
    {
      Iterator localIterator = this.mMultiThreads.iterator();
      while (localIterator.hasNext())
      {
        UploadTask.UploadThread localUploadThread = (UploadTask.UploadThread)localIterator.next();
        localUploadThread.quit();
        if (localUploadThread.tFuture != null) {
          localUploadThread.tFuture.cancel(true);
        }
      }
    }
    this.mMultiThreads.clear();
  }
  
  protected void releaseSession()
  {
    if (this.mSessionPool == null) {}
    do
    {
      return;
      if (this.mSession != null)
      {
        this.mSessionPool.offer(this.mSession);
        this.mSession = null;
      }
    } while (this.mMultiSession == null);
    IUploadSession[] arrayOfIUploadSession = this.mMultiSession;
    int j = arrayOfIUploadSession.length;
    int i = 0;
    while (i < j)
    {
      IUploadSession localIUploadSession = arrayOfIUploadSession[i];
      if (localIUploadSession != null) {
        this.mSessionPool.offer(localIUploadSession);
      }
      i += 1;
    }
    this.mMultiSession = null;
  }
  
  protected void report(int paramInt, String paramString)
  {
    if (this.mReported) {}
    long l1;
    label466:
    label487:
    long l2;
    label601:
    label612:
    do
    {
      return;
      if ((paramInt == Const.UploadRetCode.NO_SESSION.getCode()) || (paramInt == Const.UploadRetCode.ALL_IP_FAILED.getCode()))
      {
        this.mReported = true;
        return;
      }
      int i = paramInt;
      if (paramInt == Const.UploadRetCode.FILE_LENGTH_INVALID.getCode()) {
        i = Const.UploadRetCode.FILE_NOT_EXIST.getCode();
      }
      this.mReportObj.retCode = i;
      this.mReportObj.errMsg = paramString;
      Object localObject;
      if (i != Const.UploadRetCode.SUCCEED.getCode())
      {
        localObject = new StringBuilder(50);
        ((StringBuilder)localObject).append(paramString);
        StringBuilder localStringBuilder = ((StringBuilder)localObject).append(" || ").append(" clientIp=");
        if (this.mClientIp == null)
        {
          paramString = "";
          localStringBuilder.append(paramString).append(" mState=").append(getTaskState().getDesc()).append(" mProgressTotalLen=").append(this.mFileSendOffset).append(" mProgressRecvDataLen=").append(this.mFileRecvOffset).append(" || ");
          if ((i == Const.UploadRetCode.FILE_NOT_EXIST.getCode()) || (i == Const.UploadRetCode.IO_ERROR_RETCODE.getCode()) || (i == 30700) || (i == 31500))
          {
            boolean bool = Environment.getExternalStorageState().equals("mounted");
            l1 = FileUtils.getSdCardAvailableSize();
            paramString = UploadGlobalConfig.getConfig().getDeviceInfo();
            ((StringBuilder)localObject).append(" || ").append(" sdExist=").append(bool).append(" sdCardAvailableSize=").append(l1).append(" M deviceInfo=").append(paramString);
          }
          ((StringBuilder)localObject).append(" || ").append("controlPackTimeCost=").append(this.mControlPkgEndTime - this.mControlPkgStartTime);
          this.mReportObj.errMsg = ((StringBuilder)localObject).toString();
        }
      }
      else
      {
        this.mReportObj.flowId = this.flowId;
        this.mReportObj.filePath = this.mFilePath;
        if (this.mStartTime > this.mEndTime) {
          this.mEndTime = this.mStartTime;
        }
        if (this.mStartTime != 0L)
        {
          this.mReportObj.startTime = this.mStartTime;
          this.mReportObj.endTime = this.mEndTime;
        }
        if (this.mControlPkgStartTime != 0L)
        {
          this.mReportObj.ctrlStart = this.mControlPkgStartTime;
          this.mReportObj.ctrlEnd = this.mControlPkgEndTime;
        }
        if (this.mDataPkgStartTime != 0L)
        {
          this.mReportObj.dataStart = this.mDataPkgStartTime;
          this.mReportObj.dataEnd = this.mDataPkgEndTime;
        }
        localObject = this.mReportObj;
        if (this.mUploadRoute != null) {
          break label601;
        }
        paramString = "N/A";
        ((Report)localObject).serverIp = paramString;
        if (this.mUploadRoute != null) {
          break label612;
        }
        this.mReportObj.isIPV6 = false;
        paramString = this.mReportObj;
        if (this.mUploadRoute != null) {
          break label700;
        }
        paramInt = 0;
      }
      for (;;)
      {
        paramString.ipsrctype = paramInt;
        this.mReportObj.networkType = UploadConfiguration.getCurrentNetworkCategory();
        this.mReportObj.retry = this.mRetryCount;
        this.mReportObj.content_type = "slice_upload";
        this.mReportObj.concurrent = BaseUploadService.getFileSocketNumber();
        this.mReportObj.num = BaseUploadService.getBatchControlNumber();
        l1 = this.mReportObj.endTime;
        l2 = this.mReportObj.startTime;
        if (this.mReportObj.fileSize >= 0L) {
          break label729;
        }
        this.mReported = true;
        return;
        paramString = this.mClientIp;
        break;
        paramString = this.mUploadRoute.getIp();
        break label466;
        if (StringUtils.isIpv6String(this.mUploadRoute.getIp()))
        {
          this.mReportObj.isIPV6 = true;
          break label487;
        }
        if ((this.mSessionPool.getmRouteStrategy() == null) || (this.mSessionPool.getmRouteStrategy().getServerRouteTable() == null) || (!this.mUploadRoute.getIp().equals(this.mSessionPool.getmRouteStrategy().getServerRouteTable().getV6HostString()))) {
          break label487;
        }
        this.mReportObj.isIPV6 = true;
        break label487;
        if (this.mUploadRoute.getRouteCategory() == null) {
          paramInt = 0;
        } else {
          paramInt = this.mUploadRoute.getRouteCategory().getType();
        }
      }
    } while ((this.mReportObj.fileSize >= l1 - l2) || (this.mReportObj.networkType == 3));
    label700:
    label729:
    this.mReported = true;
  }
  
  public void resetTask()
  {
    this.mNeedReset = true;
    quitMultiThreadUpload();
  }
  
  public void setFilePath(String paramString)
  {
    this.mFilePath = paramString;
  }
  
  public void setInnerAppid(String paramString)
  {
    this.mAppid = paramString;
  }
  
  public void setSecondUpload(FileControlRsp paramFileControlRsp)
  {
    this.mSecondUpload = true;
    this.mSecondUploadRsp = paramFileControlRsp;
  }
  
  public void setSessionId(String paramString)
  {
    this.mSessionId = paramString;
  }
  
  public void setSliceSize(int paramInt)
  {
    this.mSliceSize = paramInt;
  }
  
  public void setTaskStateListener(TaskStateListener paramTaskStateListener)
  {
    this.mTaskStateListener = paramTaskStateListener;
  }
  
  protected boolean setTaskStatus(TaskState paramTaskState)
  {
    boolean bool = super.setTaskStatus(paramTaskState);
    onTaskInfoChanged();
    if (bool) {
      onUploadStateChange(paramTaskState);
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.upload.task.UploadTask
 * JD-Core Version:    0.7.0.1
 */