package com.tencent.qqmini.minigame.manager;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import com.tencent.qqmini.minigame.widget.DragImageView;
import com.tencent.qqmini.sdk.launcher.core.model.PendantAdInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;

final class PendantManager$4
  implements Runnable
{
  PendantManager$4(MiniAppProxy paramMiniAppProxy, Activity paramActivity, PendantAdInfo paramPendantAdInfo, DragImageView paramDragImageView) {}
  
  public void run()
  {
    Drawable localDrawable = this.val$proxy.getDrawable(this.val$context, this.val$pendantAdInfo.getStaticPendantUrl(), 0, 0, PendantManager.access$200());
    this.val$curDragImageView.setImageDrawable(localDrawable);
    PendantManager.access$500(localDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.manager.PendantManager.4
 * JD-Core Version:    0.7.0.1
 */