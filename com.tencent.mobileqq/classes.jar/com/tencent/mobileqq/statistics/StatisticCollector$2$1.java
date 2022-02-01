package com.tencent.mobileqq.statistics;

import java.util.Comparator;
import java.util.Map.Entry;

class StatisticCollector$2$1
  implements Comparator<Map.Entry<String, Integer>>
{
  StatisticCollector$2$1(StatisticCollector.2 param2) {}
  
  public int compare(Map.Entry<String, Integer> paramEntry1, Map.Entry<String, Integer> paramEntry2)
  {
    return -((Integer)paramEntry1.getValue()).compareTo((Integer)paramEntry2.getValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.StatisticCollector.2.1
 * JD-Core Version:    0.7.0.1
 */