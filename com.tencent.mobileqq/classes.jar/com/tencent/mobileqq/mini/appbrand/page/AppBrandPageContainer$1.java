package com.tencent.mobileqq.mini.appbrand.page;

import bbms;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.apkg.ApkgManager.OnInitApkgListener;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

class AppBrandPageContainer$1
  implements ApkgManager.OnInitApkgListener
{
  AppBrandPageContainer$1(AppBrandPageContainer paramAppBrandPageContainer, String paramString1, WeakReference paramWeakReference, String paramString2, bbms parambbms) {}
  
  public void onInitApkgInfo(int paramInt, ApkgInfo paramApkgInfo, String paramString)
  {
    if ((this.this$0.appBrandRuntime != null) && (this.this$0.appBrandRuntime.pageContainer != null)) {
      this.this$0.appBrandRuntime.pageContainer.reportPageViewShow("bring_to_front");
    }
    ThreadManager.getUIHandler().post(new AppBrandPageContainer.1.1(this, paramInt, paramApkgInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.AppBrandPageContainer.1
 * JD-Core Version:    0.7.0.1
 */