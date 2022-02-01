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
    } else {
      l = jdField_a_of_type_Long;
    }
    int[] arrayOfInt;
    int j;
    int i;
    int k;
    Object localObject;
    StringBuilder localStringBuilder;
    if ((jdField_a_of_type_Long - l > 0L) && (MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences$Editor != null))
    {
      MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong("last_start_date", jdField_a_of_type_Long);
      MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("count_today_reported", 0);
      arrayOfInt = Config.Plugins;
      j = arrayOfInt.length;
      i = 0;
      while (i < j)
      {
        k = arrayOfInt[i];
        localObject = MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences$Editor;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("count_plugin_");
        localStringBuilder.append(String.valueOf(k));
        ((SharedPreferences.Editor)localObject).putInt(localStringBuilder.toString(), 0);
        jdField_a_of_type_AndroidUtilSparseArray.put(k, new ReportedStatus.CurrentRecord(0L, 0));
        i += 1;
      }
      MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences$Editor.apply();
      return;
    }
    if (MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences != null)
    {
      jdField_a_of_type_Int = MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences.getInt("count_today_reported", 0);
      if (jdField_a_of_type_Int < Config.MAX_REPORT_NUM)
      {
        arrayOfInt = Config.Plugins;
        j = arrayOfInt.length;
        i = 0;
        while (i < j)
        {
          k = arrayOfInt[i];
          localObject = MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("count_plugin_");
          localStringBuilder.append(String.valueOf(k));
          int m = ((SharedPreferences)localObject).getInt(localStringBuilder.toString(), 0);
          jdField_a_of_type_AndroidUtilSparseArray.put(k, new ReportedStatus.CurrentRecord(0L, m));
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.repoter.ReportedStatus
 * JD-Core Version:    0.7.0.1
 */