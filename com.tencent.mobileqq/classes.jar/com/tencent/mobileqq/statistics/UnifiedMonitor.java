package com.tencent.mobileqq.statistics;

import ajlp;
import ajou;
import ajow;
import ajox;
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
import awri;
import awrn;
import awrz;
import awsd;
import awse;
import azzz;
import bgfp;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.monitor.MsfMonitorCallback;
import com.tencent.mobileqq.msf.core.MsfCore;
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
import zqz;
import zrh;

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
  private awsd[] jdField_a_of_type_ArrayOfAwsd = { new awsd(0.001F, 100, 10, 0.1F, 6, 0, 0, 0, false), new awsd(), new awsd(), new awsd(), new awsd(0.001F, 180000, 2, 1.0F, 6, 0, 0, 0, true), new awsd(0.001F, 180000, 2, 1.0F, 6, 0, 0, 0, true), new awsd(0.001F, 1000, 10, 0.001F, 0, 0, 0, 0, false), new awsd(0.001F, 180000, 2, 1.0F, 6, 6, 0, 0, true), new awsd(0.001F, 0, 10, 0.1F, 0, 0, 0, 0, false), new awsd(0.01F, 100, 5, 0.01F, 0, 0, 0, 0, false), new awsd(0.001F, 100, 10, 0.1F, 6, 0, 0, 0, false), new awse(0.0F, 100100005, 1, 0.01F, 0, 0, 2, 300), new awsd(0.01F, 100, 5, 0.01F, 0, 0, 0, 0, false), new awsd(0.001F, 180000, 10, 1.0F, 6, 0, 0, 0, true), new awsd(0.001F, 100, 5, 0.01F, 6, 0, 0, 0, false), new awsd(0.001F, 600000, 2, 1.0F, 6, 0, 0, 0, true), new awsd(0.001F, 180000, 2, 1.0F, 6, 0, 0, 0, true), new awsd(0.001F, 180000, 2, 1.0F, 6, 0, 0, 0, true), new awsd(0.001F, 180000, 2, 1.0F, 6, 0, 0, 0, true), new awsd(0.001F, 100, 5, 0.01F, 6, 0, 0, 0, false), new awsd(0.01F, 100, 10, 0.01F, 0, 0, 0, 0, false) };
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
        String[] arrayOfString = bgfp.c().split("/");
        localHashMap.put("act", arrayOfString[(arrayOfString.length - 1)]);
        return localHashMap;
      }
      catch (Exception localException)
      {
        localHashMap.put("act", "QZoneFriendFeedActivity");
        return localHashMap;
      }
      str = ajox.a();
    } while (str == null);
    localHashMap = new HashMap(8);
    localHashMap.put("act", str);
    return localHashMap;
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_ArrayOfAwsd[paramInt].jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ArrayOfAwsd[paramInt].jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ArrayOfAwsd[paramInt].jdField_a_of_type_ComTencentMobileqqStatisticsUnifiedMonitor$StackGetterJob = null;
    this.jdField_a_of_type_ArrayOfAwsd[paramInt].jdField_c_of_type_Boolean = false;
    if (this.jdField_a_of_type_ArrayOfAwsd[paramInt].jdField_a_of_type_MqqUtilAbstractUnifiedMonitor$ThreadMonitorCallback != null)
    {
      this.jdField_a_of_type_ArrayOfAwsd[paramInt].jdField_a_of_type_MqqUtilAbstractUnifiedMonitor$ThreadMonitorCallback.onThreadMonitorEnd(paramInt);
      this.jdField_a_of_type_ArrayOfAwsd[paramInt].jdField_a_of_type_MqqUtilAbstractUnifiedMonitor$ThreadMonitorCallback = null;
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
  
  public static void d()
  {
    awri.a();
  }
  
  public static boolean d()
  {
    return (QLog.isColorLevel()) || (azzz.c());
  }
  
  private void e()
  {
    new Handler(Looper.getMainLooper()).post(new UnifiedMonitor.1(this));
    if (2 == BaseApplicationImpl.sProcessId) {
      ajlp.b();
    }
    if (4 == BaseApplicationImpl.sProcessId) {
      g();
    }
    if (7 == BaseApplicationImpl.sProcessId) {
      ajlp.h();
    }
    if (1 != BaseApplicationImpl.sProcessId) {
      return;
    }
    if (whetherReportDuringThisStartup(0)) {
      ajlp.a();
    }
    if (whetherReportDuringThisStartup(4)) {
      ajlp.c();
    }
    if (whetherReportDuringThisStartup(5)) {
      ajlp.f();
    }
    if (whetherReportDuringThisStartup(6)) {
      ajlp.g();
    }
    if (whetherReportDuringThisStartup(13)) {
      ajlp.e();
    }
    MainService.setUnifiedMonitorInstance(a());
    f();
  }
  
  private final void f()
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
  
  private void g()
  {
    int i = 0;
    if (MsfCore.sCore != null) {
      if ((whetherReportDuringThisStartup(17)) || (whetherReportDuringThisStartup(15)) || (whetherReportDuringThisStartup(16)))
      {
        QLog.d("UnifiedMonitor", 1, new Object[] { "setMsfMonitorCallback, ", Boolean.valueOf(whetherReportDuringThisStartup(17)), ", ", Boolean.valueOf(whetherReportDuringThisStartup(15)), ", ", Boolean.valueOf(whetherReportDuringThisStartup(16)) });
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
        ajlp.d();
      }
      return;
      QLog.e("UnifiedMonitor", 1, "MsfCore.sCore is null");
    }
  }
  
  /* Error */
  private void h()
  {
    // Byte code:
    //   0: invokestatic 333	com/tencent/mobileqq/app/DeviceProfileManager:a	()Lcom/tencent/mobileqq/app/DeviceProfileManager;
    //   3: getstatic 339	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:unified_monitor_params	Lcom/tencent/mobileqq/app/DeviceProfileManager$DpcNames;
    //   6: invokevirtual 342	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:name	()Ljava/lang/String;
    //   9: invokevirtual 345	com/tencent/mobileqq/app/DeviceProfileManager:a	(Ljava/lang/String;)Ljava/lang/String;
    //   12: astore 8
    //   14: ldc_w 291
    //   17: iconst_1
    //   18: new 347	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 348	java/lang/StringBuilder:<init>	()V
    //   25: ldc_w 350
    //   28: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: aload 8
    //   33: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 357	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 359	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   42: aload 8
    //   44: ifnull +586 -> 630
    //   47: aload 8
    //   49: ldc_w 361
    //   52: invokevirtual 130	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   55: astore 10
    //   57: aload 10
    //   59: ifnonnull +20 -> 79
    //   62: aload_0
    //   63: monitorenter
    //   64: aload_0
    //   65: iconst_1
    //   66: putfield 362	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_Boolean	Z
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
    //   85: istore_2
    //   86: iload_2
    //   87: iload 5
    //   89: if_icmpge +541 -> 630
    //   92: aload 10
    //   94: iload_2
    //   95: aaload
    //   96: astore 8
    //   98: aload 8
    //   100: ldc_w 364
    //   103: invokevirtual 130	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   106: astore 11
    //   108: aload 11
    //   110: ifnull +1126 -> 1236
    //   113: aload 11
    //   115: arraylength
    //   116: iconst_2
    //   117: if_icmpne +1119 -> 1236
    //   120: aload 11
    //   122: iconst_0
    //   123: aaload
    //   124: invokestatic 370	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   127: ifne +1109 -> 1236
    //   130: aload 11
    //   132: iconst_1
    //   133: aaload
    //   134: invokestatic 370	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   137: ifne +1099 -> 1236
    //   140: aload 11
    //   142: iconst_0
    //   143: aaload
    //   144: bipush 95
    //   146: invokevirtual 373	java/lang/String:lastIndexOf	(I)I
    //   149: istore 6
    //   151: iload 6
    //   153: iconst_m1
    //   154: if_icmpeq +1089 -> 1243
    //   157: aload 11
    //   159: iconst_0
    //   160: aaload
    //   161: iconst_0
    //   162: iload 6
    //   164: iconst_1
    //   165: iadd
    //   166: invokevirtual 377	java/lang/String:substring	(II)Ljava/lang/String;
    //   169: astore 8
    //   171: iload 6
    //   173: iconst_m1
    //   174: if_icmpeq +1075 -> 1249
    //   177: iload 6
    //   179: aload 11
    //   181: iconst_0
    //   182: aaload
    //   183: invokevirtual 381	java/lang/String:length	()I
    //   186: iconst_1
    //   187: isub
    //   188: if_icmpge +1061 -> 1249
    //   191: aload 11
    //   193: iconst_0
    //   194: aaload
    //   195: iload 6
    //   197: iconst_1
    //   198: iadd
    //   199: invokevirtual 383	java/lang/String:substring	(I)Ljava/lang/String;
    //   202: astore 9
    //   204: iconst_m1
    //   205: istore_3
    //   206: aload 9
    //   208: invokestatic 388	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   211: invokevirtual 391	java/lang/Integer:intValue	()I
    //   214: istore 4
    //   216: iload 4
    //   218: istore_3
    //   219: invokestatic 197	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   222: ifeq +67 -> 289
    //   225: ldc_w 291
    //   228: iconst_2
    //   229: new 347	java/lang/StringBuilder
    //   232: dup
    //   233: invokespecial 348	java/lang/StringBuilder:<init>	()V
    //   236: ldc_w 393
    //   239: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: iload_3
    //   243: invokevirtual 396	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   246: ldc_w 398
    //   249: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: aload 8
    //   254: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: ldc_w 400
    //   260: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: aload 11
    //   265: iconst_0
    //   266: aaload
    //   267: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: ldc_w 402
    //   273: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: aload 11
    //   278: iconst_1
    //   279: aaload
    //   280: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: invokevirtual 357	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   286: invokestatic 359	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   289: aload 8
    //   291: ifnull +945 -> 1236
    //   294: iload 6
    //   296: iconst_m1
    //   297: if_icmpeq +939 -> 1236
    //   300: iload_3
    //   301: iconst_m1
    //   302: if_icmpeq +934 -> 1236
    //   305: aload 9
    //   307: ifnull +929 -> 1236
    //   310: iload_3
    //   311: bipush 21
    //   313: if_icmpge +923 -> 1236
    //   316: ldc_w 404
    //   319: aload 8
    //   321: invokevirtual 408	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   324: ifeq +25 -> 349
    //   327: aload_0
    //   328: getfield 95	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfAwsd	[Lawsd;
    //   331: iload_3
    //   332: aaload
    //   333: aload 11
    //   335: iconst_1
    //   336: aaload
    //   337: invokestatic 413	java/lang/Float:valueOf	(Ljava/lang/String;)Ljava/lang/Float;
    //   340: invokevirtual 417	java/lang/Float:floatValue	()F
    //   343: putfield 420	awsd:jdField_a_of_type_Float	F
    //   346: goto +890 -> 1236
    //   349: ldc_w 422
    //   352: aload 8
    //   354: invokevirtual 408	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   357: ifeq +85 -> 442
    //   360: aload_0
    //   361: getfield 95	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfAwsd	[Lawsd;
    //   364: iload_3
    //   365: aaload
    //   366: aload 11
    //   368: iconst_1
    //   369: aaload
    //   370: invokestatic 388	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   373: invokevirtual 391	java/lang/Integer:intValue	()I
    //   376: putfield 424	awsd:jdField_b_of_type_Int	I
    //   379: goto +857 -> 1236
    //   382: astore 8
    //   384: invokestatic 197	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   387: ifeq +849 -> 1236
    //   390: ldc_w 291
    //   393: iconst_2
    //   394: ldc_w 426
    //   397: aload 8
    //   399: invokestatic 429	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   402: goto +834 -> 1236
    //   405: astore 8
    //   407: invokestatic 197	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   410: ifeq +15 -> 425
    //   413: ldc_w 291
    //   416: iconst_2
    //   417: ldc_w 426
    //   420: aload 8
    //   422: invokestatic 431	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   425: aload_0
    //   426: monitorenter
    //   427: aload_0
    //   428: iconst_1
    //   429: putfield 362	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_Boolean	Z
    //   432: aload_0
    //   433: monitorexit
    //   434: return
    //   435: astore 8
    //   437: aload_0
    //   438: monitorexit
    //   439: aload 8
    //   441: athrow
    //   442: ldc_w 433
    //   445: aload 8
    //   447: invokevirtual 408	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   450: ifeq +39 -> 489
    //   453: aload_0
    //   454: getfield 95	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfAwsd	[Lawsd;
    //   457: iload_3
    //   458: aaload
    //   459: aload 11
    //   461: iconst_1
    //   462: aaload
    //   463: invokestatic 388	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   466: invokevirtual 391	java/lang/Integer:intValue	()I
    //   469: putfield 434	awsd:jdField_a_of_type_Int	I
    //   472: goto +764 -> 1236
    //   475: astore 8
    //   477: aload_0
    //   478: monitorenter
    //   479: aload_0
    //   480: iconst_1
    //   481: putfield 362	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_Boolean	Z
    //   484: aload_0
    //   485: monitorexit
    //   486: aload 8
    //   488: athrow
    //   489: ldc_w 436
    //   492: aload 8
    //   494: invokevirtual 408	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   497: ifeq +26 -> 523
    //   500: aload_0
    //   501: getfield 95	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfAwsd	[Lawsd;
    //   504: iload_3
    //   505: aaload
    //   506: aload 11
    //   508: iconst_1
    //   509: aaload
    //   510: invokestatic 388	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   513: invokevirtual 391	java/lang/Integer:intValue	()I
    //   516: i2f
    //   517: putfield 438	awsd:jdField_b_of_type_Float	F
    //   520: goto +716 -> 1236
    //   523: ldc_w 440
    //   526: aload 8
    //   528: invokevirtual 408	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   531: ifeq +33 -> 564
    //   534: getstatic 445	android/os/Build$VERSION:SDK_INT	I
    //   537: bipush 17
    //   539: if_icmpeq +697 -> 1236
    //   542: aload_0
    //   543: getfield 95	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfAwsd	[Lawsd;
    //   546: iload_3
    //   547: aaload
    //   548: aload 11
    //   550: iconst_1
    //   551: aaload
    //   552: invokestatic 388	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   555: invokevirtual 391	java/lang/Integer:intValue	()I
    //   558: putfield 447	awsd:jdField_c_of_type_Int	I
    //   561: goto +675 -> 1236
    //   564: ldc_w 449
    //   567: aload 8
    //   569: invokevirtual 408	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   572: ifeq +25 -> 597
    //   575: aload_0
    //   576: getfield 95	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfAwsd	[Lawsd;
    //   579: iload_3
    //   580: aaload
    //   581: aload 11
    //   583: iconst_1
    //   584: aaload
    //   585: invokestatic 388	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   588: invokevirtual 391	java/lang/Integer:intValue	()I
    //   591: putfield 451	awsd:jdField_d_of_type_Int	I
    //   594: goto +642 -> 1236
    //   597: ldc_w 453
    //   600: aload 8
    //   602: invokevirtual 408	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   605: ifeq +631 -> 1236
    //   608: aload_0
    //   609: getfield 95	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfAwsd	[Lawsd;
    //   612: iload_3
    //   613: aaload
    //   614: aload 11
    //   616: iconst_1
    //   617: aaload
    //   618: invokestatic 456	java/lang/Boolean:valueOf	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   621: invokevirtual 459	java/lang/Boolean:booleanValue	()Z
    //   624: putfield 461	awsd:jdField_d_of_type_Boolean	Z
    //   627: goto +609 -> 1236
    //   630: iconst_0
    //   631: istore_2
    //   632: iload_2
    //   633: aload_0
    //   634: getfield 95	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfAwsd	[Lawsd;
    //   637: arraylength
    //   638: if_icmpge +20 -> 658
    //   641: aload_0
    //   642: getfield 95	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfAwsd	[Lawsd;
    //   645: iload_2
    //   646: aaload
    //   647: iload_2
    //   648: invokevirtual 462	awsd:a	(I)V
    //   651: iload_2
    //   652: iconst_1
    //   653: iadd
    //   654: istore_2
    //   655: goto -23 -> 632
    //   658: aload_0
    //   659: getfield 95	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfAwsd	[Lawsd;
    //   662: bipush 10
    //   664: aaload
    //   665: iconst_0
    //   666: putfield 146	awsd:jdField_a_of_type_Boolean	Z
    //   669: invokestatic 197	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   672: ifeq +53 -> 725
    //   675: aload_0
    //   676: getfield 95	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfAwsd	[Lawsd;
    //   679: iconst_0
    //   680: aaload
    //   681: iconst_1
    //   682: putfield 146	awsd:jdField_a_of_type_Boolean	Z
    //   685: aload_0
    //   686: getfield 95	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfAwsd	[Lawsd;
    //   689: iconst_0
    //   690: aaload
    //   691: ldc_w 463
    //   694: putfield 424	awsd:jdField_b_of_type_Int	I
    //   697: aload_0
    //   698: getfield 95	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfAwsd	[Lawsd;
    //   701: iconst_0
    //   702: aaload
    //   703: fconst_1
    //   704: putfield 438	awsd:jdField_b_of_type_Float	F
    //   707: invokestatic 197	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   710: ifeq +15 -> 725
    //   713: aload_0
    //   714: getfield 95	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfAwsd	[Lawsd;
    //   717: iconst_0
    //   718: aaload
    //   719: sipush 200
    //   722: putfield 434	awsd:jdField_a_of_type_Int	I
    //   725: aload_0
    //   726: getfield 95	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfAwsd	[Lawsd;
    //   729: bipush 14
    //   731: aaload
    //   732: invokestatic 469	common/config/service/QzoneConfig:getInstance	()Lcommon/config/service/QzoneConfig;
    //   735: ldc_w 471
    //   738: ldc_w 473
    //   741: aload_0
    //   742: getfield 95	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfAwsd	[Lawsd;
    //   745: bipush 14
    //   747: aaload
    //   748: getfield 434	awsd:jdField_a_of_type_Int	I
    //   751: invokevirtual 477	common/config/service/QzoneConfig:getConfig	(Ljava/lang/String;Ljava/lang/String;I)I
    //   754: putfield 434	awsd:jdField_a_of_type_Int	I
    //   757: invokestatic 469	common/config/service/QzoneConfig:getInstance	()Lcommon/config/service/QzoneConfig;
    //   760: ldc_w 471
    //   763: ldc_w 479
    //   766: invokevirtual 482	common/config/service/QzoneConfig:getConfig	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   769: astore 9
    //   771: invokestatic 469	common/config/service/QzoneConfig:getInstance	()Lcommon/config/service/QzoneConfig;
    //   774: ldc_w 471
    //   777: ldc_w 484
    //   780: invokevirtual 482	common/config/service/QzoneConfig:getConfig	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   783: astore 8
    //   785: aload 9
    //   787: invokestatic 370	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   790: istore 7
    //   792: iload 7
    //   794: ifne +29 -> 823
    //   797: aload 9
    //   799: invokestatic 413	java/lang/Float:valueOf	(Ljava/lang/String;)Ljava/lang/Float;
    //   802: invokevirtual 417	java/lang/Float:floatValue	()F
    //   805: fstore_1
    //   806: fload_1
    //   807: fconst_0
    //   808: fcmpl
    //   809: iflt +14 -> 823
    //   812: aload_0
    //   813: getfield 95	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfAwsd	[Lawsd;
    //   816: bipush 14
    //   818: aaload
    //   819: fload_1
    //   820: putfield 420	awsd:jdField_a_of_type_Float	F
    //   823: aload 8
    //   825: invokestatic 370	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   828: istore 7
    //   830: iload 7
    //   832: ifne +29 -> 861
    //   835: aload 8
    //   837: invokestatic 413	java/lang/Float:valueOf	(Ljava/lang/String;)Ljava/lang/Float;
    //   840: invokevirtual 417	java/lang/Float:floatValue	()F
    //   843: fstore_1
    //   844: fload_1
    //   845: fconst_0
    //   846: fcmpl
    //   847: iflt +14 -> 861
    //   850: aload_0
    //   851: getfield 95	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfAwsd	[Lawsd;
    //   854: bipush 14
    //   856: aaload
    //   857: fload_1
    //   858: putfield 438	awsd:jdField_b_of_type_Float	F
    //   861: getstatic 114	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   864: iconst_4
    //   865: if_icmpne +3 -> 868
    //   868: getstatic 114	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   871: iconst_1
    //   872: if_icmpne +14 -> 886
    //   875: aload_0
    //   876: getfield 95	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfAwsd	[Lawsd;
    //   879: bipush 11
    //   881: aaload
    //   882: iconst_0
    //   883: putfield 146	awsd:jdField_a_of_type_Boolean	Z
    //   886: invokestatic 201	azzz:c	()Z
    //   889: ifeq +64 -> 953
    //   892: getstatic 114	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   895: iconst_1
    //   896: if_icmpne +246 -> 1142
    //   899: aload_0
    //   900: getfield 95	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfAwsd	[Lawsd;
    //   903: iconst_4
    //   904: aaload
    //   905: getfield 146	awsd:jdField_a_of_type_Boolean	Z
    //   908: ifeq +234 -> 1142
    //   911: new 116	java/util/HashMap
    //   914: dup
    //   915: iconst_2
    //   916: invokespecial 119	java/util/HashMap:<init>	(I)V
    //   919: astore 8
    //   921: aload 8
    //   923: ldc_w 486
    //   926: iconst_1
    //   927: invokestatic 488	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   930: invokevirtual 136	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   933: pop
    //   934: invokestatic 492	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   937: invokestatic 497	awrn:a	(Landroid/content/Context;)Lawrn;
    //   940: aconst_null
    //   941: ldc_w 499
    //   944: iconst_1
    //   945: lconst_0
    //   946: lconst_0
    //   947: aload 8
    //   949: aconst_null
    //   950: invokevirtual 502	awrn:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   953: ldc_w 291
    //   956: iconst_1
    //   957: new 347	java/lang/StringBuilder
    //   960: dup
    //   961: invokespecial 348	java/lang/StringBuilder:<init>	()V
    //   964: ldc_w 504
    //   967: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   970: invokestatic 201	azzz:c	()Z
    //   973: invokevirtual 507	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   976: ldc_w 509
    //   979: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   982: invokestatic 197	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   985: invokevirtual 507	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   988: invokevirtual 357	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   991: invokestatic 359	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   994: iconst_0
    //   995: istore_2
    //   996: aload_0
    //   997: getfield 95	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfAwsd	[Lawsd;
    //   1000: arraylength
    //   1001: istore_3
    //   1002: iload_2
    //   1003: iload_3
    //   1004: if_icmpge +203 -> 1207
    //   1007: aload_0
    //   1008: getfield 95	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfAwsd	[Lawsd;
    //   1011: iload_2
    //   1012: aaload
    //   1013: astore 8
    //   1015: ldc_w 291
    //   1018: iconst_1
    //   1019: new 347	java/lang/StringBuilder
    //   1022: dup
    //   1023: invokespecial 348	java/lang/StringBuilder:<init>	()V
    //   1026: ldc_w 511
    //   1029: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1032: iload_2
    //   1033: invokestatic 513	com/tencent/mobileqq/statistics/UnifiedMonitor:a	(I)Ljava/lang/String;
    //   1036: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1039: ldc_w 515
    //   1042: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1045: aload 8
    //   1047: getfield 146	awsd:jdField_a_of_type_Boolean	Z
    //   1050: invokevirtual 507	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1053: ldc_w 517
    //   1056: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1059: aload 8
    //   1061: getfield 438	awsd:jdField_b_of_type_Float	F
    //   1064: invokevirtual 520	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   1067: ldc_w 522
    //   1070: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1073: aload 8
    //   1075: getfield 420	awsd:jdField_a_of_type_Float	F
    //   1078: invokevirtual 520	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   1081: ldc_w 524
    //   1084: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1087: aload 8
    //   1089: getfield 424	awsd:jdField_b_of_type_Int	I
    //   1092: invokevirtual 396	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1095: ldc_w 526
    //   1098: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1101: aload 8
    //   1103: getfield 434	awsd:jdField_a_of_type_Int	I
    //   1106: invokevirtual 396	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1109: invokevirtual 357	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1112: invokestatic 359	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1115: iload_2
    //   1116: iconst_1
    //   1117: iadd
    //   1118: istore_2
    //   1119: goto -117 -> 1002
    //   1122: astore 9
    //   1124: aload 9
    //   1126: invokevirtual 529	java/lang/Exception:printStackTrace	()V
    //   1129: goto -306 -> 823
    //   1132: astore 8
    //   1134: aload 8
    //   1136: invokevirtual 529	java/lang/Exception:printStackTrace	()V
    //   1139: goto -278 -> 861
    //   1142: getstatic 114	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   1145: iconst_4
    //   1146: if_icmpne -193 -> 953
    //   1149: aload_0
    //   1150: getfield 95	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfAwsd	[Lawsd;
    //   1153: bipush 15
    //   1155: aaload
    //   1156: getfield 146	awsd:jdField_a_of_type_Boolean	Z
    //   1159: ifeq -206 -> 953
    //   1162: new 116	java/util/HashMap
    //   1165: dup
    //   1166: iconst_2
    //   1167: invokespecial 119	java/util/HashMap:<init>	(I)V
    //   1170: astore 8
    //   1172: aload 8
    //   1174: ldc_w 486
    //   1177: iconst_2
    //   1178: invokestatic 488	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1181: invokevirtual 136	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1184: pop
    //   1185: invokestatic 492	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   1188: invokestatic 497	awrn:a	(Landroid/content/Context;)Lawrn;
    //   1191: aconst_null
    //   1192: ldc_w 499
    //   1195: iconst_1
    //   1196: lconst_0
    //   1197: lconst_0
    //   1198: aload 8
    //   1200: aconst_null
    //   1201: invokevirtual 502	awrn:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   1204: goto -251 -> 953
    //   1207: aload_0
    //   1208: monitorenter
    //   1209: aload_0
    //   1210: iconst_1
    //   1211: putfield 362	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_Boolean	Z
    //   1214: aload_0
    //   1215: monitorexit
    //   1216: return
    //   1217: astore 8
    //   1219: aload_0
    //   1220: monitorexit
    //   1221: aload 8
    //   1223: athrow
    //   1224: astore 8
    //   1226: aload_0
    //   1227: monitorexit
    //   1228: aload 8
    //   1230: athrow
    //   1231: astore 12
    //   1233: goto -1014 -> 219
    //   1236: iload_2
    //   1237: iconst_1
    //   1238: iadd
    //   1239: istore_2
    //   1240: goto -1154 -> 86
    //   1243: aconst_null
    //   1244: astore 8
    //   1246: goto -1075 -> 171
    //   1249: aconst_null
    //   1250: astore 9
    //   1252: goto -1048 -> 204
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1255	0	this	UnifiedMonitor
    //   805	53	1	f	float
    //   85	1155	2	i	int
    //   205	800	3	j	int
    //   214	3	4	k	int
    //   82	8	5	m	int
    //   149	149	6	n	int
    //   790	41	7	bool	boolean
    //   12	36	8	str1	String
    //   72	5	8	localObject1	Object
    //   96	257	8	str2	String
    //   382	16	8	localThrowable1	Throwable
    //   405	16	8	localThrowable2	Throwable
    //   435	11	8	localObject2	Object
    //   475	126	8	localObject3	Object
    //   783	319	8	localObject4	Object
    //   1132	3	8	localException1	Exception
    //   1170	29	8	localHashMap	HashMap
    //   1217	5	8	localObject5	Object
    //   1224	5	8	localObject6	Object
    //   1244	1	8	localObject7	Object
    //   202	596	9	str3	String
    //   1122	3	9	localException2	Exception
    //   1250	1	9	localObject8	Object
    //   55	38	10	arrayOfString1	String[]
    //   106	509	11	arrayOfString2	String[]
    //   1231	1	12	localNumberFormatException	java.lang.NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   64	71	72	finally
    //   74	76	72	finally
    //   98	108	382	java/lang/Throwable
    //   113	151	382	java/lang/Throwable
    //   157	171	382	java/lang/Throwable
    //   177	204	382	java/lang/Throwable
    //   206	216	382	java/lang/Throwable
    //   219	289	382	java/lang/Throwable
    //   316	346	382	java/lang/Throwable
    //   349	379	382	java/lang/Throwable
    //   442	472	382	java/lang/Throwable
    //   489	520	382	java/lang/Throwable
    //   523	561	382	java/lang/Throwable
    //   564	594	382	java/lang/Throwable
    //   597	627	382	java/lang/Throwable
    //   0	42	405	java/lang/Throwable
    //   47	57	405	java/lang/Throwable
    //   79	84	405	java/lang/Throwable
    //   384	402	405	java/lang/Throwable
    //   632	651	405	java/lang/Throwable
    //   658	725	405	java/lang/Throwable
    //   725	792	405	java/lang/Throwable
    //   797	806	405	java/lang/Throwable
    //   812	823	405	java/lang/Throwable
    //   823	830	405	java/lang/Throwable
    //   835	844	405	java/lang/Throwable
    //   850	861	405	java/lang/Throwable
    //   861	868	405	java/lang/Throwable
    //   868	886	405	java/lang/Throwable
    //   886	953	405	java/lang/Throwable
    //   953	994	405	java/lang/Throwable
    //   996	1002	405	java/lang/Throwable
    //   1007	1115	405	java/lang/Throwable
    //   1124	1129	405	java/lang/Throwable
    //   1134	1139	405	java/lang/Throwable
    //   1142	1204	405	java/lang/Throwable
    //   427	434	435	finally
    //   437	439	435	finally
    //   0	42	475	finally
    //   47	57	475	finally
    //   79	84	475	finally
    //   98	108	475	finally
    //   113	151	475	finally
    //   157	171	475	finally
    //   177	204	475	finally
    //   206	216	475	finally
    //   219	289	475	finally
    //   316	346	475	finally
    //   349	379	475	finally
    //   384	402	475	finally
    //   407	425	475	finally
    //   442	472	475	finally
    //   489	520	475	finally
    //   523	561	475	finally
    //   564	594	475	finally
    //   597	627	475	finally
    //   632	651	475	finally
    //   658	725	475	finally
    //   725	792	475	finally
    //   797	806	475	finally
    //   812	823	475	finally
    //   823	830	475	finally
    //   835	844	475	finally
    //   850	861	475	finally
    //   861	868	475	finally
    //   868	886	475	finally
    //   886	953	475	finally
    //   953	994	475	finally
    //   996	1002	475	finally
    //   1007	1115	475	finally
    //   1124	1129	475	finally
    //   1134	1139	475	finally
    //   1142	1204	475	finally
    //   797	806	1122	java/lang/Exception
    //   812	823	1122	java/lang/Exception
    //   835	844	1132	java/lang/Exception
    //   850	861	1132	java/lang/Exception
    //   1209	1216	1217	finally
    //   1219	1221	1217	finally
    //   479	486	1224	finally
    //   1226	1228	1224	finally
    //   206	216	1231	java/lang/NumberFormatException
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
      QLog.e("UnifiedMonitor", 1, "skip issue caused by debugger");
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
          QLog.d("UnifiedMonitor", 2, new Object[] { "report msf interval is small, ", Long.valueOf(l) });
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
        str = awrz.a(String.valueOf(paramInt));
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
            QLog.e("UnifiedMonitor", 1, "", localException);
            l = 0L;
            continue;
            i = 0;
            continue;
            i = 0;
            continue;
            bool1 = false;
          }
          localawrn = awrn.a(BaseApplicationImpl.getApplication());
          if (j != 1) {
            break label881;
          }
        }
        localStringBuilder.append(l).append("|").append(this.jdField_b_of_type_JavaLangString).append("|").append(this.jdField_c_of_type_JavaLangString);
        localStringBuilder.append("|").append(this.jdField_a_of_type_JavaLangString).append("|").append(System.currentTimeMillis());
        localStringBuilder.append("|").append(paramInt).append("|").append(Build.MODEL).append("|").append(Build.VERSION.RELEASE);
        localStringBuilder.append("|").append("monitorThread=").append(paramThread.getName()).append(",tid=").append(paramThread.getId()).append(",state=").append(paramThread.getState());
        localStringBuilder.append(awrz.a());
        localStringBuilder.append(awrz.b());
        l = SystemClock.uptimeMillis();
        j = awrz.a(BaseApplicationImpl.getContext(), str, localStringBuilder.toString());
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
      for (boolean bool1 = awrz.a(str, localStringBuilder.toString());; bool1 = true)
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
            QLog.e("UnifiedMonitor", 1, "report stack file for " + paramInt);
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
          paramThread = this.jdField_a_of_type_ArrayOfAwsd[paramInt];
          paramThread.g += 1;
          return;
          localObject = ((QQAppInterface)BaseApplicationImpl.getApplication().waitAppRuntime(null)).getAccount();
          break;
          awrn localawrn;
          for (boolean bool2 = true;; bool2 = false)
          {
            localawrn.a(null, "event_held_thread", bool2, l, 0L, paramThread, null);
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
          awrn.a(BaseApplicationImpl.getApplication()).a(null, "event_held_thread", false, 0L, 0L, paramThread, null);
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
    //   0: new 173	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 178	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore 4
    //   10: aload 4
    //   12: invokevirtual 756	java/io/File:exists	()Z
    //   15: ifeq +100 -> 115
    //   18: ldc_w 291
    //   21: iconst_1
    //   22: new 347	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 348	java/lang/StringBuilder:<init>	()V
    //   29: ldc_w 758
    //   32: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_1
    //   36: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 357	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 324	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   45: aconst_null
    //   46: astore_2
    //   47: aconst_null
    //   48: astore_3
    //   49: new 760	java/io/BufferedReader
    //   52: dup
    //   53: new 762	java/io/InputStreamReader
    //   56: dup
    //   57: new 764	java/io/FileInputStream
    //   60: dup
    //   61: aload 4
    //   63: invokespecial 767	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   66: invokespecial 770	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   69: sipush 8096
    //   72: invokespecial 773	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   75: astore_1
    //   76: aload_1
    //   77: astore_2
    //   78: aload_1
    //   79: invokevirtual 776	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   82: astore_3
    //   83: aload_3
    //   84: ifnull +32 -> 116
    //   87: aload_1
    //   88: astore_2
    //   89: ldc_w 291
    //   92: iconst_1
    //   93: aload_3
    //   94: invokestatic 324	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   97: goto -21 -> 76
    //   100: astore_3
    //   101: aload_1
    //   102: astore_2
    //   103: aload_3
    //   104: invokevirtual 777	java/io/FileNotFoundException:printStackTrace	()V
    //   107: aload_1
    //   108: ifnull +7 -> 115
    //   111: aload_1
    //   112: invokevirtual 780	java/io/BufferedReader:close	()V
    //   115: return
    //   116: aload_1
    //   117: ifnull -2 -> 115
    //   120: aload_1
    //   121: invokevirtual 780	java/io/BufferedReader:close	()V
    //   124: return
    //   125: astore_1
    //   126: aload_1
    //   127: invokevirtual 529	java/lang/Exception:printStackTrace	()V
    //   130: return
    //   131: astore_1
    //   132: aload_1
    //   133: invokevirtual 529	java/lang/Exception:printStackTrace	()V
    //   136: return
    //   137: astore_2
    //   138: aload_3
    //   139: astore_1
    //   140: aload_2
    //   141: astore_3
    //   142: aload_1
    //   143: astore_2
    //   144: aload_3
    //   145: invokevirtual 781	java/io/IOException:printStackTrace	()V
    //   148: aload_1
    //   149: ifnull -34 -> 115
    //   152: aload_1
    //   153: invokevirtual 780	java/io/BufferedReader:close	()V
    //   156: return
    //   157: astore_1
    //   158: aload_1
    //   159: invokevirtual 529	java/lang/Exception:printStackTrace	()V
    //   162: return
    //   163: astore_1
    //   164: aload_2
    //   165: ifnull +7 -> 172
    //   168: aload_2
    //   169: invokevirtual 780	java/io/BufferedReader:close	()V
    //   172: aload_1
    //   173: athrow
    //   174: astore_2
    //   175: aload_2
    //   176: invokevirtual 529	java/lang/Exception:printStackTrace	()V
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
    boolean bool = true;
    if (!this.jdField_a_of_type_Boolean) {}
    do
    {
      bool = false;
      do
      {
        return bool;
        if ((!a().whetherReportDuringThisStartup(20)) || (!a().whetherReportThisTime(20))) {
          break;
        }
      } while (!zrh.a().a());
    } while (!b());
    return true;
  }
  
  public void addEvent(int paramInt1, String paramString, int paramInt2, int paramInt3, Map<String, String> paramMap)
  {
    if ((!this.jdField_a_of_type_Boolean) || (!whetherReportDuringThisStartup(paramInt1))) {}
    String str;
    do
    {
      return;
      str = this.jdField_a_of_type_ArrayOfAwsd[paramInt1].jdField_a_of_type_JavaLangString;
    } while ((this.jdField_a_of_type_ArrayOfAwsd[paramInt1].jdField_c_of_type_Boolean) && (TextUtils.isEmpty(str)));
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
      if (SystemClock.uptimeMillis() - ajou.jdField_a_of_type_Long < 60000L)
      {
        ((Map)localObject).put("totalCpu", String.valueOf(ajou.jdField_a_of_type_Int));
        ((Map)localObject).put("appCpu", String.valueOf(ajou.jdField_a_of_type_Ajow.jdField_a_of_type_Int));
        ((Map)localObject).put("cpu_update_time", String.valueOf((SystemClock.uptimeMillis() - ajou.jdField_a_of_type_Long) / 1000L));
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
      paramString = this.jdField_a_of_type_ArrayOfAwsd[paramInt1];
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
      awrz.a(BaseApplicationImpl.getContext());
      ArrayList localArrayList = awrz.a(BaseApplicationImpl.getContext());
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
        QLog.d("UnifiedMonitor", 2, "", localException);
      }
    }
  }
  
  public boolean c()
  {
    return Debug.isDebuggerConnected();
  }
  
  public int getThreshold(int paramInt)
  {
    return this.jdField_a_of_type_ArrayOfAwsd[paramInt].jdField_a_of_type_Int;
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
      QLog.e("UnifiedMonitor", 1, paramMessage.arg1 + ", " + paramMessage.obj + " held: " + Arrays.toString(((Thread)paramMessage.obj).getStackTrace()));
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
          break label278;
        }
        zqz.a().a((HashMap)localObject, i);
        awrn.a(BaseApplicationImpl.getApplication()).a(null, "unifiedMonitor", true, i, 0L, (HashMap)localObject, null);
        return true;
      }
      catch (Throwable paramMessage) {}
      if (!QLog.isColorLevel()) {
        continue;
      }
      paramMessage.printStackTrace();
      return true;
      label278:
      awrn.a(BaseApplicationImpl.getApplication()).a(null, "unifiedMonitor", true, i, 0L, (HashMap)localObject, null);
      return true;
      zqz.a().a((HashMap)paramMessage.obj);
      return true;
      addEvent(paramMessage.arg1, "", 3000, -1, a());
      this.jdField_a_of_type_ArrayOfAwsd[paramMessage.arg1].jdField_a_of_type_JavaLangString = null;
      return true;
      h();
      e();
      return true;
      this.jdField_a_of_type_ArrayOfAwsd[11].jdField_a_of_type_Long = SystemClock.uptimeMillis();
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(5, 2000L);
      return true;
      ajou.a(false);
      if (this.jdField_b_of_type_AndroidOsHandler.hasMessages(7)) {
        continue;
      }
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(6, 1500L);
      return true;
      ajou.b(false);
      paramMessage = (awse)this.jdField_a_of_type_ArrayOfAwsd[11];
      if (whetherReportThisTime(11, true))
      {
        localObject = new HashMap(10);
        ((Map)localObject).put("total_cpu", String.valueOf(ajou.jdField_a_of_type_Int));
        ((Map)localObject).put("app_cpu", String.valueOf(ajou.jdField_a_of_type_Ajow.jdField_a_of_type_Int));
        a().addEvent(11, null, 0, 0, (Map)localObject);
      }
      if ((ajou.jdField_a_of_type_Int >= paramMessage.j) || (ajou.jdField_a_of_type_Ajow.jdField_a_of_type_Int >= paramMessage.k)) {
        if ((QLog.isColorLevel()) && (SystemClock.uptimeMillis() - paramMessage.c > 60000L))
        {
          QLog.d("UnifiedMonitor", 2, "totalCpu exceed: " + ajou.jdField_a_of_type_Int + ", appCpu: " + ajou.jdField_a_of_type_Ajow.jdField_a_of_type_Int);
          ajou.a(true);
        }
      }
      try
      {
        Thread.sleep(2000L);
        label600:
        ajou.b(true);
        localObject = ajou.a(paramMessage.l, true).iterator();
        while (((Iterator)localObject).hasNext()) {
          QLog.d("UnifiedMonitor", 2, (String)((Iterator)localObject).next());
        }
        QLog.d("UnifiedMonitor", 2, ajou.a(10));
        localObject = ajou.a(paramMessage.l, true).iterator();
        while (((Iterator)localObject).hasNext()) {
          QLog.d("UnifiedMonitor", 2, (String)((Iterator)localObject).next());
        }
        paramMessage.c = SystemClock.uptimeMillis();
        label713:
        paramMessage.h += 1;
        while ((paramMessage.h < paramMessage.e) && (SystemClock.uptimeMillis() - paramMessage.jdField_a_of_type_Long < paramMessage.f * 1000L))
        {
          this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(5, 2000L);
          return true;
          QLog.d("UnifiedMonitor", 1, "totalCpu exceed: " + ajou.jdField_a_of_type_Int + ", appCpu: " + ajou.jdField_a_of_type_Ajow.jdField_a_of_type_Int);
          break label713;
          if (QLog.isColorLevel()) {
            QLog.d("UnifiedMonitor", 2, "totalCpu: " + ajou.jdField_a_of_type_Int + ", appCpu: " + ajou.jdField_a_of_type_Ajow.jdField_a_of_type_Int);
          }
          paramMessage.m = 1;
        }
        this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
        ajou.a(true);
        this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(8, 10000L);
        return true;
        ajou.b(true);
        localObject = (awse)this.jdField_a_of_type_ArrayOfAwsd[11];
        if (!QLog.isColorLevel()) {
          continue;
        }
        localObject = ajou.a(((awse)localObject).l, true);
        QLog.d("UnifiedMonitor", 2, "trace " + paramMessage.obj + "'s cpu end(" + ajou.jdField_a_of_type_Int + ", " + ajou.jdField_a_of_type_Ajow.jdField_a_of_type_Int + ")");
        paramMessage = ((List)localObject).iterator();
        while (paramMessage.hasNext()) {
          QLog.d("UnifiedMonitor", 2, (String)paramMessage.next());
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        break label600;
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
    if (this.jdField_a_of_type_ArrayOfAwsd[i].g >= this.jdField_a_of_type_ArrayOfAwsd[i].jdField_b_of_type_Int)
    {
      this.jdField_c_of_type_AndroidOsHandler.removeMessages(b(paramInt));
      a(i);
      return false;
    }
    paramInt = b(paramInt);
    this.jdField_c_of_type_AndroidOsHandler.removeMessages(paramInt, Thread.currentThread());
    Message localMessage = this.jdField_c_of_type_AndroidOsHandler.obtainMessage(paramInt, Thread.currentThread());
    localMessage.arg1 = i;
    this.jdField_c_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, this.jdField_a_of_type_ArrayOfAwsd[i].jdField_a_of_type_Int);
    return true;
  }
  
  public void notifyNotTimeout(int paramInt)
  {
    this.jdField_a_of_type_ArrayOfAwsd[paramInt].jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_ArrayOfAwsd[paramInt].jdField_a_of_type_JavaLangString = null;
    if ((paramInt == 0) || (paramInt == 10)) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
    }
  }
  
  public void reportStackIfTimeout(int paramInt)
  {
    this.jdField_a_of_type_ArrayOfAwsd[paramInt].jdField_b_of_type_Long = SystemClock.uptimeMillis();
    this.jdField_a_of_type_ArrayOfAwsd[paramInt].jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_ArrayOfAwsd[paramInt].jdField_b_of_type_Boolean = false;
  }
  
  public boolean setMonitoredThread(int paramInt, Thread paramThread, AbstractUnifiedMonitor.ThreadMonitorCallback arg3)
  {
    if ((paramThread == null) || (!this.jdField_a_of_type_ArrayOfAwsd[paramInt].jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ArrayOfAwsd[paramInt].jdField_a_of_type_ComTencentMobileqqStatisticsUnifiedMonitor$StackGetterJob != null) || (this.jdField_a_of_type_ArrayOfAwsd[paramInt].jdField_c_of_type_Int <= 0)) {
      return false;
    }
    QLog.d("UnifiedMonitor", 1, "setMonitoredThread for family=" + paramInt);
    synchronized (this.jdField_a_of_type_ArrayOfAwsd[paramInt])
    {
      if (this.jdField_a_of_type_ArrayOfAwsd[paramInt].jdField_a_of_type_ComTencentMobileqqStatisticsUnifiedMonitor$StackGetterJob == null)
      {
        this.jdField_a_of_type_ArrayOfAwsd[paramInt].jdField_a_of_type_ComTencentMobileqqStatisticsUnifiedMonitor$StackGetterJob = new UnifiedMonitor.StackGetterJob(this, paramInt, paramThread);
        ThreadManager.newFreeThread(this.jdField_a_of_type_ArrayOfAwsd[paramInt].jdField_a_of_type_ComTencentMobileqqStatisticsUnifiedMonitor$StackGetterJob, "um-stack-fetcher-" + paramInt, 5).start();
        this.jdField_a_of_type_ArrayOfAwsd[paramInt].jdField_c_of_type_Boolean = true;
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
    return this.jdField_a_of_type_ArrayOfAwsd[paramInt].jdField_a_of_type_Boolean;
  }
  
  public boolean whetherReportThisTime(int paramInt)
  {
    if ((!this.jdField_a_of_type_Boolean) || (!this.jdField_a_of_type_ArrayOfAwsd[paramInt].jdField_a_of_type_Boolean)) {
      return false;
    }
    if (this.jdField_a_of_type_ArrayOfAwsd[paramInt].jdField_c_of_type_Boolean) {
      return this.jdField_a_of_type_ArrayOfAwsd[paramInt].jdField_b_of_type_Boolean;
    }
    return whetherReportThisTime(paramInt, false);
  }
  
  public boolean whetherReportThisTime(int paramInt, boolean paramBoolean)
  {
    float f = this.jdField_a_of_type_ArrayOfAwsd[paramInt].jdField_b_of_type_Float;
    if (this.jdField_a_of_type_ArrayOfAwsd[paramInt].g >= this.jdField_a_of_type_ArrayOfAwsd[paramInt].jdField_b_of_type_Int) {}
    while (Math.random() > f) {
      return false;
    }
    return true;
  }
  
  public boolean whetherStackEnabled(int paramInt)
  {
    return this.jdField_a_of_type_ArrayOfAwsd[paramInt].jdField_c_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.UnifiedMonitor
 * JD-Core Version:    0.7.0.1
 */