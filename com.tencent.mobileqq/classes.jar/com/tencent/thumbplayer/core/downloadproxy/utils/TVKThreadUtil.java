package com.tencent.thumbplayer.core.downloadproxy.utils;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class TVKThreadUtil
{
  private static volatile ScheduledExecutorService mScheduler;
  
  public static ScheduledExecutorService getScheduledExecutorServiceInstance()
  {
    if (mScheduler == null) {
      try
      {
        if (mScheduler == null) {
          mScheduler = Executors.newScheduledThreadPool(4);
        }
      }
      finally {}
    }
    return mScheduler;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.utils.TVKThreadUtil
 * JD-Core Version:    0.7.0.1
 */