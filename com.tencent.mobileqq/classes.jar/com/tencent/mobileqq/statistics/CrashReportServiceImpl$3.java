package com.tencent.mobileqq.statistics;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

class CrashReportServiceImpl$3
  implements Runnable
{
  CrashReportServiceImpl$3(CrashReportServiceImpl paramCrashReportServiceImpl, Context paramContext) {}
  
  public void run()
  {
    SharedPreferences localSharedPreferences = this.a.getSharedPreferences("pref_safemode_not_exit", 4);
    if ((!StatisticCollector.sCatchedNotExit) && (localSharedPreferences.getBoolean("key_not_exit_enable", false))) {
      localSharedPreferences.edit().clear().commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.CrashReportServiceImpl.3
 * JD-Core Version:    0.7.0.1
 */