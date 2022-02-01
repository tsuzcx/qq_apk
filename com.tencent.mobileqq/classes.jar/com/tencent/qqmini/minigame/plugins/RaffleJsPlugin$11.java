package com.tencent.qqmini.minigame.plugins;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.qqmini.minigame.R.string;
import com.tencent.qqmini.minigame.ui.RaffleFailDialog;
import com.tencent.qqmini.sdk.widget.MiniToast;

class RaffleJsPlugin$11
  implements Runnable
{
  RaffleJsPlugin$11(RaffleJsPlugin paramRaffleJsPlugin, Context paramContext) {}
  
  public void run()
  {
    if (RaffleJsPlugin.access$000(this.this$0) != null) {
      RaffleJsPlugin.access$000(this.this$0).dismiss();
    }
    String str = this.a.getResources().getString(R.string.mini_sdk_game_raffle_fail_watch_ad_success);
    MiniToast.makeText(this.a, 2, str, 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.RaffleJsPlugin.11
 * JD-Core Version:    0.7.0.1
 */