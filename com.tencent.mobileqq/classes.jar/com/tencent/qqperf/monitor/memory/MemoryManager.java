package com.tencent.qqperf.monitor.memory;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Debug.MemoryInfo;
import android.os.Process;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qqperf.api.IPerfApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.MagnifierSDK;
import com.tencent.qqperf.opt.clearmemory.ClearMemoryConfig;
import com.tencent.qqperf.opt.clearmemory.MemoryClearManager;
import com.tencent.qqperf.opt.clearmemory.MemoryConfigs;
import com.tencent.qqperf.opt.vm.HackVmImpl;
import com.tencent.qqperf.tools.SceneTracker;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import mqq.app.MobileQQ;

public class MemoryManager
{
  private static long jdField_a_of_type_Long;
  private static MemoryManager jdField_a_of_type_ComTencentQqperfMonitorMemoryMemoryManager = null;
  private static List<String> jdField_a_of_type_JavaUtilList = null;
  private static long jdField_b_of_type_Long;
  private static List<Pattern> jdField_b_of_type_JavaUtilList = null;
  private static List<String> jdField_c_of_type_JavaUtilList = null;
  private int jdField_a_of_type_Int = 0;
  private MemoryManager.IReportListener jdField_a_of_type_ComTencentQqperfMonitorMemoryMemoryManager$IReportListener;
  private MemoryManager.LowMemoryReport jdField_a_of_type_ComTencentQqperfMonitorMemoryMemoryManager$LowMemoryReport = null;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private ConcurrentHashMap<String, MemoryManager.StatMemory> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(0);
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  private int jdField_c_of_type_Int = 0;
  
  static
  {
    jdField_a_of_type_Long = 0L;
    jdField_b_of_type_Long = 0L;
  }
  
  private MemoryManager()
  {
    if (0.1000000014901161D >= Math.random()) {
      bool = true;
    }
    this.jdField_a_of_type_Boolean = bool;
    if (QLog.isColorLevel()) {
      QLog.d("Q.Memory.MemoryManager", 2, "memory manager set need report = " + this.jdField_a_of_type_Boolean);
    }
    a(MemoryClearManager.a());
  }
  
