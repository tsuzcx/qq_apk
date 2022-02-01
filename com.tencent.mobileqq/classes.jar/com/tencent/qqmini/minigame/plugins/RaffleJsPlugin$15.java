package com.tencent.qqmini.minigame.plugins;

import android.os.Handler;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;

class RaffleJsPlugin$15
  implements Runnable
{
  RaffleJsPlugin$15(RaffleJsPlugin paramRaffleJsPlugin) {}
  
  public void run()
  {
    ThreadManager.getUIHandler().removeCallbacks(this.this$0.showLoadingRunnable);
    RaffleJsPlugin localRaffleJsPlugin = this.this$0;
    RaffleJsPlugin.access$100(localRaffleJsPlugin, RaffleJsPlugin.access$3500(localRaffleJsPlugin));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.RaffleJsPlugin.15
 * JD-Core Version:    0.7.0.1
 */