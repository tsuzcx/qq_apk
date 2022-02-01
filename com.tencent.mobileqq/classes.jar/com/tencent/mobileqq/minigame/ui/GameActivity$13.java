package com.tencent.mobileqq.minigame.ui;

import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.manager.MiniLoadingAdManager;
import com.tencent.mobileqq.mini.manager.MiniLoadingAdManager.OnChooseAdEndListener;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.qphone.base.util.QLog;

class GameActivity$13
  implements MiniLoadingAdManager.OnChooseAdEndListener
{
  GameActivity$13(GameActivity paramGameActivity, MiniAppConfig paramMiniAppConfig) {}
  
  public void onChooseAdEnd(String paramString, GdtAd paramGdtAd)
  {
    long l1 = System.currentTimeMillis() - GameActivity.access$2400(this.this$0);
    if (GameActivity.access$2500(this.this$0) != 2)
    {
      if ((paramString != null) && (paramGdtAd != null))
      {
        QLog.d("MiniLoadingAdManager", 1, "onChooseAdEnd 还没加载完 显示广告 选单接口实单成功");
        GameActivity.access$2600(this.this$0, 2);
        this.this$0.runOnUiThread(new GameActivity.13.1(this, paramString, paramGdtAd));
        MiniProgramLpReportDC04239.reportMiniAppEvent(this.val$mGameAppConfig, MiniProgramLpReportDC04239.getAppType(this.val$mGameAppConfig), null, "ad", "ad_loading", "request_success_online", String.valueOf(l1));
        return;
      }
      if ((paramString == null) && (paramGdtAd != null))
      {
        QLog.d("MiniLoadingAdManager", 1, "onChooseAdEnd 选单返回了没有预下载过的广告");
        MiniLoadingAdManager.getInstance().processSelectAdWithUncachedAd(paramGdtAd, this.this$0.getCurrentAccountUin(), this.val$mGameAppConfig.config.appId, this);
        MiniProgramLpReportDC04239.reportMiniAppEvent(this.val$mGameAppConfig, MiniProgramLpReportDC04239.getAppType(this.val$mGameAppConfig), null, "ad", "ad_loading", "request_success_realtime", String.valueOf(l1));
        return;
      }
      QLog.d("MiniLoadingAdManager", 1, "onChooseAdEnd 选单接口空单成功");
      MiniProgramLpReportDC04239.reportMiniAppEvent(this.val$mGameAppConfig, MiniProgramLpReportDC04239.getAppType(this.val$mGameAppConfig), null, "ad", "ad_loading", "request_success_offline", String.valueOf(l1));
      return;
    }
    QLog.d("MiniLoadingAdManager", 1, "onChooseAdEnd 选单接口超时");
    long l2 = GameActivity.access$2800(this.this$0);
    long l3 = GameActivity.access$2400(this.this$0);
    MiniProgramLpReportDC04239.reportMiniAppEvent(this.val$mGameAppConfig, MiniProgramLpReportDC04239.getAppType(this.val$mGameAppConfig), null, "ad", "ad_loading", "request_timeout", String.valueOf(l2 - l3), String.valueOf(l1));
  }
  
  public void onDownloadAdEnd(String paramString, GdtAd paramGdtAd)
  {
    long l = System.currentTimeMillis() - GameActivity.access$2400(this.this$0);
    if (GameActivity.access$2500(this.this$0) != 2)
    {
      if ((paramString != null) && (paramGdtAd != null))
      {
        QLog.d("MiniLoadingAdManager", 1, "onDownloadAdEnd 图片下载成功");
        GameActivity.access$2600(this.this$0, 2);
        this.this$0.runOnUiThread(new GameActivity.13.2(this, paramString, paramGdtAd));
        MiniProgramLpReportDC04239.reportMiniAppEvent(this.val$mGameAppConfig, MiniProgramLpReportDC04239.getAppType(this.val$mGameAppConfig), null, "ad", "ad_loading", "spec_download_success", String.valueOf(l));
        return;
      }
      QLog.d("MiniLoadingAdManager", 1, "onDownloadAdEnd 图片下载失败");
      MiniProgramLpReportDC04239.reportMiniAppEvent(this.val$mGameAppConfig, MiniProgramLpReportDC04239.getAppType(this.val$mGameAppConfig), null, "ad", "ad_loading", "spec_download_fail", "");
      return;
    }
    QLog.d("MiniLoadingAdManager", 1, "onDownloadAdEnd 图片下载超时");
    MiniProgramLpReportDC04239.reportMiniAppEvent(this.val$mGameAppConfig, MiniProgramLpReportDC04239.getAppType(this.val$mGameAppConfig), null, "ad", "ad_loading", "spec_download_timeout", String.valueOf(l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.GameActivity.13
 * JD-Core Version:    0.7.0.1
 */