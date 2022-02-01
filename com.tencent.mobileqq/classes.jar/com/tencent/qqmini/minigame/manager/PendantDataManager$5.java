package com.tencent.qqmini.minigame.manager;

import android.app.Activity;
import android.content.Context;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.PendantAdInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;

final class PendantDataManager$5
  implements Runnable
{
  PendantDataManager$5(PendantAdInfo paramPendantAdInfo, MiniAppProxy paramMiniAppProxy, Context paramContext, IMiniAppContext paramIMiniAppContext) {}
  
  public void run()
  {
    if (this.val$finalPendantAdInfo.isSchema())
    {
      str = this.val$finalPendantAdInfo.getJumpUrl();
      this.val$proxy.openSchema(this.val$context, str, 1037, null);
      return;
    }
    String str = this.val$finalPendantAdInfo.getJumpUrl();
    PendantDataManager.reportExposure("3");
    PendantManager.startRedPacketBrowserActivity((Activity)this.val$context, str, null, this.val$finalPendantAdInfo, this.val$iMiniAppContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.manager.PendantDataManager.5
 * JD-Core Version:    0.7.0.1
 */