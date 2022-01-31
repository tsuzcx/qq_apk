package com.tencent.qqmini.sdk.launcher;

import android.util.LruCache;
import bgpw;
import com.tencent.qqmini.sdk.log.QMLog;

class AppBrandLaunchManager$5
  implements Runnable
{
  AppBrandLaunchManager$5(AppBrandLaunchManager paramAppBrandLaunchManager, String paramString1, String paramString2) {}
  
  public void run()
  {
    bgpw localbgpw = (bgpw)AppBrandLaunchManager.access$100(this.this$0).get(this.a);
    if (localbgpw != null)
    {
      QMLog.i("minisdk-start_AppBrandLaunchManager", "set preload BaseLibVersion:" + this.b + " to " + localbgpw);
      localbgpw.c = this.b;
      AppBrandLaunchManager.access$100(this.this$0).put(this.a, localbgpw);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.AppBrandLaunchManager.5
 * JD-Core Version:    0.7.0.1
 */