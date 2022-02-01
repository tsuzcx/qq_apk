package com.tencent.qqmini.miniapp.core.page;

import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.widget.ToastView;

class AppBrandPageContainer$6$1
  implements Runnable
{
  AppBrandPageContainer$6$1(AppBrandPageContainer.6 param6, int paramInt, ApkgInfo paramApkgInfo, String paramString) {}
  
  public void run()
  {
    if (this.this$1.val$loadingView != null) {}
    try
    {
      this.this$1.val$loadingView.hide();
      if (this.val$resCode == 0)
      {
        AppBrandPageContainer.access$300(this.this$1.this$0, this.val$apkgInfo, this.this$1.val$path, this.this$1.val$pageWeakRef, this.this$1.val$openType);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QMLog.e("minisdk-start-AppBrandPageContainer", "", localThrowable);
      }
      QMLog.e("minisdk-start-AppBrandPageContainer", "executeDownSubPackage failed." + this.val$message);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.AppBrandPageContainer.6.1
 * JD-Core Version:    0.7.0.1
 */