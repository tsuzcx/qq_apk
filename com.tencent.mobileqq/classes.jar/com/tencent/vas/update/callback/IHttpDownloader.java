package com.tencent.vas.update.callback;

import android.os.Bundle;
import com.tencent.vas.update.callback.listener.IDownloadListener;
import com.tencent.vas.update.entity.DownloadInfoParams;

public abstract interface IHttpDownloader
{
  public abstract void cancelDownload(String paramString);
  
  public abstract void startDownload(DownloadInfoParams paramDownloadInfoParams, IDownloadListener paramIDownloadListener, Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.vas.update.callback.IHttpDownloader
 * JD-Core Version:    0.7.0.1
 */