package com.tencent.upload.utils;

import android.util.Log;
import com.tencent.upload.common.UploadGlobalConfig;
import com.tencent.upload.uinterface.IUploadLog;

public class UploadLog
{
  public static final boolean ABSTRACT_ROUTE_STRATEGY_FLAG = true;
  public static final boolean DOMAIN_NAME_PARSER_FLAG = true;
  public static final boolean NATIVE_CONNECTION_FLAG = true;
  public static final boolean RECENT_ROUTE_SET_STORAGE_FLAG = true;
  public static final boolean SESSION_LOG_ENABLE = true;
  public static final boolean TASK_LOG_ENABLE = true;
  public static final boolean UPLOAD_CONFIGURATION_FLAG = true;
  public static final String UPLOAD_TAG_PREFIX = "[upload2] ";
  
  public static void d(String paramString1, String paramString2)
  {
    IUploadLog localIUploadLog = UploadGlobalConfig.getUploadLog();
    if (localIUploadLog == null)
    {
      Log.d("[upload2] " + paramString1, paramString2);
      return;
    }
    localIUploadLog.d("[upload2] " + paramString1, paramString2);
  }
  
  public static void d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    IUploadLog localIUploadLog = UploadGlobalConfig.getUploadLog();
    if (localIUploadLog == null)
    {
      Log.d("[upload2] " + paramString1, paramString2, paramThrowable);
      return;
    }
    localIUploadLog.d("[upload2] " + paramString1, paramString2, paramThrowable);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    IUploadLog localIUploadLog = UploadGlobalConfig.getUploadLog();
    if (localIUploadLog == null)
    {
      Log.e("[upload2] " + paramString1, paramString2);
      return;
    }
    localIUploadLog.e("[upload2] " + paramString1, paramString2);
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    IUploadLog localIUploadLog = UploadGlobalConfig.getUploadLog();
    if (localIUploadLog == null)
    {
      Log.e("[upload2] " + paramString1, paramString2, paramThrowable);
      return;
    }
    localIUploadLog.e("[upload2] " + paramString1, paramString2, paramThrowable);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    IUploadLog localIUploadLog = UploadGlobalConfig.getUploadLog();
    if (localIUploadLog == null)
    {
      Log.i("[upload2] " + paramString1, paramString2);
      return;
    }
    localIUploadLog.i("[upload2] " + paramString1, paramString2);
  }
  
  public static void i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    IUploadLog localIUploadLog = UploadGlobalConfig.getUploadLog();
    if (localIUploadLog == null)
    {
      Log.i("[upload2] " + paramString1, paramString2, paramThrowable);
      return;
    }
    localIUploadLog.i("[upload2] " + paramString1, paramString2, paramThrowable);
  }
  
  public static void v(String paramString1, String paramString2)
  {
    IUploadLog localIUploadLog = UploadGlobalConfig.getUploadLog();
    if (localIUploadLog == null)
    {
      Log.v("[upload2] " + paramString1, paramString2);
      return;
    }
    localIUploadLog.v("[upload2] " + paramString1, paramString2);
  }
  
  public static void v(String paramString1, String paramString2, Throwable paramThrowable)
  {
    IUploadLog localIUploadLog = UploadGlobalConfig.getUploadLog();
    if (localIUploadLog == null)
    {
      Log.v("[upload2] " + paramString1, paramString2, paramThrowable);
      return;
    }
    localIUploadLog.v("[upload2] " + paramString1, paramString2, paramThrowable);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    IUploadLog localIUploadLog = UploadGlobalConfig.getUploadLog();
    if (localIUploadLog == null)
    {
      Log.w("[upload2] " + paramString1, paramString2);
      return;
    }
    localIUploadLog.w("[upload2] " + paramString1, paramString2);
  }
  
  public static void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    IUploadLog localIUploadLog = UploadGlobalConfig.getUploadLog();
    if (localIUploadLog == null)
    {
      Log.w("[upload2] " + paramString1, paramString2, paramThrowable);
      return;
    }
    localIUploadLog.w("[upload2] " + paramString1, paramString2, paramThrowable);
  }
  
  public static void w(String paramString, Throwable paramThrowable)
  {
    IUploadLog localIUploadLog = UploadGlobalConfig.getUploadLog();
    if (localIUploadLog == null)
    {
      Log.w("[upload2] " + paramString, paramThrowable);
      return;
    }
    localIUploadLog.w("[upload2] " + paramString, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.upload.utils.UploadLog
 * JD-Core Version:    0.7.0.1
 */