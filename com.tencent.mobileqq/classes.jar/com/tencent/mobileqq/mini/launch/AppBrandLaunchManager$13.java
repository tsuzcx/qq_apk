package com.tencent.mobileqq.mini.launch;

import android.util.LruCache;
import com.tencent.qphone.base.util.QLog;

class AppBrandLaunchManager$13
  implements Runnable
{
  AppBrandLaunchManager$13(AppBrandLaunchManager paramAppBrandLaunchManager, String paramString1, String paramString2) {}
  
  public void run()
  {
    AppBrandLaunchManager.MiniAppSubProcessorInfo localMiniAppSubProcessorInfo = (AppBrandLaunchManager.MiniAppSubProcessorInfo)AppBrandLaunchManager.access$600(this.this$0).get(this.val$processName);
    if (localMiniAppSubProcessorInfo != null)
    {
      QLog.i("miniapp-process_AppBrandLaunchManager", 1, "set preloadGameBaseLibVersion:" + this.val$gameBaseLibVersion + " to " + localMiniAppSubProcessorInfo);
      localMiniAppSubProcessorInfo.preloadGameBaseLibVersion = this.val$gameBaseLibVersion;
      AppBrandLaunchManager.access$600(this.this$0).put(this.val$processName, localMiniAppSubProcessorInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.launch.AppBrandLaunchManager.13
 * JD-Core Version:    0.7.0.1
 */