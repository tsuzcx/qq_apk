package com.tencent.mobileqq.filemanager.core;

import com.tencent.mobileqq.utils.httputils.HttpMsg;

public abstract interface IHttpUploadSink
{
  public abstract void a(int paramInt, String paramString);
  
  public abstract void a(int paramInt, String paramString1, String paramString2);
  
  public abstract void a(long paramLong, String paramString);
  
  public abstract void a(HttpMsg paramHttpMsg);
  
  public abstract void a(String paramString);
  
  public abstract void b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.IHttpUploadSink
 * JD-Core Version:    0.7.0.1
 */