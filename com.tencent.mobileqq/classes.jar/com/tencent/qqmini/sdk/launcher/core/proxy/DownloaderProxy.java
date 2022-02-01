package com.tencent.qqmini.sdk.launcher.core.proxy;

import java.util.Map;

public abstract class DownloaderProxy
{
  public abstract void abort(String paramString);
  
  public abstract boolean download(String paramString1, Map<String, String> paramMap, String paramString2, int paramInt, DownloaderProxy.DownloadListener paramDownloadListener);
  
  public void getLameMp3SoDownloadPath(DownloaderProxy.LameMp3SoDownloadListener paramLameMp3SoDownloadListener) {}
  
  public void getWebAudioDownloadPath(DownloaderProxy.WebAudioDownloadListener paramWebAudioDownloadListener) {}
  
  public abstract void preConnectDownloadHost();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy
 * JD-Core Version:    0.7.0.1
 */