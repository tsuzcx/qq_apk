package com.tencent.superplayer.api;

public abstract interface ISPlayerPreDownloader$Listener
{
  public abstract void onPrepareDownloadProgressUpdate(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2);
  
  public abstract void onPrepareError(int paramInt);
  
  public abstract void onPrepareSuccess(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.superplayer.api.ISPlayerPreDownloader.Listener
 * JD-Core Version:    0.7.0.1
 */