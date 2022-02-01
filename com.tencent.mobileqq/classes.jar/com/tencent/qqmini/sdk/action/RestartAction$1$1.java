package com.tencent.qqmini.sdk.action;

import com.tencent.qqmini.sdk.MiniSDK;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

class RestartAction$1$1
  implements Runnable
{
  RestartAction$1$1(RestartAction.1 param1, MiniAppInfo paramMiniAppInfo) {}
  
  public void run()
  {
    MiniSDK.init(MiniAppEnv.g().getContext());
    this.val$miniAppInfo.launchParam.forceReload = 3;
    MiniSDK.startMiniApp(null, this.val$miniAppInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.action.RestartAction.1.1
 * JD-Core Version:    0.7.0.1
 */