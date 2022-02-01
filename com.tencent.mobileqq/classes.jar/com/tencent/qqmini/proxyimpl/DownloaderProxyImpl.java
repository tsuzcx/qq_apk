package com.tencent.qqmini.proxyimpl;

import com.tencent.mobileqq.minigame.manager.FileDownloadManager;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.LameMp3SoDownloadListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.WebAudioDownloadListener;
import java.util.Map;

@ProxyService(proxy=DownloaderProxy.class)
public class DownloaderProxyImpl
  extends DownloaderProxy
{
  public void abort(String paramString)
  {
    FileDownloadManager.abort(paramString);
  }
  
  public boolean download(String paramString1, Map<String, String> paramMap, String paramString2, int paramInt, DownloaderProxy.DownloadListener paramDownloadListener)
  {
    return FileDownloadManager.download(paramString1, paramMap, paramString2, paramInt, paramDownloadListener);
  }
  
  public void getLameMp3SoDownloadPath(DownloaderProxy.LameMp3SoDownloadListener paramLameMp3SoDownloadListener)
  {
    FileDownloadManager.getLameMp3SoDownloadPath(paramLameMp3SoDownloadListener);
  }
  
  public void getWebAudioDownloadPath(DownloaderProxy.WebAudioDownloadListener paramWebAudioDownloadListener)
  {
    FileDownloadManager.getWebAudioDownloadPath(paramWebAudioDownloadListener);
  }
  
  public void preConnectDownloadHost() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.DownloaderProxyImpl
 * JD-Core Version:    0.7.0.1
 */