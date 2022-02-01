package com.tencent.mobileqq.mini.launch;

import android.content.Context;
import android.content.Intent;
import bkyr;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.app.PreCacheManager.OnCacheListener;
import com.tencent.qphone.base.util.QLog;

class AppBrandLaunchManager$4
  implements PreCacheManager.OnCacheListener
{
  AppBrandLaunchManager$4(AppBrandLaunchManager paramAppBrandLaunchManager, MiniAppConfig paramMiniAppConfig) {}
  
  public void onCacheUpdated(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2)) {
      try
      {
        if (bkyr.a(this.val$miniAppConfig.isEngineTypeMiniGame()))
        {
          MiniSdkLauncher.notifyPeriodicCacheUpdate(AppBrandLaunchManager.access$100(this.this$0), this.val$miniAppConfig);
          return;
        }
        AppBrandLaunchManager.MiniAppSubProcessorInfo localMiniAppSubProcessorInfo = AppBrandLaunchManager.access$400(this.this$0, this.val$miniAppConfig.config.appId);
        if ((localMiniAppSubProcessorInfo != null) && (localMiniAppSubProcessorInfo.appPreLoadClass != null))
        {
          QLog.i("miniapp-process_AppBrandLaunchManager", 1, "notify periodicCache update. " + localMiniAppSubProcessorInfo);
          Intent localIntent = new Intent();
          localIntent.setClass(AppBrandLaunchManager.access$100(this.this$0), localMiniAppSubProcessorInfo.appPreLoadClass);
          localIntent.setAction("mini_periodic_cache_update");
          localIntent.putExtra("CONFIG", this.val$miniAppConfig);
          AppBrandLaunchManager.access$100(this.this$0).sendBroadcast(localIntent);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("miniapp-process_AppBrandLaunchManager", 1, localThrowable, new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.launch.AppBrandLaunchManager.4
 * JD-Core Version:    0.7.0.1
 */