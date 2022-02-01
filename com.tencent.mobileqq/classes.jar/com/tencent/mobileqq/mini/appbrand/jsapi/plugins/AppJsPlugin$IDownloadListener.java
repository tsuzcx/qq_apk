package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

public abstract interface AppJsPlugin$IDownloadListener
{
  public abstract void onDownloadComplete();
  
  public abstract void onDownloadFailed(int paramInt1, int paramInt2, String paramString);
  
  public abstract void onDownloadPause();
  
  public abstract void onDownloadProgress(long paramLong1, long paramLong2, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.AppJsPlugin.IDownloadListener
 * JD-Core Version:    0.7.0.1
 */