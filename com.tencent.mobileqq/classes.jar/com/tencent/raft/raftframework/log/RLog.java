package com.tencent.raft.raftframework.log;

public class RLog
{
  private static ILogDelegate sLogDelegate = new DefaultLogDelegate();
  
  public static void d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    sLogDelegate.debug(paramString1, paramString2, paramThrowable);
  }
  
  public static void d(String paramString, Object... paramVarArgs)
  {
    paramVarArgs = getLogMsg(paramVarArgs);
    sLogDelegate.debug(paramString, paramVarArgs.toString());
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    sLogDelegate.error(paramString1, paramString2, paramThrowable);
  }
  
  public static void e(String paramString, Object... paramVarArgs)
  {
    paramVarArgs = getLogMsg(paramVarArgs);
    sLogDelegate.error(paramString, paramVarArgs.toString());
  }
  
  private static StringBuilder getLogMsg(Object... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramVarArgs.length)
    {
      localStringBuilder.append(paramVarArgs[i]);
      i += 1;
    }
    return localStringBuilder;
  }
  
  public static void i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    sLogDelegate.info(paramString1, paramString2, paramThrowable);
  }
  
  public static void i(String paramString, Object... paramVarArgs)
  {
    paramVarArgs = getLogMsg(paramVarArgs);
    sLogDelegate.info(paramString, paramVarArgs.toString());
  }
  
  public static void setLogDelegate(ILogDelegate paramILogDelegate)
  {
    if (paramILogDelegate != null)
    {
      sLogDelegate = paramILogDelegate;
      return;
    }
    sLogDelegate = new DefaultLogDelegate();
  }
  
  public static void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    sLogDelegate.warn(paramString1, paramString2, paramThrowable);
  }
  
  public static void w(String paramString, Object... paramVarArgs)
  {
    paramVarArgs = getLogMsg(paramVarArgs);
    sLogDelegate.warn(paramString, paramVarArgs.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.raft.raftframework.log.RLog
 * JD-Core Version:    0.7.0.1
 */