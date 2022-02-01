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
    if (this.this$1.val$loadingView != null) {
      try
      {
        this.this$1.val$loadingView.hide();
      }
      catch (Throwable localThrowable)
      {
        QMLog.e("minisdk-start-AppBrandPageContainer", "", localThrowable);
      }
    }
    int i = this.val$resCode;
    if (i == 0)
    {
      AppBrandPageContainer.access$300(this.this$1.this$0, this.val$apkgInfo, this.this$1.val$path, this.this$1.val$pageWeakRef, this.this$1.val$openType);
      return;
    }
    if (i == 5)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("executeDownSubPackage url is empty.");
      localStringBuilder.append(this.val$message);
      QMLog.e("minisdk-start-AppBrandPageContainer", localStringBuilder.toString());
      AppBrandPageContainer.access$300(this.this$1.this$0, this.val$apkgInfo, this.this$1.val$path, this.this$1.val$pageWeakRef, this.this$1.val$openType);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("executeDownSubPackage failed.");
    localStringBuilder.append(this.val$message);
    QMLog.e("minisdk-start-AppBrandPageContainer", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.AppBrandPageContainer.6.1
 * JD-Core Version:    0.7.0.1
 */