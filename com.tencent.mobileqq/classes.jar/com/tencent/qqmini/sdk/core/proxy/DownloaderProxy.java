package com.tencent.qqmini.sdk.core.proxy;

import java.util.Map;

public abstract class DownloaderProxy
{
  public abstract void abort(String paramString);
  
  public abstract boolean download(String paramString1, Map<String, String> paramMap, String paramString2, int paramInt, DownloaderProxy.DownloadListener paramDownloadListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.DownloaderProxy
 * JD-Core Version:    0.7.0.1
 */