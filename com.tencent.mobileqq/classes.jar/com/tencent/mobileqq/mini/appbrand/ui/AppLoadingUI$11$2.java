package com.tencent.mobileqq.mini.appbrand.ui;

import com.tencent.mobileqq.mini.app.AppLoaderFactory;
import com.tencent.mobileqq.mini.app.BaseAppLoaderManager;

class AppLoadingUI$11$2
  implements Runnable
{
  AppLoadingUI$11$2(AppLoadingUI.11 param11) {}
  
  public void run()
  {
    AppLoaderFactory.getAppLoaderManager().onBaselibUpdated(this.this$1.this$0.getActivity(), AppLoadingUI.access$000(this.this$1.this$0));
    AppLoaderFactory.getAppLoaderManager().loadApkgByConfig(AppLoadingUI.access$000(this.this$1.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.AppLoadingUI.11.2
 * JD-Core Version:    0.7.0.1
 */