package com.tencent.qqmini.sdk.manager;

import android.content.Context;
import android.os.Bundle;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;

final class MiniLoadingAdManager$3
  implements Runnable
{
  MiniLoadingAdManager$3(Context paramContext, MiniAppInfo paramMiniAppInfo, String paramString) {}
  
  public void run()
  {
    if ((AdProxy)ProxyManager.get(AdProxy.class) == null)
    {
      QMLog.i("MiniLoadingAdManager", "start create, null");
      return;
    }
    Bundle localBundle = MiniLoadingAdManager.access$100(this.val$context, this.val$miniAppInfo, this.val$uin, 1);
    MiniAppInfo localMiniAppInfo = this.val$miniAppInfo;
    SDKMiniProgramLpReportDC04239.reportMiniAppEvent(localMiniAppInfo, SDKMiniProgramLpReportDC04239.getAppType(localMiniAppInfo), null, "ad", "ad_loading", "preload_call", null);
    long l = System.currentTimeMillis();
    ((AdProxy)ProxyManager.get(AdProxy.class)).preloadLoadingAd(this.val$context, localBundle, new MiniLoadingAdManager.3.1(this, l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.MiniLoadingAdManager.3
 * JD-Core Version:    0.7.0.1
 */