package com.tencent.oskplayer.datasource;

public abstract interface VideoDownloadListener
{
  public abstract void onCancel(String paramString);
  
  public abstract void onError(String paramString, int paramInt);
  
  public abstract boolean onProgress(String paramString, long paramLong1, long paramLong2);
  
  public abstract void onStart(String paramString);
  
  public abstract void onSuccess(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.oskplayer.datasource.VideoDownloadListener
 * JD-Core Version:    0.7.0.1
 */