package com.tencent.mobileqq.utils;

import android.os.SystemClock;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class StartupTracker
{
  public static ConcurrentHashMap<String, Long> a = new ConcurrentHashMap(new HashMap(8));
  public static long b = 0L;
  
  public static void a(String paramString, long paramLong) {}
  
  public static void a(String paramString1, String paramString2) {}
  
  public static long b(String paramString1, String paramString2)
  {
    long l = SystemClock.uptimeMillis();
    if (paramString1 != null)
    {
      paramString1 = (Long)a.remove(paramString1);
      if (paramString1 != null)
      {
        b = l - paramString1.longValue();
        return b;
      }
    }
    else if (paramString2 != null)
    {
      b = 0L;
      a.put(paramString2, Long.valueOf(l));
    }
    return -1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.StartupTracker
 * JD-Core Version:    0.7.0.1
 */