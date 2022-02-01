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
  private static ReporterMachine a;
  private static boolean b = false;
  private static MqqHandler c;
  private static String d = "";
  private static IReporter e;
  private static Queue<String> f = new ConcurrentLinkedQueue();
  private static List<ResultObject> g = Collections.synchronizedList(new ArrayList());
  
  private ReporterMachine()
  {
    if (c == null)
    {
      HandlerThread localHandlerThread = ThreadManager.newFreeHandlerThread("ReporterMachine", 0);
      localHandlerThread.start();
      c = new MqqHandler(localHandlerThread.getLooper());
      e = new QCloudReporter(localHandlerThread);
    }
    d = a();
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
    if (c != null)
    {
      paramResultObject = new ReporterMachine.InsertRunnable(paramResultObject);
      c.post(paramResultObject);
      return;
    }
    g.add(paramResultObject);
  }
  
  public static ReporterMachine b()
  {
    if (a == null) {
      try
      {
        a = new ReporterMachine();
      }
      finally {}
    }
    return a;
  }
  
  private static void c(ResultObject paramResultObject)
  {
    if (ReportedStatus.a > Config.MAX_REPORT_NUM) {
      return;
    }
    JSONObject localJSONObject = paramResultObject.params.getJSONObject("clientinfo");
    localJSONObject.put("versionname", MagnifierSDK.a);
    localJSONObject.put("uin", String.valueOf(paramResultObject.uin));
    localJSONObject.put("manu", Build.MANUFACTURER);
    localJSONObject.put("model", Build.MODEL);
    localJSONObject.put("os", Build.VERSION.RELEASE);
    localJSONObject.put("rdmuuid", d);
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
    e.a(paramResultObject, new ReporterMachine.1());
  }
  
  public String a()
  {
    if (!TextUtils.isEmpty(d)) {
      return d;
    }
    try
    {
      d = MobileQQ.getContext().getPackageManager().getApplicationInfo(MobileQQ.getContext().getPackageName(), 128).metaData.get("com.tencent.qapm.uuid").toString();
      if ("1234567890".equals(d)) {
        d = "0";
      }
      label64:
      return d;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      break label64;
    }
  }
  
  public void c()
  {
    if (!b)
    {
      ReporterMachine.ReportRunnable localReportRunnable = new ReporterMachine.ReportRunnable(this, null);
      ReporterMachine.getFileRunnable localgetFileRunnable = new ReporterMachine.getFileRunnable();
      c.postDelayed(localgetFileRunnable, 120000L);
      c.postDelayed(localReportRunnable, 300000L);
      b = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqperf.repoter.ReporterMachine
 * JD-Core Version:    0.7.0.1
 */