package com.tencent.mtt.abtestsdk.utils;

import android.util.Log;
import java.util.Locale;

public class ABTestLog
{
  public static final String LOG_CONFIG_TAG = "tab_config";
  public static final String LOG_EXP_TAG = "tab_exp";
  public static final String LOG_FEATURE_TAG = "tab_feature";
  public static final String LOG_REP_TAG = "tab_report";
  public static final String LOG_TAG = "tab";
  private static final int MIN_STACK_OFFSET = 5;
  private static boolean logAble = false;
  public static boolean useFuncTag = false;
  
  private static boolean check()
  {
    return isLogAble();
  }
  
  public static void configUpload(String paramString, Object... paramVarArgs)
  {
    if (check()) {
      Log.d("tab_config", format(paramString, paramVarArgs));
    }
  }
  
  public static void debug(String paramString, Object... paramVarArgs)
  {
    if (check()) {
      Log.d("tab", format(paramString, paramVarArgs));
    }
  }
  
  public static void error(String paramString, Object... paramVarArgs)
  {
    if (check()) {
      Log.e("tab", format(paramString, paramVarArgs));
    }
  }
  
  public static void expUpload(String paramString, Object... paramVarArgs)
  {
    if (check()) {
      Log.d("tab_exp", format(paramString, paramVarArgs));
    }
  }
  
  public static void featureUpload(String paramString, Object... paramVarArgs)
  {
    if (check()) {
      Log.d("tab_feature", format(paramString, paramVarArgs));
    }
  }
  
  private static String format(String paramString, Object... paramVarArgs)
  {
    String str = getFuncTag();
    if (paramString == null)
    {
      paramString = new StringBuilder();
      paramString.append(str);
      paramString.append(" msg is null");
      return paramString.toString();
    }
    if ((paramVarArgs != null) && (paramVarArgs.length != 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(String.format(Locale.US, paramString, paramVarArgs));
      return localStringBuilder.toString();
    }
    paramVarArgs = new StringBuilder();
    paramVarArgs.append(str);
    paramVarArgs.append(paramString);
    return paramVarArgs.toString();
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
    boolean bool = isUseFuncTag();
    Object localObject1 = "";
    if (bool)
    {
      StackTraceElement localStackTraceElement = getCurrentStackTrace();
      if (localStackTraceElement != null)
      {
        Object localObject2 = localStackTraceElement.getFileName();
        if (localObject2 != null) {
          localObject1 = localObject2;
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("(");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(":");
        ((StringBuilder)localObject2).append(localStackTraceElement.getLineNumber());
        ((StringBuilder)localObject2).append(")");
        ((StringBuilder)localObject2).append(localStackTraceElement.getMethodName());
        ((StringBuilder)localObject2).append(" ");
        return ((StringBuilder)localObject2).toString();
      }
    }
    return "";
  }
  
  private static int getStackOffset(StackTraceElement[] paramArrayOfStackTraceElement, Class paramClass)
  {
    int i = 5;
    while (i < paramArrayOfStackTraceElement.length)
    {
      String str = paramArrayOfStackTraceElement[i].getClassName();
      if (((!paramClass.equals(Log.class)) || (i >= paramArrayOfStackTraceElement.length - 1) || (!paramArrayOfStackTraceElement[(i + 1)].getClassName().equals(Log.class.getName()))) && (str.equals(paramClass.getName()))) {
        return i + 1;
      }
      i += 1;
    }
    return -1;
  }
  
  public static void info(String paramString, Object... paramVarArgs)
  {
    if (check()) {
      Log.i("tab", format(paramString, paramVarArgs));
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
      if (check())
      {
        paramThrowable.printStackTrace();
        return;
      }
      error(paramThrowable.getMessage(), new Object[0]);
    }
  }
  
  public static void setLogAble(boolean paramBoolean)
  {
    logAble = paramBoolean;
  }
  
  public static void setUseFuncTag(boolean paramBoolean)
  {
    useFuncTag = paramBoolean;
  }
  
  public static void stepReport(String paramString, Object... paramVarArgs)
  {
    if (check()) {
      Log.d("tab_report", format(paramString, paramVarArgs));
    }
  }
  
  public static void warn(String paramString, Object... paramVarArgs)
  {
    if (check()) {
      Log.w("tab", format(paramString, paramVarArgs));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.abtestsdk.utils.ABTestLog
 * JD-Core Version:    0.7.0.1
 */