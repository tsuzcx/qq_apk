package com.tencent.qqmini.minigame.manager;

import android.app.Activity;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;

final class PendantDataManager$1
  implements Runnable
{
  PendantDataManager$1(Activity paramActivity, IMiniAppContext paramIMiniAppContext, String paramString, int paramInt) {}
  
  public void run()
  {
    PendantDataManager.access$000(this.val$mActivity, this.val$gameRuntime, this.val$appId, this.val$scene);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.manager.PendantDataManager.1
 * JD-Core Version:    0.7.0.1
 */