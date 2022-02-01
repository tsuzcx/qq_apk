package com.tencent.superplayer.api;

public abstract interface ISPlayerPreDownloader
{
  public abstract void destory();
  
  public abstract void setOnPreDownloadListener(ISPlayerPreDownloader.Listener paramListener);
  
  public abstract int startPreDownload(SuperPlayerVideoInfo paramSuperPlayerVideoInfo, long paramLong);
  
  public abstract int startPreDownload(SuperPlayerVideoInfo paramSuperPlayerVideoInfo, long paramLong1, long paramLong2);
  
  public abstract int startPreDownload(SuperPlayerVideoInfo paramSuperPlayerVideoInfo, long paramLong1, long paramLong2, SuperPlayerDownOption paramSuperPlayerDownOption);
  
  public abstract int startPreDownload(SuperPlayerVideoInfo paramSuperPlayerVideoInfo, long paramLong, SuperPlayerDownOption paramSuperPlayerDownOption);
  
  public abstract void stopAllPreDownload();
  
  public abstract void stopPreDownload(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.superplayer.api.ISPlayerPreDownloader
 * JD-Core Version:    0.7.0.1
 */