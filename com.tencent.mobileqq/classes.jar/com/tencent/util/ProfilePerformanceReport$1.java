package com.tencent.util;

import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class ProfilePerformanceReport$1
  implements Runnable
{
  ProfilePerformanceReport$1(ProfilePerformanceReport paramProfilePerformanceReport, String paramString, long paramLong, HashMap paramHashMap) {}
  
  public void run()
  {
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.jdField_a_of_type_JavaLangString, ProfilePerformanceReport.a(this.this$0), true, this.jdField_a_of_type_Long, 0L, this.jdField_a_of_type_JavaUtilHashMap, "");
    if (QLog.isDevelopLevel()) {
      QLog.i("ProfilePerformanceReport", 4, "end of report");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.util.ProfilePerformanceReport.1
 * JD-Core Version:    0.7.0.1
 */