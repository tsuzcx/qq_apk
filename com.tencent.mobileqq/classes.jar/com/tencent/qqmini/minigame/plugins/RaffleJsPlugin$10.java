package com.tencent.qqmini.minigame.plugins;

import android.content.Context;
import android.os.Bundle;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.AbsRewardVideoAdView;

class RaffleJsPlugin$10
  implements Runnable
{
  RaffleJsPlugin$10(RaffleJsPlugin paramRaffleJsPlugin, Context paramContext, Bundle paramBundle) {}
  
  public void run()
  {
    int i = 1;
    AdProxy localAdProxy = (AdProxy)ProxyManager.get(AdProxy.class);
    if (localAdProxy == null) {}
    for (;;)
    {
      if (i != 0)
      {
        RaffleJsPlugin.access$2302(this.this$0, false);
        RaffleJsPlugin.access$2402(this.this$0, false);
        this.this$0.hideLoading();
      }
      return;
      RaffleJsPlugin.access$2002(this.this$0, localAdProxy.createRewardVideoAdView(this.jdField_a_of_type_AndroidContentContext, RaffleJsPlugin.access$2100(this.this$0), RaffleJsPlugin.access$2200(this.this$0), new RaffleJsPlugin.10.1(this), this.jdField_a_of_type_AndroidOsBundle, RaffleJsPlugin.access$3300(this.this$0)));
      try
      {
        if (RaffleJsPlugin.access$2000(this.this$0) != null) {
          RaffleJsPlugin.access$2000(this.this$0).loadAD(this.jdField_a_of_type_AndroidContentContext);
        }
        for (i = 0;; i = 1) {
          break;
        }
      }
      catch (Exception localException) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.RaffleJsPlugin.10
 * JD-Core Version:    0.7.0.1
 */