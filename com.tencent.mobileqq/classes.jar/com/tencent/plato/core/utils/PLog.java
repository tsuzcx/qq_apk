package com.tencent.plato.core.utils;

import android.annotation.SuppressLint;
import android.util.Log;

public class PLog
{
  public static final int Log_D = 1;
  public static final int Log_E = 4;
  public static final int Log_I = 2;
  public static final int Log_V = 0;
  public static final int Log_W = 3;
  private static boolean enable = Ev.getLogEnable();
  private static ILogPrinter sLogPrinter = ;
  
  @SuppressLint({"DefaultLocale"})
  private static String buildMessage(String paramString)
  {
    return paramString;
  }
  
  public static int d(String paramString)
  {
    if (!enable) {
      return 0;
    }
    if (sLogPrinter != null) {
      return sLogPrinter.d(null, buildMessage(paramString));
    }
    return log(1, null, paramString, null);
  }
  
  public static int d(String paramString1, String paramString2)
  {
    if (!enable) {
      return 0;
    }
    if (sLogPrinter != null) {
      return sLogPrinter.d(paramString1, buildMessage(paramString2));
    }
    return log(1, paramString1, paramString2, null);
  }
  
  public static int d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (!enable) {
      return 0;
    }
    if (sLogPrinter != null) {
      return sLogPrinter.d(paramString1, buildMessage(paramString2), paramThrowable);
    }
    return log(1, paramString1, paramString2, paramThrowable);
  }
  
  public static int d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (!enable) {
      return 0;
    }
    paramString2 = format(paramString2, paramVarArgs);
    if (sLogPrinter != null) {
      return sLogPrinter.d(paramString1, buildMessage(paramString2));
    }
    return log(1, paramString1, paramString2, null);
  }
  
  public static int d(String paramString, Throwable paramThrowable)
  {
    if (!enable) {
      return 0;
    }
    if (sLogPrinter != null) {
      return sLogPrinter.d(null, buildMessage(paramString), paramThrowable);
    }
    return log(1, null, paramString, paramThrowable);
  }
  
  public static void dumpStack(Throwable paramThrowable)
  {
    paramThrowable = paramThrowable.getStackTrace();
    int j = paramThrowable.length;
    int i = 0;
    while (i < j)
    {
      String str = paramThrowable[i];
      str = str.getClassName() + "." + str.getMethodName() + "()";
      e("dumpStack", "-------" + str);
      i += 1;
    }
  }
  
  public static int e(String paramString)
  {
    if (sLogPrinter != null) {
      return sLogPrinter.e(null, buildMessage(paramString));
    }
    return log(4, null, paramString, null);
  }
  
  public static int e(String paramString1, String paramString2)
  {
    if (sLogPrinter != null) {
      return sLogPrinter.e(paramString1, buildMessage(paramString2));
    }
    return log(4, paramString1, paramString2, null);
  }
  
  public static int e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (sLogPrinter != null) {
      return sLogPrinter.e(paramString1, buildMessage(paramString2), paramThrowable);
    }
    return log(4, paramString1, paramString2, paramThrowable);
  }
  
  public static int e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    paramString2 = format(paramString2, paramVarArgs);
    if (sLogPrinter != null) {
      return sLogPrinter.e(paramString1, buildMessage(paramString2));
    }
    return log(4, paramString1, paramString2, null);
  }
  
  public static int e(String paramString, Throwable paramThrowable)
  {
    if (sLogPrinter != null) {
      return sLogPrinter.e(null, buildMessage(paramString), paramThrowable);
    }
    return log(4, null, paramString, paramThrowable);
  }
  
  private static String format(String paramString, Object[] paramArrayOfObject)
  {
    try
    {
      paramString = String.format(paramString, paramArrayOfObject);
      return paramString;
    }
    catch (Exception paramString) {}
    return String.valueOf(paramString.getMessage());
  }
  
  public static int i(String paramString)
  {
    if (!enable) {
      return 0;
    }
    if (sLogPrinter != null) {
      return sLogPrinter.i(null, buildMessage(paramString));
    }
    return log(2, null, paramString, null);
  }
  
  public static int i(String paramString1, String paramString2)
  {
    if (!enable) {
      return 0;
    }
    if (sLogPrinter != null) {
      return sLogPrinter.i(paramString1, buildMessage(paramString2));
    }
    return log(2, paramString1, paramString2, null);
  }
  
  public static int i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (!enable) {
      return 0;
    }
    if (sLogPrinter != null) {
      return sLogPrinter.i(paramString1, buildMessage(paramString2), paramThrowable);
    }
    return log(2, paramString1, paramString2, paramThrowable);
  }
  
  public static int i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (!enable) {
      return 0;
    }
    paramString2 = format(paramString2, paramVarArgs);
    if (sLogPrinter != null) {
      return sLogPrinter.i(paramString1, buildMessage(paramString2));
    }
    return log(2, paramString1, paramString2, null);
  }
  
  public static int i(String paramString, Throwable paramThrowable)
  {
    if (!enable) {
      return 0;
    }
    if (sLogPrinter != null) {
      return sLogPrinter.i(null, buildMessage(paramString), paramThrowable);
    }
    return log(2, null, paramString, paramThrowable);
  }
  
  @SuppressLint({"DefaultLocale"})
  public static int log(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
  {
    StackTraceElement localStackTraceElement = new Throwable().fillInStackTrace().getStackTrace()[2];
    Object localObject = localStackTraceElement.getClassName();
    String str = ((String)localObject).substring(((String)localObject).lastIndexOf('.') + 1);
    localObject = paramString1;
    if (paramString1 == null) {
      localObject = str;
    }
    paramString1 = new StringBuffer(50);
    paramString1.append("[");
    paramString1.append(Thread.currentThread().getName());
    paramString1.append("(");
    paramString1.append(Thread.currentThread().getId());
    paramString1.append(")");
    paramString1.append(str);
    paramString1.append(".");
    paramString1.append(localStackTraceElement.getMethodName());
    paramString1.append(":");
    paramString1.append(localStackTraceElement.getLineNumber());
    paramString1.append("]");
    paramString1.append(paramString2);
    paramString1 = paramString1.toString();
    switch (paramInt)
    {
    default: 
      if (paramThrowable == null) {
        return Log.e((String)localObject, paramString1);
      }
      break;
    case 1: 
      if (paramThrowable == null) {
        return Log.d((String)localObject, paramString1);
      }
      return Log.d((String)localObject, paramString1, paramThrowable);
    case 2: 
      if (paramThrowable == null) {
        return Log.i((String)localObject, paramString1);
      }
      return Log.i((String)localObject, paramString1, paramThrowable);
    case 3: 
      if (paramThrowable == null) {
        return Log.w((String)localObject, paramString1);
      }
      return Log.w((String)localObject, paramString1, paramThrowable);
    }
    return Log.e((String)localObject, paramString1, paramThrowable);
  }
  
  public static int w(String paramString)
  {
    if (sLogPrinter != null) {
      return sLogPrinter.w(null, buildMessage(paramString));
    }
    return log(3, null, paramString, null);
  }
  
  public static int w(String paramString1, String paramString2)
  {
    if (sLogPrinter != null) {
      return sLogPrinter.w(paramString1, buildMessage(paramString2));
    }
    return log(3, paramString1, paramString2, null);
  }
  
  public static int w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (sLogPrinter != null) {
      return sLogPrinter.w(paramString1, buildMessage(paramString2), paramThrowable);
    }
    return log(3, paramString1, paramString2, paramThrowable);
  }
  
  public static int w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    paramString2 = format(paramString2, paramVarArgs);
    if (sLogPrinter != null) {
      return sLogPrinter.w(paramString1, buildMessage(paramString2));
    }
    return log(3, paramString1, paramString2, null);
  }
  
  public static int w(String paramString, Throwable paramThrowable)
  {
    if (sLogPrinter != null) {
      return sLogPrinter.w(null, buildMessage(paramString), paramThrowable);
    }
    return log(3, null, paramString, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.plato.core.utils.PLog
 * JD-Core Version:    0.7.0.1
 */