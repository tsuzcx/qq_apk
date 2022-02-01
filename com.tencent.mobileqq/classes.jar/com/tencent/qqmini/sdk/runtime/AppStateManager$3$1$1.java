package com.tencent.qqmini.sdk.runtime;

import android.app.Activity;
import com.tencent.qqmini.sdk.MiniSDK;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

class AppStateManager$3$1$1
  implements Runnable
{
  AppStateManager$3$1$1(AppStateManager.3.1 param1) {}
  
  public void run()
  {
    Activity localActivity = AppStateManager.access$000(this.this$2.this$1.this$0).getRuntime().getAttachedActivity();
    this.this$2.this$1.val$miniAppInfo.launchParam.forceReload = 3;
    MiniSDK.startMiniApp(localActivity, this.this$2.this$1.val$miniAppInfo, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.AppStateManager.3.1.1
 * JD-Core Version:    0.7.0.1
 */