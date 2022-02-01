package com.tencent.mobileqq.startup.step;

import android.app.Application;
import android.content.SharedPreferences;
import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.PrivacyPolicyHelper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.data.dt.QQDtConfig;
import com.tencent.mobileqq.dt.QQDtReportHelper;
import com.tencent.mobileqq.dt.QQDtReporter;
import com.tencent.mobileqq.startup.director.StartupDirector;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.DTReportComponent;
import com.tencent.qqlive.module.videoreport.dtreport.DTReportComponent.Builder;
import com.tencent.qqlive.module.videoreport.dtreport.api.DTConfig.Builder;
import com.tencent.qqlive.module.videoreport.lazy.LazyInitObserver;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class DtSdkInitStep
  extends AsyncStep
{
  private static volatile AtomicBoolean a;
  private static volatile AtomicBoolean b;
  private static volatile AtomicBoolean c = new AtomicBoolean(false);
  private static volatile AtomicBoolean d = new AtomicBoolean(false);
  private static volatile AtomicBoolean e = new AtomicBoolean(false);
  private static AtomicBoolean f = new AtomicBoolean(false);
  private static int g = 0;
  private static long h = 0L;
  
  public static void a(int paramInt)
  {
    if ((c(paramInt)) && (BaseApplicationImpl.sProcessId == 1)) {
      return;
    }
    if (BaseApplicationImpl.sProcessId == 4) {
      return;
    }
    if (!e.compareAndSet(false, true)) {
      return;
    }
    ThreadManager.executeOnSubThread(new DtSdkInitStep.2());
  }
  
  public static void a(boolean paramBoolean)
  {
    VideoReport.setVideoReportConfig(new DTConfig.Builder().supportVideoReport(paramBoolean).build());
    QLog.d("DtSdkInitStep", 1, new Object[] { "[setDtVideoSwitch] switch: ", Boolean.valueOf(paramBoolean) });
  }
  
  public static boolean a()
  {
    if (a != null) {
      return a.get();
    }
    a = new AtomicBoolean(BaseApplicationImpl.getContext().getSharedPreferences("dt_sdk_start", 4).getBoolean("is_init_dt_sdk_at_start_b", true));
    return a.get();
  }
  
  private static void b(int paramInt)
  {
    if (!c.compareAndSet(false, true))
    {
      a(paramInt);
      return;
    }
    if (BaseApplicationImpl.sProcessId == 1) {
      QQDtReportHelper.a(1);
    }
    g = paramInt;
    long l = SystemClock.elapsedRealtime();
    Object localObject = BaseApplicationImpl.getApplication();
    if (localObject != null)
    {
      int i;
      if (a()) {
        i = 2;
      } else {
        i = 0;
      }
      VideoReport.startWithComponent((Application)localObject, DTReportComponent.builder(QQDtConfig.a()).enableDebug(false).dtReport(QQDtReporter.b()).elementFormatMode(1).lazyInitType(i).setVideoPageSwitch(3).independentPageOut(true).build());
      VideoReport.setDetectionMode(2);
      VideoReport.setDetectionInterceptor(new DtSdkInitStep.1());
      if (!PrivacyPolicyHelper.d()) {
        VideoReport.setCollectProcessName(false);
      }
      a(d());
      if ((!a()) || (BaseApplicationImpl.sProcessId != 1))
      {
        LazyInitObserver.getInstance().markToProceed();
        QLog.d("DtSdkInitStep", 1, "markToProceed");
      }
      VideoReport.supportPlayerReport(true);
      h = SystemClock.elapsedRealtime() - l;
      d.set(true);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("848QQDT initDTCost : ");
      ((StringBuilder)localObject).append(h);
      ((StringBuilder)localObject).append(" ms， from = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("DtSdkInitStep", 1, ((StringBuilder)localObject).toString());
    }
    else
    {
      QLog.i("DtSdkInitStep", 1, "848QQDT application is null, init DT sdk fail !");
    }
    a(paramInt);
  }
  
  public static boolean b()
  {
    return d.get();
  }
  
  public static void c()
  {
    if ((StartupDirector.k > 0L) && (f.compareAndSet(false, true)) && (BaseApplicationImpl.sProcessId == 1))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("initDTFrom", String.valueOf(g));
      localHashMap.put("initDTCostTime", String.valueOf(h));
      localHashMap.put("showCostTime", String.valueOf(StartupDirector.k));
      String str;
      if (g == 1) {
        str = "evt_init_dt_at_boot_b";
      } else {
        str = "evt_init_dt_at_boot_a";
      }
      StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance("", str, true, 0L, 0L, localHashMap, "", true);
    }
  }
  
  private static boolean c(int paramInt)
  {
    return paramInt == 1;
  }
  
  private static boolean d()
  {
    if (b != null) {
      return b.get();
    }
    b = new AtomicBoolean(BaseApplicationImpl.getContext().getSharedPreferences("dt_sdk_start", 4).getBoolean("key_need_turn_on_dt_video", false));
    return b.get();
  }
  
  public static void initDTSDK(int paramInt)
  {
    if (c(paramInt))
    {
      if (a()) {
        b(paramInt);
      }
    }
    else {
      b(paramInt);
    }
  }
  
  protected int doStep()
  {
    initDTSDK(0);
    return super.doStep();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.DtSdkInitStep
 * JD-Core Version:    0.7.0.1
 */