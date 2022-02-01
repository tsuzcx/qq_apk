package com.tencent.open.appstore.report;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.cooperation.ApkUtils;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.replacemonitor.MonitorStep;
import com.tencent.replacemonitor.MonitorTask;
import com.tencent.replacemonitor.replace.ReplaceMonitor;
import com.tencent.tmassistant.st.SDKReportManager2;
import com.tencent.tmassistantbase.util.GlobalUtil;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class AppCenterReporter
{
  public static void a(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[report] type=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("\ndata=");
    localStringBuilder.append(paramString);
    LogUtility.b("AppCenterReporter", localStringBuilder.toString());
    SDKReportManager2.getInstance().postReport(paramInt, paramString);
  }
  
  public static void a(ReportDataBuilder paramReportDataBuilder)
  {
    paramReportDataBuilder = paramReportDataBuilder.b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[reportExposure] type=3002\ndata=");
    localStringBuilder.append(paramReportDataBuilder);
    LogUtility.b("AppCenterReporter", localStringBuilder.toString());
    SDKReportManager2.getInstance().postReport(3002, paramReportDataBuilder);
  }
  
  public static void a(DownloadInfo paramDownloadInfo)
  {
    ThreadManager.excute(new AppCenterReporter.1(paramDownloadInfo), 16, null, true);
  }
  
  public static void a(DownloadInfo paramDownloadInfo, int paramInt)
  {
    ThreadManager.excute(new AppCenterReporter.5(paramDownloadInfo, paramInt), 16, null, true);
  }
  
  public static void a(DownloadInfo paramDownloadInfo, int paramInt, String paramString)
  {
    ThreadManager.excute(new AppCenterReporter.3(paramDownloadInfo, paramInt, paramString), 16, null, true);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    paramString1 = c(paramString1, paramString2, paramString3, paramString4, paramString5);
    paramString2 = new StringBuilder();
    paramString2.append("[reportNormalExposure] type=3001\ndata=");
    paramString2.append(paramString1);
    LogUtility.b("AppCenterReporter", paramString2.toString());
    SDKReportManager2.getInstance().postReport(3001, paramString1);
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(">notifyInstallFinish ");
    localStringBuilder.append(paramString);
    localStringBuilder.append("|");
    localStringBuilder.append(paramBoolean);
    LogUtility.b("AppCenterReporter", localStringBuilder.toString());
    ThreadManager.excute(new AppCenterReporter.6(paramString, paramBoolean), 16, null, true);
  }
  
  private static long b(String paramString)
  {
    if (ApkUtils.a(paramString, CommonDataAdapter.a().b())) {}
    try
    {
      long l = new File(GlobalUtil.getInstance().getContext().getPackageManager().getPackageInfo(paramString, 0).applicationInfo.sourceDir).length();
      return l;
    }
    catch (Throwable paramString)
    {
      StringBuilder localStringBuilder;
      break label83;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("[getInstalledAppFileSize]");
    localStringBuilder.append(paramString);
    localStringBuilder.append(": NOT INSTALLED!");
    LogUtility.b("AppCenterReporter", localStringBuilder.toString());
    label83:
    return 0L;
  }
  
  public static void b(ReportDataBuilder paramReportDataBuilder)
  {
    paramReportDataBuilder = paramReportDataBuilder.b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[reportClick] type=3003\ndata=");
    localStringBuilder.append(paramReportDataBuilder);
    LogUtility.b("AppCenterReporter", localStringBuilder.toString());
    SDKReportManager2.getInstance().postReport(3003, paramReportDataBuilder);
  }
  
  public static void b(DownloadInfo paramDownloadInfo)
  {
    ThreadManager.excute(new AppCenterReporter.2(paramDownloadInfo), 16, null, true);
  }
  
  public static void b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(c(paramString1, paramString2, paramString3, paramString4, paramString5));
    localStringBuilder.append("|");
    localStringBuilder.append(ReportDataBuilder.c().f());
    localStringBuilder.append("|");
    localStringBuilder.append("200");
    paramString1 = localStringBuilder.toString();
    paramString2 = new StringBuilder();
    paramString2.append("[reportClick] type=3003\ndata=");
    paramString2.append(paramString1);
    LogUtility.b("AppCenterReporter", paramString2.toString());
    SDKReportManager2.getInstance().postReport(3003, paramString1);
  }
  
  private static String c(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    return ReportDataBuilder.c().j(paramString5).l(paramString1).k(paramString2).m(paramString3).n(paramString4).d();
  }
  
  public static void c(DownloadInfo paramDownloadInfo)
  {
    g(paramDownloadInfo);
    ThreadManager.excute(new AppCenterReporter.4(paramDownloadInfo), 16, null, true);
  }
  
  public static void d(DownloadInfo paramDownloadInfo)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(">tryInitMonitorTask info:");
    ((StringBuilder)localObject).append(paramDownloadInfo);
    LogUtility.b("AppCenterReporter", ((StringBuilder)localObject).toString());
    if (paramDownloadInfo == null) {
      return;
    }
    localObject = ReplaceMonitor.get().getTask(paramDownloadInfo.b);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(">tryInitMonitorTask info=");
    localStringBuilder.append(paramDownloadInfo);
    LogUtility.b("AppCenterReporter", localStringBuilder.toString());
    if (localObject == null)
    {
      paramDownloadInfo = j(paramDownloadInfo);
    }
    else
    {
      if (TextUtils.isEmpty(((MonitorTask)localObject).filePath)) {
        ((MonitorTask)localObject).filePath = paramDownloadInfo.q;
      }
      paramDownloadInfo = new StringBuilder();
      paramDownloadInfo.append(">tryInitMonitorTask 已有task2:");
      paramDownloadInfo.append(localObject);
      LogUtility.b("AppCenterReporter", paramDownloadInfo.toString());
      paramDownloadInfo = (DownloadInfo)localObject;
    }
    ReplaceMonitor.get().addTask(paramDownloadInfo);
  }
  
  public static void e(DownloadInfo paramDownloadInfo)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(">downloadSuccCheck info:");
    ((StringBuilder)localObject).append(paramDownloadInfo);
    LogUtility.b("AppCenterReporter", ((StringBuilder)localObject).toString());
    if (paramDownloadInfo == null) {
      return;
    }
    MonitorTask localMonitorTask = ReplaceMonitor.get().getTask(paramDownloadInfo.b);
    if (localMonitorTask == null)
    {
      localObject = j(paramDownloadInfo);
      ReplaceMonitor.get().addTask((MonitorTask)localObject);
    }
    else
    {
      localObject = localMonitorTask;
      if (TextUtils.isEmpty(localMonitorTask.filePath))
      {
        localMonitorTask.filePath = paramDownloadInfo.q;
        localObject = localMonitorTask;
      }
    }
    paramDownloadInfo = new StringBuilder();
    paramDownloadInfo.append(">downloadSuccCheck task:");
    paramDownloadInfo.append(localObject);
    LogUtility.b("AppCenterReporter", paramDownloadInfo.toString());
    if (localObject != null) {
      ReplaceMonitor.get().execSync((MonitorTask)localObject, MonitorStep.DOWNLOADING);
    }
  }
  
  public static void f(DownloadInfo paramDownloadInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(">deleteCheck info:");
    localStringBuilder.append(paramDownloadInfo);
    LogUtility.b("AppCenterReporter", localStringBuilder.toString());
    if (paramDownloadInfo == null) {
      return;
    }
    paramDownloadInfo = ReplaceMonitor.get().getTask(paramDownloadInfo.b);
    if (paramDownloadInfo != null) {
      ReplaceMonitor.get().deleteTask(paramDownloadInfo);
    }
  }
  
  public static void g(DownloadInfo paramDownloadInfo)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(">installStartCheck ,info:");
    ((StringBuilder)localObject).append(paramDownloadInfo);
    LogUtility.b("AppCenterReporter", ((StringBuilder)localObject).toString());
    if (paramDownloadInfo == null) {
      return;
    }
    MonitorTask localMonitorTask = ReplaceMonitor.get().getTask(paramDownloadInfo.b);
    if (localMonitorTask == null)
    {
      localObject = j(paramDownloadInfo);
      ReplaceMonitor.get().addTask((MonitorTask)localObject);
    }
    else
    {
      localObject = localMonitorTask;
      if (TextUtils.isEmpty(localMonitorTask.filePath))
      {
        localMonitorTask.filePath = paramDownloadInfo.q;
        localObject = localMonitorTask;
      }
    }
    paramDownloadInfo = new StringBuilder();
    paramDownloadInfo.append(">installStartCheck task:");
    paramDownloadInfo.append(localObject);
    LogUtility.b("AppCenterReporter", paramDownloadInfo.toString());
    if (localObject != null) {
      ReplaceMonitor.get().execSync((MonitorTask)localObject, MonitorStep.BEFORE_INSTALL);
    }
  }
  
  private static MonitorTask j(DownloadInfo paramDownloadInfo)
  {
    MonitorTask localMonitorTask = new MonitorTask();
    localMonitorTask.appName = paramDownloadInfo.f;
    localMonitorTask.packageName = paramDownloadInfo.e;
    localMonitorTask.versionCode = paramDownloadInfo.n;
    localMonitorTask.fileMd5 = paramDownloadInfo.H;
    try
    {
      localMonitorTask.yybApkId = Long.parseLong(paramDownloadInfo.m);
      localMonitorTask.yybAppId = Long.parseLong(paramDownloadInfo.c);
      label62:
      localMonitorTask.downloadUrl = paramDownloadInfo.d;
      localMonitorTask.additionalId = paramDownloadInfo.b;
      localMonitorTask.filePath = paramDownloadInfo.q;
      localMonitorTask.traceId = paramDownloadInfo.S;
      localMonitorTask.externalParams = new HashMap();
      localMonitorTask.externalParams.put("via", paramDownloadInfo.h);
      return localMonitorTask;
    }
    catch (Throwable localThrowable)
    {
      break label62;
    }
  }
  
  private static String k(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo == null) {
      return "";
    }
    return ReportDataBuilder.c().j(paramDownloadInfo.F).l(paramDownloadInfo.M).k(paramDownloadInfo.N).m(paramDownloadInfo.O).n(paramDownloadInfo.h).d();
  }
  
  private static String l(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo == null) {
      return "";
    }
    return ReportDataBuilder.c().b(paramDownloadInfo.f).c(paramDownloadInfo.e).a(paramDownloadInfo.n).d(paramDownloadInfo.c).e(paramDownloadInfo.m).f(paramDownloadInfo.K).g(paramDownloadInfo.L).h(paramDownloadInfo.d).i(paramDownloadInfo.J).e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.appstore.report.AppCenterReporter
 * JD-Core Version:    0.7.0.1
 */