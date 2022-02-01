package com.tencent.qqmini.sdk.manager;

import android.content.Context;
import android.os.Bundle;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;

class MiniLoadingAdManager$1
  implements Runnable
{
  MiniLoadingAdManager$1(MiniLoadingAdManager paramMiniLoadingAdManager, String paramString, MiniAppInfo paramMiniAppInfo, Context paramContext, MiniLoadingAdManager.OnChooseAdEndListener paramOnChooseAdEndListener) {}
  
  public void run()
  {
    if ((AdProxy)ProxyManager.get(AdProxy.class) == null)
    {
      QMLog.i("MiniLoadingAdManager", "start create, null");
      return;
    }
    MiniLoadingAdManager.access$000(this.val$uin, this.val$miniAppInfo.appId);
    Bundle localBundle = MiniLoadingAdManager.access$100(this.val$context, this.val$miniAppInfo, this.val$uin, 0);
    MiniAppInfo localMiniAppInfo = this.val$miniAppInfo;
    SDKMiniProgramLpReportDC04239.reportMiniAppEvent(localMiniAppInfo, SDKMiniProgramLpReportDC04239.getAppType(localMiniAppInfo), null, "ad", "ad_loading", "request_call_cnt", null);
    long l = System.currentTimeMillis();
    MiniLoadingAdManager.access$202(this.this$0, l);
    QMLog.d("MiniLoadingAdManager", "选单接口调用");
    ((AdProxy)ProxyManager.get(AdProxy.class)).selectLoadingAd(this.val$context, localBundle, this.val$uin, new MiniLoadingAdManager.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.MiniLoadingAdManager.1
 * JD-Core Version:    0.7.0.1
 */