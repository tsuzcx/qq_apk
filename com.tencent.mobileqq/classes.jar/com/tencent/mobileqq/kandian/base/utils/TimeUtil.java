package com.tencent.mobileqq.kandian.base.utils;

import android.util.Log;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class TimeUtil
{
  private static String a = "TimeUtil";
  private static ConcurrentHashMap<String, Long> b = new ConcurrentHashMap(new HashMap(8));
  
  public static long a(String paramString)
  {
    if (b.containsKey(paramString))
    {
      long l1 = System.currentTimeMillis();
      long l2 = l1 - ((Long)b.get(paramString)).longValue();
      str = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(" end spent time : ");
      localStringBuilder.append(l2);
      localStringBuilder.append("      end time ");
      localStringBuilder.append(l1);
      Log.d(str, localStringBuilder.toString());
      b.remove(paramString);
      return l2;
    }
    b.put(paramString, Long.valueOf(System.currentTimeMillis()));
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" start time : ");
    localStringBuilder.append(System.currentTimeMillis());
    Log.d(str, localStringBuilder.toString());
    return -1L;
  }
  
  public static long b(String paramString)
  {
    paramString = (Long)b.put(paramString, Long.valueOf(System.currentTimeMillis()));
    if (paramString == null) {
      return -1L;
    }
    return paramString.longValue();
  }
  
  public static long c(String paramString)
  {
    if (b.containsKey(paramString)) {
      return ((Long)b.remove(paramString)).longValue();
    }
    return -1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.utils.TimeUtil
 * JD-Core Version:    0.7.0.1
 */