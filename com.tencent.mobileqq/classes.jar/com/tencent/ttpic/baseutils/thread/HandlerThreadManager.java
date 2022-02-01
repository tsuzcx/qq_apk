package com.tencent.ttpic.baseutils.thread;

import android.os.HandlerThread;
import com.tencent.ttpic.baseutils.api.ApiHelper;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public enum HandlerThreadManager
{
  INSTANCE;
  
  private static final String PREFIX = "HTM_";
  public static int THREAD_DESTROY_TIME_OUT_MILLS = 5000;
  private Map<String, HandlerThread> map = new HashMap();
  
  private HandlerThreadManager() {}
  
  public static HandlerThreadManager getInstance()
  {
    return INSTANCE;
  }
  
  public void destroy()
  {
    try
    {
      Iterator localIterator = this.map.values().iterator();
      while (localIterator.hasNext()) {
        ((HandlerThread)localIterator.next()).quit();
      }
      this.map.clear();
    }
    finally {}
  }
  
  public void destroyHandlerThread(HandlerThreadTag paramHandlerThreadTag)
  {
    try
    {
      destroyHandlerThread(paramHandlerThreadTag.name());
      return;
    }
    finally
    {
      paramHandlerThreadTag = finally;
      throw paramHandlerThreadTag;
    }
  }
  
  public void destroyHandlerThread(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return;
      HandlerThread localHandlerThread;
      try
      {
        localHandlerThread = (HandlerThread)this.map.get(paramString);
        if (localHandlerThread == null) {
          continue;
        }
        this.map.remove(paramString);
        if (ApiHelper.hasJellyBeanMR2())
        {
          localHandlerThread.quitSafely();
          continue;
        }
      }
      finally {}
      localHandlerThread.quit();
    }
  }
  
  public HandlerThread getHandlerThread(HandlerThreadTag paramHandlerThreadTag)
  {
    try
    {
      paramHandlerThreadTag = getHandlerThread(paramHandlerThreadTag.name());
      return paramHandlerThreadTag;
    }
    finally
    {
      paramHandlerThreadTag = finally;
      throw paramHandlerThreadTag;
    }
  }
  
  public HandlerThread getHandlerThread(String paramString)
  {
    try
    {
      HandlerThread localHandlerThread2 = (HandlerThread)this.map.get(paramString);
      HandlerThread localHandlerThread1;
      if (localHandlerThread2 != null)
      {
        localHandlerThread1 = localHandlerThread2;
        if (localHandlerThread2.isAlive()) {}
      }
      else
      {
        localHandlerThread1 = new HandlerThread("HTM_" + paramString, 10);
        localHandlerThread1.start();
        this.map.put(paramString, localHandlerThread1);
      }
      return localHandlerThread1;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.baseutils.thread.HandlerThreadManager
 * JD-Core Version:    0.7.0.1
 */