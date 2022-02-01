package com.tencent.qqmini.sdk.manager;

import com.tencent.qqmini.sdk.MiniSDK;
import com.tencent.qqmini.sdk.core.manager.PreCacheManager.OnCacheListener;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

class CommonManager$1
  implements PreCacheManager.OnCacheListener
{
  CommonManager$1(CommonManager paramCommonManager, MiniAppInfo paramMiniAppInfo) {}
  
  public void onCacheUpdated(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2)) {
      try
      {
        MiniSDK.notifyPeriodicCacheUpdate(AppLoaderFactory.g().getContext(), this.val$miniAppConfig);
        return;
      }
      catch (Throwable localThrowable)
      {
        QMLog.e("CommonManager", "", localThrowable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.CommonManager.1
 * JD-Core Version:    0.7.0.1
 */