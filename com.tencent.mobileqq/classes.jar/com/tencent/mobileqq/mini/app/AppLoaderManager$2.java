package com.tencent.mobileqq.mini.app;

import android.content.Context;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntimeContainer;
import com.tencent.mobileqq.mini.appbrand.utils.WebviewPool;
import com.tencent.mobileqq.mini.tfs.mini.ServiceCreateAsyncTask;
import com.tencent.qphone.base.util.QLog;

class AppLoaderManager$2
  implements Runnable
{
  AppLoaderManager$2(AppLoaderManager paramAppLoaderManager, Context paramContext, MiniAppConfig paramMiniAppConfig) {}
  
  public void run()
  {
    QLog.d("miniapp-start", 1, "Task BaseLib重新加载 start");
    AppLoaderManager.access$002(this.this$0, false);
    if (AppBrandRuntimeContainer.g().getEmptyAppRuntime() != null) {
      AppBrandRuntimeContainer.g().getEmptyAppRuntime().webviewPool.recycleFirstWebView(this.val$context);
    }
    AppLoaderManager.access$100(this.this$0, this.this$0.baselibLoadTask);
    AppLoaderManager.access$200(this.this$0, this.this$0.serviceCreateTask);
    AppLoaderManager.access$300(this.this$0, this.this$0.jsPluginEngineTask);
    this.this$0.serviceCreateTask.setMiniAppConfig(this.val$miniAppConfig);
    this.this$0.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.app.AppLoaderManager.2
 * JD-Core Version:    0.7.0.1
 */