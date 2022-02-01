package com.tencent.qqmini.sdk.monitor.service;

import android.os.Handler;

public class MonitorHandlerThread
{
  private static MonitorHandlerThread.HT loopThread;
  private static MonitorHandlerThread.HT writeLogThread;
  
  public static Handler getLooperThreadHandler()
  {
    if (loopThread == null) {
      loopThread = new MonitorHandlerThread.HT("loop", null);
    }
    return loopThread.getHandler();
  }
  
  public static Handler getWriteFileHandler()
  {
    if (writeLogThread == null) {
      writeLogThread = new MonitorHandlerThread.HT("writelog", null);
    }
    return writeLogThread.getHandler();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.monitor.service.MonitorHandlerThread
 * JD-Core Version:    0.7.0.1
 */