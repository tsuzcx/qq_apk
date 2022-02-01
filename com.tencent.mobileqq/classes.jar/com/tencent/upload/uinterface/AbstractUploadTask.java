package com.tencent.upload.uinterface;

import SLICE_UPLOAD.AuthToken;
import SLICE_UPLOAD.CheckType;
import SLICE_UPLOAD.DumpBussinessReq;
import SLICE_UPLOAD.FileControlReq;
import SLICE_UPLOAD.UploadModel;
import SLICE_UPLOAD.stEnvironment;
import android.os.Handler;
import android.os.Parcel;
import com.tencent.upload.common.UploadConfiguration;
import com.tencent.upload.common.UploadGlobalConfig;
import com.tencent.upload.network.session.cache.CacheUtil;
import com.tencent.upload.report.Report;
import com.tencent.upload.request.UploadRequest;
import com.tencent.upload.request.impl.BatchControlRequest;
import com.tencent.upload.request.impl.FileControlRequest;
import com.tencent.upload.request.impl.FileUploadRequest;
import com.tencent.upload.task.AtomFile;
import com.tencent.upload.task.TaskState;
import com.tencent.upload.task.UploadTask;
import com.tencent.upload.task.data.UploadDataSource;
import com.tencent.upload.task.data.UploadDataSource.FileDataSource;
import com.tencent.upload.uinterface.token.TokenProvider;
import com.tencent.upload.utils.Const.FileType;
import com.tencent.upload.utils.Const.UploadRetCode;
import com.tencent.upload.utils.FileUtils;
import com.tencent.upload.utils.UploadLog;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractUploadTask
  extends UploadTask
{
  public static final String ENTRY_TYPE_ALBUM = "album";
  public static final String ENTRY_TYPE_SHUOSHUO = "shoushuo";
  protected static final String TAG = "AbstractUploadTask";
  public String entry = "";
  public Object extra;
  public int iSync = 1;
  public long iUin = 0L;
  public long iUploadTime = 0L;
  public boolean isSyncWeishi;
  int lastState = -1;
  protected int mBatchId;
  protected byte[] mBizReq;
  protected CheckType mCheckType;
  protected String mChecksum = "";
  public Map<String, String> mExtend_info;
  protected boolean mKeepFileAfterUpload = true;
  protected UploadModel mModel;
  protected boolean mNeedBatch = true;
  protected boolean mNeedIpRedirect;
  public String mOriginFilePath;
  protected stEnvironment mStEnv;
  public IUploadConfig.UploadImageSize mTargetSize;
  protected String mTmpUploadPath;
  public String md5 = null;
  public boolean needCompress = true;
  public AbstractUploadTask origin;
  public int preupload = 0;
  public String reportRefer = "mqzone";
  public String sDescMD5;
  public String sDevIMEI;
  public String sFileMD5;
  public String sRefer = "mqzone";
  public String sha1 = null;
  public Map<String, String> transferData = null;
  public String uiRefer;
  public int uploadEntrance = 0;
  public String uploadFilePath = null;
  public IUploadTaskCallback uploadTaskCallback = null;
  public byte[] vLoginData = null;
  public byte[] vLoginKey = new byte[0];
  
  public AbstractUploadTask(Parcel paramParcel)
  {
    super(paramParcel);
    this.sFileMD5 = paramParcel.readString();
  }
  
  public AbstractUploadTask(String paramString)
  {
    super(paramString);
    this.mOriginFilePath = paramString;
    this.uploadFilePath = paramString;
    init();
  }
  
  public AbstractUploadTask(byte[] paramArrayOfByte)
  {
    super(paramArrayOfByte);
    init();
  }
  
  private void init()
  {
    this.mNeedIpRedirect = false;
    this.mDataLength = FileUtils.getFileLength(this.mFilePath);
  }
  
  private void resetPath(String paramString)
  {
    this.mFilePath = paramString;
    this.mDataSource = new UploadDataSource.FileDataSource(paramString);
    this.mDataLength = FileUtils.getFileLength(this.mFilePath);
  }
  
  protected void buildEnv()
  {
    this.mStEnv = UploadGlobalConfig.getEnv();
    stEnvironment localstEnvironment = this.mStEnv;
    localstEnvironment.refer = this.sRefer;
    localstEnvironment.entrance = this.uploadEntrance;
  }
  
  public byte[] buildExtra()
  {
    return "null".getBytes();
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (getClass() != paramObject.getClass()) {
      return false;
    }
    paramObject = (AbstractUploadTask)paramObject;
    return this.flowId == paramObject.flowId;
  }
  
  public int getAppid()
  {
    return this.iAppid;
  }
  
  public int getBatchId()
  {
    return this.mBatchId;
  }
  
  protected int getBucketSize()
  {
    return 16384;
  }
  
  protected UploadRequest getControlRequest()
  {
    if (this.mAppid.equalsIgnoreCase("video_qzone"))
    {
      this.mCheckType = CheckType.TYPE_SHA1;
      localObject1 = FileUtils.getFileSha1(new File(this.mFilePath));
      this.sha1 = ((String)localObject1);
      this.mChecksum = ((String)localObject1);
    }
    else
    {
      this.mCheckType = CheckType.TYPE_MD5;
      localObject1 = FileUtils.getMd5ByFile_REAL(new File(this.mFilePath));
      this.md5 = ((String)localObject1);
      this.mChecksum = ((String)localObject1);
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("mCheckType: ");
    ((StringBuilder)localObject1).append(this.mCheckType);
    ((StringBuilder)localObject1).append("\nmChecksum: ");
    ((StringBuilder)localObject1).append(this.mChecksum);
    UploadLog.d("AbstractUploadTask", ((StringBuilder)localObject1).toString());
    Object localObject2 = TokenProvider.getAuthToken(this.vLoginData, this.vLoginKey);
    buildEnv();
    this.mModel = UploadModel.MODEL_NORMAL;
    if (this.preupload == 1) {
      this.mModel = UploadModel.MODEL_PRE_UPLOAD;
    }
    localObject1 = null;
    if (this.isSyncWeishi)
    {
      localObject1 = new HashMap();
      localObject3 = new DumpBussinessReq();
      ((DumpBussinessReq)localObject3).IMEI = this.sDevIMEI;
      ((Map)localObject1).put(Integer.valueOf(1), localObject3);
    }
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(this.iUin);
    ((StringBuilder)localObject3).append("");
    localObject1 = new FileControlRequest(((StringBuilder)localObject3).toString(), this.mAppid, (AuthToken)localObject2, this.mChecksum, this.mCheckType, this.mDataLength, this.mStEnv, this.mModel, this.mSessionId, this.mNeedIpRedirect, true, this.iSync, (Map)localObject1, this.mExtend_info);
    ((FileControlRequest)localObject1).setExtraParam(buildExtra());
    localObject2 = new HashMap();
    ((Map)localObject2).put("1", (FileControlReq)((FileControlRequest)localObject1).createJceRequest());
    localObject1 = new BatchControlRequest((Map)localObject2);
    ((BatchControlRequest)localObject1).setTaskId(this.flowId);
    return localObject1;
  }
  
  public long getFileLength()
  {
    return this.mDataLength;
  }
  
  public Const.FileType getFileType()
  {
    return Const.FileType.Other;
  }
  
  protected FileUploadRequest getFileUploadRequest(AtomFile paramAtomFile)
  {
    int i;
    if (this.mSliceSize > 0) {
      i = this.mSliceSize;
    } else {
      i = getBucketSize();
    }
    this.mSliceSize = i;
    Object localObject1 = null;
    try
    {
      long l = paramAtomFile.getRemainSize();
      StringBuilder localStringBuilder;
      if (l <= 0L)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[speed] id:");
        localStringBuilder.append(this.flowId);
        localStringBuilder.append(" --- no data to send !!");
        UploadLog.w("AbstractUploadTask", localStringBuilder.toString());
      }
      else
      {
        l = Math.min(l, this.mSliceSize);
        localObject1 = this.mDataSource;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.iUin);
        localStringBuilder.append("");
        localObject1 = new FileUploadRequest((UploadDataSource)localObject1, localStringBuilder.toString(), this.mAppid, this.mSessionId, paramAtomFile.reduce(l), l, this.mCheckType, false);
        ((FileUploadRequest)localObject1).setTaskId(this.flowId);
      }
      return localObject1;
    }
    finally {}
  }
  
  public String getFlowMessage()
  {
    return this.mFlowRecoder.toString();
  }
  
  public StringBuffer getFlowRecoder()
  {
    return this.mFlowRecoder;
  }
  
  public String getProtocolAppid()
  {
    return this.mAppid;
  }
  
  public Report getReportObj()
  {
    return this.mReportObj;
  }
  
  public abstract TaskTypeConfig getUploadTaskType();
  
  protected boolean isNetworkAvailable()
  {
    return UploadConfiguration.isNetworkAvailable();
  }
  
  public void keepTmpFile(boolean paramBoolean)
  {
    this.mKeepFileAfterUpload = paramBoolean;
  }
  
  public boolean needWaitBatch()
  {
    return this.mNeedBatch;
  }
  
  protected void onDestroy()
  {
    CacheUtil.deleteSessionId(this, this.mSessionId);
  }
  
  protected void onUploadError(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("upload file failed! actionId=");
    localStringBuilder.append(getTaskId());
    localStringBuilder.append(" ret=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" msg=");
    localStringBuilder.append(paramString);
    UploadLog.w("AbstractUploadTask", localStringBuilder.toString());
    if (this.uploadTaskCallback == null) {
      return;
    }
    if (this.mHandler != null)
    {
      this.mHandler.post(new AbstractUploadTask.3(this, paramInt, paramString));
      return;
    }
    this.uploadTaskCallback.onUploadError(this, paramInt, paramString);
  }
  
  public final void onUploadProcessStart()
  {
    onUploadStateChange(TaskState.WAITING);
  }
  
  protected void onUploadProgress(long paramLong1, long paramLong2)
  {
    if (this.uploadTaskCallback == null) {
      return;
    }
    if (this.mFinish) {
      return;
    }
    if (this.mHandler != null)
    {
      this.mHandler.post(new AbstractUploadTask.1(this, paramLong1, paramLong2));
      return;
    }
    this.uploadTaskCallback.onUploadProgress(this, paramLong1, paramLong2);
  }
  
  protected void onUploadStateChange(TaskState paramTaskState)
  {
    int i = paramTaskState.getOutState();
    if ((i == 1) && (this.lastState == i)) {
      return;
    }
    if (i != -1000)
    {
      if (i == 0) {
        return;
      }
      this.lastState = i;
      if (this.uploadTaskCallback == null) {
        return;
      }
      if (this.mHandler != null)
      {
        this.mHandler.post(new AbstractUploadTask.4(this, i));
        return;
      }
      this.uploadTaskCallback.onUploadStateChange(this, i);
    }
  }
  
  protected void onUploadSucceed(Object paramObject)
  {
    if (this.uploadTaskCallback == null) {
      return;
    }
    if (this.mHandler != null)
    {
      this.mHandler.post(new AbstractUploadTask.2(this, paramObject));
      return;
    }
    this.uploadTaskCallback.onUploadSucceed(this, paramObject);
  }
  
  public boolean onVerifyUploadFile()
  {
    String str = getFilePath();
    StringBuilder localStringBuilder;
    if (!FileUtils.isFileExist(str))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(Const.UploadRetCode.FILE_NOT_EXIST);
      localStringBuilder.append(" path:");
      localStringBuilder.append(str);
      UploadLog.e("AbstractUploadTask", localStringBuilder.toString());
      onError(Const.UploadRetCode.FILE_NOT_EXIST.getCode(), Const.UploadRetCode.FILE_NOT_EXIST.getDesc());
      return false;
    }
    if (!FileUtils.isValidTempFile(str))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(Const.UploadRetCode.FILE_LENGTH_INVALID);
      localStringBuilder.append(" path:");
      localStringBuilder.append(str);
      UploadLog.e("AbstractUploadTask", localStringBuilder.toString());
      onError(Const.UploadRetCode.FILE_LENGTH_INVALID.getCode(), Const.UploadRetCode.FILE_LENGTH_INVALID.getDesc());
      return false;
    }
    return true;
  }
  
  protected void report(int paramInt, String paramString)
  {
    this.mReportObj.refer = this.reportRefer;
    this.mReportObj.uploadType = getUploadTaskType();
    this.mReportObj.fileSize = getFileLength();
    this.mReportObj.transfer = this.transferData;
    this.mReportObj.entry = this.entry;
    super.report(paramInt, paramString);
  }
  
  protected void retryPollSession()
  {
    if ((this.mRetryCount < getMaxRetryTimes()) && (isNetworkAvailable()))
    {
      this.mRetryCount += 1;
      postExecute(0, true);
      return;
    }
    cancelForError(Const.UploadRetCode.NO_SESSION.getCode(), Const.UploadRetCode.NO_SESSION.getDesc());
  }
  
  public void setBatchId(int paramInt)
  {
    this.mBatchId = paramInt;
  }
  
  public void setTmpFilePath(String paramString)
  {
    this.mTmpUploadPath = paramString;
    resetPath(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.upload.uinterface.AbstractUploadTask
 * JD-Core Version:    0.7.0.1
 */