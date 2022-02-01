package com.tencent.qqmini.miniapp.core;

import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

class BaseAppBrandRuntime$1
  implements Runnable
{
  BaseAppBrandRuntime$1(BaseAppBrandRuntime paramBaseAppBrandRuntime, MiniAppInfo paramMiniAppInfo, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    this.this$0.launchPage(this.val$miniAppInfo, this.val$fromReload, this.val$reloadPath);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.BaseAppBrandRuntime.1
 * JD-Core Version:    0.7.0.1
 */