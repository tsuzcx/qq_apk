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
    AdProxy localAdProxy = (AdProxy)ProxyManager.get(AdProxy.class);
    j = 1;
    if (localAdProxy == null)
    {
      i = j;
    }
    else
    {
      RaffleJsPlugin localRaffleJsPlugin = this.this$0;
      RaffleJsPlugin.access$2002(localRaffleJsPlugin, localAdProxy.createRewardVideoAdView(this.jdField_a_of_type_AndroidContentContext, RaffleJsPlugin.access$2100(localRaffleJsPlugin), RaffleJsPlugin.access$2200(this.this$0), new RaffleJsPlugin.10.1(this), this.jdField_a_of_type_AndroidOsBundle, RaffleJsPlugin.access$3300(this.this$0)));
      i = j;
    }
    try
    {
      if (RaffleJsPlugin.access$2000(this.this$0) != null)
      {
        RaffleJsPlugin.access$2000(this.this$0).loadAD(this.jdField_a_of_type_AndroidContentContext);
        i = 0;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        i = j;
      }
    }
    if (i != 0)
    {
      RaffleJsPlugin.access$2302(this.this$0, false);
      RaffleJsPlugin.access$2402(this.this$0, false);
      this.this$0.hideLoading();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.RaffleJsPlugin.10
 * JD-Core Version:    0.7.0.1
 */