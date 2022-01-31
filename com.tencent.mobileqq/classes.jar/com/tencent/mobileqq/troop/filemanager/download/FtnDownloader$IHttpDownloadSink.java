package com.tencent.mobileqq.troop.filemanager.download;

import com.tencent.mobileqq.utils.httputils.HttpMsg;

public abstract interface FtnDownloader$IHttpDownloadSink
{
  public abstract void a();
  
  public abstract void a(int paramInt, String paramString1, String paramString2);
  
  public abstract void a(HttpMsg paramHttpMsg);
  
  public abstract void a(String paramString);
  
  public abstract void a(byte[] paramArrayOfByte, long paramLong, String paramString);
  
  public abstract void b(HttpMsg paramHttpMsg);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.download.FtnDownloader.IHttpDownloadSink
 * JD-Core Version:    0.7.0.1
 */