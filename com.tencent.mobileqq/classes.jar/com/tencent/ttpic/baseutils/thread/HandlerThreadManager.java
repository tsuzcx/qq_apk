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
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
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
    if (paramString == null) {
      return;
    }
    try
    {
      HandlerThread localHandlerThread = (HandlerThread)this.map.get(paramString);
      if (localHandlerThread == null) {
        return;
      }
      this.map.remove(paramString);
      if (ApiHelper.hasJellyBeanMR2()) {
        localHandlerThread.quitSafely();
      } else {
        localHandlerThread.quit();
      }
      return;
    }
    finally {}
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
      HandlerThread localHandlerThread = (HandlerThread)this.map.get(paramString);
      Object localObject;
      if (localHandlerThread != null)
      {
        localObject = localHandlerThread;
        if (localHandlerThread.isAlive()) {}
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("HTM_");
        ((StringBuilder)localObject).append(paramString);
        localObject = new HandlerThread(((StringBuilder)localObject).toString(), 10);
        ((HandlerThread)localObject).start();
        this.map.put(paramString, localObject);
      }
      return localObject;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.baseutils.thread.HandlerThreadManager
 * JD-Core Version:    0.7.0.1
 */