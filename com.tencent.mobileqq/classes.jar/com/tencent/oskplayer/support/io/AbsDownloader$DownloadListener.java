package com.tencent.oskplayer.support.io;

public abstract interface AbsDownloader$DownloadListener
{
  public abstract void onDownloadCanceled(String paramString);
  
  public abstract void onDownloadFailed(String paramString);
  
  public abstract void onDownloadProgress(String paramString, float paramFloat);
  
  public abstract void onDownloadSucceed(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.oskplayer.support.io.AbsDownloader.DownloadListener
 * JD-Core Version:    0.7.0.1
 */