package com.tribe.async.dispatch;

import android.os.HandlerThread;
import android.support.annotation.NonNull;

public class Dispatchers
{
  private static volatile Dispatcher sDispatcher;
  
  @NonNull
  public static Dispatcher get()
  {
    if (sDispatcher != null) {
      return sDispatcher;
    }
    try
    {
      if (sDispatcher != null)
      {
        Dispatcher localDispatcher = sDispatcher;
        return localDispatcher;
      }
    }
    finally {}
    Object localObject2 = new HandlerThread("dispatcher", 10);
    ((HandlerThread)localObject2).start();
    sDispatcher = new DefaultDispatcher(((HandlerThread)localObject2).getLooper());
    localObject2 = sDispatcher;
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tribe.async.dispatch.Dispatchers
 * JD-Core Version:    0.7.0.1
 */