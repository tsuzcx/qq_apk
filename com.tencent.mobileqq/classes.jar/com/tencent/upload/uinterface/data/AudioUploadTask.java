package com.tencent.upload.uinterface.data;

import SLICE_UPLOAD.UploadTouchuanReq;
import Sound.UploadReq;
import Sound.UploadRsp;
import android.util.Log;
import com.qq.taf.jce.JceStruct;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.TaskTypeConfig;
import com.tencent.upload.utils.Const.UploadRetCode;
import com.tencent.upload.utils.JceEncoder;
import com.tencent.upload.utils.ProtocolUtil;
import com.tencent.upload.utils.UploadLog;

public class AudioUploadTask
  extends AbstractUploadTask
{
  private static final String TAG = "AudioUploadTask";
  public int appid = 0;
  public long client_ip = 0L;
  public int format = 0;
  public int voice_length = 0;
  
  public AudioUploadTask(String paramString)
  {
    super(paramString);
    this.mAppid = "touchuan";
    this.iSync = 0;
  }
  
  private byte[] getSoundReq()
  {
    Object localObject = new UploadReq();
    ((UploadReq)localObject).uin = this.iUin;
    ((UploadReq)localObject).appid = this.appid;
    ((UploadReq)localObject).format = this.format;
    ((UploadReq)localObject).voice_length = this.voice_length;
    ((UploadReq)localObject).client_ip = this.client_ip;
    ((UploadReq)localObject).data = new byte[0];
    ((UploadReq)localObject).key_type = 0L;
    ((UploadReq)localObject).key_value = new byte[0];
    ((UploadReq)localObject).server_ip = 0L;
    try
    {
      localObject = ProtocolUtil.pack(localObject.getClass().getSimpleName(), localObject);
      return localObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return new byte[0];
  }
  
  public byte[] buildExtra()
  {
    Object localObject = new UploadTouchuanReq();
    ((UploadTouchuanReq)localObject).iUploadType = getUploadTaskType().uploadType;
    ((UploadTouchuanReq)localObject).vReqData = getSoundReq();
    try
    {
      localObject = JceEncoder.encode((JceStruct)localObject);
      return localObject;
    }
    catch (Exception localException)
    {
      UploadLog.e("AudioUploadTask", localException.toString());
    }
    return null;
  }
  
  public TaskTypeConfig getUploadTaskType()
  {
    return TaskTypeConfig.AudioUploadTaskType;
  }
  
  public void processFileUploadFinishRsp(byte[] paramArrayOfByte)
  {
    Object localObject2 = null;
    try
    {
      localObject1 = (UploadRsp)ProtocolUtil.unpack(UploadRsp.class.getSimpleName(), paramArrayOfByte);
      localObject2 = localObject1;
      localObject1 = null;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject1 = Log.getStackTraceString(localException);
        UploadLog.i("AudioUploadTask", "processFileUploadFinishRsp", localException);
      }
      Object localObject1 = new AudioUploadResult();
      ((AudioUploadResult)localObject1).result = ((UploadRsp)localObject2).result;
      ((AudioUploadResult)localObject1).voice_id = ((UploadRsp)localObject2).voice_id;
      ((AudioUploadResult)localObject1).flowId = this.flowId;
      ((AudioUploadResult)localObject1).voice_length = this.voice_length;
      onUploadSucceed(localObject1);
      super.processFileUploadFinishRsp(paramArrayOfByte);
      onDestroy();
    }
    if (localObject2 == null)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = "unpack UploadRsp == null. " + paramArrayOfByte;
      }
      onError(Const.UploadRetCode.DATA_UNPACK_FAILED_RETCODE.getCode(), (String)localObject2);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.upload.uinterface.data.AudioUploadTask
 * JD-Core Version:    0.7.0.1
 */