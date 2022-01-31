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
        UploadLog.e("MobileLogUploadTask", localFileNotFoundException.toString() + "path:" + getFilePath());
        Object localObject1 = null;
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        UploadLog.e("MobileLogUploadTask", localIOException.toString() + "path:" + getFilePath());
        Object localObject2 = null;
      }
    }
  }
  
  public UploadRequest getControlRequest()
  {
    Object localObject = TokenProvider.getAuthToken(this.vLoginData, this.vLoginKey);
    this.mCheckType = CheckType.TYPE_SHA1;
    this.mChecksum = "";
    buildEnv();
    this.mModel = UploadModel.MODEL_NORMAL;
    this.mStEnv = UploadGlobalConfig.getEnv();
    localObject = new FileControlRequest(this.iUin + "", this.mAppid, (AuthToken)localObject, this.mChecksum, this.mCheckType, this.mDataLength, this.mStEnv, this.mModel, this.mSessionId, this.mNeedIpRedirect, true, this.iSync, null);
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
  
  public void onDestroy()
  {
    if (!this.mKeepFileAfterUpload) {
      FileUtils.deleteTempFile(this.mFilePath);
    }
  }
  
  public void onFileControlResponse(JceStruct paramJceStruct, UploadResponse paramUploadResponse)
  {
    if (paramJceStruct == null)
    {
      UploadLog.d("MobileLogUploadTask", "onFileControlResponse rsp == null " + hashCode());
      onError(Const.UploadRetCode.RESPONSE_IS_NULL.getCode(), Const.UploadRetCode.RESPONSE_IS_NULL.getDesc());
      return;
    }
    paramJceStruct = (FileControlRsp)paramJceStruct;
    UploadLog.d("[transfer] MobileLogUploadTask", "recv Response taskId=" + getTaskId() + " reqId=" + paramUploadResponse.getRequestSequence() + " cmd=" + paramUploadResponse.getCmd() + " ret=" + paramJceStruct.result.ret + " flag=" + paramJceStruct.result.flag + " msg=" + paramJceStruct.result.msg + " retry=" + this.mRetryCount + " offset=" + paramJceStruct.offset + " slice_size=" + paramJceStruct.slice_size + " session=" + paramJceStruct.session);
    if (paramJceStruct.result.ret == 0)
    {
      paramJceStruct = new MobileLogUploadResult(this.iUin, this.flowId);
      if (this.uploadTaskCallback != null)
      {
        UploadLog.d("MobileLogUploadTask", "onUploadSucceed flowid = " + this.flowId + " filepath = " + getFilePath());
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
    setTaskStatus(TaskState.SUCCEED);
    onTaskFinished(Const.UploadRetCode.SUCCEED.getCode(), Const.UploadRetCode.SUCCEED.getDesc());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.uinterface.data.MobileLogUploadTask
 * JD-Core Version:    0.7.0.1
 */