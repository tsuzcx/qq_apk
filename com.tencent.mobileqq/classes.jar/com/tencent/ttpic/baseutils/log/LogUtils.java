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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("(");
      localStringBuilder.append(Thread.currentThread().getName());
      localStringBuilder.append(")");
      localStringBuilder.append(((StackTraceElement)localObject).getClassName());
      localStringBuilder.append("(");
      localStringBuilder.append(((StackTraceElement)localObject).getLineNumber());
      localStringBuilder.append(")[");
      localStringBuilder.append(((StackTraceElement)localObject).getMethodName());
      localStringBuilder.append("]");
      localObject = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(": ");
      localStringBuilder.append(paramString2);
      paramString2 = localStringBuilder.toString();
      localObject = sLog;
      if (localObject != null)
      {
        ((ILog)localObject).d(paramString1, paramString2);
        return;
      }
      Log.d(paramString1, paramString2);
    }
  }
  
  public static void d(String paramString1, String paramString2, Throwable paramThrowable, Object... paramVarArgs)
  {
    if (ENABLED)
    {
      paramString2 = getFormatMessage(paramString1, paramString2, paramVarArgs);
      paramVarArgs = sLog;
      if (paramVarArgs != null)
      {
        paramVarArgs.d(paramString1, paramString2, paramThrowable);
        return;
      }
      Log.d(paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (ENABLED)
    {
      paramString2 = getFormatMessage(paramString1, paramString2, paramVarArgs);
      paramVarArgs = sLog;
      if (paramVarArgs != null)
      {
        paramVarArgs.d(paramString1, paramString2);
        return;
      }
      Log.d(paramString1, paramString2);
    }
  }
  
  public static void e(Object paramObject, String paramString)
  {
    e(getTag(paramObject), paramString);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      if (paramString2 == null) {
        return;
      }
      ILog localILog = sLog;
      if (localILog != null)
      {
        localILog.e(paramString1, paramString2);
        return;
      }
      Log.e(paramString1, paramString2);
    }
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable, Object... paramVarArgs)
  {
    if (ENABLED)
    {
      paramString2 = getFormatMessage(paramString1, paramString2, paramVarArgs);
      paramVarArgs = sLog;
      if (paramVarArgs != null)
      {
        paramVarArgs.e(paramString1, paramString2, paramThrowable);
        return;
      }
      Log.e(paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (ENABLED)
    {
      paramString2 = getFormatMessage(paramString1, paramString2, paramVarArgs);
      paramVarArgs = sLog;
      if (paramVarArgs != null)
      {
        paramVarArgs.e(paramString1, paramString2);
        return;
      }
      Log.e(paramString1, paramString2);
    }
  }
  
  public static void e(String paramString, Throwable paramThrowable)
  {
    if (ENABLED)
    {
      ILog localILog = sLog;
      if (localILog != null)
      {
        localILog.e(paramString, "", paramThrowable);
        return;
      }
      Log.e(paramString, "", paramThrowable);
    }
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
    while (i < j)
    {
      StackTraceElement localStackTraceElement = arrayOfStackTraceElement[i];
      if ((!localStackTraceElement.isNativeMethod()) && (!localStackTraceElement.getClassName().equals(Thread.class.getName())) && (localStackTraceElement.getClassName().endsWith(paramString)))
      {
        paramString = new StringBuilder();
        paramString.append("(");
        paramString.append(Thread.currentThread().getName());
        paramString.append(")");
        paramString.append(localStackTraceElement.getClassName());
        paramString.append("(");
        paramString.append(localStackTraceElement.getLineNumber());
        paramString.append(")[");
        paramString.append(localStackTraceElement.getMethodName());
        paramString.append("]: ");
        return paramString.toString();
      }
      i += 1;
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
      paramString2 = new StringBuilder();
      paramString2.append(generateLogPrefix(paramString1));
      paramString2.append(str);
      return paramString2.toString();
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
    if (paramString1 != null)
    {
      if (paramString2 == null) {
        return;
      }
      ILog localILog = sLog;
      if (localILog != null)
      {
        localILog.i(paramString1, paramString2);
        return;
      }
      Log.i(paramString1, paramString2);
    }
  }
  
  public static void i(String paramString1, String paramString2, Throwable paramThrowable, Object... paramVarArgs)
  {
    if (ENABLED)
    {
      paramString2 = getFormatMessage(paramString1, paramString2, paramVarArgs);
      paramVarArgs = sLog;
      if (paramVarArgs != null)
      {
        paramVarArgs.i(paramString1, paramString2, paramThrowable);
        return;
      }
      Log.i(paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (ENABLED)
    {
      paramString2 = getFormatMessage(paramString1, paramString2, paramVarArgs);
      paramVarArgs = sLog;
      if (paramVarArgs != null)
      {
        paramVarArgs.i(paramString1, paramString2);
        return;
      }
      Log.i(paramString1, paramString2);
    }
  }
  
  public static long initTime()
  {
    mLastTime = SystemClock.currentThreadTimeMillis();
    long l = mLastTime;
    mInitTime = l;
    return l;
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
    if ((ENABLED) && (ENABLE_PROFILE) && (!TextUtils.isEmpty(paramString1)))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      long l1;
      if (paramString2.contains("BEGIN"))
      {
        l1 = System.currentTimeMillis();
        mTimeStampMap.put(paramString1, Long.valueOf(l1));
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("LOG_PERFORMANCE_");
        ((StringBuilder)localObject).append(paramString1);
        i(((StringBuilder)localObject).toString(), paramString2);
        return;
      }
      if (paramString2.contains("END"))
      {
        localObject = (Long)mTimeStampMap.get(paramString1);
        if (localObject != null) {
          l1 = ((Long)localObject).longValue();
        } else {
          l1 = System.currentTimeMillis();
        }
        long l2 = System.currentTimeMillis();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("LOG_PERFORMANCE_");
        ((StringBuilder)localObject).append(paramString1);
        paramString1 = ((StringBuilder)localObject).toString();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString2);
        ((StringBuilder)localObject).append(" = ");
        ((StringBuilder)localObject).append(l2 - l1);
        i(paramString1, ((StringBuilder)localObject).toString());
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("LOG_PERFORMANCE_");
      ((StringBuilder)localObject).append(paramString1);
      i(((StringBuilder)localObject).toString(), paramString2);
    }
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("(");
      localStringBuilder.append(Thread.currentThread().getName());
      localStringBuilder.append(")");
      localStringBuilder.append(((StackTraceElement)localObject).getClassName());
      localStringBuilder.append("(");
      localStringBuilder.append(((StackTraceElement)localObject).getLineNumber());
      localStringBuilder.append(")[");
      localStringBuilder.append(((StackTraceElement)localObject).getMethodName());
      localStringBuilder.append("]");
      localObject = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(": ");
      localStringBuilder.append(paramString2);
      paramString2 = localStringBuilder.toString();
      localObject = sLog;
      if (localObject != null)
      {
        ((ILog)localObject).v(paramString1, paramString2);
        return;
      }
      Log.v(paramString1, paramString2);
    }
  }
  
  public static void v(String paramString1, String paramString2, Throwable paramThrowable, Object... paramVarArgs)
  {
    if (ENABLED)
    {
      paramString2 = getFormatMessage(paramString1, paramString2, paramVarArgs);
      paramVarArgs = sLog;
      if (paramVarArgs != null)
      {
        paramVarArgs.v(paramString1, paramString2, paramThrowable);
        return;
      }
      Log.v(paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (ENABLED)
    {
      paramString2 = getFormatMessage(paramString1, paramString2, paramVarArgs);
      paramVarArgs = sLog;
      if (paramVarArgs != null)
      {
        paramVarArgs.v(paramString1, paramString2);
        return;
      }
      Log.v(paramString1, paramString2);
    }
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("(");
      localStringBuilder.append(Thread.currentThread().getName());
      localStringBuilder.append(")");
      localStringBuilder.append(((StackTraceElement)localObject).getClassName());
      localStringBuilder.append("(");
      localStringBuilder.append(((StackTraceElement)localObject).getLineNumber());
      localStringBuilder.append(")[");
      localStringBuilder.append(((StackTraceElement)localObject).getMethodName());
      localStringBuilder.append("]");
      localObject = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(": ");
      localStringBuilder.append(paramString2);
      paramString2 = localStringBuilder.toString();
      localObject = sLog;
      if (localObject != null)
      {
        ((ILog)localObject).w(paramString1, paramString2);
        return;
      }
      Log.w(paramString1, paramString2);
    }
  }
  
  public static void w(String paramString1, String paramString2, Throwable paramThrowable, Object... paramVarArgs)
  {
    if (ENABLED)
    {
      paramString2 = getFormatMessage(paramString1, paramString2, paramVarArgs);
      paramVarArgs = sLog;
      if (paramVarArgs != null)
      {
        paramVarArgs.w(paramString1, paramString2, paramThrowable);
        return;
      }
      Log.w(paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (ENABLED)
    {
      paramString2 = getFormatMessage(paramString1, paramString2, paramVarArgs);
      paramVarArgs = sLog;
      if (paramVarArgs != null)
      {
        paramVarArgs.w(paramString1, paramString2);
        return;
      }
      Log.w(paramString1, paramString2);
    }
  }
  
  public static int writeLog(Object paramObject, String paramString)
  {
    if ((ENABLED) && (ENABLE_PROFILE))
    {
      paramObject = getTag(paramObject);
      try
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("\n");
        paramString = ((StringBuilder)localObject).toString();
        long l = System.currentTimeMillis();
        localObject = new FileOutputStream("/mnt/sdcard/log.txt", true);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(String.valueOf(l));
        localStringBuilder.append("--\t");
        ((FileOutputStream)localObject).write(localStringBuilder.toString().getBytes());
        ((FileOutputStream)localObject).write(paramObject.getBytes());
        ((FileOutputStream)localObject).write(new String("\t").getBytes());
        ((FileOutputStream)localObject).write(paramString.getBytes());
        ((FileOutputStream)localObject).flush();
        ((FileOutputStream)localObject).close();
      }
      catch (IOException paramObject)
      {
        paramObject.printStackTrace();
      }
      catch (FileNotFoundException paramObject)
      {
        paramObject.printStackTrace();
      }
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.baseutils.log.LogUtils
 * JD-Core Version:    0.7.0.1
 */