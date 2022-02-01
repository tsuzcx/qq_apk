package com.tencent.qqmini.miniapp.widget;

import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener.DownloadResult;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import java.util.List;
import java.util.Map;

class InnerWebView$9
  implements DownloaderProxy.DownloadListener
{
  InnerWebView$9(InnerWebView paramInnerWebView, String paramString) {}
  
  public void onDownloadFailed(int paramInt, String paramString)
  {
    AppBrandTask.runTaskOnUiThread(new InnerWebView.9.1(this));
  }
  
  public void onDownloadHeadersReceived(int paramInt, Map<String, List<String>> paramMap) {}
  
  public void onDownloadProgress(float paramFloat, long paramLong1, long paramLong2) {}
  
  public void onDownloadSucceed(int paramInt, String paramString, DownloaderProxy.DownloadListener.DownloadResult paramDownloadResult)
  {
    AppBrandTask.runTaskOnUiThread(new InnerWebView.9.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.InnerWebView.9
 * JD-Core Version:    0.7.0.1
 */