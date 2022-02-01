package com.tencent.mobileqq.imcore.proxy;

import java.util.HashMap;

public class IMCoreProxyRoute$StatisticCollector
{
  public static final String DB_OP_RESULT = "DatabaseOperatorResult_";
  private static IMCoreProxyRoute.StatisticCollector.Proxy StatisticCollectorProxy;
  
  public static void collectPerformance(String paramString1, String paramString2, boolean paramBoolean, long paramLong1, long paramLong2, HashMap<String, String> paramHashMap, String paramString3)
  {
    if (StatisticCollectorProxy != null) {
      StatisticCollectorProxy.collectPerformance(paramString1, paramString2, paramBoolean, paramLong1, paramLong2, paramHashMap, paramString3);
    }
  }
  
  public static void collectPerformance(String paramString1, String paramString2, boolean paramBoolean1, long paramLong1, long paramLong2, HashMap<String, String> paramHashMap, String paramString3, boolean paramBoolean2)
  {
    if (StatisticCollectorProxy != null) {
      StatisticCollectorProxy.collectPerformance(paramString1, paramString2, paramBoolean1, paramLong1, paramLong2, paramHashMap, paramString3, paramBoolean2);
    }
  }
  
  public static void registerProxy(IMCoreProxyRoute.StatisticCollector.Proxy paramProxy)
  {
    StatisticCollectorProxy = paramProxy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.imcore.proxy.IMCoreProxyRoute.StatisticCollector
 * JD-Core Version:    0.7.0.1
 */