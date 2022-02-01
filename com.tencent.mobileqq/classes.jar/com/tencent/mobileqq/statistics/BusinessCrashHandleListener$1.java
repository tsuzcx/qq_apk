package com.tencent.mobileqq.statistics;

import java.util.Comparator;
import java.util.Map.Entry;

class BusinessCrashHandleListener$1
  implements Comparator<Map.Entry<String, Integer>>
{
  BusinessCrashHandleListener$1(BusinessCrashHandleListener paramBusinessCrashHandleListener) {}
  
  public int a(Map.Entry<String, Integer> paramEntry1, Map.Entry<String, Integer> paramEntry2)
  {
    return -((Integer)paramEntry1.getValue()).compareTo((Integer)paramEntry2.getValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.BusinessCrashHandleListener.1
 * JD-Core Version:    0.7.0.1
 */