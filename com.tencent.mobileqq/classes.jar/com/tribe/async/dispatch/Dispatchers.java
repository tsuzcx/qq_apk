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
    Object localObject2 = (Dispatcher)sDispatcherMap.get(Long.valueOf(paramLooper.getThread().getId()));
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = new DefaultDispatcher(paramLooper);
      localObject1 = (Dispatcher)sDispatcherMap.putIfAbsent(Long.valueOf(paramLooper.getThread().getId()), localObject2);
      if (localObject1 == null) {}
    }
    else
    {
      return localObject1;
    }
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tribe.async.dispatch.Dispatchers
 * JD-Core Version:    0.7.0.1
 */