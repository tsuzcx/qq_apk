package com.tencent.mobileqq.intervideo.now.DownloadEngine;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

@QAPI(process={"all"})
@QRouteFactory(singleton=false)
public abstract interface INowDownloadManager
  extends QRouteApi
{
  public abstract void addDownloadListener(String paramString, IDownloadListener paramIDownloadListener);
  
  public abstract void addNowDownloadTask(Object paramObject);
  
  public abstract INowDownloadManager createObject(boolean paramBoolean);
  
  public abstract void init(Context paramContext);
  
  public abstract void removeDownloadListener(String paramString);
  
  public abstract void removeDownloadTask(String paramString, boolean paramBoolean);
  
  public abstract void startDownload(Object paramObject);
  
  public abstract void unInit();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.DownloadEngine.INowDownloadManager
 * JD-Core Version:    0.7.0.1
 */