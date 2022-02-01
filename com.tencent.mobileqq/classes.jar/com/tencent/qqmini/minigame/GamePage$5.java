package com.tencent.qqmini.minigame;

import android.content.Intent;
import com.tencent.qqmini.sdk.core.manager.ActivityResultManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener;

class GamePage$5
  implements IActivityResultListener
{
  GamePage$5(GamePage paramGamePage, PayProxy paramPayProxy) {}
  
  public boolean doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 3004)
    {
      if (GamePage.access$1200(this.this$0) != null)
      {
        paramIntent = this.val$payProxy;
        if (paramIntent != null) {
          paramIntent.callJs("~function(d,e){try{e=d.createEvent('Event');e.initEvent('qbrowserVisibilityChange');e.hidden=false;d.dispatchEvent(e)}catch(err){}}(document);", GamePage.access$1200(this.this$0));
        }
      }
      ActivityResultManager.g().removeActivityResultListener(this);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.GamePage.5
 * JD-Core Version:    0.7.0.1
 */