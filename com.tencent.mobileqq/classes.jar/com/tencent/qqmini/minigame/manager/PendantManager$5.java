package com.tencent.qqmini.minigame.manager;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import com.tencent.qqmini.minigame.widget.DragImageView;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.model.PendantAdInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

final class PendantManager$5
  implements Runnable
{
  PendantManager$5(Activity paramActivity, PendantAdInfo paramPendantAdInfo, DragImageView paramDragImageView) {}
  
  public void run()
  {
    if ((PendantDataManager.entranceStrategy == 1) && (PendantDataManager.TIME_EXTENSION_ENABLE))
    {
      QMLog.d("PendantManager", "挂件五分钟倒计时闪烁");
      Drawable localDrawable = ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getDrawable(this.val$context, this.val$pendantAdInfo.getPendantUrl(), 0, 0, PendantManager.access$200());
      this.val$curDragImageView.setImageDrawable(localDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.manager.PendantManager.5
 * JD-Core Version:    0.7.0.1
 */