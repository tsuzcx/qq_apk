package com.tencent.mobileqq.minigame.manager;

import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;

class DefaultDownloader$1
  implements Downloader.DownloadListener
{
  DefaultDownloader$1(DefaultDownloader paramDefaultDownloader, String paramString) {}
  
  public void onDownloadCanceled(String paramString)
  {
    if (this.this$0.mDownloadListener != null) {
      this.this$0.mDownloadListener.onDownloadCanceled(paramString);
    }
  }
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    if (this.this$0.mDownloadListener != null) {
      this.this$0.mDownloadListener.onDownloadFailed(paramString);
    }
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat)
  {
    if (this.this$0.mDownloadListener != null) {
      this.this$0.mDownloadListener.onDownloadProgress(paramString, paramFloat);
    }
  }
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    if (this.this$0.mDownloadListener != null) {
      this.this$0.mDownloadListener.onDownloadSucceed(paramString, this.val$tmpZipFile);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.DefaultDownloader.1
 * JD-Core Version:    0.7.0.1
 */