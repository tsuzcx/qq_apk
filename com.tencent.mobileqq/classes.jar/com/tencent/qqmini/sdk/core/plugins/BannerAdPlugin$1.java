package com.tencent.qqmini.sdk.core.plugins;

import android.os.Bundle;
import bglv;
import bgok;
import com.tencent.qqmini.sdk.core.proxy.AdProxy;
import com.tencent.qqmini.sdk.core.proxy.AdProxy.AbsBannerAdView;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.utils.BannerAdPosInfo;

class BannerAdPlugin$1
  implements Runnable
{
  BannerAdPlugin$1(BannerAdPlugin paramBannerAdPlugin, String paramString, BannerAdPosInfo paramBannerAdPosInfo, bgok parambgok, Bundle paramBundle) {}
  
  public void run()
  {
    if (((AdProxy)ProxyManager.get(AdProxy.class) == null) || (BannerAdPlugin.access$000(this.this$0) == null)) {
      QMLog.i("BannerAdPlugin", "start create, null");
    }
    do
    {
      return;
      BannerAdPlugin.access$102(this.this$0, ((AdProxy)ProxyManager.get(AdProxy.class)).createBannerAdView(this.this$0.mMiniAppContext.a(), this.val$appid, this.val$adPosInfo.mAdUnitId, Math.round(BannerAdPlugin.access$000(this.this$0).mAdRealWidth * BannerAdPlugin.access$200(this.this$0)), Math.round(BannerAdPlugin.access$000(this.this$0).mAdRealHeight * BannerAdPlugin.access$200(this.this$0)), new BannerAdPlugin.1.1(this), this.val$ext));
    } while (BannerAdPlugin.access$100(this.this$0) == null);
    try
    {
      BannerAdPlugin.access$100(this.this$0).loadAD();
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.i("BannerAdPlugin", "loadAd error", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.BannerAdPlugin.1
 * JD-Core Version:    0.7.0.1
 */