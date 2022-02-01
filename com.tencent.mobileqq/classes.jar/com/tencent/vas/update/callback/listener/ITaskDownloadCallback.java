package com.tencent.vas.update.callback.listener;

public abstract interface ITaskDownloadCallback
{
  public abstract void notifyDownloadComplete(String paramString1, int paramInt1, int paramInt2, String paramString2);
  
  public abstract void notifyDownloadProgress(String paramString, long paramLong1, long paramLong2, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.vas.update.callback.listener.ITaskDownloadCallback
 * JD-Core Version:    0.7.0.1
 */