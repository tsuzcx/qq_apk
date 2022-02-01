package com.tencent.upload.uinterface.data;

import FileUpload.HeadDesc;
import FileUpload.UploadPicInfoRsp;
import SLICE_UPLOAD.UploadTouchuanReq;
import com.tencent.upload.network.session.SessionPool;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.TaskTypeConfig;
import com.tencent.upload.utils.JceEncoder;
import com.tencent.upload.utils.ProtocolUtil;
import com.tencent.upload.utils.UploadLog;

public class HeadUploadTask
  extends AbstractUploadTask
{
  public HeadUploadTask(String paramString)
  {
    super(paramString);
    this.mAppid = "touchuan";
    this.iSync = 0;
  }
  
  private byte[] getHeadDesc()
  {
    Object localObject = new HeadDesc();
    ((HeadDesc)localObject).portrait_type = 0L;
    ((HeadDesc)localObject).uc_platform_qzone_subid = 0L;
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
    UploadTouchuanReq localUploadTouchuanReq = new UploadTouchuanReq();
    localUploadTouchuanReq.iUploadType = getUploadTaskType().uploadType;
    localUploadTouchuanReq.vReqData = getHeadDesc();
    return JceEncoder.encode(localUploadTouchuanReq);
  }
  
  public TaskTypeConfig getUploadTaskType()
  {
    return TaskTypeConfig.HeadUploadTaskType;
  }
  
  public void processFileUploadFinishRsp(byte[] paramArrayOfByte)
  {
    UploadLog.d("AbstractUploadTask", "ImageUploadTask put <" + this.mOriginFilePath + "," + this.mSessionId + ">");
    SessionPool.recordSessionId(this.mOriginFilePath, this.mSessionId);
    Object localObject = new UploadPicInfoRsp();
    localObject = new ImageUploadResult(this.iUin, this.flowId, getBatchId(), (UploadPicInfoRsp)localObject);
    ((ImageUploadResult)localObject).sessionId = this.mSessionId;
    UploadLog.d("AbstractUploadTask", "onUploadSucceed flowid = " + this.flowId + " filepath = " + this.mFilePath);
    onUploadSucceed(localObject);
    super.processFileUploadFinishRsp(paramArrayOfByte);
    onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.upload.uinterface.data.HeadUploadTask
 * JD-Core Version:    0.7.0.1
 */