package com.tencent.mobileqq.qqcommon.api.impl;

import com.tencent.mobileqq.qqcommon.api.IStatisticCollectorApi;
import com.tencent.mobileqq.statistics.StatisticCollector;
import java.util.HashMap;
import mqq.app.MobileQQ;

public class StatisticCollectorApiImpl
  implements IStatisticCollectorApi
{
  public void collectPerformance(String paramString1, String paramString2, String paramString3, boolean paramBoolean, long paramLong1, long paramLong2, HashMap<String, String> paramHashMap, String paramString4)
  {
    collectPerformance(paramString1, paramString2, paramString3, paramBoolean, paramLong1, paramLong2, paramHashMap, paramString4, false, false);
  }
  
  public void collectPerformance(String paramString1, String paramString2, String paramString3, boolean paramBoolean1, long paramLong1, long paramLong2, HashMap<String, String> paramHashMap, String paramString4, boolean paramBoolean2)
  {
    collectPerformance(paramString1, paramString2, paramString3, paramBoolean1, paramLong1, paramLong2, paramHashMap, paramString4, paramBoolean2, false);
  }
  
  public void collectPerformance(String paramString1, String paramString2, String paramString3, boolean paramBoolean1, long paramLong1, long paramLong2, HashMap<String, String> paramHashMap, String paramString4, boolean paramBoolean2, boolean paramBoolean3)
  {
    StatisticCollector.getInstance(MobileQQ.context).collectPerformance(paramString1, paramString2, paramString3, paramBoolean1, paramLong1, paramLong2, paramHashMap, paramString4, paramBoolean2, paramBoolean3);
  }
  
  public void collectPerformance(String paramString1, String paramString2, boolean paramBoolean, long paramLong1, long paramLong2, HashMap<String, String> paramHashMap, String paramString3)
  {
    collectPerformance("", paramString1, paramString2, paramBoolean, paramLong1, paramLong2, paramHashMap, paramString3, false, false);
  }
  
  public void collectPerformance(String paramString1, String paramString2, boolean paramBoolean1, long paramLong1, long paramLong2, HashMap<String, String> paramHashMap, String paramString3, boolean paramBoolean2)
  {
    collectPerformance("", paramString1, paramString2, paramBoolean1, paramLong1, paramLong2, paramHashMap, paramString3, paramBoolean2, false);
  }
  
  public void collectPerformance(String paramString1, String paramString2, boolean paramBoolean1, long paramLong1, long paramLong2, HashMap<String, String> paramHashMap, String paramString3, boolean paramBoolean2, boolean paramBoolean3)
  {
    collectPerformance("", paramString1, paramString2, paramBoolean1, paramLong1, paramLong2, paramHashMap, paramString3, paramBoolean2, paramBoolean3);
  }
  
  public void report(String paramString)
  {
    StatisticCollector.report(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqcommon.api.impl.StatisticCollectorApiImpl
 * JD-Core Version:    0.7.0.1
 */