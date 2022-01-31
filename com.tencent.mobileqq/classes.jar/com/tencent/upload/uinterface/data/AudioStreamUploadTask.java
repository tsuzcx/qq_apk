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
  
  public void onDestroy()
  {
    if (!this.mKeepFileAfterUpload) {
      FileUtils.deleteTempFile(this.mFilePath);
    }
    CacheUtil.deleteSessionId(this, this.mSessionId);
  }
  
  public void processFileUploadFinishRsp(byte[] paramArrayOfByte)
  {
    Object localObject2 = null;
    try
    {
      localObject1 = (CUploadDownstream)JceEncoder.decode(CUploadDownstream.class, paramArrayOfByte);
      localObject2 = localObject1;
      localObject1 = null;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject1 = Log.getStackTraceString(localException);
        UploadLog.w("AudioStreamUploadTask", localException);
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