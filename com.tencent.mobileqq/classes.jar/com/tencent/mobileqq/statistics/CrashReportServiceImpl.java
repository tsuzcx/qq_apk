package com.tencent.mobileqq.statistics;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.feedback.eup.CrashHandleListener;
import com.tencent.feedback.eup.CrashReport;
import com.tencent.hotpatch.DexPatchInstaller;
import com.tencent.mobileqq.app.ProcessUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bridge.statistics.service.ICrashReportService;
import com.tencent.mobileqq.data.entitymanager.Provider;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebView;
import mqq.os.MqqHandler;

public class CrashReportServiceImpl
  implements ICrashReportService, Provider<ICrashReportService>
{
  public CrashHandleListener a(StatisticCollector paramStatisticCollector)
  {
    return new BusinessCrashHandleListener(paramStatisticCollector);
  }
  
  public ICrashReportService a()
  {
    return this;
  }
  
  public void a(String paramString, StatisticCollector paramStatisticCollector)
  {
    Context localContext = StatisticCollector.ctx;
    CrashReport.setUserId(localContext, paramString);
    CrashReport.putUserData(localContext, "TbsSdkVersion", String.valueOf(WebView.getTbsSDKVersion(localContext)));
    CrashReport.putUserData(localContext, "X5CoreVersion", String.valueOf(QbSdk.getTbsVersion(localContext)));
    CrashReport.putUserData(localContext, "PatchInstallStatus", String.valueOf(DexPatchInstaller.jdField_a_of_type_Int));
    if (!TextUtils.isEmpty(DexPatchInstaller.jdField_a_of_type_JavaLangString)) {
      CrashReport.putUserData(localContext, "PatchNameInstalled", DexPatchInstaller.jdField_a_of_type_JavaLangString);
    }
    CrashReport.putUserData(localContext, "Revision", AppSetting.g());
    CrashReport.putUserData(localContext, "Version.buildNum", "8.5.5.5105");
    CrashReport.putUserData(localContext, "AboutSubVersionLog", AppSetting.b());
    CrashReport.putUserData(localContext, "appid", String.valueOf(AppSetting.a()));
    CrashReport.putUserData(localContext, "topActivity", ProcessUtil.a());
    paramStatisticCollector.threadInfo.append("Current process id=").append(Process.myPid()).append(", Name=").append(BaseApplicationImpl.processName).append("\n");
    StatisticCollector.sRdmInitTime = System.currentTimeMillis();
    if (1 == BaseApplicationImpl.sProcessId)
    {
      ThreadManager.getSubThreadHandler().postDelayed(new CrashReportServiceImpl.1(this, localContext, paramStatisticCollector, paramString), 3000L);
      ThreadManager.getSubThreadHandler().postDelayed(new CrashReportServiceImpl.2(this, localContext), 180000L);
      ThreadManager.getSubThreadHandler().postDelayed(new CrashReportServiceImpl.3(this, localContext), 600000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.CrashReportServiceImpl
 * JD-Core Version:    0.7.0.1
 */