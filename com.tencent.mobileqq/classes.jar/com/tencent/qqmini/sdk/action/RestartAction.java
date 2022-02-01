package com.tencent.qqmini.sdk.action;

import android.app.Activity;
import com.tencent.qqmini.sdk.MiniSDK;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.Action;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

@MiniKeep
public class RestartAction
  implements Action<Boolean>
{
  private static final String TAG = "RestartAction";
  
  public static RestartAction obtain()
  {
    return new RestartAction();
  }
  
  public static void restart(IMiniAppContext paramIMiniAppContext)
  {
    paramIMiniAppContext.performAction(new RestartAction());
  }
  
  public Boolean perform(BaseRuntime paramBaseRuntime)
  {
    if (paramBaseRuntime == null) {
      return Boolean.valueOf(false);
    }
    QMLog.i("RestartAction", "restart " + paramBaseRuntime.getMiniAppInfo());
    paramBaseRuntime.setRuntimeLifecycleListener(new RestartAction.1(this));
    if (paramBaseRuntime.isMiniGame()) {
      if (paramBaseRuntime.getMiniAppInfo() != null)
      {
        paramBaseRuntime = paramBaseRuntime.getAttachedActivity();
        if ((paramBaseRuntime != null) && (!paramBaseRuntime.isFinishing())) {
          paramBaseRuntime.finish();
        }
      }
    }
    for (;;)
    {
      return Boolean.valueOf(true);
      MiniAppInfo localMiniAppInfo = paramBaseRuntime.getMiniAppInfo();
      if (localMiniAppInfo != null)
      {
        paramBaseRuntime = paramBaseRuntime.getAttachedActivity();
        localMiniAppInfo.forceReroad = 3;
        MiniSDK.startMiniApp(paramBaseRuntime, localMiniAppInfo, null, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.action.RestartAction
 * JD-Core Version:    0.7.0.1
 */