package com.tencent.raft.raftframework.log;

import android.util.Log;

public class DefaultLogDelegate
  implements ILogDelegate
{
  public void debug(String paramString1, String paramString2)
  {
    Log.d(paramString1, paramString2);
  }
  
  public void debug(String paramString1, String paramString2, Throwable paramThrowable)
  {
    Log.d(paramString1, paramString2, paramThrowable);
  }
  
  public void error(String paramString1, String paramString2)
  {
    Log.e(paramString1, paramString2);
  }
  
  public void error(String paramString1, String paramString2, Throwable paramThrowable)
  {
    Log.e(paramString1, paramString2, paramThrowable);
  }
  
  public void info(String paramString1, String paramString2)
  {
    Log.i(paramString1, paramString2);
  }
  
  public void info(String paramString1, String paramString2, Throwable paramThrowable)
  {
    Log.i(paramString1, paramString2, paramThrowable);
  }
  
  public void warn(String paramString1, String paramString2)
  {
    Log.w(paramString1, paramString2);
  }
  
  public void warn(String paramString1, String paramString2, Throwable paramThrowable)
  {
    Log.w(paramString1, paramString2, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.raft.raftframework.log.DefaultLogDelegate
 * JD-Core Version:    0.7.0.1
 */