package com.tencent.mobileqq.qqgift.webview;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.qqgift.api.IQQGiftManager;
import com.tencent.mobileqq.qqgift.api.IQQGiftSDK;
import com.tencent.mobileqq.qqgift.api.service.IQQGiftRechargeModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QQGiftHalfTranslucentBrowserActivity$1
  implements View.OnClickListener
{
  QQGiftHalfTranslucentBrowserActivity$1(QQGiftHalfTranslucentBrowserActivity paramQQGiftHalfTranslucentBrowserActivity) {}
  
  public void onClick(View paramView)
  {
    ((IQQGiftManager)QRoute.api(IQQGiftManager.class)).getSDKImpl(QQGiftHalfTranslucentBrowserActivity.a(this.a)).f().a(QQGiftHalfTranslucentBrowserActivity.b(this.a), false, 9999, "用户手动取消");
    QQGiftHalfTranslucentBrowserActivity.c(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.webview.QQGiftHalfTranslucentBrowserActivity.1
 * JD-Core Version:    0.7.0.1
 */