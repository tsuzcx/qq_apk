package com.tencent.upload.d;

import SLICE_UPLOAD.FileBatchCommitRsp;
import SLICE_UPLOAD.FileBatchControlRsp;
import SLICE_UPLOAD.FileControlRsp;
import SLICE_UPLOAD.FileUploadRsp;
import SLICE_UPLOAD.stResult;
import android.os.Environment;
import android.os.Handler;
import android.os.Parcel;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.tencent.upload.common.Const.UploadRetCode;
import com.tencent.upload.common.FileUtils;
import com.tencent.upload.common.UploadConfiguration;
import com.tencent.upload.d.a.a.b;
import com.tencent.upload.network.route.UploadRoute;
import com.tencent.upload.network.route.c.a;
import com.tencent.upload.report.Report;
import com.tencent.upload.uinterface.IUploadConfig;
import com.tencent.upload.uinterface.V2Config;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Future;

public abstract class e
  extends b
  implements com.tencent.upload.network.a.a.a
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
  public int flowId;
  public int iAppid;
  protected String mAppid;
  private a mAtomFile;
  protected String mClientIp;
  protected String mConnectedIp = "";
  protected int mConnectedPort = 0;
  long mControlPkgEndTime;
  long mControlPkgStartTime;
  private int mCurrControlReqId = 0;
  protected long mDataLength;
  long mDataPkgEndTime;
  long mDataPkgStartTime;
  protected com.tencent.upload.d.a.a mDataSource;
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
  protected com.tencent.upload.network.a.a[] mMultiSession;
  private ArrayList<a> mMultiThreads = new ArrayList(5);
  protected boolean mNeedReset;
  protected int mNetworkRetryCount = 0;
  protected Report mReportObj = new Report();
  protected volatile boolean mReported = false;
  protected int mRetryCount = 0;
  protected com.tencent.upload.network.a.a mSavedSession;
  protected boolean mSecondUpload;
  protected FileControlRsp mSecondUploadRsp;
  protected String mServerIp;
  protected com.tencent.upload.network.a.a mSession;
  protected String mSessionId;
  protected com.tencent.upload.network.a.c mSessionPool;
  protected String mSha1;
  protected int mSliceSize;
  long mStartTime;
  protected volatile int mStep = 0;
  protected d mTaskStateListener;
  protected UploadRoute mUploadRoute;
  
  public e(Parcel paramParcel)
  {
    this.mTaskId = paramParcel.readInt();
    this.mDataSource = ((com.tencent.upload.d.a.a)paramParcel.readParcelable(com.tencent.upload.d.a.a.class.getClassLoader()));
    this.mSessionId = paramParcel.readString();
    c localc = c.a(paramParcel.readInt());
    if (localc != c.b)
    {
      paramParcel = localc;
      if (localc != c.c) {}
    }
    else
    {
      paramParcel = c.a;
    }
    setTaskStatus(paramParcel);
  }
  
  public e(String paramString)
  {
    this.mFilePath = paramString;
    this.mDataSource = new a.b(paramString);
  }
  
  public e(byte[] paramArrayOfByte)
  {
    this.mDataSource = new com.tencent.upload.d.a.a.a(paramArrayOfByte);
  }
  
  private int getConnectionNum()
  {
    return com.tencent.upload.common.a.f().mFileSocketNumber;
  }
  
  private boolean multiThreadSendFilePkg()
  {
    int j = 0;
    if ((getTaskState() == c.d) || (getTaskState() == c.e)) {
      return false;
    }
    this.mAtomFile = new a(this.mFilePath);
    this.mAtomFile.a(this.mSliceSize).a(this.mSessionId).b(this.mFileSendOffset).c(System.currentTimeMillis());
    com.tencent.upload.common.b.b("UploadTask", "taskId:" + this.mTaskId + ", filePkg, begin to wait available session ----> ");
    int k = getConnectionNum();
    com.tencent.upload.network.a.a[] arrayOfa = new com.tencent.upload.network.a.a[k];
    int i = 0;
    if (i < k)
    {
      if ((i == 0) && (this.mSession != null)) {
        arrayOfa[i] = this.mSession;
      }
      for (;;)
      {
        i += 1;
        break;
        arrayOfa[i] = pollSessionWithRetry(2);
      }
    }
    if (this.mFinish)
    {
      com.tencent.upload.common.b.d("UploadTask", "taskId:" + this.mTaskId + ", filePkg, after poll task has been finished !");
      return false;
    }
    this.mMultiSession = arrayOfa;
    this.mSavedSession = this.mMultiSession[0];
    if ((arrayOfa == null) || (arrayOfa.length <= 0) || (!sessionsValidCheck(arrayOfa)))
    {
      com.tencent.upload.common.b.e("UploadTask", "taskId:" + this.mTaskId + ", filePkg, multi session == null! no session to upload");
      com.tencent.upload.e.c.a.a(this, "无可用session");
      onError(Const.UploadRetCode.NO_SESSION.getCode(), Const.UploadRetCode.NO_SESSION.getDesc());
      return false;
    }
    long l = System.currentTimeMillis();
    this.mStartTime = l;
    this.mDataPkgStartTime = l;
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("taskId:").append(this.mTaskId).append(", sendFilePkg, mDataLength:").append(this.mDataLength).append(", use sessions size:").append(arrayOfa.length).append(", sessions detail:");
    k = arrayOfa.length;
    i = 0;
    while (i < k)
    {
      com.tencent.upload.network.a.a locala = arrayOfa[i];
      if (locala != null) {
        ((StringBuffer)localObject).append(locala.b().toString() + " ");
      }
      i += 1;
    }
    com.tencent.upload.common.b.b("[iplist] UploadTask", ((StringBuffer)localObject).toString());
    com.tencent.upload.e.c.a.a(this, "数据包开始发送");
    this.mMultiThreads.clear();
    k = arrayOfa.length;
    i = j;
    while (i < k)
    {
      localObject = arrayOfa[i];
      if (localObject != null)
      {
        localObject = new a(this.mAtomFile, (com.tencent.upload.network.a.a)localObject);
        this.mMultiThreads.add(localObject);
        ((a)localObject).f = com.tencent.upload.e.a.e.a().c().a((Runnable)localObject);
      }
      i += 1;
    }
    return true;
  }
  
  private void onFileUploadResponse(FileUploadRsp paramFileUploadRsp, com.tencent.upload.c.c paramc)
  {
    int i = 0;
    if ((paramFileUploadRsp == null) || (paramc == null)) {
      if ("onFileUploadResponse " + paramFileUploadRsp == null)
      {
        paramFileUploadRsp = "rsp == null";
        com.tencent.upload.common.b.e("UploadTask", paramFileUploadRsp);
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
        com.tencent.upload.common.b.b("[transfer] UploadTask", "recv FileUploadResponse taskId=" + getTaskId() + " reqId=" + paramc.c() + " cmd=" + paramc.b() + " ret=" + paramFileUploadRsp.result.ret + " flag=" + paramFileUploadRsp.result.flag + " msg=" + paramFileUploadRsp.result.msg + " sid=" + paramc.d() + " retry=" + this.mRetryCount + " offset=" + paramFileUploadRsp.offset + " totalSize=" + this.mDataLength + " sendOffset=" + this.mFileSendOffset + " session=" + paramFileUploadRsp.session + " mFlagError=" + this.mFlagError);
      } while ((paramc.c() < this.mCurrControlReqId) || (this.mFlagError));
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
            postExecute(0, true);
            return;
          case 13: 
            this.mRetryCount += 1;
            this.mSessionId = "";
            postExecute(0, true);
            return;
          }
          this.mRetryCount += 1;
          this.mSessionId = "";
          resetSessionPool(true);
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
        com.tencent.upload.common.b.b("UploadTask", "[speed] taskId:" + getTaskId() + ", control pkg cost: " + (this.mControlPkgEndTime - this.mControlPkgStartTime));
        com.tencent.upload.common.b.b("UploadTask", "[speed] taskId:" + getTaskId() + ", data pkg cost: " + (this.mDataPkgEndTime - this.mDataPkgStartTime));
        com.tencent.upload.common.b.b("UploadTask", "[speed] taskId:" + getTaskId() + ", finish -- speed: " + paramFileUploadRsp + " length: " + this.mDataLength / 1024L + "K");
        this.mFileRecvOffset = this.mDataLength;
        return;
      }
    } while (this.mFileRecvOffset >= paramFileUploadRsp.offset);
    this.mFileRecvOffset = paramFileUploadRsp.offset;
    onUploadProgress(this.mDataLength, this.mFileRecvOffset);
    com.tencent.upload.common.b.b("UploadTask", "taskId:" + getTaskId() + ", UploadProgress: [" + paramFileUploadRsp.offset + "," + this.mDataLength + "]");
  }
  
  private void onTaskInfoChanged()
  {
    if (this.mTaskStateListener != null) {
      this.mTaskStateListener.a(this);
    }
  }
  
  private com.tencent.upload.network.a.a pollSessionWithRetry(int paramInt)
  {
    if (this.mSessionPool == null) {
      return null;
    }
    com.tencent.upload.network.a.a locala2 = this.mSessionPool.c();
    com.tencent.upload.network.a.a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = locala2;
      if (paramInt > 0)
      {
        com.tencent.upload.common.b.e("UploadTask", "pollSessionWithRetry session == null ! retry poll session. retryTime:" + paramInt);
        do
        {
          locala2 = this.mSessionPool.c();
          paramInt -= 1;
          locala1 = locala2;
          if (locala2 != null) {
            break;
          }
          locala1 = locala2;
          if (paramInt <= 0) {
            break;
          }
        } while (!this.mFinish);
        locala1 = locala2;
      }
    }
    com.tencent.upload.e.c.a.a(this, locala1);
    return locala1;
  }
  
  private void resetSessionPool(String paramString, int paramInt)
  {
    com.tencent.upload.a.a.b(this, this.mSessionId);
    this.mSessionPool.a(new UploadRoute(paramString, paramInt, c.a.b));
  }
  
  private void resetSessionPool(boolean paramBoolean)
  {
    if (paramBoolean) {
      com.tencent.upload.a.a.b(this, this.mSessionId);
    }
    if (this.mSessionPool != null) {
      this.mSessionPool.h();
    }
  }
  
  private boolean sendControlPkg()
  {
    if ((getTaskState() == c.d) || (getTaskState() == c.e) || (getTaskState() == c.g)) {
      return false;
    }
    if (!this.mDataSource.b())
    {
      com.tencent.upload.e.c.a.a(this, "上传文件不存在");
      onError(Const.UploadRetCode.FILE_NOT_EXIST.getCode(), Const.UploadRetCode.FILE_NOT_EXIST.getDesc());
      return false;
    }
    if (this.mDataSource.c() <= 0L)
    {
      com.tencent.upload.e.c.a.a(this, "上传文件长度异常");
      onError(Const.UploadRetCode.FILE_LENGTH_INVALID.getCode(), Const.UploadRetCode.FILE_LENGTH_INVALID.getDesc());
      return false;
    }
    setState(c.b);
    com.tencent.upload.network.a.a locala = pollSessionWithRetry(2);
    if (this.mFinish)
    {
      com.tencent.upload.common.b.d("UploadTask", "after poll task has been finished !");
      return false;
    }
    if (locala == null)
    {
      com.tencent.upload.e.c.a.a(this, "获取session失败");
      onError(Const.UploadRetCode.NO_SESSION.getCode(), Const.UploadRetCode.NO_SESSION.getDesc());
      return false;
    }
    this.mSession = locala;
    this.mSavedSession = locala;
    com.tencent.upload.common.b.b("UploadTask", "[sendControlPkg] taskId=" + getTaskId() + ", getIdleSession=" + locala.hashCode() + ", sessionId=" + this.mSessionId);
    com.tencent.upload.c.b localb = getControlRequest();
    this.mCurrControlReqId = localb.c();
    this.mFlagError = false;
    com.tencent.upload.common.b.b("UploadTask", "sendControlPkg taskId=" + getTaskId() + " reqId=" + this.mCurrControlReqId + " retry=" + this.mRetryCount + " route=" + locala.b() + " mDataLength=" + this.mDataLength);
    long l = System.currentTimeMillis();
    this.mControlPkgStartTime = l;
    this.mStartTime = l;
    setTaskStatus(c.c);
    com.tencent.upload.e.c.a.a(this, "开始发送控制包");
    boolean bool = locala.a(localb, this);
    com.tencent.upload.common.b.b("UploadTask", "taskId=" + getTaskId() + ", sendControlPkg result=" + bool);
    return true;
  }
  
  private boolean sessionsValidCheck(com.tencent.upload.network.a.a[] paramArrayOfa)
  {
    if ((paramArrayOfa == null) || (paramArrayOfa.length == 0)) {}
    for (;;)
    {
      return false;
      int i = 0;
      while (i < paramArrayOfa.length)
      {
        if (paramArrayOfa[i] != null) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  protected void abortSession(com.tencent.upload.network.a.a parama)
  {
    com.tencent.upload.common.b.c("UploadTask", "abort session:" + parama.hashCode());
    if ((this.mSession != null) && (this.mSession.equals(parama))) {
      this.mSession = null;
    }
    if (this.mMultiSession != null)
    {
      int i = 0;
      while (i < this.mMultiSession.length)
      {
        if ((this.mMultiSession[i] != null) && (this.mMultiSession[i].equals(parama))) {
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
  
  public void bindSessionPool(com.tencent.upload.network.a.c paramc)
  {
    this.mSessionPool = paramc;
  }
  
  public boolean cancel()
  {
    com.tencent.upload.common.b.d("[transfer]UploadTask", "task canceled by user, taskId:" + getTaskId());
    if (getTaskState() == c.g) {
      return false;
    }
    super.cancel();
    quitMultiThreadUpload();
    setTaskStatus(c.e);
    this.mRetryCount = 0;
    this.mFinish = true;
    onTaskFinished(Const.UploadRetCode.CANCELED.getCode(), Const.UploadRetCode.CANCELED.getDesc());
    return true;
  }
  
  protected final void cancelForError(int paramInt, String paramString)
  {
    com.tencent.upload.common.b.d("[transfer] UploadTask", "cancelForError taskId:" + getTaskId() + " errorCode=" + paramInt + " retryCount:" + this.mRetryCount + " mNetworkRetryCount:" + this.mNetworkRetryCount + " errorMsg=" + paramString + " mFinish=" + this.mFinish);
    if ((paramInt == 0) || (this.mFinish)) {
      return;
    }
    super.cancel();
    this.mFinish = true;
    this.mSliceSize = 0;
    onUploadError(paramInt, paramString);
    setTaskStatus(c.f);
    onTaskFinished(paramInt, paramString);
  }
  
  protected abstract int getBucketSize();
  
  protected abstract com.tencent.upload.c.b getControlRequest();
  
  public com.tencent.upload.d.a.a getDataSource()
  {
    return this.mDataSource;
  }
  
  public String getFilePath()
  {
    return this.mFilePath;
  }
  
  protected com.tencent.upload.c.a.d getFileUploadRequest(a parama)
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
      this.mDataLength = this.mDataSource.c();
    }
    if ((this.mFileSendOffset >= this.mDataLength) || (this.mDataLength <= 0L) || (getTaskState() == c.g)) {
      return 100.0F;
    }
    return 100.0F * (float)this.mFileSendOffset / (float)this.mDataLength;
  }
  
  public boolean isDataSourceValid()
  {
    if (this.mDataSource != null) {
      return this.mDataSource.a();
    }
    return false;
  }
  
  public void onError(int paramInt, String paramString)
  {
    com.tencent.upload.common.b.d("UploadTask", "taskId:" + getTaskId() + " onError errCode:" + paramInt + " desc:" + paramString);
    cancelForError(paramInt, paramString);
  }
  
  protected void onFileControlResponse(JceStruct paramJceStruct, com.tencent.upload.c.c paramc)
  {
    long l = 0L;
    if (paramJceStruct == null)
    {
      com.tencent.upload.common.b.b("UploadTask", "onFileControlResponse rsp == null " + hashCode());
      onError(Const.UploadRetCode.RESPONSE_IS_NULL.getCode(), Const.UploadRetCode.RESPONSE_IS_NULL.getDesc());
    }
    do
    {
      return;
      if ((paramJceStruct instanceof FileBatchControlRsp))
      {
        onFileControlResponse((FileControlRsp)((FileBatchControlRsp)paramJceStruct).control_rsp.get("1"), paramc);
        return;
      }
      paramJceStruct = (FileControlRsp)paramJceStruct;
      com.tencent.upload.common.b.b("[transfer] UploadTask", "recv FileControlResponse taskId=" + getTaskId() + " reqId=" + paramc.c() + " cmd=" + paramc.b() + " ret=" + paramJceStruct.result.ret + " flag=" + paramJceStruct.result.flag + " msg=" + paramJceStruct.result.msg + " retry=" + this.mRetryCount + " offset=" + paramJceStruct.offset + " slice_size=" + paramJceStruct.slice_size + " session=" + paramJceStruct.session);
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
          this.mSessionId = "";
          resetSessionPool(true);
          return;
        }
        onError(paramJceStruct.result.ret, paramJceStruct.result.msg);
        return;
      }
      if (paramJceStruct.result.flag == 0) {
        break;
      }
    } while ((paramJceStruct.result.flag != 1) && (paramJceStruct.result.flag != 2));
    com.tencent.upload.common.b.b("UploadTask", "taskId=" + getTaskId() + "rsp.result.flag=" + paramJceStruct.result.flag + " upload success !");
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
    com.tencent.upload.common.b.b("UploadTask", "slicesize=" + paramJceStruct.slice_size);
    this.mSliceSize = ((int)paramJceStruct.slice_size);
    this.mSessionId = paramJceStruct.session;
    com.tencent.upload.a.a.a(this, this.mSessionId);
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
  
  public void onRequestError(com.tencent.upload.c.a parama, Const.UploadRetCode paramUploadRetCode, com.tencent.upload.network.a.a parama1)
  {
    boolean bool = parama.g() instanceof a;
    if (bool) {}
    for (String str = ((a)parama.g()).d;; str = "")
    {
      com.tencent.upload.common.b.b("UploadTask", str + "onRequestError taskId=" + getTaskId() + " reqId=" + parama.c() + " CMD=" + parama.d() + " mNetworkRetryCount=" + this.mNetworkRetryCount + " session=" + parama1.hashCode() + " code: " + paramUploadRetCode + " mFlagError:" + this.mFlagError);
      abortSession(parama1);
      if ((parama.c() >= this.mCurrControlReqId) && (!this.mFlagError)) {
        break;
      }
      return;
    }
    this.mFlagError = true;
    if (bool) {
      a.a((a)parama.g());
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
  
  public void onRequestSended(com.tencent.upload.c.a parama)
  {
    if (getTaskState() == c.e) {}
    do
    {
      do
      {
        do
        {
          return;
          boolean bool = parama.g() instanceof a;
          if (bool) {}
          for (String str = ((a)parama.g()).d;; str = "")
          {
            com.tencent.upload.common.b.b("[transfer] UploadTask", str + " onRequestSended taskId=" + getTaskId() + ", reqId=" + parama.c());
            if (!bool) {
              break;
            }
            ((a)parama.g()).b();
            return;
          }
        } while (parama.c() < this.mCurrControlReqId);
        switch (1.a[getTaskState().ordinal()])
        {
        default: 
          return;
        }
        if ((parama instanceof com.tencent.upload.c.a.d))
        {
          com.tencent.upload.common.b.b("[transfer] UploadTask", "send over reqId=" + parama.c() + " offset=" + this.mLastSendOffset + " slice=" + this.mLastSliceSize + " total=" + this.mDataLength);
          this.mDataPkgEndTime = System.currentTimeMillis();
          postExecute(1, false);
          return;
        }
      } while (!(parama instanceof com.tencent.upload.c.a.c));
      parama = (com.tencent.upload.c.a.c)parama;
    } while (parama.i() <= 0L);
    onUploadProgress(this.mDataLength, parama.i());
    this.mFileSendOffset = parama.i();
  }
  
  public void onRequestTimeout(com.tencent.upload.c.a parama, com.tencent.upload.network.a.a parama1)
  {
    boolean bool = parama.g() instanceof a;
    if (bool) {}
    for (String str = ((a)parama.g()).d;; str = "")
    {
      com.tencent.upload.common.b.b("UploadTask", str + "onRequestTimeout taskId=" + getTaskId() + " reqId=" + parama.c() + " CMD=" + parama.d() + " mNetworkRetryCount=" + this.mNetworkRetryCount + " session=" + parama1.hashCode() + " mCurrControlReqId=" + this.mCurrControlReqId + " mFlagError:" + this.mFlagError);
      com.tencent.upload.e.c.a.a(this, "回包超时");
      abortSession(parama1);
      if ((parama.c() >= this.mCurrControlReqId) && (!this.mFlagError)) {
        break;
      }
      return;
    }
    this.mFlagError = true;
    if (bool) {
      a.a((a)parama.g());
    }
    if (this.mNetworkRetryCount < getMaxNetworkRetryTimes())
    {
      this.mNetworkRetryCount += 1;
      com.tencent.upload.e.c.a.a(this, "重试发控制包，重试次数" + this.mNetworkRetryCount);
      postExecute(0, true);
      return;
    }
    cancelForError(Const.UploadRetCode.REQUEST_TIMEOUT.getCode(), Const.UploadRetCode.REQUEST_TIMEOUT.getDesc());
  }
  
  public void onResponse(com.tencent.upload.c.a parama, com.tencent.upload.c.c paramc)
  {
    String str;
    if ((parama.g() instanceof a))
    {
      str = ((a)parama.g()).d;
      com.tencent.upload.common.b.b("[transfer] UploadTask", str + "recv --- taskId=" + this.mTaskId + ", reqId=" + parama.c());
      if ((getTaskState() != c.g) && (getTaskState() != c.f) && (getTaskState() != c.e)) {
        break label110;
      }
    }
    label110:
    while (paramc.c() < this.mCurrControlReqId)
    {
      return;
      str = "";
      break;
    }
    switch (paramc.b())
    {
    default: 
      return;
    case 1: 
      if (this.mAppid.equalsIgnoreCase("mobilelog")) {}
      for (parama = com.tencent.upload.e.b.a(FileControlRsp.class, paramc.a());; parama = com.tencent.upload.e.b.a(FileBatchControlRsp.class, paramc.a()))
      {
        onFileControlResponse(parama, paramc);
        return;
      }
    case 2: 
      onFileUploadResponse((FileUploadRsp)com.tencent.upload.e.b.a(FileUploadRsp.class, paramc.a()), paramc);
      return;
    }
    releaseSession();
    processFileBatchCommitRsp((FileBatchCommitRsp)com.tencent.upload.e.b.a(FileBatchCommitRsp.class, paramc.a()));
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
      com.tencent.upload.common.b.b("UploadTask", "onRun --- step: " + this.mStep + " taskId:" + getTaskId());
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
    com.tencent.upload.e.c.a.a(this, "准备发送控制包");
    return sendControlPkg();
    com.tencent.upload.e.c.a.a(this, "准备发送数据包");
    return multiThreadSendFilePkg();
    com.tencent.upload.c.c localc = new com.tencent.upload.c.c();
    onFileControlResponse(this.mSecondUploadRsp, localc);
    return true;
  }
  
  protected void onTaskFinished(int paramInt, String paramString)
  {
    releaseSession();
    if (this.mSavedSession != null)
    {
      this.mUploadRoute = this.mSavedSession.b();
      this.mConnectedIp = this.mSavedSession.c();
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
          this.mSessionPool.b(this.mUploadRoute);
          i = paramInt;
        }
      }
    }
    for (;;)
    {
      if ((getTaskState() != c.e) && (getTaskState() != c.d)) {
        report(i, paramString);
      }
      if (this.mTaskStateListener != null) {
        this.mTaskStateListener.a(this, i, paramString);
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
  
  protected abstract void onUploadStateChange(c paramc);
  
  protected abstract void onUploadSucceed(Object paramObject);
  
  public boolean pause()
  {
    if ((getTaskState() == c.g) || (getTaskState() == c.f) || (getTaskState() == c.d) || (getTaskState() == c.e)) {}
    while ((getTaskState() == c.c) && (this.mFileSendOffset >= this.mDataLength)) {
      return false;
    }
    super.pause();
    setTaskStatus(c.d);
    onTaskFinished(Const.UploadRetCode.PAUSED.getCode(), Const.UploadRetCode.PAUSED.getDesc());
    return true;
  }
  
  protected void postExecute(int paramInt, boolean paramBoolean)
  {
    com.tencent.upload.common.b.c("UploadTask", "taskId:" + getTaskId() + ", postExecute newStep:" + paramInt + " needReset:" + paramBoolean);
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
    setTaskStatus(c.g);
    onTaskFinished(Const.UploadRetCode.SUCCEED.getCode(), Const.UploadRetCode.SUCCEED.getDesc());
  }
  
  protected void processFileUploadFinishRsp(byte[] paramArrayOfByte)
  {
    setTaskStatus(c.g);
    onTaskFinished(Const.UploadRetCode.SUCCEED.getCode(), Const.UploadRetCode.SUCCEED.getDesc());
  }
  
  protected void quitMultiThreadUpload()
  {
    synchronized (this.mMultiThreads)
    {
      Iterator localIterator = this.mMultiThreads.iterator();
      if (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        locala.a();
        locala.f.cancel(true);
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
        this.mSessionPool.c(this.mSession);
        this.mSession = null;
      }
    } while (this.mMultiSession == null);
    com.tencent.upload.network.a.a[] arrayOfa = this.mMultiSession;
    int j = arrayOfa.length;
    int i = 0;
    while (i < j)
    {
      com.tencent.upload.network.a.a locala = arrayOfa[i];
      if (locala != null) {
        this.mSessionPool.c(locala);
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
    long l2;
    label592:
    label603:
    label617:
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
          localStringBuilder.append(paramString).append(" mState=").append(getTaskState().b()).append(" mProgressTotalLen=").append(this.mFileSendOffset).append(" mProgressRecvDataLen=").append(this.mFileRecvOffset).append(" || ");
          if ((i == Const.UploadRetCode.FILE_NOT_EXIST.getCode()) || (i == Const.UploadRetCode.IO_ERROR_RETCODE.getCode()) || (i == 30700) || (i == 31500))
          {
            boolean bool = Environment.getExternalStorageState().equals("mounted");
            l1 = FileUtils.getSdCardAvailableSize();
            paramString = com.tencent.upload.common.a.b().getDeviceInfo();
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
          break label592;
        }
        paramString = "N/A";
        ((Report)localObject).serverIp = paramString;
        paramString = this.mReportObj;
        if (this.mUploadRoute != null) {
          break label603;
        }
      }
      for (paramInt = 0;; paramInt = this.mUploadRoute.getRouteCategory().a())
      {
        paramString.ipsrctype = paramInt;
        this.mReportObj.networkType = UploadConfiguration.getCurrentNetworkCategory();
        this.mReportObj.retry = this.mRetryCount;
        this.mReportObj.content_type = "slice_upload";
        this.mReportObj.concurrent = com.tencent.upload.common.a.f().mFileSocketNumber;
        this.mReportObj.num = com.tencent.upload.common.a.f().mBatchControlNumber;
        l1 = this.mReportObj.endTime;
        l2 = this.mReportObj.startTime;
        if (this.mReportObj.fileSize >= 0L) {
          break label617;
        }
        this.mReported = true;
        return;
        paramString = this.mClientIp;
        break;
        paramString = this.mUploadRoute.getIp();
        break label466;
      }
    } while ((this.mReportObj.fileSize >= l1 - l2) || (this.mReportObj.networkType == 3));
    this.mReported = true;
  }
  
  public void resetTask()
  {
    this.mNeedReset = true;
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
  
  public void setTaskStateListener(d paramd)
  {
    this.mTaskStateListener = paramd;
  }
  
  protected boolean setTaskStatus(c paramc)
  {
    boolean bool = super.setTaskStatus(paramc);
    onTaskInfoChanged();
    if (bool) {
      onUploadStateChange(paramc);
    }
    return bool;
  }
  
  class a
    implements Runnable
  {
    a a;
    com.tencent.upload.network.a.a b;
    long c;
    String d;
    boolean e = true;
    Future f;
    private boolean h;
    
    public a(a parama, com.tencent.upload.network.a.a parama1)
    {
      this.a = parama;
      this.b = parama1;
      this.c = hashCode();
      this.d = ("[UploadThread-" + this.c + "-" + parama1.b() + "]");
    }
    
    /* Error */
    private void c()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 78	com/tencent/upload/d/e$a:h	Z
      //   6: istore_1
      //   7: iload_1
      //   8: ifeq +6 -> 14
      //   11: aload_0
      //   12: monitorexit
      //   13: return
      //   14: aload_0
      //   15: iconst_1
      //   16: putfield 78	com/tencent/upload/d/e$a:h	Z
      //   19: aload_0
      //   20: invokevirtual 81	java/lang/Object:notify	()V
      //   23: goto -12 -> 11
      //   26: astore_2
      //   27: aload_0
      //   28: monitorexit
      //   29: aload_2
      //   30: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	31	0	this	a
      //   6	2	1	bool	boolean
      //   26	4	2	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   2	7	26	finally
      //   14	23	26	finally
    }
    
    private void d()
    {
      try
      {
        com.tencent.upload.common.b.d("UploadTask", this.d + "terminateWithRetry --- ");
        c();
        e locale = e.this;
        locale.mNetworkRetryCount += 1;
        e.this.postExecute(0, true);
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public void a()
    {
      c();
    }
    
    void b()
    {
      try
      {
        this.e = false;
        notify();
        return;
      }
      finally {}
    }
    
    public void run()
    {
      for (;;)
      {
        synchronized (this.a)
        {
          com.tencent.upload.c.a.d locald = e.this.getFileUploadRequest(this.a);
          if (locald != null)
          {
            e.this.mFileSendOffset = (locald.b + locald.i());
            e.this.mLastSliceSize = locald.i();
            e.this.mLastSendOffset = locald.b;
            e.this.mDataPkgEndTime = System.currentTimeMillis();
            locald.a(this);
          }
          if (locald == null)
          {
            com.tencent.upload.common.b.b("UploadTask", this.d + " request == null, send over!!");
            e.this.setTaskStatus(c.c);
            label120:
            com.tencent.upload.common.b.b("[transfer] UploadTask", this.d + " thread finish threadId=" + this.c + " mFinish=" + e.this.mFinish);
            return;
          }
        }
        this.e = true;
        boolean bool = this.b.a(locala1, e.this);
        com.tencent.upload.common.b.b("[transfer] UploadTask", this.d + " send result=" + bool + " reqId=" + locala1.c());
        if (!bool)
        {
          d();
          continue;
        }
        for (;;)
        {
          try {}catch (Exception localException)
          {
            com.tencent.upload.common.b.c("[transfer] UploadTask", this.d + "run tFinish: " + this.h + " mFinish: " + e.this.mFinish, localException);
            continue;
          }
          try
          {
            if (this.e) {
              wait();
            }
            if (this.h) {
              break label120;
            }
            if (!e.this.mFinish) {
              break;
            }
            break label120;
          }
          finally {}
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.d.e
 * JD-Core Version:    0.7.0.1
 */