  public static long a()
  {
    if (jdField_a_of_type_Long > 0L) {
      return jdField_a_of_type_Long;
    }
    long l1 = DeviceInfoUtil.a();
    jdField_b_of_type_Long = l1;
    long l2 = DeviceInfoUtil.e();
    long l3 = (3L * l1 + 7L * l2) / 10L;
    long l4 = DeviceInfoUtil.f();
    if (l3 <= 157286400L) {
      jdField_a_of_type_Long = Math.min(25165824L, l4);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.Memory.MemoryManager", 2, "getAvailClassSize, availClassSize=" + jdField_a_of_type_Long / 1048576L + "M, totalMemSize=" + l1 / 1048576L + "M, remainMemSize=" + l2 / 1048576L + "M, availMemSize=" + l3 / 1048576L + "M, classMemSize=" + l4 / 1048576L + "M");
      }
      return jdField_a_of_type_Long;
      if (l3 <= 262144000L) {
        jdField_a_of_type_Long = Math.min(37748736L, l4);
      } else if (l3 <= 419430400L) {
        jdField_a_of_type_Long = Math.min(67108864L, l4);
      } else if (l3 <= 524288000L) {
        jdField_a_of_type_Long = Math.min(134217728L, l4);
      } else {
        jdField_a_of_type_Long = Math.min(268435456L, l4);
      }
    }
  }
  
  public static long a(int paramInt)
  {
    try
    {
      Debug.MemoryInfo[] arrayOfMemoryInfo = ((ActivityManager)MobileQQ.getContext().getSystemService("activity")).getProcessMemoryInfo(new int[] { paramInt });
      if ((arrayOfMemoryInfo != null) && (arrayOfMemoryInfo.length > 0))
      {
        int i = arrayOfMemoryInfo[0].getTotalPss();
        return i * 1024L;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.Memory.MemoryManager", 2, "getMemory ex pid=" + paramInt, localException);
      }
      return 62914560L;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.Memory.MemoryManager", 2, new Object[] { "getMemory OutOfMemoryError pid=", Integer.valueOf(paramInt), localOutOfMemoryError });
        }
      }
    }
  }
  
  private MemoryManager.LowMemoryReport a()
  {
    if (this.jdField_a_of_type_ComTencentQqperfMonitorMemoryMemoryManager$LowMemoryReport == null)
    {
      this.jdField_a_of_type_ComTencentQqperfMonitorMemoryMemoryManager$LowMemoryReport = new MemoryManager.LowMemoryReport();
      this.jdField_a_of_type_ComTencentQqperfMonitorMemoryMemoryManager$LowMemoryReport.a();
    }
    return this.jdField_a_of_type_ComTencentQqperfMonitorMemoryMemoryManager$LowMemoryReport;
  }
  
  public static MemoryManager a()
  {
    if (jdField_a_of_type_ComTencentQqperfMonitorMemoryMemoryManager == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentQqperfMonitorMemoryMemoryManager == null) {
        jdField_a_of_type_ComTencentQqperfMonitorMemoryMemoryManager = new MemoryManager();
      }
      return jdField_a_of_type_ComTencentQqperfMonitorMemoryMemoryManager;
    }
    finally {}
  }
  
  public static void a(int paramInt, MemoryManager.DebugMemoryInfo paramDebugMemoryInfo)
  {
    try
    {
      Debug.MemoryInfo[] arrayOfMemoryInfo = ((ActivityManager)MobileQQ.getContext().getSystemService("activity")).getProcessMemoryInfo(new int[] { paramInt });
      if ((arrayOfMemoryInfo != null) && (arrayOfMemoryInfo.length > 0))
      {
        paramDebugMemoryInfo.jdField_a_of_type_Long = (arrayOfMemoryInfo[0].getTotalPss() * 1024L);
        paramDebugMemoryInfo.jdField_b_of_type_Long = (arrayOfMemoryInfo[0].nativePss * 1024L);
        paramDebugMemoryInfo.jdField_c_of_type_Long = (arrayOfMemoryInfo[0].dalvikPss * 1024L);
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.Memory.MemoryManager", 2, "getMemory ex pid=" + paramInt, localException);
      }
      paramDebugMemoryInfo.jdField_a_of_type_Long = 62914560L;
      paramDebugMemoryInfo.jdField_b_of_type_Long = 31457280L;
      paramDebugMemoryInfo.jdField_c_of_type_Long = 31457280L;
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.Memory.MemoryManager", 2, new Object[] { "getMemory OutOfMemoryError pid=", Integer.valueOf(paramInt), localOutOfMemoryError });
        }
      }
    }
  }
  
  private void a(long paramLong1, long paramLong2, SharedPreferences paramSharedPreferences)
  {
    if (Math.abs(paramLong1 - paramLong2) > 86400000L)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        MemoryManager.StatMemory localStatMemory = (MemoryManager.StatMemory)((Map.Entry)localObject).getValue();
        int i = localStatMemory.jdField_a_of_type_Int;
        if (i <= 0)
        {
          localStatMemory.a();
        }
        else
        {
          HashMap localHashMap = new HashMap();
          localObject = (String)((Map.Entry)localObject).getKey();
          if ((!"BG_GUARD".equals(localObject)) && (!"LITE_GUARD".equals(localObject))) {
            throw new IllegalStateException("mode illegal");
          }
          localHashMap.put("startMode", localObject);
          paramLong2 = DeviceInfoUtil.a() / 1024L;
          if (paramLong2 <= 0L) {
            throw new IllegalStateException("sysTotalMemory illegal");
          }
          localHashMap.put("sysTotalMemory", String.valueOf(paramLong2));
          paramLong2 = DeviceInfoUtil.f() / 1024L;
          if (paramLong2 <= 0L) {
            throw new IllegalStateException("sysClassMemory illegal");
          }
          localHashMap.put("sysClassMemory", String.valueOf(paramLong2));
          paramLong2 = localStatMemory.jdField_a_of_type_Long / (i * 1024);
          if (paramLong2 <= 0L) {
            throw new IllegalStateException("sysAvailableMemory illegal");
          }
          localHashMap.put("sysAvailableMemory", String.valueOf(paramLong2));
          paramLong2 = localStatMemory.jdField_b_of_type_Long / (i * 1024);
          if (paramLong2 < 0L) {
            throw new IllegalStateException("qqOtherUsedMemory illegal");
          }
          localHashMap.put("qqOtherUsedMemory", String.valueOf(paramLong2));
          paramLong2 = localStatMemory.jdField_c_of_type_Long / (i * 1024);
          if (paramLong2 <= 0L) {
            throw new IllegalStateException("qqUsedMemory illegal");
          }
          localHashMap.put("qqUsedMemory", String.valueOf(paramLong2));
          paramLong2 = localStatMemory.g / (i * 1024);
          if (paramLong2 <= 0L) {
            throw new IllegalStateException("dalvikPss illegal " + paramLong2);
          }
          localHashMap.put("dalvikPss", String.valueOf(paramLong2));
          paramLong2 = localStatMemory.h / (i * 1024);
          if (paramLong2 <= 0L) {
            throw new IllegalStateException("dalvikHeap illegal " + paramLong2);
          }
          localHashMap.put("dalvikHeap", String.valueOf(paramLong2));
          paramLong2 = localStatMemory.f / (i * 1024);
          if (paramLong2 <= 0L) {
            throw new IllegalStateException("nativePss illegal " + paramLong2);
          }
          localHashMap.put("nativePss", String.valueOf(paramLong2));
          localHashMap.put("maxHeap", String.valueOf(Runtime.getRuntime().maxMemory() / 1024L));
          paramLong2 = localStatMemory.d / (i * 1024);
          if (paramLong2 < 0L) {
            throw new IllegalStateException("imageCacheMax illegal");
          }
          localHashMap.put("imageCacheMax", String.valueOf(paramLong2));
          paramLong2 = localStatMemory.e / (i * 1024);
          if (paramLong2 < 0L) {
            throw new IllegalStateException("imageCacheUsed illegal");
          }
          localHashMap.put("imageCacheUsed", String.valueOf(paramLong2));
          paramLong2 = localStatMemory.jdField_c_of_type_Int / i;
          if (paramLong2 < 0L) {
            throw new IllegalStateException("imageHitCount illegal");
          }
          localHashMap.put("imageHitCount", String.valueOf(paramLong2));
          if (localStatMemory.jdField_c_of_type_Int + localStatMemory.jdField_b_of_type_Int != 0) {}
          for (i = localStatMemory.jdField_c_of_type_Int * 100 / (localStatMemory.jdField_c_of_type_Int + localStatMemory.jdField_b_of_type_Int);; i = 0)
          {
            paramLong2 = i;
            if (paramLong2 >= 0L) {
              break;
            }
            throw new IllegalStateException("imageHitRate illegal");
          }
          localHashMap.put("imageHitRate", String.valueOf(paramLong2));
          localHashMap.put("guardConfigId", ((IPerfApi)QRoute.api(IPerfApi.class)).getGuardConfigID());
          localHashMap.put("memoryConfigId", MagnifierSDK.a().a().jdField_a_of_type_JavaLangString);
          localHashMap.put("osVersion", Build.VERSION.RELEASE);
          localHashMap.put("resolution", DeviceInfoUtil.l());
          if (MagnifierSDK.a().a().jdField_a_of_type_ComTencentQqperfOptClearmemoryClearMemoryConfig.jdField_a_of_type_Boolean)
          {
            localObject = "1";
            label848:
            localHashMap.put("clearMemFlag", localObject);
            if (!MagnifierSDK.a().a().b) {
              break label928;
            }
          }
          label928:
          for (i = 1;; i = 0)
          {
            localHashMap.put("enable_heap_sucide", String.valueOf(i));
            StatisticCollector.getInstance(MobileQQ.getContext()).collectPerformance(null, "actMemory", true, 0L, 0L, localHashMap, null);
            localStatMemory.a();
            localStatMemory.b();
            break;
            localObject = "0";
            break label848;
          }
        }
      }
      paramSharedPreferences.edit().putLong("StateMemoryLastTime", paramLong1).commit();
    }
  }
  
  public float a()
  {
    long l1 = Runtime.getRuntime().totalMemory();
    long l2 = Runtime.getRuntime().maxMemory();
    return (float)l1 * 1.0F / (float)l2;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a()
  {
    long l2 = 1L;
    if (MobileQQ.sProcessId == 1) {}
    try
    {
      SharedPreferences localSharedPreferences = MobileQQ.getContext().getSharedPreferences("pref_oom", 0);
      if (localSharedPreferences.contains("enable_sucide_heap")) {
        localSharedPreferences.edit().remove("enable_sucide_heap");
      }
      localSharedPreferences.edit().putLong("heap_size", Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
      localSharedPreferences.edit().putLong("sys_pss", a(Process.myPid()));
      localSharedPreferences.edit().putLong("sys_total", jdField_b_of_type_Long);
      localSharedPreferences.edit().putLong("heap_free", Runtime.getRuntime().freeMemory());
      localSharedPreferences.edit().putLong("heap_total", Runtime.getRuntime().totalMemory());
      localSharedPreferences.edit().putLong("heap_max", Runtime.getRuntime().maxMemory());
      localSharedPreferences.edit().putLong("heap_org_max", HackVmImpl.jdField_a_of_type_Long);
      localSharedPreferences.edit().putInt("leak_actvity_count", this.jdField_a_of_type_Int);
      localSharedPreferences.edit().putInt("leak_qqapp_count", this.jdField_b_of_type_Int);
      localSharedPreferences.edit().putInt("leak_other_count", this.jdField_c_of_type_Int);
      SharedPreferences.Editor localEditor = localSharedPreferences.edit();
      if (MagnifierSDK.a().a().b)
      {
        l1 = 1L;
        localEditor.putLong("enable_sucide_heap_new", l1);
        localEditor = localSharedPreferences.edit();
        if (!MagnifierSDK.a().a().d) {
          break label406;
        }
      }
      label406:
      for (long l1 = l2;; l1 = 0L)
      {
        localEditor.putLong("en_sucide_ab", l1);
        localSharedPreferences.edit().putString("key_top_act", ((IPerfApi)QRoute.api(IPerfApi.class)).getTopActivityName());
        localSharedPreferences.edit().putString("key_mem_usg", SceneTracker.a().a());
        localSharedPreferences.edit().commit();
        return;
        l1 = 0L;
        break;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.d("Q.Memory.MemoryManager", 2, "onOOMCrash", localThrowable);
    }
  }
  
  public void a(long paramLong)
  {
    long l1;
    if (paramLong == 2L)
    {
      localSharedPreferences = MobileQQ.getContext().getSharedPreferences("pref_oom", 0);
      l1 = localSharedPreferences.getLong("oom_scid_count", 0L);
      localSharedPreferences.edit().putLong("oom_scid_count", l1 + 1L);
      localSharedPreferences.edit().commit();
    }
    long l3 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    long l4 = Runtime.getRuntime().totalMemory();
    long l5 = Runtime.getRuntime().maxMemory();
    float f = (float)l4 * 1.0F / (float)l5;
    long l6 = DeviceInfoUtil.e();
    long l7 = a(Process.myPid());
    SharedPreferences localSharedPreferences = MobileQQ.getContext().getSharedPreferences("pref_heap_level", 0);
    if (localSharedPreferences.contains("enable_sucide_heap")) {
      localSharedPreferences.edit().remove("enable_sucide_heap");
    }
    if (paramLong == 2L)
    {
      localSharedPreferences.edit().putLong("guard_type", paramLong);
      localSharedPreferences.edit().putLong("heap_size", l3);
      localSharedPreferences.edit().putLong("heap_total", l4);
      localSharedPreferences.edit().putLong("heap_max", l5);
      localSharedPreferences.edit().putFloat("heap_level", f);
      localSharedPreferences.edit().putLong("sys_total", l6);
      localSharedPreferences.edit().putLong("sys_pss", l7);
      localObject = localSharedPreferences.edit();
      if (MagnifierSDK.a().a().b)
      {
        paramLong = 1L;
        ((SharedPreferences.Editor)localObject).putLong("enable_sucide_heap_new", paramLong);
        localObject = localSharedPreferences.edit();
        if (!MagnifierSDK.a().a().d) {
          break label382;
        }
        paramLong = 1L;
        label351:
        ((SharedPreferences.Editor)localObject).putLong("en_sucide_ab", paramLong);
        localSharedPreferences.edit().commit();
      }
    }
    label382:
    do
    {
      return;
      paramLong = 0L;
      break;
      paramLong = 0L;
      break label351;
      if (localSharedPreferences.getFloat("heap_level", -1.0F) > 0.0F)
      {
        localObject = new HashMap(10);
        ((HashMap)localObject).put("guard_type", String.valueOf(localSharedPreferences.getLong("guard_type", -1L)));
        ((HashMap)localObject).put("heap_size", String.valueOf(localSharedPreferences.getLong("heap_size", -1L)));
        ((HashMap)localObject).put("heap_total", String.valueOf(localSharedPreferences.getLong("heap_total", -1L)));
        ((HashMap)localObject).put("heap_max", String.valueOf(localSharedPreferences.getLong("heap_max", -1L)));
        ((HashMap)localObject).put("heap_level", String.valueOf(localSharedPreferences.getFloat("heap_level", -1.0F)));
        ((HashMap)localObject).put("sys_total", String.valueOf(localSharedPreferences.getLong("sys_total", -1L)));
        ((HashMap)localObject).put("sys_pss", String.valueOf(localSharedPreferences.getLong("sys_pss", -1L)));
        ((HashMap)localObject).put("enable_sucide_heap_new", String.valueOf(localSharedPreferences.getLong("enable_sucide_heap_new", -1L)));
        ((HashMap)localObject).put("en_sucide_ab", String.valueOf(localSharedPreferences.getLong("en_sucide_ab", -1L)));
        StatisticCollector.getInstance(MobileQQ.getContext()).collectPerformance(null, "HeapLevel", true, 0L, 0L, (HashMap)localObject, null);
        localSharedPreferences.edit().remove("heap_level").commit();
      }
      localSharedPreferences = MobileQQ.getContext().getSharedPreferences("MemoryManagerMemoryStat", 0);
      long l2 = localSharedPreferences.getLong("HeapLevelReportLastTime", 0L);
      l1 = l2;
      if (l2 == 0L)
      {
        l1 = System.currentTimeMillis();
        localSharedPreferences.edit().putLong("HeapLevelReportLastTime", l1).commit();
      }
    } while ((Math.abs(System.currentTimeMillis() - l1) <= 86400000L) || (!MagnifierSDK.a().a().c));
    Object localObject = new HashMap(10);
    ((HashMap)localObject).put("guard_type", String.valueOf(paramLong));
    ((HashMap)localObject).put("heap_size", String.valueOf(l3));
    ((HashMap)localObject).put("heap_total", String.valueOf(l4));
    ((HashMap)localObject).put("heap_max", String.valueOf(l5));
    ((HashMap)localObject).put("heap_level", String.valueOf(f));
    ((HashMap)localObject).put("sys_total", String.valueOf(l6));
    ((HashMap)localObject).put("sys_pss", String.valueOf(l7));
    if (MagnifierSDK.a().a().b)
    {
      i = 1;
      ((HashMap)localObject).put("enable_sucide_heap_new", String.valueOf(i));
      if (!MagnifierSDK.a().a().d) {
        break label988;
      }
    }
    label988:
    for (int i = 1;; i = 0)
    {
      ((HashMap)localObject).put("en_sucide_ab", String.valueOf(i));
      StatisticCollector.getInstance(MobileQQ.getContext()).collectPerformance(null, "HeapLevel", true, 0L, 0L, (HashMap)localObject, null);
      localSharedPreferences.edit().putLong("HeapLevelReportLastTime", System.currentTimeMillis()).commit();
      return;
      i = 0;
      break;
    }
  }
  
  protected void a(long paramLong1, long paramLong2)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      MemoryManager.LowMemoryReport localLowMemoryReport = a();
      localLowMemoryReport.jdField_a_of_type_Long += paramLong2;
      localLowMemoryReport.jdField_b_of_type_Long += paramLong1;
      localLowMemoryReport.jdField_a_of_type_Int += 1;
      localLowMemoryReport.c();
      return;
    }
  }
  
  public void a(Context paramContext, Class paramClass, int paramInt)
  {
    if (MagnifierSDK.a().a().jdField_a_of_type_Boolean) {
      ThreadManager.executeOnNetWorkThread(new MemoryManager.AlertMemoryRunner(paramContext, 2, paramClass, paramInt));
    }
  }
  
  public void a(MemoryManager.IReportListener paramIReportListener)
  {
    this.jdField_a_of_type_ComTencentQqperfMonitorMemoryMemoryManager$IReportListener = paramIReportListener;
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentQqperfMonitorMemoryMemoryManager$IReportListener != null) && ("BG_GUARD".equals(paramString))) {
      this.jdField_a_of_type_ComTencentQqperfMonitorMemoryMemoryManager$IReportListener.a();
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.Memory.MemoryManager", 2, "Report memory do not need report");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.Memory.MemoryManager", 2, "Report memory with action = " + paramString);
    }
    b(paramString);
    c();
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public final void b()
  {
    SharedPreferences localSharedPreferences;
    HashMap localHashMap;
    if (MobileQQ.sProcessId == 1)
    {
      localSharedPreferences = MobileQQ.getContext().getSharedPreferences("pref_oom", 0);
      if (localSharedPreferences.contains("enable_sucide_heap")) {
        localSharedPreferences.edit().remove("enable_sucide_heap");
      }
      if (localSharedPreferences.contains("leak_actvity_count"))
      {
        localHashMap = new HashMap(10);
        localHashMap.put("maxHeap", String.valueOf(Runtime.getRuntime().maxMemory()));
        localHashMap.put("osVersion", String.valueOf(Build.VERSION.SDK_INT));
        localHashMap.put("hackResult", String.valueOf(HackVmImpl.jdField_c_of_type_Int));
        localHashMap.put("hackArtResult", String.valueOf(HackVmImpl.d));
        localHashMap.put("heap_size", String.valueOf(localSharedPreferences.getLong("heap_size", -1L)));
        localHashMap.put("leak_actvity_count", String.valueOf(localSharedPreferences.getInt("leak_actvity_count", -1)));
        localHashMap.put("leak_qqapp_count", String.valueOf(localSharedPreferences.getInt("leak_qqapp_count", -1)));
        localHashMap.put("leak_other_count", String.valueOf(localSharedPreferences.getInt("leak_other_count", -1)));
        localHashMap.put("sys_pss", String.valueOf(localSharedPreferences.getLong("sys_pss", -1L)));
        localHashMap.put("sys_total", String.valueOf(localSharedPreferences.getLong("sys_total", -1L)));
        localHashMap.put("heap_free", String.valueOf(localSharedPreferences.getLong("heap_free", -1L)));
        localHashMap.put("heap_total", String.valueOf(localSharedPreferences.getLong("heap_total", -1L)));
        localHashMap.put("heap_max", String.valueOf(localSharedPreferences.getLong("heap_max", -1L)));
        localHashMap.put("heap_org_max", String.valueOf(localSharedPreferences.getLong("heap_org_max", -1L)));
        localHashMap.put("oom_scid_count", String.valueOf(localSharedPreferences.getLong("oom_scid_count", -1L)));
        localHashMap.put("enable_sucide_heap_new", String.valueOf(localSharedPreferences.getLong("enable_sucide_heap_new", -1L)));
        localHashMap.put("en_sucide_ab", String.valueOf(localSharedPreferences.getLong("en_sucide_ab", -1L)));
        localHashMap.put("key_top_act", localSharedPreferences.getString("key_top_act", ""));
        localHashMap.put("key_mem_usg", localSharedPreferences.getString("key_mem_usg", ""));
        str = System.getProperty("java.vm.version");
        if (TextUtils.isEmpty(str)) {
          break label550;
        }
      }
    }
    label550:
    for (String str = str.substring(0, 1);; str = "")
    {
      localHashMap.put("vmVersion", str);
      StatisticCollector.getInstance(MobileQQ.getContext()).collectPerformance(null, "oomInfo", true, 0L, 0L, localHashMap, null);
      localSharedPreferences.edit().putLong("oom_scid_count", 0L);
      localSharedPreferences.edit().remove("leak_actvity_count").commit();
      MemoryClearManager.a().d();
      return;
    }
  }
  
  protected void b(long paramLong1, long paramLong2)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      MemoryManager.LowMemoryReport localLowMemoryReport = a();
      localLowMemoryReport.jdField_c_of_type_Long += paramLong2;
      localLowMemoryReport.d += paramLong1;
      localLowMemoryReport.jdField_b_of_type_Int += 1;
      localLowMemoryReport.c();
      return;
    }
  }
  
  protected void b(String paramString)
  {
    Object localObject = (ActivityManager)MobileQQ.getContext().getSystemService("activity");
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get("LITE_GUARD") == null)
    {
      localStatMemory = new MemoryManager.StatMemory();
      localStatMemory.a("LITE_GUARD");
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put("LITE_GUARD", localStatMemory);
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get("BG_GUARD") == null)
    {
      localStatMemory = new MemoryManager.StatMemory();
      localStatMemory.a("BG_GUARD");
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put("BG_GUARD", localStatMemory);
    }
    if ("LITE_GUARD".equals(paramString)) {}
    for (MemoryManager.StatMemory localStatMemory = (MemoryManager.StatMemory)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get("LITE_GUARD"); localStatMemory == null; localStatMemory = (MemoryManager.StatMemory)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get("BG_GUARD"))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.Memory.MemoryManager", 2, " curStateMemory == null return with no stat");
      }
      label144:
      return;
      if (!"BG_GUARD".equals(paramString)) {
        break label814;
      }
    }
    long l3 = DeviceInfoUtil.e();
    MemoryManager.DebugMemoryInfo localDebugMemoryInfo = new MemoryManager.DebugMemoryInfo();
    a(Process.myPid(), localDebugMemoryInfo);
    long l4 = localDebugMemoryInfo.jdField_a_of_type_Long;
    long l1 = 0L;
    label811:
    label814:
    label820:
    for (;;)
    {
      try
      {
        localObject = ((ActivityManager)localObject).getRunningAppProcesses();
        long l2 = l1;
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          l2 = l1;
          if (((Iterator)localObject).hasNext())
          {
            ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
            String str = localRunningAppProcessInfo.processName;
            if ((!str.startsWith("com.tencent.mobileqq")) || (str.equals("com.tencent.mobileqq"))) {
              break label811;
            }
            l1 = a(localRunningAppProcessInfo.pid) + l1;
            break label820;
          }
        }
        if ((l3 < 0L) || (l4 < 0L) || (l2 < 0L)) {
          break label144;
        }
        localStatMemory.jdField_a_of_type_Long += l3;
        localStatMemory.jdField_b_of_type_Long += l2;
        localStatMemory.jdField_c_of_type_Long += l4;
        localStatMemory.g += localDebugMemoryInfo.jdField_c_of_type_Long;
        localStatMemory.f += localDebugMemoryInfo.jdField_b_of_type_Long;
        localStatMemory.h += Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        localStatMemory.jdField_a_of_type_Int += 1;
        localObject = GlobalImageCache.a;
        localStatMemory.d += ((MQLruCache)localObject).maxSize();
        localStatMemory.e += ((MQLruCache)localObject).size();
        localStatMemory.jdField_c_of_type_Int += ((MQLruCache)localObject).hitCount();
        int i = localStatMemory.jdField_b_of_type_Int;
        localStatMemory.jdField_b_of_type_Int = (((MQLruCache)localObject).missCount() + i);
        l3 = System.currentTimeMillis();
        localObject = MobileQQ.getContext().getSharedPreferences("MemoryManagerMemoryStat", 0);
        l2 = ((SharedPreferences)localObject).getLong("StateMemoryLastTime", 0L);
        l1 = l2;
        if (l2 == 0L)
        {
          l1 = System.currentTimeMillis();
          ((SharedPreferences)localObject).edit().putLong("StateMemoryLastTime", l1).commit();
        }
        a(l3, l1, (SharedPreferences)localObject);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("reportMemoryInfo, start mode =").append(paramString).append("sysTotalMemory=").append(DeviceInfoUtil.a()).append(",statCount=").append(localStatMemory.jdField_a_of_type_Int).append(",sysClassMemory=").append(DeviceInfoUtil.f()).append(",sysAvailableMemory=").append(localStatMemory.jdField_a_of_type_Long).append(",qqOtherUsedMemory=").append(localStatMemory.jdField_b_of_type_Long).append(",qqUsedMemory=").append(localStatMemory.jdField_c_of_type_Long).append(",imageCacheMax=").append(localStatMemory.d).append(",imageCacheUsed=").append(localStatMemory.e).append(",imageHitCount=").append(localStatMemory.jdField_c_of_type_Int).append(",imageHitTotal=").append(localStatMemory.jdField_c_of_type_Int + localStatMemory.jdField_b_of_type_Int).append("\n");
          QLog.d("Q.Memory.MemoryManager", 2, ((StringBuilder)localObject).toString());
        }
        localStatMemory.b();
        return;
      }
      catch (IllegalStateException paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.Memory.MemoryManager", 2, "reportMemoryInfo exception", paramString);
        }
        localStatMemory.a();
        localStatMemory.b();
        return;
      }
      catch (Exception paramString) {}
      if (!QLog.isColorLevel()) {
        break label144;
      }
      QLog.d("Q.Memory.MemoryManager", 2, "reportMemoryInfo exception", paramString);
      return;
      break label820;
      localStatMemory = null;
      break;
    }
  }
  
  public int c()
  {
    return this.jdField_c_of_type_Int;
  }
  
  protected void c()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      localLowMemoryReport = a();
      l1 = System.currentTimeMillis();
      long l2 = localLowMemoryReport.e;
      if (l1 - l2 > 86400000L) {}
      for (;;)
      {
        try
        {
          i = localLowMemoryReport.jdField_a_of_type_Int;
          j = localLowMemoryReport.jdField_b_of_type_Int;
          HashMap localHashMap = new HashMap();
          localHashMap.put("sysTotalMemory", String.valueOf(DeviceInfoUtil.a() / 1024L));
          if (i != 0) {
            continue;
          }
          str = "0";
          localHashMap.put("lowWarningMemory", str);
          if (i != 0) {
            continue;
          }
          str = "0";
          localHashMap.put("lowRemainMemory", str);
          localHashMap.put("lowMemoryCount", String.valueOf(i));
          if (j != 0) {
            continue;
          }
          str = "0";
          localHashMap.put("clearWarningMemory", str);
          if (j != 0) {
            continue;
          }
          str = "0";
          localHashMap.put("clearRemainMemory", str);
          localHashMap.put("clearCount", String.valueOf(j));
          StatisticCollector.getInstance(MobileQQ.getContext()).collectPerformance(null, "LowMemoryStat", true, 0L, 0L, localHashMap, null);
          if (QLog.isColorLevel()) {
            QLog.d("Q.Memory.MemoryManager", 2, "reportLowMemory, sysTotalMemory=" + String.valueOf(DeviceInfoUtil.a() / 1024L) + ", lowWarningMemory=" + localLowMemoryReport.jdField_b_of_type_Long + ", lowRemainMemory=" + localLowMemoryReport.jdField_a_of_type_Long + ", lowMemoryCount=" + i + ", clearWarningMemory=" + localLowMemoryReport.d + ", clearRemainMemory=" + localLowMemoryReport.jdField_c_of_type_Long + ",clearCount=" + j);
          }
        }
        catch (Exception localException)
        {
          int i;
          int j;
          String str;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("Q.Memory.MemoryManager", 2, "reportMemoryInfo exception", localException);
          localLowMemoryReport.b();
          localLowMemoryReport.e = l1;
          continue;
          localObject1 = finally;
          throw localObject1;
        }
        finally
        {
          localLowMemoryReport.b();
          localLowMemoryReport.e = l1;
        }
        localLowMemoryReport.c();
        return;
        str = String.valueOf(localLowMemoryReport.jdField_b_of_type_Long / (i * 1024));
        continue;
        str = String.valueOf(localLowMemoryReport.jdField_a_of_type_Long / (i * 1024));
        continue;
        str = String.valueOf(localLowMemoryReport.d / (j * 1024));
      }
      l2 = localLowMemoryReport.jdField_c_of_type_Long / (j * 1024);
      str = String.valueOf(l2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqperf.monitor.memory.MemoryManager
 * JD-Core Version:    0.7.0.1
 */