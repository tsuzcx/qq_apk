package com.tencent.qqmini.minigame.plugins;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import com.tencent.qqmini.minigame.R.string;
import com.tencent.qqmini.sdk.action.ShareAction;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class RaffleJsPlugin$17
  implements RaffleJsPlugin.OnRaffleFailListener
{
  RaffleJsPlugin$17(RaffleJsPlugin paramRaffleJsPlugin) {}
  
  public void onAgain()
  {
    RaffleJsPlugin.access$3900(this.a, "again");
    QMLog.d(RaffleJsPlugin.access$200(), "onRaffleFailListener onAgain");
    RaffleJsPlugin.access$1200(this.a, "xiaoyouxi_fail_again", "clk");
  }
  
  public void onClose()
  {
    RaffleJsPlugin.access$3900(this.a, "close");
    QMLog.d(RaffleJsPlugin.access$200(), "onRaffleFailListener onClose");
    RaffleJsPlugin.access$1200(this.a, "xiaoyouxi_fail_close", "clk");
  }
  
  public void onShare()
  {
    QMLog.d(RaffleJsPlugin.access$200(), "onRaffleFailListener onShare");
    Activity localActivity = RaffleJsPlugin.access$4000(this.a).getAttachedActivity();
    if (RaffleJsPlugin.access$3700(this.a, localActivity))
    {
      RaffleJsPlugin.access$400(this.a, localActivity, localActivity.getResources().getString(R.string.mini_sdk_game_raffle_no_network));
      QMLog.e(RaffleJsPlugin.access$200(), "onRaffleFailListener onShare no network");
      return;
    }
    RaffleJsPlugin.access$4100(this.a).performAction(ShareAction.obtain(6));
    RaffleJsPlugin.access$1200(this.a, "xiaoyouxi_fail_share_recover", "clk");
  }
  
  public void onWatchAd()
  {
    QMLog.d(RaffleJsPlugin.access$200(), "onRaffleFailListener onWatchAd");
    Activity localActivity = RaffleJsPlugin.access$4200(this.a).getAttachedActivity();
    if (RaffleJsPlugin.access$3700(this.a, localActivity))
    {
      RaffleJsPlugin.access$400(this.a, localActivity, localActivity.getResources().getString(R.string.mini_sdk_game_raffle_no_network));
      QMLog.e(RaffleJsPlugin.access$200(), "onRaffleFailListener onWatchAd no network");
      return;
    }
    RaffleJsPlugin.access$4300(this.a, localActivity);
    RaffleJsPlugin.access$1200(this.a, "xiaoyouxi_fail_reward_video", "clk");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.RaffleJsPlugin.17
 * JD-Core Version:    0.7.0.1
 */