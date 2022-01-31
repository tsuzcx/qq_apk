package com.tencent.upload.uinterface.data;

import FileUpload.UploadUppInfoReq;
import FileUpload.UploadUppInfoRsp;
import android.util.Log;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.TaskTypeConfig;
import com.tencent.upload.utils.Const.UploadRetCode;
import com.tencent.upload.utils.FileUtils;
import com.tencent.upload.utils.JceEncoder;
import com.tencent.upload.utils.UploadLog;

public class UppUploadTask
  extends AbstractUploadTask
{
  private static final String TAG = "UppUploadTask";
  public static final String sfUppAppId = "diy";
  
  public UppUploadTask(String paramString)
  {
    super(paramString);
    this.mAppid = "upp";
    this.iSync = 0;
  }
  
  public UppUploadTask(byte[] paramArrayOfByte)
  {
    super(paramArrayOfByte);
  }
  
  public byte[] buildExtra()
  {
    UploadUppInfoReq localUploadUppInfoReq = new UploadUppInfoReq();
    localUploadUppInfoReq.appid = "diy";
    return JceEncoder.encode(localUploadUppInfoReq);
  }
  
  public TaskTypeConfig getUploadTaskType()
  {
    return TaskTypeConfig.UppUploadTaskType;
  }
  
  public void onDestroy()
  {
    if (!this.mKeepFileAfterUpload) {
      FileUtils.deleteTempFile(this.uploadFilePath);
    }
    super.onDestroy();
  }
  
  public void processFileUploadFinishRsp(byte[] paramArrayOfByte)
  {
    Object localObject2 = null;
    try
    {
      localObject1 = (UploadUppInfoRsp)JceEncoder.decode(UploadUppInfoRsp.class, paramArrayOfByte);
      localObject2 = localObject1;
      localObject1 = null;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject1 = Log.getStackTraceString(localException);
        UploadLog.w("UppUploadTask", "get rsp ", localException);
      }
      Object localObject1 = new UppUploadResult();
      ((UppUploadResult)localObject1).flowId = this.flowId;
      ((UppUploadResult)localObject1).sUrl = ((UploadUppInfoRsp)localObject2).sUrl;
      onUploadSucceed(localObject1);
      super.processFileUploadFinishRsp(paramArrayOfByte);
      onDestroy();
    }
    if (localObject2 == null)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = "unpack uploadUppInfoRsp=null. " + paramArrayOfByte;
      }
      onError(Const.UploadRetCode.DATA_UNPACK_FAILED_RETCODE.getCode(), (String)localObject2);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.uinterface.data.UppUploadTask
 * JD-Core Version:    0.7.0.1
 */