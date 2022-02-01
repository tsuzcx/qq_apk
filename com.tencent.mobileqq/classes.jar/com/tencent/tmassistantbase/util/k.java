package com.tencent.tmassistantbase.util;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class k
{
  public static Map<l, Handler> a = new ConcurrentHashMap();
  private static Handler b;
  
  public static Handler a()
  {
    if (b == null) {
      b = b(l.a);
    }
    return b;
  }
  
  public static Looper a(l paraml)
  {
    return b(paraml).getLooper();
  }
  
  private static Handler b(l paraml)
  {
    if (a.containsKey(paraml)) {
      return (Handler)a.get(paraml);
    }
    Object localObject = new HandlerThread(paraml.name());
    ((HandlerThread)localObject).start();
    localObject = new Handler(((HandlerThread)localObject).getLooper());
    a.put(paraml, localObject);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmassistantbase.util.k
 * JD-Core Version:    0.7.0.1
 */