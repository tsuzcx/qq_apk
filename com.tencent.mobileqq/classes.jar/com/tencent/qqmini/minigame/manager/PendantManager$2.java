package com.tencent.qqmini.minigame.manager;

import android.graphics.drawable.Drawable;
import com.tencent.qqmini.minigame.widget.DragImageView;
import com.tencent.qqmini.sdk.launcher.core.model.PendantAdInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;

class PendantManager$2
  implements Runnable
{
  PendantManager$2(PendantManager paramPendantManager, MiniAppProxy paramMiniAppProxy, PendantAdInfo paramPendantAdInfo) {}
  
  public void run()
  {
    Drawable localDrawable = this.val$proxy.getDrawable(PendantManager.access$100(this.this$0), this.val$pendantAdInfo.getStaticPendantUrl(), 0, 0, PendantManager.access$200());
    PendantManager.access$300(this.this$0).setImageDrawable(localDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.manager.PendantManager.2
 * JD-Core Version:    0.7.0.1
 */