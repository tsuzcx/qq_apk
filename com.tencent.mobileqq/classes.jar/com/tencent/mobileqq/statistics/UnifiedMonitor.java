package com.tencent.mobileqq.statistics;

import abwa;
import alvx;
import alzh;
import alzj;
import alzk;
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
import azrd;
import azri;
import azru;
import azry;
import azrz;
import bdeu;
import bjuq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mfsdk.MagnifierSDK;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.monitor.MsfMonitorCallback;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.qapmsdk.base.config.DefaultPluginConfig;
import com.tencent.qapmsdk.base.config.PluginCombination;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MainService;
import mqq.util.AbstractUnifiedMonitor;
import mqq.util.AbstractUnifiedMonitor.ThreadMonitorCallback;

public class UnifiedMonitor
  extends AbstractUnifiedMonitor
  implements Handler.Callback, MsfMonitorCallback
{
  private static int jdField_a_of_type_Int = -1;
  private static UnifiedMonitor jdField_a_of_type_ComTencentMobileqqStatisticsUnifiedMonitor;
  public static AtomicBoolean a;
  public static String[] a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private String jdField_a_of_type_JavaLangString;
  public volatile boolean a;
  private azry[] jdField_a_of_type_ArrayOfAzry = { new azry(0.0008F, 100, 10, 0.1F, 6, 0, 0, 0, false), new azry(), new azry(), new azry(), new azry(0.001F, 180000, 2, 1.0F, 6, 0, 0, 0, true), new azry(0.001F, 180000, 2, 1.0F, 6, 0, 0, 0, true), new azry(0.001F, 1000, 10, 0.001F, 0, 0, 0, 0, false), new azry(0.001F, 180000, 2, 1.0F, 6, 6, 0, 0, true), new azry(0.001F, 0, 10, 0.1F, 0, 0, 0, 0, false), new azry(0.001F, 100, 5, 0.01F, 0, 0, 0, 0, false), new azry(0.001F, 100, 10, 0.1F, 6, 0, 0, 0, false), new azrz(0.0F, 100100005, 1, 0.01F, 0, 0, 2, 300), new azry(0.01F, 100, 5, 0.01F, 0, 0, 0, 0, false), new azry(0.001F, 180000, 10, 1.0F, 6, 0, 0, 0, true), new azry(0.001F, 100, 5, 0.01F, 6, 0, 0, 0, false), new azry(0.001F, 600000, 2, 1.0F, 6, 0, 0, 0, true), new azry(0.001F, 180000, 2, 1.0F, 6, 0, 0, 0, true), new azry(0.001F, 180000, 2, 1.0F, 6, 0, 0, 0, true), new azry(0.001F, 180000, 2, 1.0F, 6, 0, 0, 0, true), new azry(0.001F, 100, 5, 0.01F, 6, 0, 0, 0, false), new azry(0.01F, 100, 10, 0.01F, 0, 0, 0, 0, false) };
  private Handler jdField_b_of_type_AndroidOsHandler;
  private HandlerThread jdField_b_of_type_AndroidOsHandlerThread;
  private String jdField_b_of_type_JavaLangString;
  private Handler jdField_c_of_type_AndroidOsHandler;
  private String jdField_c_of_type_JavaLangString;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "FAMILY_LOOPER", "FAMILY_OBSERVER", "FAMILY_IMAGE_DRAWABLE", "FAMILY_IMAGE_VIEW", "FAMILY_SUB_TASK", "FAMILY_FILE_TASK", "FAMILY_BG_TASK", "FAMILY_MSF_MSG", "FAMILY_ACT_TIME", "FAMILY_SCENE_SMOOTH", "FAMILY_DROP_FRAME", "FAMILY_CPU_STATS", "FAMILY_NEW_FPS", "FAMILY_RECENT", "FAMILY_QZONE_LOOPER", "FAMILY_MSF_SENDER", "FAMILY_MSF_RECVER", "FAMILY_MSF_LIGHT_SENDER", "FAMILY_MSF_NETWORK", "FAMILY_TOOL_LOOPER", "FAMILY_SCENE_PERF", "FAMILY_LAST" };
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
    if (jdField_a_of_type_ComTencentMobileqqStatisticsUnifiedMonitor != null) {
      return jdField_a_of_type_ComTencentMobileqqStatisticsUnifiedMonitor;
    }
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqStatisticsUnifiedMonitor == null) {
        jdField_a_of_type_ComTencentMobileqqStatisticsUnifiedMonitor = new UnifiedMonitor();
      }
      UnifiedMonitor localUnifiedMonitor = jdField_a_of_type_ComTencentMobileqqStatisticsUnifiedMonitor;
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
    HashMap localHashMap = null;
    if (2 == BaseApplicationImpl.sProcessId) {
      localHashMap = new HashMap(8);
    }
    String str;
    do
    {
      try
      {
        String[] arrayOfString = bjuq.c().split("/");
        localHashMap.put("act", arrayOfString[(arrayOfString.length - 1)]);
        return localHashMap;
      }
      catch (Exception localException)
      {
        localHashMap.put("act", "QZoneFriendFeedActivity");
        return localHashMap;
      }
      str = alzk.a();
    } while (str == null);
    localHashMap = new HashMap(8);
    localHashMap.put("act", str);
    return localHashMap;
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_ArrayOfAzry[paramInt].jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ArrayOfAzry[paramInt].jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ArrayOfAzry[paramInt].jdField_a_of_type_ComTencentMobileqqStatisticsUnifiedMonitor$StackGetterJob = null;
    this.jdField_a_of_type_ArrayOfAzry[paramInt].jdField_c_of_type_Boolean = false;
    if (this.jdField_a_of_type_ArrayOfAzry[paramInt].jdField_a_of_type_MqqUtilAbstractUnifiedMonitor$ThreadMonitorCallback != null)
    {
      this.jdField_a_of_type_ArrayOfAzry[paramInt].jdField_a_of_type_MqqUtilAbstractUnifiedMonitor$ThreadMonitorCallback.onThreadMonitorEnd(paramInt);
      this.jdField_a_of_type_ArrayOfAzry[paramInt].jdField_a_of_type_MqqUtilAbstractUnifiedMonitor$ThreadMonitorCallback = null;
    }
  }
  
  public static void a(DefaultPluginConfig paramDefaultPluginConfig, azry paramazry)
  {
    paramDefaultPluginConfig.eventSampleRatio = paramazry.jdField_b_of_type_Float;
    paramDefaultPluginConfig.threshold = paramazry.jdField_a_of_type_Int;
    paramDefaultPluginConfig.maxReportNum = paramazry.jdField_b_of_type_Int;
    paramDefaultPluginConfig.stackDepth = paramazry.jdField_c_of_type_Int;
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
  
  public static boolean b()
  {
    if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean == null) {
      jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(new File("/proc/stat").canRead());
    }
    return jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  public static boolean d()
  {
    return (QLog.isColorLevel()) || (bdeu.b());
  }
  
  public static void e()
  {
    azrd.a();
  }
  
  private void f()
  {
    if (!MagnifierSDK.a())
    {
      new Handler(Looper.getMainLooper()).post(new UnifiedMonitor.1(this));
      if (2 == BaseApplicationImpl.sProcessId) {
        alvx.b();
      }
      if (7 == BaseApplicationImpl.sProcessId) {
        alvx.h();
      }
    }
    if (4 == BaseApplicationImpl.sProcessId) {
      h();
    }
    if (1 != BaseApplicationImpl.sProcessId) {
      return;
    }
    if ((!MagnifierSDK.a()) && (whetherReportDuringThisStartup(0))) {
      alvx.a();
    }
    if (whetherReportDuringThisStartup(4)) {
      alvx.c();
    }
    if (whetherReportDuringThisStartup(5)) {
      alvx.f();
    }
    if (whetherReportDuringThisStartup(6)) {
      alvx.g();
    }
    if (whetherReportDuringThisStartup(13)) {
      alvx.e();
    }
    MainService.setUnifiedMonitorInstance(a());
    g();
  }
  
  private final void g()
  {
    if ((whetherReportDuringThisStartup(11)) && (this.jdField_a_of_type_AndroidOsHandlerThread == null) && (b()))
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
  
  private void h()
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
        alvx.d();
      }
      return;
      QLog.e("UnifiedMonitor_QAPM", 1, "MsfCore.sCore is null");
    }
  }
  
  /* Error */
  private void i()
  {
    // Byte code:
    //   0: invokestatic 361	com/tencent/mobileqq/app/DeviceProfileManager:a	()Lcom/tencent/mobileqq/app/DeviceProfileManager;
    //   3: getstatic 367	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:unified_monitor_params	Lcom/tencent/mobileqq/app/DeviceProfileManager$DpcNames;
    //   6: invokevirtual 370	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:name	()Ljava/lang/String;
    //   9: invokevirtual 373	com/tencent/mobileqq/app/DeviceProfileManager:a	(Ljava/lang/String;)Ljava/lang/String;
    //   12: astore 8
    //   14: ldc_w 318
    //   17: iconst_1
    //   18: new 375	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 376	java/lang/StringBuilder:<init>	()V
    //   25: ldc_w 378
    //   28: invokevirtual 382	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: aload 8
    //   33: invokevirtual 382	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 385	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 387	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   42: aload 8
    //   44: ifnull +589 -> 633
    //   47: aload 8
    //   49: ldc_w 389
    //   52: invokevirtual 131	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   55: astore 10
    //   57: aload 10
    //   59: ifnonnull +20 -> 79
    //   62: aload_0
    //   63: monitorenter
    //   64: aload_0
    //   65: iconst_1
    //   66: putfield 390	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_Boolean	Z
    //   69: aload_0
    //   70: monitorexit
    //   71: return
    //   72: astore 8
    //   74: aload_0
    //   75: monitorexit
    //   76: aload 8
    //   78: athrow
    //   79: aload 10
    //   81: arraylength
    //   82: istore 5
    //   84: iconst_0
    //   85: istore 4
    //   87: iload 4
    //   89: iload 5
    //   91: if_icmpge +542 -> 633
    //   94: aload 10
    //   96: iload 4
    //   98: aaload
    //   99: astore 8
    //   101: aload 8
    //   103: ldc_w 392
    //   106: invokevirtual 131	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   109: astore 11
    //   111: aload 11
    //   113: ifnull +1165 -> 1278
    //   116: aload 11
    //   118: arraylength
    //   119: iconst_2
    //   120: if_icmpne +1158 -> 1278
    //   123: aload 11
    //   125: iconst_0
    //   126: aaload
    //   127: invokestatic 398	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   130: ifne +1148 -> 1278
    //   133: aload 11
    //   135: iconst_1
    //   136: aaload
    //   137: invokestatic 398	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   140: ifne +1138 -> 1278
    //   143: aload 11
    //   145: iconst_0
    //   146: aaload
    //   147: bipush 95
    //   149: invokevirtual 401	java/lang/String:lastIndexOf	(I)I
    //   152: istore 6
    //   154: iload 6
    //   156: iconst_m1
    //   157: if_icmpeq +1130 -> 1287
    //   160: aload 11
    //   162: iconst_0
    //   163: aaload
    //   164: iconst_0
    //   165: iload 6
    //   167: iconst_1
    //   168: iadd
    //   169: invokevirtual 405	java/lang/String:substring	(II)Ljava/lang/String;
    //   172: astore 8
    //   174: iload 6
    //   176: iconst_m1
    //   177: if_icmpeq +1116 -> 1293
    //   180: iload 6
    //   182: aload 11
    //   184: iconst_0
    //   185: aaload
    //   186: invokevirtual 409	java/lang/String:length	()I
    //   189: iconst_1
    //   190: isub
    //   191: if_icmpge +1102 -> 1293
    //   194: aload 11
    //   196: iconst_0
    //   197: aaload
    //   198: iload 6
    //   200: iconst_1
    //   201: iadd
    //   202: invokevirtual 411	java/lang/String:substring	(I)Ljava/lang/String;
    //   205: astore 9
    //   207: iconst_m1
    //   208: istore_3
    //   209: aload 9
    //   211: invokestatic 416	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   214: invokevirtual 419	java/lang/Integer:intValue	()I
    //   217: istore_2
    //   218: iload_2
    //   219: istore_3
    //   220: invokestatic 216	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   223: ifeq +1028 -> 1251
    //   226: ldc_w 318
    //   229: iconst_2
    //   230: new 375	java/lang/StringBuilder
    //   233: dup
    //   234: invokespecial 376	java/lang/StringBuilder:<init>	()V
    //   237: ldc_w 421
    //   240: invokevirtual 382	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: iload_3
    //   244: invokevirtual 424	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   247: ldc_w 426
    //   250: invokevirtual 382	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: aload 8
    //   255: invokevirtual 382	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: ldc_w 428
    //   261: invokevirtual 382	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: aload 11
    //   266: iconst_0
    //   267: aaload
    //   268: invokevirtual 382	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: ldc_w 430
    //   274: invokevirtual 382	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: aload 11
    //   279: iconst_1
    //   280: aaload
    //   281: invokevirtual 382	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: invokevirtual 385	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   287: invokestatic 387	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   290: goto +961 -> 1251
    //   293: aload 8
    //   295: ifnull +983 -> 1278
    //   298: iload 6
    //   300: iconst_m1
    //   301: if_icmpeq +977 -> 1278
    //   304: iload_2
    //   305: iconst_m1
    //   306: if_icmpeq +972 -> 1278
    //   309: aload 9
    //   311: ifnull +967 -> 1278
    //   314: iload_2
    //   315: bipush 21
    //   317: if_icmpge +961 -> 1278
    //   320: ldc_w 432
    //   323: aload 8
    //   325: invokevirtual 436	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   328: ifeq +25 -> 353
    //   331: aload_0
    //   332: getfield 96	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfAzry	[Lazry;
    //   335: iload_2
    //   336: aaload
    //   337: aload 11
    //   339: iconst_1
    //   340: aaload
    //   341: invokestatic 441	java/lang/Float:valueOf	(Ljava/lang/String;)Ljava/lang/Float;
    //   344: invokevirtual 445	java/lang/Float:floatValue	()F
    //   347: putfield 447	azry:jdField_a_of_type_Float	F
    //   350: goto +928 -> 1278
    //   353: ldc_w 449
    //   356: aload 8
    //   358: invokevirtual 436	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   361: ifeq +85 -> 446
    //   364: aload_0
    //   365: getfield 96	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfAzry	[Lazry;
    //   368: iload_2
    //   369: aaload
    //   370: aload 11
    //   372: iconst_1
    //   373: aaload
    //   374: invokestatic 416	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   377: invokevirtual 419	java/lang/Integer:intValue	()I
    //   380: putfield 180	azry:jdField_b_of_type_Int	I
    //   383: goto +895 -> 1278
    //   386: astore 8
    //   388: invokestatic 216	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   391: ifeq +887 -> 1278
    //   394: ldc_w 318
    //   397: iconst_2
    //   398: ldc_w 451
    //   401: aload 8
    //   403: invokestatic 454	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   406: goto +872 -> 1278
    //   409: astore 8
    //   411: invokestatic 216	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   414: ifeq +15 -> 429
    //   417: ldc_w 318
    //   420: iconst_2
    //   421: ldc_w 451
    //   424: aload 8
    //   426: invokestatic 456	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   429: aload_0
    //   430: monitorenter
    //   431: aload_0
    //   432: iconst_1
    //   433: putfield 390	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_Boolean	Z
    //   436: aload_0
    //   437: monitorexit
    //   438: return
    //   439: astore 8
    //   441: aload_0
    //   442: monitorexit
    //   443: aload 8
    //   445: athrow
    //   446: ldc_w 458
    //   449: aload 8
    //   451: invokevirtual 436	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   454: ifeq +39 -> 493
    //   457: aload_0
    //   458: getfield 96	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfAzry	[Lazry;
    //   461: iload_2
    //   462: aaload
    //   463: aload 11
    //   465: iconst_1
    //   466: aaload
    //   467: invokestatic 416	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   470: invokevirtual 419	java/lang/Integer:intValue	()I
    //   473: putfield 175	azry:jdField_a_of_type_Int	I
    //   476: goto +802 -> 1278
    //   479: astore 8
    //   481: aload_0
    //   482: monitorenter
    //   483: aload_0
    //   484: iconst_1
    //   485: putfield 390	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_Boolean	Z
    //   488: aload_0
    //   489: monitorexit
    //   490: aload 8
    //   492: athrow
    //   493: ldc_w 460
    //   496: aload 8
    //   498: invokevirtual 436	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   501: ifeq +25 -> 526
    //   504: aload_0
    //   505: getfield 96	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfAzry	[Lazry;
    //   508: iload_2
    //   509: aaload
    //   510: aload 11
    //   512: iconst_1
    //   513: aaload
    //   514: invokestatic 441	java/lang/Float:valueOf	(Ljava/lang/String;)Ljava/lang/Float;
    //   517: invokevirtual 445	java/lang/Float:floatValue	()F
    //   520: putfield 169	azry:jdField_b_of_type_Float	F
    //   523: goto +755 -> 1278
    //   526: ldc_w 462
    //   529: aload 8
    //   531: invokevirtual 436	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   534: ifeq +33 -> 567
    //   537: getstatic 467	android/os/Build$VERSION:SDK_INT	I
    //   540: bipush 17
    //   542: if_icmpeq +736 -> 1278
    //   545: aload_0
    //   546: getfield 96	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfAzry	[Lazry;
    //   549: iload_2
    //   550: aaload
    //   551: aload 11
    //   553: iconst_1
    //   554: aaload
    //   555: invokestatic 416	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   558: invokevirtual 419	java/lang/Integer:intValue	()I
    //   561: putfield 185	azry:jdField_c_of_type_Int	I
    //   564: goto +714 -> 1278
    //   567: ldc_w 469
    //   570: aload 8
    //   572: invokevirtual 436	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   575: ifeq +25 -> 600
    //   578: aload_0
    //   579: getfield 96	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfAzry	[Lazry;
    //   582: iload_2
    //   583: aaload
    //   584: aload 11
    //   586: iconst_1
    //   587: aaload
    //   588: invokestatic 416	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   591: invokevirtual 419	java/lang/Integer:intValue	()I
    //   594: putfield 471	azry:jdField_d_of_type_Int	I
    //   597: goto +681 -> 1278
    //   600: ldc_w 473
    //   603: aload 8
    //   605: invokevirtual 436	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   608: ifeq +670 -> 1278
    //   611: aload_0
    //   612: getfield 96	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfAzry	[Lazry;
    //   615: iload_2
    //   616: aaload
    //   617: aload 11
    //   619: iconst_1
    //   620: aaload
    //   621: invokestatic 476	java/lang/Boolean:valueOf	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   624: invokevirtual 479	java/lang/Boolean:booleanValue	()Z
    //   627: putfield 481	azry:jdField_d_of_type_Boolean	Z
    //   630: goto +648 -> 1278
    //   633: iconst_0
    //   634: istore_2
    //   635: iload_2
    //   636: aload_0
    //   637: getfield 96	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfAzry	[Lazry;
    //   640: arraylength
    //   641: if_icmpge +20 -> 661
    //   644: aload_0
    //   645: getfield 96	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfAzry	[Lazry;
    //   648: iload_2
    //   649: aaload
    //   650: iload_2
    //   651: invokevirtual 482	azry:a	(I)V
    //   654: iload_2
    //   655: iconst_1
    //   656: iadd
    //   657: istore_2
    //   658: goto -23 -> 635
    //   661: aload_0
    //   662: getfield 96	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfAzry	[Lazry;
    //   665: bipush 10
    //   667: aaload
    //   668: iconst_0
    //   669: putfield 147	azry:jdField_a_of_type_Boolean	Z
    //   672: invokestatic 216	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   675: ifeq +53 -> 728
    //   678: aload_0
    //   679: getfield 96	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfAzry	[Lazry;
    //   682: iconst_0
    //   683: aaload
    //   684: iconst_1
    //   685: putfield 147	azry:jdField_a_of_type_Boolean	Z
    //   688: aload_0
    //   689: getfield 96	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfAzry	[Lazry;
    //   692: iconst_0
    //   693: aaload
    //   694: ldc_w 483
    //   697: putfield 180	azry:jdField_b_of_type_Int	I
    //   700: aload_0
    //   701: getfield 96	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfAzry	[Lazry;
    //   704: iconst_0
    //   705: aaload
    //   706: fconst_1
    //   707: putfield 169	azry:jdField_b_of_type_Float	F
    //   710: invokestatic 216	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   713: ifeq +15 -> 728
    //   716: aload_0
    //   717: getfield 96	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfAzry	[Lazry;
    //   720: iconst_0
    //   721: aaload
    //   722: sipush 200
    //   725: putfield 175	azry:jdField_a_of_type_Int	I
    //   728: aload_0
    //   729: getfield 96	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfAzry	[Lazry;
    //   732: bipush 14
    //   734: aaload
    //   735: invokestatic 489	common/config/service/QzoneConfig:getInstance	()Lcommon/config/service/QzoneConfig;
    //   738: ldc_w 491
    //   741: ldc_w 493
    //   744: aload_0
    //   745: getfield 96	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfAzry	[Lazry;
    //   748: bipush 14
    //   750: aaload
    //   751: getfield 175	azry:jdField_a_of_type_Int	I
    //   754: invokevirtual 497	common/config/service/QzoneConfig:getConfig	(Ljava/lang/String;Ljava/lang/String;I)I
    //   757: putfield 175	azry:jdField_a_of_type_Int	I
    //   760: invokestatic 489	common/config/service/QzoneConfig:getInstance	()Lcommon/config/service/QzoneConfig;
    //   763: ldc_w 491
    //   766: ldc_w 499
    //   769: invokevirtual 502	common/config/service/QzoneConfig:getConfig	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   772: astore 9
    //   774: invokestatic 489	common/config/service/QzoneConfig:getInstance	()Lcommon/config/service/QzoneConfig;
    //   777: ldc_w 491
    //   780: ldc_w 504
    //   783: invokevirtual 502	common/config/service/QzoneConfig:getConfig	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   786: astore 8
    //   788: aload 9
    //   790: invokestatic 398	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   793: istore 7
    //   795: iload 7
    //   797: ifne +29 -> 826
    //   800: aload 9
    //   802: invokestatic 441	java/lang/Float:valueOf	(Ljava/lang/String;)Ljava/lang/Float;
    //   805: invokevirtual 445	java/lang/Float:floatValue	()F
    //   808: fstore_1
    //   809: fload_1
    //   810: fconst_0
    //   811: fcmpl
    //   812: iflt +14 -> 826
    //   815: aload_0
    //   816: getfield 96	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfAzry	[Lazry;
    //   819: bipush 14
    //   821: aaload
    //   822: fload_1
    //   823: putfield 447	azry:jdField_a_of_type_Float	F
    //   826: aload 8
    //   828: invokestatic 398	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   831: istore 7
    //   833: iload 7
    //   835: ifne +29 -> 864
    //   838: aload 8
    //   840: invokestatic 441	java/lang/Float:valueOf	(Ljava/lang/String;)Ljava/lang/Float;
    //   843: invokevirtual 445	java/lang/Float:floatValue	()F
    //   846: fstore_1
    //   847: fload_1
    //   848: fconst_0
    //   849: fcmpl
    //   850: iflt +14 -> 864
    //   853: aload_0
    //   854: getfield 96	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfAzry	[Lazry;
    //   857: bipush 14
    //   859: aaload
    //   860: fload_1
    //   861: putfield 169	azry:jdField_b_of_type_Float	F
    //   864: getstatic 115	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   867: iconst_4
    //   868: if_icmpne +3 -> 871
    //   871: getstatic 115	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   874: iconst_1
    //   875: if_icmpne +14 -> 889
    //   878: aload_0
    //   879: getfield 96	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfAzry	[Lazry;
    //   882: bipush 11
    //   884: aaload
    //   885: iconst_0
    //   886: putfield 147	azry:jdField_a_of_type_Boolean	Z
    //   889: invokestatic 220	bdeu:b	()Z
    //   892: ifeq +64 -> 956
    //   895: getstatic 115	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   898: iconst_1
    //   899: if_icmpne +246 -> 1145
    //   902: aload_0
    //   903: getfield 96	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfAzry	[Lazry;
    //   906: iconst_4
    //   907: aaload
    //   908: getfield 147	azry:jdField_a_of_type_Boolean	Z
    //   911: ifeq +234 -> 1145
    //   914: new 117	java/util/HashMap
    //   917: dup
    //   918: iconst_2
    //   919: invokespecial 120	java/util/HashMap:<init>	(I)V
    //   922: astore 8
    //   924: aload 8
    //   926: ldc_w 506
    //   929: iconst_1
    //   930: invokestatic 508	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   933: invokevirtual 137	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   936: pop
    //   937: invokestatic 512	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   940: invokestatic 517	azri:a	(Landroid/content/Context;)Lazri;
    //   943: aconst_null
    //   944: ldc_w 519
    //   947: iconst_1
    //   948: lconst_0
    //   949: lconst_0
    //   950: aload 8
    //   952: aconst_null
    //   953: invokevirtual 522	azri:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   956: ldc_w 524
    //   959: iconst_1
    //   960: new 375	java/lang/StringBuilder
    //   963: dup
    //   964: invokespecial 376	java/lang/StringBuilder:<init>	()V
    //   967: ldc_w 526
    //   970: invokevirtual 382	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   973: invokestatic 220	bdeu:b	()Z
    //   976: invokevirtual 529	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   979: ldc_w 531
    //   982: invokevirtual 382	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   985: invokestatic 216	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   988: invokevirtual 529	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   991: invokevirtual 385	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   994: invokestatic 387	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   997: iconst_0
    //   998: istore_2
    //   999: aload_0
    //   1000: getfield 96	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfAzry	[Lazry;
    //   1003: arraylength
    //   1004: istore_3
    //   1005: iload_2
    //   1006: iload_3
    //   1007: if_icmpge +203 -> 1210
    //   1010: aload_0
    //   1011: getfield 96	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfAzry	[Lazry;
    //   1014: iload_2
    //   1015: aaload
    //   1016: astore 8
    //   1018: ldc_w 524
    //   1021: iconst_1
    //   1022: new 375	java/lang/StringBuilder
    //   1025: dup
    //   1026: invokespecial 376	java/lang/StringBuilder:<init>	()V
    //   1029: ldc_w 533
    //   1032: invokevirtual 382	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1035: iload_2
    //   1036: invokestatic 535	com/tencent/mobileqq/statistics/UnifiedMonitor:a	(I)Ljava/lang/String;
    //   1039: invokevirtual 382	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1042: ldc_w 537
    //   1045: invokevirtual 382	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1048: aload 8
    //   1050: getfield 147	azry:jdField_a_of_type_Boolean	Z
    //   1053: invokevirtual 529	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1056: ldc_w 539
    //   1059: invokevirtual 382	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1062: aload 8
    //   1064: getfield 169	azry:jdField_b_of_type_Float	F
    //   1067: invokevirtual 542	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   1070: ldc_w 544
    //   1073: invokevirtual 382	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1076: aload 8
    //   1078: getfield 447	azry:jdField_a_of_type_Float	F
    //   1081: invokevirtual 542	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   1084: ldc_w 546
    //   1087: invokevirtual 382	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1090: aload 8
    //   1092: getfield 180	azry:jdField_b_of_type_Int	I
    //   1095: invokevirtual 424	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1098: ldc_w 548
    //   1101: invokevirtual 382	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1104: aload 8
    //   1106: getfield 175	azry:jdField_a_of_type_Int	I
    //   1109: invokevirtual 424	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1112: invokevirtual 385	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1115: invokestatic 387	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1118: iload_2
    //   1119: iconst_1
    //   1120: iadd
    //   1121: istore_2
    //   1122: goto -117 -> 1005
    //   1125: astore 9
    //   1127: aload 9
    //   1129: invokevirtual 551	java/lang/Exception:printStackTrace	()V
    //   1132: goto -306 -> 826
    //   1135: astore 8
    //   1137: aload 8
    //   1139: invokevirtual 551	java/lang/Exception:printStackTrace	()V
    //   1142: goto -278 -> 864
    //   1145: getstatic 115	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   1148: iconst_4
    //   1149: if_icmpne -193 -> 956
    //   1152: aload_0
    //   1153: getfield 96	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfAzry	[Lazry;
    //   1156: bipush 15
    //   1158: aaload
    //   1159: getfield 147	azry:jdField_a_of_type_Boolean	Z
    //   1162: ifeq -206 -> 956
    //   1165: new 117	java/util/HashMap
    //   1168: dup
    //   1169: iconst_2
    //   1170: invokespecial 120	java/util/HashMap:<init>	(I)V
    //   1173: astore 8
    //   1175: aload 8
    //   1177: ldc_w 506
    //   1180: iconst_2
    //   1181: invokestatic 508	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1184: invokevirtual 137	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1187: pop
    //   1188: invokestatic 512	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   1191: invokestatic 517	azri:a	(Landroid/content/Context;)Lazri;
    //   1194: aconst_null
    //   1195: ldc_w 519
    //   1198: iconst_1
    //   1199: lconst_0
    //   1200: lconst_0
    //   1201: aload 8
    //   1203: aconst_null
    //   1204: invokevirtual 522	azri:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   1207: goto -251 -> 956
    //   1210: invokestatic 231	com/tencent/mfsdk/MagnifierSDK:a	()Z
    //   1213: ifeq +9 -> 1222
    //   1216: invokestatic 556	aztr:a	()Laztr;
    //   1219: invokevirtual 557	aztr:a	()V
    //   1222: aload_0
    //   1223: monitorenter
    //   1224: aload_0
    //   1225: iconst_1
    //   1226: putfield 390	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_Boolean	Z
    //   1229: aload_0
    //   1230: monitorexit
    //   1231: return
    //   1232: astore 8
    //   1234: aload_0
    //   1235: monitorexit
    //   1236: aload 8
    //   1238: athrow
    //   1239: astore 8
    //   1241: aload_0
    //   1242: monitorexit
    //   1243: aload 8
    //   1245: athrow
    //   1246: astore 12
    //   1248: goto -1028 -> 220
    //   1251: iload_3
    //   1252: istore_2
    //   1253: iload_3
    //   1254: sipush 1000
    //   1257: if_icmplt -964 -> 293
    //   1260: iload_3
    //   1261: sipush 1000
    //   1264: isub
    //   1265: istore_3
    //   1266: iload_3
    //   1267: istore_2
    //   1268: iload_3
    //   1269: iconst_m1
    //   1270: if_icmpge -977 -> 293
    //   1273: iconst_m1
    //   1274: istore_2
    //   1275: goto -982 -> 293
    //   1278: iload 4
    //   1280: iconst_1
    //   1281: iadd
    //   1282: istore 4
    //   1284: goto -1197 -> 87
    //   1287: aconst_null
    //   1288: astore 8
    //   1290: goto -1116 -> 174
    //   1293: aconst_null
    //   1294: astore 9
    //   1296: goto -1089 -> 207
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1299	0	this	UnifiedMonitor
    //   808	53	1	f	float
    //   217	1058	2	i	int
    //   208	1063	3	j	int
    //   85	1198	4	k	int
    //   82	10	5	m	int
    //   152	150	6	n	int
    //   793	41	7	bool	boolean
    //   12	36	8	str1	String
    //   72	5	8	localObject1	Object
    //   99	258	8	str2	String
    //   386	16	8	localThrowable1	Throwable
    //   409	16	8	localThrowable2	Throwable
    //   439	11	8	localObject2	Object
    //   479	125	8	localObject3	Object
    //   786	319	8	localObject4	Object
    //   1135	3	8	localException1	Exception
    //   1173	29	8	localHashMap	HashMap
    //   1232	5	8	localObject5	Object
    //   1239	5	8	localObject6	Object
    //   1288	1	8	localObject7	Object
    //   205	596	9	str3	String
    //   1125	3	9	localException2	Exception
    //   1294	1	9	localObject8	Object
    //   55	40	10	arrayOfString1	String[]
    //   109	509	11	arrayOfString2	String[]
    //   1246	1	12	localNumberFormatException	java.lang.NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   64	71	72	finally
    //   74	76	72	finally
    //   101	111	386	java/lang/Throwable
    //   116	154	386	java/lang/Throwable
    //   160	174	386	java/lang/Throwable
    //   180	207	386	java/lang/Throwable
    //   209	218	386	java/lang/Throwable
    //   220	290	386	java/lang/Throwable
    //   320	350	386	java/lang/Throwable
    //   353	383	386	java/lang/Throwable
    //   446	476	386	java/lang/Throwable
    //   493	523	386	java/lang/Throwable
    //   526	564	386	java/lang/Throwable
    //   567	597	386	java/lang/Throwable
    //   600	630	386	java/lang/Throwable
    //   0	42	409	java/lang/Throwable
    //   47	57	409	java/lang/Throwable
    //   79	84	409	java/lang/Throwable
    //   388	406	409	java/lang/Throwable
    //   635	654	409	java/lang/Throwable
    //   661	728	409	java/lang/Throwable
    //   728	795	409	java/lang/Throwable
    //   800	809	409	java/lang/Throwable
    //   815	826	409	java/lang/Throwable
    //   826	833	409	java/lang/Throwable
    //   838	847	409	java/lang/Throwable
    //   853	864	409	java/lang/Throwable
    //   864	871	409	java/lang/Throwable
    //   871	889	409	java/lang/Throwable
    //   889	956	409	java/lang/Throwable
    //   956	997	409	java/lang/Throwable
    //   999	1005	409	java/lang/Throwable
    //   1010	1118	409	java/lang/Throwable
    //   1127	1132	409	java/lang/Throwable
    //   1137	1142	409	java/lang/Throwable
    //   1145	1207	409	java/lang/Throwable
    //   1210	1222	409	java/lang/Throwable
    //   431	438	439	finally
    //   441	443	439	finally
    //   0	42	479	finally
    //   47	57	479	finally
    //   79	84	479	finally
    //   101	111	479	finally
    //   116	154	479	finally
    //   160	174	479	finally
    //   180	207	479	finally
    //   209	218	479	finally
    //   220	290	479	finally
    //   320	350	479	finally
    //   353	383	479	finally
    //   388	406	479	finally
    //   411	429	479	finally
    //   446	476	479	finally
    //   493	523	479	finally
    //   526	564	479	finally
    //   567	597	479	finally
    //   600	630	479	finally
    //   635	654	479	finally
    //   661	728	479	finally
    //   728	795	479	finally
    //   800	809	479	finally
    //   815	826	479	finally
    //   826	833	479	finally
    //   838	847	479	finally
    //   853	864	479	finally
    //   864	871	479	finally
    //   871	889	479	finally
    //   889	956	479	finally
    //   956	997	479	finally
    //   999	1005	479	finally
    //   1010	1118	479	finally
    //   1127	1132	479	finally
    //   1137	1142	479	finally
    //   1145	1207	479	finally
    //   1210	1222	479	finally
    //   800	809	1125	java/lang/Exception
    //   815	826	1125	java/lang/Exception
    //   838	847	1135	java/lang/Exception
    //   853	864	1135	java/lang/Exception
    //   1224	1231	1232	finally
    //   1234	1236	1232	finally
    //   483	490	1239	finally
    //   1241	1243	1239	finally
    //   209	218	1246	java/lang/NumberFormatException
  }
  
  public void a() {}
  
  public void a(int paramInt, Thread paramThread)
  {
    if (!c())
    {
      if ((this.jdField_a_of_type_Boolean) && (whetherReportDuringThisStartup(paramInt))) {}
    }
    else
    {
      QLog.e("UnifiedMonitor_QAPM", 1, "skip issue caused by debugger");
      return;
    }
    SharedPreferences localSharedPreferences;
    long l;
    int i;
    if ((1 != BaseApplicationImpl.sProcessId) || (4 == BaseApplicationImpl.sProcessId))
    {
      localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("sp_thread_hold_msf", 0);
      l = localSharedPreferences.getLong("key_time_msf", -1L);
      if (Math.abs(System.currentTimeMillis() - l) < 86400000L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("UnifiedMonitor_QAPM", 2, new Object[] { "report msf interval is small, ", Long.valueOf(l) });
        }
        i = 0;
      }
    }
    for (;;)
    {
      String str;
      StringBuilder localStringBuilder;
      if (i != 0)
      {
        str = azru.a(String.valueOf(paramInt));
        if (this.jdField_a_of_type_JavaLangString == null)
        {
          this.jdField_a_of_type_JavaLangString = "dbg";
          this.jdField_a_of_type_JavaLangString = "pub";
        }
        localStringBuilder = new StringBuilder(50);
        localStringBuilder.append("AdditionInfo:0|");
        try
        {
          localObject = BaseApplicationImpl.getApplication().getPackageManager();
          if (this.jdField_b_of_type_JavaLangString == null)
          {
            PackageInfo localPackageInfo = ((PackageManager)localObject).getPackageInfo("com.tencent.mobileqq", 128);
            this.jdField_b_of_type_JavaLangString = (localPackageInfo.versionName + "." + localPackageInfo.versionCode);
          }
          if (this.jdField_c_of_type_JavaLangString == null) {
            this.jdField_c_of_type_JavaLangString = ((PackageManager)localObject).getApplicationInfo("com.tencent.mobileqq", 128).metaData.get("com.tencent.rdm.uuid").toString();
          }
          localObject = null;
          if (4 != BaseApplicationImpl.sProcessId) {
            break label791;
          }
          if (MsfCore.sCore != null) {
            localObject = MsfCore.sCore.getMainAccount();
          }
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            break label823;
          }
          l = Long.parseLong((String)localObject);
        }
        catch (Exception localException)
        {
          int j;
          for (;;)
          {
            Object localObject;
            QLog.e("UnifiedMonitor_QAPM", 1, "", localException);
            l = 0L;
            continue;
            i = 0;
            continue;
            i = 0;
            continue;
            bool1 = false;
          }
          localazri = azri.a(BaseApplicationImpl.getApplication());
          if (j != 1) {
            break label881;
          }
        }
        localStringBuilder.append(l).append("|").append(this.jdField_b_of_type_JavaLangString).append("|").append(this.jdField_c_of_type_JavaLangString);
        localStringBuilder.append("|").append(this.jdField_a_of_type_JavaLangString).append("|").append(System.currentTimeMillis());
        localStringBuilder.append("|").append(paramInt).append("|").append(Build.MODEL).append("|").append(Build.VERSION.RELEASE);
        localStringBuilder.append("|").append("monitorThread=").append(paramThread.getName()).append(",tid=").append(paramThread.getId()).append(",state=").append(paramThread.getState());
        localStringBuilder.append(azru.a());
        localStringBuilder.append(azru.b());
        l = SystemClock.uptimeMillis();
        j = azru.a(BaseApplicationImpl.getContext(), str, localStringBuilder.toString());
        l = SystemClock.uptimeMillis() - l;
        if (j == 1) {
          break label1023;
        }
      }
      label791:
      label823:
      label834:
      label839:
      label845:
      label881:
      label1023:
      for (boolean bool1 = azru.a(str, localStringBuilder.toString());; bool1 = true)
      {
        a(str);
        paramThread = new HashMap(2);
        paramThread.put("key_code", String.valueOf(j));
        if (QLog.isColorLevel())
        {
          i = 1;
          paramThread.put("is_color_level", String.valueOf(i));
          if (!BaseApplication.monitorBan) {
            break label834;
          }
          i = 1;
          paramThread.put("monitor_ban", String.valueOf(i));
          paramThread.put("event_family", String.valueOf(paramInt));
          if (4 != BaseApplicationImpl.sProcessId) {
            break label845;
          }
          if (MsfCore.sCore != null)
          {
            localObject = MsfCore.sCore;
            if (j != 1) {
              break label839;
            }
            bool1 = true;
            ((MsfCore)localObject).reportRDM("event_held_thread_msf", bool1, l, 0L, paramThread, false, false);
          }
          bool1 = false;
          if (bool1)
          {
            paramThread = new HashMap(2);
            paramThread.put("filePath", str);
            this.jdField_a_of_type_AndroidOsHandler.sendMessage(Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 10, 0, 0, paramThread));
            QLog.e("UnifiedMonitor_QAPM", 1, "report stack file for " + paramInt);
          }
          if ((0 != 0) && (1 == BaseApplicationImpl.sProcessId)) {
            throw new NullPointerException();
          }
          if (4 == BaseApplicationImpl.sProcessId) {
            localSharedPreferences.edit().putLong("key_time_msf", System.currentTimeMillis()).commit();
          }
        }
        for (;;)
        {
          paramThread = this.jdField_a_of_type_ArrayOfAzry[paramInt];
          paramThread.g += 1;
          return;
          localObject = ((QQAppInterface)BaseApplicationImpl.getApplication().waitAppRuntime(null)).getAccount();
          break;
          azri localazri;
          for (boolean bool2 = true;; bool2 = false)
          {
            localazri.a(null, "event_held_thread", bool2, l, 0L, paramThread, null);
            break;
          }
          paramThread = new HashMap(2);
          paramThread.put("key_code", String.valueOf(7));
          if (QLog.isColorLevel())
          {
            i = 1;
            paramThread.put("is_color_level", String.valueOf(i));
            if (!BaseApplication.monitorBan) {
              break label997;
            }
          }
          for (i = 1;; i = 0)
          {
            paramThread.put("monitor_ban", String.valueOf(i));
            paramThread.put("event_family", String.valueOf(paramInt));
            if (4 != BaseApplicationImpl.sProcessId) {
              break label1002;
            }
            if (MsfCore.sCore == null) {
              break;
            }
            MsfCore.sCore.reportRDM("event_held_thread_msf", false, 0L, 0L, paramThread, false, false);
            break;
            i = 0;
            break label917;
          }
          azri.a(BaseApplicationImpl.getApplication()).a(null, "event_held_thread", false, 0L, 0L, paramThread, null);
        }
      }
      label917:
      label997:
      label1002:
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
    //   0: new 197	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 202	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore 4
    //   10: aload 4
    //   12: invokevirtual 785	java/io/File:exists	()Z
    //   15: ifeq +100 -> 115
    //   18: ldc_w 318
    //   21: iconst_1
    //   22: new 375	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 376	java/lang/StringBuilder:<init>	()V
    //   29: ldc_w 787
    //   32: invokevirtual 382	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_1
    //   36: invokevirtual 382	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 385	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 351	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   45: aconst_null
    //   46: astore_2
    //   47: aconst_null
    //   48: astore_3
    //   49: new 789	java/io/BufferedReader
    //   52: dup
    //   53: new 791	java/io/InputStreamReader
    //   56: dup
    //   57: new 793	java/io/FileInputStream
    //   60: dup
    //   61: aload 4
    //   63: invokespecial 796	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   66: invokespecial 799	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   69: sipush 8096
    //   72: invokespecial 802	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   75: astore_1
    //   76: aload_1
    //   77: astore_2
    //   78: aload_1
    //   79: invokevirtual 805	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   82: astore_3
    //   83: aload_3
    //   84: ifnull +32 -> 116
    //   87: aload_1
    //   88: astore_2
    //   89: ldc_w 318
    //   92: iconst_1
    //   93: aload_3
    //   94: invokestatic 351	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   97: goto -21 -> 76
    //   100: astore_3
    //   101: aload_1
    //   102: astore_2
    //   103: aload_3
    //   104: invokevirtual 806	java/io/FileNotFoundException:printStackTrace	()V
    //   107: aload_1
    //   108: ifnull +7 -> 115
    //   111: aload_1
    //   112: invokevirtual 809	java/io/BufferedReader:close	()V
    //   115: return
    //   116: aload_1
    //   117: ifnull -2 -> 115
    //   120: aload_1
    //   121: invokevirtual 809	java/io/BufferedReader:close	()V
    //   124: return
    //   125: astore_1
    //   126: aload_1
    //   127: invokevirtual 551	java/lang/Exception:printStackTrace	()V
    //   130: return
    //   131: astore_1
    //   132: aload_1
    //   133: invokevirtual 551	java/lang/Exception:printStackTrace	()V
    //   136: return
    //   137: astore_2
    //   138: aload_3
    //   139: astore_1
    //   140: aload_2
    //   141: astore_3
    //   142: aload_1
    //   143: astore_2
    //   144: aload_3
    //   145: invokevirtual 810	java/io/IOException:printStackTrace	()V
    //   148: aload_1
    //   149: ifnull -34 -> 115
    //   152: aload_1
    //   153: invokevirtual 809	java/io/BufferedReader:close	()V
    //   156: return
    //   157: astore_1
    //   158: aload_1
    //   159: invokevirtual 551	java/lang/Exception:printStackTrace	()V
    //   162: return
    //   163: astore_1
    //   164: aload_2
    //   165: ifnull +7 -> 172
    //   168: aload_2
    //   169: invokevirtual 809	java/io/BufferedReader:close	()V
    //   172: aload_1
    //   173: athrow
    //   174: astore_2
    //   175: aload_2
    //   176: invokevirtual 551	java/lang/Exception:printStackTrace	()V
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
  
  public boolean a()
  {
    if (!this.jdField_a_of_type_Boolean) {}
    while ((!a().whetherReportDuringThisStartup(20)) || (!a().whetherReportThisTime(20))) {
      return false;
    }
    return true;
  }
  
  public void addEvent(int paramInt1, String paramString, int paramInt2, int paramInt3, Map<String, String> paramMap)
  {
    if ((!this.jdField_a_of_type_Boolean) || (!whetherReportDuringThisStartup(paramInt1))) {}
    String str;
    do
    {
      return;
      str = this.jdField_a_of_type_ArrayOfAzry[paramInt1].jdField_a_of_type_JavaLangString;
    } while ((this.jdField_a_of_type_ArrayOfAzry[paramInt1].jdField_c_of_type_Boolean) && (TextUtils.isEmpty(str)));
    Object localObject = paramMap;
    if (paramMap == null) {
      localObject = new HashMap(17);
    }
    ((Map)localObject).put("family", String.valueOf(paramInt1));
    boolean bool;
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
      if (SystemClock.uptimeMillis() - alzh.jdField_a_of_type_Long < 60000L)
      {
        ((Map)localObject).put("totalCpu", String.valueOf(alzh.jdField_a_of_type_Int));
        ((Map)localObject).put("appCpu", String.valueOf(alzh.jdField_a_of_type_Alzj.jdField_a_of_type_Int));
        ((Map)localObject).put("cpu_update_time", String.valueOf((SystemClock.uptimeMillis() - alzh.jdField_a_of_type_Long) / 1000L));
      }
      if (paramInt1 == 0)
      {
        paramString = BaseApplicationImpl.getApplication().getRuntime();
        if ((paramString != null) && ((paramString instanceof QQAppInterface)))
        {
          if (((QQAppInterface)paramString).a.jdField_a_of_type_Long == 0L) {
            break label472;
          }
          bool = true;
          label264:
          ((Map)localObject).put("param_is_logining", String.valueOf(bool));
          if (((QQAppInterface)paramString).a.c()) {
            break label478;
          }
          bool = true;
          label296:
          ((Map)localObject).put("param_syncing_msg", String.valueOf(bool));
        }
        ((Map)localObject).put("max_heap_size", String.valueOf(Runtime.getRuntime().maxMemory()));
        ((Map)localObject).put("currentHeapSize", String.valueOf(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));
      }
      ((Map)localObject).put("wal_enable", String.valueOf(jdField_a_of_type_Int));
      if (!QLog.isColorLevel()) {
        break label484;
      }
      paramString = "-1";
      label386:
      ((Map)localObject).put("not_reported", paramString);
      if (str != null)
      {
        if (str.length() > 950) {
          break label493;
        }
        ((Map)localObject).put("stack", str);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 1, paramInt2, 0, localObject));
      paramString = this.jdField_a_of_type_ArrayOfAzry[paramInt1];
      paramString.g += 1;
      return;
      paramString = "";
      break;
      label472:
      bool = false;
      break label264;
      label478:
      bool = false;
      break label296;
      label484:
      paramString = String.valueOf(paramInt3);
      break label386;
      label493:
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
  
  public void c()
  {
    int i = 0;
    try
    {
      b();
      azru.a(BaseApplicationImpl.getContext());
      ArrayList localArrayList = azru.a(BaseApplicationImpl.getContext());
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
  
  public boolean c()
  {
    return Debug.isDebuggerConnected();
  }
  
  public void d()
  {
    a(PluginCombination.dropFramePlugin, this.jdField_a_of_type_ArrayOfAzry[9]);
    if (BaseApplicationImpl.sProcessId == 2) {
      a(PluginCombination.loopStackPlugin, this.jdField_a_of_type_ArrayOfAzry[14]);
    }
    for (;;)
    {
      a(PluginCombination.resourcePlugin, this.jdField_a_of_type_ArrayOfAzry[20]);
      return;
      if (BaseApplicationImpl.sProcessId == 7) {
        a(PluginCombination.loopStackPlugin, this.jdField_a_of_type_ArrayOfAzry[19]);
      } else {
        a(PluginCombination.loopStackPlugin, this.jdField_a_of_type_ArrayOfAzry[0]);
      }
    }
  }
  
  public int getThreshold(int paramInt)
  {
    return this.jdField_a_of_type_ArrayOfAzry[paramInt].jdField_a_of_type_Int;
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
      int i;
      try
      {
        localObject = (HashMap)paramMessage.obj;
        i = paramMessage.arg1;
        int j = Integer.valueOf((String)((HashMap)localObject).get("family")).intValue();
        if ((j != 0) && (j != 14) && (j != 19)) {
          break label284;
        }
        if (!MagnifierSDK.a()) {
          abwa.a().a((HashMap)localObject, i);
        }
        azri.a(BaseApplicationImpl.getApplication()).a(null, "unifiedMonitor", true, i, 0L, (HashMap)localObject, null);
        return true;
      }
      catch (Throwable paramMessage) {}
      if (!QLog.isColorLevel()) {
        continue;
      }
      paramMessage.printStackTrace();
      return true;
      label284:
      azri.a(BaseApplicationImpl.getApplication()).a(null, "unifiedMonitor", true, i, 0L, (HashMap)localObject, null);
      return true;
      abwa.a().a((HashMap)paramMessage.obj);
      return true;
      addEvent(paramMessage.arg1, "", 3000, -1, a());
      this.jdField_a_of_type_ArrayOfAzry[paramMessage.arg1].jdField_a_of_type_JavaLangString = null;
      return true;
      i();
      f();
      return true;
      this.jdField_a_of_type_ArrayOfAzry[11].jdField_a_of_type_Long = SystemClock.uptimeMillis();
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(5, 2000L);
      return true;
      alzh.a(false);
      if (this.jdField_b_of_type_AndroidOsHandler.hasMessages(7)) {
        continue;
      }
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(6, 1500L);
      return true;
      alzh.b(false);
      paramMessage = (azrz)this.jdField_a_of_type_ArrayOfAzry[11];
      if (whetherReportThisTime(11, true))
      {
        localObject = new HashMap(10);
        ((Map)localObject).put("total_cpu", String.valueOf(alzh.jdField_a_of_type_Int));
        ((Map)localObject).put("app_cpu", String.valueOf(alzh.jdField_a_of_type_Alzj.jdField_a_of_type_Int));
        a().addEvent(11, null, 0, 0, (Map)localObject);
      }
      if ((alzh.jdField_a_of_type_Int >= paramMessage.j) || (alzh.jdField_a_of_type_Alzj.jdField_a_of_type_Int >= paramMessage.k)) {
        if ((QLog.isColorLevel()) && (SystemClock.uptimeMillis() - paramMessage.c > 60000L))
        {
          QLog.d("UnifiedMonitor_QAPM", 2, "totalCpu exceed: " + alzh.jdField_a_of_type_Int + ", appCpu: " + alzh.jdField_a_of_type_Alzj.jdField_a_of_type_Int);
          alzh.a(true);
        }
      }
      try
      {
        Thread.sleep(2000L);
        label606:
        alzh.b(true);
        localObject = alzh.a(paramMessage.l, true).iterator();
        while (((Iterator)localObject).hasNext()) {
          QLog.d("UnifiedMonitor_QAPM", 2, (String)((Iterator)localObject).next());
        }
        QLog.d("UnifiedMonitor_QAPM", 2, alzh.a(10));
        localObject = alzh.a(paramMessage.l, true).iterator();
        while (((Iterator)localObject).hasNext()) {
          QLog.d("UnifiedMonitor_QAPM", 2, (String)((Iterator)localObject).next());
        }
        paramMessage.c = SystemClock.uptimeMillis();
        label719:
        paramMessage.h += 1;
        while ((paramMessage.h < paramMessage.e) && (SystemClock.uptimeMillis() - paramMessage.jdField_a_of_type_Long < paramMessage.f * 1000L))
        {
          this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(5, 2000L);
          return true;
          QLog.d("UnifiedMonitor_QAPM", 1, "totalCpu exceed: " + alzh.jdField_a_of_type_Int + ", appCpu: " + alzh.jdField_a_of_type_Alzj.jdField_a_of_type_Int);
          break label719;
          paramMessage.m = 1;
        }
        this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
        alzh.a(true);
        this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(8, 10000L);
        return true;
        alzh.b(true);
        localObject = (azrz)this.jdField_a_of_type_ArrayOfAzry[11];
        if (!QLog.isColorLevel()) {
          continue;
        }
        localObject = alzh.a(((azrz)localObject).l, true);
        QLog.d("UnifiedMonitor_QAPM", 2, "trace " + paramMessage.obj + "'s cpu end(" + alzh.jdField_a_of_type_Int + ", " + alzh.jdField_a_of_type_Alzj.jdField_a_of_type_Int + ")");
        paramMessage = ((List)localObject).iterator();
        while (paramMessage.hasNext()) {
          QLog.d("UnifiedMonitor_QAPM", 2, (String)paramMessage.next());
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        break label606;
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
    if (this.jdField_a_of_type_ArrayOfAzry[i].g >= this.jdField_a_of_type_ArrayOfAzry[i].jdField_b_of_type_Int)
    {
      this.jdField_c_of_type_AndroidOsHandler.removeMessages(b(paramInt));
      a(i);
      return false;
    }
    paramInt = b(paramInt);
    this.jdField_c_of_type_AndroidOsHandler.removeMessages(paramInt, Thread.currentThread());
    Message localMessage = this.jdField_c_of_type_AndroidOsHandler.obtainMessage(paramInt, Thread.currentThread());
    localMessage.arg1 = i;
    this.jdField_c_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, this.jdField_a_of_type_ArrayOfAzry[i].jdField_a_of_type_Int);
    return true;
  }
  
  public void notifyNotTimeout(int paramInt)
  {
    this.jdField_a_of_type_ArrayOfAzry[paramInt].jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_ArrayOfAzry[paramInt].jdField_a_of_type_JavaLangString = null;
    if ((paramInt == 0) || (paramInt == 10)) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
    }
  }
  
  public void reportStackIfTimeout(int paramInt)
  {
    this.jdField_a_of_type_ArrayOfAzry[paramInt].jdField_b_of_type_Long = SystemClock.uptimeMillis();
    this.jdField_a_of_type_ArrayOfAzry[paramInt].jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_ArrayOfAzry[paramInt].jdField_b_of_type_Boolean = false;
  }
  
  public boolean setMonitoredThread(int paramInt, Thread paramThread, AbstractUnifiedMonitor.ThreadMonitorCallback arg3)
  {
    if ((paramThread == null) || (!this.jdField_a_of_type_ArrayOfAzry[paramInt].jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ArrayOfAzry[paramInt].jdField_a_of_type_ComTencentMobileqqStatisticsUnifiedMonitor$StackGetterJob != null) || (this.jdField_a_of_type_ArrayOfAzry[paramInt].jdField_c_of_type_Int <= 0)) {
      return false;
    }
    QLog.d("UnifiedMonitor_QAPM", 1, "setMonitoredThread for family=" + paramInt);
    synchronized (this.jdField_a_of_type_ArrayOfAzry[paramInt])
    {
      if (this.jdField_a_of_type_ArrayOfAzry[paramInt].jdField_a_of_type_ComTencentMobileqqStatisticsUnifiedMonitor$StackGetterJob == null)
      {
        this.jdField_a_of_type_ArrayOfAzry[paramInt].jdField_a_of_type_ComTencentMobileqqStatisticsUnifiedMonitor$StackGetterJob = new UnifiedMonitor.StackGetterJob(this, paramInt, paramThread);
        ThreadManager.newFreeThread(this.jdField_a_of_type_ArrayOfAzry[paramInt].jdField_a_of_type_ComTencentMobileqqStatisticsUnifiedMonitor$StackGetterJob, "um-stack-fetcher-" + paramInt, 5).start();
        this.jdField_a_of_type_ArrayOfAzry[paramInt].jdField_c_of_type_Boolean = true;
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
    return this.jdField_a_of_type_ArrayOfAzry[paramInt].jdField_a_of_type_Boolean;
  }
  
  public boolean whetherReportThisTime(int paramInt)
  {
    if ((!this.jdField_a_of_type_Boolean) || (!this.jdField_a_of_type_ArrayOfAzry[paramInt].jdField_a_of_type_Boolean)) {
      return false;
    }
    if (this.jdField_a_of_type_ArrayOfAzry[paramInt].jdField_c_of_type_Boolean) {
      return this.jdField_a_of_type_ArrayOfAzry[paramInt].jdField_b_of_type_Boolean;
    }
    return whetherReportThisTime(paramInt, false);
  }
  
  public boolean whetherReportThisTime(int paramInt, boolean paramBoolean)
  {
    float f = this.jdField_a_of_type_ArrayOfAzry[paramInt].jdField_b_of_type_Float;
    if (this.jdField_a_of_type_ArrayOfAzry[paramInt].g >= this.jdField_a_of_type_ArrayOfAzry[paramInt].jdField_b_of_type_Int) {}
    while (Math.random() > f) {
      return false;
    }
    return true;
  }
  
  public boolean whetherStackEnabled(int paramInt)
  {
    return this.jdField_a_of_type_ArrayOfAzry[paramInt].jdField_c_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.UnifiedMonitor
 * JD-Core Version:    0.7.0.1
 */