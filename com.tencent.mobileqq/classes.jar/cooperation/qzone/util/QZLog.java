package cooperation.qzone.util;

import android.util.Log;
import anis;
import com.tencent.qphone.base.util.QLog;

public class QZLog
{
  public static final int CLR = 2;
  public static final String CRASH_TAG = "crash";
  public static final int DEV = 4;
  private static final boolean ENABLED = true;
  public static final String EXCEPTION_TAG = "exception";
  public static final String FEEDS_TAG = "Feeds";
  public static final String IMAGE_CACHE_TAG = "ImageCache";
  public static final String MEMORY_LEAK = "MemoryLeak";
  public static final String PICTURE_PREVIEW = "picture_preview";
  public static final String PUBLISH_QUEUE_TAG = "[upload2][outbox] PublishQueue";
  public static final String REPORT_QUEUE_TAG = "QZoneReportTaskQueue";
  public static final String REQUSET = "REQUSET";
  public static final String TO_DEVICE_TAG = "QZLog";
  public static final int USR = 1;
  public static final String WNS_HTML = "wns_html";
  
  public static void d(String paramString1, int paramInt, String paramString2)
  {
    QLog.d(paramString1, getNewLevel(paramInt), paramString2);
  }
  
  public static void d(String paramString1, int paramInt, String paramString2, Throwable paramThrowable)
  {
    QLog.d(paramString1, getNewLevel(paramInt), paramString2, paramThrowable);
  }
  
  public static void d(String paramString, int paramInt, Throwable paramThrowable, Object... paramVarArgs)
  {
    int i = 0;
    int j = getNewLevel(paramInt);
    if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {}
    while (!needPrintLog(j)) {
      return;
    }
    if ((paramVarArgs.length == 1) && (paramVarArgs[0] != null))
    {
      d(paramString, j, paramVarArgs[0].toString());
      return;
    }
    anis localanis = anis.a();
    int k = paramVarArgs.length;
    paramInt = i;
    while (paramInt < k)
    {
      localanis.a(paramVarArgs[paramInt]);
      paramInt += 1;
    }
    QLog.d(paramString, j, localanis.toString(), paramThrowable);
    localanis.a();
  }
  
  public static void d(String paramString, int paramInt, Object... paramVarArgs)
  {
    d(paramString, getNewLevel(paramInt), (Throwable)null, paramVarArgs);
  }
  
  public static void e(String paramString, int paramInt, Throwable paramThrowable, Object... paramVarArgs)
  {
    int i = 0;
    int j = getNewLevel(paramInt);
    if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {}
    while (!needPrintLog(j)) {
      return;
    }
    if ((paramVarArgs.length == 1) && (paramVarArgs[0] != null))
    {
      QLog.e(paramString, j, paramVarArgs[0].toString());
      return;
    }
    anis localanis = anis.a();
    int k = paramVarArgs.length;
    paramInt = i;
    while (paramInt < k)
    {
      localanis.a(paramVarArgs[paramInt]);
      paramInt += 1;
    }
    QLog.e(paramString, j, localanis.toString(), paramThrowable);
    localanis.a();
  }
  
  public static void e(String paramString, int paramInt, Object... paramVarArgs)
  {
    e(paramString, getNewLevel(paramInt), (Throwable)null, paramVarArgs);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    QLog.e(paramString1, 1, paramString2);
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    QLog.e(paramString1, 1, paramString2, paramThrowable);
  }
  
  public static int getNewLevel(int paramInt)
  {
    if (isForceOpenColor()) {
      paramInt = 1;
    }
    return paramInt;
  }
  
  public static String getStackTraceString(Throwable paramThrowable)
  {
    return Log.getStackTraceString(paramThrowable);
  }
  
  public static void i(String paramString1, int paramInt, String paramString2)
  {
    QLog.i(paramString1, getNewLevel(paramInt), paramString2);
  }
  
  public static void i(String paramString1, int paramInt, String paramString2, Throwable paramThrowable)
  {
    QLog.i(paramString1, getNewLevel(paramInt), paramString2, paramThrowable);
  }
  
  public static void i(String paramString, int paramInt, Throwable paramThrowable, Object... paramVarArgs)
  {
    int i = 0;
    int j = getNewLevel(paramInt);
    if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {}
    while (!needPrintLog(j)) {
      return;
    }
    if ((paramVarArgs.length == 1) && (paramVarArgs[0] != null))
    {
      i(paramString, j, paramVarArgs[0].toString());
      return;
    }
    anis localanis = anis.a();
    int k = paramVarArgs.length;
    paramInt = i;
    while (paramInt < k)
    {
      localanis.a(paramVarArgs[paramInt]);
      paramInt += 1;
    }
    QLog.i(paramString, j, localanis.toString(), paramThrowable);
    localanis.a();
  }
  
  public static void i(String paramString, int paramInt, Object... paramVarArgs)
  {
    i(paramString, getNewLevel(paramInt), (Throwable)null, paramVarArgs);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    QLog.i(paramString1, 1, paramString2);
  }
  
  public static boolean isColorLevel()
  {
    if (isForceOpenColor()) {
      return true;
    }
    return QLog.isColorLevel();
  }
  
  public static final boolean isDevelopLevel()
  {
    return QLog.isDevelopLevel();
  }
  
  public static boolean isForceOpenColor()
  {
    return false;
  }
  
  private static boolean needPrintLog(int paramInt)
  {
    int i;
    if (QLog.isDevelopLevel()) {
      i = 4;
    }
    while (i >= paramInt)
    {
      return true;
      if (QLog.isColorLevel()) {
        i = 2;
      } else {
        i = 1;
      }
    }
    return false;
  }
  
  public static void w(String paramString, int paramInt, Throwable paramThrowable, Object... paramVarArgs)
  {
    int i = 0;
    int j = getNewLevel(paramInt);
    if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {}
    while (!needPrintLog(j)) {
      return;
    }
    if ((paramVarArgs.length == 1) && (paramVarArgs[0] != null))
    {
      QLog.w(paramString, j, paramVarArgs[0].toString());
      return;
    }
    anis localanis = anis.a();
    int k = paramVarArgs.length;
    paramInt = i;
    while (paramInt < k)
    {
      localanis.a(paramVarArgs[paramInt]);
      paramInt += 1;
    }
    QLog.w(paramString, j, localanis.toString(), paramThrowable);
    localanis.a();
  }
  
  public static void w(String paramString, int paramInt, Object... paramVarArgs)
  {
    w(paramString, getNewLevel(paramInt), (Throwable)null, paramVarArgs);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    QLog.w(paramString1, 1, paramString2, null);
  }
  
  public static void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    QLog.w(paramString1, 1, paramString2, paramThrowable);
  }
  
  public static void w(Throwable paramThrowable)
  {
    w("exception", "", paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.util.QZLog
 * JD-Core Version:    0.7.0.1
 */