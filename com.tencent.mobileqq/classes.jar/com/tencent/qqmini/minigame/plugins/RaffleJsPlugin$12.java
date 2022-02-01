package com.tencent.qqmini.minigame.plugins;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.qqmini.minigame.R.string;
import com.tencent.qqmini.minigame.ui.RaffleFailDialog;
import com.tencent.qqmini.sdk.widget.MiniToast;

class RaffleJsPlugin$12
  implements Runnable
{
  RaffleJsPlugin$12(RaffleJsPlugin paramRaffleJsPlugin, Context paramContext) {}
  
  public void run()
  {
    String str = this.a.getResources().getString(R.string.mini_sdk_game_raffle_fail_ad_fail_twice_auto_reward);
    MiniToast.makeText(this.a, 0, str, 1).show();
    if (RaffleJsPlugin.access$000(this.this$0) != null) {
      RaffleJsPlugin.access$000(this.this$0).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.RaffleJsPlugin.12
 * JD-Core Version:    0.7.0.1
 */