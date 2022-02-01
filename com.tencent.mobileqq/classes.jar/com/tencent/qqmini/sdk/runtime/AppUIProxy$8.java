package com.tencent.qqmini.sdk.runtime;

import android.app.Activity;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.manager.MiniLoadingAdManager;

class AppUIProxy$8
  implements Runnable
{
  AppUIProxy$8(AppUIProxy paramAppUIProxy, Activity paramActivity, MiniAppInfo paramMiniAppInfo, String paramString, long paramLong) {}
  
  public void run()
  {
    if ((this.this$0.mCurrRuntimeLoader != null) && (this.this$0.mCurrRuntimeLoader.mRuntime != null)) {
      this.this$0.mCurrRuntimeLoader.mRuntime.setLoadingAdStatus(2);
    }
    DisplayUtil.setSystemUIVisible(this.val$activity, false);
    MiniLoadingAdManager.getInstance().updateLoadingAdLayoutAndShow(this.val$miniAppInfo, this.val$activity, false, this.val$adJson, this.val$aid, new AppUIProxy.8.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.AppUIProxy.8
 * JD-Core Version:    0.7.0.1
 */