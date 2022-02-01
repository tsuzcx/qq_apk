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
    Object localObject = UploadGlobalConfig.getUploadLog();
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[upload2] ");
      ((StringBuilder)localObject).append(paramString1);
      Log.d(((StringBuilder)localObject).toString(), paramString2);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[upload2] ");
    localStringBuilder.append(paramString1);
    ((IUploadLog)localObject).d(localStringBuilder.toString(), paramString2);
  }
  
  public static void d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    Object localObject = UploadGlobalConfig.getUploadLog();
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[upload2] ");
      ((StringBuilder)localObject).append(paramString1);
      Log.d(((StringBuilder)localObject).toString(), paramString2, paramThrowable);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[upload2] ");
    localStringBuilder.append(paramString1);
    ((IUploadLog)localObject).d(localStringBuilder.toString(), paramString2, paramThrowable);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    Object localObject = UploadGlobalConfig.getUploadLog();
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[upload2] ");
      ((StringBuilder)localObject).append(paramString1);
      Log.e(((StringBuilder)localObject).toString(), paramString2);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[upload2] ");
    localStringBuilder.append(paramString1);
    ((IUploadLog)localObject).e(localStringBuilder.toString(), paramString2);
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    Object localObject = UploadGlobalConfig.getUploadLog();
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[upload2] ");
      ((StringBuilder)localObject).append(paramString1);
      Log.e(((StringBuilder)localObject).toString(), paramString2, paramThrowable);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[upload2] ");
    localStringBuilder.append(paramString1);
    ((IUploadLog)localObject).e(localStringBuilder.toString(), paramString2, paramThrowable);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    Object localObject = UploadGlobalConfig.getUploadLog();
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[upload2] ");
      ((StringBuilder)localObject).append(paramString1);
      Log.i(((StringBuilder)localObject).toString(), paramString2);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[upload2] ");
    localStringBuilder.append(paramString1);
    ((IUploadLog)localObject).i(localStringBuilder.toString(), paramString2);
  }
  
  public static void i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    Object localObject = UploadGlobalConfig.getUploadLog();
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[upload2] ");
      ((StringBuilder)localObject).append(paramString1);
      Log.i(((StringBuilder)localObject).toString(), paramString2, paramThrowable);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[upload2] ");
    localStringBuilder.append(paramString1);
    ((IUploadLog)localObject).i(localStringBuilder.toString(), paramString2, paramThrowable);
  }
  
  public static void v(String paramString1, String paramString2)
  {
    Object localObject = UploadGlobalConfig.getUploadLog();
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[upload2] ");
      ((StringBuilder)localObject).append(paramString1);
      Log.v(((StringBuilder)localObject).toString(), paramString2);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[upload2] ");
    localStringBuilder.append(paramString1);
    ((IUploadLog)localObject).v(localStringBuilder.toString(), paramString2);
  }
  
  public static void v(String paramString1, String paramString2, Throwable paramThrowable)
  {
    Object localObject = UploadGlobalConfig.getUploadLog();
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[upload2] ");
      ((StringBuilder)localObject).append(paramString1);
      Log.v(((StringBuilder)localObject).toString(), paramString2, paramThrowable);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[upload2] ");
    localStringBuilder.append(paramString1);
    ((IUploadLog)localObject).v(localStringBuilder.toString(), paramString2, paramThrowable);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    Object localObject = UploadGlobalConfig.getUploadLog();
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[upload2] ");
      ((StringBuilder)localObject).append(paramString1);
      Log.w(((StringBuilder)localObject).toString(), paramString2);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[upload2] ");
    localStringBuilder.append(paramString1);
    ((IUploadLog)localObject).w(localStringBuilder.toString(), paramString2);
  }
  
  public static void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    Object localObject = UploadGlobalConfig.getUploadLog();
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[upload2] ");
      ((StringBuilder)localObject).append(paramString1);
      Log.w(((StringBuilder)localObject).toString(), paramString2, paramThrowable);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[upload2] ");
    localStringBuilder.append(paramString1);
    ((IUploadLog)localObject).w(localStringBuilder.toString(), paramString2, paramThrowable);
  }
  
  public static void w(String paramString, Throwable paramThrowable)
  {
    Object localObject = UploadGlobalConfig.getUploadLog();
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[upload2] ");
      ((StringBuilder)localObject).append(paramString);
      Log.w(((StringBuilder)localObject).toString(), paramThrowable);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[upload2] ");
    localStringBuilder.append(paramString);
    ((IUploadLog)localObject).w(localStringBuilder.toString(), paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.upload.utils.UploadLog
 * JD-Core Version:    0.7.0.1
 */