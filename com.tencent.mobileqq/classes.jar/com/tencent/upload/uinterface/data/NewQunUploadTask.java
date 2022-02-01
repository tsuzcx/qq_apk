package com.tencent.upload.uinterface.data;

import FileUpload.UploadPicInfoReq;
import com.tencent.upload.uinterface.TaskTypeConfig;
import java.util.Map;

public class NewQunUploadTask
  extends ImageUploadTask
{
  public byte[] a2_key = null;
  public String appid = "";
  public String userid = "";
  
  public NewQunUploadTask(String paramString)
  {
    super(false, paramString);
    this.mAppid = "qun";
  }
  
  public UploadPicInfoReq createUploadPicInfoReq()
  {
    UploadPicInfoReq localUploadPicInfoReq = super.createUploadPicInfoReq();
    localUploadPicInfoReq.mapExt.put("userid", this.userid);
    localUploadPicInfoReq.mapExt.put("a2_key", new String(this.a2_key));
    return localUploadPicInfoReq;
  }
  
  public TaskTypeConfig getUploadTaskType()
  {
    return TaskTypeConfig.NewQunUploadTaskType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.upload.uinterface.data.NewQunUploadTask
 * JD-Core Version:    0.7.0.1
 */