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
  public static long a;
  public static int b;
  public static long b;
  public static int c;
  public static int d;
  
  static
  {
    jdField_a_of_type_Int = 0;
    jdField_b_of_type_Int = 0;
    c = 0;
    d = 0;
    jdField_a_of_type_Long = Runtime.getRuntime().maxMemory();
    jdField_b_of_type_Long = 0L;
  }
  
  public static void a()
  {
    if (Build.VERSION.SDK_INT <= 20) {}
    try
    {
      String str = System.getProperty("java.vm.version");
      if ((str != null) && (str.startsWith("2"))) {
        a(134217728L);
      }
      return;
    }
    catch (Throwable localThrowable) {}
    if (Build.VERSION.SDK_INT < 23)
    {
      a(134217728L);
      return;
    }
    b();
    return;
  }
  
  public static void a(long paramLong)
  {
    long l = ((ActivityManager)MobileQQ.getContext().getSystemService("activity")).getLargeMemoryClass() * 1024 * 1024;
    if (jdField_a_of_type_Long <= paramLong) {
      if (QLog.isColorLevel()) {
        QLog.d("HACK_ART_MEM", 2, "openLargeHeap|curMaxSize= " + jdField_a_of_type_Long + ",largeHeapSize=" + l);
      }
    }
    try
    {
      Object localObject2 = Class.forName("dalvik.system.VMRuntime");
      Object localObject1 = ((Class)localObject2).getMethod("getRuntime", new Class[0]).invoke(null, (Object[])null);
      localObject2 = ((Class)localObject2).getDeclaredMethod("clearGrowthLimit", new Class[0]);
      ((Method)localObject2).setAccessible(true);
      ((Method)localObject2).invoke(localObject1, new Object[0]);
      jdField_b_of_type_Long = Runtime.getRuntime().maxMemory();
      d = 21;
      paramLong = Runtime.getRuntime().maxMemory();
      if (QLog.isColorLevel()) {
        QLog.d("HACK_ART_MEM", 2, "openLargeHeap|newMaxMemory= " + paramLong);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        d = -1;
        localException.printStackTrace();
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
    boolean bool1;
    if (i < 4) {
      bool1 = true;
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
      if ((bool2) && (MobileQQ.sProcessId == 1)) {
        localSharedPreferences.edit().putLong("key_last_hack_time", System.currentTimeMillis()).commit();
      }
      if (bool2)
      {
        long l = ((ActivityManager)MobileQQ.getContext().getSystemService("activity")).getLargeMemoryClass() * 1024 * 1024;
        jdField_b_of_type_Long = Math.min(Runtime.getRuntime().maxMemory() * 2L, l);
        jdField_b_of_type_Long = Math.min(jdField_b_of_type_Long, 201326592L);
      }
    }
    catch (Throwable localThrowable2)
    {
      try
      {
        for (;;)
        {
          DalvikReplacer.dvmHack(MobileQQ.getContext(), 26214400, bool2, jdField_b_of_type_Long);
          QLog.e("QQAppInterface", 1, new Object[] { "laResult: ", Integer.valueOf(DalvikReplacer.sLaResult), ", verifyResult: ", Integer.valueOf(DalvikReplacer.sVerifyResult), ", heapResult = ", Integer.valueOf(DalvikReplacer.sHeapResult), ", modHeap = " + jdField_b_of_type_Long });
          jdField_a_of_type_Int = DalvikReplacer.sLaResult;
          if (bool2)
          {
            jdField_b_of_type_Int = DalvikReplacer.sVerifyResult;
            c = DalvikReplacer.sHeapResult;
          }
          if ((bool2) && (MobileQQ.sProcessId == 1)) {
            ThreadManager.getSubThreadHandler().postDelayed(new HackVmImpl.1(), 5000L);
          }
          return true;
          bool1 = false;
        }
        localThrowable2 = localThrowable2;
        boolean bool2 = bool1;
      }
      catch (Throwable localThrowable1)
      {
        for (;;)
        {
          QLog.e("AutoMonitor", 1, "dvmHack error", localThrowable1);
        }
      }
    }
  }
  
  public static void b()
  {
    if ((MobileQQ.sProcessId != 1) && (MobileQQ.sProcessId != 2)) {}
    for (;;)
    {
      return;
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
      if (i < 4)
      {
        i = 1;
        if ((i == 0) || (jdField_a_of_type_Long >= 201326592L)) {
          continue;
        }
        long l = ((ActivityManager)MobileQQ.getContext().getSystemService("activity")).getLargeMemoryClass() * 1024 * 1024;
        jdField_b_of_type_Long = Math.min(jdField_a_of_type_Long * 2L, l);
        if (jdField_b_of_type_Long <= jdField_a_of_type_Long) {
          continue;
        }
        if (MobileQQ.sProcessId == 1) {
          localSharedPreferences.edit().putLong("key_last_hack_art_time", System.currentTimeMillis()).commit();
        }
      }
      try
      {
        DalvikReplacer.artHack(MobileQQ.getContext(), jdField_a_of_type_Long, jdField_b_of_type_Long);
        QLog.e("HACK_ART_MEM", 1, new Object[] { "hackArtResult = ", Integer.valueOf(DalvikReplacer.sArtHackResult), ", modHeap = " + jdField_b_of_type_Long });
        d = DalvikReplacer.sArtHackResult;
        if (MobileQQ.sProcessId != 1) {
          continue;
        }
        ThreadManager.getSubThreadHandler().postDelayed(new HackVmImpl.2(), 5000L);
        return;
        i = 0;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          QLog.e("HACK_ART_MEM", 1, "ArtHack error", localThrowable);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqperf.opt.vm.HackVmImpl
 * JD-Core Version:    0.7.0.1
 */