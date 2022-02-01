package com.tencent.raft.codegenmeta.utils;

import java.io.PrintStream;

public class RLog
{
  public static final String DEBUG = "DEBUG";
  public static final String ERROR = "ERROR";
  public static final String WARN = " WARN";
  
  public static void d(String paramString, Object... paramVarArgs)
  {
    paramVarArgs = getLogMsg(paramVarArgs);
    System.out.println(format("DEBUG", paramString, paramVarArgs.toString()));
  }
  
  public static void e(String paramString, Object... paramVarArgs)
  {
    paramVarArgs = getLogMsg(paramVarArgs);
    System.out.println(format("ERROR", paramString, paramVarArgs.toString()));
  }
  
  private static String format(String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("] [");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("] ");
    localStringBuilder.append(paramString3);
    return localStringBuilder.toString();
  }
  
  private static StringBuilder getLogMsg(Object... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(paramVarArgs[i]);
      i += 1;
    }
    return localStringBuilder;
  }
  
  public static void w(String paramString, Object... paramVarArgs)
  {
    paramVarArgs = getLogMsg(paramVarArgs);
    System.out.println(format(" WARN", paramString, paramVarArgs.toString()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.raft.codegenmeta.utils.RLog
 * JD-Core Version:    0.7.0.1
 */