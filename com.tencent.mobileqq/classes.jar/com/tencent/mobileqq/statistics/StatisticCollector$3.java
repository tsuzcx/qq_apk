package com.tencent.mobileqq.statistics;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

class StatisticCollector$3
  implements Runnable
{
  StatisticCollector$3(StatisticCollector paramStatisticCollector, String paramString) {}
  
  public void run()
  {
    int i = 0;
    try
    {
      SharedPreferences localSharedPreferences = StatisticCollector.access$1000().getSharedPreferences("crashcontrol", 0);
      if (localSharedPreferences != null)
      {
        if (localSharedPreferences.getBoolean("shouldStopMsf", false))
        {
          this.this$0.collectPerformance(this.val$curUin, "actKillMsf", true, 0L, 0L, null, "");
          localSharedPreferences.edit().putBoolean("shouldStopMsf", false).commit();
        }
        int j = localSharedPreferences.getInt("countTryKillMsf", 0);
        if (j > 0)
        {
          while (i < j)
          {
            this.this$0.collectPerformance(this.val$curUin, "countTryKillMsf", true, 0L, 0L, null, "");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.StatisticCollector.3
 * JD-Core Version:    0.7.0.1
 */