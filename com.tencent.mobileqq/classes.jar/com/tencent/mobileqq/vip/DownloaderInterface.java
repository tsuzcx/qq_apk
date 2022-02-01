package com.tencent.mobileqq.vip;

import android.os.Bundle;

public abstract interface DownloaderInterface
{
  public abstract int cancelTask(boolean paramBoolean, String paramString);
  
  public abstract DownloadTask getTask(String paramString);
  
  public abstract void onDestroy();
  
  public abstract void startDownload(DownloadTask paramDownloadTask, DownloadListener paramDownloadListener, Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vip.DownloaderInterface
 * JD-Core Version:    0.7.0.1
 */