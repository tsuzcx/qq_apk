package com.tencent.weiyun.uploader;

public abstract interface IUploader$IUploadListener
{
  public abstract void onUploadCanceled(UploadRequest paramUploadRequest);
  
  public abstract void onUploadFinished(UploadRequest paramUploadRequest, boolean paramBoolean, UploadResponse paramUploadResponse);
  
  public abstract void onUploadProgress(UploadRequest paramUploadRequest, long paramLong1, float paramFloat, long paramLong2, long paramLong3, long paramLong4);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.weiyun.uploader.IUploader.IUploadListener
 * JD-Core Version:    0.7.0.1
 */