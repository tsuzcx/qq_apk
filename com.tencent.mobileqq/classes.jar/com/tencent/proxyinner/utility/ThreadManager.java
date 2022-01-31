package com.tencent.proxyinner.utility;

import android.os.Handler;
import android.os.HandlerThread;

public class ThreadManager
{
  public static volatile HandlerThread FILE_HANDLER_THREAD = null;
  public static volatile Handler FILE_THREAD_HANDLER = null;
  
  public static Handler getFileThreadHandler()
  {
    if (FILE_HANDLER_THREAD == null) {}
    try
    {
      FILE_HANDLER_THREAD = new HandlerThread("nowlive_install", 0);
      FILE_HANDLER_THREAD.start();
      FILE_THREAD_HANDLER = new Handler(FILE_HANDLER_THREAD.getLooper());
      return FILE_THREAD_HANDLER;
    }
    finally {}
  }
  
  public static void unInit()
  {
    try
    {
      if (FILE_HANDLER_THREAD != null)
      {
        FILE_HANDLER_THREAD.quit();
        FILE_HANDLER_THREAD = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.proxyinner.utility.ThreadManager
 * JD-Core Version:    0.7.0.1
 */