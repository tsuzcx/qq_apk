package com.tencent.qg.sdk.log;

import android.util.Log;

public class DefaultLog
  implements IQLog
{
  private static String formatString(String paramString, Object... paramVarArgs)
  {
    return String.format(null, paramString, paramVarArgs);
  }
  
  public void a(String paramString1, String paramString2)
  {
    Log.i(paramString1, paramString2);
  }
  
  public void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    Log.i(paramString1, paramString2, paramThrowable);
  }
  
  public void d(String paramString1, String paramString2)
  {
    Log.d(paramString1, paramString2);
  }
  
  public void d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    Log.d(paramString1, paramString2, paramThrowable);
  }
  
  public void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    Log.d(paramString1, formatString(paramString2, paramVarArgs));
  }
  
  public void e(String paramString1, String paramString2)
  {
    Log.e(paramString1, paramString2);
  }
  
  public void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    Log.e(paramString1, paramString2, paramThrowable);
  }
  
  public void i(String paramString1, String paramString2)
  {
    Log.i(paramString1, paramString2);
  }
  
  public void i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    Log.i(paramString1, paramString2, paramThrowable);
  }
  
  public void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    Log.i(paramString1, formatString(paramString2, paramVarArgs));
  }
  
  public void v(String paramString1, String paramString2)
  {
    Log.v(paramString1, paramString2);
  }
  
  public void v(String paramString1, String paramString2, Throwable paramThrowable)
  {
    Log.v(paramString1, paramString2, paramThrowable);
  }
  
  public void w(String paramString1, String paramString2)
  {
    Log.i(paramString1, paramString2);
  }
  
  public void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    Log.w(paramString1, paramString2, paramThrowable);
  }
  
  public void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    Log.w(paramString1, formatString(paramString2, paramVarArgs));
  }
  
  public void w(String paramString, Throwable paramThrowable)
  {
    Log.w(paramString, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qg.sdk.log.DefaultLog
 * JD-Core Version:    0.7.0.1
 */