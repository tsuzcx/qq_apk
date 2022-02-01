package com.tencent.qqperf;

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
import com.tencent.mobileqq.perf.report.FeatureFlag;
import com.tencent.mobileqq.qqperf.api.IPerfApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.Utils;
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
import mqq.app.MainService;
import mqq.app.MobileQQ;
import mqq.util.AbstractUnifiedMonitor;
import mqq.util.AbstractUnifiedMonitor.ThreadMonitorCallback;

public class UnifiedMonitor
  extends AbstractUnifiedMonitor
  implements Handler.Callback, MsfMonitorCallback
{
  public static AtomicBoolean b;
  public static String[] c = { "FAMILY_LOOPER", "FAMILY_OBSERVER", "FAMILY_IMAGE_DRAWABLE", "FAMILY_IMAGE_VIEW", "FAMILY_SUB_TASK", "FAMILY_FILE_TASK", "FAMILY_BG_TASK", "FAMILY_MSF_MSG", "FAMILY_ACT_TIME", "FAMILY_SCENE_SMOOTH", "FAMILY_DROP_FRAME", "FAMILY_CPU_STATS", "FAMILY_NEW_FPS", "FAMILY_RECENT", "FAMILY_QZONE_LOOPER", "FAMILY_MSF_SENDER", "FAMILY_MSF_RECVER", "FAMILY_MSF_LIGHT_SENDER", "FAMILY_MSF_NETWORK", "FAMILY_TOOL_LOOPER", "FAMILY_SCENE_PERF", "FAMILY_LAST" };
  private static UnifiedMonitor g;
  private static int k = -1;
  public volatile boolean a = false;
  private Handler d = null;
  private HandlerThread e = null;
  private Handler f = null;
  private UnifiedMonitor.FamilyConfig[] h = { new UnifiedMonitor.FamilyConfig(0.0008F, 100, 10, 0.1F, 6, 0, 0, 0, false), new UnifiedMonitor.FamilyConfig(), new UnifiedMonitor.FamilyConfig(), new UnifiedMonitor.FamilyConfig(), new UnifiedMonitor.FamilyConfig(0.001F, 180000, 2, 1.0F, 6, 0, 0, 0, true), new UnifiedMonitor.FamilyConfig(0.001F, 180000, 2, 1.0F, 6, 0, 0, 0, true), new UnifiedMonitor.FamilyConfig(0.001F, 1000, 10, 0.001F, 0, 0, 0, 0, false), new UnifiedMonitor.FamilyConfig(0.001F, 180000, 2, 1.0F, 6, 6, 0, 0, true), new UnifiedMonitor.FamilyConfig(0.001F, 0, 10, 0.1F, 0, 0, 0, 0, false), new UnifiedMonitor.FamilyConfig(0.001F, 100, 5, 0.01F, 0, 0, 0, 0, false), new UnifiedMonitor.FamilyConfig(0.001F, 100, 10, 0.1F, 6, 0, 0, 0, false), new UnifiedMonitor.ProcessStatsConfig(0.0F, 100100005, 1, 0.01F, 0, 0, 2, 300), new UnifiedMonitor.FamilyConfig(0.01F, 100, 5, 0.01F, 0, 0, 0, 0, false), new UnifiedMonitor.FamilyConfig(0.001F, 180000, 10, 1.0F, 6, 0, 0, 0, true), new UnifiedMonitor.FamilyConfig(0.001F, 100, 5, 0.01F, 6, 0, 0, 0, false), new UnifiedMonitor.FamilyConfig(0.001F, 600000, 2, 1.0F, 6, 0, 0, 0, true), new UnifiedMonitor.FamilyConfig(0.001F, 180000, 2, 1.0F, 6, 0, 0, 0, true), new UnifiedMonitor.FamilyConfig(0.001F, 180000, 2, 1.0F, 6, 0, 0, 0, true), new UnifiedMonitor.FamilyConfig(0.001F, 180000, 2, 1.0F, 6, 0, 0, 0, true), new UnifiedMonitor.FamilyConfig(0.001F, 100, 5, 0.01F, 6, 0, 0, 0, false), new UnifiedMonitor.FamilyConfig(0.01F, 100, 10, 0.01F, 0, 0, 0, 0, false) };
  private HandlerThread i = null;
  private Handler j = null;
  private String l = null;
  private String m = null;
  private String n = null;
  
  public static UnifiedMonitor a()
  {
    UnifiedMonitor localUnifiedMonitor = g;
    if (localUnifiedMonitor != null) {
      return localUnifiedMonitor;
    }
    try
    {
      if (g == null) {
        g = new UnifiedMonitor();
      }
      localUnifiedMonitor = g;
      return localUnifiedMonitor;
    }
    finally {}
  }
  
  public static String a(int paramInt)
  {
    String[] arrayOfString = c;
    if (arrayOfString.length > paramInt) {
      return arrayOfString[paramInt];
    }
    return "unknown";
  }
  
  public static void a(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private static final int b(int paramInt)
  {
    if (paramInt == 1) {
      return 15;
    }
    if (paramInt == 2) {
      return 16;
    }
    return 17;
  }
  
  private static final int c(int paramInt)
  {
    if (paramInt == 1) {
      return 12;
    }
    if (paramInt == 2) {
      return 13;
    }
    return 11;
  }
  
  private void d(int paramInt)
  {
    UnifiedMonitor.FamilyConfig[] arrayOfFamilyConfig = this.h;
    arrayOfFamilyConfig[paramInt].l = false;
    arrayOfFamilyConfig[paramInt].m = false;
    arrayOfFamilyConfig[paramInt].q = null;
    arrayOfFamilyConfig[paramInt].p = false;
    if (arrayOfFamilyConfig[paramInt].r != null)
    {
      this.h[paramInt].r.onThreadMonitorEnd(paramInt);
      this.h[paramInt].r = null;
    }
  }
  
  public static boolean d()
  {
    if (b == null) {
      b = new AtomicBoolean(new File("/proc/stat").canRead());
    }
    return b.get();
  }
  
  public static boolean g()
  {
    return (QLog.isColorLevel()) || (Utils.d());
  }
  
  public static HashMap<String, String> h()
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
  
  private void i()
  {
    StackObservable.a().addObserver(new StackObserver());
    if (4 == MobileQQ.sProcessId) {
      k();
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
    j();
  }
  
  private final void j()
  {
    if ((whetherReportDuringThisStartup(11)) && (this.e == null) && (d()))
    {
      this.e = ThreadManager.newFreeHandlerThread("cpu-stats", 0);
      this.e.start();
      Looper localLooper = this.e.getLooper();
      if (localLooper != null)
      {
        this.f = new Handler(localLooper, this);
        this.f.sendEmptyMessage(4);
      }
    }
  }
  
  private void k()
  {
    MsfCore localMsfCore = MsfCore.sCore;
    int i1 = 0;
    if (localMsfCore != null)
    {
      if ((whetherReportDuringThisStartup(17)) || (whetherReportDuringThisStartup(15)) || (whetherReportDuringThisStartup(16)))
      {
        QLog.d("UnifiedMonitor_QAPM", 1, new Object[] { "setMsfMonitorCallback, ", Boolean.valueOf(whetherReportDuringThisStartup(17)), ", ", Boolean.valueOf(whetherReportDuringThisStartup(15)), ", ", Boolean.valueOf(whetherReportDuringThisStartup(16)) });
        MsfCore.sCore.setMsfMonitorCallback(this);
        i1 = 1;
      }
    }
    else {
      QLog.e("UnifiedMonitor_QAPM", 1, "MsfCore.sCore is null");
    }
    if (i1 != 0)
    {
      this.i = new HandlerThread("um-msfMonitor");
      this.i.start();
      this.j = new Handler(this.i.getLooper(), this);
    }
    if (whetherReportDuringThisStartup(18)) {
      LooperMonitorHelper.b();
    }
  }
  
  /* Error */
  private void l()
  {
    // Byte code:
    //   0: ldc_w 332
    //   3: invokestatic 204	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   6: checkcast 332	com/tencent/mobileqq/dpc/api/IDPCApi
    //   9: getstatic 338	com/tencent/mobileqq/dpc/enumname/DPCNames:unified_monitor_params	Lcom/tencent/mobileqq/dpc/enumname/DPCNames;
    //   12: invokevirtual 341	com/tencent/mobileqq/dpc/enumname/DPCNames:name	()Ljava/lang/String;
    //   15: invokeinterface 345 2 0
    //   20: astore 7
    //   22: new 347	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 348	java/lang/StringBuilder:<init>	()V
    //   29: astore 8
    //   31: aload 8
    //   33: ldc_w 350
    //   36: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload 8
    //   42: aload 7
    //   44: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: ldc_w 297
    //   51: iconst_1
    //   52: aload 8
    //   54: invokevirtual 357	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokestatic 359	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   60: iconst_0
    //   61: istore 4
    //   63: aload 7
    //   65: ifnull +1180 -> 1245
    //   68: aload 7
    //   70: ldc_w 361
    //   73: invokevirtual 365	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   76: astore 10
    //   78: aload 10
    //   80: ifnonnull +20 -> 100
    //   83: aload_0
    //   84: monitorenter
    //   85: aload_0
    //   86: iconst_1
    //   87: putfield 94	com/tencent/qqperf/UnifiedMonitor:a	Z
    //   90: aload_0
    //   91: monitorexit
    //   92: return
    //   93: astore 7
    //   95: aload_0
    //   96: monitorexit
    //   97: aload 7
    //   99: athrow
    //   100: aload 10
    //   102: arraylength
    //   103: istore 5
    //   105: iconst_0
    //   106: istore_3
    //   107: iload_3
    //   108: iload 5
    //   110: if_icmpge +1135 -> 1245
    //   113: aload 10
    //   115: iload_3
    //   116: aaload
    //   117: astore 7
    //   119: aload 7
    //   121: ldc_w 367
    //   124: invokevirtual 365	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   127: astore 11
    //   129: aload 11
    //   131: ifnull +1107 -> 1238
    //   134: aload 11
    //   136: arraylength
    //   137: iconst_2
    //   138: if_icmpne +1100 -> 1238
    //   141: aload 11
    //   143: iconst_0
    //   144: aaload
    //   145: invokestatic 373	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   148: ifne +1090 -> 1238
    //   151: aload 11
    //   153: iconst_1
    //   154: aaload
    //   155: invokestatic 373	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   158: ifne +1080 -> 1238
    //   161: aload 11
    //   163: iconst_0
    //   164: aaload
    //   165: bipush 95
    //   167: invokevirtual 376	java/lang/String:lastIndexOf	(I)I
    //   170: istore 6
    //   172: aconst_null
    //   173: astore 9
    //   175: iload 6
    //   177: iconst_m1
    //   178: if_icmpeq +1027 -> 1205
    //   181: aload 11
    //   183: iconst_0
    //   184: aaload
    //   185: iconst_0
    //   186: iload 6
    //   188: iconst_1
    //   189: iadd
    //   190: invokevirtual 380	java/lang/String:substring	(II)Ljava/lang/String;
    //   193: astore 7
    //   195: goto +3 -> 198
    //   198: aload 9
    //   200: astore 8
    //   202: iload 6
    //   204: iconst_m1
    //   205: if_icmpeq +34 -> 239
    //   208: aload 9
    //   210: astore 8
    //   212: iload 6
    //   214: aload 11
    //   216: iconst_0
    //   217: aaload
    //   218: invokevirtual 384	java/lang/String:length	()I
    //   221: iconst_1
    //   222: isub
    //   223: if_icmpge +16 -> 239
    //   226: aload 11
    //   228: iconst_0
    //   229: aaload
    //   230: iload 6
    //   232: iconst_1
    //   233: iadd
    //   234: invokevirtual 386	java/lang/String:substring	(I)Ljava/lang/String;
    //   237: astore 8
    //   239: aload 8
    //   241: invokestatic 391	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   244: invokevirtual 394	java/lang/Integer:intValue	()I
    //   247: istore_2
    //   248: goto +5 -> 253
    //   251: iconst_m1
    //   252: istore_2
    //   253: invokestatic 191	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   256: ifeq +955 -> 1211
    //   259: new 347	java/lang/StringBuilder
    //   262: dup
    //   263: invokespecial 348	java/lang/StringBuilder:<init>	()V
    //   266: astore 9
    //   268: aload 9
    //   270: ldc_w 396
    //   273: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: pop
    //   277: aload 9
    //   279: iload_2
    //   280: invokevirtual 399	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   283: pop
    //   284: aload 9
    //   286: ldc_w 401
    //   289: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: pop
    //   293: aload 9
    //   295: aload 7
    //   297: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: pop
    //   301: aload 9
    //   303: ldc_w 403
    //   306: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: pop
    //   310: aload 9
    //   312: aload 11
    //   314: iconst_0
    //   315: aaload
    //   316: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: pop
    //   320: aload 9
    //   322: ldc_w 405
    //   325: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: pop
    //   329: aload 9
    //   331: aload 11
    //   333: iconst_1
    //   334: aaload
    //   335: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: pop
    //   339: ldc_w 297
    //   342: iconst_2
    //   343: aload 9
    //   345: invokevirtual 357	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   348: invokestatic 359	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   351: goto +860 -> 1211
    //   354: aload 7
    //   356: ifnull +882 -> 1238
    //   359: iload 6
    //   361: iconst_m1
    //   362: if_icmpeq +876 -> 1238
    //   365: iload_1
    //   366: iconst_m1
    //   367: if_icmpeq +871 -> 1238
    //   370: aload 8
    //   372: ifnull +866 -> 1238
    //   375: iload_1
    //   376: bipush 21
    //   378: if_icmpge +860 -> 1238
    //   381: ldc_w 407
    //   384: aload 7
    //   386: invokevirtual 411	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   389: ifeq +25 -> 414
    //   392: aload_0
    //   393: getfield 114	com/tencent/qqperf/UnifiedMonitor:h	[Lcom/tencent/qqperf/UnifiedMonitor$FamilyConfig;
    //   396: iload_1
    //   397: aaload
    //   398: aload 11
    //   400: iconst_1
    //   401: aaload
    //   402: invokestatic 416	java/lang/Float:valueOf	(Ljava/lang/String;)Ljava/lang/Float;
    //   405: invokevirtual 420	java/lang/Float:floatValue	()F
    //   408: putfield 423	com/tencent/qqperf/UnifiedMonitor$FamilyConfig:c	F
    //   411: goto +827 -> 1238
    //   414: ldc_w 425
    //   417: aload 7
    //   419: invokevirtual 411	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   422: ifeq +25 -> 447
    //   425: aload_0
    //   426: getfield 114	com/tencent/qqperf/UnifiedMonitor:h	[Lcom/tencent/qqperf/UnifiedMonitor$FamilyConfig;
    //   429: iload_1
    //   430: aaload
    //   431: aload 11
    //   433: iconst_1
    //   434: aaload
    //   435: invokestatic 391	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   438: invokevirtual 394	java/lang/Integer:intValue	()I
    //   441: putfield 427	com/tencent/qqperf/UnifiedMonitor$FamilyConfig:b	I
    //   444: goto +794 -> 1238
    //   447: ldc_w 429
    //   450: aload 7
    //   452: invokevirtual 411	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   455: ifeq +25 -> 480
    //   458: aload_0
    //   459: getfield 114	com/tencent/qqperf/UnifiedMonitor:h	[Lcom/tencent/qqperf/UnifiedMonitor$FamilyConfig;
    //   462: iload_1
    //   463: aaload
    //   464: aload 11
    //   466: iconst_1
    //   467: aaload
    //   468: invokestatic 391	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   471: invokevirtual 394	java/lang/Integer:intValue	()I
    //   474: putfield 431	com/tencent/qqperf/UnifiedMonitor$FamilyConfig:a	I
    //   477: goto +761 -> 1238
    //   480: ldc_w 433
    //   483: aload 7
    //   485: invokevirtual 411	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   488: ifeq +25 -> 513
    //   491: aload_0
    //   492: getfield 114	com/tencent/qqperf/UnifiedMonitor:h	[Lcom/tencent/qqperf/UnifiedMonitor$FamilyConfig;
    //   495: iload_1
    //   496: aaload
    //   497: aload 11
    //   499: iconst_1
    //   500: aaload
    //   501: invokestatic 416	java/lang/Float:valueOf	(Ljava/lang/String;)Ljava/lang/Float;
    //   504: invokevirtual 420	java/lang/Float:floatValue	()F
    //   507: putfield 435	com/tencent/qqperf/UnifiedMonitor$FamilyConfig:d	F
    //   510: goto +728 -> 1238
    //   513: ldc_w 437
    //   516: aload 7
    //   518: invokevirtual 411	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   521: ifeq +33 -> 554
    //   524: getstatic 442	android/os/Build$VERSION:SDK_INT	I
    //   527: bipush 17
    //   529: if_icmpeq +709 -> 1238
    //   532: aload_0
    //   533: getfield 114	com/tencent/qqperf/UnifiedMonitor:h	[Lcom/tencent/qqperf/UnifiedMonitor$FamilyConfig;
    //   536: iload_1
    //   537: aaload
    //   538: aload 11
    //   540: iconst_1
    //   541: aaload
    //   542: invokestatic 391	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   545: invokevirtual 394	java/lang/Integer:intValue	()I
    //   548: putfield 444	com/tencent/qqperf/UnifiedMonitor$FamilyConfig:e	I
    //   551: goto +687 -> 1238
    //   554: ldc_w 446
    //   557: aload 7
    //   559: invokevirtual 411	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   562: ifeq +25 -> 587
    //   565: aload_0
    //   566: getfield 114	com/tencent/qqperf/UnifiedMonitor:h	[Lcom/tencent/qqperf/UnifiedMonitor$FamilyConfig;
    //   569: iload_1
    //   570: aaload
    //   571: aload 11
    //   573: iconst_1
    //   574: aaload
    //   575: invokestatic 391	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   578: invokevirtual 394	java/lang/Integer:intValue	()I
    //   581: putfield 448	com/tencent/qqperf/UnifiedMonitor$FamilyConfig:f	I
    //   584: goto +654 -> 1238
    //   587: ldc_w 450
    //   590: aload 7
    //   592: invokevirtual 411	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   595: ifeq +643 -> 1238
    //   598: aload_0
    //   599: getfield 114	com/tencent/qqperf/UnifiedMonitor:h	[Lcom/tencent/qqperf/UnifiedMonitor$FamilyConfig;
    //   602: iload_1
    //   603: aaload
    //   604: aload 11
    //   606: iconst_1
    //   607: aaload
    //   608: invokestatic 453	java/lang/Boolean:valueOf	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   611: invokevirtual 456	java/lang/Boolean:booleanValue	()Z
    //   614: putfield 459	com/tencent/qqperf/UnifiedMonitor$FamilyConfig:t	Z
    //   617: goto +621 -> 1238
    //   620: astore 7
    //   622: invokestatic 191	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   625: ifeq +613 -> 1238
    //   628: ldc_w 297
    //   631: iconst_2
    //   632: ldc_w 461
    //   635: aload 7
    //   637: invokestatic 464	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   640: goto +598 -> 1238
    //   643: iload_1
    //   644: aload_0
    //   645: getfield 114	com/tencent/qqperf/UnifiedMonitor:h	[Lcom/tencent/qqperf/UnifiedMonitor$FamilyConfig;
    //   648: arraylength
    //   649: if_icmpge +20 -> 669
    //   652: aload_0
    //   653: getfield 114	com/tencent/qqperf/UnifiedMonitor:h	[Lcom/tencent/qqperf/UnifiedMonitor$FamilyConfig;
    //   656: iload_1
    //   657: aaload
    //   658: iload_1
    //   659: invokevirtual 466	com/tencent/qqperf/UnifiedMonitor$FamilyConfig:a	(I)V
    //   662: iload_1
    //   663: iconst_1
    //   664: iadd
    //   665: istore_1
    //   666: goto -23 -> 643
    //   669: aload_0
    //   670: getfield 114	com/tencent/qqperf/UnifiedMonitor:h	[Lcom/tencent/qqperf/UnifiedMonitor$FamilyConfig;
    //   673: bipush 10
    //   675: aaload
    //   676: iconst_0
    //   677: putfield 150	com/tencent/qqperf/UnifiedMonitor$FamilyConfig:l	Z
    //   680: invokestatic 191	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   683: ifeq +53 -> 736
    //   686: aload_0
    //   687: getfield 114	com/tencent/qqperf/UnifiedMonitor:h	[Lcom/tencent/qqperf/UnifiedMonitor$FamilyConfig;
    //   690: iconst_0
    //   691: aaload
    //   692: iconst_1
    //   693: putfield 150	com/tencent/qqperf/UnifiedMonitor$FamilyConfig:l	Z
    //   696: aload_0
    //   697: getfield 114	com/tencent/qqperf/UnifiedMonitor:h	[Lcom/tencent/qqperf/UnifiedMonitor$FamilyConfig;
    //   700: iconst_0
    //   701: aaload
    //   702: ldc_w 467
    //   705: putfield 427	com/tencent/qqperf/UnifiedMonitor$FamilyConfig:b	I
    //   708: aload_0
    //   709: getfield 114	com/tencent/qqperf/UnifiedMonitor:h	[Lcom/tencent/qqperf/UnifiedMonitor$FamilyConfig;
    //   712: iconst_0
    //   713: aaload
    //   714: fconst_1
    //   715: putfield 435	com/tencent/qqperf/UnifiedMonitor$FamilyConfig:d	F
    //   718: invokestatic 191	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   721: ifeq +15 -> 736
    //   724: aload_0
    //   725: getfield 114	com/tencent/qqperf/UnifiedMonitor:h	[Lcom/tencent/qqperf/UnifiedMonitor$FamilyConfig;
    //   728: iconst_0
    //   729: aaload
    //   730: sipush 200
    //   733: putfield 431	com/tencent/qqperf/UnifiedMonitor$FamilyConfig:a	I
    //   736: getstatic 237	mqq/app/MobileQQ:sProcessId	I
    //   739: istore_1
    //   740: getstatic 237	mqq/app/MobileQQ:sProcessId	I
    //   743: iconst_1
    //   744: if_icmpne +14 -> 758
    //   747: aload_0
    //   748: getfield 114	com/tencent/qqperf/UnifiedMonitor:h	[Lcom/tencent/qqperf/UnifiedMonitor$FamilyConfig;
    //   751: bipush 11
    //   753: aaload
    //   754: iconst_0
    //   755: putfield 150	com/tencent/qqperf/UnifiedMonitor$FamilyConfig:l	Z
    //   758: invokestatic 195	com/tencent/mobileqq/util/Utils:d	()Z
    //   761: ifeq +129 -> 890
    //   764: getstatic 237	mqq/app/MobileQQ:sProcessId	I
    //   767: iconst_1
    //   768: if_icmpne +60 -> 828
    //   771: aload_0
    //   772: getfield 114	com/tencent/qqperf/UnifiedMonitor:h	[Lcom/tencent/qqperf/UnifiedMonitor$FamilyConfig;
    //   775: iconst_4
    //   776: aaload
    //   777: getfield 150	com/tencent/qqperf/UnifiedMonitor$FamilyConfig:l	Z
    //   780: ifeq +48 -> 828
    //   783: new 210	java/util/HashMap
    //   786: dup
    //   787: iconst_2
    //   788: invokespecial 212	java/util/HashMap:<init>	(I)V
    //   791: astore 7
    //   793: aload 7
    //   795: ldc_w 469
    //   798: iconst_1
    //   799: invokestatic 471	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   802: invokevirtual 218	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   805: pop
    //   806: invokestatic 475	mqq/app/MobileQQ:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   809: invokestatic 481	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   812: aconst_null
    //   813: ldc_w 483
    //   816: iconst_1
    //   817: lconst_0
    //   818: lconst_0
    //   819: aload 7
    //   821: aconst_null
    //   822: invokevirtual 487	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   825: goto +65 -> 890
    //   828: getstatic 237	mqq/app/MobileQQ:sProcessId	I
    //   831: iconst_4
    //   832: if_icmpne +58 -> 890
    //   835: aload_0
    //   836: getfield 114	com/tencent/qqperf/UnifiedMonitor:h	[Lcom/tencent/qqperf/UnifiedMonitor$FamilyConfig;
    //   839: bipush 15
    //   841: aaload
    //   842: getfield 150	com/tencent/qqperf/UnifiedMonitor$FamilyConfig:l	Z
    //   845: ifeq +45 -> 890
    //   848: new 210	java/util/HashMap
    //   851: dup
    //   852: iconst_2
    //   853: invokespecial 212	java/util/HashMap:<init>	(I)V
    //   856: astore 7
    //   858: aload 7
    //   860: ldc_w 469
    //   863: iconst_2
    //   864: invokestatic 471	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   867: invokevirtual 218	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   870: pop
    //   871: invokestatic 475	mqq/app/MobileQQ:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   874: invokestatic 481	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   877: aconst_null
    //   878: ldc_w 483
    //   881: iconst_1
    //   882: lconst_0
    //   883: lconst_0
    //   884: aload 7
    //   886: aconst_null
    //   887: invokevirtual 487	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   890: new 347	java/lang/StringBuilder
    //   893: dup
    //   894: invokespecial 348	java/lang/StringBuilder:<init>	()V
    //   897: astore 7
    //   899: aload 7
    //   901: ldc_w 489
    //   904: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   907: pop
    //   908: aload 7
    //   910: invokestatic 195	com/tencent/mobileqq/util/Utils:d	()Z
    //   913: invokevirtual 492	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   916: pop
    //   917: aload 7
    //   919: ldc_w 494
    //   922: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   925: pop
    //   926: aload 7
    //   928: invokestatic 191	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   931: invokevirtual 492	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   934: pop
    //   935: ldc_w 496
    //   938: iconst_1
    //   939: aload 7
    //   941: invokevirtual 357	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   944: invokestatic 359	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   947: aload_0
    //   948: getfield 114	com/tencent/qqperf/UnifiedMonitor:h	[Lcom/tencent/qqperf/UnifiedMonitor$FamilyConfig;
    //   951: arraylength
    //   952: istore_2
    //   953: iload 4
    //   955: istore_1
    //   956: iload_1
    //   957: iload_2
    //   958: if_icmpge +158 -> 1116
    //   961: aload_0
    //   962: getfield 114	com/tencent/qqperf/UnifiedMonitor:h	[Lcom/tencent/qqperf/UnifiedMonitor$FamilyConfig;
    //   965: iload_1
    //   966: aaload
    //   967: astore 7
    //   969: new 347	java/lang/StringBuilder
    //   972: dup
    //   973: invokespecial 348	java/lang/StringBuilder:<init>	()V
    //   976: astore 8
    //   978: aload 8
    //   980: ldc_w 498
    //   983: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   986: pop
    //   987: aload 8
    //   989: iload_1
    //   990: invokestatic 500	com/tencent/qqperf/UnifiedMonitor:a	(I)Ljava/lang/String;
    //   993: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   996: pop
    //   997: aload 8
    //   999: ldc_w 502
    //   1002: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1005: pop
    //   1006: aload 8
    //   1008: aload 7
    //   1010: getfield 150	com/tencent/qqperf/UnifiedMonitor$FamilyConfig:l	Z
    //   1013: invokevirtual 492	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1016: pop
    //   1017: aload 8
    //   1019: ldc_w 504
    //   1022: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1025: pop
    //   1026: aload 8
    //   1028: aload 7
    //   1030: getfield 435	com/tencent/qqperf/UnifiedMonitor$FamilyConfig:d	F
    //   1033: invokevirtual 507	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   1036: pop
    //   1037: aload 8
    //   1039: ldc_w 509
    //   1042: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1045: pop
    //   1046: aload 8
    //   1048: aload 7
    //   1050: getfield 423	com/tencent/qqperf/UnifiedMonitor$FamilyConfig:c	F
    //   1053: invokevirtual 507	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   1056: pop
    //   1057: aload 8
    //   1059: ldc_w 511
    //   1062: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1065: pop
    //   1066: aload 8
    //   1068: aload 7
    //   1070: getfield 427	com/tencent/qqperf/UnifiedMonitor$FamilyConfig:b	I
    //   1073: invokevirtual 399	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1076: pop
    //   1077: aload 8
    //   1079: ldc_w 513
    //   1082: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1085: pop
    //   1086: aload 8
    //   1088: aload 7
    //   1090: getfield 431	com/tencent/qqperf/UnifiedMonitor$FamilyConfig:a	I
    //   1093: invokevirtual 399	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1096: pop
    //   1097: ldc_w 496
    //   1100: iconst_1
    //   1101: aload 8
    //   1103: invokevirtual 357	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1106: invokestatic 359	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1109: iload_1
    //   1110: iconst_1
    //   1111: iadd
    //   1112: istore_1
    //   1113: goto -157 -> 956
    //   1116: aload_0
    //   1117: monitorenter
    //   1118: aload_0
    //   1119: iconst_1
    //   1120: putfield 94	com/tencent/qqperf/UnifiedMonitor:a	Z
    //   1123: aload_0
    //   1124: monitorexit
    //   1125: return
    //   1126: astore 7
    //   1128: aload_0
    //   1129: monitorexit
    //   1130: aload 7
    //   1132: athrow
    //   1133: astore 7
    //   1135: goto +40 -> 1175
    //   1138: astore 7
    //   1140: invokestatic 191	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1143: ifeq +15 -> 1158
    //   1146: ldc_w 297
    //   1149: iconst_2
    //   1150: ldc_w 461
    //   1153: aload 7
    //   1155: invokestatic 515	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1158: aload_0
    //   1159: monitorenter
    //   1160: aload_0
    //   1161: iconst_1
    //   1162: putfield 94	com/tencent/qqperf/UnifiedMonitor:a	Z
    //   1165: aload_0
    //   1166: monitorexit
    //   1167: return
    //   1168: astore 7
    //   1170: aload_0
    //   1171: monitorexit
    //   1172: aload 7
    //   1174: athrow
    //   1175: aload_0
    //   1176: monitorenter
    //   1177: aload_0
    //   1178: iconst_1
    //   1179: putfield 94	com/tencent/qqperf/UnifiedMonitor:a	Z
    //   1182: aload_0
    //   1183: monitorexit
    //   1184: aload 7
    //   1186: athrow
    //   1187: astore 7
    //   1189: aload_0
    //   1190: monitorexit
    //   1191: goto +6 -> 1197
    //   1194: aload 7
    //   1196: athrow
    //   1197: goto -3 -> 1194
    //   1200: astore 9
    //   1202: goto -951 -> 251
    //   1205: aconst_null
    //   1206: astore 7
    //   1208: goto -1010 -> 198
    //   1211: iload_2
    //   1212: istore_1
    //   1213: iload_2
    //   1214: sipush 1000
    //   1217: if_icmplt -863 -> 354
    //   1220: iload_2
    //   1221: sipush 1000
    //   1224: isub
    //   1225: istore_2
    //   1226: iload_2
    //   1227: istore_1
    //   1228: iload_2
    //   1229: iconst_m1
    //   1230: if_icmpge -876 -> 354
    //   1233: iconst_m1
    //   1234: istore_1
    //   1235: goto -881 -> 354
    //   1238: iload_3
    //   1239: iconst_1
    //   1240: iadd
    //   1241: istore_3
    //   1242: goto -1135 -> 107
    //   1245: iconst_0
    //   1246: istore_1
    //   1247: goto -604 -> 643
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1250	0	this	UnifiedMonitor
    //   365	882	1	i1	int
    //   247	984	2	i2	int
    //   106	1136	3	i3	int
    //   61	893	4	i4	int
    //   103	8	5	i5	int
    //   170	193	6	i6	int
    //   20	49	7	str1	String
    //   93	5	7	localObject1	Object
    //   117	474	7	str2	String
    //   620	16	7	localThrowable1	Throwable
    //   791	298	7	localObject2	Object
    //   1126	5	7	localObject3	Object
    //   1133	1	7	localObject4	Object
    //   1138	16	7	localThrowable2	Throwable
    //   1168	17	7	localObject5	Object
    //   1187	8	7	localObject6	Object
    //   1206	1	7	localObject7	Object
    //   29	1073	8	localObject8	Object
    //   173	171	9	localStringBuilder	StringBuilder
    //   1200	1	9	localNumberFormatException	java.lang.NumberFormatException
    //   76	38	10	arrayOfString1	String[]
    //   127	478	11	arrayOfString2	String[]
    // Exception table:
    //   from	to	target	type
    //   85	92	93	finally
    //   95	97	93	finally
    //   119	129	620	java/lang/Throwable
    //   134	172	620	java/lang/Throwable
    //   181	195	620	java/lang/Throwable
    //   212	239	620	java/lang/Throwable
    //   239	248	620	java/lang/Throwable
    //   253	351	620	java/lang/Throwable
    //   381	411	620	java/lang/Throwable
    //   414	444	620	java/lang/Throwable
    //   447	477	620	java/lang/Throwable
    //   480	510	620	java/lang/Throwable
    //   513	551	620	java/lang/Throwable
    //   554	584	620	java/lang/Throwable
    //   587	617	620	java/lang/Throwable
    //   1118	1125	1126	finally
    //   1128	1130	1126	finally
    //   0	60	1133	finally
    //   68	78	1133	finally
    //   100	105	1133	finally
    //   119	129	1133	finally
    //   134	172	1133	finally
    //   181	195	1133	finally
    //   212	239	1133	finally
    //   239	248	1133	finally
    //   253	351	1133	finally
    //   381	411	1133	finally
    //   414	444	1133	finally
    //   447	477	1133	finally
    //   480	510	1133	finally
    //   513	551	1133	finally
    //   554	584	1133	finally
    //   587	617	1133	finally
    //   622	640	1133	finally
    //   643	662	1133	finally
    //   669	736	1133	finally
    //   736	758	1133	finally
    //   758	825	1133	finally
    //   828	890	1133	finally
    //   890	953	1133	finally
    //   961	1109	1133	finally
    //   1140	1158	1133	finally
    //   0	60	1138	java/lang/Throwable
    //   68	78	1138	java/lang/Throwable
    //   100	105	1138	java/lang/Throwable
    //   622	640	1138	java/lang/Throwable
    //   643	662	1138	java/lang/Throwable
    //   669	736	1138	java/lang/Throwable
    //   736	758	1138	java/lang/Throwable
    //   758	825	1138	java/lang/Throwable
    //   828	890	1138	java/lang/Throwable
    //   890	953	1138	java/lang/Throwable
    //   961	1109	1138	java/lang/Throwable
    //   1160	1167	1168	finally
    //   1170	1172	1168	finally
    //   1177	1184	1187	finally
    //   1189	1191	1187	finally
    //   239	248	1200	java/lang/NumberFormatException
  }
  
  public void a(int paramInt, Thread paramThread)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  /* Error */
  void a(String paramString)
  {
    // Byte code:
    //   0: new 175	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 178	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_2
    //   9: aload_2
    //   10: invokevirtual 527	java/io/File:exists	()Z
    //   13: ifeq +179 -> 192
    //   16: new 347	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 348	java/lang/StringBuilder:<init>	()V
    //   23: astore_3
    //   24: aload_3
    //   25: ldc_w 529
    //   28: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: pop
    //   32: aload_3
    //   33: aload_1
    //   34: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: ldc_w 297
    //   41: iconst_1
    //   42: aload_3
    //   43: invokevirtual 357	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokestatic 321	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   49: aconst_null
    //   50: astore_3
    //   51: aconst_null
    //   52: astore 4
    //   54: aconst_null
    //   55: astore_1
    //   56: new 531	java/io/BufferedReader
    //   59: dup
    //   60: new 533	java/io/InputStreamReader
    //   63: dup
    //   64: new 535	java/io/FileInputStream
    //   67: dup
    //   68: aload_2
    //   69: invokespecial 538	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   72: invokespecial 541	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   75: sipush 8096
    //   78: invokespecial 544	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   81: astore_2
    //   82: aload_2
    //   83: invokevirtual 547	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   86: astore_1
    //   87: aload_1
    //   88: ifnull +14 -> 102
    //   91: ldc_w 297
    //   94: iconst_1
    //   95: aload_1
    //   96: invokestatic 321	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   99: goto -17 -> 82
    //   102: aload_2
    //   103: invokevirtual 550	java/io/BufferedReader:close	()V
    //   106: return
    //   107: astore_1
    //   108: aload_2
    //   109: astore_3
    //   110: aload_1
    //   111: astore_2
    //   112: aload_3
    //   113: astore_1
    //   114: goto +60 -> 174
    //   117: astore_3
    //   118: goto +16 -> 134
    //   121: astore_3
    //   122: goto +31 -> 153
    //   125: astore_2
    //   126: goto +48 -> 174
    //   129: astore_1
    //   130: aload_3
    //   131: astore_2
    //   132: aload_1
    //   133: astore_3
    //   134: aload_2
    //   135: astore_1
    //   136: aload_3
    //   137: invokevirtual 553	java/io/IOException:printStackTrace	()V
    //   140: aload_2
    //   141: ifnull +51 -> 192
    //   144: aload_2
    //   145: invokevirtual 550	java/io/BufferedReader:close	()V
    //   148: return
    //   149: astore_3
    //   150: aload 4
    //   152: astore_2
    //   153: aload_2
    //   154: astore_1
    //   155: aload_3
    //   156: invokevirtual 554	java/io/FileNotFoundException:printStackTrace	()V
    //   159: aload_2
    //   160: ifnull +32 -> 192
    //   163: aload_2
    //   164: invokevirtual 550	java/io/BufferedReader:close	()V
    //   167: return
    //   168: astore_1
    //   169: aload_1
    //   170: invokevirtual 555	java/lang/Exception:printStackTrace	()V
    //   173: return
    //   174: aload_1
    //   175: ifnull +15 -> 190
    //   178: aload_1
    //   179: invokevirtual 550	java/io/BufferedReader:close	()V
    //   182: goto +8 -> 190
    //   185: astore_1
    //   186: aload_1
    //   187: invokevirtual 555	java/lang/Exception:printStackTrace	()V
    //   190: aload_2
    //   191: athrow
    //   192: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	193	0	this	UnifiedMonitor
    //   0	193	1	paramString	String
    //   8	104	2	localObject1	Object
    //   125	1	2	localObject2	Object
    //   131	60	2	localObject3	Object
    //   23	90	3	localObject4	Object
    //   117	1	3	localIOException	java.io.IOException
    //   121	10	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   133	4	3	str	String
    //   149	7	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   52	99	4	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   82	87	107	finally
    //   91	99	107	finally
    //   82	87	117	java/io/IOException
    //   91	99	117	java/io/IOException
    //   82	87	121	java/io/FileNotFoundException
    //   91	99	121	java/io/FileNotFoundException
    //   56	82	125	finally
    //   136	140	125	finally
    //   155	159	125	finally
    //   56	82	129	java/io/IOException
    //   56	82	149	java/io/FileNotFoundException
    //   102	106	168	java/lang/Exception
    //   144	148	168	java/lang/Exception
    //   163	167	168	java/lang/Exception
    //   178	182	185	java/lang/Exception
  }
  
  public void addEvent(int paramInt1, String paramString, int paramInt2, int paramInt3, Map<String, String> paramMap)
  {
    if (this.a)
    {
      if (!whetherReportDuringThisStartup(paramInt1)) {
        return;
      }
      String str = this.h[paramInt1].n;
      if ((this.h[paramInt1].p) && (TextUtils.isEmpty(str))) {
        return;
      }
      Object localObject = paramMap;
      if (paramMap == null) {
        localObject = new HashMap(17);
      }
      ((Map)localObject).put("family", String.valueOf(paramInt1));
      if (paramString == null) {
        paramString = "";
      }
      ((Map)localObject).put("event", paramString);
      ((Map)localObject).put("revision", AppSetting.i());
      if (this.l == null)
      {
        this.l = "dbg";
        this.l = "pub";
      }
      ((Map)localObject).put("build_type", this.l);
      if (SystemClock.uptimeMillis() - ProcessStats.a < 60000L)
      {
        ((Map)localObject).put("totalCpu", String.valueOf(ProcessStats.b));
        ((Map)localObject).put("appCpu", String.valueOf(ProcessStats.c.f));
        ((Map)localObject).put("cpu_update_time", String.valueOf((SystemClock.uptimeMillis() - ProcessStats.a) / 1000L));
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
      ((Map)localObject).put("wal_enable", String.valueOf(k));
      if (QLog.isColorLevel()) {
        paramString = "-1";
      } else {
        paramString = String.valueOf(paramInt3);
      }
      ((Map)localObject).put("not_reported", paramString);
      if (str != null) {
        if (str.length() <= 950)
        {
          ((Map)localObject).put("stack", str);
        }
        else
        {
          ((Map)localObject).put("stack", str.substring(0, 950));
          ((Map)localObject).put("stack1", str.substring(950));
        }
      }
      FeatureFlag.a((Map)localObject);
      paramString = this.d;
      paramString.sendMessage(Message.obtain(paramString, 1, paramInt2, 0, localObject));
      paramString = this.h[paramInt1];
      paramString.i += 1;
    }
  }
  
  public void b() {}
  
  public void c()
  {
    try
    {
      if (!this.a)
      {
        if (this.d == null)
        {
          HandlerThread localHandlerThread = ThreadManager.newFreeHandlerThread("unified-monitor", 0);
          localHandlerThread.start();
          this.d = new Handler(localHandlerThread.getLooper(), this);
          this.d.sendEmptyMessage(3);
        }
        return;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void e()
  {
    try
    {
      c();
      ThreadTraceHelper.a(MobileQQ.getContext());
      ArrayList localArrayList = ThreadTraceHelper.b(MobileQQ.getContext());
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        int i1 = 0;
        while (i1 < localArrayList.size())
        {
          HashMap localHashMap = new HashMap(2);
          localHashMap.put("filePath", localArrayList.get(i1));
          this.d.sendMessage(Message.obtain(this.d, 10, 0, 0, localHashMap));
          i1 += 1;
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
  
  public boolean f()
  {
    return Debug.isDebuggerConnected();
  }
  
  public int getThreshold(int paramInt)
  {
    return this.h[paramInt].a;
  }
  
  public boolean handleEnd(int paramInt)
  {
    if (this.j == null) {
      return false;
    }
    if (!whetherReportDuringThisStartup(b(paramInt))) {
      return false;
    }
    this.j.removeMessages(c(paramInt), Thread.currentThread());
    return true;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject;
    switch (paramMessage.what)
    {
    case 9: 
    default: 
      return true;
    case 11: 
    case 12: 
    case 13: 
      if ((whetherReportThisTime(paramMessage.arg1, false)) && (paramMessage.obj != null) && ((paramMessage.obj instanceof Thread)))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramMessage.arg1);
        ((StringBuilder)localObject).append(", ");
        ((StringBuilder)localObject).append(paramMessage.obj);
        ((StringBuilder)localObject).append(" held: ");
        ((StringBuilder)localObject).append(Arrays.toString(((Thread)paramMessage.obj).getStackTrace()));
        QLog.e("UnifiedMonitor_QAPM", 1, ((StringBuilder)localObject).toString());
        a(paramMessage.arg1, (Thread)paramMessage.obj);
        return true;
      }
      break;
    case 10: 
      StackObservable.a().a((HashMap)paramMessage.obj);
      return true;
    case 8: 
      ProcessStats.b(true);
      localObject = (UnifiedMonitor.ProcessStatsConfig)this.h[11];
      if (QLog.isColorLevel())
      {
        localObject = ProcessStats.a(((UnifiedMonitor.ProcessStatsConfig)localObject).x, true);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("trace ");
        localStringBuilder.append(paramMessage.obj);
        localStringBuilder.append("'s cpu end(");
        localStringBuilder.append(ProcessStats.b);
        localStringBuilder.append(", ");
        localStringBuilder.append(ProcessStats.c.f);
        localStringBuilder.append(")");
        QLog.d("UnifiedMonitor_QAPM", 2, localStringBuilder.toString());
        paramMessage = ((List)localObject).iterator();
      }
      break;
    case 7: 
    case 6: 
      for (;;)
      {
        if (paramMessage.hasNext())
        {
          QLog.d("UnifiedMonitor_QAPM", 2, (String)paramMessage.next());
          continue;
          this.f.removeCallbacksAndMessages(null);
          ProcessStats.a(true);
          this.f.sendEmptyMessageDelayed(8, 10000L);
          return true;
          ProcessStats.b(false);
          paramMessage = (UnifiedMonitor.ProcessStatsConfig)this.h[11];
          if (whetherReportThisTime(11, true))
          {
            localObject = new HashMap(10);
            ((Map)localObject).put("total_cpu", String.valueOf(ProcessStats.b));
            ((Map)localObject).put("app_cpu", String.valueOf(ProcessStats.c.f));
            a().addEvent(11, null, 0, 0, (Map)localObject);
          }
          if ((ProcessStats.b < paramMessage.v) && (ProcessStats.c.f < paramMessage.w))
          {
            paramMessage.y = 1;
          }
          else if ((QLog.isColorLevel()) && (SystemClock.uptimeMillis() - paramMessage.z > 60000L))
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("totalCpu exceed: ");
            ((StringBuilder)localObject).append(ProcessStats.b);
            ((StringBuilder)localObject).append(", appCpu: ");
            ((StringBuilder)localObject).append(ProcessStats.c.f);
            QLog.d("UnifiedMonitor_QAPM", 2, ((StringBuilder)localObject).toString());
            ProcessStats.a(true);
          }
        }
      }
    }
    try
    {
      Thread.sleep(2000L);
      label587:
      ProcessStats.b(true);
      localObject = ProcessStats.a(paramMessage.x, true).iterator();
      while (((Iterator)localObject).hasNext()) {
        QLog.d("UnifiedMonitor_QAPM", 2, (String)((Iterator)localObject).next());
      }
      QLog.d("UnifiedMonitor_QAPM", 2, ProcessStats.a(10));
      localObject = ProcessStats.a(paramMessage.x, true).iterator();
      while (((Iterator)localObject).hasNext()) {
        QLog.d("UnifiedMonitor_QAPM", 2, (String)((Iterator)localObject).next());
      }
      paramMessage.z = SystemClock.uptimeMillis();
      break label751;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("totalCpu exceed: ");
      ((StringBuilder)localObject).append(ProcessStats.b);
      ((StringBuilder)localObject).append(", appCpu: ");
      ((StringBuilder)localObject).append(ProcessStats.c.f);
      QLog.d("UnifiedMonitor_QAPM", 1, ((StringBuilder)localObject).toString());
      label751:
      paramMessage.j += 1;
      if (paramMessage.j < paramMessage.g)
      {
        if (SystemClock.uptimeMillis() - paramMessage.k >= paramMessage.h * 1000L) {
          return true;
        }
        this.f.sendEmptyMessageDelayed(5, 2000L);
        return true;
        ProcessStats.a(false);
        if (!this.f.hasMessages(7))
        {
          this.f.sendEmptyMessageDelayed(6, 1500L);
          return true;
          this.h[11].k = SystemClock.uptimeMillis();
          this.f.sendEmptyMessageDelayed(5, 2000L);
          return true;
          l();
          i();
          return true;
          addEvent(paramMessage.arg1, "", 3000, -1, h());
          this.h[paramMessage.arg1].n = null;
          return true;
          if (paramMessage.obj != null) {
            try
            {
              localObject = (HashMap)paramMessage.obj;
              int i1 = paramMessage.arg1;
              StatisticCollector.getInstance(MobileQQ.getContext()).collectPerformance(null, "unifiedMonitor", true, i1, 0L, (HashMap)localObject, null);
              return true;
            }
            catch (Throwable paramMessage)
            {
              if (QLog.isColorLevel()) {
                paramMessage.printStackTrace();
              }
            }
          }
        }
      }
      return true;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label587;
    }
  }
  
  public boolean handleStart(int paramInt)
  {
    if (this.j == null) {
      return false;
    }
    int i1 = b(paramInt);
    if (!whetherReportDuringThisStartup(i1)) {
      return false;
    }
    if (this.h[i1].i >= this.h[i1].b)
    {
      this.j.removeMessages(c(paramInt));
      d(i1);
      return false;
    }
    paramInt = c(paramInt);
    this.j.removeMessages(paramInt, Thread.currentThread());
    Message localMessage = this.j.obtainMessage(paramInt, Thread.currentThread());
    localMessage.arg1 = i1;
    this.j.sendMessageDelayed(localMessage, this.h[i1].a);
    return true;
  }
  
  public void notifyNotTimeout(int paramInt)
  {
    UnifiedMonitor.FamilyConfig[] arrayOfFamilyConfig = this.h;
    arrayOfFamilyConfig[paramInt].o = 0L;
    arrayOfFamilyConfig[paramInt].n = null;
    if ((paramInt == 0) || (paramInt == 10)) {
      this.d.removeMessages(2);
    }
  }
  
  public void reportStackIfTimeout(int paramInt)
  {
    this.h[paramInt].o = SystemClock.uptimeMillis();
    UnifiedMonitor.FamilyConfig[] arrayOfFamilyConfig = this.h;
    arrayOfFamilyConfig[paramInt].n = null;
    arrayOfFamilyConfig[paramInt].m = false;
  }
  
  public boolean setMonitoredThread(int paramInt, Thread paramThread, AbstractUnifiedMonitor.ThreadMonitorCallback arg3)
  {
    if ((paramThread != null) && (this.h[paramInt].l) && (this.h[paramInt].q == null))
    {
      if (this.h[paramInt].e <= 0) {
        return false;
      }
      ??? = new StringBuilder();
      ???.append("setMonitoredThread for family=");
      ???.append(paramInt);
      QLog.d("UnifiedMonitor_QAPM", 1, ???.toString());
      synchronized (this.h[paramInt])
      {
        if (this.h[paramInt].q == null)
        {
          this.h[paramInt].q = new UnifiedMonitor.StackGetterJob(this, paramInt, paramThread);
          paramThread = this.h[paramInt].q;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("um-stack-fetcher-");
          localStringBuilder.append(paramInt);
          ThreadManager.newFreeThread(paramThread, localStringBuilder.toString(), 5).start();
          this.h[paramInt].p = true;
          return true;
        }
        return false;
      }
    }
    return false;
  }
  
  public boolean whetherReportDuringThisStartup(int paramInt)
  {
    if (paramInt >= 21) {
      return false;
    }
    return this.h[paramInt].l;
  }
  
  public boolean whetherReportThisTime(int paramInt)
  {
    if (this.a)
    {
      if (!this.h[paramInt].l) {
        return false;
      }
      if (this.h[paramInt].p) {
        return this.h[paramInt].m;
      }
      return whetherReportThisTime(paramInt, false);
    }
    return false;
  }
  
  public boolean whetherReportThisTime(int paramInt, boolean paramBoolean)
  {
    float f1 = this.h[paramInt].d;
    if (this.h[paramInt].i >= this.h[paramInt].b) {
      return false;
    }
    return Math.random() <= f1;
  }
  
  public boolean whetherStackEnabled(int paramInt)
  {
    return this.h[paramInt].p;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqperf.UnifiedMonitor
 * JD-Core Version:    0.7.0.1
 */