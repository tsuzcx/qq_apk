package com.tencent.mobileqq.richmedia.ordersend;

import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class OrderMediaMsgReporter
{
  public static void a(int paramInt1, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("msgType", String.valueOf(paramInt1));
    localHashMap.put("idType", String.valueOf(paramInt2));
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "OrderMediaMsgAddTimeout", false, 0L, 0L, localHashMap, "");
  }
  
  public static void a(int paramInt, long paramLong)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("totalSize", String.valueOf(paramInt));
    localHashMap.put("totalCost", String.valueOf(paramLong));
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "OrderMediaMsgCompleteInfo", true, paramLong, paramInt, localHashMap, "");
  }
  
  public static void a(int paramInt, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("msgType", String.valueOf(paramInt));
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "OrderMediaMsgSendTimeout", paramBoolean ^ true, 0L, 0L, localHashMap, "");
  }
  
  public static void b(int paramInt1, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("totalSize", String.valueOf(paramInt1));
    localHashMap.put("mediaSize", String.valueOf(paramInt2));
    StatisticCollector localStatisticCollector = StatisticCollector.getInstance(BaseApplication.getContext());
    boolean bool;
    if (paramInt2 > 0) {
      bool = true;
    } else {
      bool = false;
    }
    localStatisticCollector.collectPerformance(null, "OrderMediaMsgMultiSeperate", bool, 0L, paramInt1, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgReporter
 * JD-Core Version:    0.7.0.1
 */