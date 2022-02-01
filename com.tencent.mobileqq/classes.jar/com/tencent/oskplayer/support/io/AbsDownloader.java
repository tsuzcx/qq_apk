package com.tencent.oskplayer.support.io;

public abstract class AbsDownloader
{
  protected AbsDownloader.DownloadListener mDownloadListener;
  protected String mUrl;
  
  protected AbsDownloader(String paramString)
  {
    this(paramString, null);
  }
  
  protected AbsDownloader(String paramString, AbsDownloader.DownloadListener paramDownloadListener)
  {
    this.mUrl = paramString;
    this.mDownloadListener = paramDownloadListener;
  }
  
  public abstract void download();
  
  public void setDownloadListener(AbsDownloader.DownloadListener paramDownloadListener)
  {
    this.mDownloadListener = paramDownloadListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.oskplayer.support.io.AbsDownloader
 * JD-Core Version:    0.7.0.1
 */