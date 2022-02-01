package com.tencent.raft.raftannotation.utils;

import java.io.PrintStream;

public class Log$LogPrinter
{
  public void d(String paramString1, String paramString2)
  {
    System.out.println("[" + paramString1 + "]" + paramString2);
  }
  
  public void e(String paramString1, String paramString2)
  {
    System.out.println("[" + paramString1 + "]" + paramString2);
  }
  
  public void e(String paramString, Throwable paramThrowable)
  {
    System.out.println("[" + paramString + "]" + paramThrowable.toString());
  }
  
  public void i(String paramString1, String paramString2)
  {
    System.out.println("[" + paramString1 + "]" + paramString2);
  }
  
  public void v(String paramString1, String paramString2)
  {
    System.out.println("[" + paramString1 + "]" + paramString2);
  }
  
  public void w(String paramString1, String paramString2)
  {
    System.out.println("[" + paramString1 + "]" + paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.raft.raftannotation.utils.Log.LogPrinter
 * JD-Core Version:    0.7.0.1
 */