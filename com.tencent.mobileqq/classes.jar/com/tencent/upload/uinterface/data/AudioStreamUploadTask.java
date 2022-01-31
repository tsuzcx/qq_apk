package com.tencent.upload.uinterface.data;

import NS_COMM_UPLOAD_PROTOCOL.CUploadDownstream;
import NS_COMM_UPLOAD_PROTOCOL.CUploadUpstream;
import SLICE_UPLOAD.UploadTouchuanReq;
import android.util.Log;
import com.qq.taf.jce.JceStruct;
import com.tencent.upload.a.a;
import com.tencent.upload.common.Const.UploadRetCode;
import com.tencent.upload.common.FileUtils;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.TaskTypeConfig;

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
      localObject = com.tencent.upload.e.b.a((JceStruct)localObject);
      return localObject;
    }
    catch (Exception localException)
    {
      com.tencent.upload.common.b.a("AudioStreamUploadTask", localException);
      byte[] arrayOfByte = super.buildExtra();
      com.tencent.upload.common.b.b("AudioStreamUploadTask", "buildExtra() failed", localException);
      return arrayOfByte;
    }
  }
  
  public byte[] buildExtra()
  {
    UploadTouchuanReq localUploadTouchuanReq = new UploadTouchuanReq();
    localUploadTouchuanReq.iUploadType = getUploadTaskType().uploadType;
    localUploadTouchuanReq.vReqData = getAudioStreamData();
    return com.tencent.upload.e.b.a(localUploadTouchuanReq);
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
    a.b(this, this.mSessionId);
  }
  
  protected void processFileUploadFinishRsp(byte[] paramArrayOfByte)
  {
    Object localObject2 = null;
    try
    {
      localObject1 = (CUploadDownstream)com.tencent.upload.e.b.a(CUploadDownstream.class, paramArrayOfByte);
      localObject2 = localObject1;
      localObject1 = null;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject1 = Log.getStackTraceString(localException);
        com.tencent.upload.common.b.a("AudioStreamUploadTask", localException);
      }
      onUploadSucceed(localObject2);
      super.processFileUploadFinishRsp(paramArrayOfByte);
      onDestroy();
    }
    if (localObject2 == null)
    {
      paramArrayOfByte = (byte[])localObject1;
      if (localObject1 == null) {
        paramArrayOfByte = "音频上传回包解析出错！";
      }
      onError(Const.UploadRetCode.DATA_UNPACK_FAILED_RETCODE.getCode(), "errorMsg = " + paramArrayOfByte);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.uinterface.data.AudioStreamUploadTask
 * JD-Core Version:    0.7.0.1
 */