package com.tencent.tbs.log;

import android.content.Context;
import android.os.Environment;
import com.tencent.tbs.log.file.FilePrinter;
import com.tencent.tbs.log.file.backup.FileSizeBackupStrategy;
import com.tencent.tbs.log.file.clean.FileLastModifiedCleanStrategy;
import com.tencent.tbs.log.file.naming.DateLogNameGenerator;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class TBSLog
{
  public static final String DEFAULT_TBS_LOG_KEY_OF_KEY = "tbslog.txt";
  private static volatile Boolean sInitialized = Boolean.valueOf(false);
  private static LogLevel sLogLevel = LogLevel.ALL;
  private static boolean sLogOpen;
  private static String sLogPath = "";
  private static List<LogPrinter> sLogPrinters;
  private static TBSLog.TBSLogger sLogger;
  
  public static void addPrinter(LogPrinter paramLogPrinter)
  {
    if (!checkInitialize()) {}
    while ((paramLogPrinter == null) || (sLogPrinters.contains(paramLogPrinter))) {
      return;
    }
    sLogPrinters.add(paramLogPrinter);
  }
  
  private static boolean checkInitialize()
  {
    if (!sInitialized.booleanValue()) {
      new Throwable("TBSLog has not been initialized! Please call TBSLog.initialize() first.").printStackTrace();
    }
    return sInitialized.booleanValue();
  }
  
  public static void close()
  {
    if (!checkInitialize()) {
      return;
    }
    Iterator localIterator = sLogPrinters.iterator();
    while (localIterator.hasNext())
    {
      LogPrinter localLogPrinter = (LogPrinter)localIterator.next();
      localLogPrinter.close();
      removePrinter(localLogPrinter);
    }
    sLogger = null;
    sLogPrinters = null;
    sLogOpen = false;
    sInitialized = Boolean.valueOf(false);
  }
  
  public static LogPrinter createFilePrinter(Context paramContext, long paramLong1, long paramLong2)
  {
    return new FilePrinter(paramContext, true, true, new DateLogNameGenerator(), new FileLastModifiedCleanStrategy(paramLong1), new FileSizeBackupStrategy(paramLong2));
  }
  
  public static void d(String paramString1, String paramString2)
  {
    if (!checkInitialize()) {
      return;
    }
    TBSLog.TBSLogger.access$200(sLogger, paramString1);
    sLogger.d(paramString2);
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (!checkInitialize()) {
      return;
    }
    TBSLog.TBSLogger.access$200(sLogger, paramString1);
    sLogger.d(paramString2, paramVarArgs);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    if (!checkInitialize()) {
      return;
    }
    TBSLog.TBSLogger.access$200(sLogger, paramString1);
    sLogger.e(paramString2);
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (!checkInitialize()) {
      return;
    }
    TBSLog.TBSLogger.access$200(sLogger, paramString1);
    sLogger.e(paramString2, paramVarArgs);
  }
  
  public static String getLogPath()
  {
    return sLogPath;
  }
  
  public static Logger getLogger(Class<?> paramClass)
  {
    if (paramClass != null) {
      try
      {
        paramClass = getLogger(paramClass.getSimpleName());
        return paramClass;
      }
      finally {}
    }
    new Throwable("class not null!").printStackTrace();
    return null;
  }
  
  public static Logger getLogger(String paramString)
  {
    return new TBSLog.TBSLogger(paramString, null);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    if (!checkInitialize()) {
      return;
    }
    TBSLog.TBSLogger.access$200(sLogger, paramString1);
    sLogger.i(paramString2);
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (!checkInitialize()) {
      return;
    }
    TBSLog.TBSLogger.access$200(sLogger, paramString1);
    sLogger.i(paramString2, paramVarArgs);
  }
  
  public static void initialize(Context paramContext, String paramString, long paramLong1, long paramLong2)
  {
    initialize(paramContext, paramString, paramLong1, paramLong2, false);
  }
  
  public static void initialize(Context paramContext, String paramString, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    File localFile = null;
    try
    {
      if (!sInitialized.booleanValue())
      {
        sLogger = new TBSLog.TBSLogger(null);
        sLogPrinters = new ArrayList();
        sLogPrinters.add(createFilePrinter(paramContext, paramLong1, paramLong2));
        if (paramBoolean) {
          sLogPrinters.add(new DefaultPrinter());
        }
        if ("mounted".equals(Environment.getExternalStorageState())) {
          localFile = paramContext.getExternalFilesDir(paramString);
        }
        if (localFile != null) {}
        for (sLogPath = localFile.getAbsolutePath();; sLogPath = paramContext.getFilesDir() + File.separator + paramString)
        {
          sLogLevel = LogLevel.ALL;
          sLogOpen = true;
          sInitialized = Boolean.valueOf(true);
          return;
        }
      }
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static void log(int paramInt, String paramString1, String paramString2)
  {
    if (!checkInitialize()) {
      return;
    }
    TBSLog.TBSLogger.access$200(sLogger, paramString1);
    sLogger.log(paramInt, paramString2);
  }
  
  public static void log(int paramInt, String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (!checkInitialize()) {
      return;
    }
    TBSLog.TBSLogger.access$200(sLogger, paramString1);
    sLogger.log(paramInt, paramString2, paramVarArgs);
  }
  
  public static void logSwitch(boolean paramBoolean)
  {
    if (!checkInitialize()) {
      return;
    }
    sLogOpen = paramBoolean;
  }
  
  public static void removePrinter(LogPrinter paramLogPrinter)
  {
    if (!checkInitialize()) {}
    while (paramLogPrinter == null) {
      return;
    }
    sLogPrinters.remove(paramLogPrinter);
  }
  
  public static void setLogLevel(LogLevel paramLogLevel)
  {
    if (!checkInitialize()) {
      return;
    }
    sLogLevel = paramLogLevel;
  }
  
  public static void v(String paramString1, String paramString2)
  {
    if (!checkInitialize()) {
      return;
    }
    TBSLog.TBSLogger.access$200(sLogger, paramString1);
    sLogger.v(paramString2);
  }
  
  public static void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (!checkInitialize()) {
      return;
    }
    TBSLog.TBSLogger.access$200(sLogger, paramString1);
    sLogger.v(paramString2, paramVarArgs);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    if (!checkInitialize()) {
      return;
    }
    TBSLog.TBSLogger.access$200(sLogger, paramString1);
    sLogger.w(paramString2);
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (!checkInitialize()) {
      return;
    }
    TBSLog.TBSLogger.access$200(sLogger, paramString1);
    sLogger.w(paramString2, paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.log.TBSLog
 * JD-Core Version:    0.7.0.1
 */