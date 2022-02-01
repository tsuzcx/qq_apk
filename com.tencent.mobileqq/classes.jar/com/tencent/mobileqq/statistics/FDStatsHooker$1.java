package com.tencent.mobileqq.statistics;

import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;

final class FDStatsHooker$1
  implements Runnable
{
  FDStatsHooker$1(StringBuilder paramStringBuilder, HashMap paramHashMap) {}
  
  public void run()
  {
    if (System.currentTimeMillis() - FDStatsHooker.lastLogTime > 10000L)
    {
      QLog.d("FDStats", 1, this.a.toString());
      FDStatsHooker.lastLogTime = System.currentTimeMillis();
    }
    String str1 = (String)this.b.get("filePath");
    String str2 = (String)this.b.get("method:");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str1);
    localStringBuilder.append(str2);
    str1 = localStringBuilder.toString();
    if (!FDStatsHooker.access$000().containsKey(str1))
    {
      int i;
      if (Math.random() <= 0.001D) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        StatisticCollector.getInstance(MobileQQ.sMobileQQ).collectPerformance(null, "actNotifyFDError", true, 0L, 0L, this.b, "");
      }
      FDNative.a(FDNative.e() + 1);
      FDStatsHooker.access$000().put(str1, Integer.valueOf(1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.FDStatsHooker.1
 * JD-Core Version:    0.7.0.1
 */