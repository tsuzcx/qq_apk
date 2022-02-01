package com.tencent.qqmini.sdk.action;

import android.content.Context;
import com.tencent.qqmini.sdk.cache.MiniCacheFreeManager;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.core.IRuntimeLifecycleListener;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.manager.LoginManager;

class RestartAction$1
  implements IRuntimeLifecycleListener
{
  RestartAction$1(RestartAction paramRestartAction) {}
  
  public void onDestroy(Context paramContext, MiniAppInfo paramMiniAppInfo)
  {
    int i;
    if (paramMiniAppInfo.engineType == 1) {
      i = 1;
    } else {
      i = 0;
    }
    if ((i != 0) && ((i == 0) || (WnsConfig.getConfig("qqtriton", "mini_game_capsule_restart_free_cache", 0) != 1)))
    {
      QMLog.i("RestartAction", "miniGame restartAction does not freeCache.");
      return;
    }
    MiniCacheFreeManager.freeCache(LoginManager.getInstance().getAccount(), paramMiniAppInfo, false, new RestartAction.1.1(this, paramMiniAppInfo));
    QMLog.i("RestartAction", "restartAction freeCache");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.action.RestartAction.1
 * JD-Core Version:    0.7.0.1
 */