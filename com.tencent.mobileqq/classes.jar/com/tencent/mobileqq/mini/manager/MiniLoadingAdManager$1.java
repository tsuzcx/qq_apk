package com.tencent.mobileqq.mini.manager;

import NS_MINI_AD.MiniAppAd.StGetAdReq;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.qphone.base.util.QLog;

class MiniLoadingAdManager$1
  implements Runnable
{
  MiniLoadingAdManager$1(MiniLoadingAdManager paramMiniLoadingAdManager, MiniAppConfig paramMiniAppConfig, String paramString, MiniLoadingAdManager.OnChooseAdEndListener paramOnChooseAdEndListener) {}
  
  public void run()
  {
    MiniAppAd.StGetAdReq localStGetAdReq = MiniLoadingAdManager.access$000(this.val$miniAppConfig, this.val$uin, 0);
    QLog.d("MiniLoadingAdManager", 1, "选单接口调用");
    MiniAppConfig localMiniAppConfig = this.val$miniAppConfig;
    MiniProgramLpReportDC04239.reportMiniAppEvent(localMiniAppConfig, MiniProgramLpReportDC04239.getAppType(localMiniAppConfig), null, "ad", "ad_loading", "request_call_cnt", null);
    MiniAppCmdUtil.getInstance().getRewardedVideoADInfo(localStGetAdReq, new MiniLoadingAdManager.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.manager.MiniLoadingAdManager.1
 * JD-Core Version:    0.7.0.1
 */