package com.tencent.qqmini.sdk.core.plugins;

import android.app.Activity;
import android.os.Bundle;
import bekr;
import com.tencent.qqmini.sdk.core.proxy.AdProxy;
import com.tencent.qqmini.sdk.core.proxy.AdProxy.AbsRewardVideoAdView;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;

class RewardedVideoAdPlugin$1
  implements Runnable
{
  RewardedVideoAdPlugin$1(RewardedVideoAdPlugin paramRewardedVideoAdPlugin, Activity paramActivity, String paramString1, String paramString2, bekr parambekr, String paramString3, Bundle paramBundle) {}
  
  public void run()
  {
    AdProxy localAdProxy = (AdProxy)ProxyManager.get(AdProxy.class);
    if (localAdProxy == null)
    {
      RewardedVideoAdPlugin.access$002(this.this$0, false);
      return;
    }
    RewardedVideoAdPlugin.access$102(this.this$0, localAdProxy.createRewardVideoAdView(this.val$activity, this.val$appid, this.val$pos_id, new RewardedVideoAdPlugin.1.1(this), this.val$ext));
    try
    {
      if (RewardedVideoAdPlugin.access$100(this.this$0) != null)
      {
        RewardedVideoAdPlugin.access$100(this.this$0).loadAD();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.RewardedVideoAdPlugin.1
 * JD-Core Version:    0.7.0.1
 */