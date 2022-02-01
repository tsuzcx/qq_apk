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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("processSelectLoadingAdLogic onChooseAdEnd adJson=");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" aid=");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append(" needExtraDownload:");
    ((StringBuilder)localObject).append(paramBoolean);
    QMLog.i("MiniLoadingAdManager", ((StringBuilder)localObject).toString());
    long l1 = System.currentTimeMillis() - this.val$loadingAdSelectStartTime;
    if (this.this$0.isAbleToShowAd())
    {
      if (paramBoolean)
      {
        QMLog.i("MiniLoadingAdManager", "processSelectLoadingAdLogic onChooseAdEnd 选单返回了没有预下载过的广告");
        MiniLoadingAdManager.getInstance().processSelectAdWithUncachedAd(paramString, this.val$uin, this.val$miniAppInfo.appId, this);
        paramString = this.val$miniAppInfo;
        SDKMiniProgramLpReportDC04239.reportMiniAppEvent(paramString, SDKMiniProgramLpReportDC04239.getAppType(paramString), null, "ad", "ad_loading", "request_success_realtime", String.valueOf(l1));
        return;
      }
      if ((paramString != null) && (paramLong != -1L))
      {
        QMLog.i("MiniLoadingAdManager", "processSelectLoadingAdLogic onChooseAdEnd 选单接口实单成功");
        localObject = this.val$miniAppInfo;
        SDKMiniProgramLpReportDC04239.reportMiniAppEvent((MiniAppInfo)localObject, SDKMiniProgramLpReportDC04239.getAppType((MiniAppInfo)localObject), null, "ad", "ad_loading", "request_success_online", String.valueOf(l1));
        localObject = this.this$0;
        ((BaseUIProxy)localObject).updateLoadingAdUI(this.val$activity, this.val$miniAppInfo, paramString, paramLong, ((BaseUIProxy)localObject).showTimeStamp);
        return;
      }
      QMLog.i("MiniLoadingAdManager", "processSelectLoadingAdLogic onChooseAdEnd 选单接口空单成功");
      paramString = this.val$miniAppInfo;
      SDKMiniProgramLpReportDC04239.reportMiniAppEvent(paramString, SDKMiniProgramLpReportDC04239.getAppType(paramString), null, "ad", "ad_loading", "request_success_offline", String.valueOf(l1));
      return;
    }
    QMLog.i("MiniLoadingAdManager", "processSelectLoadingAdLogic onChooseAdEnd 选单接口超时");
    paramLong = this.this$0.loadCompleteTimeForLoadingAdReport;
    long l2 = this.val$loadingAdSelectStartTime;
    paramString = this.val$miniAppInfo;
    SDKMiniProgramLpReportDC04239.reportMiniAppEvent(paramString, SDKMiniProgramLpReportDC04239.getAppType(paramString), null, "ad", "ad_loading", "request_timeout", String.valueOf(paramLong - l2), String.valueOf(l1));
  }
  
  public void onDownloadAdEnd(String paramString, long paramLong)
  {
    long l = System.currentTimeMillis() - this.val$loadingAdSelectStartTime;
    if (this.this$0.isAbleToShowAd())
    {
      if ((paramString != null) && (paramLong != -1L))
      {
        QMLog.i("MiniLoadingAdManager", "processSelectLoadingAdLogic onDownloadAdEnd 图片下载成功");
        Object localObject = this.val$miniAppInfo;
        SDKMiniProgramLpReportDC04239.reportMiniAppEvent((MiniAppInfo)localObject, SDKMiniProgramLpReportDC04239.getAppType((MiniAppInfo)localObject), null, "ad", "ad_loading", "spec_download_success", String.valueOf(l));
        localObject = this.this$0;
        ((BaseUIProxy)localObject).updateLoadingAdUI(this.val$activity, this.val$miniAppInfo, paramString, paramLong, ((BaseUIProxy)localObject).showTimeStamp);
        return;
      }
      QMLog.i("MiniLoadingAdManager", "processSelectLoadingAdLogic onDownloadAdEnd 图片下载失败");
      paramString = this.val$miniAppInfo;
      SDKMiniProgramLpReportDC04239.reportMiniAppEvent(paramString, SDKMiniProgramLpReportDC04239.getAppType(paramString), null, "ad", "ad_loading", "spec_download_fail", "");
      return;
    }
    QMLog.i("MiniLoadingAdManager", "processSelectLoadingAdLogic onDownloadAdEnd 图片下载超时");
    paramString = this.val$miniAppInfo;
    SDKMiniProgramLpReportDC04239.reportMiniAppEvent(paramString, SDKMiniProgramLpReportDC04239.getAppType(paramString), null, "ad", "ad_loading", "spec_download_timeout", String.valueOf(l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.BaseUIProxy.5
 * JD-Core Version:    0.7.0.1
 */