package com.tencent.upload.uinterface.data;

import com.tencent.upload.uinterface.TaskTypeConfig;

public class LiveVideoUploadTask
  extends VideoUploadTask
{
  public LiveVideoUploadTask(String paramString)
  {
    super(paramString);
    setIsNew(109);
    this.mAppid = "c2cvideo";
    this.iSync = 0;
  }
  
  public TaskTypeConfig getUploadTaskType()
  {
    return TaskTypeConfig.LiveVideoUploadTaskType;
  }
  
  public boolean onVerifyUploadFile()
  {
    return super.onVerifyUploadFile();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.uinterface.data.LiveVideoUploadTask
 * JD-Core Version:    0.7.0.1
 */