package com.tencent.smtt.utils;

public abstract interface DebugTbsPlugin$DebugDownloadStatusListener
{
  public abstract void onDownloadFailure(Throwable paramThrowable);
  
  public abstract void onDownloadProgress(int paramInt);
  
  public abstract void onDownloadSuccess();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.smtt.utils.DebugTbsPlugin.DebugDownloadStatusListener
 * JD-Core Version:    0.7.0.1
 */