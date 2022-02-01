package com.tencent.rmonitor.memory;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.util.Pair;
import com.tencent.rmonitor.base.config.DefaultPluginConfig;
import com.tencent.rmonitor.base.config.PluginCombination;
import com.tencent.rmonitor.base.config.data.RPluginConfig;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.base.plugin.monitor.PluginController;
import com.tencent.rmonitor.common.util.FileUtil;
import com.tencent.rmonitor.fd.utils.LogUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public final class MemoryUtils
{
  private static final String a;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(FileUtil.e());
    localStringBuilder.append("/Log/");
    a = localStringBuilder.toString();
  }
  
  public static Pair<Boolean, String> a(@NonNull List<String> paramList, String paramString)
  {
    String str = a(System.currentTimeMillis(), "yy-MM-dd_HH.mm.ss");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a());
    localStringBuilder.append("dump_");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(str);
    localStringBuilder.append(".zip");
    paramString = localStringBuilder.toString();
    return new Pair(Boolean.valueOf(FileUtil.a(paramList, paramString, false)), paramString);
  }
  
  public static String a()
  {
    return a;
  }
  
  public static String a(long paramLong, @NonNull String paramString)
  {
    if (paramLong <= 0L) {
      return null;
    }
    Date localDate = new Date(paramLong);
    return new SimpleDateFormat(paramString, Locale.US).format(localDate);
  }
  
  public static boolean a(int paramInt)
  {
    Object localObject = BaseInfo.sharePreference;
    if (localObject != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("plugin_start_sample_date_");
      localStringBuilder.append(paramInt);
      long l1 = ((SharedPreferences)localObject).getLong(localStringBuilder.toString(), 0L);
      long l2 = Math.round((float)System.currentTimeMillis() / 86400000.0F);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("plugin_start_sample_ratio_");
      localStringBuilder.append(paramInt);
      float f1 = ((SharedPreferences)localObject).getFloat(localStringBuilder.toString(), 0.0F);
      float f2 = b(paramInt);
      boolean bool1;
      if ((l2 <= l1) && (f2 == f1))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("plugin_start_sample_result_");
        localStringBuilder.append(paramInt);
        bool1 = ((SharedPreferences)localObject).getBoolean(localStringBuilder.toString(), PluginController.b.d(paramInt));
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("sample result for plugin ");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append(" is ");
        ((StringBuilder)localObject).append(bool1);
        ((StringBuilder)localObject).append(", using old result");
        LogUtils.a("MemoryUtils", ((StringBuilder)localObject).toString());
        return bool1;
      }
      boolean bool3 = PluginController.b.d(paramInt);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("sample result for plugin ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" is ");
      localStringBuilder.append(bool3);
      localStringBuilder.append(", due to new date: ");
      boolean bool2 = true;
      if (l2 > l1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      localStringBuilder.append(bool1);
      localStringBuilder.append(", new ratio: ");
      if (f2 != f1) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      localStringBuilder.append(bool1);
      LogUtils.a("MemoryUtils", localStringBuilder.toString());
      localObject = ((SharedPreferences)localObject).edit();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("plugin_start_sample_result_");
      localStringBuilder.append(paramInt);
      localObject = ((SharedPreferences.Editor)localObject).putBoolean(localStringBuilder.toString(), bool3);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("plugin_start_sample_ratio_");
      localStringBuilder.append(paramInt);
      localObject = ((SharedPreferences.Editor)localObject).putFloat(localStringBuilder.toString(), f2);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("plugin_start_sample_date_");
      localStringBuilder.append(paramInt);
      ((SharedPreferences.Editor)localObject).putLong(localStringBuilder.toString(), l2).apply();
      return bool3;
    }
    return PluginController.b.d(paramInt);
  }
  
  private static float b(int paramInt)
  {
    DefaultPluginConfig localDefaultPluginConfig = PluginCombination.a(paramInt);
    if (localDefaultPluginConfig != null) {
      return localDefaultPluginConfig.f.h;
    }
    return 0.0F;
  }
  
  public static long b()
  {
    return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.memory.MemoryUtils
 * JD-Core Version:    0.7.0.1
 */