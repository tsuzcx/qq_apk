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
    Object localObject1 = getTaskState();
    Object localObject2 = TaskState.PAUSE;
    int j = 0;
    if (localObject1 != localObject2)
    {
      if (getTaskState() == TaskState.CANCEL) {
        return false;
      }
      this.mAtomFile = new AtomFile(this.mFilePath);
      this.mAtomFile.setSliceSize(this.mSliceSize).setSessionId(this.mSessionId).setOffset(this.mFileSendOffset).setStartTime(System.currentTimeMillis());
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("taskId:");
      ((StringBuilder)localObject1).append(this.mTaskId);
      ((StringBuilder)localObject1).append(", filePkg, begin to wait available session ----> ");
      UploadLog.d("UploadTask", ((StringBuilder)localObject1).toString());
      int k = getConnectionNum();
      localObject1 = new IUploadSession[k];
      int i = 0;
      while (i < k)
      {
        if (i == 0)
        {
          localObject2 = this.mSession;
          if (localObject2 != null)
          {
            localObject1[i] = localObject2;
            break label177;
          }
        }
        localObject1[i] = pollSessionWithRetry(2);
        label177:
        i += 1;
      }
      if (this.mFinish)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("taskId:");
        ((StringBuilder)localObject1).append(this.mTaskId);
        ((StringBuilder)localObject1).append(", filePkg, after poll task has been finished !");
        UploadLog.w("UploadTask", ((StringBuilder)localObject1).toString());
        return false;
      }
      this.mMultiSession = ((IUploadSession[])localObject1);
      this.mSavedSession = this.mMultiSession[0];
      if ((localObject1.length > 0) && (sessionsValidCheck((IUploadSession[])localObject1)))
      {
        long l = System.currentTimeMillis();
        this.mStartTime = l;
        this.mDataPkgStartTime = l;
        localObject2 = new StringBuffer();
        ((StringBuffer)localObject2).append("taskId:");
        ((StringBuffer)localObject2).append(this.mTaskId);
        ((StringBuffer)localObject2).append(", sendFilePkg, mDataLength:");
        ((StringBuffer)localObject2).append(this.mDataLength);
        ((StringBuffer)localObject2).append(", use sessions size:");
        ((StringBuffer)localObject2).append(localObject1.length);
        ((StringBuffer)localObject2).append(", sessions detail:");
        k = localObject1.length;
        i = 0;
        while (i < k)
        {
          Object localObject3 = localObject1[i];
          if (localObject3 != null)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(localObject3.getUploadRoute().toString());
            localStringBuilder.append(" ");
            ((StringBuffer)localObject2).append(localStringBuilder.toString());
          }
          i += 1;
        }
        UploadLog.d("[iplist] UploadTask", ((StringBuffer)localObject2).toString());
        UploadFlowTracker.trackFlow(this, "数据包开始发送");
        this.mMultiThreads.clear();
        k = localObject1.length;
        i = j;
        while (i < k)
        {
          localObject2 = localObject1[i];
          if (localObject2 != null)
          {
            localObject2 = new UploadTask.UploadThread(this, this.mAtomFile, (IUploadSession)localObject2);
            this.mMultiThreads.add(localObject2);
            ((UploadTask.UploadThread)localObject2).tFuture = UploadThreadManager.getInstance().getDataThreadPool().submit((Runnable)localObject2);
          }
          i += 1;
        }
        return true;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("taskId:");
      ((StringBuilder)localObject1).append(this.mTaskId);
      ((StringBuilder)localObject1).append(", filePkg, multi session == null! no session to upload");
      UploadLog.e("UploadTask", ((StringBuilder)localObject1).toString());
      UploadFlowTracker.trackFlow(this, "无可用session");
      onError(Const.UploadRetCode.NO_SESSION.getCode(), Const.UploadRetCode.NO_SESSION.getDesc());
    }
    return false;
  }
  
  private void onFileUploadResponse(FileUploadRsp paramFileUploadRsp, UploadResponse paramUploadResponse)
  {
    if ((paramFileUploadRsp != null) && (paramUploadResponse != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("recv FileUploadResponse taskId=");
      localStringBuilder.append(getTaskId());
      localStringBuilder.append(" reqId=");
      localStringBuilder.append(paramUploadResponse.getRequestSequence());
      localStringBuilder.append(" cmd=");
      localStringBuilder.append(paramUploadResponse.getCmd());
      localStringBuilder.append(" ret=");
      localStringBuilder.append(paramFileUploadRsp.result.ret);
      localStringBuilder.append(" flag=");
      localStringBuilder.append(paramFileUploadRsp.result.flag);
      localStringBuilder.append(" msg=");
      localStringBuilder.append(paramFileUploadRsp.result.msg);
      localStringBuilder.append(" sid=");
      localStringBuilder.append(paramUploadResponse.getSid());
      localStringBuilder.append(" retry=");
      localStringBuilder.append(this.mRetryCount);
      localStringBuilder.append(" offset=");
      localStringBuilder.append(paramFileUploadRsp.offset);
      localStringBuilder.append(" totalSize=");
      localStringBuilder.append(this.mDataLength);
      localStringBuilder.append(" sendOffset=");
      localStringBuilder.append(this.mFileSendOffset);
      localStringBuilder.append(" session=");
      localStringBuilder.append(paramFileUploadRsp.session);
      localStringBuilder.append(" mFlagError=");
      localStringBuilder.append(this.mFlagError);
      UploadLog.d("[transfer] UploadTask", localStringBuilder.toString());
      if (paramUploadResponse.getRequestSequence() >= this.mCurrControlReqId)
      {
        if (this.mFlagError) {
          return;
        }
        clearCompleteTimer();
        int j = paramFileUploadRsp.result.ret;
        int i = 0;
        if (j != 0)
        {
          this.mFlagError = true;
          if (this.mRetryCount < getMaxRetryTimes())
          {
            switch (paramFileUploadRsp.result.flag)
            {
            default: 
              onError(paramFileUploadRsp.result.ret, paramFileUploadRsp.result.msg);
              return;
            case 14: 
              this.mRetryCount += 1;
              resetWaitState();
              quitMultiThreadUpload();
              resetSessionPool(true);
              this.mSessionId = "";
              return;
            case 13: 
              this.mRetryCount += 1;
              this.mSessionId = "";
              quitMultiThreadUpload();
              postExecute(0, true);
              return;
            }
            this.mRetryCount += 1;
            quitMultiThreadUpload();
            postExecute(0, true);
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
          l1 = this.mDataLength;
          onUploadProgress(l1, l1);
          processFileUploadFinishRsp(paramFileUploadRsp.biz_rsp);
          l1 = this.mEndTime;
          long l2 = this.mStartTime;
          paramFileUploadRsp = new StringBuilder();
          paramFileUploadRsp.append((float)this.mDataLength * 1.0F * 1000.0F / (float)((l1 - l2) * 1024L));
          paramFileUploadRsp.append("KB/s");
          paramFileUploadRsp = paramFileUploadRsp.toString();
          paramUploadResponse = new StringBuilder();
          paramUploadResponse.append("[speed] taskId:");
          paramUploadResponse.append(getTaskId());
          paramUploadResponse.append(", control pkg cost: ");
          paramUploadResponse.append(this.mControlPkgEndTime - this.mControlPkgStartTime);
          UploadLog.d("UploadTask", paramUploadResponse.toString());
          paramUploadResponse = new StringBuilder();
          paramUploadResponse.append("[speed] taskId:");
          paramUploadResponse.append(getTaskId());
          paramUploadResponse.append(", data pkg cost: ");
          paramUploadResponse.append(this.mDataPkgEndTime - this.mDataPkgStartTime);
          UploadLog.d("UploadTask", paramUploadResponse.toString());
          paramUploadResponse = new StringBuilder();
          paramUploadResponse.append("[speed] taskId:");
          paramUploadResponse.append(getTaskId());
          paramUploadResponse.append(", finish -- speed: ");
          paramUploadResponse.append(paramFileUploadRsp);
          paramUploadResponse.append(" length: ");
          paramUploadResponse.append(this.mDataLength / 1024L);
          paramUploadResponse.append("K");
          UploadLog.d("UploadTask", paramUploadResponse.toString());
          this.mFileRecvOffset = this.mDataLength;
          return;
        }
        startCompleteTimer();
        if (this.mFileRecvOffset < paramFileUploadRsp.offset)
        {
          this.mFileRecvOffset = paramFileUploadRsp.offset;
          onUploadProgress(this.mDataLength, this.mFileRecvOffset);
          paramUploadResponse = new StringBuilder();
          paramUploadResponse.append("taskId:");
          paramUploadResponse.append(getTaskId());
          paramUploadResponse.append(", UploadProgress: [");
          paramUploadResponse.append(paramFileUploadRsp.offset);
          paramUploadResponse.append(",");
          paramUploadResponse.append(this.mDataLength);
          paramUploadResponse.append("]");
          UploadLog.d("UploadTask", paramUploadResponse.toString());
        }
      }
      return;
    }
    paramUploadResponse = new StringBuilder();
    paramUploadResponse.append("onFileUploadResponse ");
    paramUploadResponse.append(paramFileUploadRsp);
    if (paramUploadResponse.toString() == null) {
      paramFileUploadRsp = "rsp == null";
    } else {
      paramFileUploadRsp = "response == null";
    }
    UploadLog.e("UploadTask", paramFileUploadRsp);
    onError(Const.UploadRetCode.RESPONSE_IS_NULL.getCode(), Const.UploadRetCode.RESPONSE_IS_NULL.getDesc());
  }
  
  private void onTaskInfoChanged()
  {
    TaskStateListener localTaskStateListener = this.mTaskStateListener;
    if (localTaskStateListener != null) {
      localTaskStateListener.onTaskInfoChanged(this);
    }
  }
  
  private IUploadSession pollSessionWithRetry(int paramInt)
  {
    Object localObject = this.mSessionPool;
    if (localObject == null) {
      return null;
    }
    IUploadSession localIUploadSession = ((SessionPool)localObject).poll();
    localObject = localIUploadSession;
    if (localIUploadSession == null)
    {
      localObject = localIUploadSession;
      if (paramInt > 0)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("pollSessionWithRetry session == null ! retry poll session. retryTime:");
        ((StringBuilder)localObject).append(paramInt);
        UploadLog.e("UploadTask", ((StringBuilder)localObject).toString());
        do
        {
          localIUploadSession = this.mSessionPool.poll();
          paramInt -= 1;
          localObject = localIUploadSession;
          if (localIUploadSession != null) {
            break;
          }
          localObject = localIUploadSession;
          if (paramInt <= 0) {
            break;
          }
        } while (!this.mFinish);
        localObject = localIUploadSession;
      }
    }
    UploadFlowTracker.trackRoute(this, (IUploadSession)localObject);
    return localObject;
  }
  
  private void resetSessionPool(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("resetSessionPool taskId=");
    localStringBuilder.append(getTaskId());
    localStringBuilder.append(" delete mSessionId:");
    localStringBuilder.append(this.mSessionId);
    UploadLog.d("UploadTask", localStringBuilder.toString());
    CacheUtil.deleteSessionId(this, this.mSessionId);
    this.mSessionPool.reset(new UploadRoute(paramString, paramInt, IUploadRouteStrategy.RouteCategoryType.REDIRECT));
  }
  
  private void resetSessionPool(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("resetSessionPool taskId=");
    ((StringBuilder)localObject).append(getTaskId());
    ((StringBuilder)localObject).append(" delete:");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(" mSessionId:");
    ((StringBuilder)localObject).append(this.mSessionId);
    UploadLog.d("UploadTask", ((StringBuilder)localObject).toString());
    if (paramBoolean) {
      CacheUtil.deleteSessionId(this, this.mSessionId);
    }
    localObject = this.mSessionPool;
    if (localObject != null) {
      ((SessionPool)localObject).reset();
    }
  }
  
  private boolean sendControlPkg()
  {
    if ((getTaskState() != TaskState.PAUSE) && (getTaskState() != TaskState.CANCEL))
    {
      if (getTaskState() == TaskState.SUCCEED) {
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
      Object localObject1 = pollSessionWithRetry(2);
      if (this.mFinish)
      {
        UploadLog.w("UploadTask", "after poll task has been finished !");
        return false;
      }
      if (localObject1 == null)
      {
        UploadFlowTracker.trackFlow(this, "获取session失败");
        onError(Const.UploadRetCode.NO_SESSION.getCode(), Const.UploadRetCode.NO_SESSION.getDesc());
        return false;
      }
      this.mSession = ((IUploadSession)localObject1);
      this.mSavedSession = ((IUploadSession)localObject1);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[sendControlPkg] taskId=");
      ((StringBuilder)localObject2).append(getTaskId());
      ((StringBuilder)localObject2).append(", getIdleSession=");
      ((StringBuilder)localObject2).append(localObject1.hashCode());
      ((StringBuilder)localObject2).append(", sessionId=");
      ((StringBuilder)localObject2).append(this.mSessionId);
      UploadLog.d("UploadTask", ((StringBuilder)localObject2).toString());
      localObject2 = getControlRequest();
      this.mCurrControlReqId = ((UploadRequest)localObject2).getRequestId();
      this.mFlagError = false;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendControlPkg taskId=");
      localStringBuilder.append(getTaskId());
      localStringBuilder.append(" reqId=");
      localStringBuilder.append(this.mCurrControlReqId);
      localStringBuilder.append(" retry=");
      localStringBuilder.append(this.mRetryCount);
      localStringBuilder.append(" route=");
      localStringBuilder.append(((IUploadSession)localObject1).getUploadRoute());
      localStringBuilder.append(" mDataLength=");
      localStringBuilder.append(this.mDataLength);
      UploadLog.d("UploadTask", localStringBuilder.toString());
      long l = System.currentTimeMillis();
      this.mControlPkgStartTime = l;
      this.mStartTime = l;
      UploadFlowTracker.trackFlow(this, "开始发送控制包");
      boolean bool = ((IUploadSession)localObject1).send((IActionRequest)localObject2, this);
      if (bool) {
        setTaskStatus(TaskState.SENDING);
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("taskId=");
      ((StringBuilder)localObject1).append(getTaskId());
      ((StringBuilder)localObject1).append(", sendControlPkg result=");
      ((StringBuilder)localObject1).append(bool);
      UploadLog.d("UploadTask", ((StringBuilder)localObject1).toString());
      return true;
    }
    return false;
  }
  
  private boolean sessionsValidCheck(IUploadSession[] paramArrayOfIUploadSession)
  {
    if (paramArrayOfIUploadSession != null)
    {
      if (paramArrayOfIUploadSession.length == 0) {
        return false;
      }
      int i = 0;
      while (i < paramArrayOfIUploadSession.length)
      {
        if (paramArrayOfIUploadSession[i] != null) {
          return true;
        }
        i += 1;
      }
    }
    return false;
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("abort session:");
    ((StringBuilder)localObject).append(paramIUploadSession.hashCode());
    UploadLog.i("UploadTask", ((StringBuilder)localObject).toString());
    localObject = this.mSession;
    if ((localObject != null) && (localObject.equals(paramIUploadSession))) {
      this.mSession = null;
    }
    if (this.mMultiSession != null)
    {
      int i = 0;
      for (;;)
      {
        localObject = this.mMultiSession;
        if (i >= localObject.length) {
          break;
        }
        if ((localObject[i] != null) && (localObject[i].equals(paramIUploadSession))) {
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("task canceled by user, taskId:");
    localStringBuilder.append(getTaskId());
    UploadLog.w("[transfer]UploadTask", localStringBuilder.toString());
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cancelForError taskId:");
    localStringBuilder.append(getTaskId());
    localStringBuilder.append(" errorCode=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" retryCount:");
    localStringBuilder.append(this.mRetryCount);
    localStringBuilder.append(" mNetworkRetryCount:");
    localStringBuilder.append(this.mNetworkRetryCount);
    localStringBuilder.append(" errorMsg=");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" mFinish=");
    localStringBuilder.append(this.mFinish);
    UploadLog.w("[transfer] UploadTask", localStringBuilder.toString());
    if (paramInt != 0)
    {
      if (this.mFinish) {
        return;
      }
      super.cancel();
      this.mFinish = true;
      this.mSliceSize = 0;
      onUploadError(paramInt, paramString);
      setTaskStatus(TaskState.FAILED);
      onTaskFinished(paramInt, paramString);
    }
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
    long l1 = this.mFileSendOffset;
    long l2 = this.mDataLength;
    if ((l1 < l2) && (l2 > 0L))
    {
      if (getTaskState() == TaskState.SUCCEED) {
        return 100.0F;
      }
      return (float)this.mFileSendOffset * 100.0F / (float)this.mDataLength;
    }
    return 100.0F;
  }
  
  public boolean isDataSourceValid()
  {
    UploadDataSource localUploadDataSource = this.mDataSource;
    if (localUploadDataSource != null) {
      return localUploadDataSource.isValid();
    }
    return false;
  }
  
  public void onError(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("taskId:");
    localStringBuilder.append(getTaskId());
    localStringBuilder.append(" onError errCode:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" desc:");
    localStringBuilder.append(paramString);
    UploadLog.e("UploadTask", localStringBuilder.toString());
    cancelForError(paramInt, paramString);
  }
  
  protected void onFileControlResponse(JceStruct paramJceStruct, UploadResponse paramUploadResponse)
  {
    if (paramJceStruct == null)
    {
      paramJceStruct = new StringBuilder();
      paramJceStruct.append("onFileControlResponse rsp == null ");
      paramJceStruct.append(hashCode());
      UploadLog.d("UploadTask", paramJceStruct.toString());
      onError(Const.UploadRetCode.RESPONSE_IS_NULL.getCode(), Const.UploadRetCode.RESPONSE_IS_NULL.getDesc());
      return;
    }
    if ((paramJceStruct instanceof FileBatchControlRsp))
    {
      onFileControlResponse((FileControlRsp)((FileBatchControlRsp)paramJceStruct).control_rsp.get("1"), paramUploadResponse);
      return;
    }
    paramJceStruct = (FileControlRsp)paramJceStruct;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("recv FileControlResponse taskId=");
    localStringBuilder.append(getTaskId());
    localStringBuilder.append(" reqId=");
    localStringBuilder.append(paramUploadResponse.getRequestSequence());
    localStringBuilder.append(" cmd=");
    localStringBuilder.append(paramUploadResponse.getCmd());
    localStringBuilder.append(" ret=");
    localStringBuilder.append(paramJceStruct.result.ret);
    localStringBuilder.append(" flag=");
    localStringBuilder.append(paramJceStruct.result.flag);
    localStringBuilder.append(" msg=");
    localStringBuilder.append(paramJceStruct.result.msg);
    localStringBuilder.append(" retry=");
    localStringBuilder.append(this.mRetryCount);
    localStringBuilder.append(" offset=");
    localStringBuilder.append(paramJceStruct.offset);
    localStringBuilder.append(" slice_size=");
    localStringBuilder.append(paramJceStruct.slice_size);
    localStringBuilder.append(" session=");
    localStringBuilder.append(paramJceStruct.session);
    UploadLog.d("[transfer] UploadTask", localStringBuilder.toString());
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
        case 14: 
          this.mRetryCount += 1;
          resetWaitState();
          resetSessionPool(true);
          this.mSessionId = "";
          return;
        case 13: 
          this.mRetryCount += 1;
          this.mSessionId = "";
          postExecute(0, true);
          return;
        }
        this.mRetryCount += 1;
        postExecute(0, true);
        return;
      }
      onError(paramJceStruct.result.ret, paramJceStruct.result.msg);
      return;
    }
    if (paramJceStruct.result.flag != 0)
    {
      if ((paramJceStruct.result.flag == 1) || (paramJceStruct.result.flag == 2))
      {
        paramUploadResponse = new StringBuilder();
        paramUploadResponse.append("taskId=");
        paramUploadResponse.append(getTaskId());
        paramUploadResponse.append("rsp.result.flag=");
        paramUploadResponse.append(paramJceStruct.result.flag);
        paramUploadResponse.append(" upload success !");
        UploadLog.d("UploadTask", paramUploadResponse.toString());
        l1 = System.currentTimeMillis();
        this.mEndTime = l1;
        this.mDataPkgEndTime = l1;
        l1 = this.mDataLength;
        onUploadProgress(l1, l1);
        this.mIsFastUpload = true;
        processFileUploadFinishRsp(paramJceStruct.biz_rsp);
      }
      return;
    }
    if (!TextUtils.isEmpty(paramJceStruct.redirect_ip))
    {
      this.mSessionId = "";
      paramJceStruct = paramJceStruct.redirect_ip;
      paramUploadResponse = this.mUploadRoute;
      int i;
      if (paramUploadResponse != null) {
        i = paramUploadResponse.getPort();
      } else {
        i = 443;
      }
      resetSessionPool(paramJceStruct, i);
      return;
    }
    paramUploadResponse = new StringBuilder();
    paramUploadResponse.append("slicesize=");
    paramUploadResponse.append(paramJceStruct.slice_size);
    UploadLog.d("UploadTask", paramUploadResponse.toString());
    this.mSliceSize = ((int)paramJceStruct.slice_size);
    this.mSessionId = paramJceStruct.session;
    paramUploadResponse = new StringBuilder();
    paramUploadResponse.append("cacheSessionId :");
    paramUploadResponse.append(this.mSessionId);
    UploadLog.d("UploadTask", paramUploadResponse.toString());
    CacheUtil.cacheSessionId(this, this.mSessionId);
    long l2 = paramJceStruct.offset;
    long l1 = 0L;
    if (l2 >= 0L) {
      l1 = paramJceStruct.offset;
    }
    this.mFileSendOffset = l1;
    this.mFileRecvOffset = l1;
    this.mDataPkgStartTime = System.currentTimeMillis();
    postExecute(1, false);
  }
  
  public void onRequestError(IActionRequest paramIActionRequest, Const.UploadRetCode paramUploadRetCode, IUploadSession paramIUploadSession)
  {
    boolean bool = paramIActionRequest.getTag() instanceof UploadTask.UploadThread;
    String str;
    if (bool) {
      str = ((UploadTask.UploadThread)paramIActionRequest.getTag()).tTAG;
    } else {
      str = "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("onRequestError taskId=");
    localStringBuilder.append(getTaskId());
    localStringBuilder.append(" reqId=");
    localStringBuilder.append(paramIActionRequest.getRequestId());
    localStringBuilder.append(" CMD=");
    localStringBuilder.append(paramIActionRequest.getCmdId());
    localStringBuilder.append(" mNetworkRetryCount=");
    localStringBuilder.append(this.mNetworkRetryCount);
    localStringBuilder.append(" session=");
    localStringBuilder.append(paramIUploadSession.hashCode());
    localStringBuilder.append(" code: ");
    localStringBuilder.append(paramUploadRetCode);
    localStringBuilder.append(" mCurrControlReqId=");
    localStringBuilder.append(this.mCurrControlReqId);
    localStringBuilder.append(" mFlagError:");
    localStringBuilder.append(this.mFlagError);
    localStringBuilder.append(" mFinish:");
    localStringBuilder.append(this.mFinish);
    UploadLog.d("UploadTask", localStringBuilder.toString());
    abortSession(paramIUploadSession);
    if ((paramIActionRequest.getRequestId() >= this.mCurrControlReqId) && (!this.mFlagError) && (!this.mFinish))
    {
      this.mFlagError = true;
      if (bool) {
        quitMultiThreadUpload();
      }
      if ((paramUploadRetCode != Const.UploadRetCode.OOM) && (paramUploadRetCode != Const.UploadRetCode.SESSION_REQUEST_ENCODE_ERROR) && (paramUploadRetCode != Const.UploadRetCode.SESSION_CONN_SEND_FAILED))
      {
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
        return;
      }
      cancelForError(paramUploadRetCode.getCode(), paramUploadRetCode.getDesc());
      return;
    }
    UploadLog.d("UploadTask", "onRequestError return");
  }
  
  public void onRequestSended(IActionRequest paramIActionRequest)
  {
    if (getTaskState() == TaskState.CANCEL) {
      return;
    }
    boolean bool = paramIActionRequest.getTag() instanceof UploadTask.UploadThread;
    Object localObject;
    if (bool) {
      localObject = ((UploadTask.UploadThread)paramIActionRequest.getTag()).tTAG;
    } else {
      localObject = "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(" onRequestSended taskId=");
    localStringBuilder.append(getTaskId());
    localStringBuilder.append(", reqId=");
    localStringBuilder.append(paramIActionRequest.getRequestId());
    UploadLog.d("[transfer] UploadTask", localStringBuilder.toString());
    if (bool)
    {
      ((UploadTask.UploadThread)paramIActionRequest.getTag()).notifySendend();
      return;
    }
    if (paramIActionRequest.getRequestId() < this.mCurrControlReqId) {
      return;
    }
    if (UploadTask.2.$SwitchMap$com$tencent$upload$task$TaskState[getTaskState().ordinal()] != 1) {
      return;
    }
    if ((paramIActionRequest instanceof FileUploadRequest))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("send over reqId=");
      ((StringBuilder)localObject).append(paramIActionRequest.getRequestId());
      ((StringBuilder)localObject).append(" offset=");
      ((StringBuilder)localObject).append(this.mLastSendOffset);
      ((StringBuilder)localObject).append(" slice=");
      ((StringBuilder)localObject).append(this.mLastSliceSize);
      ((StringBuilder)localObject).append(" total=");
      ((StringBuilder)localObject).append(this.mDataLength);
      UploadLog.d("[transfer] UploadTask", ((StringBuilder)localObject).toString());
      this.mDataPkgEndTime = System.currentTimeMillis();
      postExecute(1, false);
      return;
    }
    if ((paramIActionRequest instanceof FileControlRequest))
    {
      paramIActionRequest = (FileControlRequest)paramIActionRequest;
      if (paramIActionRequest.getFileDataLength() > 0L)
      {
        onUploadProgress(this.mDataLength, paramIActionRequest.getFileDataLength());
        this.mFileSendOffset = paramIActionRequest.getFileDataLength();
      }
    }
  }
  
  public void onRequestTimeout(IActionRequest paramIActionRequest, IUploadSession paramIUploadSession)
  {
    boolean bool = paramIActionRequest.getTag() instanceof UploadTask.UploadThread;
    String str;
    if (bool) {
      str = ((UploadTask.UploadThread)paramIActionRequest.getTag()).tTAG;
    } else {
      str = "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("onRequestTimeout taskId=");
    localStringBuilder.append(getTaskId());
    localStringBuilder.append(" reqId=");
    localStringBuilder.append(paramIActionRequest.getRequestId());
    localStringBuilder.append(" CMD=");
    localStringBuilder.append(paramIActionRequest.getCmdId());
    localStringBuilder.append(" mNetworkRetryCount=");
    localStringBuilder.append(this.mNetworkRetryCount);
    localStringBuilder.append(" session=");
    localStringBuilder.append(paramIUploadSession.hashCode());
    localStringBuilder.append(" mCurrControlReqId=");
    localStringBuilder.append(this.mCurrControlReqId);
    localStringBuilder.append(" mFlagError:");
    localStringBuilder.append(this.mFlagError);
    UploadLog.d("UploadTask", localStringBuilder.toString());
    UploadFlowTracker.trackFlow(this, "回包超时");
    abortSession(paramIUploadSession);
    if ((paramIActionRequest.getRequestId() >= this.mCurrControlReqId) && (!this.mFlagError))
    {
      if (this.mFinish) {
        return;
      }
      this.mFlagError = true;
      if (bool) {
        quitMultiThreadUpload();
      }
      if (this.mNetworkRetryCount < getMaxNetworkRetryTimes())
      {
        this.mNetworkRetryCount += 1;
        paramIActionRequest = new StringBuilder();
        paramIActionRequest.append("重试发控制包，重试次数");
        paramIActionRequest.append(this.mNetworkRetryCount);
        UploadFlowTracker.trackFlow(this, paramIActionRequest.toString());
        quitMultiThreadUpload();
        postExecute(0, true);
        return;
      }
      cancelForError(Const.UploadRetCode.REQUEST_TIMEOUT.getCode(), Const.UploadRetCode.REQUEST_TIMEOUT.getDesc());
    }
  }
  
  public void onResponse(IActionRequest paramIActionRequest, UploadResponse paramUploadResponse)
  {
    String str;
    if ((paramIActionRequest.getTag() instanceof UploadTask.UploadThread)) {
      str = ((UploadTask.UploadThread)paramIActionRequest.getTag()).tTAG;
    } else {
      str = "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("recv --- taskId=");
    localStringBuilder.append(this.mTaskId);
    localStringBuilder.append(", reqId=");
    localStringBuilder.append(paramIActionRequest.getRequestId());
    UploadLog.d("[transfer] UploadTask", localStringBuilder.toString());
    if ((getTaskState() != TaskState.SUCCEED) && (getTaskState() != TaskState.FAILED))
    {
      if (getTaskState() == TaskState.CANCEL) {
        return;
      }
      if (paramUploadResponse.getRequestSequence() < this.mCurrControlReqId) {
        return;
      }
      int i = paramUploadResponse.getCmd();
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            return;
          }
          releaseSession();
          processFileBatchCommitRsp((FileBatchCommitRsp)JceEncoder.decode(FileBatchCommitRsp.class, paramUploadResponse.getReponseData()));
          return;
        }
        onFileUploadResponse((FileUploadRsp)JceEncoder.decode(FileUploadRsp.class, paramUploadResponse.getReponseData()), paramUploadResponse);
        return;
      }
      if (this.mAppid.equalsIgnoreCase("mobilelog")) {
        paramIActionRequest = JceEncoder.decode(FileControlRsp.class, paramUploadResponse.getReponseData());
      } else {
        paramIActionRequest = JceEncoder.decode(FileBatchControlRsp.class, paramUploadResponse.getReponseData());
      }
      onFileControlResponse(paramIActionRequest, paramUploadResponse);
    }
  }
  
  public boolean onRun()
  {
    this.mFinish = false;
    this.mStep = 0;
    if (this.mSecondUpload) {
      this.mStep = 2;
    } else if ((!TextUtils.isEmpty(this.mSessionId)) && (this.mSliceSize != 0) && (!this.mNeedReset)) {
      this.mStep = 1;
    } else if (this.mNeedReset) {
      this.mNeedReset = false;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onRun --- step: ");
    ((StringBuilder)localObject).append(this.mStep);
    ((StringBuilder)localObject).append(" taskId:");
    ((StringBuilder)localObject).append(getTaskId());
    UploadLog.d("UploadTask", ((StringBuilder)localObject).toString());
    int i = this.mStep;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return true;
        }
        localObject = new UploadResponse();
        onFileControlResponse(this.mSecondUploadRsp, (UploadResponse)localObject);
        return true;
      }
      UploadFlowTracker.trackFlow(this, "准备发送数据包");
      return multiThreadSendFilePkg();
    }
    UploadFlowTracker.trackFlow(this, "准备发送控制包");
    return sendControlPkg();
  }
  
  protected void onTaskFinished(int paramInt, String paramString)
  {
    releaseSession();
    Object localObject = this.mSavedSession;
    if (localObject != null)
    {
      this.mUploadRoute = ((IUploadSession)localObject).getUploadRoute();
      this.mConnectedIp = this.mSavedSession.getConnectedIp();
      localObject = this.mUploadRoute;
      if (localObject != null) {
        this.mConnectedPort = ((UploadRoute)localObject).getPort();
      }
    }
    int i;
    if (paramInt == Const.UploadRetCode.SUCCEED.getCode())
    {
      localObject = this.mSessionPool;
      i = paramInt;
      if (localObject != null)
      {
        UploadRoute localUploadRoute = this.mUploadRoute;
        i = paramInt;
        if (localUploadRoute != null)
        {
          ((SessionPool)localObject).saveRoute(localUploadRoute);
          i = paramInt;
        }
      }
    }
    else
    {
      i = paramInt;
      if (paramInt == Const.UploadRetCode.FAST_SUCCEED.getCode()) {
        i = Const.UploadRetCode.SUCCEED.getCode();
      }
    }
    if ((getTaskState() != TaskState.CANCEL) && (getTaskState() != TaskState.PAUSE)) {
      report(i, paramString);
    }
    localObject = this.mTaskStateListener;
    if (localObject != null) {
      ((TaskStateListener)localObject).onTaskFinished(this, i, paramString);
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
    if (!this.mFlagError)
    {
      if (this.mFinish) {
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
  }
  
  public boolean pause()
  {
    if ((getTaskState() != TaskState.SUCCEED) && (getTaskState() != TaskState.FAILED) && (getTaskState() != TaskState.PAUSE))
    {
      if (getTaskState() == TaskState.CANCEL) {
        return false;
      }
      if ((getTaskState() == TaskState.SENDING) && (this.mFileSendOffset >= this.mDataLength)) {
        return false;
      }
      super.pause();
      setTaskStatus(TaskState.PAUSE);
      onTaskFinished(Const.UploadRetCode.PAUSED.getCode(), Const.UploadRetCode.PAUSED.getDesc());
      return true;
    }
    return false;
  }
  
  protected void postExecute(int paramInt, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("postExecute taskId:");
    localStringBuilder.append(getTaskId());
    localStringBuilder.append(", postExecute newStep:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" needReset:");
    localStringBuilder.append(paramBoolean);
    UploadLog.i("UploadTask", localStringBuilder.toString());
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
      this.mMultiThreads.clear();
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  protected void releaseSession()
  {
    Object localObject = this.mSessionPool;
    if (localObject == null) {
      return;
    }
    IUploadSession localIUploadSession = this.mSession;
    if (localIUploadSession != null)
    {
      ((SessionPool)localObject).offer(localIUploadSession);
      this.mSession = null;
    }
    localObject = this.mMultiSession;
    if (localObject != null)
    {
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        localIUploadSession = localObject[i];
        if (localIUploadSession != null) {
          this.mSessionPool.offer(localIUploadSession);
        }
        i += 1;
      }
      this.mMultiSession = null;
    }
  }
  
  protected void report(int paramInt, String paramString)
  {
    if (this.mReported) {
      return;
    }
    if ((paramInt != Const.UploadRetCode.NO_SESSION.getCode()) && (paramInt != Const.UploadRetCode.ALL_IP_FAILED.getCode()))
    {
      int i = paramInt;
      if (paramInt == Const.UploadRetCode.FILE_LENGTH_INVALID.getCode()) {
        i = Const.UploadRetCode.FILE_NOT_EXIST.getCode();
      }
      Object localObject = this.mReportObj;
      ((Report)localObject).retCode = i;
      ((Report)localObject).errMsg = paramString;
      if (i != Const.UploadRetCode.SUCCEED.getCode())
      {
        StringBuilder localStringBuilder = new StringBuilder(50);
        localStringBuilder.append(paramString);
        localStringBuilder.append(" || ");
        localStringBuilder.append(" clientIp=");
        localObject = this.mClientIp;
        paramString = (String)localObject;
        if (localObject == null) {
          paramString = "";
        }
        localStringBuilder.append(paramString);
        localStringBuilder.append(" mState=");
        localStringBuilder.append(getTaskState().getDesc());
        localStringBuilder.append(" mProgressTotalLen=");
        localStringBuilder.append(this.mFileSendOffset);
        localStringBuilder.append(" mProgressRecvDataLen=");
        localStringBuilder.append(this.mFileRecvOffset);
        localStringBuilder.append(" || ");
        if ((i == Const.UploadRetCode.FILE_NOT_EXIST.getCode()) || (i == Const.UploadRetCode.IO_ERROR_RETCODE.getCode()) || (i == 30700) || (i == 31500))
        {
          boolean bool = Environment.getExternalStorageState().equals("mounted");
          l1 = FileUtils.getSdCardAvailableSize();
          paramString = UploadGlobalConfig.getConfig().getDeviceInfo();
          localStringBuilder.append(" || ");
          localStringBuilder.append(" sdExist=");
          localStringBuilder.append(bool);
          localStringBuilder.append(" sdCardAvailableSize=");
          localStringBuilder.append(l1);
          localStringBuilder.append(" M deviceInfo=");
          localStringBuilder.append(paramString);
        }
        localStringBuilder.append(" || ");
        localStringBuilder.append("controlPackTimeCost=");
        localStringBuilder.append(this.mControlPkgEndTime - this.mControlPkgStartTime);
        this.mReportObj.errMsg = localStringBuilder.toString();
      }
      paramString = this.mReportObj;
      paramString.flowId = this.flowId;
      paramString.filePath = this.mFilePath;
      long l1 = this.mStartTime;
      if (l1 > this.mEndTime) {
        this.mEndTime = l1;
      }
      l1 = this.mStartTime;
      if (l1 != 0L)
      {
        paramString = this.mReportObj;
        paramString.startTime = l1;
        paramString.endTime = this.mEndTime;
      }
      l1 = this.mControlPkgStartTime;
      if (l1 != 0L)
      {
        paramString = this.mReportObj;
        paramString.ctrlStart = l1;
        paramString.ctrlEnd = this.mControlPkgEndTime;
      }
      l1 = this.mDataPkgStartTime;
      if (l1 != 0L)
      {
        paramString = this.mReportObj;
        paramString.dataStart = l1;
        paramString.dataEnd = this.mDataPkgEndTime;
      }
      localObject = this.mReportObj;
      paramString = this.mUploadRoute;
      if (paramString == null) {
        paramString = "N/A";
      } else {
        paramString = paramString.getIp();
      }
      ((Report)localObject).serverIp = paramString;
      paramString = this.mUploadRoute;
      paramInt = 0;
      if (paramString == null) {
        this.mReportObj.isIPV6 = false;
      } else if (StringUtils.isIpv6String(paramString.getIp())) {
        this.mReportObj.isIPV6 = true;
      } else if ((this.mSessionPool.getmRouteStrategy() != null) && (this.mSessionPool.getmRouteStrategy().getServerRouteTable() != null) && (this.mUploadRoute.getIp().equals(this.mSessionPool.getmRouteStrategy().getServerRouteTable().getV6HostString()))) {
        this.mReportObj.isIPV6 = true;
      }
      paramString = this.mReportObj;
      localObject = this.mUploadRoute;
      if ((localObject != null) && (((UploadRoute)localObject).getRouteCategory() != null)) {
        paramInt = this.mUploadRoute.getRouteCategory().getType();
      }
      paramString.ipsrctype = paramInt;
      this.mReportObj.networkType = UploadConfiguration.getCurrentNetworkCategory();
      paramString = this.mReportObj;
      paramString.retry = this.mRetryCount;
      paramString.content_type = "slice_upload";
      paramString.concurrent = BaseUploadService.getFileSocketNumber();
      this.mReportObj.num = BaseUploadService.getBatchControlNumber();
      l1 = this.mReportObj.endTime;
      long l2 = this.mReportObj.startTime;
      if (this.mReportObj.fileSize < 0L)
      {
        this.mReported = true;
        return;
      }
      if ((this.mReportObj.fileSize < l1 - l2) && (this.mReportObj.networkType != 3)) {
        this.mReported = true;
      }
      return;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.upload.task.UploadTask
 * JD-Core Version:    0.7.0.1
 */