package com.tencent.qqmini.minigame.manager;

import com.tencent.qqmini.minigame.action.OperatePendantAd;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

final class PendantDataManager$7
  implements Runnable
{
  PendantDataManager$7(IMiniAppContext paramIMiniAppContext) {}
  
  public void run()
  {
    if ((PendantDataManager.entranceStrategy == 1) && (PendantDataManager.TIME_EXTENSION_ENABLE))
    {
      QMLog.d("PendantDataManager", "还有五分钟挂件消失");
      return;
    }
    QMLog.d("PendantDataManager", "挂件超出投放时间，挂件消失");
    OperatePendantAd.obtain(this.a).remove();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.manager.PendantDataManager.7
 * JD-Core Version:    0.7.0.1
 */