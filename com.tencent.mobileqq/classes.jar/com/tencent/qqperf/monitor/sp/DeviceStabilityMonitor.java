package com.tencent.qqperf.monitor.sp;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;

public class DeviceStabilityMonitor
{
  public static void a(Context paramContext)
  {
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("sp_d_stable", 0);
    Object localObject;
    boolean bool1;
    if (!localSharedPreferences.contains("key_mnt"))
    {
      localObject = localSharedPreferences.edit();
      if (Math.random() < 0.001F) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      ((SharedPreferences.Editor)localObject).putBoolean("key_mnt", bool1).commit();
    }
    if (localSharedPreferences.getBoolean("key_mnt", false))
    {
      long l3 = localSharedPreferences.getLong("k_last_stable_ts_785", 0L);
      long l2 = System.currentTimeMillis();
      if (l2 - l3 < 86400000L) {
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramContext.getPackageName());
      ((StringBuilder)localObject).append("_preferences");
      localObject = paramContext.getSharedPreferences(((StringBuilder)localObject).toString(), 0);
      long l4 = ((SharedPreferences)localObject).getLong("k_last_stable_ts_785", 0L);
      File localFile = new File(paramContext.getFilesDir(), "file_stable");
      if (localFile.exists()) {
        localFile.delete();
      }
      localSharedPreferences.edit().remove("k_last_stable_ts");
      ((SharedPreferences)localObject).edit().remove("k_last_stable_ts");
      localFile = new File(paramContext.getFilesDir(), "file_stable_785");
      String str = FileUtils.readFileContent(localFile);
      if (!TextUtils.isEmpty(str)) {
        l1 = Long.parseLong(str);
      } else {
        l1 = 0L;
      }
      if ((l4 <= 0L) && (l3 <= 0L) && (l1 <= 0L)) {}
      for (;;)
      {
        break;
        int i;
        if ((l3 >= l1) && ((l3 - l1) % 86400000L == 0L))
        {
          if ((l4 >= l3) && ((l4 - l3) % 86400000L == 0L)) {
            i = 0;
          } else {
            i = 1;
          }
        }
        else {
          i = 2;
        }
        QLog.d("DeviceStability", 1, new Object[] { "check sp file.", Long.valueOf(l4), ", ", Long.valueOf(l3), ", ", Long.valueOf(l1) });
        HashMap localHashMap = new HashMap(4);
        localHashMap.put("fileCode", String.valueOf(i));
        int j = i;
        if (j != 0)
        {
          localHashMap.put("big_sp_time", String.valueOf(l4));
          localHashMap.put("sm_sp_time", String.valueOf(l3));
          localHashMap.put("file_time", str);
        }
        StatisticCollector.getInstance(paramContext).collectPerformance("", "actSpFileStable", true, j, 0L, localHashMap, "");
        if (j == 0)
        {
          boolean bool3 = ((SharedPreferences)localObject).getBoolean("k_last_stable_sw", false);
          boolean bool2 = localSharedPreferences.getBoolean("k_last_stable_sw", false);
          if (l4 / 24L / 60L / 60L / 1000L % 2L == 0L) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          i = j;
          if (bool3 != bool1) {
            i = j | 0x1;
          }
          if (l3 / 24L / 60L / 60L / 1000L % 2L == 0L) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          j = i;
          if (bool2 != bool1) {
            j = i | 0x2;
          }
          localHashMap = new HashMap(4);
          localHashMap.put("fileCode", String.valueOf(j));
          if (j != 0)
          {
            localHashMap.put("big_sp_time", String.valueOf(l4));
            localHashMap.put("sm_sp_time", String.valueOf(l3));
            localHashMap.put("file_time", str);
          }
          StatisticCollector.getInstance(paramContext).collectPerformance("", "actSpContentStable", true, j, 0L, localHashMap, "");
        }
      }
      long l1 = l2 / 86400000L;
      l3 = l1 * 86400000L;
      if (l1 % 2L == 0L) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      paramContext = new StringBuilder();
      paramContext.append("write now = ");
      paramContext.append(l2);
      QLog.d("DeviceStability", 1, paramContext.toString());
      ((SharedPreferences)localObject).edit().putLong("k_last_stable_ts_785", l3).putBoolean("k_last_stable_sw", bool1).commit();
      paramContext = new StringBuilder();
      paramContext.append("write switch = ");
      paramContext.append(bool1);
      QLog.d("DeviceStability", 1, paramContext.toString());
      localSharedPreferences.edit().putLong("k_last_stable_ts_785", l3).putBoolean("k_last_stable_sw", bool1).commit();
      QLog.d("DeviceStability", 1, "write sp end");
      bool1 = FileUtils.writeFile(localFile.getAbsolutePath(), String.valueOf(l3), false);
      paramContext = new StringBuilder();
      paramContext.append("write content end ");
      paramContext.append(bool1);
      QLog.d("DeviceStability", 1, paramContext.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqperf.monitor.sp.DeviceStabilityMonitor
 * JD-Core Version:    0.7.0.1
 */