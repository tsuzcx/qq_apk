package com.tencent.ttpic.baseutils.log;

import android.content.res.Configuration;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.LruCache;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class LogUtils
{
  private static boolean ENABLED = true;
  private static boolean ENABLE_PROFILE = true;
  private static long mInitTime;
  private static long mLastTime;
  private static LruCache<String, Long> mTimeStampMap = new LruCache(1000);
  private static final Configuration sConfiguration = new Configuration();
  private static ILog sLog = null;
  
  public static void d(Object paramObject, String paramString)
  {
    d(getTag(paramObject), paramString);
  }
  
  public static void d(String paramString1, String paramString2)
  {
    if (ENABLED)
    {
      Object localObject = Thread.currentThread().getStackTrace()[3];
      localObject = "(" + Thread.currentThread().getName() + ")" + ((StackTraceElement)localObject).getClassName() + "(" + ((StackTraceElement)localObject).getLineNumber() + ")[" + ((StackTraceElement)localObject).getMethodName() + "]";
      paramString2 = (String)localObject + ": " + paramString2;
      if (sLog != null) {
        sLog.d(paramString1, paramString2);
      }
    }
    else
    {
      return;
    }
    Log.d(paramString1, paramString2);
  }
  
  public static void d(String paramString1, String paramString2, Throwable paramThrowable, Object... paramVarArgs)
  {
    if (ENABLED)
    {
      paramString2 = getFormatMessage(paramString1, paramString2, paramVarArgs);
      if (sLog != null) {
        sLog.d(paramString1, paramString2, paramThrowable);
      }
    }
    else
    {
      return;
    }
    Log.d(paramString1, paramString2, paramThrowable);
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (ENABLED)
    {
      paramString2 = getFormatMessage(paramString1, paramString2, paramVarArgs);
      if (sLog != null) {
        sLog.d(paramString1, paramString2);
      }
    }
    else
    {
      return;
    }
    Log.d(paramString1, paramString2);
  }
  
  public static void e(Object paramObject, String paramString)
  {
    e(getTag(paramObject), paramString);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return;
    }
    if (sLog != null)
    {
      sLog.e(paramString1, paramString2);
      return;
    }
    Log.e(paramString1, paramString2);
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable, Object... paramVarArgs)
  {
    if (ENABLED)
    {
      paramString2 = getFormatMessage(paramString1, paramString2, paramVarArgs);
      if (sLog != null) {
        sLog.e(paramString1, paramString2, paramThrowable);
      }
    }
    else
    {
      return;
    }
    Log.e(paramString1, paramString2, paramThrowable);
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (ENABLED)
    {
      paramString2 = getFormatMessage(paramString1, paramString2, paramVarArgs);
      if (sLog != null) {
        sLog.e(paramString1, paramString2);
      }
    }
    else
    {
      return;
    }
    Log.e(paramString1, paramString2);
  }
  
  public static void e(String paramString, Throwable paramThrowable)
  {
    if (ENABLED)
    {
      if (sLog != null) {
        sLog.e(paramString, "", paramThrowable);
      }
    }
    else {
      return;
    }
    Log.e(paramString, "", paramThrowable);
  }
  
  public static void e(Throwable paramThrowable)
  {
    e("", paramThrowable.getMessage());
  }
  
  private static String generateLogPrefix(String paramString)
  {
    StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
    if (arrayOfStackTraceElement == null) {
      return "";
    }
    int j = arrayOfStackTraceElement.length;
    int i = 0;
    if (i < j)
    {
      StackTraceElement localStackTraceElement = arrayOfStackTraceElement[i];
      if (localStackTraceElement.isNativeMethod()) {}
      while ((localStackTraceElement.getClassName().equals(Thread.class.getName())) || (!localStackTraceElement.getClassName().endsWith(paramString)))
      {
        i += 1;
        break;
      }
      return "(" + Thread.currentThread().getName() + ")" + localStackTraceElement.getClassName() + "(" + localStackTraceElement.getLineNumber() + ")[" + localStackTraceElement.getMethodName() + "]: ";
    }
    return "";
  }
  
  private static String getFormatMessage(String paramString1, String paramString2, Object... paramVarArgs)
  {
    String str = paramString2;
    if (paramVarArgs != null) {}
    try
    {
      str = String.format(sConfiguration.locale, paramString2, paramVarArgs);
      return generateLogPrefix(paramString1) + str;
    }
    catch (Exception paramVarArgs)
    {
      for (;;)
      {
        str = paramString2;
      }
    }
  }
  
  public static ILog getLog()
  {
    return sLog;
  }
  
  private static String getTag(Object paramObject)
  {
    if (paramObject == null) {
      return "filter process";
    }
    if ((paramObject instanceof String)) {
      return (String)paramObject;
    }
    return paramObject.getClass().getSimpleName();
  }
  
  public static void i(Object paramObject, String paramString)
  {
    i(getTag(paramObject), paramString);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return;
    }
    if (sLog != null)
    {
      sLog.i(paramString1, paramString2);
      return;
    }
    Log.i(paramString1, paramString2);
  }
  
  public static void i(String paramString1, String paramString2, Throwable paramThrowable, Object... paramVarArgs)
  {
    if (ENABLED)
    {
      paramString2 = getFormatMessage(paramString1, paramString2, paramVarArgs);
      if (sLog != null) {
        sLog.i(paramString1, paramString2, paramThrowable);
      }
    }
    else
    {
      return;
    }
    Log.i(paramString1, paramString2, paramThrowable);
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (ENABLED)
    {
      paramString2 = getFormatMessage(paramString1, paramString2, paramVarArgs);
      if (sLog != null) {
        sLog.i(paramString1, paramString2);
      }
    }
    else
    {
      return;
    }
    Log.i(paramString1, paramString2);
  }
  
  public static long initTime()
  {
    mLastTime = SystemClock.currentThreadTimeMillis();
    mInitTime = mLastTime;
    return mLastTime;
  }
  
  public static boolean isEnableProfile()
  {
    return ENABLE_PROFILE;
  }
  
  public static boolean isEnabled()
  {
    return ENABLED;
  }
  
  public static void printTime(String paramString1, String paramString2)
  {
    if ((!ENABLED) || (!ENABLE_PROFILE) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    long l1;
    if (paramString2.contains("BEGIN"))
    {
      l1 = System.currentTimeMillis();
      mTimeStampMap.put(paramString1, Long.valueOf(l1));
      i("LOG_PERFORMANCE_" + paramString1, paramString2);
      return;
    }
    if (paramString2.contains("END"))
    {
      Long localLong = (Long)mTimeStampMap.get(paramString1);
      if (localLong != null) {}
      for (l1 = localLong.longValue();; l1 = System.currentTimeMillis())
      {
        long l2 = System.currentTimeMillis();
        i("LOG_PERFORMANCE_" + paramString1, paramString2 + " = " + (l2 - l1));
        return;
      }
    }
    i("LOG_PERFORMANCE_" + paramString1, paramString2);
  }
  
  public static void setEnable(boolean paramBoolean)
  {
    ENABLED = paramBoolean;
  }
  
  public static void setEnableProfile(boolean paramBoolean)
  {
    ENABLE_PROFILE = paramBoolean;
  }
  
  public static void setLog(ILog paramILog)
  {
    sLog = paramILog;
  }
  
  public static void v(Object paramObject, String paramString)
  {
    v(getTag(paramObject), paramString);
  }
  
  public static void v(String paramString1, String paramString2)
  {
    if (ENABLED)
    {
      Object localObject = Thread.currentThread().getStackTrace()[3];
      localObject = "(" + Thread.currentThread().getName() + ")" + ((StackTraceElement)localObject).getClassName() + "(" + ((StackTraceElement)localObject).getLineNumber() + ")[" + ((StackTraceElement)localObject).getMethodName() + "]";
      paramString2 = (String)localObject + ": " + paramString2;
      if (sLog != null) {
        sLog.v(paramString1, paramString2);
      }
    }
    else
    {
      return;
    }
    Log.v(paramString1, paramString2);
  }
  
  public static void v(String paramString1, String paramString2, Throwable paramThrowable, Object... paramVarArgs)
  {
    if (ENABLED)
    {
      paramString2 = getFormatMessage(paramString1, paramString2, paramVarArgs);
      if (sLog != null) {
        sLog.v(paramString1, paramString2, paramThrowable);
      }
    }
    else
    {
      return;
    }
    Log.v(paramString1, paramString2, paramThrowable);
  }
  
  public static void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (ENABLED)
    {
      paramString2 = getFormatMessage(paramString1, paramString2, paramVarArgs);
      if (sLog != null) {
        sLog.v(paramString1, paramString2);
      }
    }
    else
    {
      return;
    }
    Log.v(paramString1, paramString2);
  }
  
  public static void w(Object paramObject, String paramString)
  {
    w(getTag(paramObject), paramString);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    if (ENABLED)
    {
      Object localObject = Thread.currentThread().getStackTrace()[3];
      localObject = "(" + Thread.currentThread().getName() + ")" + ((StackTraceElement)localObject).getClassName() + "(" + ((StackTraceElement)localObject).getLineNumber() + ")[" + ((StackTraceElement)localObject).getMethodName() + "]";
      paramString2 = (String)localObject + ": " + paramString2;
      if (sLog != null) {
        sLog.w(paramString1, paramString2);
      }
    }
    else
    {
      return;
    }
    Log.w(paramString1, paramString2);
  }
  
  public static void w(String paramString1, String paramString2, Throwable paramThrowable, Object... paramVarArgs)
  {
    if (ENABLED)
    {
      paramString2 = getFormatMessage(paramString1, paramString2, paramVarArgs);
      if (sLog != null) {
        sLog.w(paramString1, paramString2, paramThrowable);
      }
    }
    else
    {
      return;
    }
    Log.w(paramString1, paramString2, paramThrowable);
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (ENABLED)
    {
      paramString2 = getFormatMessage(paramString1, paramString2, paramVarArgs);
      if (sLog != null) {
        sLog.w(paramString1, paramString2);
      }
    }
    else
    {
      return;
    }
    Log.w(paramString1, paramString2);
  }
  
  public static int writeLog(Object paramObject, String paramString)
  {
    if ((ENABLED) && (ENABLE_PROFILE)) {
      paramObject = getTag(paramObject);
    }
    try
    {
      paramString = paramString + "\n";
      long l = System.currentTimeMillis();
      FileOutputStream localFileOutputStream = new FileOutputStream("/mnt/sdcard/log.txt", true);
      localFileOutputStream.write((String.valueOf(l) + "--\t").getBytes());
      localFileOutputStream.write(paramObject.getBytes());
      localFileOutputStream.write(new String("\t").getBytes());
      localFileOutputStream.write(paramString.getBytes());
      localFileOutputStream.flush();
      localFileOutputStream.close();
      return 0;
    }
    catch (FileNotFoundException paramObject)
    {
      for (;;)
      {
        paramObject.printStackTrace();
      }
    }
    catch (IOException paramObject)
    {
      for (;;)
      {
        paramObject.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.baseutils.log.LogUtils
 * JD-Core Version:    0.7.0.1
 */