package com.tencent.mobileqq.vas.util;

import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class VasMonitorDT
{
  public static void a(String paramString, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("authResult", String.valueOf(paramInt));
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", paramString, false, 0L, -1L, localHashMap, "", true);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("errCode", paramString2);
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", paramString1, false, 0L, -1L, localHashMap, "", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.util.VasMonitorDT
 * JD-Core Version:    0.7.0.1
 */