package com.tencent.mobileqq.mini.reuse;

import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;

class MiniappDownloadUtil$ProgressResampleDownloadListener
  implements Downloader.DownloadListener
{
  private final Downloader.DownloadListener delegatedListener;
  private float previousProgress;
  private final float progressResampleStep;
  
  MiniappDownloadUtil$ProgressResampleDownloadListener(Downloader.DownloadListener paramDownloadListener, float paramFloat)
  {
    this.delegatedListener = paramDownloadListener;
    this.progressResampleStep = paramFloat;
  }
  
  public void onDownloadCanceled(String paramString)
  {
    if (this.delegatedListener != null) {
      this.delegatedListener.onDownloadCanceled(paramString);
    }
  }
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    if (this.delegatedListener != null) {
      this.delegatedListener.onDownloadFailed(paramString, paramDownloadResult);
    }
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat)
  {
    if (paramFloat - this.previousProgress > this.progressResampleStep)
    {
      if (this.delegatedListener != null) {
        this.delegatedListener.onDownloadProgress(paramString, paramLong, paramFloat);
      }
      this.previousProgress = paramFloat;
    }
  }
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    if (this.delegatedListener != null) {
      this.delegatedListener.onDownloadSucceed(paramString, paramDownloadResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.reuse.MiniappDownloadUtil.ProgressResampleDownloadListener
 * JD-Core Version:    0.7.0.1
 */