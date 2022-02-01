package com.tencent.weiyun.uploader.xplatform;

public abstract interface UploadSDKContext$IUploadSDKCallback
{
  public abstract void uploadCancelled(String paramString);
  
  public abstract void uploadFinish(String paramString1, int paramInt, String paramString2);
  
  public abstract void uploadProgress(String paramString, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.weiyun.uploader.xplatform.UploadSDKContext.IUploadSDKCallback
 * JD-Core Version:    0.7.0.1
 */