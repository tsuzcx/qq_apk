package com.tencent.mobileqq.winkpublish.fs.task;

import FileUpload.UploadPicInfoReq;
import com.tencent.upload.uinterface.TaskTypeConfig;
import com.tencent.upload.uinterface.data.ImageUploadTask;

public class QCircleImageUploadTask
  extends ImageUploadTask
{
  public QCircleImageUploadTask(boolean paramBoolean, String paramString)
  {
    super(paramBoolean, paramString);
    this.mAppid = "circle_photo";
  }
  
  public UploadPicInfoReq createUploadPicInfoReq()
  {
    UploadPicInfoReq localUploadPicInfoReq = super.createUploadPicInfoReq();
    localUploadPicInfoReq.iAlbumTypeID = 32;
    return localUploadPicInfoReq;
  }
  
  public TaskTypeConfig getUploadTaskType()
  {
    return TaskTypeConfig.ImageUploadTaskType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.fs.task.QCircleImageUploadTask
 * JD-Core Version:    0.7.0.1
 */