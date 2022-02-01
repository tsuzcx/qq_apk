package com.tencent.qqmini.sdk.launcher.core.proxy;

import org.json.JSONObject;

public abstract class ThirdAppProxy
{
  public abstract void init();
  
  public abstract boolean installApp(String paramString, AsyncResult paramAsyncResult);
  
  public abstract void queryApkDownloadInfo(String paramString, AsyncResult paramAsyncResult);
  
  public abstract void queryDownloadTask(String paramString, AsyncResult paramAsyncResult);
  
  public abstract void startDownload(String paramString, JSONObject paramJSONObject, boolean paramBoolean, ThirdAppProxy.AppDownloadListener paramAppDownloadListener);
  
  public abstract boolean stopDownloadTask(String paramString);
  
  public abstract void unInit();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.proxy.ThirdAppProxy
 * JD-Core Version:    0.7.0.1
 */