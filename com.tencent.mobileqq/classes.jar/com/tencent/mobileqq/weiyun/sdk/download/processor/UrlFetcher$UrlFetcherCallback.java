package com.tencent.mobileqq.weiyun.sdk.download.processor;

import com.tencent.mobileqq.weiyun.model.DownloadFile.DownloadServerInfo;

public abstract interface UrlFetcher$UrlFetcherCallback
{
  public abstract void a(long paramLong, int paramInt, String paramString);
  
  public abstract void a(long paramLong, DownloadFile.DownloadServerInfo paramDownloadServerInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.sdk.download.processor.UrlFetcher.UrlFetcherCallback
 * JD-Core Version:    0.7.0.1
 */