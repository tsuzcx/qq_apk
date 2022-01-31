package com.tencent.oskplayer.datasource;

public abstract interface DownloadListener
{
  public abstract void onEnd(String paramString);
  
  public abstract void onError(String paramString, int paramInt);
  
  public abstract void onStart(String paramString);
  
  public abstract void onTransfer(String paramString, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.oskplayer.datasource.DownloadListener
 * JD-Core Version:    0.7.0.1
 */