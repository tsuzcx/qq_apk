package com.tencent.qqmini.sdk.core.plugins;

import android.app.Activity;
import android.os.Bundle;
import bdfz;
import com.tencent.qqmini.sdk.core.proxy.AdProxy;
import com.tencent.qqmini.sdk.core.proxy.AdProxy.AbsRewardVideoAdView;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;

class RewardedVideoAdPlugin$2
  implements Runnable
{
  RewardedVideoAdPlugin$2(RewardedVideoAdPlugin paramRewardedVideoAdPlugin, Activity paramActivity, String paramString1, String paramString2, bdfz parambdfz, String paramString3, Bundle paramBundle) {}
  
  public void run()
  {
    AdProxy localAdProxy = (AdProxy)ProxyManager.get(AdProxy.class);
    if (localAdProxy == null)
    {
      RewardedVideoAdPlugin.access$102(this.this$0, false);
      return;
    }
    RewardedVideoAdPlugin.access$202(this.this$0, localAdProxy.createRewardVideoAdView(this.val$activity, this.val$appid, this.val$pos_id, new RewardedVideoAdPlugin.2.1(this), this.val$ext));
    try
    {
      if (RewardedVideoAdPlugin.access$200(this.this$0) != null)
      {
        RewardedVideoAdPlugin.access$200(this.this$0).loadAD();
        return;
      }
    }
    catch (Exception localException)
    {
      RewardedVideoAdPlugin.access$102(this.this$0, false);
      return;
    }
    RewardedVideoAdPlugin.access$102(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.RewardedVideoAdPlugin.2
 * JD-Core Version:    0.7.0.1
 */