package com.tencent.qqperf.monitor.crash;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.statistics.StatisticCollector;
import mqq.app.MobileQQ;

class QQCrashControlManager$1
  implements Runnable
{
  QQCrashControlManager$1(QQCrashControlManager paramQQCrashControlManager, String paramString) {}
  
  public void run()
  {
    try
    {
      SharedPreferences localSharedPreferences = MobileQQ.sMobileQQ.getSharedPreferences("crashcontrol", 0);
      if (localSharedPreferences != null)
      {
        if (localSharedPreferences.getBoolean("shouldStopMsf", false))
        {
          StatisticCollector.getInstance(MobileQQ.getContext()).collectPerformance(this.a, "actKillMsf", true, 0L, 0L, null, "");
          localSharedPreferences.edit().putBoolean("shouldStopMsf", false).commit();
        }
        int j = localSharedPreferences.getInt("countTryKillMsf", 0);
        if (j > 0)
        {
          int i = 0;
          while (i < j)
          {
            StatisticCollector.getInstance(MobileQQ.getContext()).collectPerformance(this.a, "countTryKillMsf", true, 0L, 0L, null, "");
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
 * Qualified Name:     com.tencent.qqperf.monitor.crash.QQCrashControlManager.1
 * JD-Core Version:    0.7.0.1
 */