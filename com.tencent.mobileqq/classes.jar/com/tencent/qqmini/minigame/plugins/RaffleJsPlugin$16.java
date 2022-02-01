package com.tencent.qqmini.minigame.plugins;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import com.tencent.qqmini.minigame.R.string;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class RaffleJsPlugin$16
  implements RaffleJsPlugin.OnRaffleSuccessListener
{
  RaffleJsPlugin$16(RaffleJsPlugin paramRaffleJsPlugin) {}
  
  public void onAgain()
  {
    RaffleJsPlugin.access$3900(this.a, "again");
    QMLog.d(RaffleJsPlugin.access$200(), "onRaffleSuccessListener onAgain");
    RaffleJsPlugin.access$1200(this.a, "xiaoyouxi_return_again", "clk");
  }
  
  public void onClose()
  {
    QMLog.d(RaffleJsPlugin.access$200(), "onRaffleSuccessListener onClose");
    RaffleJsPlugin.access$1200(this.a, "xiaoyouxi_choujiang_close", "clk");
  }
  
  public void onCloseCancel()
  {
    QMLog.d(RaffleJsPlugin.access$200(), "onRaffleSuccessListener onCloseCancel");
    RaffleJsPlugin.access$1200(this.a, "xiaoyouxi_close_pop_cancel", "clk");
  }
  
  public void onCloseCertain()
  {
    RaffleJsPlugin.access$3900(this.a, "close");
    QMLog.d(RaffleJsPlugin.access$200(), "onRaffleSuccessListener onCloseCertain");
    RaffleJsPlugin.access$1200(this.a, "xiaoyouxi_close_pop_confirm", "clk");
  }
  
  public void onGoBackMain()
  {
    RaffleJsPlugin.access$3900(this.a, "close");
    QMLog.d(RaffleJsPlugin.access$200(), "onRaffleSuccessListener onGoBack");
    RaffleJsPlugin.access$1200(this.a, "xiaoyouxi_return_game", "clk");
  }
  
  public boolean onReceive()
  {
    QMLog.d(RaffleJsPlugin.access$200(), "onRaffleSuccessListener onReceive");
    Activity localActivity = RaffleJsPlugin.access$3600(this.a).getAttachedActivity();
    if (RaffleJsPlugin.access$3700(this.a, localActivity))
    {
      QMLog.e(RaffleJsPlugin.access$200(), "onRaffleSuccessListener onReceive no network");
      RaffleJsPlugin.access$400(this.a, localActivity, localActivity.getResources().getString(R.string.mini_sdk_game_raffle_no_network));
      return false;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("url", RaffleJsPlugin.access$3800(this.a) + "&_wwv=13");
    ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).startBrowserActivity(localActivity, localIntent);
    RaffleJsPlugin.access$1200(this.a, "xiaoyouxi_choujiang_open", "clk");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.RaffleJsPlugin.16
 * JD-Core Version:    0.7.0.1
 */