package com.tencent.qqperf.monitor.crash;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

final class QQCrashControlManager$2
  implements Runnable
{
  QQCrashControlManager$2(SharedPreferences paramSharedPreferences) {}
  
  public void run()
  {
    QLog.e("QQCrashControlManager", 1, "restart for background and crash many times, kill self !!!!");
    this.a.edit().putBoolean("allowAutoRestart", true);
    this.a.edit().putInt("crashcount", 0);
    this.a.edit().commit();
    StatisticCollector.getInstance(MobileQQ.getContext()).collectPerformance(null, "suicideCount", true, System.currentTimeMillis(), 0L, null, null);
    QLog.flushLog();
    System.exit(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.monitor.crash.QQCrashControlManager.2
 * JD-Core Version:    0.7.0.1
 */