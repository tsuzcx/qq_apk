package com.tencent.qqmini.miniapp.core.service;

import android.content.Context;
import android.os.Handler;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.smtt.sdk.QbSdk.PreInitCallback;

class AppBrandService$1
  implements QbSdk.PreInitCallback
{
  AppBrandService$1(AppBrandService paramAppBrandService, Context paramContext) {}
  
  public void onCoreInitFinished()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCoreInitFinished in thread --> ");
    localStringBuilder.append(this.this$0.threadName);
    QMLog.e("AppBrandService", localStringBuilder.toString());
    AppBrandService.access$002(true);
    AppBrandService.mThreadHandler.post(new AppBrandService.1.1(this));
  }
  
  public void onViewInitFinished(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onViewInitFinished isX5Core:");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" in thread --> ");
    localStringBuilder.append(this.this$0.threadName);
    QMLog.e("AppBrandService", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.service.AppBrandService.1
 * JD-Core Version:    0.7.0.1
 */