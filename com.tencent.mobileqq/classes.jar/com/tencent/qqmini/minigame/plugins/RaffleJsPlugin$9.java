package com.tencent.qqmini.minigame.plugins;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.qqmini.minigame.R.string;
import com.tencent.qqmini.minigame.R.style;
import com.tencent.qqmini.sdk.core.utils.DialogUtil;
import com.tencent.qqmini.sdk.core.widget.AppCloseDialog;

class RaffleJsPlugin$9
  implements Runnable
{
  RaffleJsPlugin$9(RaffleJsPlugin paramRaffleJsPlugin, Context paramContext) {}
  
  public void run()
  {
    DialogUtil.createCloseAlertDialog(this.val$context, R.style.mini_sdk_QQProgressDialog, this.val$context.getResources().getString(R.string.mini_sdk_game_raffle_success_image_load_fail), "", this.val$context.getResources().getString(R.string.mini_sdk_game_raffle_know), 100.0F, false, false, true, null, new RaffleJsPlugin.9.1(this)).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.RaffleJsPlugin.9
 * JD-Core Version:    0.7.0.1
 */