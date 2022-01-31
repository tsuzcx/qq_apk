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
import com.tencent.upload.task.TaskState;
import com.tencent.upload.task.UploadTask;
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
  protected boolean mKeepFileAfterUpload = true;
  protected UploadModel mModel;
  protected boolean mNeedBatch = true;
  protected boolean mNeedIpRedirect;
  public String mOriginFilePath;
  protected stEnvironment mStEnv;
  protected String mTmpUploadPath;
  public String md5 = null;
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
    this.mStEnv.refer = this.sRefer;
    this.mStEnv.entrance = this.uploadEntrance;
  }
  
  public byte[] buildExtra()
  {
    return "null".getBytes();
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (paramObject == null) {
        return false;
      }
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (AbstractUploadTask)paramObject;
    } while (this.flowId == paramObject.flowId);
    return false;
  }
  
  public int getAppid()
  {
    return this.iAppid;
  }
  
  public int getBatchId()
  {
    return this.mBatchId;
  }
  
  public int getBucketSize()
  {
    return 16384;
  }
  
  public UploadRequest getControlRequest()
  {
    Object localObject1;
    if (this.mAppid.equalsIgnoreCase("video_qzone"))
    {
      this.mCheckType = CheckType.TYPE_SHA1;
      localObject1 = FileUtils.getFileSha1(new File(this.mFilePath));
      this.sha1 = ((String)localObject1);
    }
    for (this.mChecksum = ((String)localObject1);; this.mChecksum = ((String)localObject1))
    {
      UploadLog.d("AbstractUploadTask", "mCheckType: " + this.mCheckType + "\nmChecksum: " + this.mChecksum);
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
        DumpBussinessReq localDumpBussinessReq = new DumpBussinessReq();
        localDumpBussinessReq.IMEI = this.sDevIMEI;
        ((Map)localObject1).put(Integer.valueOf(1), localDumpBussinessReq);
      }
      localObject1 = new FileControlRequest(this.iUin + "", this.mAppid, (AuthToken)localObject2, this.mChecksum, this.mCheckType, this.mDataLength, this.mStEnv, this.mModel, this.mSessionId, this.mNeedIpRedirect, true, this.iSync, (Map)localObject1);
      ((FileControlRequest)localObject1).setExtraParam(buildExtra());
      localObject2 = new HashMap();
      ((Map)localObject2).put("1", (FileControlReq)((FileControlRequest)localObject1).createJceRequest());
      localObject1 = new BatchControlRequest((Map)localObject2);
      ((BatchControlRequest)localObject1).setTaskId(this.flowId);
      return localObject1;
      this.mCheckType = CheckType.TYPE_MD5;
      localObject1 = FileUtils.getMd5ByFile_REAL(new File(this.mFilePath));
      this.md5 = ((String)localObject1);
    }
  }
  
  public long getFileLength()
  {
    return this.mDataLength;
  }
  
  public Const.FileType getFileType()
  {
    return Const.FileType.Other;
  }
  
  /* Error */
  public com.tencent.upload.request.impl.FileUploadRequest getFileUploadRequest(com.tencent.upload.task.AtomFile paramAtomFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 340	com/tencent/upload/uinterface/AbstractUploadTask:mSliceSize	I
    //   4: ifle +68 -> 72
    //   7: aload_0
    //   8: getfield 340	com/tencent/upload/uinterface/AbstractUploadTask:mSliceSize	I
    //   11: istore_2
    //   12: aload_0
    //   13: iload_2
    //   14: putfield 340	com/tencent/upload/uinterface/AbstractUploadTask:mSliceSize	I
    //   17: aconst_null
    //   18: astore 5
    //   20: aload_1
    //   21: monitorenter
    //   22: aload_1
    //   23: invokevirtual 345	com/tencent/upload/task/AtomFile:getRemainSize	()J
    //   26: lstore_3
    //   27: lload_3
    //   28: lconst_0
    //   29: lcmp
    //   30: ifgt +50 -> 80
    //   33: ldc 14
    //   35: new 222	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 224	java/lang/StringBuilder:<init>	()V
    //   42: ldc_w 347
    //   45: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: aload_0
    //   49: getfield 186	com/tencent/upload/uinterface/AbstractUploadTask:flowId	I
    //   52: invokevirtual 350	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   55: ldc_w 352
    //   58: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: invokevirtual 238	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokestatic 355	com/tencent/upload/utils/UploadLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   67: aload_1
    //   68: monitorexit
    //   69: aload 5
    //   71: areturn
    //   72: aload_0
    //   73: invokevirtual 357	com/tencent/upload/uinterface/AbstractUploadTask:getBucketSize	()I
    //   76: istore_2
    //   77: goto -65 -> 12
    //   80: lload_3
    //   81: aload_0
    //   82: getfield 340	com/tencent/upload/uinterface/AbstractUploadTask:mSliceSize	I
    //   85: i2l
    //   86: invokestatic 363	java/lang/Math:min	(JJ)J
    //   89: lstore_3
    //   90: new 365	com/tencent/upload/request/impl/FileUploadRequest
    //   93: dup
    //   94: aload_0
    //   95: getfield 149	com/tencent/upload/uinterface/AbstractUploadTask:mDataSource	Lcom/tencent/upload/task/data/UploadDataSource;
    //   98: new 222	java/lang/StringBuilder
    //   101: dup
    //   102: invokespecial 224	java/lang/StringBuilder:<init>	()V
    //   105: aload_0
    //   106: getfield 84	com/tencent/upload/uinterface/AbstractUploadTask:iUin	J
    //   109: invokevirtual 292	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   112: ldc 80
    //   114: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: invokevirtual 238	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: aload_0
    //   121: getfield 200	com/tencent/upload/uinterface/AbstractUploadTask:mAppid	Ljava/lang/String;
    //   124: aload_0
    //   125: getfield 295	com/tencent/upload/uinterface/AbstractUploadTask:mSessionId	Ljava/lang/String;
    //   128: aload_1
    //   129: lload_3
    //   130: invokevirtual 369	com/tencent/upload/task/AtomFile:reduce	(J)J
    //   133: lload_3
    //   134: aload_0
    //   135: getfield 213	com/tencent/upload/uinterface/AbstractUploadTask:mCheckType	LSLICE_UPLOAD/CheckType;
    //   138: iconst_0
    //   139: invokespecial 372	com/tencent/upload/request/impl/FileUploadRequest:<init>	(Lcom/tencent/upload/task/data/UploadDataSource;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLSLICE_UPLOAD/CheckType;Z)V
    //   142: astore 5
    //   144: aload 5
    //   146: aload_0
    //   147: getfield 186	com/tencent/upload/uinterface/AbstractUploadTask:flowId	I
    //   150: invokevirtual 373	com/tencent/upload/request/impl/FileUploadRequest:setTaskId	(I)V
    //   153: goto -86 -> 67
    //   156: astore 5
    //   158: aload_1
    //   159: monitorexit
    //   160: aload 5
    //   162: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	163	0	this	AbstractUploadTask
    //   0	163	1	paramAtomFile	com.tencent.upload.task.AtomFile
    //   11	66	2	i	int
    //   26	108	3	l	long
    //   18	127	5	localFileUploadRequest	com.tencent.upload.request.impl.FileUploadRequest
    //   156	5	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   22	27	156	finally
    //   33	67	156	finally
    //   67	69	156	finally
    //   80	153	156	finally
    //   158	160	156	finally
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
  
  public void onUploadError(int paramInt, String paramString)
  {
    UploadLog.w("AbstractUploadTask", "upload file failed! actionId=" + getTaskId() + " ret=" + paramInt + " msg=" + paramString);
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
  
  public void onUploadProgress(long paramLong1, long paramLong2)
  {
    if (this.uploadTaskCallback == null) {}
    while (this.mFinish) {
      return;
    }
    if (this.mHandler != null)
    {
      this.mHandler.post(new AbstractUploadTask.1(this, paramLong1, paramLong2));
      return;
    }
    this.uploadTaskCallback.onUploadProgress(this, paramLong1, paramLong2);
  }
  
  public void onUploadStateChange(TaskState paramTaskState)
  {
    int i = paramTaskState.getOutState();
    if ((i == 1) && (this.lastState == i)) {}
    do
    {
      do
      {
        return;
      } while ((i == -1000) || (i == 0));
      this.lastState = i;
    } while (this.uploadTaskCallback == null);
    if (this.mHandler != null)
    {
      this.mHandler.post(new AbstractUploadTask.4(this, i));
      return;
    }
    this.uploadTaskCallback.onUploadStateChange(this, i);
  }
  
  public void onUploadSucceed(Object paramObject)
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
    if (!FileUtils.isFileExist(str))
    {
      UploadLog.e("AbstractUploadTask", Const.UploadRetCode.FILE_NOT_EXIST + " path:" + str);
      onError(Const.UploadRetCode.FILE_NOT_EXIST.getCode(), Const.UploadRetCode.FILE_NOT_EXIST.getDesc());
      return false;
    }
    if (!FileUtils.isValidTempFile(str))
    {
      UploadLog.e("AbstractUploadTask", Const.UploadRetCode.FILE_LENGTH_INVALID + " path:" + str);
      onError(Const.UploadRetCode.FILE_LENGTH_INVALID.getCode(), Const.UploadRetCode.FILE_LENGTH_INVALID.getDesc());
      return false;
    }
    return true;
  }
  
  public void report(int paramInt, String paramString)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.uinterface.AbstractUploadTask
 * JD-Core Version:    0.7.0.1
 */