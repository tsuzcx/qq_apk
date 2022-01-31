package com.tencent.tvkbeacon.core.c;

import android.util.Log;
import java.util.Locale;

public class c
{
  public static boolean a = false;
  public static boolean b = false;
  public static boolean c = false;
  
  private static int a(StackTraceElement[] paramArrayOfStackTraceElement, Class paramClass)
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
  
  public static void a(String paramString, Object... paramVarArgs)
  {
    if (a()) {
      Log.i("tvkbeacon", i(paramString, paramVarArgs));
    }
  }
  
  public static void a(Throwable paramThrowable)
  {
    if (a())
    {
      paramThrowable.printStackTrace();
      return;
    }
    d(paramThrowable.getMessage(), new Object[0]);
  }
  
  private static boolean a()
  {
    return a;
  }
  
  private static StackTraceElement b()
  {
    StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
    int j = a(arrayOfStackTraceElement, c.class);
    int i = j;
    if (j == -1)
    {
      j = a(arrayOfStackTraceElement, Log.class);
      i = j;
      if (j == -1) {
        return null;
      }
    }
    return arrayOfStackTraceElement[i];
  }
  
  public static void b(String paramString, Object... paramVarArgs)
  {
    if (a()) {
      Log.d("tvkbeacon", i(paramString, paramVarArgs));
    }
  }
  
  private static String c()
  {
    if (c)
    {
      StackTraceElement localStackTraceElement = b();
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
  
  public static void c(String paramString, Object... paramVarArgs)
  {
    if (a()) {
      Log.w("tvkbeacon", i(paramString, paramVarArgs));
    }
  }
  
  public static void d(String paramString, Object... paramVarArgs)
  {
    if (a()) {
      Log.e("tvkbeacon", i(paramString, paramVarArgs));
    }
  }
  
  public static void e(String paramString, Object... paramVarArgs)
  {
    if (a()) {
      Log.d("tvkbeacon_step_api", i(paramString, paramVarArgs));
    }
  }
  
  public static void f(String paramString, Object... paramVarArgs)
  {
    if (a()) {
      Log.d("tvkbeacon_step_buffer", i(paramString, paramVarArgs));
    }
  }
  
  public static void g(String paramString, Object... paramVarArgs)
  {
    if (a()) {
      Log.d("tvkbeacon_step_db", i(paramString, paramVarArgs));
    }
  }
  
  public static void h(String paramString, Object... paramVarArgs)
  {
    if (a()) {
      Log.d("tvkbeacon_step_upload", i(paramString, paramVarArgs));
    }
  }
  
  private static String i(String paramString, Object... paramVarArgs)
  {
    String str = c();
    if (paramString == null) {
      return str + "msg is null";
    }
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {
      return str + paramString;
    }
    return str + String.format(Locale.US, paramString, paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tvkbeacon.core.c.c
 * JD-Core Version:    0.7.0.1
 */