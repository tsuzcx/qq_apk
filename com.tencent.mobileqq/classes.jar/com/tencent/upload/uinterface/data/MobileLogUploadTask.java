package com.tencent.upload.uinterface.data;

import SLICE_UPLOAD.AuthToken;
import SLICE_UPLOAD.CheckType;
import SLICE_UPLOAD.FileControlRsp;
import SLICE_UPLOAD.UploadModel;
import SLICE_UPLOAD.stResult;
import com.qq.taf.jce.JceStruct;
import com.tencent.upload.common.UploadGlobalConfig;
import com.tencent.upload.request.UploadRequest;
import com.tencent.upload.request.UploadResponse;
import com.tencent.upload.request.impl.FileControlRequest;
import com.tencent.upload.task.TaskState;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadTaskCallback;
import com.tencent.upload.uinterface.TaskTypeConfig;
import com.tencent.upload.uinterface.token.TokenProvider;
import com.tencent.upload.utils.Const.FileType;
import com.tencent.upload.utils.Const.UploadRetCode;
import com.tencent.upload.utils.FileUtils;
import com.tencent.upload.utils.UploadLog;
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
      byte[] arrayOfByte = FileUtils.toByteArray(getFilePath());
    }
    catch (IOException localIOException)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(localIOException.toString());
      ((StringBuilder)localObject2).append("path:");
      ((StringBuilder)localObject2).append(getFilePath());
      UploadLog.e("MobileLogUploadTask", ((StringBuilder)localObject2).toString());
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(localFileNotFoundException.toString());
      ((StringBuilder)localObject2).append("path:");
      ((StringBuilder)localObject2).append(getFilePath());
      UploadLog.e("MobileLogUploadTask", ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = null;
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new byte[0];
    }
    return localObject2;
  }
  
  protected UploadRequest getControlRequest()
  {
    Object localObject = TokenProvider.getAuthToken(this.vLoginData, this.vLoginKey);
    this.mCheckType = CheckType.TYPE_SHA1;
    this.mChecksum = "";
    buildEnv();
    this.mModel = UploadModel.MODEL_NORMAL;
    this.mStEnv = UploadGlobalConfig.getEnv();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.iUin);
    localStringBuilder.append("");
    localObject = new FileControlRequest(localStringBuilder.toString(), this.mAppid, (AuthToken)localObject, this.mChecksum, this.mCheckType, this.mDataLength, this.mStEnv, this.mModel, this.mSessionId, this.mNeedIpRedirect, true, this.iSync, null, this.mExtend_info);
    ((FileControlRequest)localObject).setExtraParam(buildExtra());
    return localObject;
  }
  
  public Const.FileType getFileType()
  {
    return Const.FileType.Log;
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
  
  protected void onFileControlResponse(JceStruct paramJceStruct, UploadResponse paramUploadResponse)
  {
    if (paramJceStruct == null)
    {
      paramJceStruct = new StringBuilder();
      paramJceStruct.append("onFileControlResponse rsp == null ");
      paramJceStruct.append(hashCode());
      UploadLog.d("MobileLogUploadTask", paramJceStruct.toString());
      onError(Const.UploadRetCode.RESPONSE_IS_NULL.getCode(), Const.UploadRetCode.RESPONSE_IS_NULL.getDesc());
      return;
    }
    paramJceStruct = (FileControlRsp)paramJceStruct;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("recv Response taskId=");
    localStringBuilder.append(getTaskId());
    localStringBuilder.append(" reqId=");
    localStringBuilder.append(paramUploadResponse.getRequestSequence());
    localStringBuilder.append(" cmd=");
    localStringBuilder.append(paramUploadResponse.getCmd());
    localStringBuilder.append(" ret=");
    localStringBuilder.append(paramJceStruct.result.ret);
    localStringBuilder.append(" flag=");
    localStringBuilder.append(paramJceStruct.result.flag);
    localStringBuilder.append(" msg=");
    localStringBuilder.append(paramJceStruct.result.msg);
    localStringBuilder.append(" retry=");
    localStringBuilder.append(this.mRetryCount);
    localStringBuilder.append(" offset=");
    localStringBuilder.append(paramJceStruct.offset);
    localStringBuilder.append(" slice_size=");
    localStringBuilder.append(paramJceStruct.slice_size);
    localStringBuilder.append(" session=");
    localStringBuilder.append(paramJceStruct.session);
    UploadLog.d("[transfer] MobileLogUploadTask", localStringBuilder.toString());
    if (paramJceStruct.result.ret == 0)
    {
      paramJceStruct = new MobileLogUploadResult(this.iUin, this.flowId);
      if (this.uploadTaskCallback != null)
      {
        paramUploadResponse = new StringBuilder();
        paramUploadResponse.append("onUploadSucceed flowid = ");
        paramUploadResponse.append(this.flowId);
        paramUploadResponse.append(" filepath = ");
        paramUploadResponse.append(getFilePath());
        UploadLog.d("MobileLogUploadTask", paramUploadResponse.toString());
        this.uploadTaskCallback.onUploadSucceed(this, paramJceStruct);
      }
    }
    else if (this.uploadTaskCallback != null)
    {
      this.uploadTaskCallback.onUploadError(this, paramJceStruct.result.ret, paramJceStruct.result.msg);
    }
    processUploadLogRsp();
  }
  
  protected void processUploadLogRsp()
  {
    setTaskStatus(TaskState.SUCCEED);
    onTaskFinished(Const.UploadRetCode.SUCCEED.getCode(), Const.UploadRetCode.SUCCEED.getDesc());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.upload.uinterface.data.MobileLogUploadTask
 * JD-Core Version:    0.7.0.1
 */