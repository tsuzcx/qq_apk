package com.tencent.mobileqq.mini.appbrand.page;

import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;

class ProgressWebView$6
  implements Downloader.DownloadListener
{
  ProgressWebView$6(ProgressWebView paramProgressWebView, String paramString) {}
  
  public void onDownloadCanceled(String paramString) {}
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    AppBrandTask.runTaskOnUiThread(new ProgressWebView.6.1(this));
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    AppBrandTask.runTaskOnUiThread(new ProgressWebView.6.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.ProgressWebView.6
 * JD-Core Version:    0.7.0.1
 */