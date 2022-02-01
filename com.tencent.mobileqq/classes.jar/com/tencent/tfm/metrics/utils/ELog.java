package com.tencent.tfm.metrics.utils;

import android.util.Log;
import java.util.Locale;

public class ELog
{
  public static final String LOG_TAG = "pcg_monitor";
  private static final int MIN_STACK_OFFSET = 5;
  public static boolean fileLogAble = false;
  private static boolean logAble = false;
  public static boolean useFuncTag = false;
  
  private static boolean check()
  {
    return isLogAble();
  }
  
  public static void debug(String paramString, Object... paramVarArgs)
  {
    if (check()) {
      Log.d("pcg_monitor", format(paramString, paramVarArgs));
    }
  }
  
  public static void debug2(String paramString1, String paramString2, Object... paramVarArgs)
  {
    Log.d("pcg_monitor", format(paramString1 + " " + paramString2, paramVarArgs));
  }
  
  public static void error(String paramString, Object... paramVarArgs)
  {
    if (check()) {
      Log.e("pcg_monitor", format(paramString, paramVarArgs));
    }
  }
  
  protected static String format(String paramString, Object... paramVarArgs)
  {
    String str = getFuncTag();
    if (paramString == null) {
      return str + "msg is null";
    }
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {
      return str + paramString;
    }
    return str + String.format(Locale.US, paramString, paramVarArgs);
  }
  
  private static StackTraceElement getCurrentStackTrace()
  {
    StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
    int j = getStackOffset(arrayOfStackTraceElement, ELog.class);
    int i = j;
    if (j == -1)
    {
      j = getStackOffset(arrayOfStackTraceElement, Log.class);
      i = j;
      if (j == -1) {
        return null;
      }
    }
    return arrayOfStackTraceElement[i];
  }
  
  private static String getFuncTag()
  {
    if (isUseFuncTag())
    {
      StackTraceElement localStackTraceElement = getCurrentStackTrace();
      if (localStackTraceElement != null)
      {
        String str2 = localStackTraceElement.getFileName();
        String str1 = str2;
        if (str2 == null) {
          str1 = "";
        }
        return "(" + str1 + ":" + localStackTraceElement.getLineNumber() + ")" + localStackTraceElement.getMethodName() + " ";
      }
    }
    return "";
  }
  
  private static int getStackOffset(StackTraceElement[] paramArrayOfStackTraceElement, Class paramClass)
  {
    int i = 5;
    if (i < paramArrayOfStackTraceElement.length)
    {
      String str = paramArrayOfStackTraceElement[i].getClassName();
      if ((paramClass.equals(Log.class)) && (i < paramArrayOfStackTraceElement.length - 1) && (paramArrayOfStackTraceElement[(i + 1)].getClassName().equals(Log.class.getName()))) {}
      while (!str.equals(paramClass.getName()))
      {
        i += 1;
        break;
      }
      return i + 1;
    }
    return -1;
  }
  
  public static void info(String paramString, Object... paramVarArgs)
  {
    if (check()) {
      Log.i("pcg_monitor", format(paramString, paramVarArgs));
    }
  }
  
  public static boolean isLogAble()
  {
    try
    {
      boolean bool = logAble;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean isUseFuncTag()
  {
    try
    {
      boolean bool = useFuncTag;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void printStackTrace(Throwable paramThrowable)
  {
    if ((paramThrowable != null) && (check())) {
      Log.e("pcg_monitor", "error", paramThrowable);
    }
  }
  
  public static void setLogAble(boolean paramBoolean)
  {
    try
    {
      logAble = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void setUseFuncTag(boolean paramBoolean)
  {
    try
    {
      useFuncTag = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void step(String paramString1, int paramInt, String paramString2, Object... paramVarArgs)
  {
    Log.d("pcg_monitor", format(paramString1 + " step: " + paramInt + ". " + paramString2, paramVarArgs));
  }
  
  public static void warn(String paramString, Object... paramVarArgs)
  {
    if (check()) {
      Log.w("pcg_monitor", format(paramString, paramVarArgs));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tfm.metrics.utils.ELog
 * JD-Core Version:    0.7.0.1
 */