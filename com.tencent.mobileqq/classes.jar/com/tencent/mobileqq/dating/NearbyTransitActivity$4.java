package com.tencent.mobileqq.dating;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

final class NearbyTransitActivity$4
  implements Runnable
{
  NearbyTransitActivity$4(int paramInt, String paramString, boolean paramBoolean, long paramLong) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(this.a));
    StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(this.b, "actEnterHotChatAIO", this.c, this.d, this.a, localHashMap, "");
    if (QLog.isDevelopLevel()) {
      NearbyUtils.a("NearbyTransitActivity", "reportResult", new Object[] { "end of report" });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dating.NearbyTransitActivity.4
 * JD-Core Version:    0.7.0.1
 */