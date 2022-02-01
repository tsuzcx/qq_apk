package com.tencent.mobileqq.minigame.manager;

public abstract class AbstractDownloader
{
  protected AbstractDownloader.DownloadListener mDownloadListener;
  public String mUrl;
  
  public abstract void download();
  
  public void setDownloadListener(AbstractDownloader.DownloadListener paramDownloadListener)
  {
    this.mDownloadListener = paramDownloadListener;
  }
  
  public void setUrl(String paramString)
  {
    this.mUrl = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.AbstractDownloader
 * JD-Core Version:    0.7.0.1
 */