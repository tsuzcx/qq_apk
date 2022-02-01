package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.minigame.data.BlockAdInfo;
import com.tencent.mobileqq.minigame.ui.GameActivity;

class BlockAdPlugin$3
  implements Runnable
{
  BlockAdPlugin$3(BlockAdPlugin paramBlockAdPlugin, BlockAdInfo paramBlockAdInfo) {}
  
  public void run()
  {
    ((GameActivity)this.this$0.jsPluginEngine.activityContext).hideBlockAd(this.val$adInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BlockAdPlugin.3
 * JD-Core Version:    0.7.0.1
 */