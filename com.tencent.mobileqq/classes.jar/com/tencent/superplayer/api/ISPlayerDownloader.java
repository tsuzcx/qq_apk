package com.tencent.superplayer.api;

public abstract interface ISPlayerDownloader
{
  public abstract int startOfflineDownload(SuperPlayerVideoInfo paramSuperPlayerVideoInfo, ISPlayerDownloader.Listener paramListener);
  
  public abstract void stopOfflineDownload(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.superplayer.api.ISPlayerDownloader
 * JD-Core Version:    0.7.0.1
 */