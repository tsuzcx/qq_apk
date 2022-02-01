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
      ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).enterNearbyProcess(this.this$0.jdField_a_of_type_JavaLangString);
      long l1 = this.this$0.jdField_a_of_type_Long - this.this$0.c;
      long l2 = this.this$0.d - this.this$0.c;
      long l3 = this.this$0.jdField_b_of_type_Long;
      long l4 = this.this$0.c;
      HashMap localHashMap = new HashMap();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(DeviceInfoUtil.f());
      localStringBuilder.append("");
      localHashMap.put("param_DeviceType", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.this$0.jdField_b_of_type_Int);
      localStringBuilder.append("");
      localHashMap.put("param_PreloadType", localStringBuilder.toString());
      if ((l1 > 0L) && (l1 < 60000L) && (l2 > 0L) && (l2 < 60000L)) {
        if (this.this$0.jdField_a_of_type_Int == 0) {
          StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(this.this$0.jdField_a_of_type_JavaLangString, "actEnterNearbyActCost", false, l2, l1, localHashMap, "");
        } else if (this.this$0.jdField_a_of_type_Int == 1) {
          StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(this.this$0.jdField_a_of_type_JavaLangString, "actEnterNearbyActCost", true, l2, l1, localHashMap, "");
        }
      }
      if (QLog.isColorLevel())
      {
        NearbyUtils.a("NearbyProcessPerf", new Object[] { Integer.valueOf(this.this$0.jdField_a_of_type_Int), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3 - l4), Integer.valueOf(this.this$0.jdField_b_of_type_Int) });
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyTitleBarActivity.ReportRunnable.1
 * JD-Core Version:    0.7.0.1
 */