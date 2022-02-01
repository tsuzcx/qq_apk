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
  private static DateFormat dateFormat;
  private static File localFile;
  private static String localLogName;
  private static YtLogger.IYtLoggerListener loggerListener;
  private static ExecutorService mExecutorService = Executors.newSingleThreadExecutor();
  private static boolean needLogFile = false;
  
  static
  {
    dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss.SSS");
    localLogName = "youtu_log";
    localFile = null;
  }
  
  private static String buildMessage(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if ((localLogName != null) && (!"".equals(localLogName)) && (needLogFile))
    {
      StringBuffer localStringBuffer1 = new StringBuffer();
      localStringBuffer1.append(paramString2);
      StringBuffer localStringBuffer2 = new StringBuffer();
      localStringBuffer2.append(dateFormat.format(new Date()));
      localStringBuffer2.append("    ");
      localStringBuffer2.append("    ");
      localStringBuffer2.append(paramString1);
      localStringBuffer2.append("    ");
      localStringBuffer2.append(localStringBuffer1);
      if (paramThrowable != null)
      {
        localStringBuffer2.append(System.getProperty("line.separator"));
        localStringBuffer2.append(Log.getStackTraceString(paramThrowable));
      }
      save2File(localStringBuffer2.toString());
    }
    return paramString2;
  }
  
  public static void d(String paramString, Object paramObject)
  {
    if (currentLogLevel >= 4) {
      showLog(paramString, "[YoutuLog]-[DEBUG]-" + paramObject);
    }
  }
  
  public static void e(String paramString1, String paramString2)
  {
    if (currentLogLevel >= 0) {
      showLog(paramString1, "[YoutuLog]-[ERROR]-" + paramString2);
    }
  }
  
  private static File getLogFile(String paramString)
  {
    paramString = new File(Environment.getExternalStorageDirectory() + File.separator + "youtulog" + File.separator + paramString);
    if ((!paramString.exists()) && (!paramString.mkdirs())) {
      paramString = null;
    }
    Object localObject;
    do
    {
      return paramString;
      localObject = dateFormat.format(new Date()) + ".log";
      localObject = new File(paramString.getPath() + File.separator + (String)localObject);
      paramString = (String)localObject;
    } while (((File)localObject).exists());
    try
    {
      ((File)localObject).createNewFile();
      return localObject;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return localObject;
  }
  
  public static void i(String paramString1, String paramString2)
  {
    if (currentLogLevel >= 2) {
      showLog(paramString1, "[YoutuLog]-[INFO]-" + paramString2);
    }
  }
  
  private static void save2File(String paramString)
  {
    if (localFile != null) {
      writeFile(localFile, paramString);
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
    if (loggerListener != null) {
      loggerListener.log(paramString1, paramString2);
    }
    Log.d(paramString1, buildMessage(paramString1, paramString2, null));
  }
  
  public static void v(String paramString, Object paramObject)
  {
    if (currentLogLevel >= 5) {
      showLog(paramString, "[YoutuLog]-[VERB]-" + paramObject);
    }
  }
  
  public static void w(String paramString1, String paramString2)
  {
    if (currentLogLevel >= 1) {
      showLog(paramString1, "[YoutuLog]-[WARN]-" + paramString2);
    }
  }
  
  private static void writeFile(File paramFile, String paramString)
  {
    mExecutorService.submit(new YtLogger.1(paramFile, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.common.YtLogger
 * JD-Core Version:    0.7.0.1
 */