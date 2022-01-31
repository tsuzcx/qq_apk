package com.tencent.tmassistantbase.util;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class l
{
  public static Map<m, Handler> a = new ConcurrentHashMap();
  private static Handler b;
  
  public static Handler a()
  {
    if (b == null) {
      b = b(m.a);
    }
    return b;
  }
  
  public static Looper a(m paramm)
  {
    return b(paramm).getLooper();
  }
  
  private static Handler b(m paramm)
  {
    if (a.containsKey(paramm)) {
      return (Handler)a.get(paramm);
    }
    Object localObject = new HandlerThread(paramm.name());
    ((HandlerThread)localObject).start();
    localObject = new Handler(((HandlerThread)localObject).getLooper());
    a.put(paramm, localObject);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.tmassistantbase.util.l
 * JD-Core Version:    0.7.0.1
 */