package com.tencent.mobileqq.mini.appbrand.ui;

import com.tencent.mobileqq.mini.app.AppLoaderFactory;
import com.tencent.mobileqq.mini.app.BaseAppLoaderManager;

class AppLoadingUI$9
  implements Runnable
{
  AppLoadingUI$9(AppLoadingUI paramAppLoadingUI) {}
  
  public void run()
  {
    AppLoaderFactory.getAppLoaderManager().onBaselibUpdated(this.this$0.getActivity(), null);
    AppLoaderFactory.getAppLoaderManager().loadApkgByConfig(AppLoadingUI.access$000(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.AppLoadingUI.9
 * JD-Core Version:    0.7.0.1
 */