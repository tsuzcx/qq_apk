package com.tencent.mobileqq.nearby;

import aild;
import aush;
import ausq;
import azmz;
import com.tencent.common.app.BaseApplicationImpl;
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
      aush.c(this.this$0.jdField_a_of_type_JavaLangString);
      long l1 = this.this$0.jdField_a_of_type_Long - this.this$0.c;
      long l2 = this.this$0.d - this.this$0.c;
      long l3 = this.this$0.jdField_b_of_type_Long;
      long l4 = this.this$0.c;
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_DeviceType", aild.a() + "");
      localHashMap.put("param_PreloadType", this.this$0.jdField_b_of_type_Int + "");
      if ((l1 > 0L) && (l1 < 60000L) && (l2 > 0L) && (l2 < 60000L))
      {
        if (this.this$0.jdField_a_of_type_Int != 0) {
          break label261;
        }
        azmz.a(BaseApplicationImpl.getContext()).a(this.this$0.jdField_a_of_type_JavaLangString, "actEnterNearbyActCost", false, l2, l1, localHashMap, "");
      }
      while (QLog.isColorLevel())
      {
        ausq.a("NearbyProcessPerf", new Object[] { Integer.valueOf(this.this$0.jdField_a_of_type_Int), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3 - l4), Integer.valueOf(this.this$0.jdField_b_of_type_Int) });
        return;
        label261:
        if (this.this$0.jdField_a_of_type_Int == 1) {
          azmz.a(BaseApplicationImpl.getContext()).a(this.this$0.jdField_a_of_type_JavaLangString, "actEnterNearbyActCost", true, l2, l1, localHashMap, "");
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyTitleBarActivity.ReportRunnable.1
 * JD-Core Version:    0.7.0.1
 */