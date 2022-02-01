package com.tencent.qqmini.miniapp.core.page;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.AppConfigInfo;
import com.tencent.qqmini.sdk.widget.ToastView;
import java.lang.ref.WeakReference;

class AppBrandPageContainer$4$1
  implements Runnable
{
  AppBrandPageContainer$4$1(AppBrandPageContainer.4 param4, int paramInt, ApkgInfo paramApkgInfo, String paramString) {}
  
  public void run()
  {
    if (this.this$1.val$loadingView != null) {}
    for (;;)
    {
      try
      {
        this.this$1.val$loadingView.hide();
        if (this.val$resCode != 0) {
          break;
        }
        if ((this.val$apkgInfo != null) && (this.val$apkgInfo.isUrlFileExist(this.this$1.val$path)))
        {
          AppBrandPageContainer localAppBrandPageContainer = (AppBrandPageContainer)this.this$1.val$pageWeakRef.get();
          if (localAppBrandPageContainer != null)
          {
            if ("navigateTo".equals(this.this$1.val$openType)) {
              localAppBrandPageContainer.navigateTo(this.this$1.val$path, -1);
            }
          }
          else {
            return;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        QMLog.e("minisdk-start-AppBrandPageContainer", "", localThrowable);
        continue;
        if ("redirectTo".equals(this.this$1.val$openType))
        {
          localThrowable.redirectTo(this.this$1.val$path, -1);
          return;
        }
        if ("appLaunch".equals(this.this$1.val$openType))
        {
          localThrowable.launch(this.this$1.val$path, "appLaunch");
          return;
        }
        if (!"reLaunch".equals(this.this$1.val$openType)) {
          continue;
        }
        localThrowable.launch(this.this$1.val$path, "reLaunch");
        return;
      }
      AppBrandPageContainer.access$200(this.this$1.this$0, this.this$1.val$path);
      QMLog.e("minisdk-start-AppBrandPageContainer", "Page not found." + this.this$1.val$path);
      if ((this.val$apkgInfo != null) && (this.val$apkgInfo.mAppConfigInfo != null))
      {
        String str = this.val$apkgInfo.mAppConfigInfo.entryPagePath;
        if ((!TextUtils.isEmpty(str)) && (this.val$apkgInfo.isUrlFileExist(str)))
        {
          ((AppBrandPageContainer)this.this$1.val$pageWeakRef.get()).launch(str, "appLaunch");
          return;
        }
        if ((AppBrandPageContainer.access$000(this.this$1.this$0) != null) && (AppBrandPageContainer.access$000(this.this$1.this$0).getAttachedActivity() != null) && (!AppBrandPageContainer.access$000(this.this$1.this$0).getAttachedActivity().isFinishing()))
        {
          AppBrandPageContainer.access$000(this.this$1.this$0).getAttachedActivity().moveTaskToBack(false);
          return;
        }
      }
    }
    QMLog.e("minisdk-start-AppBrandPageContainer", "executeDownSubPackage failed." + this.val$message);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.AppBrandPageContainer.4.1
 * JD-Core Version:    0.7.0.1
 */