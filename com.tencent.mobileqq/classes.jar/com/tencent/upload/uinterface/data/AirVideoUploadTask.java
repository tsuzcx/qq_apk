package com.tencent.upload.uinterface.data;

import com.tencent.upload.uinterface.TaskTypeConfig;

public class AirVideoUploadTask
  extends VideoUploadTask
{
  public AirVideoUploadTask(String paramString)
  {
    super(paramString);
    this.iIsNew = 109;
  }
  
  public TaskTypeConfig getUploadTaskType()
  {
    return TaskTypeConfig.AirVideoUploadTaskType;
  }
  
  public boolean onVerifyUploadFile()
  {
    return super.onVerifyUploadFile();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.uinterface.data.AirVideoUploadTask
 * JD-Core Version:    0.7.0.1
 */