package com.tencent.qqmini.sdk.plugins;

import android.content.Context;
import android.os.Bundle;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.AbsRewardVideoAdView;

class RewardedVideoAdPlugin$1
  implements Runnable
{
  RewardedVideoAdPlugin$1(RewardedVideoAdPlugin paramRewardedVideoAdPlugin, Context paramContext, String paramString1, String paramString2, RequestEvent paramRequestEvent, String paramString3, Bundle paramBundle) {}
  
  public void run()
  {
    AdProxy localAdProxy = (AdProxy)ProxyManager.get(AdProxy.class);
    if (localAdProxy == null)
    {
      RewardedVideoAdPlugin.access$002(this.this$0, false);
      return;
    }
    RewardedVideoAdPlugin.access$102(this.this$0, localAdProxy.createRewardVideoAdView(this.val$context, this.val$appid, this.val$posId, new RewardedVideoAdPlugin.1.1(this), this.val$ext, RewardedVideoAdPlugin.access$1400(this.this$0)));
    try
    {
      if (RewardedVideoAdPlugin.access$100(this.this$0) != null)
      {
        RewardedVideoAdPlugin.access$100(this.this$0).loadAD(this.val$context);
        return;
      }
    }
    catch (Exception localException)
    {
      RewardedVideoAdPlugin.access$002(this.this$0, false);
      return;
    }
    RewardedVideoAdPlugin.access$002(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.RewardedVideoAdPlugin.1
 * JD-Core Version:    0.7.0.1
 */