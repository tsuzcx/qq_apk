package com.tencent.qqmini.minigame;

import android.content.Intent;
import com.tencent.qqmini.sdk.core.manager.ActivityResultManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener;

class GamePage$6
  implements IActivityResultListener
{
  GamePage$6(GamePage paramGamePage, PayProxy paramPayProxy) {}
  
  public boolean doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 3004)
    {
      if (GamePage.access$1600(this.b) != null)
      {
        paramIntent = this.a;
        if (paramIntent != null) {
          paramIntent.callJs("~function(d,e){try{e=d.createEvent('Event');e.initEvent('qbrowserVisibilityChange');e.hidden=false;d.dispatchEvent(e)}catch(err){}}(document);", GamePage.access$1600(this.b));
        }
      }
      ActivityResultManager.g().removeActivityResultListener(this);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.GamePage.6
 * JD-Core Version:    0.7.0.1
 */