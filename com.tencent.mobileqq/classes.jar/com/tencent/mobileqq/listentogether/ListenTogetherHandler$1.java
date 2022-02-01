package com.tencent.mobileqq.listentogether;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.StatisticCollector;
import java.util.HashMap;

class ListenTogetherHandler$1
  implements Runnable
{
  ListenTogetherHandler$1(ListenTogetherHandler paramListenTogetherHandler, long paramLong1, long paramLong2, int paramInt, long paramLong3) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("server_request", String.valueOf(this.a - this.b));
    localHashMap.put("serverInterval", String.valueOf(this.a));
    localHashMap.put("requestInterval", String.valueOf(this.b));
    localHashMap.put("reportType", String.valueOf(this.c));
    localHashMap.put("interval", String.valueOf(this.d));
    StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance("", "listen_together_seek_adjust", true, 0L, 0L, localHashMap, "", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ListenTogetherHandler.1
 * JD-Core Version:    0.7.0.1
 */