package com.tencent.qqmini.minigame.plugins;

import com.tencent.qqmini.sdk.launcher.log.QMLog;

class BlockAdPlugin$4
  implements Runnable
{
  BlockAdPlugin$4(BlockAdPlugin paramBlockAdPlugin, int paramInt) {}
  
  public void run()
  {
    boolean bool = this.this$0.hideBlockAd(this.val$compId);
    if (QMLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("hideBlockAd ");
      localStringBuilder.append(bool);
      QMLog.i("BlockAdPlugin", localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.BlockAdPlugin.4
 * JD-Core Version:    0.7.0.1
 */