package com.tencent.mobileqq.nearby;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class NearbyTitleBarActivity$ReportRunnable$1
  implements Runnable
{
  NearbyTitleBarActivity$ReportRunnable$1(NearbyTitleBarActivity.ReportRunnable paramReportRunnable) {}
  
  public void run()
  {
    try
    {
      ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).enterNearbyProcess(this.this$0.c);
      long l1 = this.this$0.d - this.this$0.f;
      long l2 = this.this$0.g - this.this$0.f;
      long l3 = this.this$0.e;
      long l4 = this.this$0.f;
      HashMap localHashMap = new HashMap();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(DeviceInfoUtil.O());
      localStringBuilder.append("");
      localHashMap.put("param_DeviceType", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.this$0.b);
      localStringBuilder.append("");
      localHashMap.put("param_PreloadType", localStringBuilder.toString());
      if ((l1 > 0L) && (l1 < 60000L) && (l2 > 0L) && (l2 < 60000L)) {
        if (this.this$0.a == 0) {
          StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(this.this$0.c, "actEnterNearbyActCost", false, l2, l1, localHashMap, "");
        } else if (this.this$0.a == 1) {
          StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(this.this$0.c, "actEnterNearbyActCost", true, l2, l1, localHashMap, "");
        }
      }
      if (QLog.isColorLevel())
      {
        NearbyUtils.a("NearbyProcessPerf", new Object[] { Integer.valueOf(this.this$0.a), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3 - l4), Integer.valueOf(this.this$0.b) });
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyTitleBarActivity.ReportRunnable.1
 * JD-Core Version:    0.7.0.1
 */