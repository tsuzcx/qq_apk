package com.tencent.mobileqq.mini.appbrand;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.app.AppLoaderFactory;
import com.tencent.mobileqq.mini.app.BaseAppLoaderManager;
import com.tencent.mobileqq.mini.appbrand.page.AbsAppBrandPage;
import com.tencent.mobileqq.mini.appbrand.page.AppBrandPageContainer;
import com.tencent.mobileqq.mini.report.MiniAppStartState;
import com.tencent.mobileqq.mini.report.MiniProgramReportHelper;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.qphone.base.util.QLog;

class AppBrandRuntime$8
  implements Runnable
{
  AppBrandRuntime$8(AppBrandRuntime paramAppBrandRuntime) {}
  
  public void run()
  {
    QLog.i("miniapp-start", 1, "custom_event_PAGE_EVENT __DOMReady.  Show the page.");
    MiniReportManager.reportEventType(this.this$0.apkgInfo.appConfig, 611, MiniProgramReportHelper.currentUrlFromAppBrandRuntime(this.this$0), null, null, 0, MiniAppStartState.getBaseLibDownloadDesc(this.this$0.appId), MiniAppStartState.getApkgDownloadDesc(this.this$0.appId), MiniAppStartState.getBaselibLoadDesc(this.this$0.appId), MiniAppStartState.getPageSwitchDesc(this.this$0.appId));
    MiniReportManager.reportEventType(this.this$0.apkgInfo.appConfig, 645, MiniProgramReportHelper.currentUrlFromAppBrandRuntime(this.this$0), null, null, 0);
    AbsAppBrandPage localAbsAppBrandPage;
    if (this.this$0.pageContainer != null)
    {
      localAbsAppBrandPage = this.this$0.pageContainer.getCurrentPage();
      if ((localAbsAppBrandPage == null) || (localAbsAppBrandPage.getVisibility() == 0) || (localAbsAppBrandPage.isHomePage())) {}
    }
    try
    {
      localAbsAppBrandPage.setVisibility(0);
      Animation localAnimation = AnimationUtils.loadAnimation(AppLoaderFactory.getAppLoaderManager().getContext(), 2130772271);
      localAnimation.setAnimationListener(new AppBrandRuntime.8.1(this));
      localAbsAppBrandPage.setAnimation(localAnimation);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("AppBrandRuntime", 4, "custom_event_PAGE_EVENT __DOMReady exception.", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.AppBrandRuntime.8
 * JD-Core Version:    0.7.0.1
 */