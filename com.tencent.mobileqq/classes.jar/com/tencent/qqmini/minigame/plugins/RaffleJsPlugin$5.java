package com.tencent.qqmini.minigame.plugins;

import android.content.Context;

class RaffleJsPlugin$5
  implements RaffleJsPlugin.GetGameRaffleMaterialInterface
{
  RaffleJsPlugin$5(RaffleJsPlugin paramRaffleJsPlugin, Context paramContext, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onFail()
  {
    this.this$0.hideLoading();
    RaffleJsPlugin.access$1400(this.this$0, this.val$context);
    RaffleJsPlugin.access$600(this.this$0, 5);
  }
  
  public void onSuccess()
  {
    RaffleJsPlugin.access$1300(this.this$0, this.val$context, this.val$canShare, this.val$canWatchAd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.RaffleJsPlugin.5
 * JD-Core Version:    0.7.0.1
 */