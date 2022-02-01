package com.tencent.mtt.abtestsdk.utils;

import android.util.Log;
import java.util.Locale;

public class ABTestLog
{
  public static final String LOG_API_TAG = "tab_test_api";
  public static final String LOG_BUF_TAG = "tab_test_buffer";
  public static final String LOG_REP_TAG = "tab_test_report";
  public static final String LOG_TAG = "tab_test";
  public static final String LOG_UP_TAG = "tab_test_upload";
  private static final int MIN_STACK_OFFSET = 5;
  private static boolean logAble = false;
  public static boolean useFuncTag = false;
  
  private static boolean check()
  {
    return isLogAble();
  }
  
  public static void debug(String paramString, Object... paramVarArgs)
  {
    if (check()) {
      Log.d("tab_test", format(paramString, paramVarArgs));
    }
  }
  
  public static void error(String paramString, Object... paramVarArgs)
  {
    if (check()) {
      Log.e("tab_test", format(paramString, paramVarArgs));
    }
  }
  
  private static String format(String paramString, Object... paramVarArgs)
  {
    String str = getFuncTag();
    if (paramString == null) {
      return str + " msg is null";
    }
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {
      return str + paramString;
    }
    return str + String.format(Locale.US, paramString, paramVarArgs);
  }
  
  private static StackTraceElement getCurrentStackTrace()
  {
    StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
    int j = getStackOffset(arrayOfStackTraceElement, ABTestLog.class);
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
      Log.i("tab_test", format(paramString, paramVarArgs));
    }
  }
  
  public static boolean isLogAble()
  {
    return logAble;
  }
  
  public static boolean isUseFuncTag()
  {
    return useFuncTag;
  }
  
  public static void printStackTrace(Throwable paramThrowable)
  {
    if (paramThrowable != null)
    {
      if (check()) {
        paramThrowable.printStackTrace();
      }
    }
    else {
      return;
    }
    error(paramThrowable.getMessage(), new Object[0]);
  }
  
  public static void setLogAble(boolean paramBoolean)
  {
    logAble = paramBoolean;
  }
  
  public static void setUseFuncTag(boolean paramBoolean)
  {
    useFuncTag = paramBoolean;
  }
  
  public static void stepAPI(String paramString, Object... paramVarArgs)
  {
    if (check()) {
      Log.d("tab_test_api", format(paramString, paramVarArgs));
    }
  }
  
  public static void stepBuffer(String paramString, Object... paramVarArgs)
  {
    if (check()) {
      Log.d("tab_test_buffer", format(paramString, paramVarArgs));
    }
  }
  
  public static void stepReport(String paramString, Object... paramVarArgs)
  {
    if (check()) {
      Log.d("tab_test_report", format(paramString, paramVarArgs));
    }
  }
  
  public static void stepUpload(String paramString, Object... paramVarArgs)
  {
    if (check()) {
      Log.d("tab_test_upload", format(paramString, paramVarArgs));
    }
  }
  
  public static void warn(String paramString, Object... paramVarArgs)
  {
    if (check()) {
      Log.w("tab_test", format(paramString, paramVarArgs));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.abtestsdk.utils.ABTestLog
 * JD-Core Version:    0.7.0.1
 */