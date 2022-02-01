package com.tencent.qqmini.minigame.manager;

import com.tencent.qqmini.minigame.action.OperatePendantAd;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

final class PendantDataManager$8
  implements Runnable
{
  PendantDataManager$8(IMiniAppContext paramIMiniAppContext) {}
  
  public void run()
  {
    QMLog.d("PendantDataManager", "消除挂件");
    OperatePendantAd.obtain(this.a).remove();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.manager.PendantDataManager.8
 * JD-Core Version:    0.7.0.1
 */