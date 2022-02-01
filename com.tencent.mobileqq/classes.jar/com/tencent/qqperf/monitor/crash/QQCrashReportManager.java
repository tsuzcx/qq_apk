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
  public static int a = 0;
  public static long a = 0L;
  public static QQCrashCallback a;
  private static QQCrashReportManager a;
  public static String a = "999";
  public static StringBuilder a;
  public static volatile boolean a;
  public static volatile long b;
  public static final String b;
  public static StringBuilder b;
  public static volatile boolean b;
  public static String c;
  public static volatile boolean c;
  public static String d;
  public static String e;
  
  static
  {
    jdField_b_of_type_JavaLangString = MobileQQ.sMobileQQ.getFilesDir().getPath();
    jdField_a_of_type_ComTencentQqperfMonitorCrashQQCrashCallback = null;
    jdField_a_of_type_Boolean = false;
    jdField_b_of_type_Boolean = false;
    jdField_b_of_type_Long = 0L;
    jdField_c_of_type_Boolean = false;
    jdField_c_of_type_JavaLangString = null;
    d = null;
    jdField_a_of_type_JavaLangStringBuilder = new StringBuilder("DPC info:\n");
    jdField_b_of_type_JavaLangStringBuilder = new StringBuilder("Thread info:\n");
  }
  
  public static QQCrashReportManager a()
  {
    if (jdField_a_of_type_ComTencentQqperfMonitorCrashQQCrashReportManager == null) {
      try
      {
        if (jdField_a_of_type_ComTencentQqperfMonitorCrashQQCrashReportManager == null) {
          jdField_a_of_type_ComTencentQqperfMonitorCrashQQCrashReportManager = new QQCrashReportManager();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentQqperfMonitorCrashQQCrashReportManager;
  }
  
  public static void a(String paramString)
  {
    jdField_a_of_type_JavaLangString = paramString;
    CrashReport.setUserId(MobileQQ.sMobileQQ, paramString);
  }
  
  private void b(String paramString)
  {
    BaseApplication localBaseApplication = MobileQQ.getContext();
    CrashReport.setUserId(localBaseApplication, paramString);
    CrashReport.putUserData(localBaseApplication, "TbsSdkVersion", String.valueOf(WebView.getTbsSDKVersion(localBaseApplication)));
    CrashReport.putUserData(localBaseApplication, "X5CoreVersion", String.valueOf(QbSdk.getTbsVersion(localBaseApplication)));
    CrashReport.putUserData(localBaseApplication, "Revision", AppSetting.g());
    CrashReport.putUserData(localBaseApplication, "Version.buildNum", "8.7.0.5295");
    CrashReport.putUserData(localBaseApplication, "AboutSubVersionLog", AppSetting.b());
    CrashReport.putUserData(localBaseApplication, "appid", String.valueOf(AppSetting.a()));
    CrashReport.putUserData(localBaseApplication, "topActivity", ((IPerfApi)QRoute.api(IPerfApi.class)).getTopActivityName());
    StringBuilder localStringBuilder = jdField_b_of_type_JavaLangStringBuilder;
    localStringBuilder.append("Current process id=");
    localStringBuilder.append(Process.myPid());
    localStringBuilder.append(", Name=");
    localStringBuilder.append(MobileQQ.processName);
    localStringBuilder.append("\n");
    jdField_b_of_type_Long = System.currentTimeMillis();
    if (1 == MobileQQ.sProcessId)
    {
      QQCrashControlManager.a().a(paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.monitor.crash.QQCrashReportManager
 * JD-Core Version:    0.7.0.1
 */