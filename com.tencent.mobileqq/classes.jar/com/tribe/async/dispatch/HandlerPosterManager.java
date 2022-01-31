package com.tribe.async.dispatch;

import android.os.Looper;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HandlerPosterManager
{
  private static final int MAX_DISPATCH_RUN_TIME = 200;
  private final Map<Looper, HandlerPoster> mHandlerPosterMap = new ConcurrentHashMap(2);
  
  public static HandlerPosterManager instance()
  {
    return InstanceHolder.sInstance;
  }
  
  public HandlerPoster getHandlerPoster(Looper paramLooper)
  {
    HandlerPoster localHandlerPoster2 = (HandlerPoster)this.mHandlerPosterMap.get(paramLooper);
    HandlerPoster localHandlerPoster1 = localHandlerPoster2;
    if (localHandlerPoster2 == null)
    {
      localHandlerPoster1 = new HandlerPoster(paramLooper, 200);
      this.mHandlerPosterMap.put(paramLooper, localHandlerPoster1);
    }
    return localHandlerPoster1;
  }
  
  private static class InstanceHolder
  {
    public static HandlerPosterManager sInstance = new HandlerPosterManager(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tribe.async.dispatch.HandlerPosterManager
 * JD-Core Version:    0.7.0.1
 */