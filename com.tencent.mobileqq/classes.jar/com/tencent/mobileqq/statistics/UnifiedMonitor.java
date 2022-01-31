package com.tencent.mobileqq.statistics;

import aigi;
import aigj;
import aigk;
import aigl;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mfsdk.reporter.StackObservable;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.LooperMonitorHelper;
import com.tencent.mobileqq.app.ProcessStats;
import com.tencent.mobileqq.app.ProcessStats.Stats;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.monitor.MsfMonitorCallback;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.ProcessUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.Foreground;
import mqq.app.MainService;
import mqq.util.AbstractUnifiedMonitor;
import mqq.util.AbstractUnifiedMonitor.ThreadMonitorCallback;

public class UnifiedMonitor
  extends AbstractUnifiedMonitor
  implements Handler.Callback, MsfMonitorCallback
{
  private static int jdField_a_of_type_Int = -1;
  private static UnifiedMonitor jdField_a_of_type_ComTencentMobileqqStatisticsUnifiedMonitor;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private String jdField_a_of_type_JavaLangString;
  public volatile boolean a;
  private aigj[] jdField_a_of_type_ArrayOfAigj = { new aigj(0.001F, 100, 10, 0.1F, 6, 0, 0, 0, false), new aigj(), new aigj(), new aigj(), new aigj(0.001F, 180000, 2, 1.0F, 6, 0, 0, 0, true), new aigj(0.001F, 180000, 2, 1.0F, 6, 0, 0, 0, true), new aigj(0.001F, 1000, 10, 0.001F, 0, 0, 0, 0, false), new aigj(0.001F, 180000, 2, 1.0F, 6, 6, 0, 0, true), new aigj(0.001F, 0, 10, 0.1F, 0, 0, 0, 0, false), new aigj(0.01F, 100, 5, 0.01F, 0, 0, 0, 0, false), new aigj(0.001F, 100, 10, 0.1F, 6, 0, 0, 0, false), new aigk(0.0F, 100100005, 1, 0.01F, 0, 0, 2, 300), new aigj(0.01F, 100, 5, 0.01F, 0, 0, 0, 0, false), new aigj(0.001F, 180000, 10, 1.0F, 6, 0, 0, 0, true), new aigj(0.001F, 100, 5, 0.01F, 6, 0, 0, 0, false), new aigj(0.001F, 600000, 2, 1.0F, 6, 0, 0, 0, true), new aigj(0.001F, 180000, 2, 1.0F, 6, 0, 0, 0, true), new aigj(0.001F, 180000, 2, 1.0F, 6, 0, 0, 0, true), new aigj(0.001F, 180000, 2, 1.0F, 6, 0, 0, 0, true), new aigj(0.001F, 100, 5, 0.01F, 6, 0, 0, 0, false) };
  private Handler jdField_b_of_type_AndroidOsHandler;
  private HandlerThread jdField_b_of_type_AndroidOsHandlerThread;
  private String jdField_b_of_type_JavaLangString;
  private Handler jdField_c_of_type_AndroidOsHandler;
  private String jdField_c_of_type_JavaLangString;
  
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
  
  public static HashMap a()
  {
    Object localObject1;
    if (2 == BaseApplicationImpl.sProcessId)
    {
      localObject1 = new HashMap(8);
      try
      {
        String[] arrayOfString = ProcessUtils.c().split("/");
        ((HashMap)localObject1).put("act", arrayOfString[(arrayOfString.length - 1)]);
        return localObject1;
      }
      catch (Exception localException)
      {
        ((HashMap)localObject1).put("act", "QZoneFriendFeedActivity");
        return localObject1;
      }
    }
    Object localObject2 = Foreground.getTopActivity();
    if (localObject2 != null)
    {
      localObject1 = localObject2.getClass().getName();
      if (((localObject2 instanceof SplashActivity)) && (SplashActivity.jdField_a_of_type_Int == 1)) {
        localObject1 = (String)localObject1 + "_" + ((SplashActivity)localObject2).a();
      }
      for (;;)
      {
        localObject2 = new HashMap(8);
        ((HashMap)localObject2).put("act", localObject1);
        return localObject2;
      }
    }
    return null;
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_ArrayOfAigj[paramInt].jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ArrayOfAigj[paramInt].jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ArrayOfAigj[paramInt].jdField_a_of_type_Aigl = null;
    this.jdField_a_of_type_ArrayOfAigj[paramInt].jdField_c_of_type_Boolean = false;
    if (this.jdField_a_of_type_ArrayOfAigj[paramInt].jdField_a_of_type_MqqUtilAbstractUnifiedMonitor$ThreadMonitorCallback != null)
    {
      this.jdField_a_of_type_ArrayOfAigj[paramInt].jdField_a_of_type_MqqUtilAbstractUnifiedMonitor$ThreadMonitorCallback.onThreadMonitorEnd(paramInt);
      this.jdField_a_of_type_ArrayOfAigj[paramInt].jdField_a_of_type_MqqUtilAbstractUnifiedMonitor$ThreadMonitorCallback = null;
    }
  }
  
  private void a(int paramInt, Thread paramThread)
  {
    if ((!this.jdField_a_of_type_Boolean) || (!whetherReportDuringThisStartup(paramInt))) {
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
        str = ThreadTraceHelper.a(String.valueOf(paramInt));
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
            break label755;
          }
          if (MsfCore.sCore != null) {
            localObject = MsfCore.sCore.getMainAccount();
          }
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            break label786;
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
          localStatisticCollector = StatisticCollector.a(BaseApplicationImpl.getApplication());
          if (j != 1) {
            break label844;
          }
        }
        localStringBuilder.append(l).append("|").append(this.jdField_b_of_type_JavaLangString).append("|").append(this.jdField_c_of_type_JavaLangString);
        localStringBuilder.append("|").append(this.jdField_a_of_type_JavaLangString).append("|").append(System.currentTimeMillis());
        localStringBuilder.append("|").append(paramInt).append("|").append(Build.MODEL).append("|").append(Build.VERSION.RELEASE);
        localStringBuilder.append("|").append("monitorThread=").append(paramThread.getName()).append(",tid=").append(paramThread.getId()).append(",state=").append(paramThread.getState());
        localStringBuilder.append(ThreadTraceHelper.a());
        localStringBuilder.append(ThreadTraceHelper.b());
        l = SystemClock.uptimeMillis();
        j = ThreadTraceHelper.a(BaseApplicationImpl.getContext(), str, localStringBuilder.toString());
        l = SystemClock.uptimeMillis() - l;
        if (j == 1) {
          break label986;
        }
      }
      label786:
      label797:
      label802:
      label808:
      label844:
      label986:
      for (boolean bool1 = ThreadTraceHelper.a(str, localStringBuilder.toString());; bool1 = true)
      {
        paramThread = new HashMap(2);
        paramThread.put("key_code", String.valueOf(j));
        if (QLog.isColorLevel())
        {
          i = 1;
          paramThread.put("is_color_level", String.valueOf(i));
          if (!BaseApplication.monitorBan) {
            break label797;
          }
          i = 1;
          paramThread.put("monitor_ban", String.valueOf(i));
          paramThread.put("event_family", String.valueOf(paramInt));
          if (4 != BaseApplicationImpl.sProcessId) {
            break label808;
          }
          if (MsfCore.sCore != null)
          {
            localObject = MsfCore.sCore;
            if (j != 1) {
              break label802;
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
          paramThread = this.jdField_a_of_type_ArrayOfAigj[paramInt];
          paramThread.g += 1;
          return;
          label755:
          localObject = ((QQAppInterface)BaseApplicationImpl.getApplication().waitAppRuntime(null)).getAccount();
          break;
          StatisticCollector localStatisticCollector;
          for (boolean bool2 = true;; bool2 = false)
          {
            localStatisticCollector.a(null, "event_held_thread", bool2, l, 0L, paramThread, null);
            break;
          }
          paramThread = new HashMap(2);
          paramThread.put("key_code", String.valueOf(7));
          if (QLog.isColorLevel())
          {
            i = 1;
            label880:
            paramThread.put("is_color_level", String.valueOf(i));
            if (!BaseApplication.monitorBan) {
              break label960;
            }
          }
          for (i = 1;; i = 0)
          {
            paramThread.put("monitor_ban", String.valueOf(i));
            paramThread.put("event_family", String.valueOf(paramInt));
            if (4 != BaseApplicationImpl.sProcessId) {
              break label965;
            }
            if (MsfCore.sCore == null) {
              break;
            }
            MsfCore.sCore.reportRDM("event_held_thread_msf", false, 0L, 0L, paramThread, false, false);
            break;
            i = 0;
            break label880;
          }
          StatisticCollector.a(BaseApplicationImpl.getApplication()).a(null, "event_held_thread", false, 0L, 0L, paramThread, null);
        }
      }
      label960:
      label965:
      i = 1;
      continue;
      localSharedPreferences = null;
      i = 1;
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
  
  private void d()
  {
    new Handler(Looper.getMainLooper()).post(new aigi(this));
    if (2 == BaseApplicationImpl.sProcessId) {
      LooperMonitorHelper.b();
    }
    if (4 == BaseApplicationImpl.sProcessId) {
      f();
    }
    if (7 == BaseApplicationImpl.sProcessId) {
      LooperMonitorHelper.h();
    }
    if (1 != BaseApplicationImpl.sProcessId) {
      return;
    }
    if (whetherReportDuringThisStartup(0)) {
      LooperMonitorHelper.a();
    }
    if (whetherReportDuringThisStartup(4)) {
      LooperMonitorHelper.c();
    }
    if (whetherReportDuringThisStartup(5)) {
      LooperMonitorHelper.f();
    }
    if (whetherReportDuringThisStartup(6)) {
      LooperMonitorHelper.g();
    }
    if (whetherReportDuringThisStartup(13)) {
      LooperMonitorHelper.e();
    }
    MainService.setUnifiedMonitorInstance(a());
    e();
  }
  
  private final void e()
  {
    if (whetherReportDuringThisStartup(11))
    {
      Object localObject = new File("/proc/stat");
      if ((this.jdField_a_of_type_AndroidOsHandlerThread == null) && (localObject != null) && (((File)localObject).canRead()))
      {
        this.jdField_a_of_type_AndroidOsHandlerThread = ThreadManager.newFreeHandlerThread("cpu-stats", 0);
        this.jdField_a_of_type_AndroidOsHandlerThread.start();
        localObject = this.jdField_a_of_type_AndroidOsHandlerThread.getLooper();
        if (localObject != null)
        {
          this.jdField_b_of_type_AndroidOsHandler = new Handler((Looper)localObject, this);
          this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(4);
        }
      }
    }
  }
  
  private void f()
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
        LooperMonitorHelper.d();
      }
      return;
      QLog.e("UnifiedMonitor", 1, "MsfCore.sCore is null");
    }
  }
  
  /* Error */
  private void g()
  {
    // Byte code:
    //   0: invokestatic 541	com/tencent/mobileqq/app/DeviceProfileManager:a	()Lcom/tencent/mobileqq/app/DeviceProfileManager;
    //   3: getstatic 547	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:unified_monitor_params	Lcom/tencent/mobileqq/app/DeviceProfileManager$DpcNames;
    //   6: invokevirtual 550	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:name	()Ljava/lang/String;
    //   9: invokevirtual 551	com/tencent/mobileqq/app/DeviceProfileManager:a	(Ljava/lang/String;)Ljava/lang/String;
    //   12: astore 8
    //   14: ldc 192
    //   16: iconst_1
    //   17: new 109	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   24: ldc_w 553
    //   27: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: aload 8
    //   32: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokestatic 555	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   41: aload 8
    //   43: ifnull +583 -> 626
    //   46: aload 8
    //   48: ldc_w 557
    //   51: invokevirtual 79	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   54: astore 10
    //   56: aload 10
    //   58: ifnonnull +20 -> 78
    //   61: aload_0
    //   62: monitorenter
    //   63: aload_0
    //   64: iconst_1
    //   65: putfield 144	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_Boolean	Z
    //   68: aload_0
    //   69: monitorexit
    //   70: return
    //   71: astore 8
    //   73: aload_0
    //   74: monitorexit
    //   75: aload 8
    //   77: athrow
    //   78: aload 10
    //   80: arraylength
    //   81: istore 5
    //   83: iconst_0
    //   84: istore_2
    //   85: iload_2
    //   86: iload 5
    //   88: if_icmpge +538 -> 626
    //   91: aload 10
    //   93: iload_2
    //   94: aaload
    //   95: astore 8
    //   97: aload 8
    //   99: ldc_w 559
    //   102: invokevirtual 79	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   105: astore 11
    //   107: aload 11
    //   109: ifnull +1169 -> 1278
    //   112: aload 11
    //   114: arraylength
    //   115: iconst_2
    //   116: if_icmpne +1162 -> 1278
    //   119: aload 11
    //   121: iconst_0
    //   122: aaload
    //   123: invokestatic 285	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   126: ifne +1152 -> 1278
    //   129: aload 11
    //   131: iconst_1
    //   132: aaload
    //   133: invokestatic 285	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   136: ifne +1142 -> 1278
    //   139: aload 11
    //   141: iconst_0
    //   142: aaload
    //   143: bipush 95
    //   145: invokevirtual 562	java/lang/String:lastIndexOf	(I)I
    //   148: istore 6
    //   150: iload 6
    //   152: iconst_m1
    //   153: if_icmpeq +1132 -> 1285
    //   156: aload 11
    //   158: iconst_0
    //   159: aaload
    //   160: iconst_0
    //   161: iload 6
    //   163: iconst_1
    //   164: iadd
    //   165: invokevirtual 566	java/lang/String:substring	(II)Ljava/lang/String;
    //   168: astore 8
    //   170: iload 6
    //   172: iconst_m1
    //   173: if_icmpeq +1118 -> 1291
    //   176: iload 6
    //   178: aload 11
    //   180: iconst_0
    //   181: aaload
    //   182: invokevirtual 569	java/lang/String:length	()I
    //   185: iconst_1
    //   186: isub
    //   187: if_icmpge +1104 -> 1291
    //   190: aload 11
    //   192: iconst_0
    //   193: aaload
    //   194: iload 6
    //   196: iconst_1
    //   197: iadd
    //   198: invokevirtual 571	java/lang/String:substring	(I)Ljava/lang/String;
    //   201: astore 9
    //   203: iconst_m1
    //   204: istore_3
    //   205: aload 9
    //   207: invokestatic 576	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   210: invokevirtual 579	java/lang/Integer:intValue	()I
    //   213: istore 4
    //   215: iload 4
    //   217: istore_3
    //   218: invokestatic 190	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   221: ifeq +66 -> 287
    //   224: ldc 192
    //   226: iconst_2
    //   227: new 109	java/lang/StringBuilder
    //   230: dup
    //   231: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   234: ldc_w 581
    //   237: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: iload_3
    //   241: invokevirtual 122	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   244: ldc_w 583
    //   247: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: aload 8
    //   252: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: ldc_w 585
    //   258: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: aload 11
    //   263: iconst_0
    //   264: aaload
    //   265: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: ldc_w 587
    //   271: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: aload 11
    //   276: iconst_1
    //   277: aaload
    //   278: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   284: invokestatic 555	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   287: aload 8
    //   289: ifnull +989 -> 1278
    //   292: iload 6
    //   294: iconst_m1
    //   295: if_icmpeq +983 -> 1278
    //   298: iload_3
    //   299: iconst_m1
    //   300: if_icmpeq +978 -> 1278
    //   303: aload 9
    //   305: ifnull +973 -> 1278
    //   308: iload_3
    //   309: bipush 20
    //   311: if_icmpge +967 -> 1278
    //   314: ldc_w 589
    //   317: aload 8
    //   319: invokevirtual 593	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   322: ifeq +25 -> 347
    //   325: aload_0
    //   326: getfield 45	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfAigj	[Laigj;
    //   329: iload_3
    //   330: aaload
    //   331: aload 11
    //   333: iconst_1
    //   334: aaload
    //   335: invokestatic 598	java/lang/Float:valueOf	(Ljava/lang/String;)Ljava/lang/Float;
    //   338: invokevirtual 602	java/lang/Float:floatValue	()F
    //   341: putfield 605	aigj:jdField_a_of_type_Float	F
    //   344: goto +934 -> 1278
    //   347: ldc_w 607
    //   350: aload 8
    //   352: invokevirtual 593	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   355: ifeq +83 -> 438
    //   358: aload_0
    //   359: getfield 45	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfAigj	[Laigj;
    //   362: iload_3
    //   363: aaload
    //   364: aload 11
    //   366: iconst_1
    //   367: aaload
    //   368: invokestatic 576	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   371: invokevirtual 579	java/lang/Integer:intValue	()I
    //   374: putfield 609	aigj:jdField_b_of_type_Int	I
    //   377: goto +901 -> 1278
    //   380: astore 8
    //   382: invokestatic 190	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   385: ifeq +893 -> 1278
    //   388: ldc 192
    //   390: iconst_2
    //   391: ldc_w 405
    //   394: aload 8
    //   396: invokestatic 408	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   399: goto +879 -> 1278
    //   402: astore 8
    //   404: invokestatic 190	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   407: ifeq +14 -> 421
    //   410: ldc 192
    //   412: iconst_2
    //   413: ldc_w 405
    //   416: aload 8
    //   418: invokestatic 611	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   421: aload_0
    //   422: monitorenter
    //   423: aload_0
    //   424: iconst_1
    //   425: putfield 144	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_Boolean	Z
    //   428: aload_0
    //   429: monitorexit
    //   430: return
    //   431: astore 8
    //   433: aload_0
    //   434: monitorexit
    //   435: aload 8
    //   437: athrow
    //   438: ldc_w 613
    //   441: aload 8
    //   443: invokevirtual 593	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   446: ifeq +39 -> 485
    //   449: aload_0
    //   450: getfield 45	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfAigj	[Laigj;
    //   453: iload_3
    //   454: aaload
    //   455: aload 11
    //   457: iconst_1
    //   458: aaload
    //   459: invokestatic 576	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   462: invokevirtual 579	java/lang/Integer:intValue	()I
    //   465: putfield 614	aigj:jdField_a_of_type_Int	I
    //   468: goto +810 -> 1278
    //   471: astore 8
    //   473: aload_0
    //   474: monitorenter
    //   475: aload_0
    //   476: iconst_1
    //   477: putfield 144	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_Boolean	Z
    //   480: aload_0
    //   481: monitorexit
    //   482: aload 8
    //   484: athrow
    //   485: ldc_w 616
    //   488: aload 8
    //   490: invokevirtual 593	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   493: ifeq +26 -> 519
    //   496: aload_0
    //   497: getfield 45	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfAigj	[Laigj;
    //   500: iload_3
    //   501: aaload
    //   502: aload 11
    //   504: iconst_1
    //   505: aaload
    //   506: invokestatic 576	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   509: invokevirtual 579	java/lang/Integer:intValue	()I
    //   512: i2f
    //   513: putfield 618	aigj:jdField_b_of_type_Float	F
    //   516: goto +762 -> 1278
    //   519: ldc_w 620
    //   522: aload 8
    //   524: invokevirtual 593	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   527: ifeq +33 -> 560
    //   530: getstatic 623	android/os/Build$VERSION:SDK_INT	I
    //   533: bipush 17
    //   535: if_icmpeq +743 -> 1278
    //   538: aload_0
    //   539: getfield 45	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfAigj	[Laigj;
    //   542: iload_3
    //   543: aaload
    //   544: aload 11
    //   546: iconst_1
    //   547: aaload
    //   548: invokestatic 576	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   551: invokevirtual 579	java/lang/Integer:intValue	()I
    //   554: putfield 625	aigj:jdField_c_of_type_Int	I
    //   557: goto +721 -> 1278
    //   560: ldc_w 627
    //   563: aload 8
    //   565: invokevirtual 593	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   568: ifeq +25 -> 593
    //   571: aload_0
    //   572: getfield 45	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfAigj	[Laigj;
    //   575: iload_3
    //   576: aaload
    //   577: aload 11
    //   579: iconst_1
    //   580: aaload
    //   581: invokestatic 576	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   584: invokevirtual 579	java/lang/Integer:intValue	()I
    //   587: putfield 629	aigj:jdField_d_of_type_Int	I
    //   590: goto +688 -> 1278
    //   593: ldc_w 631
    //   596: aload 8
    //   598: invokevirtual 593	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   601: ifeq +677 -> 1278
    //   604: aload_0
    //   605: getfield 45	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfAigj	[Laigj;
    //   608: iload_3
    //   609: aaload
    //   610: aload 11
    //   612: iconst_1
    //   613: aaload
    //   614: invokestatic 634	java/lang/Boolean:valueOf	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   617: invokevirtual 637	java/lang/Boolean:booleanValue	()Z
    //   620: putfield 639	aigj:jdField_d_of_type_Boolean	Z
    //   623: goto +655 -> 1278
    //   626: iconst_0
    //   627: istore_2
    //   628: iload_2
    //   629: aload_0
    //   630: getfield 45	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfAigj	[Laigj;
    //   633: arraylength
    //   634: if_icmpge +45 -> 679
    //   637: aload_0
    //   638: getfield 45	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfAigj	[Laigj;
    //   641: iload_2
    //   642: aaload
    //   643: astore 8
    //   645: invokestatic 643	java/lang/Math:random	()D
    //   648: aload_0
    //   649: getfield 45	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfAigj	[Laigj;
    //   652: iload_2
    //   653: aaload
    //   654: getfield 605	aigj:jdField_a_of_type_Float	F
    //   657: f2d
    //   658: dcmpg
    //   659: ifgt +638 -> 1297
    //   662: iconst_1
    //   663: istore 7
    //   665: aload 8
    //   667: iload 7
    //   669: putfield 127	aigj:jdField_a_of_type_Boolean	Z
    //   672: iload_2
    //   673: iconst_1
    //   674: iadd
    //   675: istore_2
    //   676: goto -48 -> 628
    //   679: aload_0
    //   680: getfield 45	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfAigj	[Laigj;
    //   683: bipush 10
    //   685: aaload
    //   686: iconst_0
    //   687: putfield 127	aigj:jdField_a_of_type_Boolean	Z
    //   690: invokestatic 190	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   693: ifeq +64 -> 757
    //   696: aload_0
    //   697: getfield 45	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfAigj	[Laigj;
    //   700: iconst_0
    //   701: aaload
    //   702: iconst_1
    //   703: putfield 127	aigj:jdField_a_of_type_Boolean	Z
    //   706: aload_0
    //   707: getfield 45	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfAigj	[Laigj;
    //   710: iconst_0
    //   711: aaload
    //   712: ldc_w 644
    //   715: putfield 609	aigj:jdField_b_of_type_Int	I
    //   718: aload_0
    //   719: getfield 45	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfAigj	[Laigj;
    //   722: iconst_0
    //   723: aaload
    //   724: fconst_1
    //   725: putfield 618	aigj:jdField_b_of_type_Float	F
    //   728: invokestatic 190	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   731: ifeq +26 -> 757
    //   734: aload_0
    //   735: getfield 45	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfAigj	[Laigj;
    //   738: iconst_0
    //   739: aaload
    //   740: sipush 400
    //   743: putfield 614	aigj:jdField_a_of_type_Int	I
    //   746: aload_0
    //   747: getfield 45	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfAigj	[Laigj;
    //   750: iconst_0
    //   751: aaload
    //   752: ldc 30
    //   754: putfield 646	aigj:jdField_c_of_type_Float	F
    //   757: aload_0
    //   758: getfield 45	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfAigj	[Laigj;
    //   761: bipush 14
    //   763: aaload
    //   764: invokestatic 652	common/config/service/QzoneConfig:getInstance	()Lcommon/config/service/QzoneConfig;
    //   767: ldc_w 654
    //   770: ldc_w 656
    //   773: aload_0
    //   774: getfield 45	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfAigj	[Laigj;
    //   777: bipush 14
    //   779: aaload
    //   780: getfield 614	aigj:jdField_a_of_type_Int	I
    //   783: invokevirtual 660	common/config/service/QzoneConfig:getConfig	(Ljava/lang/String;Ljava/lang/String;I)I
    //   786: putfield 614	aigj:jdField_a_of_type_Int	I
    //   789: invokestatic 652	common/config/service/QzoneConfig:getInstance	()Lcommon/config/service/QzoneConfig;
    //   792: ldc_w 654
    //   795: ldc_w 662
    //   798: invokevirtual 665	common/config/service/QzoneConfig:getConfig	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   801: astore 9
    //   803: invokestatic 652	common/config/service/QzoneConfig:getInstance	()Lcommon/config/service/QzoneConfig;
    //   806: ldc_w 654
    //   809: ldc_w 667
    //   812: invokevirtual 665	common/config/service/QzoneConfig:getConfig	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   815: astore 8
    //   817: aload 9
    //   819: invokestatic 285	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   822: istore 7
    //   824: iload 7
    //   826: ifne +29 -> 855
    //   829: aload 9
    //   831: invokestatic 598	java/lang/Float:valueOf	(Ljava/lang/String;)Ljava/lang/Float;
    //   834: invokevirtual 602	java/lang/Float:floatValue	()F
    //   837: fstore_1
    //   838: fload_1
    //   839: fconst_0
    //   840: fcmpl
    //   841: iflt +14 -> 855
    //   844: aload_0
    //   845: getfield 45	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfAigj	[Laigj;
    //   848: bipush 14
    //   850: aaload
    //   851: fload_1
    //   852: putfield 605	aigj:jdField_a_of_type_Float	F
    //   855: aload 8
    //   857: invokestatic 285	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   860: istore 7
    //   862: iload 7
    //   864: ifne +29 -> 893
    //   867: aload 8
    //   869: invokestatic 598	java/lang/Float:valueOf	(Ljava/lang/String;)Ljava/lang/Float;
    //   872: invokevirtual 602	java/lang/Float:floatValue	()F
    //   875: fstore_1
    //   876: fload_1
    //   877: fconst_0
    //   878: fcmpl
    //   879: iflt +14 -> 893
    //   882: aload_0
    //   883: getfield 45	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfAigj	[Laigj;
    //   886: bipush 14
    //   888: aaload
    //   889: fload_1
    //   890: putfield 618	aigj:jdField_b_of_type_Float	F
    //   893: getstatic 61	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   896: iconst_4
    //   897: if_icmpne +3 -> 900
    //   900: getstatic 61	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   903: iconst_1
    //   904: if_icmpne +14 -> 918
    //   907: aload_0
    //   908: getfield 45	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfAigj	[Laigj;
    //   911: bipush 11
    //   913: aaload
    //   914: iconst_0
    //   915: putfield 127	aigj:jdField_a_of_type_Boolean	Z
    //   918: invokestatic 671	com/tencent/mobileqq/util/Utils:c	()Z
    //   921: ifeq +152 -> 1073
    //   924: getstatic 61	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   927: iconst_1
    //   928: if_icmpne +182 -> 1110
    //   931: aload_0
    //   932: getfield 45	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfAigj	[Laigj;
    //   935: iconst_4
    //   936: aaload
    //   937: getfield 605	aigj:jdField_a_of_type_Float	F
    //   940: fconst_0
    //   941: fcmpl
    //   942: ifle +168 -> 1110
    //   945: aload_0
    //   946: getfield 45	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfAigj	[Laigj;
    //   949: iconst_5
    //   950: aaload
    //   951: getfield 605	aigj:jdField_a_of_type_Float	F
    //   954: fconst_0
    //   955: fcmpl
    //   956: ifle +154 -> 1110
    //   959: aload_0
    //   960: getfield 45	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfAigj	[Laigj;
    //   963: bipush 13
    //   965: aaload
    //   966: getfield 605	aigj:jdField_a_of_type_Float	F
    //   969: fconst_0
    //   970: fcmpl
    //   971: ifle +139 -> 1110
    //   974: aload_0
    //   975: getfield 45	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfAigj	[Laigj;
    //   978: bipush 7
    //   980: aaload
    //   981: getfield 605	aigj:jdField_a_of_type_Float	F
    //   984: fconst_0
    //   985: fcmpl
    //   986: ifle +124 -> 1110
    //   989: aload_0
    //   990: getfield 45	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfAigj	[Laigj;
    //   993: iconst_4
    //   994: aaload
    //   995: iconst_1
    //   996: putfield 127	aigj:jdField_a_of_type_Boolean	Z
    //   999: aload_0
    //   1000: getfield 45	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfAigj	[Laigj;
    //   1003: iconst_5
    //   1004: aaload
    //   1005: iconst_1
    //   1006: putfield 127	aigj:jdField_a_of_type_Boolean	Z
    //   1009: aload_0
    //   1010: getfield 45	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfAigj	[Laigj;
    //   1013: bipush 13
    //   1015: aaload
    //   1016: iconst_1
    //   1017: putfield 127	aigj:jdField_a_of_type_Boolean	Z
    //   1020: aload_0
    //   1021: getfield 45	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfAigj	[Laigj;
    //   1024: bipush 7
    //   1026: aaload
    //   1027: iconst_1
    //   1028: putfield 127	aigj:jdField_a_of_type_Boolean	Z
    //   1031: new 63	java/util/HashMap
    //   1034: dup
    //   1035: iconst_2
    //   1036: invokespecial 66	java/util/HashMap:<init>	(I)V
    //   1039: astore 8
    //   1041: aload 8
    //   1043: ldc_w 673
    //   1046: iconst_1
    //   1047: invokestatic 207	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1050: invokevirtual 85	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1053: pop
    //   1054: invokestatic 225	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   1057: invokestatic 413	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   1060: aconst_null
    //   1061: ldc_w 675
    //   1064: iconst_1
    //   1065: lconst_0
    //   1066: lconst_0
    //   1067: aload 8
    //   1069: aconst_null
    //   1070: invokevirtual 418	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   1073: aload_0
    //   1074: monitorenter
    //   1075: aload_0
    //   1076: iconst_1
    //   1077: putfield 144	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_Boolean	Z
    //   1080: aload_0
    //   1081: monitorexit
    //   1082: return
    //   1083: astore 8
    //   1085: aload_0
    //   1086: monitorexit
    //   1087: aload 8
    //   1089: athrow
    //   1090: astore 9
    //   1092: aload 9
    //   1094: invokevirtual 678	java/lang/Exception:printStackTrace	()V
    //   1097: goto -242 -> 855
    //   1100: astore 8
    //   1102: aload 8
    //   1104: invokevirtual 678	java/lang/Exception:printStackTrace	()V
    //   1107: goto -214 -> 893
    //   1110: getstatic 61	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   1113: iconst_4
    //   1114: if_icmpne -41 -> 1073
    //   1117: aload_0
    //   1118: getfield 45	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfAigj	[Laigj;
    //   1121: bipush 15
    //   1123: aaload
    //   1124: getfield 605	aigj:jdField_a_of_type_Float	F
    //   1127: fconst_0
    //   1128: fcmpl
    //   1129: ifle -56 -> 1073
    //   1132: aload_0
    //   1133: getfield 45	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfAigj	[Laigj;
    //   1136: bipush 16
    //   1138: aaload
    //   1139: getfield 605	aigj:jdField_a_of_type_Float	F
    //   1142: fconst_0
    //   1143: fcmpl
    //   1144: ifle -71 -> 1073
    //   1147: aload_0
    //   1148: getfield 45	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfAigj	[Laigj;
    //   1151: bipush 17
    //   1153: aaload
    //   1154: getfield 605	aigj:jdField_a_of_type_Float	F
    //   1157: fconst_0
    //   1158: fcmpl
    //   1159: ifle -86 -> 1073
    //   1162: aload_0
    //   1163: getfield 45	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfAigj	[Laigj;
    //   1166: bipush 18
    //   1168: aaload
    //   1169: getfield 605	aigj:jdField_a_of_type_Float	F
    //   1172: fconst_0
    //   1173: fcmpl
    //   1174: ifle -101 -> 1073
    //   1177: aload_0
    //   1178: getfield 45	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfAigj	[Laigj;
    //   1181: bipush 15
    //   1183: aaload
    //   1184: iconst_1
    //   1185: putfield 127	aigj:jdField_a_of_type_Boolean	Z
    //   1188: aload_0
    //   1189: getfield 45	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfAigj	[Laigj;
    //   1192: bipush 16
    //   1194: aaload
    //   1195: iconst_1
    //   1196: putfield 127	aigj:jdField_a_of_type_Boolean	Z
    //   1199: aload_0
    //   1200: getfield 45	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfAigj	[Laigj;
    //   1203: bipush 17
    //   1205: aaload
    //   1206: iconst_1
    //   1207: putfield 127	aigj:jdField_a_of_type_Boolean	Z
    //   1210: aload_0
    //   1211: getfield 45	com/tencent/mobileqq/statistics/UnifiedMonitor:jdField_a_of_type_ArrayOfAigj	[Laigj;
    //   1214: bipush 18
    //   1216: aaload
    //   1217: iconst_1
    //   1218: putfield 127	aigj:jdField_a_of_type_Boolean	Z
    //   1221: new 63	java/util/HashMap
    //   1224: dup
    //   1225: iconst_2
    //   1226: invokespecial 66	java/util/HashMap:<init>	(I)V
    //   1229: astore 8
    //   1231: aload 8
    //   1233: ldc_w 673
    //   1236: iconst_2
    //   1237: invokestatic 207	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1240: invokevirtual 85	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1243: pop
    //   1244: invokestatic 225	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   1247: invokestatic 413	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   1250: aconst_null
    //   1251: ldc_w 675
    //   1254: iconst_1
    //   1255: lconst_0
    //   1256: lconst_0
    //   1257: aload 8
    //   1259: aconst_null
    //   1260: invokevirtual 418	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   1263: goto -190 -> 1073
    //   1266: astore 8
    //   1268: aload_0
    //   1269: monitorexit
    //   1270: aload 8
    //   1272: athrow
    //   1273: astore 12
    //   1275: goto -1057 -> 218
    //   1278: iload_2
    //   1279: iconst_1
    //   1280: iadd
    //   1281: istore_2
    //   1282: goto -1197 -> 85
    //   1285: aconst_null
    //   1286: astore 8
    //   1288: goto -1118 -> 170
    //   1291: aconst_null
    //   1292: astore 9
    //   1294: goto -1091 -> 203
    //   1297: iconst_0
    //   1298: istore 7
    //   1300: goto -635 -> 665
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1303	0	this	UnifiedMonitor
    //   837	53	1	f	float
    //   84	1198	2	i	int
    //   204	405	3	j	int
    //   213	3	4	k	int
    //   81	8	5	m	int
    //   148	148	6	n	int
    //   663	636	7	bool	boolean
    //   12	35	8	str1	String
    //   71	5	8	localObject1	Object
    //   95	256	8	str2	String
    //   380	15	8	localThrowable1	Throwable
    //   402	15	8	localThrowable2	Throwable
    //   431	11	8	localObject2	Object
    //   471	126	8	localObject3	Object
    //   643	425	8	localObject4	Object
    //   1083	5	8	localObject5	Object
    //   1100	3	8	localException1	Exception
    //   1229	29	8	localHashMap	HashMap
    //   1266	5	8	localObject6	Object
    //   1286	1	8	localObject7	Object
    //   201	629	9	str3	String
    //   1090	3	9	localException2	Exception
    //   1292	1	9	localObject8	Object
    //   54	38	10	arrayOfString1	String[]
    //   105	506	11	arrayOfString2	String[]
    //   1273	1	12	localNumberFormatException	java.lang.NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   63	70	71	finally
    //   73	75	71	finally
    //   97	107	380	java/lang/Throwable
    //   112	150	380	java/lang/Throwable
    //   156	170	380	java/lang/Throwable
    //   176	203	380	java/lang/Throwable
    //   205	215	380	java/lang/Throwable
    //   218	287	380	java/lang/Throwable
    //   314	344	380	java/lang/Throwable
    //   347	377	380	java/lang/Throwable
    //   438	468	380	java/lang/Throwable
    //   485	516	380	java/lang/Throwable
    //   519	557	380	java/lang/Throwable
    //   560	590	380	java/lang/Throwable
    //   593	623	380	java/lang/Throwable
    //   0	41	402	java/lang/Throwable
    //   46	56	402	java/lang/Throwable
    //   78	83	402	java/lang/Throwable
    //   382	399	402	java/lang/Throwable
    //   628	662	402	java/lang/Throwable
    //   665	672	402	java/lang/Throwable
    //   679	757	402	java/lang/Throwable
    //   757	824	402	java/lang/Throwable
    //   829	838	402	java/lang/Throwable
    //   844	855	402	java/lang/Throwable
    //   855	862	402	java/lang/Throwable
    //   867	876	402	java/lang/Throwable
    //   882	893	402	java/lang/Throwable
    //   893	900	402	java/lang/Throwable
    //   900	918	402	java/lang/Throwable
    //   918	1073	402	java/lang/Throwable
    //   1092	1097	402	java/lang/Throwable
    //   1102	1107	402	java/lang/Throwable
    //   1110	1263	402	java/lang/Throwable
    //   423	430	431	finally
    //   433	435	431	finally
    //   0	41	471	finally
    //   46	56	471	finally
    //   78	83	471	finally
    //   97	107	471	finally
    //   112	150	471	finally
    //   156	170	471	finally
    //   176	203	471	finally
    //   205	215	471	finally
    //   218	287	471	finally
    //   314	344	471	finally
    //   347	377	471	finally
    //   382	399	471	finally
    //   404	421	471	finally
    //   438	468	471	finally
    //   485	516	471	finally
    //   519	557	471	finally
    //   560	590	471	finally
    //   593	623	471	finally
    //   628	662	471	finally
    //   665	672	471	finally
    //   679	757	471	finally
    //   757	824	471	finally
    //   829	838	471	finally
    //   844	855	471	finally
    //   855	862	471	finally
    //   867	876	471	finally
    //   882	893	471	finally
    //   893	900	471	finally
    //   900	918	471	finally
    //   918	1073	471	finally
    //   1092	1097	471	finally
    //   1102	1107	471	finally
    //   1110	1263	471	finally
    //   1075	1082	1083	finally
    //   1085	1087	1083	finally
    //   829	838	1090	java/lang/Exception
    //   844	855	1090	java/lang/Exception
    //   867	876	1100	java/lang/Exception
    //   882	893	1100	java/lang/Exception
    //   475	482	1266	finally
    //   1268	1270	1266	finally
    //   205	215	1273	java/lang/NumberFormatException
  }
  
  public void a()
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
  
  public void addEvent(int paramInt1, String paramString, int paramInt2, int paramInt3, Map paramMap)
  {
    if ((!this.jdField_a_of_type_Boolean) || (!whetherReportDuringThisStartup(paramInt1))) {}
    String str;
    do
    {
      return;
      str = this.jdField_a_of_type_ArrayOfAigj[paramInt1].jdField_a_of_type_JavaLangString;
    } while ((this.jdField_a_of_type_ArrayOfAigj[paramInt1].jdField_c_of_type_Boolean) && (TextUtils.isEmpty(str)));
    Object localObject = paramMap;
    if (paramMap == null) {
      localObject = new HashMap(17);
    }
    ((Map)localObject).put("family", String.valueOf(paramInt1));
    boolean bool;
    if (paramString != null)
    {
      ((Map)localObject).put("event", paramString);
      ((Map)localObject).put("revision", "351230");
      if (this.jdField_a_of_type_JavaLangString == null)
      {
        this.jdField_a_of_type_JavaLangString = "dbg";
        this.jdField_a_of_type_JavaLangString = "pub";
      }
      ((Map)localObject).put("build_type", this.jdField_a_of_type_JavaLangString);
      if (SystemClock.uptimeMillis() - ProcessStats.jdField_a_of_type_Long < 60000L)
      {
        ((Map)localObject).put("totalCpu", String.valueOf(ProcessStats.jdField_a_of_type_Int));
        ((Map)localObject).put("appCpu", String.valueOf(ProcessStats.jdField_a_of_type_ComTencentMobileqqAppProcessStats$Stats.jdField_a_of_type_Int));
        ((Map)localObject).put("cpu_update_time", String.valueOf((SystemClock.uptimeMillis() - ProcessStats.jdField_a_of_type_Long) / 1000L));
      }
      if (paramInt1 == 0)
      {
        paramString = BaseApplicationImpl.getApplication().getRuntime();
        if ((paramString != null) && ((paramString instanceof QQAppInterface)))
        {
          if (((QQAppInterface)paramString).a.jdField_a_of_type_Long == 0L) {
            break label470;
          }
          bool = true;
          label262:
          ((Map)localObject).put("param_is_logining", String.valueOf(bool));
          if (((QQAppInterface)paramString).a.c()) {
            break label476;
          }
          bool = true;
          label294:
          ((Map)localObject).put("param_syncing_msg", String.valueOf(bool));
        }
        ((Map)localObject).put("max_heap_size", String.valueOf(Runtime.getRuntime().maxMemory()));
        ((Map)localObject).put("currentHeapSize", String.valueOf(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));
      }
      ((Map)localObject).put("wal_enable", String.valueOf(jdField_a_of_type_Int));
      if (!QLog.isColorLevel()) {
        break label482;
      }
      paramString = "-1";
      label384:
      ((Map)localObject).put("not_reported", paramString);
      if (str != null)
      {
        if (str.length() > 950) {
          break label491;
        }
        ((Map)localObject).put("stack", str);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 1, paramInt2, 0, localObject));
      paramString = this.jdField_a_of_type_ArrayOfAigj[paramInt1];
      paramString.g += 1;
      return;
      paramString = "";
      break;
      label470:
      bool = false;
      break label262;
      label476:
      bool = false;
      break label294;
      label482:
      paramString = String.valueOf(paramInt3);
      break label384;
      label491:
      ((Map)localObject).put("stack", str.substring(0, 950));
      ((Map)localObject).put("stack1", str.substring(950));
    }
  }
  
  public void b() {}
  
  public void c()
  {
    int i = 0;
    try
    {
      a();
      ThreadTraceHelper.a(BaseApplicationImpl.getContext());
      ArrayList localArrayList = ThreadTraceHelper.a(BaseApplicationImpl.getContext());
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
  
  public int getThreshold(int paramInt)
  {
    return this.jdField_a_of_type_ArrayOfAigj[paramInt].jdField_a_of_type_Int;
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
          break label294;
        }
        if (Math.random() >= this.jdField_a_of_type_ArrayOfAigj[j].jdField_c_of_type_Float) {
          continue;
        }
        StackObservable.a().a((HashMap)localObject, i);
        StatisticCollector.a(BaseApplicationImpl.getApplication()).a(null, "unifiedMonitor", true, i, 0L, (HashMap)localObject, null);
        return true;
      }
      catch (Throwable paramMessage) {}
      if (!QLog.isColorLevel()) {
        continue;
      }
      paramMessage.printStackTrace();
      return true;
      label294:
      StatisticCollector.a(BaseApplicationImpl.getApplication()).a(null, "unifiedMonitor", true, i, 0L, (HashMap)localObject, null);
      return true;
      StackObservable.a().a((HashMap)paramMessage.obj);
      return true;
      addEvent(paramMessage.arg1, "", 3000, -1, a());
      this.jdField_a_of_type_ArrayOfAigj[paramMessage.arg1].jdField_a_of_type_JavaLangString = null;
      return true;
      g();
      d();
      return true;
      this.jdField_a_of_type_ArrayOfAigj[11].jdField_a_of_type_Long = SystemClock.uptimeMillis();
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(5, 2000L);
      return true;
      ProcessStats.a(false);
      if (this.jdField_b_of_type_AndroidOsHandler.hasMessages(7)) {
        continue;
      }
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(6, 1500L);
      return true;
      ProcessStats.b(false);
      paramMessage = (aigk)this.jdField_a_of_type_ArrayOfAigj[11];
      if (whetherReportThisTime(11, true))
      {
        localObject = new HashMap(10);
        ((Map)localObject).put("total_cpu", String.valueOf(ProcessStats.jdField_a_of_type_Int));
        ((Map)localObject).put("app_cpu", String.valueOf(ProcessStats.jdField_a_of_type_ComTencentMobileqqAppProcessStats$Stats.jdField_a_of_type_Int));
        a().addEvent(11, null, 0, 0, (Map)localObject);
      }
      if ((ProcessStats.jdField_a_of_type_Int >= paramMessage.j) || (ProcessStats.jdField_a_of_type_ComTencentMobileqqAppProcessStats$Stats.jdField_a_of_type_Int >= paramMessage.k)) {
        if ((QLog.isColorLevel()) && (SystemClock.uptimeMillis() - paramMessage.c > 60000L))
        {
          QLog.d("UnifiedMonitor", 2, "totalCpu exceed: " + ProcessStats.jdField_a_of_type_Int + ", appCpu: " + ProcessStats.jdField_a_of_type_ComTencentMobileqqAppProcessStats$Stats.jdField_a_of_type_Int);
          ProcessStats.a(true);
        }
      }
      try
      {
        Thread.sleep(2000L);
        label615:
        ProcessStats.b(true);
        localObject = ProcessStats.a(paramMessage.l, true).iterator();
        while (((Iterator)localObject).hasNext()) {
          QLog.d("UnifiedMonitor", 2, (String)((Iterator)localObject).next());
        }
        QLog.d("UnifiedMonitor", 2, ProcessStats.a(10));
        localObject = ProcessStats.a(paramMessage.l, true).iterator();
        while (((Iterator)localObject).hasNext()) {
          QLog.d("UnifiedMonitor", 2, (String)((Iterator)localObject).next());
        }
        paramMessage.c = SystemClock.uptimeMillis();
        label725:
        paramMessage.h += 1;
        while ((paramMessage.h < paramMessage.e) && (SystemClock.uptimeMillis() - paramMessage.jdField_a_of_type_Long < paramMessage.f * 1000L))
        {
          this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(5, 2000L);
          return true;
          QLog.d("UnifiedMonitor", 1, "totalCpu exceed: " + ProcessStats.jdField_a_of_type_Int + ", appCpu: " + ProcessStats.jdField_a_of_type_ComTencentMobileqqAppProcessStats$Stats.jdField_a_of_type_Int);
          break label725;
          if (QLog.isColorLevel()) {
            QLog.d("UnifiedMonitor", 2, "totalCpu: " + ProcessStats.jdField_a_of_type_Int + ", appCpu: " + ProcessStats.jdField_a_of_type_ComTencentMobileqqAppProcessStats$Stats.jdField_a_of_type_Int);
          }
          paramMessage.m = 1;
        }
        this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
        ProcessStats.a(true);
        this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(8, 10000L);
        return true;
        ProcessStats.b(true);
        localObject = (aigk)this.jdField_a_of_type_ArrayOfAigj[11];
        if (!QLog.isColorLevel()) {
          continue;
        }
        localObject = ProcessStats.a(((aigk)localObject).l, true);
        QLog.d("UnifiedMonitor", 2, "trace " + paramMessage.obj + "'s cpu end(" + ProcessStats.jdField_a_of_type_Int + ", " + ProcessStats.jdField_a_of_type_ComTencentMobileqqAppProcessStats$Stats.jdField_a_of_type_Int + ")");
        paramMessage = ((List)localObject).iterator();
        while (paramMessage.hasNext()) {
          QLog.d("UnifiedMonitor", 2, (String)paramMessage.next());
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        break label615;
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
    if (this.jdField_a_of_type_ArrayOfAigj[i].g >= this.jdField_a_of_type_ArrayOfAigj[i].jdField_b_of_type_Int)
    {
      this.jdField_c_of_type_AndroidOsHandler.removeMessages(b(paramInt));
      a(i);
      return false;
    }
    paramInt = b(paramInt);
    this.jdField_c_of_type_AndroidOsHandler.removeMessages(paramInt, Thread.currentThread());
    Message localMessage = this.jdField_c_of_type_AndroidOsHandler.obtainMessage(paramInt, Thread.currentThread());
    localMessage.arg1 = i;
    this.jdField_c_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, this.jdField_a_of_type_ArrayOfAigj[i].jdField_a_of_type_Int);
    return true;
  }
  
  public void notifyNotTimeout(int paramInt)
  {
    this.jdField_a_of_type_ArrayOfAigj[paramInt].jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_ArrayOfAigj[paramInt].jdField_a_of_type_JavaLangString = null;
    if ((paramInt == 0) || (paramInt == 10)) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
    }
  }
  
  public void reportStackIfTimeout(int paramInt)
  {
    this.jdField_a_of_type_ArrayOfAigj[paramInt].jdField_b_of_type_Long = SystemClock.uptimeMillis();
    this.jdField_a_of_type_ArrayOfAigj[paramInt].jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_ArrayOfAigj[paramInt].jdField_b_of_type_Boolean = false;
  }
  
  public boolean setMonitoredThread(int paramInt, Thread paramThread, AbstractUnifiedMonitor.ThreadMonitorCallback arg3)
  {
    if ((paramThread == null) || (!this.jdField_a_of_type_ArrayOfAigj[paramInt].jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ArrayOfAigj[paramInt].jdField_a_of_type_Aigl != null) || (this.jdField_a_of_type_ArrayOfAigj[paramInt].jdField_c_of_type_Int <= 0)) {
      return false;
    }
    QLog.d("UnifiedMonitor", 1, "setMonitoredThread for family=" + paramInt);
    synchronized (this.jdField_a_of_type_ArrayOfAigj[paramInt])
    {
      if (this.jdField_a_of_type_ArrayOfAigj[paramInt].jdField_a_of_type_Aigl == null)
      {
        this.jdField_a_of_type_ArrayOfAigj[paramInt].jdField_a_of_type_Aigl = new aigl(this, paramInt, paramThread);
        ThreadManager.newFreeThread(this.jdField_a_of_type_ArrayOfAigj[paramInt].jdField_a_of_type_Aigl, "um-stack-fetcher-" + paramInt, 5).start();
        this.jdField_a_of_type_ArrayOfAigj[paramInt].jdField_c_of_type_Boolean = true;
        return true;
      }
    }
    return false;
  }
  
  public boolean whetherReportDuringThisStartup(int paramInt)
  {
    if (paramInt >= 20) {
      return false;
    }
    return this.jdField_a_of_type_ArrayOfAigj[paramInt].jdField_a_of_type_Boolean;
  }
  
  public boolean whetherReportThisTime(int paramInt)
  {
    if ((!this.jdField_a_of_type_Boolean) || (!this.jdField_a_of_type_ArrayOfAigj[paramInt].jdField_a_of_type_Boolean)) {
      return false;
    }
    if (this.jdField_a_of_type_ArrayOfAigj[paramInt].jdField_c_of_type_Boolean) {
      return this.jdField_a_of_type_ArrayOfAigj[paramInt].jdField_b_of_type_Boolean;
    }
    return whetherReportThisTime(paramInt, false);
  }
  
  public boolean whetherReportThisTime(int paramInt, boolean paramBoolean)
  {
    float f = this.jdField_a_of_type_ArrayOfAigj[paramInt].jdField_b_of_type_Float;
    if (this.jdField_a_of_type_ArrayOfAigj[paramInt].g >= this.jdField_a_of_type_ArrayOfAigj[paramInt].jdField_b_of_type_Int) {}
    while (Math.random() > f) {
      return false;
    }
    return true;
  }
  
  public boolean whetherStackEnabled(int paramInt)
  {
    return this.jdField_a_of_type_ArrayOfAigj[paramInt].jdField_c_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.UnifiedMonitor
 * JD-Core Version:    0.7.0.1
 */