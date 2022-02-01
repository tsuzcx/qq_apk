package com.tencent.mobileqq.chat;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class NotificationBannerManager$1
  implements View.OnClickListener
{
  NotificationBannerManager$1(NotificationBannerManager paramNotificationBannerManager, BannerManager paramBannerManager) {}
  
  public void onClick(View paramView)
  {
    this.b.a(this.a);
    this.b.a();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.chat.NotificationBannerManager.1
 * JD-Core Version:    0.7.0.1
 */