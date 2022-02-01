package com.tencent.qqperf.repoter;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.SparseArray;
import com.tencent.qqperf.MagnifierSDK;
import com.tencent.qqperf.config.Config;

public class ReportedStatus
{
  public static int a;
  public static SparseArray<ReportedStatus.CurrentRecord> b;
  private static long c = Math.round((float)(System.currentTimeMillis() / 86400000L));
  
  static
  {
    a = 0;
    b = new SparseArray(18);
    b.put(6, new ReportedStatus.CurrentRecord(0L, 0));
    b.put(14, new ReportedStatus.CurrentRecord(0L, 0));
  }
  
  public static void a()
  {
    long l;
    if (MagnifierSDK.c != null) {
      l = MagnifierSDK.c.getLong("last_start_date", 0L);
    } else {
      l = c;
    }
    int[] arrayOfInt;
    int j;
    int i;
    int k;
    Object localObject;
    StringBuilder localStringBuilder;
    if ((c - l > 0L) && (MagnifierSDK.d != null))
    {
      MagnifierSDK.d.putLong("last_start_date", c);
      MagnifierSDK.d.putInt("count_today_reported", 0);
      arrayOfInt = Config.Plugins;
      j = arrayOfInt.length;
      i = 0;
      while (i < j)
      {
        k = arrayOfInt[i];
        localObject = MagnifierSDK.d;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("count_plugin_");
        localStringBuilder.append(String.valueOf(k));
        ((SharedPreferences.Editor)localObject).putInt(localStringBuilder.toString(), 0);
        b.put(k, new ReportedStatus.CurrentRecord(0L, 0));
        i += 1;
      }
      MagnifierSDK.d.apply();
      return;
    }
    if (MagnifierSDK.c != null)
    {
      a = MagnifierSDK.c.getInt("count_today_reported", 0);
      if (a < Config.MAX_REPORT_NUM)
      {
        arrayOfInt = Config.Plugins;
        j = arrayOfInt.length;
        i = 0;
        while (i < j)
        {
          k = arrayOfInt[i];
          localObject = MagnifierSDK.c;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("count_plugin_");
          localStringBuilder.append(String.valueOf(k));
          int m = ((SharedPreferences)localObject).getInt(localStringBuilder.toString(), 0);
          b.put(k, new ReportedStatus.CurrentRecord(0L, m));
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqperf.repoter.ReportedStatus
 * JD-Core Version:    0.7.0.1
 */