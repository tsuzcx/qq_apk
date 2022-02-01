package com.tencent.mobileqq.qqgamepub.api.impl;

import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;

public abstract class QQGamePreDownloadServiceImpl$DownloadListenerWrapper
  extends DownloadListener
{
  private DownloadListener a;
  
  public QQGamePreDownloadServiceImpl$DownloadListenerWrapper(DownloadListener paramDownloadListener)
  {
    this.a = paramDownloadListener;
  }
  
  public void onDoneFile(DownloadTask paramDownloadTask)
  {
    super.onDoneFile(paramDownloadTask);
    DownloadListener localDownloadListener = this.a;
    if (localDownloadListener != null) {
      localDownloadListener.onDoneFile(paramDownloadTask);
    }
  }
  
  public void onProgress(DownloadTask paramDownloadTask)
  {
    super.onProgress(paramDownloadTask);
    DownloadListener localDownloadListener = this.a;
    if (localDownloadListener != null) {
      localDownloadListener.onProgress(paramDownloadTask);
    }
  }
  
  public boolean onStart(DownloadTask paramDownloadTask)
  {
    DownloadListener localDownloadListener = this.a;
    if (localDownloadListener != null) {
      localDownloadListener.onStart(paramDownloadTask);
    }
    return super.onStart(paramDownloadTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.api.impl.QQGamePreDownloadServiceImpl.DownloadListenerWrapper
 * JD-Core Version:    0.7.0.1
 */