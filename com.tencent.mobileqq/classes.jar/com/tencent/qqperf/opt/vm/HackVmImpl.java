package com.tencent.qqperf.opt.vm;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dalvik.DalvikReplacer;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class HackVmImpl
{
  public static int a;
  public static int b;
  public static int c;
  public static int d;
  public static long e = Runtime.getRuntime().maxMemory();
  public static long f = 0L;
  
  public static void a(long paramLong)
  {
    long l = ((ActivityManager)MobileQQ.getContext().getSystemService("activity")).getLargeMemoryClass() * 1024 * 1024;
    if (e <= paramLong)
    {
      Object localObject1;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("openLargeHeap|curMaxSize= ");
        ((StringBuilder)localObject1).append(e);
        ((StringBuilder)localObject1).append(",largeHeapSize=");
        ((StringBuilder)localObject1).append(l);
        QLog.d("HACK_ART_MEM", 2, ((StringBuilder)localObject1).toString());
      }
      try
      {
        Object localObject2 = Class.forName("dalvik.system.VMRuntime");
        localObject1 = ((Class)localObject2).getMethod("getRuntime", new Class[0]).invoke(null, (Object[])null);
        localObject2 = ((Class)localObject2).getDeclaredMethod("clearGrowthLimit", new Class[0]);
        ((Method)localObject2).setAccessible(true);
        ((Method)localObject2).invoke(localObject1, new Object[0]);
        f = Runtime.getRuntime().maxMemory();
        d = 21;
      }
      catch (Exception localException)
      {
        d = -1;
        localException.printStackTrace();
      }
      paramLong = Runtime.getRuntime().maxMemory();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("openLargeHeap|newMaxMemory= ");
        localStringBuilder.append(paramLong);
        QLog.d("HACK_ART_MEM", 2, localStringBuilder.toString());
      }
    }
  }
  
  @SuppressLint({"InlinedApi"})
  public static boolean a()
  {
    SharedPreferences localSharedPreferences = MobileQQ.getContext().getSharedPreferences("sp_hack_dvm", 4);
    int j = localSharedPreferences.getInt("key_continuous_crash_count", 0);
    int i = j;
    if (j < 4)
    {
      i = j;
      if (MobileQQ.sProcessId == 1)
      {
        i = j;
        if (localSharedPreferences.getLong("key_last_hack_time", 0L) > 0L)
        {
          i = j + 1;
          localSharedPreferences.edit().putInt("key_continuous_crash_count", i).commit();
        }
      }
    }
    if (i < 4) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    try
    {
      String str = System.getProperty("java.vm.version");
      bool2 = bool1;
      if (str != null)
      {
        boolean bool3 = str.startsWith("2");
        bool2 = bool1;
        if (bool3) {
          bool2 = false;
        }
      }
    }
    catch (Throwable localThrowable2)
    {
      for (;;)
      {
        long l;
        int k;
        StringBuilder localStringBuilder;
        boolean bool2 = bool1;
      }
    }
    if ((bool2) && (MobileQQ.sProcessId == 1)) {
      localSharedPreferences.edit().putLong("key_last_hack_time", System.currentTimeMillis()).commit();
    }
    if (bool2)
    {
      l = ((ActivityManager)MobileQQ.getContext().getSystemService("activity")).getLargeMemoryClass() * 1024 * 1024;
      f = Math.min(Runtime.getRuntime().maxMemory() * 2L, l);
      f = Math.min(f, 201326592L);
    }
    try
    {
      DalvikReplacer.dvmHack(MobileQQ.getContext(), 26214400, bool2, f);
    }
    catch (Throwable localThrowable1)
    {
      QLog.e("AutoMonitor", 1, "dvmHack error", localThrowable1);
    }
    i = DalvikReplacer.sLaResult;
    j = DalvikReplacer.sVerifyResult;
    k = DalvikReplacer.sHeapResult;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(", modHeap = ");
    localStringBuilder.append(f);
    QLog.e("QQAppInterface", 1, new Object[] { "laResult: ", Integer.valueOf(i), ", verifyResult: ", Integer.valueOf(j), ", heapResult = ", Integer.valueOf(k), localStringBuilder.toString() });
    a = DalvikReplacer.sLaResult;
    if (bool2)
    {
      b = DalvikReplacer.sVerifyResult;
      c = DalvikReplacer.sHeapResult;
    }
    if ((bool2) && (MobileQQ.sProcessId == 1)) {
      ThreadManager.getSubThreadHandler().postDelayed(new HackVmImpl.1(), 5000L);
    }
    return true;
  }
  
  public static void b()
  {
    if (Build.VERSION.SDK_INT <= 20) {}
    try
    {
      String str = System.getProperty("java.vm.version");
      if ((str != null) && (str.startsWith("2")))
      {
        a(134217728L);
        return;
        if (Build.VERSION.SDK_INT < 23)
        {
          a(134217728L);
          return;
        }
        c();
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public static void c()
  {
    if ((MobileQQ.sProcessId != 1) && (MobileQQ.sProcessId != 2)) {
      return;
    }
    SharedPreferences localSharedPreferences = MobileQQ.getContext().getSharedPreferences("sp_hack_dvm", 4);
    int j = localSharedPreferences.getInt("key_art_continuous_crash_count", 0);
    int i = j;
    if (j < 4)
    {
      i = j;
      if (MobileQQ.sProcessId == 1)
      {
        i = j;
        if (localSharedPreferences.getLong("key_last_hack_art_time", 0L) > 0L)
        {
          i = j + 1;
          localSharedPreferences.edit().putInt("key_art_continuous_crash_count", i).commit();
        }
      }
    }
    if (i < 4) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0) {
      return;
    }
    if (e >= 201326592L) {
      return;
    }
    long l = ((ActivityManager)MobileQQ.getContext().getSystemService("activity")).getLargeMemoryClass() * 1024 * 1024;
    f = Math.min(e * 2L, l);
    if (f > e)
    {
      if (MobileQQ.sProcessId == 1) {
        localSharedPreferences.edit().putLong("key_last_hack_art_time", System.currentTimeMillis()).commit();
      }
      try
      {
        DalvikReplacer.artHack(MobileQQ.getContext(), e, f);
      }
      catch (Throwable localThrowable)
      {
        QLog.e("HACK_ART_MEM", 1, "ArtHack error", localThrowable);
      }
      i = DalvikReplacer.sArtHackResult;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(", modHeap = ");
      localStringBuilder.append(f);
      QLog.e("HACK_ART_MEM", 1, new Object[] { "hackArtResult = ", Integer.valueOf(i), localStringBuilder.toString() });
      d = DalvikReplacer.sArtHackResult;
      if (MobileQQ.sProcessId == 1) {
        ThreadManager.getSubThreadHandler().postDelayed(new HackVmImpl.2(), 5000L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqperf.opt.vm.HackVmImpl
 * JD-Core Version:    0.7.0.1
 */