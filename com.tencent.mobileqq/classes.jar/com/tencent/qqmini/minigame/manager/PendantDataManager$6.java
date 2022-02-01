package com.tencent.qqmini.minigame.manager;

import com.tencent.qqmini.minigame.action.OperatePendantAd;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.PendantAdInfo;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

final class PendantDataManager$6
  implements Runnable
{
  PendantDataManager$6(IMiniAppContext paramIMiniAppContext, PendantAdInfo paramPendantAdInfo) {}
  
  public void run()
  {
    QMLog.d("PendantDataManager", "倒计时结束");
    OperatePendantAd.obtain(this.val$iMiniAppContext).show(this.val$finalPendantAdInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.manager.PendantDataManager.6
 * JD-Core Version:    0.7.0.1
 */