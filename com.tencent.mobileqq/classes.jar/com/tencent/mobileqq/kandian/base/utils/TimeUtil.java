package com.tencent.mobileqq.kandian.base.utils;

import android.util.Log;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class TimeUtil
{
  private static String jdField_a_of_type_JavaLangString = "TimeUtil";
  private static ConcurrentHashMap<String, Long> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(new HashMap(8));
  
  public static long a(String paramString)
  {
    if (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))
    {
      long l1 = System.currentTimeMillis();
      long l2 = l1 - ((Long)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString)).longValue();
      str = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(" end spent time : ");
      localStringBuilder.append(l2);
      localStringBuilder.append("      end time ");
      localStringBuilder.append(l1);
      Log.d(str, localStringBuilder.toString());
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
      return l2;
    }
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Long.valueOf(System.currentTimeMillis()));
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" start time : ");
    localStringBuilder.append(System.currentTimeMillis());
    Log.d(str, localStringBuilder.toString());
    return -1L;
  }
  
  public static long b(String paramString)
  {
    paramString = (Long)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Long.valueOf(System.currentTimeMillis()));
    if (paramString == null) {
      return -1L;
    }
    return paramString.longValue();
  }
  
  public static long c(String paramString)
  {
    if (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString)) {
      return ((Long)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString)).longValue();
    }
    return -1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.utils.TimeUtil
 * JD-Core Version:    0.7.0.1
 */