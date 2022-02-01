package com.tencent.qqperf.repoter;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.SparseArray;
import com.tencent.qqperf.MagnifierSDK;
import com.tencent.qqperf.config.Config;

public class ReportedStatus
{
  public static int a;
  private static long a;
  public static SparseArray<ReportedStatus.CurrentRecord> a;
  
  static
  {
    jdField_a_of_type_Long = Math.round((float)(System.currentTimeMillis() / 86400000L));
    jdField_a_of_type_Int = 0;
    jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(18);
    jdField_a_of_type_AndroidUtilSparseArray.put(6, new ReportedStatus.CurrentRecord(0L, 0));
    jdField_a_of_type_AndroidUtilSparseArray.put(14, new ReportedStatus.CurrentRecord(0L, 0));
  }
  
  public static void a()
  {
    long l;
    if (MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences != null) {
      l = MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences.getLong("last_start_date", 0L);
    }
    int[] arrayOfInt;
    int j;
    int i;
    int k;
    for (;;)
    {
      if ((jdField_a_of_type_Long - l > 0L) && (MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences$Editor != null))
      {
        MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong("last_start_date", jdField_a_of_type_Long);
        MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("count_today_reported", 0);
        arrayOfInt = Config.Plugins;
        j = arrayOfInt.length;
        i = 0;
        for (;;)
        {
          if (i < j)
          {
            k = arrayOfInt[i];
            MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("count_plugin_" + String.valueOf(k), 0);
            jdField_a_of_type_AndroidUtilSparseArray.put(k, new ReportedStatus.CurrentRecord(0L, 0));
            i += 1;
            continue;
            l = jdField_a_of_type_Long;
            break;
          }
        }
        MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences$Editor.apply();
      }
    }
    for (;;)
    {
      return;
      if (MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences != null)
      {
        jdField_a_of_type_Int = MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences.getInt("count_today_reported", 0);
        if (jdField_a_of_type_Int >= Config.MAX_REPORT_NUM) {
          break;
        }
        arrayOfInt = Config.Plugins;
        j = arrayOfInt.length;
        i = 0;
        while (i < j)
        {
          k = arrayOfInt[i];
          int m = MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences.getInt("count_plugin_" + String.valueOf(k), 0);
          jdField_a_of_type_AndroidUtilSparseArray.put(k, new ReportedStatus.CurrentRecord(0L, m));
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqperf.repoter.ReportedStatus
 * JD-Core Version:    0.7.0.1
 */