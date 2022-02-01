package com.tencent.qqmini.sdk.action;

import android.app.Activity;
import com.tencent.qqmini.sdk.MiniSDK;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
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
  
  private void finishActivity(Activity paramActivity)
  {
    if ((paramActivity != null) && (!paramActivity.isFinishing())) {
      paramActivity.finish();
    }
  }
  
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
    int i = 0;
    Object localObject = Boolean.valueOf(false);
    if (paramBaseRuntime == null) {
      return localObject;
    }
    MiniAppInfo localMiniAppInfo = paramBaseRuntime.getMiniAppInfo();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("restart ");
    localStringBuilder.append(localMiniAppInfo);
    QMLog.i("RestartAction", localStringBuilder.toString());
    if (localMiniAppInfo == null) {
      return localObject;
    }
    if (WnsConfig.getConfig("qqtriton", "mini_game_capsule_restart_free_cache", 0) == 1) {
      i = 1;
    }
    localObject = paramBaseRuntime.getAttachedActivity();
    if ((paramBaseRuntime.isMiniGame()) && (i != 0))
    {
      QMLog.i("RestartAction", "restartAction clearGameCache");
      paramBaseRuntime.setRuntimeLifecycleListener(new RestartAction.1(this));
      finishActivity((Activity)localObject);
    }
    else
    {
      if (paramBaseRuntime.isMiniGame()) {
        finishActivity((Activity)localObject);
      }
      localMiniAppInfo.launchParam.forceReload = 3;
      MiniSDK.startMiniApp((Activity)localObject, localMiniAppInfo, null, null);
    }
    return Boolean.valueOf(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.action.RestartAction
 * JD-Core Version:    0.7.0.1
 */