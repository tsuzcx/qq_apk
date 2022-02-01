package com.tencent.rmonitor.device.device;

import android.annotation.SuppressLint;
import android.system.Os;
import android.system.OsConstants;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.common.util.AndroidVersion;
import com.tencent.rmonitor.common.util.AndroidVersion.Companion;
import com.tencent.rmonitor.common.util.FileUtil;
import com.tencent.rmonitor.common.util.FileUtil.Companion;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/device/device/DeviceCpu$Companion;", "", "()V", "TAG", "", "cores", "", "getCpuModelName", "getMaxCpuFreq", "getMinCpuFreq", "getNumCores", "getScClkTck", "", "defaultClkTck", "getScNProcessorsConf", "defaultProcessors", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class DeviceCpu$Companion
{
  public final int a()
  {
    if (DeviceCpu.a() > 0) {
      return DeviceCpu.a();
    }
    for (;;)
    {
      try
      {
        DeviceCpu.a((int)((Companion)this).a(-1L));
        if (DeviceCpu.a() < 0)
        {
          Object localObject = new File("/sys/devices/system/cpu/");
          if (!((File)localObject).exists()) {
            break;
          }
          if (!((File)localObject).isDirectory()) {
            return 0;
          }
          localObject = ((File)localObject).listFiles((FilenameFilter)DeviceCpu.Companion.getNumCores.1.a);
          if (localObject == null) {
            break label105;
          }
          i = localObject.length;
          DeviceCpu.a(i);
        }
        i = DeviceCpu.a();
        return i;
      }
      catch (Exception localException)
      {
        Logger.b.a("RMonitor_common_DeviceCpu", (Throwable)localException);
        return 0;
      }
      label105:
      int i = 0;
    }
    return 0;
  }
  
  @JvmStatic
  @SuppressLint({"ObsoleteSdkInt"})
  public final long a(long paramLong)
  {
    if (AndroidVersion.a.d()) {
      try
      {
        paramLong = Os.sysconf(OsConstants._SC_NPROCESSORS_CONF);
        return paramLong;
      }
      catch (Exception localException)
      {
        Logger localLogger = Logger.b;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localException);
        localStringBuilder.append(": get system cpu core failed.");
        localLogger.d(new String[] { "RMonitor_common_DeviceCpu", localStringBuilder.toString() });
        paramLong = 0L;
      }
    }
    return paramLong;
  }
  
  @NotNull
  public final String b()
  {
    Object localObject2 = (String)null;
    Iterator localIterator = ((Iterable)StringsKt.split$default((CharSequence)FileUtil.a.b("/proc/cpuinfo"), new String[] { "\n" }, false, 0, 6, null)).iterator();
    Object localObject1 = localObject2;
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject3 = localObject2;
      if (localObject2 == null)
      {
        localObject3 = localObject2;
        if (StringsKt.startsWith$default(str, "model name", false, 2, null)) {
          localObject3 = str;
        }
      }
      localObject2 = localObject3;
      if (localObject1 == null)
      {
        localObject2 = localObject3;
        if (StringsKt.startsWith$default(str, "Hardware", false, 2, null))
        {
          localObject1 = str;
          localObject2 = localObject3;
        }
      }
    }
    localObject1 = (String)CollectionsKt.firstOrNull(CollectionsKt.listOfNotNull(new String[] { localObject2, localObject1 }));
    if (localObject1 != null)
    {
      localObject1 = (CharSequence)StringsKt.substringAfter((String)localObject1, ":", "");
      int i = ((CharSequence)localObject1).length() - 1;
      int j = 0;
      int k = 0;
      while (j <= i)
      {
        int m;
        if (k == 0) {
          m = j;
        } else {
          m = i;
        }
        if (((CharSequence)localObject1).charAt(m) <= ' ') {
          m = 1;
        } else {
          m = 0;
        }
        if (k == 0)
        {
          if (m == 0) {
            k = 1;
          } else {
            j += 1;
          }
        }
        else
        {
          if (m == 0) {
            break;
          }
          i -= 1;
        }
      }
      return ((CharSequence)localObject1).subSequence(j, i + 1).toString();
    }
    return "";
  }
  
  @NotNull
  public final String c()
  {
    String str = FileUtil.a.b("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq");
    int i;
    if (((CharSequence)str).length() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return "";
    }
    try
    {
      i = Integer.valueOf(str).intValue() / 1000;
      return String.valueOf(i);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      Logger localLogger = Logger.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localNumberFormatException);
      localStringBuilder.append(": get cpu failed.");
      localLogger.d(new String[] { "RMonitor_common_DeviceCpu", localStringBuilder.toString() });
    }
    return "";
  }
  
  @NotNull
  public final String d()
  {
    String str = FileUtil.a.b("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq");
    int i;
    if (((CharSequence)str).length() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return "";
    }
    return String.valueOf(Integer.valueOf(str).intValue() / 1000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.device.device.DeviceCpu.Companion
 * JD-Core Version:    0.7.0.1
 */