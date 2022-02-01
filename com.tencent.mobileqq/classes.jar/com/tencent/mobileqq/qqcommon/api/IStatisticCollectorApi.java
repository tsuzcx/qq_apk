package com.tencent.mobileqq.qqcommon.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.HashMap;

@QAPI(process={"all"})
public abstract interface IStatisticCollectorApi
  extends QRouteApi
{
  public abstract void collectPerformance(String paramString1, String paramString2, String paramString3, boolean paramBoolean, long paramLong1, long paramLong2, HashMap<String, String> paramHashMap, String paramString4);
  
  public abstract void collectPerformance(String paramString1, String paramString2, String paramString3, boolean paramBoolean1, long paramLong1, long paramLong2, HashMap<String, String> paramHashMap, String paramString4, boolean paramBoolean2);
  
  public abstract void collectPerformance(String paramString1, String paramString2, String paramString3, boolean paramBoolean1, long paramLong1, long paramLong2, HashMap<String, String> paramHashMap, String paramString4, boolean paramBoolean2, boolean paramBoolean3);
  
  public abstract void collectPerformance(String paramString1, String paramString2, boolean paramBoolean, long paramLong1, long paramLong2, HashMap<String, String> paramHashMap, String paramString3);
  
  public abstract void collectPerformance(String paramString1, String paramString2, boolean paramBoolean1, long paramLong1, long paramLong2, HashMap<String, String> paramHashMap, String paramString3, boolean paramBoolean2);
  
  public abstract void collectPerformance(String paramString1, String paramString2, boolean paramBoolean1, long paramLong1, long paramLong2, HashMap<String, String> paramHashMap, String paramString3, boolean paramBoolean2, boolean paramBoolean3);
  
  public abstract void report(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qqcommon.api.IStatisticCollectorApi
 * JD-Core Version:    0.7.0.1
 */