package com.tencent.upload.common;

import android.util.Log;
import com.tencent.upload.uinterface.IUploadLog;

public class b
{
  public static void a(String paramString1, String paramString2)
  {
    IUploadLog localIUploadLog = a.d();
    if (localIUploadLog == null)
    {
      Log.v("[upload2] " + paramString1, paramString2);
      return;
    }
    localIUploadLog.v("[upload2] " + paramString1, paramString2);
  }
  
  public static void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    IUploadLog localIUploadLog = a.d();
    if (localIUploadLog == null)
    {
      Log.i("[upload2] " + paramString1, paramString2, paramThrowable);
      return;
    }
    localIUploadLog.i("[upload2] " + paramString1, paramString2, paramThrowable);
  }
  
  public static void a(String paramString, Throwable paramThrowable)
  {
    IUploadLog localIUploadLog = a.d();
    if (localIUploadLog == null)
    {
      Log.w("[upload2] " + paramString, paramThrowable);
      return;
    }
    localIUploadLog.w("[upload2] " + paramString, paramThrowable);
  }
  
  public static void b(String paramString1, String paramString2)
  {
    IUploadLog localIUploadLog = a.d();
    if (localIUploadLog == null)
    {
      Log.d("[upload2] " + paramString1, paramString2);
      return;
    }
    localIUploadLog.d("[upload2] " + paramString1, paramString2);
  }
  
  public static void b(String paramString1, String paramString2, Throwable paramThrowable)
  {
    IUploadLog localIUploadLog = a.d();
    if (localIUploadLog == null)
    {
      Log.w("[upload2] " + paramString1, paramString2, paramThrowable);
      return;
    }
    localIUploadLog.w("[upload2] " + paramString1, paramString2, paramThrowable);
  }
  
  public static void c(String paramString1, String paramString2)
  {
    IUploadLog localIUploadLog = a.d();
    if (localIUploadLog == null)
    {
      Log.i("[upload2] " + paramString1, paramString2);
      return;
    }
    localIUploadLog.i("[upload2] " + paramString1, paramString2);
  }
  
  public static void c(String paramString1, String paramString2, Throwable paramThrowable)
  {
    IUploadLog localIUploadLog = a.d();
    if (localIUploadLog == null)
    {
      Log.e("[upload2] " + paramString1, paramString2, paramThrowable);
      return;
    }
    localIUploadLog.e("[upload2] " + paramString1, paramString2, paramThrowable);
  }
  
  public static void d(String paramString1, String paramString2)
  {
    IUploadLog localIUploadLog = a.d();
    if (localIUploadLog == null)
    {
      Log.w("[upload2] " + paramString1, paramString2);
      return;
    }
    localIUploadLog.w("[upload2] " + paramString1, paramString2);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    IUploadLog localIUploadLog = a.d();
    if (localIUploadLog == null)
    {
      Log.e("[upload2] " + paramString1, paramString2);
      return;
    }
    localIUploadLog.e("[upload2] " + paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.common.b
 * JD-Core Version:    0.7.0.1
 */