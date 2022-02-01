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
import com.tencent.qqperf.opt.clearmemory.MemoryClearManager;
import com.tencent.qqperf.opt.clearmemory.MemoryConfigs;
import com.tencent.qqperf.opt.vm.HackVmImpl;
import com.tencent.qqperf.tools.SceneTracker;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import mqq.app.MobileQQ;

public class MemoryManager
{
  private static long jdField_a_of_type_Long;
  private static MemoryManager jdField_a_of_type_ComTencentQqperfMonitorMemoryMemoryManager;
  private static List<String> jdField_a_of_type_JavaUtilList;
  private static long jdField_b_of_type_Long;
  private static List<Pattern> jdField_b_of_type_JavaUtilList;
  private static List<String> jdField_c_of_type_JavaUtilList;
  private int jdField_a_of_type_Int;
  private MemoryManager.IReportListener jdField_a_of_type_ComTencentQqperfMonitorMemoryMemoryManager$IReportListener;
  private MemoryManager.LowMemoryReport jdField_a_of_type_ComTencentQqperfMonitorMemoryMemoryManager$LowMemoryReport;
  private Object jdField_a_of_type_JavaLangObject;
  private ConcurrentHashMap<String, MemoryManager.StatMemory> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private int jdField_c_of_type_Int;
  
