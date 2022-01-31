package com.tencent.upload.uinterface.data;

import SLICE_UPLOAD.AuthToken;
import SLICE_UPLOAD.CheckType;
import SLICE_UPLOAD.FileControlRsp;
import SLICE_UPLOAD.UploadModel;
import SLICE_UPLOAD.stResult;
import com.qq.taf.jce.JceStruct;
import com.tencent.upload.common.Const.UploadRetCode;
import com.tencent.upload.common.Const.b;
import com.tencent.upload.common.FileUtils;
import com.tencent.upload.common.a;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadConfig;
import com.tencent.upload.uinterface.IUploadTaskCallback;
import com.tencent.upload.uinterface.TaskTypeConfig;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MobileLogUploadTask
  extends AbstractUploadTask
{
  private static final String TAG = "MobileLogUploadTask";
  
  public MobileLogUploadTask(String paramString)
  {
    super(paramString);
    this.mAppid = "mobilelog";
  }
  
  public byte[] buildExtra()
  {
    try
    {
      byte[] arrayOfByte1 = FileUtils.toByteArray(getFilePath());
      byte[] arrayOfByte2 = arrayOfByte1;
      if (arrayOfByte1 == null) {
        arrayOfByte2 = new byte[0];
      }
      return arrayOfByte2;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      for (;;)
      {
        com.tencent.upload.common.b.e("MobileLogUploadTask", localFileNotFoundException.toString() + "path:" + getFilePath());
        Object localObject1 = null;
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        com.tencent.upload.common.b.e("MobileLogUploadTask", localIOException.toString() + "path:" + getFilePath());
        Object localObject2 = null;
      }
    }
  }
  
  protected com.tencent.upload.c.b getControlRequest()
  {
    Object localObject = this.vLoginData;
    AuthToken localAuthToken = new AuthToken(2, (byte[])localObject, this.vLoginKey, a.b().getAppId());
    StringBuilder localStringBuilder = new StringBuilder().append(" vLoginData.size:");
    if (localObject == null) {}
    for (localObject = "null";; localObject = Integer.valueOf(localObject.length))
    {
      com.tencent.upload.common.b.c("MobileLogUploadTask", localObject + " vLoginKey.size:" + this.vLoginKey.length);
      this.mCheckType = CheckType.TYPE_SHA1;
      this.mChecksum = "";
      buildEnv();
      this.mModel = UploadModel.MODEL_NORMAL;
      this.mStEnv = a.g();
      localObject = new com.tencent.upload.c.a.c(this.iUin + "", this.mAppid, localAuthToken, this.mChecksum, this.mCheckType, this.mDataLength, this.mStEnv, this.mModel, this.mSessionId, this.mNeedIpRedirect, true, this.iSync);
      ((com.tencent.upload.c.a.c)localObject).a(buildExtra());
      return localObject;
    }
  }
  
  public Const.b getFileType()
  {
    return Const.b.f;
  }
  
  public TaskTypeConfig getUploadTaskType()
  {
    return TaskTypeConfig.MobileLogUploadTaskType;
  }
  
  protected void onDestroy()
  {
    if (!this.mKeepFileAfterUpload) {
      FileUtils.deleteTempFile(this.mFilePath);
    }
  }
  
  protected void onFileControlResponse(JceStruct paramJceStruct, com.tencent.upload.c.c paramc)
  {
    if (paramJceStruct == null)
    {
      com.tencent.upload.common.b.b("MobileLogUploadTask", "onFileControlResponse rsp == null " + hashCode());
      onError(Const.UploadRetCode.RESPONSE_IS_NULL.getCode(), Const.UploadRetCode.RESPONSE_IS_NULL.getDesc());
      return;
    }
    paramJceStruct = (FileControlRsp)paramJceStruct;
    com.tencent.upload.common.b.b("[transfer] MobileLogUploadTask", "recv Response taskId=" + getTaskId() + " reqId=" + paramc.c() + " cmd=" + paramc.b() + " ret=" + paramJceStruct.result.ret + " flag=" + paramJceStruct.result.flag + " msg=" + paramJceStruct.result.msg + " retry=" + this.mRetryCount + " offset=" + paramJceStruct.offset + " slice_size=" + paramJceStruct.slice_size + " session=" + paramJceStruct.session);
    if (paramJceStruct.result.ret == 0)
    {
      paramJceStruct = new MobileLogUploadResult(this.iUin, this.flowId);
      if (this.uploadTaskCallback != null)
      {
        com.tencent.upload.common.b.b("MobileLogUploadTask", "onUploadSucceed flowid = " + this.flowId + " filepath = " + getFilePath());
        this.uploadTaskCallback.onUploadSucceed(this, paramJceStruct);
      }
    }
    for (;;)
    {
      processUploadLogRsp();
      return;
      if (this.uploadTaskCallback != null) {
        this.uploadTaskCallback.onUploadError(this, paramJceStruct.result.ret, paramJceStruct.result.msg);
      }
    }
  }
  
  protected void processUploadLogRsp()
  {
    setTaskStatus(com.tencent.upload.d.c.g);
    onTaskFinished(Const.UploadRetCode.SUCCEED.getCode(), Const.UploadRetCode.SUCCEED.getDesc());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.uinterface.data.MobileLogUploadTask
 * JD-Core Version:    0.7.0.1
 */