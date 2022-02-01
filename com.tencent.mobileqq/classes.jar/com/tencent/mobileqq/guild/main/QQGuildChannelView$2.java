package com.tencent.mobileqq.guild.main;

import android.text.TextUtils;
import com.tencent.mobileqq.guild.handler.QQGuildObserver;
import com.tencent.mobileqq.guild.mainframe.GuildMainFrameConstants;
import com.tencent.mobileqq.guild.mainframe.GuildMainViewContext;
import com.tencent.mobileqq.guild.mainframe.attachcontainer.ChannelData;
import com.tencent.mobileqq.guild.mainframe.attachcontainer.GuildAttachContainerController;
import com.tencent.mobileqq.guild.mainframe.container.facade.FacadeArgsData;
import com.tencent.mobileqq.guild.mainframe.helper.ChannelSelectHelper;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.qphone.base.util.QLog;

class QQGuildChannelView$2
  extends QQGuildObserver
{
  QQGuildChannelView$2(QQGuildChannelView paramQQGuildChannelView) {}
  
  public void a(ChannelData paramChannelData)
  {
    if (paramChannelData == null) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onCloseAppChannel ");
    ((StringBuilder)localObject).append(paramChannelData.a());
    QLog.d("QQGuildChannelView", 1, ((StringBuilder)localObject).toString());
    localObject = (ChannelSelectHelper)QQGuildChannelView.d(this.a).a(GuildMainFrameConstants.f);
    if (TextUtils.equals(((ChannelSelectHelper)localObject).a(QQGuildChannelView.b(this.a).b), paramChannelData.a()))
    {
      ((ChannelSelectHelper)localObject).a(QQGuildChannelView.b(this.a).b, null);
      QQGuildChannelView.f(this.a);
    }
  }
  
  public void a(IGProChannelInfo paramIGProChannelInfo)
  {
    QLog.d("QQGuildChannelView", 1, "onGuildLiveChannelInfoUpdate: ");
    this.a.c();
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdateSelectedChannel ");
      localStringBuilder.append(paramString);
      QLog.d("QQGuildChannelView", 1, localStringBuilder.toString());
    }
    QQGuildChannelView.e(this.a).b(paramString);
    QQGuildChannelView.e(this.a).notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean, IGProChannelInfo paramIGProChannelInfo)
  {
    if (paramIGProChannelInfo != null)
    {
      if (QQGuildChannelView.b(this.a) == null) {
        return;
      }
      if (!TextUtils.equals(paramIGProChannelInfo.getGuildId(), QQGuildChannelView.b(this.a).b)) {
        return;
      }
      QQGuildChannelView.a(this.a, paramIGProChannelInfo.getChannelUin());
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onChannelDelete ");
        localStringBuilder.append(QQGuildChannelView.c(this.a));
        QLog.d("QQGuildChannelView", 1, localStringBuilder.toString());
      }
      if ((TextUtils.equals(((ChannelSelectHelper)QQGuildChannelView.d(this.a).a(GuildMainFrameConstants.f)).a(paramIGProChannelInfo.getGuildId()), paramIGProChannelInfo.getChannelUin())) && (QQGuildChannelView.d(this.a).e().i()))
      {
        if (QLog.isColorLevel()) {
          QLog.i("QQGuildObserver", 1, "delete current sel channel, close aio.");
        }
        QQGuildChannelView.d(this.a).e().d(true);
      }
      this.a.c();
    }
  }
  
  public void a(boolean paramBoolean, IGProChannelInfo paramIGProChannelInfo, String paramString)
  {
    if ((paramBoolean) && (paramIGProChannelInfo != null) && (QQGuildChannelView.a(this.a) != null) && (TextUtils.equals(paramIGProChannelInfo.getGuildId(), QQGuildChannelView.a(this.a).getGuildID())))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QQGuildObserver", 1, "channel create success, refresh channel list");
      }
      this.a.c();
      AppTroopItemShowManager.a().b();
      this.a.b(true);
    }
  }
  
  public void b(boolean paramBoolean, IGProChannelInfo paramIGProChannelInfo)
  {
    if (paramIGProChannelInfo != null)
    {
      if (QQGuildChannelView.b(this.a) == null) {
        return;
      }
      if (!TextUtils.equals(paramIGProChannelInfo.getGuildId(), QQGuildChannelView.b(this.a).b)) {
        return;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onChannelUpdate ");
        localStringBuilder.append(paramIGProChannelInfo);
        QLog.d("QQGuildChannelView", 1, localStringBuilder.toString());
      }
      this.a.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.main.QQGuildChannelView.2
 * JD-Core Version:    0.7.0.1
 */