package com.tencent.qqperf.monitor.crash;

import android.os.Process;
import com.tencent.common.config.AppSetting;
import com.tencent.feedback.anr.ANRReport;
import com.tencent.feedback.eup.CrashReport;
import com.tencent.feedback.eup.CrashStrategyBean;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qqperf.api.IPerfApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class QQCrashReportManager
{
  public static String a = "999";
  public static int b;
  public static long c;
  public static final String d = MobileQQ.sMobileQQ.getFilesDir().getPath();
  public static QQCrashCallback e = null;
  public static volatile boolean f = false;
  public static volatile boolean g = false;
  public static volatile long h = 0L;
  public static volatile boolean i = false;
  public static String j = null;
  public static String k = null;
  public static String l;
  public static StringBuilder m = new StringBuilder("DPC info:\n");
  public static StringBuilder n = new StringBuilder("Thread info:\n");
  private static QQCrashReportManager o;
  
  public static QQCrashReportManager a()
  {
    if (o == null) {
      try
      {
        if (o == null) {
          o = new QQCrashReportManager();
        }
      }
      finally {}
    }
    return o;
  }
  
  public static void a(String paramString)
  {
    a = paramString;
    CrashReport.setUserId(MobileQQ.sMobileQQ, paramString);
  }
  
  private void b(String paramString)
  {
    BaseApplication localBaseApplication = MobileQQ.getContext();
    CrashReport.setUserId(localBaseApplication, paramString);
    CrashReport.putUserData(localBaseApplication, "TbsSdkVersion", String.valueOf(WebView.getTbsSDKVersion(localBaseApplication)));
    CrashReport.putUserData(localBaseApplication, "X5CoreVersion", String.valueOf(QbSdk.getTbsVersion(localBaseApplication)));
    CrashReport.putUserData(localBaseApplication, "Revision", AppSetting.i());
    CrashReport.putUserData(localBaseApplication, "Version.buildNum", "8.8.17.5770");
    CrashReport.putUserData(localBaseApplication, "AboutSubVersionLog", AppSetting.c());
    CrashReport.putUserData(localBaseApplication, "appid", String.valueOf(AppSetting.d()));
    CrashReport.putUserData(localBaseApplication, "topActivity", ((IPerfApi)QRoute.api(IPerfApi.class)).getTopActivityName());
    StringBuilder localStringBuilder = n;
    localStringBuilder.append("Current process id=");
    localStringBuilder.append(Process.myPid());
    localStringBuilder.append(", Name=");
    localStringBuilder.append(MobileQQ.processName);
    localStringBuilder.append("\n");
    h = System.currentTimeMillis();
    if (1 == MobileQQ.sProcessId)
    {
      QQCrashControlManager.b().a(paramString);
      ThreadManager.getSubThreadHandler().postDelayed(new QQCrashReportManager.1(this, localBaseApplication), 180000L);
      ThreadManager.getSubThreadHandler().postDelayed(new QQCrashReportManager.2(this, localBaseApplication), 600000L);
    }
  }
  
  public void a(String paramString, ICrashReportCallback paramICrashReportCallback)
  {
    QLog.d("QQCrashReportManager", 1, "CrashReport init started.");
    if (paramICrashReportCallback == null)
    {
      QLog.e("QQCrashReportManager", 1, "setEnableCrashRecord with callback null,so return");
      return;
    }
    CrashReport.setLogAble(false, false);
    Object localObject = new CrashStrategyBean();
    ((CrashStrategyBean)localObject).setUploadSpotCrash(false);
    ((CrashStrategyBean)localObject).setMaxStackFrame(6);
    StringBuilder localStringBuilder = new StringBuilder("initCrashReport process=");
    localStringBuilder.append(MobileQQ.processName);
    localStringBuilder.append(", pid=");
    localStringBuilder.append(Process.myPid());
    QLog.d("QQCrashReportManager", 1, localStringBuilder.toString());
    if (MobileQQ.processName.endsWith(":qzone")) {
      ThreadManager.executeOnSubThread(new QQCrashReportManager.3(this));
    }
    boolean bool;
    if (MobileQQ.sProcessId == 1) {
      bool = true;
    } else {
      bool = false;
    }
    CrashReport.initCrashReport(MobileQQ.sMobileQQ, paramICrashReportCallback.a(), null, bool, (CrashStrategyBean)localObject, 30000L);
    try
    {
      localObject = MobileQQ.sMobileQQ.getDir("tombs", 0).getAbsolutePath();
      localStringBuilder = new StringBuilder("initNativeCrashReport process=");
      localStringBuilder.append(MobileQQ.processName);
      localStringBuilder.append(", pid=");
      localStringBuilder.append(Process.myPid());
      QLog.d("QQCrashReportManager", 1, localStringBuilder.toString());
      CrashReport.initNativeCrashReport(MobileQQ.sMobileQQ, (String)localObject, false, null, null, 0L);
      CrashReport.filterSysLog(true, true);
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      QLog.e("QQCrashReportManager", 1, "initNativeCrashReport error", localUnsatisfiedLinkError);
    }
    ANRReport.stopANRMonitor();
    b(paramString);
    paramICrashReportCallback.a(paramString, this);
    QLog.d("QQCrashReportManager", 1, "CrashReport init finished.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqperf.monitor.crash.QQCrashReportManager
 * JD-Core Version:    0.7.0.1
 */