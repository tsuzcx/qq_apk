package com.tencent.mobileqq.guild.live.fragment.audience.module.chatbar;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.live.livemanager.audience.QQGuildLiveAudienceRoomMgr;
import com.tencent.mobileqq.qqgift.api.IQQGiftSDK;
import com.tencent.mobileqq.qqgift.api.service.IQQGiftRechargeModule;
import com.tencent.mobileqq.qqgift.data.service.GiftServiceData;
import com.tencent.mobileqq.qqgift.mvvm.business.view.IQQGiftPanelView;
import com.tencent.mobileqq.qqgift.mvvm.business.view.IQQGiftPanelView.OnPanelEventListener;

class QQGuildChatBarLiveFragment$4
  implements IQQGiftPanelView.OnPanelEventListener
{
  QQGuildChatBarLiveFragment$4(QQGuildChatBarLiveFragment paramQQGuildChatBarLiveFragment, IQQGiftPanelView paramIQQGiftPanelView) {}
  
  public boolean a()
  {
    QQGuildChatBarLiveFragment.f(this.b).f().a(QQGuildChatBarLiveFragment.e(this.b));
    return false;
  }
  
  public boolean a(GiftServiceData paramGiftServiceData, int paramInt)
  {
    return false;
  }
  
  public boolean a(boolean paramBoolean, GiftServiceData paramGiftServiceData, int paramInt)
  {
    if ((paramBoolean) && (paramGiftServiceData != null))
    {
      long l = QQGuildLiveAudienceRoomMgr.a().d();
      QQGuildChatBarLiveFragment.a(this.b, paramGiftServiceData.a, paramGiftServiceData.b, paramGiftServiceData.g, paramGiftServiceData.e, 1, l, paramGiftServiceData.d);
      ThreadManagerV2.getUIHandlerV2().post(new QQGuildChatBarLiveFragment.4.1(this));
    }
    return false;
  }
  
  public boolean b()
  {
    QQGuildChatBarLiveFragment.f(this.b).f().a();
    return false;
  }
  
  public boolean b(GiftServiceData paramGiftServiceData, int paramInt)
  {
    return false;
  }
  
  public boolean c()
  {
    return false;
  }
  
  public boolean c(GiftServiceData paramGiftServiceData, int paramInt)
  {
    return QQGuildChatBarLiveFragment.a(this.b, paramGiftServiceData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.fragment.audience.module.chatbar.QQGuildChatBarLiveFragment.4
 * JD-Core Version:    0.7.0.1
 */