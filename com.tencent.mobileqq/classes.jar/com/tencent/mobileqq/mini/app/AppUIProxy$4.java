package com.tencent.mobileqq.mini.app;

import android.app.Fragment;
import android.view.ViewGroup;
import android.view.Window;
import biip;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.manager.MiniLoadingAdManager;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.mini.widget.MiniLoadingAdLayout;

class AppUIProxy$4
  implements Runnable
{
  AppUIProxy$4(AppUIProxy paramAppUIProxy, BaseActivity paramBaseActivity, MiniAppConfig paramMiniAppConfig, String paramString, GdtAd paramGdtAd) {}
  
  public void run()
  {
    DisplayUtil.setSystemUIVisible(this.val$activity, false);
    MiniProgramLpReportDC04239.reportMiniAppEvent(this.val$miniAppConfig, MiniProgramLpReportDC04239.getAppType(this.val$miniAppConfig), null, "ad", "ad_loading", "expo_call", null);
    MiniLoadingAdLayout localMiniLoadingAdLayout = MiniLoadingAdManager.getInstance().getLoadingAdLayout(this.val$miniAppConfig, this.this$0.getAppBrandFragment().getActivity(), false, this.val$filePath, this.val$adInfo);
    if (localMiniLoadingAdLayout != null)
    {
      ((ViewGroup)this.val$activity.getWindow().getDecorView()).addView(localMiniLoadingAdLayout);
      MiniLoadingAdManager.getInstance().show(localMiniLoadingAdLayout, this.val$miniAppConfig.config.appId, String.valueOf(biip.a().a()), new AppUIProxy.4.1(this));
      MiniProgramLpReportDC04239.reportMiniAppEvent(this.val$miniAppConfig, MiniProgramLpReportDC04239.getAppType(this.val$miniAppConfig), null, "ad", "ad_loading", "expo_success", null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.app.AppUIProxy.4
 * JD-Core Version:    0.7.0.1
 */