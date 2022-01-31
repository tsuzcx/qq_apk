package com.tencent.mobileqq.filemanager.core;

import com.tencent.mobileqq.utils.httputils.HttpMsg;

public abstract interface ThumbHttpDownloader$WhatHappen
{
  public abstract void a(long paramLong, int paramInt, ThumbHttpDownloader.DownloadTask paramDownloadTask);
  
  public abstract void a(long paramLong, ThumbHttpDownloader.DownloadTask paramDownloadTask);
  
  public abstract void a(long paramLong, HttpMsg paramHttpMsg);
  
  public abstract void a(long paramLong, boolean paramBoolean, int paramInt, String paramString, ThumbHttpDownloader.DownloadTask paramDownloadTask);
  
  public abstract boolean a(long paramLong, ThumbHttpDownloader.DownloadTask paramDownloadTask);
  
  public abstract void b(long paramLong, ThumbHttpDownloader.DownloadTask paramDownloadTask);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.ThumbHttpDownloader.WhatHappen
 * JD-Core Version:    0.7.0.1
 */