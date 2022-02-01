package com.tencent.mobileqq.guild.live.livemanager;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.event.QQGuildEventManager;
import com.tencent.mobileqq.guild.live.livemanager.repo.QQGuildLiveRoomUiData;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.ILiveChannelMemberInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class QQGuildLiveEventHelper$3
  extends GPServiceObserver
{
  QQGuildLiveEventHelper$3(QQGuildLiveEventHelper paramQQGuildLiveEventHelper) {}
  
  protected void a(IGProGuildInfo paramIGProGuildInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onAddGuildWithInfo info=");
    localStringBuilder.append(paramIGProGuildInfo);
    QLog.i("QGL.QQGuildLiveEventHelper", 1, localStringBuilder.toString());
    QQGuildLiveEventHelper.c(this.a);
    QQGuildLiveEventHelper.f(this.a);
  }
  
  protected void a(String paramString)
  {
    if (TextUtils.equals(paramString, QQGuildLiveEventHelper.g(this.a))) {
      QQGuildLiveEventHelper.c(this.a);
    }
  }
  
  protected void a(String paramString, int paramInt)
  {
    if (TextUtils.equals(paramString, QQGuildLiveEventHelper.g(this.a)))
    {
      QLog.i("QGL.QQGuildLiveEventHelper", 1, "onBeKickFromGuild.");
      QQGuildLiveEventHelper.a(this.a, null);
    }
  }
  
  protected void a(String paramString1, String paramString2, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onLiveChannelAnchorIdentityChange guildId=");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" channelId=");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(" action=");
    localStringBuilder.append(paramInt);
    QLog.i("QGL.QQGuildLiveEventHelper", 1, localStringBuilder.toString());
    QQGuildLiveEventHelper.a(this.a, paramString1, paramString2, paramInt);
  }
  
  protected void a(String paramString1, String paramString2, int paramInt1, int paramInt2) {}
  
  protected void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt)
  {
    paramString4 = new StringBuilder();
    paramString4.append("onLiveRoomStatusChange guildId=");
    paramString4.append(paramString1);
    paramString4.append(" channelId=");
    paramString4.append(paramString2);
    paramString4.append(" roomId=");
    paramString4.append(paramString3);
    paramString4.append(" anchorTinyId=");
    paramString4.append(paramString5);
    paramString4.append(" action=");
    paramString4.append(paramInt);
    QLog.i("QGL.QQGuildLiveEventHelper", 1, paramString4.toString());
    QQGuildLiveEventHelper.a(this.a, paramString1, paramString2, paramString3, paramString5, paramInt);
  }
  
  protected void a(String paramString1, String paramString2, List<ILiveChannelMemberInfo> paramList, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onLiveRoomUserChange guildId=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" channelId=");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" action=");
      localStringBuilder.append(paramInt);
      QLog.i("QGL.QQGuildLiveEventHelper", 1, localStringBuilder.toString());
    }
    QQGuildLiveEventHelper.a(this.a, paramString1, paramString2, paramList, paramInt);
  }
  
  protected void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((QQGuildLiveEventHelper.b(this.a, paramString1)) && (QQGuildLiveEventHelper.c(this.a, paramString2)))
    {
      QQGuildLiveRoomUiData.a().b(paramBoolean);
      QQGuildLiveEventHelper.c(this.a);
      QQGuildLiveEventHelper.d(this.a);
      QQGuildLiveEventHelper.e(this.a);
    }
  }
  
  protected void a(String paramString, List<String> paramList)
  {
    if (TextUtils.equals(paramString, QQGuildLiveEventHelper.g(this.a)))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        paramString = (String)paramList.next();
        if (TextUtils.equals(paramString, QQGuildLiveEventHelper.h(this.a)))
        {
          QLog.i("QGL.QQGuildLiveEventHelper", 1, "onPushChannelDestroy.");
          if (!QQGuildEventManager.a.a(QQGuildLiveEventHelper.g(this.a), paramString, 1)) {
            paramString = HardCodeUtil.a(2131890421);
          } else {
            paramString = "";
          }
          QQGuildLiveEventHelper.a(this.a, paramString);
        }
      }
    }
  }
  
  protected void c(String paramString)
  {
    if (TextUtils.equals(paramString, QQGuildLiveEventHelper.g(this.a)))
    {
      QLog.i("QGL.QQGuildLiveEventHelper", 1, "onRemoveGuild.");
      if (QQGuildLiveRoomUiData.a().b().getValue() == Boolean.TRUE) {
        QQGuildLiveEventHelper.a(this.a, HardCodeUtil.a(2131890421));
      }
    }
  }
  
  protected void d(String paramString)
  {
    if (TextUtils.equals(paramString, QQGuildLiveEventHelper.g(this.a)))
    {
      QLog.i("QGL.QQGuildLiveEventHelper", 1, "onDestoryGuild.");
      QQGuildLiveEventHelper.a(this.a, HardCodeUtil.a(2131890421));
    }
  }
  
  protected void e(String paramString)
  {
    if (TextUtils.equals(paramString, QQGuildLiveEventHelper.h(this.a))) {
      QQGuildLiveEventHelper.i(this.a);
    }
  }
  
  protected void g(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onAddGuildNotInfo guildId=");
    localStringBuilder.append(paramString);
    QLog.i("QGL.QQGuildLiveEventHelper", 1, localStringBuilder.toString());
    QQGuildLiveEventHelper.c(this.a);
    QQGuildLiveEventHelper.f(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.livemanager.QQGuildLiveEventHelper.3
 * JD-Core Version:    0.7.0.1
 */