package com.tencent.mobileqq.mini.tfs.mini;

import android.content.Context;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.apkg.ApkgMainProcessManager;
import com.tencent.mobileqq.mini.apkg.ApkgManager;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.report.MiniAppReportManager2;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.tfs.AsyncTask;
import com.tencent.qphone.base.util.QLog;

public class ApkgLoadAsyncTask
  extends AsyncTask
{
  public String errorMsg;
  private ApkgInfo mApkgInfo;
  private MiniAppConfig mLoadingApp;
  
  public ApkgLoadAsyncTask(Context paramContext)
  {
    super(paramContext);
  }
  
  private void loadApkgInMiniProcess(MiniAppConfig paramMiniAppConfig)
  {
    ApkgMainProcessManager.queueSubProcessLoadTask(paramMiniAppConfig);
    ApkgManager.getInstance().getApkgInfoByConfig(paramMiniAppConfig, new ApkgLoadAsyncTask.2(this, paramMiniAppConfig));
  }
  
  private void tryLoadApkgInMainProcess(MiniAppConfig paramMiniAppConfig)
  {
    ThreadManagerV2.excute(new ApkgLoadAsyncTask.1(this, paramMiniAppConfig), 16, null, false);
  }
  
  public void executeAsync() {}
  
  public ApkgInfo getApkgInfo()
  {
    return this.mApkgInfo;
  }
  
  public void loadApkgByConfig(MiniAppConfig paramMiniAppConfig)
  {
    QLog.i("miniapp-start", 1, "ApkgLoadAsyncTask start loadApkgByConfig");
    if ((paramMiniAppConfig == null) || (paramMiniAppConfig.config == null) || (paramMiniAppConfig.config.appId == null)) {
      return;
    }
    if ((this.mApkgInfo != null) && (this.mApkgInfo.appConfig != null) && (this.mApkgInfo.appConfig.equals(paramMiniAppConfig)))
    {
      QLog.i("miniapp-start", 1, "initApkgByConfig appid " + paramMiniAppConfig.config.appId + " has loaded.");
      onTaskSucceed();
      return;
    }
    if ((this.mLoadingApp != null) && (this.mLoadingApp.equals(paramMiniAppConfig)))
    {
      QLog.i("miniapp-start", 1, "initApkgByConfig appid " + paramMiniAppConfig.config.appId + " is loading.");
      return;
    }
    QLog.i("miniapp-start", 1, "initApkgByConfig start");
    this.mLoadingApp = paramMiniAppConfig;
    this.mApkgInfo = null;
    tryLoadApkgInMainProcess(paramMiniAppConfig);
  }
  
  public void onTaskFailed(int paramInt, String paramString)
  {
    super.onTaskFailed(paramInt, paramString);
    if (this.mLoadingApp == null) {
      return;
    }
    if (paramInt == 3)
    {
      MiniProgramLpReportDC04239.reportPageView(this.mLoadingApp, "0", null, "load_fail", "unpkg_fail");
      MiniAppReportManager2.reportPageView("2launch_fail", "unpkg_fail", null, this.mLoadingApp);
      return;
    }
    if (paramInt == 1)
    {
      MiniProgramLpReportDC04239.reportPageView(this.mLoadingApp, "0", null, "load_fail", "download_url_fail");
      MiniAppReportManager2.reportPageView("2launch_fail", "download_url_fail", null, this.mLoadingApp);
      return;
    }
    MiniProgramLpReportDC04239.reportPageView(this.mLoadingApp, "0", null, "load_fail", "download_apk_fail");
    MiniAppReportManager2.reportPageView("2launch_fail", "download_apk_fail", null, this.mLoadingApp);
  }
  
  public void onTaskSucceed()
  {
    super.onTaskSucceed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.tfs.mini.ApkgLoadAsyncTask
 * JD-Core Version:    0.7.0.1
 */