package com.tencent.qqperf.monitor.crash;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

class QQCrashReportManager$2
  implements Runnable
{
  QQCrashReportManager$2(QQCrashReportManager paramQQCrashReportManager, Context paramContext) {}
  
  public void run()
  {
    SharedPreferences localSharedPreferences = this.a.getSharedPreferences("pref_safemode_not_exit", 4);
    if ((!QQCrashReportManager.i) && (localSharedPreferences.getBoolean("key_not_exit_enable", false))) {
      localSharedPreferences.edit().clear().commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqperf.monitor.crash.QQCrashReportManager.2
 * JD-Core Version:    0.7.0.1
 */