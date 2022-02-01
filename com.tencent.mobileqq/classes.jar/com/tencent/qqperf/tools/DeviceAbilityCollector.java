package com.tencent.qqperf.tools;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.FileUtils.StorageInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class DeviceAbilityCollector
{
  public static void a(Context paramContext)
  {
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("sp_device_ability", 0);
    if (Math.abs(System.currentTimeMillis() - localSharedPreferences.getLong("device_ability_report_time", 0L)) < 86400000L) {
      return;
    }
    localSharedPreferences.edit().putLong("device_ability_report_time", System.currentTimeMillis()).commit();
    try
    {
      b(paramContext);
      c(paramContext);
      return;
    }
    catch (Throwable paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TAG", 2, "", paramContext);
      }
    }
  }
  
  @SuppressLint({"WrongConstant"})
  private static void b(Context paramContext)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private static void c(Context paramContext)
  {
    int i2 = (int)(FileUtils.getTotalInnernalMemorySize() / 1024.0F / 1024.0F);
    int i = (int)(FileUtils.getAvailableInnernalMemorySize() / 1024.0F / 1024.0F);
    boolean bool = FileUtils.hasSDCardAndWritable();
    int m = -1;
    int j;
    if (bool)
    {
      k = (int)(FileUtils.getTotalInnernalMemorySize() / 1024.0F / 1024.0F);
      n = (int)(FileUtils.getAvailableInnernalMemorySize() / 1024.0F / 1024.0F);
      i = n;
      j = k;
      if (Build.VERSION.SDK_INT >= 9)
      {
        localObject = FileUtils.listAvaliableExternalStorage(paramContext);
        i1 = ((List)localObject).size();
        localObject = ((List)localObject).iterator();
        i = m;
        while (((Iterator)localObject).hasNext()) {
          if (((FileUtils.StorageInfo)((Iterator)localObject).next()).isRemoveable) {
            i += 1;
          }
        }
        m = i;
        i = n;
        j = k;
        k = m;
        m = i1;
        break label156;
      }
    }
    else
    {
      j = -1000;
    }
    int k = -1;
    label156:
    int n = ProcessStats.a();
    int i1 = (int)(DeviceInfoUtil.c() / 1024L);
    int i3 = (int)(DeviceInfoUtil.a() / 1024L / 1024L);
    Object localObject = new HashMap(16);
    ((HashMap)localObject).put("totalRom", String.valueOf(i2));
    ((HashMap)localObject).put("avaiRom", String.valueOf(i));
    ((HashMap)localObject).put("totalSD", String.valueOf(j));
    ((HashMap)localObject).put("avaiSD", String.valueOf(-1000));
    ((HashMap)localObject).put("extCount", String.valueOf(m));
    ((HashMap)localObject).put("remoableExtCount", String.valueOf(k));
    ((HashMap)localObject).put("osVersion", String.valueOf(Build.VERSION.SDK_INT));
    ((HashMap)localObject).put("cpuCoreNum", String.valueOf(n));
    ((HashMap)localObject).put("maxFrequency", String.valueOf(i1));
    ((HashMap)localObject).put("cpu_abi", Build.CPU_ABI);
    ((HashMap)localObject).put("cpu_abi2", Build.CPU_ABI2);
    ((HashMap)localObject).put("ramSize", String.valueOf(i3));
    StatisticCollector.getInstance(paramContext).collectPerformance("", "actStorageStats", true, 0L, 0L, (HashMap)localObject, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.tools.DeviceAbilityCollector
 * JD-Core Version:    0.7.0.1
 */