package com.tencent.qqmini.minigame.manager;

import android.content.Context;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

final class PendantDataManager$3
  implements Runnable
{
  PendantDataManager$3(Context paramContext, IMiniAppContext paramIMiniAppContext, String paramString, int paramInt) {}
  
  public void run()
  {
    QMLog.d("PendantDataManager", "倒计时结束");
    PendantDataManager.access$000(this.val$context, this.val$iMiniAppContext, this.val$appId, this.val$scene);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.manager.PendantDataManager.3
 * JD-Core Version:    0.7.0.1
 */