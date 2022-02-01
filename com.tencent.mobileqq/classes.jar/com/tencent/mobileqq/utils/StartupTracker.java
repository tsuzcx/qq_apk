package com.tencent.mobileqq.utils;

import android.os.SystemClock;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class StartupTracker
{
  public static long a;
  public static ConcurrentHashMap<String, Long> a;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(new HashMap(8));
    jdField_a_of_type_Long = 0L;
  }
  
  public static long a(String paramString1, String paramString2)
  {
    long l = SystemClock.uptimeMillis();
    if (paramString1 != null)
    {
      paramString1 = (Long)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString1);
      if (paramString1 != null)
      {
        jdField_a_of_type_Long = l - paramString1.longValue();
        return jdField_a_of_type_Long;
      }
    }
    else if (paramString2 != null)
    {
      jdField_a_of_type_Long = 0L;
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString2, Long.valueOf(l));
    }
    return -1L;
  }
  
  public static void a(String paramString, long paramLong) {}
  
  public static void a(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.StartupTracker
 * JD-Core Version:    0.7.0.1
 */