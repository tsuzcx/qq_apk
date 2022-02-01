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
  
  protected void onDestroy()
  {
    if (!this.mKeepFileAfterUpload) {
      FileUtils.deleteTempFile(this.uploadFilePath);
    }
    super.onDestroy();
  }
  
  protected void processFileUploadFinishRsp(byte[] paramArrayOfByte)
  {
    Object localObject2 = null;
    try
    {
      UploadUppInfoRsp localUploadUppInfoRsp = (UploadUppInfoRsp)JceEncoder.decode(UploadUppInfoRsp.class, paramArrayOfByte);
      localObject1 = null;
      localObject2 = localUploadUppInfoRsp;
    }
    catch (Exception localException)
    {
      localObject1 = Log.getStackTraceString(localException);
      UploadLog.w("UppUploadTask", "get rsp ", localException);
    }
    if (localObject2 == null)
    {
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("unpack uploadUppInfoRsp=null. ");
        ((StringBuilder)localObject1).append(paramArrayOfByte);
        localObject2 = ((StringBuilder)localObject1).toString();
      }
      onError(Const.UploadRetCode.DATA_UNPACK_FAILED_RETCODE.getCode(), (String)localObject2);
      return;
    }
    Object localObject1 = new UppUploadResult();
    ((UppUploadResult)localObject1).flowId = this.flowId;
    ((UppUploadResult)localObject1).sUrl = ((UploadUppInfoRsp)localObject2).sUrl;
    onUploadSucceed(localObject1);
    super.processFileUploadFinishRsp(paramArrayOfByte);
    onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.upload.uinterface.data.UppUploadTask
 * JD-Core Version:    0.7.0.1
 */