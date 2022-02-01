package com.tencent.qqmini.minigame.plugins;

import android.content.Context;

class RaffleJsPlugin$3
  implements RaffleJsPlugin.GetGameRaffleMaterialInterface
{
  RaffleJsPlugin$3(RaffleJsPlugin paramRaffleJsPlugin, Context paramContext) {}
  
  public void onFail()
  {
    this.this$0.hideLoading();
    RaffleJsPlugin.access$800(this.this$0, this.val$context);
    RaffleJsPlugin.access$600(this.this$0, 3);
  }
  
  public void onSuccess()
  {
    RaffleJsPlugin.access$700(this.this$0, this.val$context);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.RaffleJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */