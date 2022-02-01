package com.tencent.mobileqq.imcore.proxy.basic;

import java.util.HashMap;

public class StatisticCollectorProxy
{
  public static final String DB_OP_RESULT = "DatabaseOperatorResult_";
  private static StatisticCollectorProxy.Proxy proxy;
  
  public static void collectPerformance(String paramString1, String paramString2, boolean paramBoolean, long paramLong1, long paramLong2, HashMap<String, String> paramHashMap, String paramString3)
  {
    StatisticCollectorProxy.Proxy localProxy = proxy;
    if (localProxy != null) {
      localProxy.collectPerformance(paramString1, paramString2, paramBoolean, paramLong1, paramLong2, paramHashMap, paramString3);
    }
  }
  
  public static void collectPerformance(String paramString1, String paramString2, boolean paramBoolean1, long paramLong1, long paramLong2, HashMap<String, String> paramHashMap, String paramString3, boolean paramBoolean2)
  {
    StatisticCollectorProxy.Proxy localProxy = proxy;
    if (localProxy != null) {
      localProxy.collectPerformance(paramString1, paramString2, paramBoolean1, paramLong1, paramLong2, paramHashMap, paramString3, paramBoolean2);
    }
  }
  
  public static void registerProxy(StatisticCollectorProxy.Proxy paramProxy)
  {
    proxy = paramProxy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.imcore.proxy.basic.StatisticCollectorProxy
 * JD-Core Version:    0.7.0.1
 */