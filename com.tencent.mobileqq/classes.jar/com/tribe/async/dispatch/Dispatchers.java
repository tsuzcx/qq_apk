package com.tribe.async.dispatch;

import android.os.Looper;
import android.support.annotation.NonNull;
import com.tribe.async.utils.AssertUtils;
import java.util.concurrent.ConcurrentHashMap;

public class Dispatchers
{
  private static final ConcurrentHashMap<Long, Dispatcher> sDispatcherMap = new ConcurrentHashMap();
  
  @NonNull
  public static Dispatcher get(@NonNull Looper paramLooper)
  {
    AssertUtils.checkNotNull(paramLooper);
    Dispatcher localDispatcher = (Dispatcher)sDispatcherMap.get(Long.valueOf(paramLooper.getThread().getId()));
    Object localObject = localDispatcher;
    if (localDispatcher == null)
    {
      localObject = new DefaultDispatcher(paramLooper);
      paramLooper = (Dispatcher)sDispatcherMap.putIfAbsent(Long.valueOf(paramLooper.getThread().getId()), localObject);
      if (paramLooper != null) {
        localObject = paramLooper;
      }
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tribe.async.dispatch.Dispatchers
 * JD-Core Version:    0.7.0.1
 */