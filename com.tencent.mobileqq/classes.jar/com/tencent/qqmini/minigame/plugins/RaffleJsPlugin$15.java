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
    RaffleJsPlugin.access$100(this.this$0, RaffleJsPlugin.access$3500(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.RaffleJsPlugin.15
 * JD-Core Version:    0.7.0.1
 */