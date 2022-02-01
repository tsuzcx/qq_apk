package com.tencent.qqperf;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Debug;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.automator.api.IAutomatorApi;
import com.tencent.mobileqq.monitor.MsfMonitorCallback;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.qqperf.api.IPerfApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.heldthread.LooperMonitorHelper;
import com.tencent.qqperf.repoter.StackObservable;
import com.tencent.qqperf.repoter.StackObserver;
import com.tencent.qqperf.tools.ProcessStats;
import com.tencent.qqperf.tools.ProcessStats.Stats;
import com.tencent.qqperf.tools.ThreadTraceHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MainService;
import mqq.app.MobileQQ;
import mqq.util.AbstractUnifiedMonitor;
import mqq.util.AbstractUnifiedMonitor.ThreadMonitorCallback;

public class UnifiedMonitor
  extends AbstractUnifiedMonitor
  implements Handler.Callback, MsfMonitorCallback
{
  private static int jdField_a_of_type_Int;
  private static UnifiedMonitor jdField_a_of_type_ComTencentQqperfUnifiedMonitor = null;
  public static AtomicBoolean a;
  public static String[] a;
  private Handler jdField_a_of_type_AndroidOsHandler = null;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread = null;
  private String jdField_a_of_type_JavaLangString = null;
  public volatile boolean a;
  private UnifiedMonitor.FamilyConfig[] jdField_a_of_type_ArrayOfComTencentQqperfUnifiedMonitor$FamilyConfig = { new UnifiedMonitor.FamilyConfig(0.0008F, 100, 10, 0.1F, 6, 0, 0, 0, false), new UnifiedMonitor.FamilyConfig(), new UnifiedMonitor.FamilyConfig(), new UnifiedMonitor.FamilyConfig(), new UnifiedMonitor.FamilyConfig(0.001F, 180000, 2, 1.0F, 6, 0, 0, 0, true), new UnifiedMonitor.FamilyConfig(0.001F, 180000, 2, 1.0F, 6, 0, 0, 0, true), new UnifiedMonitor.FamilyConfig(0.001F, 1000, 10, 0.001F, 0, 0, 0, 0, false), new UnifiedMonitor.FamilyConfig(0.001F, 180000, 2, 1.0F, 6, 6, 0, 0, true), new UnifiedMonitor.FamilyConfig(0.001F, 0, 10, 0.1F, 0, 0, 0, 0, false), new UnifiedMonitor.FamilyConfig(0.001F, 100, 5, 0.01F, 0, 0, 0, 0, false), new UnifiedMonitor.FamilyConfig(0.001F, 100, 10, 0.1F, 6, 0, 0, 0, false), new UnifiedMonitor.ProcessStatsConfig(0.0F, 100100005, 1, 0.01F, 0, 0, 2, 300), new UnifiedMonitor.FamilyConfig(0.01F, 100, 5, 0.01F, 0, 0, 0, 0, false), new UnifiedMonitor.FamilyConfig(0.001F, 180000, 10, 1.0F, 6, 0, 0, 0, true), new UnifiedMonitor.FamilyConfig(0.001F, 100, 5, 0.01F, 6, 0, 0, 0, false), new UnifiedMonitor.FamilyConfig(0.001F, 600000, 2, 1.0F, 6, 0, 0, 0, true), new UnifiedMonitor.FamilyConfig(0.001F, 180000, 2, 1.0F, 6, 0, 0, 0, true), new UnifiedMonitor.FamilyConfig(0.001F, 180000, 2, 1.0F, 6, 0, 0, 0, true), new UnifiedMonitor.FamilyConfig(0.001F, 180000, 2, 1.0F, 6, 0, 0, 0, true), new UnifiedMonitor.FamilyConfig(0.001F, 100, 5, 0.01F, 6, 0, 0, 0, false), new UnifiedMonitor.FamilyConfig(0.01F, 100, 10, 0.01F, 0, 0, 0, 0, false) };
  private Handler jdField_b_of_type_AndroidOsHandler = null;
  private HandlerThread jdField_b_of_type_AndroidOsHandlerThread = null;
  private String jdField_b_of_type_JavaLangString = null;
  private Handler jdField_c_of_type_AndroidOsHandler = null;
  private String jdField_c_of_type_JavaLangString = null;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = null;
    jdField_a_of_type_Int = -1;
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "FAMILY_LOOPER", "FAMILY_OBSERVER", "FAMILY_IMAGE_DRAWABLE", "FAMILY_IMAGE_VIEW", "FAMILY_SUB_TASK", "FAMILY_FILE_TASK", "FAMILY_BG_TASK", "FAMILY_MSF_MSG", "FAMILY_ACT_TIME", "FAMILY_SCENE_SMOOTH", "FAMILY_DROP_FRAME", "FAMILY_CPU_STATS", "FAMILY_NEW_FPS", "FAMILY_RECENT", "FAMILY_QZONE_LOOPER", "FAMILY_MSF_SENDER", "FAMILY_MSF_RECVER", "FAMILY_MSF_LIGHT_SENDER", "FAMILY_MSF_NETWORK", "FAMILY_TOOL_LOOPER", "FAMILY_SCENE_PERF", "FAMILY_LAST" };
  }
  
  public UnifiedMonitor()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  private static final int a(int paramInt)
  {
    if (paramInt == 1) {
      return 15;
    }
    if (paramInt == 2) {
      return 16;
    }
    return 17;
  }
  
  public static UnifiedMonitor a()
  {
    if (jdField_a_of_type_ComTencentQqperfUnifiedMonitor != null) {
      return jdField_a_of_type_ComTencentQqperfUnifiedMonitor;
    }
    try
    {
      if (jdField_a_of_type_ComTencentQqperfUnifiedMonitor == null) {
        jdField_a_of_type_ComTencentQqperfUnifiedMonitor = new UnifiedMonitor();
      }
      UnifiedMonitor localUnifiedMonitor = jdField_a_of_type_ComTencentQqperfUnifiedMonitor;
      return localUnifiedMonitor;
    }
    finally {}
  }
  
  public static String a(int paramInt)
  {
    String str = "unknown";
    if (jdField_a_of_type_ArrayOfJavaLangString.length > paramInt) {
      str = jdField_a_of_type_ArrayOfJavaLangString[paramInt];
    }
    return str;
  }
  
  public static HashMap<String, String> a()
  {
    String str = ((IPerfApi)QRoute.api(IPerfApi.class)).getTopActivityName();
    if (str != null)
    {
      HashMap localHashMap = new HashMap(8);
      localHashMap.put("act", str);
      return localHashMap;
    }
    return null;
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_ArrayOfComTencentQqperfUnifiedMonitor$FamilyConfig[paramInt].jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ArrayOfComTencentQqperfUnifiedMonitor$FamilyConfig[paramInt].jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ArrayOfComTencentQqperfUnifiedMonitor$FamilyConfig[paramInt].jdField_a_of_type_ComTencentQqperfUnifiedMonitor$StackGetterJob = null;
    this.jdField_a_of_type_ArrayOfComTencentQqperfUnifiedMonitor$FamilyConfig[paramInt].jdField_c_of_type_Boolean = false;
    if (this.jdField_a_of_type_ArrayOfComTencentQqperfUnifiedMonitor$FamilyConfig[paramInt].jdField_a_of_type_MqqUtilAbstractUnifiedMonitor$ThreadMonitorCallback != null)
    {
      this.jdField_a_of_type_ArrayOfComTencentQqperfUnifiedMonitor$FamilyConfig[paramInt].jdField_a_of_type_MqqUtilAbstractUnifiedMonitor$ThreadMonitorCallback.onThreadMonitorEnd(paramInt);
      this.jdField_a_of_type_ArrayOfComTencentQqperfUnifiedMonitor$FamilyConfig[paramInt].jdField_a_of_type_MqqUtilAbstractUnifiedMonitor$ThreadMonitorCallback = null;
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      jdField_a_of_type_Int = i;
      return;
    }
  }
  
  public static boolean a()
  {
    if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean == null) {
      jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(new File("/proc/stat").canRead());
    }
    return jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  private static final int b(int paramInt)
  {
    if (paramInt == 1) {
      return 12;
    }
    if (paramInt == 2) {
      return 13;
    }
    return 11;
  }
  
  public static boolean c()
  {
    return (QLog.isColorLevel()) || (Utils.b());
  }
  
  private void d()
  {
    StackObservable.a().addObserver(new StackObserver());
    if (4 == MobileQQ.sProcessId) {
      f();
    }
    if (1 != MobileQQ.sProcessId) {
      return;
    }
    if (whetherReportDuringThisStartup(4)) {
      LooperMonitorHelper.a();
    }
    if (whetherReportDuringThisStartup(5)) {
      LooperMonitorHelper.d();
    }
    if (whetherReportDuringThisStartup(6)) {
      LooperMonitorHelper.e();
    }
    if (whetherReportDuringThisStartup(13)) {
      LooperMonitorHelper.c();
    }
    MainService.setUnifiedMonitorInstance(a());
    e();
  }
  
  private final void e()
  {
    if ((whetherReportDuringThisStartup(11)) && (this.jdField_a_of_type_AndroidOsHandlerThread == null) && (a()))
    {
      this.jdField_a_of_type_AndroidOsHandlerThread = ThreadManager.newFreeHandlerThread("cpu-stats", 0);
      this.jdField_a_of_type_AndroidOsHandlerThread.start();
      Looper localLooper = this.jdField_a_of_type_AndroidOsHandlerThread.getLooper();
      if (localLooper != null)
      {
        this.jdField_b_of_type_AndroidOsHandler = new Handler(localLooper, this);
        this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(4);
      }
    }
  }
  
  private void f()
  {
    int i = 0;
    if (MsfCore.sCore != null) {
      if ((whetherReportDuringThisStartup(17)) || (whetherReportDuringThisStartup(15)) || (whetherReportDuringThisStartup(16)))
      {
        QLog.d("UnifiedMonitor_QAPM", 1, new Object[] { "setMsfMonitorCallback, ", Boolean.valueOf(whetherReportDuringThisStartup(17)), ", ", Boolean.valueOf(whetherReportDuringThisStartup(15)), ", ", Boolean.valueOf(whetherReportDuringThisStartup(16)) });
        MsfCore.sCore.setMsfMonitorCallback(this);
        i = 1;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        this.jdField_b_of_type_AndroidOsHandlerThread = new HandlerThread("um-msfMonitor");
        this.jdField_b_of_type_AndroidOsHandlerThread.start();
        this.jdField_c_of_type_AndroidOsHandler = new Handler(this.jdField_b_of_type_AndroidOsHandlerThread.getLooper(), this);
      }
      if (whetherReportDuringThisStartup(18)) {
        LooperMonitorHelper.b();
      }
      return;
      QLog.e("UnifiedMonitor_QAPM", 1, "MsfCore.sCore is null");
    }
  }
  
  /* Error */
  private void g()
  {
    // Byte code:
    //   0: ldc_w 315
    //   3: invokestatic 134	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   6: checkcast 315	com/tencent/mobileqq/dpc/api/IDPCApi
    //   9: getstatic 321	com/tencent/mobileqq/dpc/enumname/DPCNames:unified_monitor_params	Lcom/tencent/mobileqq/dpc/enumname/DPCNames;
    //   12: invokevirtual 324	com/tencent/mobileqq/dpc/enumname/DPCNames:name	()Ljava/lang/String;
    //   15: invokeinterface 328 2 0
    //   20: astore 6
    //   22: ldc_w 279
    //   25: iconst_1
    //   26: new 330	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 331	java/lang/StringBuilder:<init>	()V
    //   33: ldc_w 333
    //   36: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: aload 6
    //   41: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: invokevirtual 340	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokestatic 342	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   50: aload 6
    //   52: ifnull +586 -> 638
    //   55: aload 6
    //   57: ldc_w 344
    //   60: invokevirtual 348	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   63: astore 8
    //   65: aload 8
    //   67: ifnonnull +20 -> 87
    //   70: aload_0
    //   71: monitorenter
    //   72: aload_0
    //   73: iconst_1
    //   74: putfield 88	com/tencent/qqperf/UnifiedMonitor:jdField_a_of_type_Boolean	Z
    //   77: aload_0
    //   78: monitorexit
    //   79: return
    //   80: astore 6
    //   82: aload_0
    //   83: monitorexit
    //   84: aload 6
    //   86: athrow
    //   87: aload 8
    //   89: arraylength
    //   90: istore 4
    //   92: iconst_0
    //   93: istore_3
    //   94: iload_3
    //   95: iload 4
    //   97: if_icmpge +541 -> 638
    //   100: aload 8
    //   102: iload_3
    //   103: aaload
    //   104: astore 6
    //   106: aload 6
    //   108: ldc_w 350
    //   111: invokevirtual 348	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   114: astore 9
    //   116: aload 9
    //   118: ifnull +997 -> 1115
    //   121: aload 9
    //   123: arraylength
    //   124: iconst_2
    //   125: if_icmpne +990 -> 1115
    //   128: aload 9
    //   130: iconst_0
    //   131: aaload
    //   132: invokestatic 356	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   135: ifne +980 -> 1115
    //   138: aload 9
    //   140: iconst_1
    //   141: aaload
    //   142: invokestatic 356	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   145: ifne +970 -> 1115
    //   148: aload 9
    //   150: iconst_0
    //   151: aaload
    //   152: bipush 95
    //   154: invokevirtual 359	java/lang/String:lastIndexOf	(I)I
    //   157: istore 5
    //   159: iload 5
    //   161: iconst_m1
    //   162: if_icmpeq +960 -> 1122
    //   165: aload 9
    //   167: iconst_0
    //   168: aaload
    //   169: iconst_0
    //   170: iload 5
    //   172: iconst_1
    //   173: iadd
    //   174: invokevirtual 363	java/lang/String:substring	(II)Ljava/lang/String;
    //   177: astore 6
    //   179: iload 5
    //   181: iconst_m1
    //   182: if_icmpeq +946 -> 1128
    //   185: iload 5
    //   187: aload 9
    //   189: iconst_0
    //   190: aaload
    //   191: invokevirtual 367	java/lang/String:length	()I
    //   194: iconst_1
    //   195: isub
    //   196: if_icmpge +932 -> 1128
    //   199: aload 9
    //   201: iconst_0
    //   202: aaload
    //   203: iload 5
    //   205: iconst_1
    //   206: iadd
    //   207: invokevirtual 369	java/lang/String:substring	(I)Ljava/lang/String;
    //   210: astore 7
    //   212: iconst_m1
    //   213: istore_2
    //   214: aload 7
    //   216: invokestatic 374	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   219: invokevirtual 377	java/lang/Integer:intValue	()I
    //   222: istore_1
    //   223: iload_1
    //   224: istore_2
    //   225: invokestatic 195	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   228: ifeq +860 -> 1088
    //   231: ldc_w 279
    //   234: iconst_2
    //   235: new 330	java/lang/StringBuilder
    //   238: dup
    //   239: invokespecial 331	java/lang/StringBuilder:<init>	()V
    //   242: ldc_w 379
    //   245: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: iload_2
    //   249: invokevirtual 382	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   252: ldc_w 384
    //   255: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: aload 6
    //   260: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: ldc_w 386
    //   266: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: aload 9
    //   271: iconst_0
    //   272: aaload
    //   273: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: ldc_w 388
    //   279: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: aload 9
    //   284: iconst_1
    //   285: aaload
    //   286: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: invokevirtual 340	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   292: invokestatic 342	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   295: goto +793 -> 1088
    //   298: aload 6
    //   300: ifnull +815 -> 1115
    //   303: iload 5
    //   305: iconst_m1
    //   306: if_icmpeq +809 -> 1115
    //   309: iload_1
    //   310: iconst_m1
    //   311: if_icmpeq +804 -> 1115
    //   314: aload 7
    //   316: ifnull +799 -> 1115
    //   319: iload_1
    //   320: bipush 21
    //   322: if_icmpge +793 -> 1115
    //   325: ldc_w 390
    //   328: aload 6
    //   330: invokevirtual 394	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   333: ifeq +25 -> 358
    //   336: aload_0
    //   337: getfield 108	com/tencent/qqperf/UnifiedMonitor:jdField_a_of_type_ArrayOfComTencentQqperfUnifiedMonitor$FamilyConfig	[Lcom/tencent/qqperf/UnifiedMonitor$FamilyConfig;
    //   340: iload_1
    //   341: aaload
    //   342: aload 9
    //   344: iconst_1
    //   345: aaload
    //   346: invokestatic 399	java/lang/Float:valueOf	(Ljava/lang/String;)Ljava/lang/Float;
    //   349: invokevirtual 403	java/lang/Float:floatValue	()F
    //   352: putfield 406	com/tencent/qqperf/UnifiedMonitor$FamilyConfig:jdField_a_of_type_Float	F
    //   355: goto +760 -> 1115
    //   358: ldc_w 408
    //   361: aload 6
    //   363: invokevirtual 394	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   366: ifeq +85 -> 451
    //   369: aload_0
    //   370: getfield 108	com/tencent/qqperf/UnifiedMonitor:jdField_a_of_type_ArrayOfComTencentQqperfUnifiedMonitor$FamilyConfig	[Lcom/tencent/qqperf/UnifiedMonitor$FamilyConfig;
    //   373: iload_1
    //   374: aaload
    //   375: aload 9
    //   377: iconst_1
    //   378: aaload
    //   379: invokestatic 374	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   382: invokevirtual 377	java/lang/Integer:intValue	()I
    //   385: putfield 410	com/tencent/qqperf/UnifiedMonitor$FamilyConfig:jdField_b_of_type_Int	I
    //   388: goto +727 -> 1115
    //   391: astore 6
    //   393: invokestatic 195	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   396: ifeq +719 -> 1115
    //   399: ldc_w 279
    //   402: iconst_2
    //   403: ldc_w 412
    //   406: aload 6
    //   408: invokestatic 415	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   411: goto +704 -> 1115
    //   414: astore 6
    //   416: invokestatic 195	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   419: ifeq +15 -> 434
    //   422: ldc_w 279
    //   425: iconst_2
    //   426: ldc_w 412
    //   429: aload 6
    //   431: invokestatic 417	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   434: aload_0
    //   435: monitorenter
    //   436: aload_0
    //   437: iconst_1
    //   438: putfield 88	com/tencent/qqperf/UnifiedMonitor:jdField_a_of_type_Boolean	Z
    //   441: aload_0
    //   442: monitorexit
    //   443: return
    //   444: astore 6
    //   446: aload_0
    //   447: monitorexit
    //   448: aload 6
    //   450: athrow
    //   451: ldc_w 419
    //   454: aload 6
    //   456: invokevirtual 394	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   459: ifeq +39 -> 498
    //   462: aload_0
    //   463: getfield 108	com/tencent/qqperf/UnifiedMonitor:jdField_a_of_type_ArrayOfComTencentQqperfUnifiedMonitor$FamilyConfig	[Lcom/tencent/qqperf/UnifiedMonitor$FamilyConfig;
    //   466: iload_1
    //   467: aaload
    //   468: aload 9
    //   470: iconst_1
    //   471: aaload
    //   472: invokestatic 374	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   475: invokevirtual 377	java/lang/Integer:intValue	()I
    //   478: putfield 420	com/tencent/qqperf/UnifiedMonitor$FamilyConfig:jdField_a_of_type_Int	I
    //   481: goto +634 -> 1115
    //   484: astore 6
    //   486: aload_0
    //   487: monitorenter
    //   488: aload_0
    //   489: iconst_1
    //   490: putfield 88	com/tencent/qqperf/UnifiedMonitor:jdField_a_of_type_Boolean	Z
    //   493: aload_0
    //   494: monitorexit
    //   495: aload 6
    //   497: athrow
    //   498: ldc_w 422
    //   501: aload 6
    //   503: invokevirtual 394	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   506: ifeq +25 -> 531
    //   509: aload_0
    //   510: getfield 108	com/tencent/qqperf/UnifiedMonitor:jdField_a_of_type_ArrayOfComTencentQqperfUnifiedMonitor$FamilyConfig	[Lcom/tencent/qqperf/UnifiedMonitor$FamilyConfig;
    //   513: iload_1
    //   514: aaload
    //   515: aload 9
    //   517: iconst_1
    //   518: aaload
    //   519: invokestatic 399	java/lang/Float:valueOf	(Ljava/lang/String;)Ljava/lang/Float;
    //   522: invokevirtual 403	java/lang/Float:floatValue	()F
    //   525: putfield 424	com/tencent/qqperf/UnifiedMonitor$FamilyConfig:jdField_b_of_type_Float	F
    //   528: goto +587 -> 1115
    //   531: ldc_w 426
    //   534: aload 6
    //   536: invokevirtual 394	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   539: ifeq +33 -> 572
    //   542: getstatic 431	android/os/Build$VERSION:SDK_INT	I
    //   545: bipush 17
    //   547: if_icmpeq +568 -> 1115
    //   550: aload_0
    //   551: getfield 108	com/tencent/qqperf/UnifiedMonitor:jdField_a_of_type_ArrayOfComTencentQqperfUnifiedMonitor$FamilyConfig	[Lcom/tencent/qqperf/UnifiedMonitor$FamilyConfig;
    //   554: iload_1
    //   555: aaload
    //   556: aload 9
    //   558: iconst_1
    //   559: aaload
    //   560: invokestatic 374	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   563: invokevirtual 377	java/lang/Integer:intValue	()I
    //   566: putfield 433	com/tencent/qqperf/UnifiedMonitor$FamilyConfig:jdField_c_of_type_Int	I
    //   569: goto +546 -> 1115
    //   572: ldc_w 435
    //   575: aload 6
    //   577: invokevirtual 394	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   580: ifeq +25 -> 605
    //   583: aload_0
    //   584: getfield 108	com/tencent/qqperf/UnifiedMonitor:jdField_a_of_type_ArrayOfComTencentQqperfUnifiedMonitor$FamilyConfig	[Lcom/tencent/qqperf/UnifiedMonitor$FamilyConfig;
    //   587: iload_1
    //   588: aaload
    //   589: aload 9
    //   591: iconst_1
    //   592: aaload
    //   593: invokestatic 374	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   596: invokevirtual 377	java/lang/Integer:intValue	()I
    //   599: putfield 437	com/tencent/qqperf/UnifiedMonitor$FamilyConfig:jdField_d_of_type_Int	I
    //   602: goto +513 -> 1115
    //   605: ldc_w 439
    //   608: aload 6
    //   610: invokevirtual 394	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   613: ifeq +502 -> 1115
    //   616: aload_0
    //   617: getfield 108	com/tencent/qqperf/UnifiedMonitor:jdField_a_of_type_ArrayOfComTencentQqperfUnifiedMonitor$FamilyConfig	[Lcom/tencent/qqperf/UnifiedMonitor$FamilyConfig;
    //   620: iload_1
    //   621: aaload
    //   622: aload 9
    //   624: iconst_1
    //   625: aaload
    //   626: invokestatic 442	java/lang/Boolean:valueOf	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   629: invokevirtual 445	java/lang/Boolean:booleanValue	()Z
    //   632: putfield 447	com/tencent/qqperf/UnifiedMonitor$FamilyConfig:jdField_d_of_type_Boolean	Z
    //   635: goto +480 -> 1115
    //   638: iconst_0
    //   639: istore_1
    //   640: iload_1
    //   641: aload_0
    //   642: getfield 108	com/tencent/qqperf/UnifiedMonitor:jdField_a_of_type_ArrayOfComTencentQqperfUnifiedMonitor$FamilyConfig	[Lcom/tencent/qqperf/UnifiedMonitor$FamilyConfig;
    //   645: arraylength
    //   646: if_icmpge +20 -> 666
    //   649: aload_0
    //   650: getfield 108	com/tencent/qqperf/UnifiedMonitor:jdField_a_of_type_ArrayOfComTencentQqperfUnifiedMonitor$FamilyConfig	[Lcom/tencent/qqperf/UnifiedMonitor$FamilyConfig;
    //   653: iload_1
    //   654: aaload
    //   655: iload_1
    //   656: invokevirtual 448	com/tencent/qqperf/UnifiedMonitor$FamilyConfig:a	(I)V
    //   659: iload_1
    //   660: iconst_1
    //   661: iadd
    //   662: istore_1
    //   663: goto -23 -> 640
    //   666: aload_0
    //   667: getfield 108	com/tencent/qqperf/UnifiedMonitor:jdField_a_of_type_ArrayOfComTencentQqperfUnifiedMonitor$FamilyConfig	[Lcom/tencent/qqperf/UnifiedMonitor$FamilyConfig;
    //   670: bipush 10
    //   672: aaload
    //   673: iconst_0
    //   674: putfield 152	com/tencent/qqperf/UnifiedMonitor$FamilyConfig:jdField_a_of_type_Boolean	Z
    //   677: invokestatic 195	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   680: ifeq +53 -> 733
    //   683: aload_0
    //   684: getfield 108	com/tencent/qqperf/UnifiedMonitor:jdField_a_of_type_ArrayOfComTencentQqperfUnifiedMonitor$FamilyConfig	[Lcom/tencent/qqperf/UnifiedMonitor$FamilyConfig;
    //   687: iconst_0
    //   688: aaload
    //   689: iconst_1
    //   690: putfield 152	com/tencent/qqperf/UnifiedMonitor$FamilyConfig:jdField_a_of_type_Boolean	Z
    //   693: aload_0
    //   694: getfield 108	com/tencent/qqperf/UnifiedMonitor:jdField_a_of_type_ArrayOfComTencentQqperfUnifiedMonitor$FamilyConfig	[Lcom/tencent/qqperf/UnifiedMonitor$FamilyConfig;
    //   697: iconst_0
    //   698: aaload
    //   699: ldc_w 449
    //   702: putfield 410	com/tencent/qqperf/UnifiedMonitor$FamilyConfig:jdField_b_of_type_Int	I
    //   705: aload_0
    //   706: getfield 108	com/tencent/qqperf/UnifiedMonitor:jdField_a_of_type_ArrayOfComTencentQqperfUnifiedMonitor$FamilyConfig	[Lcom/tencent/qqperf/UnifiedMonitor$FamilyConfig;
    //   709: iconst_0
    //   710: aaload
    //   711: fconst_1
    //   712: putfield 424	com/tencent/qqperf/UnifiedMonitor$FamilyConfig:jdField_b_of_type_Float	F
    //   715: invokestatic 195	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   718: ifeq +15 -> 733
    //   721: aload_0
    //   722: getfield 108	com/tencent/qqperf/UnifiedMonitor:jdField_a_of_type_ArrayOfComTencentQqperfUnifiedMonitor$FamilyConfig	[Lcom/tencent/qqperf/UnifiedMonitor$FamilyConfig;
    //   725: iconst_0
    //   726: aaload
    //   727: sipush 200
    //   730: putfield 420	com/tencent/qqperf/UnifiedMonitor$FamilyConfig:jdField_a_of_type_Int	I
    //   733: getstatic 217	mqq/app/MobileQQ:sProcessId	I
    //   736: iconst_4
    //   737: if_icmpne +3 -> 740
    //   740: getstatic 217	mqq/app/MobileQQ:sProcessId	I
    //   743: iconst_1
    //   744: if_icmpne +14 -> 758
    //   747: aload_0
    //   748: getfield 108	com/tencent/qqperf/UnifiedMonitor:jdField_a_of_type_ArrayOfComTencentQqperfUnifiedMonitor$FamilyConfig	[Lcom/tencent/qqperf/UnifiedMonitor$FamilyConfig;
    //   751: bipush 11
    //   753: aaload
    //   754: iconst_0
    //   755: putfield 152	com/tencent/qqperf/UnifiedMonitor$FamilyConfig:jdField_a_of_type_Boolean	Z
    //   758: invokestatic 199	com/tencent/mobileqq/util/Utils:b	()Z
    //   761: ifeq +64 -> 825
    //   764: getstatic 217	mqq/app/MobileQQ:sProcessId	I
    //   767: iconst_1
    //   768: if_icmpne +226 -> 994
    //   771: aload_0
    //   772: getfield 108	com/tencent/qqperf/UnifiedMonitor:jdField_a_of_type_ArrayOfComTencentQqperfUnifiedMonitor$FamilyConfig	[Lcom/tencent/qqperf/UnifiedMonitor$FamilyConfig;
    //   775: iconst_4
    //   776: aaload
    //   777: getfield 152	com/tencent/qqperf/UnifiedMonitor$FamilyConfig:jdField_a_of_type_Boolean	Z
    //   780: ifeq +214 -> 994
    //   783: new 140	java/util/HashMap
    //   786: dup
    //   787: iconst_2
    //   788: invokespecial 143	java/util/HashMap:<init>	(I)V
    //   791: astore 6
    //   793: aload 6
    //   795: ldc_w 451
    //   798: iconst_1
    //   799: invokestatic 453	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   802: invokevirtual 149	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   805: pop
    //   806: invokestatic 457	mqq/app/MobileQQ:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   809: invokestatic 463	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   812: aconst_null
    //   813: ldc_w 465
    //   816: iconst_1
    //   817: lconst_0
    //   818: lconst_0
    //   819: aload 6
    //   821: aconst_null
    //   822: invokevirtual 469	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   825: ldc_w 471
    //   828: iconst_1
    //   829: new 330	java/lang/StringBuilder
    //   832: dup
    //   833: invokespecial 331	java/lang/StringBuilder:<init>	()V
    //   836: ldc_w 473
    //   839: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   842: invokestatic 199	com/tencent/mobileqq/util/Utils:b	()Z
    //   845: invokevirtual 476	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   848: ldc_w 478
    //   851: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   854: invokestatic 195	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   857: invokevirtual 476	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   860: invokevirtual 340	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   863: invokestatic 342	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   866: iconst_0
    //   867: istore_1
    //   868: aload_0
    //   869: getfield 108	com/tencent/qqperf/UnifiedMonitor:jdField_a_of_type_ArrayOfComTencentQqperfUnifiedMonitor$FamilyConfig	[Lcom/tencent/qqperf/UnifiedMonitor$FamilyConfig;
    //   872: arraylength
    //   873: istore_2
    //   874: iload_1
    //   875: iload_2
    //   876: if_icmpge +183 -> 1059
    //   879: aload_0
    //   880: getfield 108	com/tencent/qqperf/UnifiedMonitor:jdField_a_of_type_ArrayOfComTencentQqperfUnifiedMonitor$FamilyConfig	[Lcom/tencent/qqperf/UnifiedMonitor$FamilyConfig;
    //   883: iload_1
    //   884: aaload
    //   885: astore 6
    //   887: ldc_w 471
    //   890: iconst_1
    //   891: new 330	java/lang/StringBuilder
    //   894: dup
    //   895: invokespecial 331	java/lang/StringBuilder:<init>	()V
    //   898: ldc_w 480
    //   901: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   904: iload_1
    //   905: invokestatic 482	com/tencent/qqperf/UnifiedMonitor:a	(I)Ljava/lang/String;
    //   908: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   911: ldc_w 484
    //   914: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   917: aload 6
    //   919: getfield 152	com/tencent/qqperf/UnifiedMonitor$FamilyConfig:jdField_a_of_type_Boolean	Z
    //   922: invokevirtual 476	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   925: ldc_w 486
    //   928: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   931: aload 6
    //   933: getfield 424	com/tencent/qqperf/UnifiedMonitor$FamilyConfig:jdField_b_of_type_Float	F
    //   936: invokevirtual 489	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   939: ldc_w 491
    //   942: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   945: aload 6
    //   947: getfield 406	com/tencent/qqperf/UnifiedMonitor$FamilyConfig:jdField_a_of_type_Float	F
    //   950: invokevirtual 489	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   953: ldc_w 493
    //   956: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   959: aload 6
    //   961: getfield 410	com/tencent/qqperf/UnifiedMonitor$FamilyConfig:jdField_b_of_type_Int	I
    //   964: invokevirtual 382	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   967: ldc_w 495
    //   970: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   973: aload 6
    //   975: getfield 420	com/tencent/qqperf/UnifiedMonitor$FamilyConfig:jdField_a_of_type_Int	I
    //   978: invokevirtual 382	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   981: invokevirtual 340	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   984: invokestatic 342	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   987: iload_1
    //   988: iconst_1
    //   989: iadd
    //   990: istore_1
    //   991: goto -117 -> 874
    //   994: getstatic 217	mqq/app/MobileQQ:sProcessId	I
    //   997: iconst_4
    //   998: if_icmpne -173 -> 825
    //   1001: aload_0
    //   1002: getfield 108	com/tencent/qqperf/UnifiedMonitor:jdField_a_of_type_ArrayOfComTencentQqperfUnifiedMonitor$FamilyConfig	[Lcom/tencent/qqperf/UnifiedMonitor$FamilyConfig;
    //   1005: bipush 15
    //   1007: aaload
    //   1008: getfield 152	com/tencent/qqperf/UnifiedMonitor$FamilyConfig:jdField_a_of_type_Boolean	Z
    //   1011: ifeq -186 -> 825
    //   1014: new 140	java/util/HashMap
    //   1017: dup
    //   1018: iconst_2
    //   1019: invokespecial 143	java/util/HashMap:<init>	(I)V
    //   1022: astore 6
    //   1024: aload 6
    //   1026: ldc_w 451
    //   1029: iconst_2
    //   1030: invokestatic 453	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1033: invokevirtual 149	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1036: pop
    //   1037: invokestatic 457	mqq/app/MobileQQ:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1040: invokestatic 463	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   1043: aconst_null
    //   1044: ldc_w 465
    //   1047: iconst_1
    //   1048: lconst_0
    //   1049: lconst_0
    //   1050: aload 6
    //   1052: aconst_null
    //   1053: invokevirtual 469	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   1056: goto -231 -> 825
    //   1059: aload_0
    //   1060: monitorenter
    //   1061: aload_0
    //   1062: iconst_1
    //   1063: putfield 88	com/tencent/qqperf/UnifiedMonitor:jdField_a_of_type_Boolean	Z
    //   1066: aload_0
    //   1067: monitorexit
    //   1068: return
    //   1069: astore 6
    //   1071: aload_0
    //   1072: monitorexit
    //   1073: aload 6
    //   1075: athrow
    //   1076: astore 6
    //   1078: aload_0
    //   1079: monitorexit
    //   1080: aload 6
    //   1082: athrow
    //   1083: astore 10
    //   1085: goto -860 -> 225
    //   1088: iload_2
    //   1089: istore_1
    //   1090: iload_2
    //   1091: sipush 1000
    //   1094: if_icmplt -796 -> 298
    //   1097: iload_2
    //   1098: sipush 1000
    //   1101: isub
    //   1102: istore_2
    //   1103: iload_2
    //   1104: istore_1
    //   1105: iload_2
    //   1106: iconst_m1
    //   1107: if_icmpge -809 -> 298
    //   1110: iconst_m1
    //   1111: istore_1
    //   1112: goto -814 -> 298
    //   1115: iload_3
    //   1116: iconst_1
    //   1117: iadd
    //   1118: istore_3
    //   1119: goto -1025 -> 94
    //   1122: aconst_null
    //   1123: astore 6
    //   1125: goto -946 -> 179
    //   1128: aconst_null
    //   1129: astore 7
    //   1131: goto -919 -> 212
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1134	0	this	UnifiedMonitor
    //   222	890	1	i	int
    //   213	895	2	j	int
    //   93	1026	3	k	int
    //   90	8	4	m	int
    //   157	150	5	n	int
    //   20	36	6	str1	String
    //   80	5	6	localObject1	Object
    //   104	258	6	str2	String
    //   391	16	6	localThrowable1	Throwable
    //   414	16	6	localThrowable2	Throwable
    //   444	11	6	localObject2	Object
    //   484	125	6	localObject3	Object
    //   791	260	6	localObject4	Object
    //   1069	5	6	localObject5	Object
    //   1076	5	6	localObject6	Object
    //   1123	1	6	localObject7	Object
    //   210	920	7	str3	String
    //   63	38	8	arrayOfString1	String[]
    //   114	509	9	arrayOfString2	String[]
    //   1083	1	10	localNumberFormatException	java.lang.NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   72	79	80	finally
    //   82	84	80	finally
    //   106	116	391	java/lang/Throwable
    //   121	159	391	java/lang/Throwable
    //   165	179	391	java/lang/Throwable
    //   185	212	391	java/lang/Throwable
    //   214	223	391	java/lang/Throwable
    //   225	295	391	java/lang/Throwable
    //   325	355	391	java/lang/Throwable
    //   358	388	391	java/lang/Throwable
    //   451	481	391	java/lang/Throwable
    //   498	528	391	java/lang/Throwable
    //   531	569	391	java/lang/Throwable
    //   572	602	391	java/lang/Throwable
    //   605	635	391	java/lang/Throwable
    //   0	50	414	java/lang/Throwable
    //   55	65	414	java/lang/Throwable
    //   87	92	414	java/lang/Throwable
    //   393	411	414	java/lang/Throwable
    //   640	659	414	java/lang/Throwable
    //   666	733	414	java/lang/Throwable
    //   733	740	414	java/lang/Throwable
    //   740	758	414	java/lang/Throwable
    //   758	825	414	java/lang/Throwable
    //   825	866	414	java/lang/Throwable
    //   868	874	414	java/lang/Throwable
    //   879	987	414	java/lang/Throwable
    //   994	1056	414	java/lang/Throwable
    //   436	443	444	finally
    //   446	448	444	finally
    //   0	50	484	finally
    //   55	65	484	finally
    //   87	92	484	finally
    //   106	116	484	finally
    //   121	159	484	finally
    //   165	179	484	finally
    //   185	212	484	finally
    //   214	223	484	finally
    //   225	295	484	finally
    //   325	355	484	finally
    //   358	388	484	finally
    //   393	411	484	finally
    //   416	434	484	finally
    //   451	481	484	finally
    //   498	528	484	finally
    //   531	569	484	finally
    //   572	602	484	finally
    //   605	635	484	finally
    //   640	659	484	finally
    //   666	733	484	finally
    //   733	740	484	finally
    //   740	758	484	finally
    //   758	825	484	finally
    //   825	866	484	finally
    //   868	874	484	finally
    //   879	987	484	finally
    //   994	1056	484	finally
    //   1061	1068	1069	finally
    //   1071	1073	1069	finally
    //   488	495	1076	finally
    //   1078	1080	1076	finally
    //   214	223	1083	java/lang/NumberFormatException
  }
  
  public void a() {}
  
  public void a(int paramInt, Thread paramThread)
  {
    if (!b())
    {
      if ((this.jdField_a_of_type_Boolean) && (whetherReportDuringThisStartup(paramInt))) {}
    }
    else
    {
      QLog.e("UnifiedMonitor_QAPM", 1, "skip issue caused by debugger");
      return;
    }
    SharedPreferences localSharedPreferences;
    long l1;
    int i;
    if ((1 != MobileQQ.sProcessId) || (4 == MobileQQ.sProcessId))
    {
      localSharedPreferences = MobileQQ.getContext().getSharedPreferences("sp_thread_hold_msf", 0);
      l1 = localSharedPreferences.getLong("key_time_msf", -1L);
      if (Math.abs(System.currentTimeMillis() - l1) < 86400000L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("UnifiedMonitor_QAPM", 2, new Object[] { "report msf interval is small, ", Long.valueOf(l1) });
        }
        i = 0;
      }
    }
    for (;;)
    {
      String str;
      StringBuilder localStringBuilder;
      long l2;
      if (i != 0)
      {
        str = ThreadTraceHelper.a(String.valueOf(paramInt));
        if (this.jdField_a_of_type_JavaLangString == null)
        {
          this.jdField_a_of_type_JavaLangString = "dbg";
          this.jdField_a_of_type_JavaLangString = "pub";
        }
        localStringBuilder = new StringBuilder(50);
        localStringBuilder.append("AdditionInfo:0|");
        l2 = 0L;
        try
        {
          localObject = MobileQQ.getContext().getPackageManager();
          if (this.jdField_b_of_type_JavaLangString == null)
          {
            PackageInfo localPackageInfo = ((PackageManager)localObject).getPackageInfo("com.tencent.mobileqq", 128);
            this.jdField_b_of_type_JavaLangString = (localPackageInfo.versionName + "." + localPackageInfo.versionCode);
          }
          if (this.jdField_c_of_type_JavaLangString == null) {
            this.jdField_c_of_type_JavaLangString = ((PackageManager)localObject).getApplicationInfo("com.tencent.mobileqq", 128).metaData.get("com.tencent.qapm.uuid").toString();
          }
          localObject = null;
          if (4 != MobileQQ.sProcessId) {
            break label798;
          }
          if (MsfCore.sCore != null) {
            localObject = MsfCore.sCore.getMainAccount();
          }
          l1 = l2;
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            l1 = Long.parseLong((String)localObject);
          }
        }
        catch (Exception localException)
        {
          int j;
          for (;;)
          {
            Object localObject;
            QLog.e("UnifiedMonitor_QAPM", 1, "", localException);
            l1 = l2;
            continue;
            i = 0;
            continue;
            i = 0;
            continue;
            bool1 = false;
          }
          localStatisticCollector = StatisticCollector.getInstance(MobileQQ.getContext());
          if (j != 1) {
            break label886;
          }
        }
        localStringBuilder.append(l1).append("|").append(this.jdField_b_of_type_JavaLangString).append("|").append(this.jdField_c_of_type_JavaLangString);
        localStringBuilder.append("|").append(this.jdField_a_of_type_JavaLangString).append("|").append(System.currentTimeMillis());
        localStringBuilder.append("|").append(paramInt).append("|").append(Build.MODEL).append("|").append(Build.VERSION.RELEASE);
        localStringBuilder.append("|").append("monitorThread=").append(paramThread.getName()).append(",tid=").append(paramThread.getId()).append(",state=").append(paramThread.getState());
        localStringBuilder.append(ThreadTraceHelper.a());
        localStringBuilder.append(ThreadTraceHelper.b());
        l1 = SystemClock.uptimeMillis();
        j = ThreadTraceHelper.a(MobileQQ.getContext(), str, localStringBuilder.toString());
        l1 = SystemClock.uptimeMillis() - l1;
        if (j == 1) {
          break label1028;
        }
      }
      label1028:
      for (boolean bool1 = ThreadTraceHelper.a(str, localStringBuilder.toString());; bool1 = true)
      {
        a(str);
        paramThread = new HashMap(2);
        paramThread.put("key_code", String.valueOf(j));
        if (QLog.isColorLevel())
        {
          i = 1;
          paramThread.put("is_color_level", String.valueOf(i));
          if (!BaseApplication.monitorBan) {
            break label839;
          }
          i = 1;
          paramThread.put("monitor_ban", String.valueOf(i));
          paramThread.put("event_family", String.valueOf(paramInt));
          if (4 != MobileQQ.sProcessId) {
            break label850;
          }
          if (MsfCore.sCore != null)
          {
            localObject = MsfCore.sCore;
            if (j != 1) {
              break label844;
            }
            bool1 = true;
            ((MsfCore)localObject).reportRDM("event_held_thread_msf", bool1, l1, 0L, paramThread, false, false);
          }
          bool1 = false;
          if (bool1)
          {
            paramThread = new HashMap(2);
            paramThread.put("filePath", str);
            this.jdField_a_of_type_AndroidOsHandler.sendMessage(Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 10, 0, 0, paramThread));
            QLog.e("UnifiedMonitor_QAPM", 1, "report stack file for " + paramInt);
          }
          if ((0 != 0) && (1 == MobileQQ.sProcessId)) {
            throw new NullPointerException();
          }
          if (4 == MobileQQ.sProcessId) {
            localSharedPreferences.edit().putLong("key_time_msf", System.currentTimeMillis()).commit();
          }
        }
        for (;;)
        {
          paramThread = this.jdField_a_of_type_ArrayOfComTencentQqperfUnifiedMonitor$FamilyConfig[paramInt];
          paramThread.g += 1;
          return;
          label798:
          localObject = MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
          break;
          label839:
          label844:
          label850:
          StatisticCollector localStatisticCollector;
          label886:
          for (boolean bool2 = true;; bool2 = false)
          {
            localStatisticCollector.collectPerformance(null, "event_held_thread", bool2, l1, 0L, paramThread, null);
            break;
          }
          paramThread = new HashMap(2);
          paramThread.put("key_code", String.valueOf(7));
          if (QLog.isColorLevel())
          {
            i = 1;
            label922:
            paramThread.put("is_color_level", String.valueOf(i));
            if (!BaseApplication.monitorBan) {
              break label1002;
            }
          }
          label1002:
          for (i = 1;; i = 0)
          {
            paramThread.put("monitor_ban", String.valueOf(i));
            paramThread.put("event_family", String.valueOf(paramInt));
            if (4 != MobileQQ.sProcessId) {
              break label1007;
            }
            if (MsfCore.sCore == null) {
              break;
            }
            MsfCore.sCore.reportRDM("event_held_thread_msf", false, 0L, 0L, paramThread, false, false);
            break;
            i = 0;
            break label922;
          }
          label1007:
          StatisticCollector.getInstance(MobileQQ.getContext()).collectPerformance(null, "event_held_thread", false, 0L, 0L, paramThread, null);
        }
      }
      i = 1;
      continue;
      localSharedPreferences = null;
      i = 1;
    }
  }
  
  /* Error */
  void a(String paramString)
  {
    // Byte code:
    //   0: new 176	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 181	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore 4
    //   10: aload 4
    //   12: invokevirtual 720	java/io/File:exists	()Z
    //   15: ifeq +100 -> 115
    //   18: ldc_w 279
    //   21: iconst_1
    //   22: new 330	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 331	java/lang/StringBuilder:<init>	()V
    //   29: ldc_w 722
    //   32: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_1
    //   36: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 340	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 308	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   45: aconst_null
    //   46: astore_2
    //   47: aconst_null
    //   48: astore_3
    //   49: new 724	java/io/BufferedReader
    //   52: dup
    //   53: new 726	java/io/InputStreamReader
    //   56: dup
    //   57: new 728	java/io/FileInputStream
    //   60: dup
    //   61: aload 4
    //   63: invokespecial 731	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   66: invokespecial 734	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   69: sipush 8096
    //   72: invokespecial 737	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   75: astore_1
    //   76: aload_1
    //   77: astore_2
    //   78: aload_1
    //   79: invokevirtual 740	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   82: astore_3
    //   83: aload_3
    //   84: ifnull +32 -> 116
    //   87: aload_1
    //   88: astore_2
    //   89: ldc_w 279
    //   92: iconst_1
    //   93: aload_3
    //   94: invokestatic 308	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   97: goto -21 -> 76
    //   100: astore_3
    //   101: aload_1
    //   102: astore_2
    //   103: aload_3
    //   104: invokevirtual 743	java/io/FileNotFoundException:printStackTrace	()V
    //   107: aload_1
    //   108: ifnull +7 -> 115
    //   111: aload_1
    //   112: invokevirtual 746	java/io/BufferedReader:close	()V
    //   115: return
    //   116: aload_1
    //   117: ifnull -2 -> 115
    //   120: aload_1
    //   121: invokevirtual 746	java/io/BufferedReader:close	()V
    //   124: return
    //   125: astore_1
    //   126: aload_1
    //   127: invokevirtual 747	java/lang/Exception:printStackTrace	()V
    //   130: return
    //   131: astore_1
    //   132: aload_1
    //   133: invokevirtual 747	java/lang/Exception:printStackTrace	()V
    //   136: return
    //   137: astore_2
    //   138: aload_3
    //   139: astore_1
    //   140: aload_2
    //   141: astore_3
    //   142: aload_1
    //   143: astore_2
    //   144: aload_3
    //   145: invokevirtual 748	java/io/IOException:printStackTrace	()V
    //   148: aload_1
    //   149: ifnull -34 -> 115
    //   152: aload_1
    //   153: invokevirtual 746	java/io/BufferedReader:close	()V
    //   156: return
    //   157: astore_1
    //   158: aload_1
    //   159: invokevirtual 747	java/lang/Exception:printStackTrace	()V
    //   162: return
    //   163: astore_1
    //   164: aload_2
    //   165: ifnull +7 -> 172
    //   168: aload_2
    //   169: invokevirtual 746	java/io/BufferedReader:close	()V
    //   172: aload_1
    //   173: athrow
    //   174: astore_2
    //   175: aload_2
    //   176: invokevirtual 747	java/lang/Exception:printStackTrace	()V
    //   179: goto -7 -> 172
    //   182: astore_1
    //   183: goto -19 -> 164
    //   186: astore_3
    //   187: goto -45 -> 142
    //   190: astore_3
    //   191: aconst_null
    //   192: astore_1
    //   193: goto -92 -> 101
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	196	0	this	UnifiedMonitor
    //   0	196	1	paramString	String
    //   46	57	2	str1	String
    //   137	4	2	localIOException1	java.io.IOException
    //   143	26	2	str2	String
    //   174	2	2	localException	Exception
    //   48	46	3	str3	String
    //   100	39	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   141	4	3	localIOException2	java.io.IOException
    //   186	1	3	localIOException3	java.io.IOException
    //   190	1	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   8	54	4	localFile	File
    // Exception table:
    //   from	to	target	type
    //   78	83	100	java/io/FileNotFoundException
    //   89	97	100	java/io/FileNotFoundException
    //   120	124	125	java/lang/Exception
    //   111	115	131	java/lang/Exception
    //   49	76	137	java/io/IOException
    //   152	156	157	java/lang/Exception
    //   49	76	163	finally
    //   144	148	163	finally
    //   168	172	174	java/lang/Exception
    //   78	83	182	finally
    //   89	97	182	finally
    //   103	107	182	finally
    //   78	83	186	java/io/IOException
    //   89	97	186	java/io/IOException
    //   49	76	190	java/io/FileNotFoundException
  }
  
  public void addEvent(int paramInt1, String paramString, int paramInt2, int paramInt3, Map<String, String> paramMap)
  {
    if ((!this.jdField_a_of_type_Boolean) || (!whetherReportDuringThisStartup(paramInt1))) {}
    String str;
    do
    {
      return;
      str = this.jdField_a_of_type_ArrayOfComTencentQqperfUnifiedMonitor$FamilyConfig[paramInt1].jdField_a_of_type_JavaLangString;
    } while ((this.jdField_a_of_type_ArrayOfComTencentQqperfUnifiedMonitor$FamilyConfig[paramInt1].jdField_c_of_type_Boolean) && (TextUtils.isEmpty(str)));
    Object localObject = paramMap;
    if (paramMap == null) {
      localObject = new HashMap(17);
    }
    ((Map)localObject).put("family", String.valueOf(paramInt1));
    if (paramString != null)
    {
      ((Map)localObject).put("event", paramString);
      ((Map)localObject).put("revision", AppSetting.g());
      if (this.jdField_a_of_type_JavaLangString == null)
      {
        this.jdField_a_of_type_JavaLangString = "dbg";
        this.jdField_a_of_type_JavaLangString = "pub";
      }
      ((Map)localObject).put("build_type", this.jdField_a_of_type_JavaLangString);
      if (SystemClock.uptimeMillis() - ProcessStats.jdField_a_of_type_Long < 60000L)
      {
        ((Map)localObject).put("totalCpu", String.valueOf(ProcessStats.jdField_a_of_type_Int));
        ((Map)localObject).put("appCpu", String.valueOf(ProcessStats.jdField_a_of_type_ComTencentQqperfToolsProcessStats$Stats.jdField_a_of_type_Int));
        ((Map)localObject).put("cpu_update_time", String.valueOf((SystemClock.uptimeMillis() - ProcessStats.jdField_a_of_type_Long) / 1000L));
      }
      if (paramInt1 == 0)
      {
        if (MobileQQ.sProcessId == 1)
        {
          ((Map)localObject).put("param_is_logining", String.valueOf(((IAutomatorApi)QRoute.api(IAutomatorApi.class)).isLogining()));
          ((Map)localObject).put("param_syncing_msg", String.valueOf(((IAutomatorApi)QRoute.api(IAutomatorApi.class)).isSyncingMsg()));
        }
        ((Map)localObject).put("max_heap_size", String.valueOf(Runtime.getRuntime().maxMemory()));
        ((Map)localObject).put("currentHeapSize", String.valueOf(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));
      }
      ((Map)localObject).put("wal_enable", String.valueOf(jdField_a_of_type_Int));
      if (!QLog.isColorLevel()) {
        break label451;
      }
      paramString = "-1";
      label365:
      ((Map)localObject).put("not_reported", paramString);
      if (str != null)
      {
        if (str.length() > 950) {
          break label460;
        }
        ((Map)localObject).put("stack", str);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 1, paramInt2, 0, localObject));
      paramString = this.jdField_a_of_type_ArrayOfComTencentQqperfUnifiedMonitor$FamilyConfig[paramInt1];
      paramString.g += 1;
      return;
      paramString = "";
      break;
      label451:
      paramString = String.valueOf(paramInt3);
      break label365;
      label460:
      ((Map)localObject).put("stack", str.substring(0, 950));
      ((Map)localObject).put("stack1", str.substring(950));
    }
  }
  
  public void b()
  {
    try
    {
      if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidOsHandler == null))
      {
        HandlerThread localHandlerThread = ThreadManager.newFreeHandlerThread("unified-monitor", 0);
        localHandlerThread.start();
        this.jdField_a_of_type_AndroidOsHandler = new Handler(localHandlerThread.getLooper(), this);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean b()
  {
    return Debug.isDebuggerConnected();
  }
  
  public void c()
  {
    int i = 0;
    try
    {
      b();
      ThreadTraceHelper.a(MobileQQ.getContext());
      ArrayList localArrayList = ThreadTraceHelper.a(MobileQQ.getContext());
      if ((localArrayList != null) && (localArrayList.size() > 0)) {
        while (i < localArrayList.size())
        {
          HashMap localHashMap = new HashMap(2);
          localHashMap.put("filePath", localArrayList.get(i));
          this.jdField_a_of_type_AndroidOsHandler.sendMessage(Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 10, 0, 0, localHashMap));
          i += 1;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("UnifiedMonitor_QAPM", 2, "", localException);
      }
    }
  }
  
  public int getThreshold(int paramInt)
  {
    return this.jdField_a_of_type_ArrayOfComTencentQqperfUnifiedMonitor$FamilyConfig[paramInt].jdField_a_of_type_Int;
  }
  
  public boolean handleEnd(int paramInt)
  {
    if (this.jdField_c_of_type_AndroidOsHandler == null) {}
    while (!whetherReportDuringThisStartup(a(paramInt))) {
      return false;
    }
    this.jdField_c_of_type_AndroidOsHandler.removeMessages(b(paramInt), Thread.currentThread());
    return true;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if ((!whetherReportThisTime(paramMessage.arg1, false)) || (paramMessage.obj == null) || (!(paramMessage.obj instanceof Thread))) {
        continue;
      }
      QLog.e("UnifiedMonitor_QAPM", 1, paramMessage.arg1 + ", " + paramMessage.obj + " held: " + Arrays.toString(((Thread)paramMessage.obj).getStackTrace()));
      a(paramMessage.arg1, (Thread)paramMessage.obj);
      return true;
      if (paramMessage.obj == null) {
        continue;
      }
      Object localObject;
      try
      {
        localObject = (HashMap)paramMessage.obj;
        int i = paramMessage.arg1;
        StatisticCollector.getInstance(MobileQQ.getContext()).collectPerformance(null, "unifiedMonitor", true, i, 0L, (HashMap)localObject, null);
        return true;
      }
      catch (Throwable paramMessage) {}
      if (!QLog.isColorLevel()) {
        continue;
      }
      paramMessage.printStackTrace();
      return true;
      StackObservable.a().a((HashMap)paramMessage.obj);
      return true;
      addEvent(paramMessage.arg1, "", 3000, -1, a());
      this.jdField_a_of_type_ArrayOfComTencentQqperfUnifiedMonitor$FamilyConfig[paramMessage.arg1].jdField_a_of_type_JavaLangString = null;
      return true;
      g();
      d();
      return true;
      this.jdField_a_of_type_ArrayOfComTencentQqperfUnifiedMonitor$FamilyConfig[11].jdField_a_of_type_Long = SystemClock.uptimeMillis();
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(5, 2000L);
      return true;
      ProcessStats.a(false);
      if (this.jdField_b_of_type_AndroidOsHandler.hasMessages(7)) {
        continue;
      }
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(6, 1500L);
      return true;
      ProcessStats.b(false);
      paramMessage = (UnifiedMonitor.ProcessStatsConfig)this.jdField_a_of_type_ArrayOfComTencentQqperfUnifiedMonitor$FamilyConfig[11];
      if (whetherReportThisTime(11, true))
      {
        localObject = new HashMap(10);
        ((Map)localObject).put("total_cpu", String.valueOf(ProcessStats.jdField_a_of_type_Int));
        ((Map)localObject).put("app_cpu", String.valueOf(ProcessStats.jdField_a_of_type_ComTencentQqperfToolsProcessStats$Stats.jdField_a_of_type_Int));
        a().addEvent(11, null, 0, 0, (Map)localObject);
      }
      if ((ProcessStats.jdField_a_of_type_Int >= paramMessage.j) || (ProcessStats.jdField_a_of_type_ComTencentQqperfToolsProcessStats$Stats.jdField_a_of_type_Int >= paramMessage.k)) {
        if ((QLog.isColorLevel()) && (SystemClock.uptimeMillis() - paramMessage.c > 60000L))
        {
          QLog.d("UnifiedMonitor_QAPM", 2, "totalCpu exceed: " + ProcessStats.jdField_a_of_type_Int + ", appCpu: " + ProcessStats.jdField_a_of_type_ComTencentQqperfToolsProcessStats$Stats.jdField_a_of_type_Int);
          ProcessStats.a(true);
        }
      }
      try
      {
        Thread.sleep(2000L);
        label529:
        ProcessStats.b(true);
        localObject = ProcessStats.a(paramMessage.l, true).iterator();
        while (((Iterator)localObject).hasNext()) {
          QLog.d("UnifiedMonitor_QAPM", 2, (String)((Iterator)localObject).next());
        }
        QLog.d("UnifiedMonitor_QAPM", 2, ProcessStats.a(10));
        localObject = ProcessStats.a(paramMessage.l, true).iterator();
        while (((Iterator)localObject).hasNext()) {
          QLog.d("UnifiedMonitor_QAPM", 2, (String)((Iterator)localObject).next());
        }
        paramMessage.c = SystemClock.uptimeMillis();
        label636:
        paramMessage.h += 1;
        while ((paramMessage.h < paramMessage.e) && (SystemClock.uptimeMillis() - paramMessage.jdField_a_of_type_Long < paramMessage.f * 1000L))
        {
          this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(5, 2000L);
          return true;
          QLog.d("UnifiedMonitor_QAPM", 1, "totalCpu exceed: " + ProcessStats.jdField_a_of_type_Int + ", appCpu: " + ProcessStats.jdField_a_of_type_ComTencentQqperfToolsProcessStats$Stats.jdField_a_of_type_Int);
          break label636;
          paramMessage.m = 1;
        }
        this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
        ProcessStats.a(true);
        this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(8, 10000L);
        return true;
        ProcessStats.b(true);
        localObject = (UnifiedMonitor.ProcessStatsConfig)this.jdField_a_of_type_ArrayOfComTencentQqperfUnifiedMonitor$FamilyConfig[11];
        if (!QLog.isColorLevel()) {
          continue;
        }
        localObject = ProcessStats.a(((UnifiedMonitor.ProcessStatsConfig)localObject).l, true);
        QLog.d("UnifiedMonitor_QAPM", 2, "trace " + paramMessage.obj + "'s cpu end(" + ProcessStats.jdField_a_of_type_Int + ", " + ProcessStats.jdField_a_of_type_ComTencentQqperfToolsProcessStats$Stats.jdField_a_of_type_Int + ")");
        paramMessage = ((List)localObject).iterator();
        while (paramMessage.hasNext()) {
          QLog.d("UnifiedMonitor_QAPM", 2, (String)paramMessage.next());
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        break label529;
      }
    }
  }
  
  public boolean handleStart(int paramInt)
  {
    if (this.jdField_c_of_type_AndroidOsHandler == null) {}
    int i;
    do
    {
      return false;
      i = a(paramInt);
    } while (!whetherReportDuringThisStartup(i));
    if (this.jdField_a_of_type_ArrayOfComTencentQqperfUnifiedMonitor$FamilyConfig[i].g >= this.jdField_a_of_type_ArrayOfComTencentQqperfUnifiedMonitor$FamilyConfig[i].jdField_b_of_type_Int)
    {
      this.jdField_c_of_type_AndroidOsHandler.removeMessages(b(paramInt));
      a(i);
      return false;
    }
    paramInt = b(paramInt);
    this.jdField_c_of_type_AndroidOsHandler.removeMessages(paramInt, Thread.currentThread());
    Message localMessage = this.jdField_c_of_type_AndroidOsHandler.obtainMessage(paramInt, Thread.currentThread());
    localMessage.arg1 = i;
    this.jdField_c_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, this.jdField_a_of_type_ArrayOfComTencentQqperfUnifiedMonitor$FamilyConfig[i].jdField_a_of_type_Int);
    return true;
  }
  
  public void notifyNotTimeout(int paramInt)
  {
    this.jdField_a_of_type_ArrayOfComTencentQqperfUnifiedMonitor$FamilyConfig[paramInt].jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_ArrayOfComTencentQqperfUnifiedMonitor$FamilyConfig[paramInt].jdField_a_of_type_JavaLangString = null;
    if ((paramInt == 0) || (paramInt == 10)) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
    }
  }
  
  public void reportStackIfTimeout(int paramInt)
  {
    this.jdField_a_of_type_ArrayOfComTencentQqperfUnifiedMonitor$FamilyConfig[paramInt].jdField_b_of_type_Long = SystemClock.uptimeMillis();
    this.jdField_a_of_type_ArrayOfComTencentQqperfUnifiedMonitor$FamilyConfig[paramInt].jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_ArrayOfComTencentQqperfUnifiedMonitor$FamilyConfig[paramInt].jdField_b_of_type_Boolean = false;
  }
  
  public boolean setMonitoredThread(int paramInt, Thread paramThread, AbstractUnifiedMonitor.ThreadMonitorCallback arg3)
  {
    if ((paramThread == null) || (!this.jdField_a_of_type_ArrayOfComTencentQqperfUnifiedMonitor$FamilyConfig[paramInt].jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ArrayOfComTencentQqperfUnifiedMonitor$FamilyConfig[paramInt].jdField_a_of_type_ComTencentQqperfUnifiedMonitor$StackGetterJob != null) || (this.jdField_a_of_type_ArrayOfComTencentQqperfUnifiedMonitor$FamilyConfig[paramInt].jdField_c_of_type_Int <= 0)) {
      return false;
    }
    QLog.d("UnifiedMonitor_QAPM", 1, "setMonitoredThread for family=" + paramInt);
    synchronized (this.jdField_a_of_type_ArrayOfComTencentQqperfUnifiedMonitor$FamilyConfig[paramInt])
    {
      if (this.jdField_a_of_type_ArrayOfComTencentQqperfUnifiedMonitor$FamilyConfig[paramInt].jdField_a_of_type_ComTencentQqperfUnifiedMonitor$StackGetterJob == null)
      {
        this.jdField_a_of_type_ArrayOfComTencentQqperfUnifiedMonitor$FamilyConfig[paramInt].jdField_a_of_type_ComTencentQqperfUnifiedMonitor$StackGetterJob = new UnifiedMonitor.StackGetterJob(this, paramInt, paramThread);
        ThreadManager.newFreeThread(this.jdField_a_of_type_ArrayOfComTencentQqperfUnifiedMonitor$FamilyConfig[paramInt].jdField_a_of_type_ComTencentQqperfUnifiedMonitor$StackGetterJob, "um-stack-fetcher-" + paramInt, 5).start();
        this.jdField_a_of_type_ArrayOfComTencentQqperfUnifiedMonitor$FamilyConfig[paramInt].jdField_c_of_type_Boolean = true;
        return true;
      }
    }
    return false;
  }
  
  public boolean whetherReportDuringThisStartup(int paramInt)
  {
    if (paramInt >= 21) {
      return false;
    }
    return this.jdField_a_of_type_ArrayOfComTencentQqperfUnifiedMonitor$FamilyConfig[paramInt].jdField_a_of_type_Boolean;
  }
  
  public boolean whetherReportThisTime(int paramInt)
  {
    if ((!this.jdField_a_of_type_Boolean) || (!this.jdField_a_of_type_ArrayOfComTencentQqperfUnifiedMonitor$FamilyConfig[paramInt].jdField_a_of_type_Boolean)) {
      return false;
    }
    if (this.jdField_a_of_type_ArrayOfComTencentQqperfUnifiedMonitor$FamilyConfig[paramInt].jdField_c_of_type_Boolean) {
      return this.jdField_a_of_type_ArrayOfComTencentQqperfUnifiedMonitor$FamilyConfig[paramInt].jdField_b_of_type_Boolean;
    }
    return whetherReportThisTime(paramInt, false);
  }
  
  public boolean whetherReportThisTime(int paramInt, boolean paramBoolean)
  {
    float f = this.jdField_a_of_type_ArrayOfComTencentQqperfUnifiedMonitor$FamilyConfig[paramInt].jdField_b_of_type_Float;
    if (this.jdField_a_of_type_ArrayOfComTencentQqperfUnifiedMonitor$FamilyConfig[paramInt].g >= this.jdField_a_of_type_ArrayOfComTencentQqperfUnifiedMonitor$FamilyConfig[paramInt].jdField_b_of_type_Int) {}
    while (Math.random() > f) {
      return false;
    }
    return true;
  }
  
  public boolean whetherStackEnabled(int paramInt)
  {
    return this.jdField_a_of_type_ArrayOfComTencentQqperfUnifiedMonitor$FamilyConfig[paramInt].jdField_c_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqperf.UnifiedMonitor
 * JD-Core Version:    0.7.0.1
 */