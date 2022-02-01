package com.tencent.vas.update.callback.listener;

public abstract interface IDownloadListener
{
  public abstract void onCompleted(String paramString1, int paramInt1, int paramInt2, String paramString2);
  
  public abstract void onDownloadStart(String paramString);
  
  public abstract void onProgress(String paramString, long paramLong1, long paramLong2, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.vas.update.callback.listener.IDownloadListener
 * JD-Core Version:    0.7.0.1
 */