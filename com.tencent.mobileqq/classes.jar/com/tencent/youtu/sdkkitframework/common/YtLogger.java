package com.tencent.youtu.sdkkitframework.common;

import android.annotation.SuppressLint;
import android.os.Environment;
import android.util.Log;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class YtLogger
{
  public static final int DEBUG_LEVEL = 4;
  public static final int ERROR_LEVEL = 0;
  public static final int INFO_LEVEL = 2;
  public static final int VERB_LEVEL = 5;
  public static final int WARN_LEVEL = 1;
  private static int currentLogLevel = 0;
  @SuppressLint({"SimpleDateFormat"})
  private static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss.SSS");
  private static File localFile;
  private static String localLogName = "youtu_log";
  private static YtLogger.IYtLoggerListener loggerListener;
  private static ExecutorService mExecutorService = Executors.newSingleThreadExecutor();
  private static boolean needLogFile = false;
  
  static
  {
    localFile = null;
  }
  
  private static String buildMessage(String paramString1, String paramString2, Throwable paramThrowable)
  {
    Object localObject = localLogName;
    if ((localObject != null) && (!"".equals(localObject)) && (needLogFile))
    {
      localObject = new StringBuffer();
      ((StringBuffer)localObject).append(paramString2);
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append(dateFormat.format(new Date()));
      localStringBuffer.append("    ");
      localStringBuffer.append("    ");
      localStringBuffer.append(paramString1);
      localStringBuffer.append("    ");
      localStringBuffer.append((StringBuffer)localObject);
      if (paramThrowable != null)
      {
        localStringBuffer.append(System.getProperty("line.separator"));
        localStringBuffer.append(Log.getStackTraceString(paramThrowable));
      }
      save2File(localStringBuffer.toString());
    }
    return paramString2;
  }
  
  public static void d(String paramString, Object paramObject)
  {
    if (currentLogLevel >= 4)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[YoutuLog]-[DEBUG]-");
      localStringBuilder.append(paramObject);
      showLog(paramString, localStringBuilder.toString());
    }
  }
  
  public static void e(String paramString1, String paramString2)
  {
    if (currentLogLevel >= 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[YoutuLog]-[ERROR]-");
      localStringBuilder.append(paramString2);
      showLog(paramString1, localStringBuilder.toString());
    }
  }
  
  private static File getLogFile(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(Environment.getExternalStorageDirectory());
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append("youtulog");
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(paramString);
    paramString = new File(((StringBuilder)localObject).toString());
    if ((!paramString.exists()) && (!paramString.mkdirs())) {
      return null;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(dateFormat.format(new Date()));
    ((StringBuilder)localObject).append(".log");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString.getPath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append((String)localObject);
    paramString = new File(localStringBuilder.toString());
    if (!paramString.exists()) {
      try
      {
        paramString.createNewFile();
        return paramString;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    return paramString;
  }
  
  public static void i(String paramString1, String paramString2)
  {
    if (currentLogLevel >= 2)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[YoutuLog]-[INFO]-");
      localStringBuilder.append(paramString2);
      showLog(paramString1, localStringBuilder.toString());
    }
  }
  
  private static void save2File(String paramString)
  {
    File localFile1 = localFile;
    if (localFile1 != null) {
      writeFile(localFile1, paramString);
    }
  }
  
  public static void setLogLevel(int paramInt)
  {
    currentLogLevel = Math.min(paramInt, Math.max(paramInt, 0));
  }
  
  public static void setLoggerListener(YtLogger.IYtLoggerListener paramIYtLoggerListener)
  {
    loggerListener = paramIYtLoggerListener;
  }
  
  public static void setNeedLogFile(boolean paramBoolean, String paramString)
  {
    needLogFile = paramBoolean;
    if (needLogFile)
    {
      localLogName = paramString;
      localFile = getLogFile(localLogName);
    }
  }
  
  private static void showLog(String paramString1, String paramString2)
  {
    YtLogger.IYtLoggerListener localIYtLoggerListener = loggerListener;
    if (localIYtLoggerListener != null) {
      localIYtLoggerListener.log(paramString1, paramString2);
    }
    Log.d(paramString1, buildMessage(paramString1, paramString2, null));
  }
  
  public static void v(String paramString, Object paramObject)
  {
    if (currentLogLevel >= 5)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[YoutuLog]-[VERB]-");
      localStringBuilder.append(paramObject);
      showLog(paramString, localStringBuilder.toString());
    }
  }
  
  public static void w(String paramString1, String paramString2)
  {
    if (currentLogLevel >= 1)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[YoutuLog]-[WARN]-");
      localStringBuilder.append(paramString2);
      showLog(paramString1, localStringBuilder.toString());
    }
  }
  
  private static void writeFile(File paramFile, String paramString)
  {
    mExecutorService.submit(new YtLogger.1(paramFile, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.common.YtLogger
 * JD-Core Version:    0.7.0.1
 */