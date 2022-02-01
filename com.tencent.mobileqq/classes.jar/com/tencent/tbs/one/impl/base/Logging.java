package com.tencent.tbs.one.impl.base;

import android.util.Log;
import java.util.Locale;

public final class Logging
{
  private static final String TAG = "TBSOne";
  private static Logging.LoggingHandler sHandler = new Logging.DefaultLoggingHandler(null);
  
  public static void d(String paramString, Object... paramVarArgs)
  {
    paramString = formatLogWithStack(paramString, getThrowableToLog(paramVarArgs), paramVarArgs);
    sHandler.log(3, paramString);
  }
  
  public static void e(String paramString, Object... paramVarArgs)
  {
    paramString = formatLogWithStack(paramString, getThrowableToLog(paramVarArgs), paramVarArgs);
    sHandler.log(6, paramString);
  }
  
  private static String formatLogWithStack(String paramString, Throwable paramThrowable, Object... paramVarArgs)
  {
    if ((paramVarArgs != null) && (((paramThrowable == null) && (paramVarArgs.length > 0)) || (paramVarArgs.length > 1))) {
      paramString = String.format(Locale.US, paramString, paramVarArgs);
    }
    for (;;)
    {
      paramVarArgs = paramString;
      if (paramThrowable != null) {
        paramVarArgs = paramString + '\n' + Log.getStackTraceString(paramThrowable);
      }
      return paramVarArgs;
    }
  }
  
  private static Throwable getThrowableToLog(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject == null) || (paramArrayOfObject.length == 0)) {
      return null;
    }
    paramArrayOfObject = paramArrayOfObject[(paramArrayOfObject.length - 1)];
    if (!(paramArrayOfObject instanceof Throwable)) {
      return null;
    }
    return (Throwable)paramArrayOfObject;
  }
  
  public static void i(String paramString, Object... paramVarArgs)
  {
    paramString = formatLogWithStack(paramString, getThrowableToLog(paramVarArgs), paramVarArgs);
    sHandler.log(4, paramString);
  }
  
  public static void override(Logging.LoggingHandler paramLoggingHandler)
  {
    if (paramLoggingHandler != null)
    {
      sHandler = paramLoggingHandler;
      return;
    }
    sHandler = new Logging.DefaultLoggingHandler(null);
  }
  
  public static void v(String paramString, Object... paramVarArgs)
  {
    paramString = formatLogWithStack(paramString, getThrowableToLog(paramVarArgs), paramVarArgs);
    sHandler.log(2, paramString);
  }
  
  public static void w(String paramString, Object... paramVarArgs)
  {
    paramString = formatLogWithStack(paramString, getThrowableToLog(paramVarArgs), paramVarArgs);
    sHandler.log(5, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.base.Logging
 * JD-Core Version:    0.7.0.1
 */