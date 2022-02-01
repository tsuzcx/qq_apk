package com.tencent.mobileqq.intervideo.now.DownloadEngine.impl;

import android.content.Context;
import com.tencent.mobileqq.intervideo.now.DownloadEngine.IDownloadListener;
import com.tencent.mobileqq.intervideo.now.DownloadEngine.INowDownloadManager;
import com.tencent.mobileqq.intervideo.now.DownloadEngine.NowDownloadManager;

public class NowDownloadManagerImpl
  implements INowDownloadManager
{
  private NowDownloadManager nowDownloadManager;
  
  public void addDownloadListener(String paramString, IDownloadListener paramIDownloadListener)
  {
    this.nowDownloadManager.a(paramString, paramIDownloadListener);
  }
  
  public void addNowDownloadTask(Object paramObject)
  {
    this.nowDownloadManager.a((NowDownloadTaskInfo)paramObject);
  }
  
  public INowDownloadManager createObject(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.nowDownloadManager = NowDownloadManager.b;
      return this;
    }
    this.nowDownloadManager = new NowDownloadManager();
    return this;
  }
  
  public void init(Context paramContext)
  {
    this.nowDownloadManager.a(paramContext);
  }
  
  public void removeDownloadListener(String paramString)
  {
    this.nowDownloadManager.a(paramString);
  }
  
  public void removeDownloadTask(String paramString, boolean paramBoolean)
  {
    this.nowDownloadManager.a(paramString, paramBoolean);
  }
  
  public void startDownload(Object paramObject)
  {
    this.nowDownloadManager.b((NowDownloadTaskInfo)paramObject);
  }
  
  public void unInit()
  {
    this.nowDownloadManager.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.DownloadEngine.impl.NowDownloadManagerImpl
 * JD-Core Version:    0.7.0.1
 */