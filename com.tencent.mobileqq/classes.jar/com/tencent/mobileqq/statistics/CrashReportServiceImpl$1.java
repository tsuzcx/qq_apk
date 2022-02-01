package com.tencent.mobileqq.statistics;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

class CrashReportServiceImpl$1
  implements Runnable
{
  CrashReportServiceImpl$1(CrashReportServiceImpl paramCrashReportServiceImpl, Context paramContext, StatisticCollector paramStatisticCollector, String paramString) {}
  
  public void run()
  {
    int i = 0;
    try
    {
      SharedPreferences localSharedPreferences = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("crashcontrol", 0);
      if (localSharedPreferences != null)
      {
        if (localSharedPreferences.getBoolean("shouldStopMsf", false))
        {
          this.jdField_a_of_type_ComTencentMobileqqStatisticsStatisticCollector.collectPerformance(this.jdField_a_of_type_JavaLangString, "actKillMsf", true, 0L, 0L, null, "");
          localSharedPreferences.edit().putBoolean("shouldStopMsf", false).commit();
        }
        int j = localSharedPreferences.getInt("countTryKillMsf", 0);
        if (j > 0)
        {
          while (i < j)
          {
            this.jdField_a_of_type_ComTencentMobileqqStatisticsStatisticCollector.collectPerformance(this.jdField_a_of_type_JavaLangString, "countTryKillMsf", true, 0L, 0L, null, "");
            i += 1;
          }
          localSharedPreferences.edit().putInt("countTryKillMsf", 0).commit();
        }
      }
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.CrashReportServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */