package com.tencent.qqmini.sdk.plugins;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.AbsBannerAdView;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.utils.BannerAdPosInfo;
import java.util.HashMap;

class BannerAdPlugin$1
  implements Runnable
{
  BannerAdPlugin$1(BannerAdPlugin paramBannerAdPlugin, RequestEvent paramRequestEvent, String paramString, BannerAdPosInfo paramBannerAdPosInfo, Bundle paramBundle) {}
  
  public void run()
  {
    AdProxy localAdProxy = (AdProxy)ProxyManager.get(AdProxy.class);
    if ((localAdProxy != null) && (BannerAdPlugin.access$000(this.this$0) != null))
    {
      Activity localActivity = BannerAdPlugin.access$100(this.this$0).getAttachedActivity();
      if (localActivity == null)
      {
        QMLog.i("BannerAdPlugin", "start create, activity null");
        BannerAdPlugin.access$300(this.this$0, this.val$req, 1003, (String)BannerAdPlugin.access$200().get(Integer.valueOf(1003)), 300);
        return;
      }
      BannerAdPlugin.access$402(this.this$0, localAdProxy.createBannerAdView(localActivity, this.val$appid, this.val$adPosInfo.mAdUnitId, Math.round(BannerAdPlugin.access$000(this.this$0).mAdRealWidth * BannerAdPlugin.access$500(this.this$0)), Math.round(BannerAdPlugin.access$000(this.this$0).mAdRealHeight * BannerAdPlugin.access$500(this.this$0)), new BannerAdPlugin.1.1(this), this.val$ext, BannerAdPlugin.access$800(this.this$0), this.this$0));
      if (BannerAdPlugin.access$400(this.this$0) != null) {
        try
        {
          BannerAdPlugin.access$400(this.this$0).loadAD();
          return;
        }
        catch (Throwable localThrowable)
        {
          QMLog.i("BannerAdPlugin", "loadAd error", localThrowable);
        }
      }
      return;
    }
    QMLog.i("BannerAdPlugin", "start create, null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.BannerAdPlugin.1
 * JD-Core Version:    0.7.0.1
 */