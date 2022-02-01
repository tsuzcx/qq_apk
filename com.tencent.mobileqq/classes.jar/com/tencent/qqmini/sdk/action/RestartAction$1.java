package com.tencent.qqmini.sdk.action;

import android.content.Context;
import com.tencent.qqmini.sdk.cache.MiniCacheFreeManager;
import com.tencent.qqmini.sdk.launcher.core.IRuntimeLifecycleListener;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.manager.LoginManager;

class RestartAction$1
  implements IRuntimeLifecycleListener
{
  RestartAction$1(RestartAction paramRestartAction) {}
  
  public void onDestroy(Context paramContext, MiniAppInfo paramMiniAppInfo)
  {
    MiniCacheFreeManager.freeCache(LoginManager.getInstance().getAccount(), paramMiniAppInfo, false, new RestartAction.1.1(this, paramMiniAppInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.action.RestartAction.1
 * JD-Core Version:    0.7.0.1
 */