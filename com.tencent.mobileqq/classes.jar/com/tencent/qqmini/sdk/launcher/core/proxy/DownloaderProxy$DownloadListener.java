package com.tencent.qqmini.sdk.launcher.core.proxy;

import java.util.List;
import java.util.Map;

public abstract interface DownloaderProxy$DownloadListener
{
  public abstract void onDownloadFailed(int paramInt, String paramString);
  
  public abstract void onDownloadHeadersReceived(int paramInt, Map<String, List<String>> paramMap);
  
  public abstract void onDownloadProgress(float paramFloat, long paramLong1, long paramLong2);
  
  public abstract void onDownloadSucceed(int paramInt, String paramString, DownloaderProxy.DownloadListener.DownloadResult paramDownloadResult);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
 * JD-Core Version:    0.7.0.1
 */