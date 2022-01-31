package com.tencent.superplayer.api;

public abstract interface ISPlayerPreLoader
{
  public abstract void destory();
  
  public abstract void setPreDownloadListener(ISPlayerPreLoader.Listener paramListener);
  
  public abstract void startPreDownload(SuperPlayerVideoInfo paramSuperPlayerVideoInfo, long paramLong);
  
  public abstract void startPreDownload(SuperPlayerVideoInfo paramSuperPlayerVideoInfo, long paramLong1, long paramLong2, long paramLong3);
  
  public abstract void stopPreDownload(SuperPlayerVideoInfo paramSuperPlayerVideoInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.superplayer.api.ISPlayerPreLoader
 * JD-Core Version:    0.7.0.1
 */