package com.tencent.mobileqq.triton.sdk.download;

public abstract interface ITDownloadListener
{
  public abstract void onCancel(String paramString);
  
  public abstract void onFail(String paramString1, int paramInt, String paramString2);
  
  public abstract void onProgress(String paramString, long paramLong, float paramFloat);
  
  public abstract void onSuccess(String paramString1, int paramInt, String paramString2, String paramString3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.triton.sdk.download.ITDownloadListener
 * JD-Core Version:    0.7.0.1
 */