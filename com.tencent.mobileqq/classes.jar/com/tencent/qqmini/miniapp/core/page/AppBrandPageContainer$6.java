package com.tencent.qqmini.miniapp.core.page;

import android.os.Handler;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.manager.ApkgManager.OnInitApkgListener;
import com.tencent.qqmini.sdk.widget.ToastView;
import java.lang.ref.WeakReference;

class AppBrandPageContainer$6
  implements ApkgManager.OnInitApkgListener
{
  AppBrandPageContainer$6(AppBrandPageContainer paramAppBrandPageContainer, ToastView paramToastView, String paramString1, WeakReference paramWeakReference, String paramString2) {}
  
  public void onInitApkgInfo(int paramInt, ApkgInfo paramApkgInfo, String paramString)
  {
    ThreadManager.getUIHandler().post(new AppBrandPageContainer.6.1(this, paramInt, paramApkgInfo, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.AppBrandPageContainer.6
 * JD-Core Version:    0.7.0.1
 */