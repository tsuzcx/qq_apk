package com.tencent.weiyun.transmission.upload;

public abstract interface UploadManager$IUploadStatusListener
{
  public abstract void onUploadJobAdded(String paramString, long paramLong);
  
  public abstract void onUploadStatusChanged(String paramString, long paramLong, UploadJobContext.StatusInfo paramStatusInfo, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weiyun.transmission.upload.UploadManager.IUploadStatusListener
 * JD-Core Version:    0.7.0.1
 */