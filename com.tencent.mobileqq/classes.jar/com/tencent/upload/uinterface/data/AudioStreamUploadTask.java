package com.tencent.upload.uinterface.data;

import NS_COMM_UPLOAD_PROTOCOL.CUploadDownstream;
import NS_COMM_UPLOAD_PROTOCOL.CUploadUpstream;
import SLICE_UPLOAD.UploadTouchuanReq;
import android.util.Log;
import com.qq.taf.jce.JceStruct;
import com.tencent.upload.network.session.cache.CacheUtil;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.TaskTypeConfig;
import com.tencent.upload.utils.Const.UploadRetCode;
import com.tencent.upload.utils.FileUtils;
import com.tencent.upload.utils.JceEncoder;
import com.tencent.upload.utils.UploadLog;

public class AudioStreamUploadTask
  extends AbstractUploadTask
{
  private static final String TAG = "AudioStreamUploadTask";
  private int mBusiType;
  private byte[] mExtra;
  private int mFileType;
  
  public AudioStreamUploadTask(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    super(paramString);
    this.mBusiType = paramInt1;
    this.mFileType = paramInt2;
    this.mExtra = paramArrayOfByte;
    this.mAppid = "touchuan";
    this.iSync = 0;
  }
  
  private byte[] getAudioStreamData()
  {
    Object localObject = new CUploadUpstream();
    ((CUploadUpstream)localObject).busiType = this.mBusiType;
    ((CUploadUpstream)localObject).fileType = this.mFileType;
    ((CUploadUpstream)localObject).extra = this.mExtra;
    try
    {
      localObject = JceEncoder.encode((JceStruct)localObject);
      return localObject;
    }
    catch (Exception localException)
    {
      UploadLog.w("AudioStreamUploadTask", localException);
      byte[] arrayOfByte = super.buildExtra();
      UploadLog.w("AudioStreamUploadTask", "buildExtra() failed", localException);
      return arrayOfByte;
    }
  }
  
  public byte[] buildExtra()
  {
    UploadTouchuanReq localUploadTouchuanReq = new UploadTouchuanReq();
    localUploadTouchuanReq.iUploadType = getUploadTaskType().uploadType;
    localUploadTouchuanReq.vReqData = getAudioStreamData();
    return JceEncoder.encode(localUploadTouchuanReq);
  }
  
  public TaskTypeConfig getUploadTaskType()
  {
    return TaskTypeConfig.AudioStreamUploadTaskType;
  }
  
  protected void onDestroy()
  {
    if (!this.mKeepFileAfterUpload) {
      FileUtils.deleteTempFile(this.mFilePath);
    }
    CacheUtil.deleteSessionId(this, this.mSessionId);
  }
  
  protected void processFileUploadFinishRsp(byte[] paramArrayOfByte)
  {
    Object localObject2 = null;
    Object localObject1;
    try
    {
      CUploadDownstream localCUploadDownstream = (CUploadDownstream)JceEncoder.decode(CUploadDownstream.class, paramArrayOfByte);
      localObject1 = null;
      localObject2 = localCUploadDownstream;
    }
    catch (Exception localException)
    {
      localObject1 = Log.getStackTraceString(localException);
      UploadLog.w("AudioStreamUploadTask", localException);
    }
    if (localObject2 == null)
    {
      paramArrayOfByte = (byte[])localObject1;
      if (localObject1 == null) {
        paramArrayOfByte = "音频上传回包解析出错！";
      }
      int i = Const.UploadRetCode.DATA_UNPACK_FAILED_RETCODE.getCode();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("errorMsg = ");
      ((StringBuilder)localObject1).append(paramArrayOfByte);
      onError(i, ((StringBuilder)localObject1).toString());
      return;
    }
    onUploadSucceed(localObject2);
    super.processFileUploadFinishRsp(paramArrayOfByte);
    onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.upload.uinterface.data.AudioStreamUploadTask
 * JD-Core Version:    0.7.0.1
 */