  private MemoryManager()
  {
    boolean bool = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(0);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_ComTencentQqperfMonitorMemoryMemoryManager$LowMemoryReport = null;
    if (0.1000000014901161D >= Math.random()) {
      bool = true;
    }
    this.jdField_a_of_type_Boolean = bool;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("memory manager set need report = ");
      localStringBuilder.append(this.jdField_a_of_type_Boolean);
      QLog.d("Q.Memory.MemoryManager", 2, localStringBuilder.toString());
    }
    a(MemoryClearManager.a());
  }
  
  public static long a()
  {
    long l1 = jdField_a_of_type_Long;
    if (l1 > 0L) {
      return l1;
    }
    l1 = DeviceInfoUtil.a();
    jdField_b_of_type_Long = l1;
    long l2 = DeviceInfoUtil.e();
    long l3 = (3L * l1 + 7L * l2) / 10L;
    long l4 = DeviceInfoUtil.f();
    if (l3 <= 157286400L) {
      jdField_a_of_type_Long = Math.min(25165824L, l4);
    } else if (l3 <= 262144000L) {
      jdField_a_of_type_Long = Math.min(37748736L, l4);
    } else if (l3 <= 419430400L) {
      jdField_a_of_type_Long = Math.min(67108864L, l4);
    } else if (l3 <= 524288000L) {
      jdField_a_of_type_Long = Math.min(134217728L, l4);
    } else {
      jdField_a_of_type_Long = Math.min(268435456L, l4);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getAvailClassSize, availClassSize=");
      localStringBuilder.append(jdField_a_of_type_Long / 1048576L);
      localStringBuilder.append("M, totalMemSize=");
      localStringBuilder.append(l1 / 1048576L);
      localStringBuilder.append("M, remainMemSize=");
      localStringBuilder.append(l2 / 1048576L);
      localStringBuilder.append("M, availMemSize=");
      localStringBuilder.append(l3 / 1048576L);
      localStringBuilder.append("M, classMemSize=");
      localStringBuilder.append(l4 / 1048576L);
      localStringBuilder.append("M");
      QLog.d("Q.Memory.MemoryManager", 2, localStringBuilder.toString());
    }
    return jdField_a_of_type_Long;
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
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.Memory.MemoryManager", 2, new Object[] { "getMemory OutOfMemoryError pid=", Integer.valueOf(paramInt), localOutOfMemoryError });
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getMemory ex pid=");
        localStringBuilder.append(paramInt);
        QLog.d("Q.Memory.MemoryManager", 2, localStringBuilder.toString(), localException);
      }
    }
    return 62914560L;
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
    if (jdField_a_of_type_ComTencentQqperfMonitorMemoryMemoryManager == null) {
      try
      {
        if (jdField_a_of_type_ComTencentQqperfMonitorMemoryMemoryManager == null) {
          jdField_a_of_type_ComTencentQqperfMonitorMemoryMemoryManager = new MemoryManager();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentQqperfMonitorMemoryMemoryManager;
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
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.Memory.MemoryManager", 2, new Object[] { "getMemory OutOfMemoryError pid=", Integer.valueOf(paramInt), localOutOfMemoryError });
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getMemory ex pid=");
        localStringBuilder.append(paramInt);
        QLog.d("Q.Memory.MemoryManager", 2, localStringBuilder.toString(), localException);
      }
    }
    paramDebugMemoryInfo.jdField_a_of_type_Long = 62914560L;
    paramDebugMemoryInfo.jdField_b_of_type_Long = 31457280L;
    paramDebugMemoryInfo.jdField_c_of_type_Long = 31457280L;
  }
  
  private void a(long paramLong1, long paramLong2, SharedPreferences paramSharedPreferences)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
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
    if (MobileQQ.sProcessId == 1) {}
    for (;;)
    {
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
        boolean bool = MagnifierSDK.a().a().b;
        long l2 = 1L;
        if (!bool) {
          break label425;
        }
        l1 = 1L;
        localEditor.putLong("enable_sucide_heap_new", l1);
        localEditor = localSharedPreferences.edit();
        if (!MagnifierSDK.a().a().d) {
          break label430;
        }
        l1 = l2;
        localEditor.putLong("en_sucide_ab", l1);
        localSharedPreferences.edit().putString("key_top_act", ((IPerfApi)QRoute.api(IPerfApi.class)).getTopActivityName());
        localSharedPreferences.edit().putString("key_mem_usg", SceneTracker.a().a());
        localSharedPreferences.edit().commit();
        return;
      }
      catch (Throwable localThrowable)
      {
        QLog.d("Q.Memory.MemoryManager", 2, "onOOMCrash", localThrowable);
      }
      return;
      label425:
      long l1 = 0L;
      continue;
      label430:
      l1 = 0L;
    }
  }
  
  public void a(long paramLong)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Report memory with action = ");
      localStringBuilder.append(paramString);
      QLog.d("Q.Memory.MemoryManager", 2, localStringBuilder.toString());
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
    if (MobileQQ.sProcessId == 1)
    {
      SharedPreferences localSharedPreferences = MobileQQ.getContext().getSharedPreferences("pref_oom", 0);
      if (localSharedPreferences.contains("enable_sucide_heap")) {
        localSharedPreferences.edit().remove("enable_sucide_heap");
      }
      if (localSharedPreferences.contains("leak_actvity_count"))
      {
        HashMap localHashMap = new HashMap(10);
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
        String str1 = "";
        localHashMap.put("key_top_act", localSharedPreferences.getString("key_top_act", ""));
        localHashMap.put("key_mem_usg", localSharedPreferences.getString("key_mem_usg", ""));
        String str2 = System.getProperty("java.vm.version");
        if (!TextUtils.isEmpty(str2)) {
          str1 = str2.substring(0, 1);
        }
        localHashMap.put("vmVersion", str1);
        StatisticCollector.getInstance(MobileQQ.getContext()).collectPerformance(null, "oomInfo", true, 0L, 0L, localHashMap, null);
        localSharedPreferences.edit().putLong("oom_scid_count", 0L);
        localSharedPreferences.edit().remove("leak_actvity_count").commit();
      }
      MemoryClearManager.a().d();
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
    MemoryManager.StatMemory localStatMemory = null;
    if ("LITE_GUARD".equals(paramString)) {
      localStatMemory = (MemoryManager.StatMemory)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get("LITE_GUARD");
    } else if ("BG_GUARD".equals(paramString)) {
      localStatMemory = (MemoryManager.StatMemory)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get("BG_GUARD");
    }
    if (localStatMemory == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.Memory.MemoryManager", 2, " curStateMemory == null return with no stat");
      }
      return;
    }
    long l3 = DeviceInfoUtil.e();
    MemoryManager.DebugMemoryInfo localDebugMemoryInfo = new MemoryManager.DebugMemoryInfo();
    a(Process.myPid(), localDebugMemoryInfo);
    long l4 = localDebugMemoryInfo.jdField_a_of_type_Long;
    try
    {
      localObject = ((ActivityManager)localObject).getRunningAppProcesses();
      if (localObject == null) {
        break label874;
      }
      localObject = ((List)localObject).iterator();
      l1 = 0L;
      if (!((Iterator)localObject).hasNext()) {
        break label871;
      }
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
      String str = localRunningAppProcessInfo.processName;
      l2 = l1;
      if (!str.startsWith("com.tencent.mobileqq")) {
        break label865;
      }
      l2 = l1;
      if (str.equals("com.tencent.mobileqq")) {
        break label865;
      }
      l2 = l1 + a(localRunningAppProcessInfo.pid);
    }
    catch (Exception paramString)
    {
      if (!QLog.isColorLevel()) {
        break label864;
      }
      QLog.d("Q.Memory.MemoryManager", 2, "reportMemoryInfo exception", paramString);
      return;
    }
    catch (IllegalStateException paramString)
    {
      label300:
      if (!QLog.isColorLevel()) {
        break label854;
      }
      QLog.d("Q.Memory.MemoryManager", 2, "reportMemoryInfo exception", paramString);
      localStatMemory.a();
      localStatMemory.b();
    }
    localStatMemory.jdField_a_of_type_Long += l3;
    localStatMemory.jdField_b_of_type_Long += l1;
    localStatMemory.jdField_c_of_type_Long += l4;
    localStatMemory.g += localDebugMemoryInfo.jdField_c_of_type_Long;
    localStatMemory.f += localDebugMemoryInfo.jdField_b_of_type_Long;
    localStatMemory.h += Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    localStatMemory.jdField_a_of_type_Int += 1;
    localObject = GlobalImageCache.a;
    localStatMemory.d += ((MQLruCache)localObject).maxSize();
    localStatMemory.e += ((MQLruCache)localObject).size();
    localStatMemory.jdField_c_of_type_Int += ((MQLruCache)localObject).hitCount();
    localStatMemory.jdField_b_of_type_Int += ((MQLruCache)localObject).missCount();
    long l2 = System.currentTimeMillis();
    localObject = MobileQQ.getContext().getSharedPreferences("MemoryManagerMemoryStat", 0);
    long l1 = ((SharedPreferences)localObject).getLong("StateMemoryLastTime", 0L);
    if (l1 == 0L)
    {
      l1 = System.currentTimeMillis();
      ((SharedPreferences)localObject).edit().putLong("StateMemoryLastTime", l1).commit();
    }
    for (;;)
    {
      a(l2, l1, (SharedPreferences)localObject);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("reportMemoryInfo, start mode =");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("sysTotalMemory=");
        ((StringBuilder)localObject).append(DeviceInfoUtil.a());
        ((StringBuilder)localObject).append(",statCount=");
        ((StringBuilder)localObject).append(localStatMemory.jdField_a_of_type_Int);
        ((StringBuilder)localObject).append(",sysClassMemory=");
        ((StringBuilder)localObject).append(DeviceInfoUtil.f());
        ((StringBuilder)localObject).append(",sysAvailableMemory=");
        ((StringBuilder)localObject).append(localStatMemory.jdField_a_of_type_Long);
        ((StringBuilder)localObject).append(",qqOtherUsedMemory=");
        ((StringBuilder)localObject).append(localStatMemory.jdField_b_of_type_Long);
        ((StringBuilder)localObject).append(",qqUsedMemory=");
        ((StringBuilder)localObject).append(localStatMemory.jdField_c_of_type_Long);
        ((StringBuilder)localObject).append(",imageCacheMax=");
        ((StringBuilder)localObject).append(localStatMemory.d);
        ((StringBuilder)localObject).append(",imageCacheUsed=");
        ((StringBuilder)localObject).append(localStatMemory.e);
        ((StringBuilder)localObject).append(",imageHitCount=");
        ((StringBuilder)localObject).append(localStatMemory.jdField_c_of_type_Int);
        ((StringBuilder)localObject).append(",imageHitTotal=");
        ((StringBuilder)localObject).append(localStatMemory.jdField_c_of_type_Int + localStatMemory.jdField_b_of_type_Int);
        ((StringBuilder)localObject).append("\n");
        paramString = ((StringBuilder)localObject).toString();
        try
        {
          QLog.d("Q.Memory.MemoryManager", 2, paramString);
        }
        catch (IllegalStateException paramString)
        {
          break label838;
        }
      }
      localStatMemory.b();
      return;
      label838:
      label854:
      label864:
      label865:
      label871:
      label874:
      do
      {
        return;
        return;
        l1 = l2;
        break;
        continue;
        l1 = 0L;
      } while ((l3 < 0L) || (l4 < 0L));
      if (l1 >= 0L) {
        break label300;
      }
      return;
    }
  }
  
  public int c()
  {
    return this.jdField_c_of_type_Int;
  }
  
  /* Error */
  protected void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 42	com/tencent/qqperf/monitor/memory/MemoryManager:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   4: astore 8
    //   6: aload 8
    //   8: monitorenter
    //   9: aload_0
    //   10: invokespecial 379	com/tencent/qqperf/monitor/memory/MemoryManager:a	()Lcom/tencent/qqperf/monitor/memory/MemoryManager$LowMemoryReport;
    //   13: astore 9
    //   15: invokestatic 592	java/lang/System:currentTimeMillis	()J
    //   18: lstore_3
    //   19: aload 9
    //   21: getfield 628	com/tencent/qqperf/monitor/memory/MemoryManager$LowMemoryReport:e	J
    //   24: lstore 5
    //   26: lload_3
    //   27: lload 5
    //   29: lsub
    //   30: ldc2_w 629
    //   33: lcmp
    //   34: ifle +471 -> 505
    //   37: aload 9
    //   39: getfield 382	com/tencent/qqperf/monitor/memory/MemoryManager$LowMemoryReport:jdField_a_of_type_Int	I
    //   42: istore_1
    //   43: aload 9
    //   45: getfield 502	com/tencent/qqperf/monitor/memory/MemoryManager$LowMemoryReport:jdField_b_of_type_Int	I
    //   48: istore_2
    //   49: new 419	java/util/HashMap
    //   52: dup
    //   53: invokespecial 631	java/util/HashMap:<init>	()V
    //   56: astore 10
    //   58: aload 10
    //   60: ldc_w 633
    //   63: invokestatic 95	com/tencent/mobileqq/utils/DeviceInfoUtil:a	()J
    //   66: ldc2_w 180
    //   69: ldiv
    //   70: invokestatic 425	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   73: invokevirtual 429	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   76: pop
    //   77: iload_1
    //   78: ifne +11 -> 89
    //   81: ldc_w 635
    //   84: astore 7
    //   86: goto +20 -> 106
    //   89: aload 9
    //   91: getfield 381	com/tencent/qqperf/monitor/memory/MemoryManager$LowMemoryReport:jdField_b_of_type_Long	J
    //   94: iload_1
    //   95: sipush 1024
    //   98: imul
    //   99: i2l
    //   100: ldiv
    //   101: invokestatic 425	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   104: astore 7
    //   106: aload 10
    //   108: ldc_w 637
    //   111: aload 7
    //   113: invokevirtual 429	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   116: pop
    //   117: iload_1
    //   118: ifne +11 -> 129
    //   121: ldc_w 635
    //   124: astore 7
    //   126: goto +20 -> 146
    //   129: aload 9
    //   131: getfield 380	com/tencent/qqperf/monitor/memory/MemoryManager$LowMemoryReport:jdField_a_of_type_Long	J
    //   134: iload_1
    //   135: sipush 1024
    //   138: imul
    //   139: i2l
    //   140: ldiv
    //   141: invokestatic 425	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   144: astore 7
    //   146: aload 10
    //   148: ldc_w 639
    //   151: aload 7
    //   153: invokevirtual 429	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   156: pop
    //   157: aload 10
    //   159: ldc_w 641
    //   162: iload_1
    //   163: invokestatic 439	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   166: invokevirtual 429	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   169: pop
    //   170: iload_2
    //   171: ifne +11 -> 182
    //   174: ldc_w 635
    //   177: astore 7
    //   179: goto +20 -> 199
    //   182: aload 9
    //   184: getfield 501	com/tencent/qqperf/monitor/memory/MemoryManager$LowMemoryReport:d	J
    //   187: iload_2
    //   188: sipush 1024
    //   191: imul
    //   192: i2l
    //   193: ldiv
    //   194: invokestatic 425	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   197: astore 7
    //   199: aload 10
    //   201: ldc_w 643
    //   204: aload 7
    //   206: invokevirtual 429	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   209: pop
    //   210: iload_2
    //   211: ifne +11 -> 222
    //   214: ldc_w 635
    //   217: astore 7
    //   219: goto +20 -> 239
    //   222: aload 9
    //   224: getfield 499	com/tencent/qqperf/monitor/memory/MemoryManager$LowMemoryReport:jdField_c_of_type_Long	J
    //   227: iload_2
    //   228: sipush 1024
    //   231: imul
    //   232: i2l
    //   233: ldiv
    //   234: invokestatic 425	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   237: astore 7
    //   239: aload 10
    //   241: ldc_w 645
    //   244: aload 7
    //   246: invokevirtual 429	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   249: pop
    //   250: aload 10
    //   252: ldc_w 647
    //   255: iload_2
    //   256: invokestatic 439	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   259: invokevirtual 429	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   262: pop
    //   263: invokestatic 159	mqq/app/MobileQQ:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   266: invokestatic 490	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   269: aconst_null
    //   270: ldc_w 649
    //   273: iconst_1
    //   274: lconst_0
    //   275: lconst_0
    //   276: aload 10
    //   278: aconst_null
    //   279: invokevirtual 496	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   282: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   285: ifeq +160 -> 445
    //   288: new 60	java/lang/StringBuilder
    //   291: dup
    //   292: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   295: astore 7
    //   297: aload 7
    //   299: ldc_w 651
    //   302: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: pop
    //   306: aload 7
    //   308: invokestatic 95	com/tencent/mobileqq/utils/DeviceInfoUtil:a	()J
    //   311: ldc2_w 180
    //   314: ldiv
    //   315: invokestatic 425	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   318: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: pop
    //   322: aload 7
    //   324: ldc_w 653
    //   327: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: pop
    //   331: aload 7
    //   333: aload 9
    //   335: getfield 381	com/tencent/qqperf/monitor/memory/MemoryManager$LowMemoryReport:jdField_b_of_type_Long	J
    //   338: invokevirtual 138	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   341: pop
    //   342: aload 7
    //   344: ldc_w 655
    //   347: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: pop
    //   351: aload 7
    //   353: aload 9
    //   355: getfield 380	com/tencent/qqperf/monitor/memory/MemoryManager$LowMemoryReport:jdField_a_of_type_Long	J
    //   358: invokevirtual 138	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   361: pop
    //   362: aload 7
    //   364: ldc_w 657
    //   367: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: pop
    //   371: aload 7
    //   373: iload_1
    //   374: invokevirtual 197	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   377: pop
    //   378: aload 7
    //   380: ldc_w 659
    //   383: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: pop
    //   387: aload 7
    //   389: aload 9
    //   391: getfield 501	com/tencent/qqperf/monitor/memory/MemoryManager$LowMemoryReport:d	J
    //   394: invokevirtual 138	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   397: pop
    //   398: aload 7
    //   400: ldc_w 661
    //   403: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: pop
    //   407: aload 7
    //   409: aload 9
    //   411: getfield 499	com/tencent/qqperf/monitor/memory/MemoryManager$LowMemoryReport:jdField_c_of_type_Long	J
    //   414: invokevirtual 138	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   417: pop
    //   418: aload 7
    //   420: ldc_w 663
    //   423: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   426: pop
    //   427: aload 7
    //   429: iload_2
    //   430: invokevirtual 197	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   433: pop
    //   434: ldc 72
    //   436: iconst_2
    //   437: aload 7
    //   439: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   442: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   445: aload 9
    //   447: invokevirtual 664	com/tencent/qqperf/monitor/memory/MemoryManager$LowMemoryReport:b	()V
    //   450: aload 9
    //   452: lload_3
    //   453: putfield 628	com/tencent/qqperf/monitor/memory/MemoryManager$LowMemoryReport:e	J
    //   456: goto +49 -> 505
    //   459: astore 7
    //   461: goto +30 -> 491
    //   464: astore 7
    //   466: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   469: ifeq +14 -> 483
    //   472: ldc 72
    //   474: iconst_2
    //   475: ldc_w 626
    //   478: aload 7
    //   480: invokestatic 200	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   483: aload 9
    //   485: invokevirtual 664	com/tencent/qqperf/monitor/memory/MemoryManager$LowMemoryReport:b	()V
    //   488: goto -38 -> 450
    //   491: aload 9
    //   493: invokevirtual 664	com/tencent/qqperf/monitor/memory/MemoryManager$LowMemoryReport:b	()V
    //   496: aload 9
    //   498: lload_3
    //   499: putfield 628	com/tencent/qqperf/monitor/memory/MemoryManager$LowMemoryReport:e	J
    //   502: aload 7
    //   504: athrow
    //   505: aload 9
    //   507: invokevirtual 384	com/tencent/qqperf/monitor/memory/MemoryManager$LowMemoryReport:c	()V
    //   510: aload 8
    //   512: monitorexit
    //   513: return
    //   514: astore 7
    //   516: aload 8
    //   518: monitorexit
    //   519: goto +6 -> 525
    //   522: aload 7
    //   524: athrow
    //   525: goto -3 -> 522
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	528	0	this	MemoryManager
    //   42	332	1	i	int
    //   48	382	2	j	int
    //   18	481	3	l1	long
    //   24	4	5	l2	long
    //   84	354	7	localObject1	Object
    //   459	1	7	localObject2	Object
    //   464	39	7	localException	Exception
    //   514	9	7	localObject3	Object
    //   4	513	8	localObject4	Object
    //   13	493	9	localLowMemoryReport	MemoryManager.LowMemoryReport
    //   56	221	10	localHashMap	HashMap
    // Exception table:
    //   from	to	target	type
    //   37	77	459	finally
    //   89	106	459	finally
    //   106	117	459	finally
    //   129	146	459	finally
    //   146	170	459	finally
    //   182	199	459	finally
    //   199	210	459	finally
    //   222	239	459	finally
    //   239	445	459	finally
    //   466	483	459	finally
    //   37	77	464	java/lang/Exception
    //   89	106	464	java/lang/Exception
    //   106	117	464	java/lang/Exception
    //   129	146	464	java/lang/Exception
    //   146	170	464	java/lang/Exception
    //   182	199	464	java/lang/Exception
    //   199	210	464	java/lang/Exception
    //   222	239	464	java/lang/Exception
    //   239	445	464	java/lang/Exception
    //   9	26	514	finally
    //   445	450	514	finally
    //   450	456	514	finally
    //   483	488	514	finally
    //   491	505	514	finally
    //   505	513	514	finally
    //   516	519	514	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.monitor.memory.MemoryManager
 * JD-Core Version:    0.7.0.1
 */