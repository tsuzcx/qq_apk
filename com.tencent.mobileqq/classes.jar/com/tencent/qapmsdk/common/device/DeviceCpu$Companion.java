package com.tencent.qapmsdk.common.device;

import android.annotation.SuppressLint;
import android.system.Os;
import android.system.OsConstants;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.util.AndroidVersion;
import com.tencent.qapmsdk.common.util.AndroidVersion.Companion;
import com.tencent.qapmsdk.common.util.FileUtil;
import com.tencent.qapmsdk.common.util.FileUtil.Companion;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/device/DeviceCpu$Companion;", "", "()V", "TAG", "", "cores", "", "getCpuModelName", "getMaxCpuFreq", "getMinCpuFreq", "getNumCores", "getScClkTck", "", "defaultClkTck", "getScNProcessorsConf", "defaultProcessors", "common_release"}, k=1, mv={1, 1, 15})
public final class DeviceCpu$Companion
{
  @NotNull
  public final String getCpuModelName()
  {
    Object localObject3 = (String)null;
    Object localObject1 = (String)null;
    Iterator localIterator = ((Iterable)StringsKt.split$default((CharSequence)FileUtil.Companion.readOutputFromFile("/proc/cpuinfo"), new String[] { "\n" }, false, 0, 6, null)).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject2 = localObject3;
      if (localObject3 == null)
      {
        localObject2 = localObject3;
        if (StringsKt.startsWith$default(str, "model name", false, 2, null)) {
          localObject2 = str;
        }
      }
      Object localObject4 = localObject1;
      if (localObject1 == null)
      {
        localObject4 = localObject1;
        if (StringsKt.startsWith$default(str, "Hardware", false, 2, null)) {
          localObject4 = str;
        }
      }
      localObject3 = localObject2;
      localObject1 = localObject4;
    }
    localObject1 = (String)CollectionsKt.firstOrNull(CollectionsKt.listOfNotNull(new String[] { localObject3, localObject1 }));
    if (localObject1 != null)
    {
      localObject1 = (CharSequence)StringsKt.substringAfter((String)localObject1, ":", "");
      int j = ((CharSequence)localObject1).length() - 1;
      int i = 0;
      int k = 0;
      int m;
      if (k <= j) {
        if (i == 0)
        {
          m = k;
          label213:
          if (((CharSequence)localObject1).charAt(m) > ' ') {
            break label250;
          }
          m = 1;
          label230:
          if (i != 0) {
            break label263;
          }
          if (m != 0) {
            break label256;
          }
          i = 1;
        }
      }
      for (;;)
      {
        break;
        m = j;
        break label213;
        label250:
        m = 0;
        break label230;
        label256:
        k += 1;
        continue;
        label263:
        if (m == 0) {
          return ((CharSequence)localObject1).subSequence(k, j + 1).toString();
        }
        j -= 1;
      }
    }
    return "";
  }
  
  @NotNull
  public final String getMaxCpuFreq()
  {
    String str = FileUtil.Companion.readOutputFromFile("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq");
    if (((CharSequence)str).length() == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return "";
    }
    try
    {
      i = Integer.valueOf(str).intValue() / 1000;
      return String.valueOf(i);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      Logger.INSTANCE.d(new String[] { "QAPM_common_DeviceCpu", localNumberFormatException + ": get cpu failed." });
    }
    return "";
  }
  
  @NotNull
  public final String getMinCpuFreq()
  {
    String str = FileUtil.Companion.readOutputFromFile("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq");
    if (((CharSequence)str).length() == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return "";
    }
    return String.valueOf(Integer.valueOf(str).intValue() / 1000);
  }
  
  public final int getNumCores()
  {
    if (DeviceCpu.access$getCores$cp() > 0) {
      return DeviceCpu.access$getCores$cp();
    }
    try
    {
      DeviceCpu.access$setCores$cp((int)((Companion)this).getScNProcessorsConf(-1L));
      Object localObject;
      if (DeviceCpu.access$getCores$cp() < 0)
      {
        localObject = new File("/sys/devices/system/cpu/");
        if ((!((File)localObject).exists()) || (!((File)localObject).isDirectory())) {
          break label105;
        }
        localObject = ((File)localObject).listFiles((FilenameFilter)DeviceCpu.Companion.getNumCores.1.INSTANCE);
        if (localObject == null) {
          break label85;
        }
      }
      label85:
      for (int i = localObject.length;; i = 0)
      {
        DeviceCpu.access$setCores$cp(i);
        i = DeviceCpu.access$getCores$cp();
        return i;
      }
      return 0;
    }
    catch (Exception localException)
    {
      Logger.INSTANCE.exception("QAPM_common_DeviceCpu", (Throwable)localException);
      return 0;
    }
  }
  
  @JvmStatic
  @SuppressLint({"ObsoleteSdkInt"})
  public final long getScClkTck(long paramLong)
  {
    if (AndroidVersion.Companion.isL()) {}
    for (;;)
    {
      try
      {
        l = Os.sysconf(OsConstants._SC_CLK_TCK);
        if (l > 0L) {
          paramLong = l;
        }
        return paramLong;
      }
      catch (Exception localException)
      {
        Logger.INSTANCE.d(new String[] { "QAPM_common_DeviceCpu", localException + ": get system cpu click failed." });
        l = 0L;
        continue;
      }
      long l = paramLong;
    }
  }
  
  @JvmStatic
  @SuppressLint({"ObsoleteSdkInt"})
  public final long getScNProcessorsConf(long paramLong)
  {
    if (AndroidVersion.Companion.isL()) {}
    try
    {
      paramLong = Os.sysconf(OsConstants._SC_NPROCESSORS_CONF);
      return paramLong;
    }
    catch (Exception localException)
    {
      Logger.INSTANCE.d(new String[] { "QAPM_common_DeviceCpu", localException + ": get system cpu core failed." });
    }
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.common.device.DeviceCpu.Companion
 * JD-Core Version:    0.7.0.1
 */