package com.tencent.qqmini.sdk.launcher.core.proxy;

public abstract interface ThirdAppProxy$AppDownloadListener
{
  public abstract void onDownloadComplete();
  
  public abstract void onDownloadFailed(int paramInt1, int paramInt2, String paramString);
  
  public abstract void onDownloadProgress(long paramLong1, long paramLong2, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.proxy.ThirdAppProxy.AppDownloadListener
 * JD-Core Version:    0.7.0.1
 */