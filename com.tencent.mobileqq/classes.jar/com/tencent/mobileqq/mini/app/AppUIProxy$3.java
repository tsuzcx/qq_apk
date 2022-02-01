package com.tencent.mobileqq.mini.app;

import biip;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.manager.MiniLoadingAdManager;
import com.tencent.mobileqq.mini.manager.MiniLoadingAdManager.OnChooseAdEndListener;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.qphone.base.util.QLog;

class AppUIProxy$3
  implements MiniLoadingAdManager.OnChooseAdEndListener
{
  AppUIProxy$3(AppUIProxy paramAppUIProxy, long paramLong, MiniAppConfig paramMiniAppConfig, BaseActivity paramBaseActivity) {}
  
  public void onChooseAdEnd(String paramString, GdtAd paramGdtAd)
  {
    long l1 = System.currentTimeMillis() - this.val$loadingAdSelectStartTime;
    if (!AppUIProxy.access$000(this.this$0))
    {
      if ((paramString != null) && (paramGdtAd != null))
      {
        QLog.d("MiniLoadingAdManager", 1, "选单接口实单成功");
        MiniProgramLpReportDC04239.reportMiniAppEvent(this.val$miniAppConfig, MiniProgramLpReportDC04239.getAppType(this.val$miniAppConfig), null, "ad", "ad_loading", "request_success_online", String.valueOf(l1));
        AppUIProxy.access$100(this.this$0, this.val$activity, this.val$miniAppConfig, paramString, paramGdtAd);
        return;
      }
      if ((paramString == null) && (paramGdtAd != null))
      {
        QLog.d("MiniLoadingAdManager", 1, "选单返回了没有预下载过的广告");
        MiniLoadingAdManager.getInstance().processSelectAdWithUncachedAd(paramGdtAd, String.valueOf(biip.a().a()), this.val$miniAppConfig.config.appId, this);
        MiniProgramLpReportDC04239.reportMiniAppEvent(this.val$miniAppConfig, MiniProgramLpReportDC04239.getAppType(this.val$miniAppConfig), null, "ad", "ad_loading", "request_success_realtime", String.valueOf(l1));
        return;
      }
      QLog.d("MiniLoadingAdManager", 1, "选单接口空单成功");
      MiniProgramLpReportDC04239.reportMiniAppEvent(this.val$miniAppConfig, MiniProgramLpReportDC04239.getAppType(this.val$miniAppConfig), null, "ad", "ad_loading", "request_success_offline", String.valueOf(l1));
      return;
    }
    QLog.d("MiniLoadingAdManager", 1, "选单接口超时");
    long l2 = AppUIProxy.access$200(this.this$0);
    long l3 = this.val$loadingAdSelectStartTime;
    MiniProgramLpReportDC04239.reportMiniAppEvent(this.val$miniAppConfig, MiniProgramLpReportDC04239.getAppType(this.val$miniAppConfig), null, "ad", "ad_loading", "request_timeout", String.valueOf(l2 - l3), String.valueOf(l1));
  }
  
  public void onDownloadAdEnd(String paramString, GdtAd paramGdtAd)
  {
    long l = System.currentTimeMillis() - this.val$loadingAdSelectStartTime;
    if (!AppUIProxy.access$000(this.this$0))
    {
      if ((paramString != null) && (paramGdtAd != null))
      {
        QLog.d("MiniLoadingAdManager", 1, "onDownloadAdEnd 图片下载成功");
        MiniProgramLpReportDC04239.reportMiniAppEvent(this.val$miniAppConfig, MiniProgramLpReportDC04239.getAppType(this.val$miniAppConfig), null, "ad", "ad_loading", "spec_download_success", String.valueOf(l));
        AppUIProxy.access$100(this.this$0, this.val$activity, this.val$miniAppConfig, paramString, paramGdtAd);
        return;
      }
      QLog.d("MiniLoadingAdManager", 1, "onDownloadAdEnd 图片下载失败");
      MiniProgramLpReportDC04239.reportMiniAppEvent(this.val$miniAppConfig, MiniProgramLpReportDC04239.getAppType(this.val$miniAppConfig), null, "ad", "ad_loading", "spec_download_fail", "");
      return;
    }
    QLog.d("MiniLoadingAdManager", 1, "onDownloadAdEnd 图片下载超时");
    MiniProgramLpReportDC04239.reportMiniAppEvent(this.val$miniAppConfig, MiniProgramLpReportDC04239.getAppType(this.val$miniAppConfig), null, "ad", "ad_loading", "spec_download_timeout", String.valueOf(l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.app.AppUIProxy.3
 * JD-Core Version:    0.7.0.1
 */