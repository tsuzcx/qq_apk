package com.tencent.mobileqq.statistics;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import axrn;

public class StatisticCollector$5
  implements Runnable
{
  public StatisticCollector$5(axrn paramaxrn) {}
  
  public void run()
  {
    SharedPreferences localSharedPreferences = axrn.a().getSharedPreferences("pref_safemode_not_exit", 4);
    if ((!axrn.b) && (localSharedPreferences.getBoolean("key_not_exit_enable", false))) {
      localSharedPreferences.edit().clear().commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.StatisticCollector.5
 * JD-Core Version:    0.7.0.1
 */