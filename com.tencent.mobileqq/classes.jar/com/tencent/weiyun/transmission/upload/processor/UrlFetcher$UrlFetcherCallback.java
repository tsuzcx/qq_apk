package com.tencent.weiyun.transmission.upload.processor;

import com.tencent.weiyun.transmission.upload.UploadFile;

public abstract interface UrlFetcher$UrlFetcherCallback
{
  public abstract void onFetchError(long paramLong, int paramInt, String paramString);
  
  public abstract void onFetchSuccess(long paramLong, UploadFile paramUploadFile);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.weiyun.transmission.upload.processor.UrlFetcher.UrlFetcherCallback
 * JD-Core Version:    0.7.0.1
 */