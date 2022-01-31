package com.tencent.mobileqq.mini.activity;

import com.tencent.mobileqq.mini.app.AppLoaderFactory;
import com.tencent.mobileqq.mini.app.BaseAppLoaderManager;

class LoadingFragment$4
  implements Runnable
{
  LoadingFragment$4(LoadingFragment paramLoadingFragment) {}
  
  public void run()
  {
    AppLoaderFactory.getAppLoaderManager().onBaselibUpdated(this.this$0.getActivity(), null);
    AppLoaderFactory.getAppLoaderManager().loadApkgByConfig(LoadingFragment.access$000(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.activity.LoadingFragment.4
 * JD-Core Version:    0.7.0.1
 */