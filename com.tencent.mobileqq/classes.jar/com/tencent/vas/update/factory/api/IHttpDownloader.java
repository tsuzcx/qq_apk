package com.tencent.vas.update.factory.api;

import android.os.Bundle;
import com.tencent.vas.update.callback.listener.IDownloadListener;
import com.tencent.vas.update.entity.DownloadInfoParams;

public abstract interface IHttpDownloader
{
  public abstract void a(DownloadInfoParams paramDownloadInfoParams, IDownloadListener paramIDownloadListener, Bundle paramBundle);
  
  public abstract void a(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.vas.update.factory.api.IHttpDownloader
 * JD-Core Version:    0.7.0.1
 */