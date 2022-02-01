package com.tencent.qqmini.minigame.plugins;

import android.os.Bundle;
import com.tencent.qqmini.minigame.model.BlockAdInfo;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;

class BlockAdPlugin$1
  implements Runnable
{
  BlockAdPlugin$1(BlockAdPlugin paramBlockAdPlugin, BlockAdInfo paramBlockAdInfo, String paramString, RequestEvent paramRequestEvent, Bundle paramBundle) {}
  
  public void run()
  {
    BlockAdPlugin.access$000(this.this$0, this.val$adInfo, this.val$appid, this.val$req, this.val$ext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.BlockAdPlugin.1
 * JD-Core Version:    0.7.0.1
 */