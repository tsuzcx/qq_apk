package com.tencent.mobileqq.startup.step;

import android.content.SharedPreferences;
import android.os.SystemClock;
import com.tencent.beacon.event.UserAction;
import com.tencent.beacon.upload.TunnelInfo;
import com.tencent.common.app.BaseApplicationImpl;
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
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class DtSdkInitStep
  extends AsyncStep
{
  private static long jdField_a_of_type_Long = 0L;
  private static volatile AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = null;
  private static volatile AtomicBoolean b = null;
  private static volatile AtomicBoolean c = new AtomicBoolean(false);
  private static int jdField_d_of_type_Int;
  private static volatile AtomicBoolean jdField_d_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private static volatile AtomicBoolean e = new AtomicBoolean(false);
  private static AtomicBoolean f = new AtomicBoolean(false);
  
  static
  {
    jdField_d_of_type_Int = 0;
  }
  
  public static void a()
  {
    if ((StartupDirector.d > 0L) && (f.compareAndSet(false, true)) && (BaseApplicationImpl.sProcessId == 1))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("initDTFrom", String.valueOf(jdField_d_of_type_Int));
      localHashMap.put("initDTCostTime", String.valueOf(jdField_a_of_type_Long));
      localHashMap.put("showCostTime", String.valueOf(StartupDirector.d));
      String str = "evt_init_dt_at_boot_a";
      if (jdField_d_of_type_Int == 1) {
        str = "evt_init_dt_at_boot_b";
      }
      StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance("", str, true, 0L, 0L, localHashMap, "", true);
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    VideoReport.setVideoReportConfig(new DTConfig.Builder().supportVideoReport(paramBoolean).build());
    QLog.d("DtSdkInitStep", 1, new Object[] { "[setDtVideoSwitch] switch: ", Boolean.valueOf(paramBoolean) });
  }
  
  public static boolean a()
  {
    if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean != null) {
      return jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
    }
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(BaseApplicationImpl.getContext().getSharedPreferences("dt_sdk_start", 4).getBoolean("is_init_dt_sdk_at_start_b", true));
    return jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  private static boolean a(int paramInt)
  {
    return paramInt == 1;
  }
  
  public static void b(int paramInt)
  {
    if ((a(paramInt)) && (BaseApplicationImpl.sProcessId == 1)) {}
    while ((BaseApplicationImpl.sProcessId == 4) || (!e.compareAndSet(false, true))) {
      return;
    }
    ThreadManager.executeOnSubThread(new DtSdkInitStep.2());
  }
  
  public static boolean b()
  {
    return jdField_d_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  private static void c(int paramInt)
  {
    if (!c.compareAndSet(false, true))
    {
      b(paramInt);
      return;
    }
    if (BaseApplicationImpl.sProcessId == 1) {
      QQDtReportHelper.a(1);
    }
    jdField_d_of_type_Int = paramInt;
    long l = SystemClock.elapsedRealtime();
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if (localBaseApplicationImpl != null) {
      if (!a()) {
        break label209;
      }
    }
    label209:
    for (int i = 2;; i = 0)
    {
      VideoReport.startWithComponent(localBaseApplicationImpl, DTReportComponent.builder(new QQDtConfig()).enableDebug(false).dtReport(QQDtReporter.b()).elementFormatMode(1).lazyInitType(i).independentPageOut(true).build());
      VideoReport.setDetectionMode(2);
      VideoReport.setDetectionInterceptor(new DtSdkInitStep.1());
      a(c());
      if ((!a()) || (BaseApplicationImpl.sProcessId != 1))
      {
        LazyInitObserver.getInstance().markToProceed();
        QLog.d("DtSdkInitStep", 1, "markToProceed");
      }
      jdField_a_of_type_Long = SystemClock.elapsedRealtime() - l;
      jdField_d_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      QLog.d("DtSdkInitStep", 1, "848QQDT initDTCost : " + jdField_a_of_type_Long + " ms， from = " + paramInt);
      for (;;)
      {
        b(paramInt);
        return;
        QLog.i("DtSdkInitStep", 1, "848QQDT application is null, init DT sdk fail !");
      }
    }
  }
  
  private static boolean c()
  {
    if (b != null) {
      return b.get();
    }
    b = new AtomicBoolean(BaseApplicationImpl.getContext().getSharedPreferences("dt_sdk_start", 4).getBoolean("key_need_turn_on_dt_video", false));
    return b.get();
  }
  
  private static void e()
  {
    List localList = QQDtConfig.a();
    int i = 0;
    while (i < localList.size())
    {
      UserAction.registerTunnel((TunnelInfo)localList.get(i));
      i += 1;
    }
  }
  
  public static void initDTSDK(int paramInt)
  {
    if (a(paramInt))
    {
      if (a()) {
        c(paramInt);
      }
      return;
    }
    c(paramInt);
  }
  
  public int a()
  {
    initDTSDK(0);
    return super.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.DtSdkInitStep
 * JD-Core Version:    0.7.0.1
 */