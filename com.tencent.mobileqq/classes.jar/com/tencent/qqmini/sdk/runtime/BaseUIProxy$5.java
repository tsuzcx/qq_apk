package com.tencent.qqmini.sdk.runtime;

import android.app.Activity;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.manager.MiniLoadingAdManager;
import com.tencent.qqmini.sdk.manager.MiniLoadingAdManager.OnChooseAdEndListener;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;

class BaseUIProxy$5
  implements MiniLoadingAdManager.OnChooseAdEndListener
{
  BaseUIProxy$5(BaseUIProxy paramBaseUIProxy, long paramLong, String paramString, MiniAppInfo paramMiniAppInfo, Activity paramActivity) {}
  
  public void onChooseAdEnd(String paramString, long paramLong, boolean paramBoolean)
  {
    QMLog.i("MiniLoadingAdManager", "processSelectLoadingAdLogic onChooseAdEnd adJson=" + paramString + " aid=" + paramLong + " needExtraDownload:" + paramBoolean);
    long l1 = System.currentTimeMillis() - this.val$loadingAdSelectStartTime;
    if (!this.this$0.hasCompletedLoading)
    {
      if (paramBoolean)
      {
        QMLog.i("MiniLoadingAdManager", "processSelectLoadingAdLogic onChooseAdEnd 选单返回了没有预下载过的广告");
        MiniLoadingAdManager.getInstance().processSelectAdWithUncachedAd(paramString, this.val$uin, this.val$miniAppInfo.appId, this);
        SDKMiniProgramLpReportDC04239.reportMiniAppEvent(this.val$miniAppInfo, SDKMiniProgramLpReportDC04239.getAppType(this.val$miniAppInfo), null, "ad", "ad_loading", "request_success_realtime", String.valueOf(l1));
        return;
      }
      if ((paramString != null) && (paramLong != -1L))
      {
        QMLog.i("MiniLoadingAdManager", "processSelectLoadingAdLogic onChooseAdEnd 选单接口实单成功");
        SDKMiniProgramLpReportDC04239.reportMiniAppEvent(this.val$miniAppInfo, SDKMiniProgramLpReportDC04239.getAppType(this.val$miniAppInfo), null, "ad", "ad_loading", "request_success_online", String.valueOf(l1));
        this.this$0.updateLoadingAdUI(this.val$activity, this.val$miniAppInfo, paramString, paramLong, this.this$0.showTimeStamp);
        return;
      }
      QMLog.i("MiniLoadingAdManager", "processSelectLoadingAdLogic onChooseAdEnd 选单接口空单成功");
      SDKMiniProgramLpReportDC04239.reportMiniAppEvent(this.val$miniAppInfo, SDKMiniProgramLpReportDC04239.getAppType(this.val$miniAppInfo), null, "ad", "ad_loading", "request_success_offline", String.valueOf(l1));
      return;
    }
    QMLog.i("MiniLoadingAdManager", "processSelectLoadingAdLogic onChooseAdEnd 选单接口超时");
    paramLong = this.this$0.loadCompleteTimeForLoadingAdReport;
    long l2 = this.val$loadingAdSelectStartTime;
    SDKMiniProgramLpReportDC04239.reportMiniAppEvent(this.val$miniAppInfo, SDKMiniProgramLpReportDC04239.getAppType(this.val$miniAppInfo), null, "ad", "ad_loading", "request_timeout", String.valueOf(paramLong - l2), String.valueOf(l1));
  }
  
  public void onDownloadAdEnd(String paramString, long paramLong)
  {
    long l = System.currentTimeMillis() - this.val$loadingAdSelectStartTime;
    if (!this.this$0.hasCompletedLoading)
    {
      if ((paramString != null) && (paramLong != -1L))
      {
        QMLog.i("MiniLoadingAdManager", "processSelectLoadingAdLogic onDownloadAdEnd 图片下载成功");
        SDKMiniProgramLpReportDC04239.reportMiniAppEvent(this.val$miniAppInfo, SDKMiniProgramLpReportDC04239.getAppType(this.val$miniAppInfo), null, "ad", "ad_loading", "spec_download_success", String.valueOf(l));
        this.this$0.updateLoadingAdUI(this.val$activity, this.val$miniAppInfo, paramString, paramLong, this.this$0.showTimeStamp);
        return;
      }
      QMLog.i("MiniLoadingAdManager", "processSelectLoadingAdLogic onDownloadAdEnd 图片下载失败");
      SDKMiniProgramLpReportDC04239.reportMiniAppEvent(this.val$miniAppInfo, SDKMiniProgramLpReportDC04239.getAppType(this.val$miniAppInfo), null, "ad", "ad_loading", "spec_download_fail", "");
      return;
    }
    QMLog.i("MiniLoadingAdManager", "processSelectLoadingAdLogic onDownloadAdEnd 图片下载超时");
    SDKMiniProgramLpReportDC04239.reportMiniAppEvent(this.val$miniAppInfo, SDKMiniProgramLpReportDC04239.getAppType(this.val$miniAppInfo), null, "ad", "ad_loading", "spec_download_timeout", String.valueOf(l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.BaseUIProxy.5
 * JD-Core Version:    0.7.0.1
 */