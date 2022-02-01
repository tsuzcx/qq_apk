package com.tencent.raft.raftannotation.utils;

import java.io.PrintStream;

public class Log$LogPrinter
{
  public void d(String paramString1, String paramString2)
  {
    PrintStream localPrintStream = System.out;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("]");
    localStringBuilder.append(paramString2);
    localPrintStream.println(localStringBuilder.toString());
  }
  
  public void e(String paramString1, String paramString2)
  {
    PrintStream localPrintStream = System.out;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("]");
    localStringBuilder.append(paramString2);
    localPrintStream.println(localStringBuilder.toString());
  }
  
  public void e(String paramString, Throwable paramThrowable)
  {
    PrintStream localPrintStream = System.out;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("]");
    localStringBuilder.append(paramThrowable.toString());
    localPrintStream.println(localStringBuilder.toString());
  }
  
  public void i(String paramString1, String paramString2)
  {
    PrintStream localPrintStream = System.out;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("]");
    localStringBuilder.append(paramString2);
    localPrintStream.println(localStringBuilder.toString());
  }
  
  public void v(String paramString1, String paramString2)
  {
    PrintStream localPrintStream = System.out;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("]");
    localStringBuilder.append(paramString2);
    localPrintStream.println(localStringBuilder.toString());
  }
  
  public void w(String paramString1, String paramString2)
  {
    PrintStream localPrintStream = System.out;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("]");
    localStringBuilder.append(paramString2);
    localPrintStream.println(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.raft.raftannotation.utils.Log.LogPrinter
 * JD-Core Version:    0.7.0.1
 */