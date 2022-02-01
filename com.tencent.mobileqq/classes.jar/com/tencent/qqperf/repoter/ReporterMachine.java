package com.tencent.qqperf.repoter;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qqperf.api.IPerfApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.MagnifierSDK;
import com.tencent.qqperf.abfactor.AbFactorManger;
import com.tencent.qqperf.config.Config;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class ReporterMachine
{
  private static IReporter jdField_a_of_type_ComTencentQqperfRepoterIReporter;
  private static ReporterMachine jdField_a_of_type_ComTencentQqperfRepoterReporterMachine;
  private static String jdField_a_of_type_JavaLangString = "";
  private static List<ResultObject> jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
  private static Queue<String> jdField_a_of_type_JavaUtilQueue = new ConcurrentLinkedQueue();
  private static MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private static boolean jdField_a_of_type_Boolean = false;
  
  private ReporterMachine()
  {
    if (jdField_a_of_type_MqqOsMqqHandler == null)
    {
      HandlerThread localHandlerThread = ThreadManager.newFreeHandlerThread("ReporterMachine", 0);
      localHandlerThread.start();
      jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(localHandlerThread.getLooper());
      jdField_a_of_type_ComTencentQqperfRepoterIReporter = new QCloudReporter(localHandlerThread);
    }
    jdField_a_of_type_JavaLangString = a();
  }
  
  public static ReporterMachine a()
  {
    if (jdField_a_of_type_ComTencentQqperfRepoterReporterMachine == null) {
      try
      {
        jdField_a_of_type_ComTencentQqperfRepoterReporterMachine = new ReporterMachine();
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentQqperfRepoterReporterMachine;
  }
  
  public static void a(ResultObject paramResultObject)
  {
    AbFactorManger.a(paramResultObject.params);
    if ((true == paramResultObject.isRealTime) && (1 == NetworkCenter.getInstance().getNetType())) {
      try
      {
        c(paramResultObject);
        return;
      }
      catch (Exception paramResultObject)
      {
        paramResultObject.printStackTrace();
        return;
      }
    }
    if (jdField_a_of_type_MqqOsMqqHandler != null)
    {
      paramResultObject = new ReporterMachine.InsertRunnable(paramResultObject);
      jdField_a_of_type_MqqOsMqqHandler.post(paramResultObject);
      return;
    }
    jdField_a_of_type_JavaUtilList.add(paramResultObject);
  }
  
  private static void c(ResultObject paramResultObject)
  {
    if (ReportedStatus.a > Config.MAX_REPORT_NUM) {
      return;
    }
    JSONObject localJSONObject = paramResultObject.params.getJSONObject("clientinfo");
    localJSONObject.put("versionname", MagnifierSDK.jdField_a_of_type_JavaLangString);
    localJSONObject.put("uin", String.valueOf(paramResultObject.uin));
    localJSONObject.put("manu", Build.MANUFACTURER);
    localJSONObject.put("model", Build.MODEL);
    localJSONObject.put("os", Build.VERSION.RELEASE);
    localJSONObject.put("rdmuuid", jdField_a_of_type_JavaLangString);
    localJSONObject.put("deviceid", ((IPerfApi)QRoute.api(IPerfApi.class)).getDeviceId());
    if (MobileQQ.sProcessId == 1) {
      try
      {
        String.valueOf(paramResultObject.params.get("newplugin"));
      }
      catch (Exception localException)
      {
        QLog.d("Magnifier_ReporterMachine", 1, "reportAtOnce", localException);
      }
    }
    jdField_a_of_type_ComTencentQqperfRepoterIReporter.a(paramResultObject, new ReporterMachine.1());
  }
  
  public String a()
  {
    if (!TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {
      return jdField_a_of_type_JavaLangString;
    }
    try
    {
      jdField_a_of_type_JavaLangString = MobileQQ.getContext().getPackageManager().getApplicationInfo(MobileQQ.getContext().getPackageName(), 128).metaData.get("com.tencent.qapm.uuid").toString();
      if ("1234567890".equals(jdField_a_of_type_JavaLangString)) {
        jdField_a_of_type_JavaLangString = "0";
      }
      label64:
      return jdField_a_of_type_JavaLangString;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      break label64;
    }
  }
  
  public void a()
  {
    if (!jdField_a_of_type_Boolean)
    {
      ReporterMachine.ReportRunnable localReportRunnable = new ReporterMachine.ReportRunnable(this, null);
      ReporterMachine.getFileRunnable localgetFileRunnable = new ReporterMachine.getFileRunnable();
      jdField_a_of_type_MqqOsMqqHandler.postDelayed(localgetFileRunnable, 120000L);
      jdField_a_of_type_MqqOsMqqHandler.postDelayed(localReportRunnable, 300000L);
      jdField_a_of_type_Boolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.repoter.ReporterMachine
 * JD-Core Version:    0.7.0.1
 */