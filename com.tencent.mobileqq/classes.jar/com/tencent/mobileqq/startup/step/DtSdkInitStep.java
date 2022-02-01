package com.tencent.mobileqq.startup.step;

import android.content.SharedPreferences;
import android.os.SystemClock;
import arip;
import arnl;
import bcow;
import bctj;
import com.tencent.beacon.event.UserAction;
import com.tencent.beacon.upload.TunnelInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.DTReportComponent;
import com.tencent.qqlive.module.videoreport.dtreport.DTReportComponent.Builder;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class DtSdkInitStep
  extends AsyncStep
{
  private static long jdField_a_of_type_Long;
  private static volatile AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
  private static volatile AtomicBoolean b = new AtomicBoolean(false);
  private static volatile AtomicBoolean c = new AtomicBoolean(false);
  private static int jdField_d_of_type_Int = 0;
  private static AtomicBoolean jdField_d_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  
  public static void a()
  {
    if (jdField_d_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return;
    }
    jdField_d_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    HashMap localHashMap = new HashMap();
    localHashMap.put("initDTFrom", String.valueOf(jdField_d_of_type_Int));
    localHashMap.put("initDTCostTime", String.valueOf(jdField_a_of_type_Long));
    localHashMap.put("showCostTime", String.valueOf(bcow.h));
    bctj.a(BaseApplicationImpl.getContext()).a("", "EvtInitDTCostTime", true, 0L, 0L, localHashMap, "");
  }
  
  private static boolean a()
  {
    if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean != null) {
      return jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
    }
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(BaseApplicationImpl.getContext().getSharedPreferences("dt_sdk_start", 0).getBoolean("is_init_dt_sdk_at_start", false));
    return jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  private static boolean a(int paramInt)
  {
    return paramInt == 1;
  }
  
  public static void b(int paramInt)
  {
    if ((a(paramInt)) && (BaseApplicationImpl.sProcessId == 1)) {}
    while (!c.compareAndSet(false, true)) {
      return;
    }
    ThreadManager.executeOnSubThread(new DtSdkInitStep.1());
  }
  
  private static void c(int paramInt)
  {
    if (!b.compareAndSet(false, true))
    {
      b(paramInt);
      return;
    }
    jdField_d_of_type_Int = paramInt;
    long l = SystemClock.elapsedRealtime();
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if (localBaseApplicationImpl != null)
    {
      VideoReport.startWithComponent(localBaseApplicationImpl, DTReportComponent.builder(new arip()).enableDebug(false).dtReport(arnl.b()).independentPageOut(true).build());
      VideoReport.setDetectionMode(2);
      jdField_a_of_type_Long = SystemClock.elapsedRealtime() - l;
      QLog.d("DtSdkInitStep", 1, "initDTCost : " + jdField_a_of_type_Long + " ms， from = " + paramInt);
    }
    for (;;)
    {
      b(paramInt);
      return;
      QLog.i("DtSdkInitStep", 1, "application is null, init DT sdk fail !");
    }
  }
  
  private static void e()
  {
    List localList = arip.a();
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