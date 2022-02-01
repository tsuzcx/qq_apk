package com.tencent.mobileqq.guild.main;

import android.text.TextUtils;
import com.tencent.mobileqq.qqguildsdk.data.GuildUserAvatar;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class QQGuildChannelView$7
  extends GPServiceObserver
{
  QQGuildChannelView$7(QQGuildChannelView paramQQGuildChannelView) {}
  
  protected void a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (QQGuildChannelView.a(this.a) != null) && (paramString.equals(QQGuildChannelView.a(this.a).getGuildID())))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onGuildInfoUpdated=");
        localStringBuilder.append(paramString);
        QLog.d("QQGuildChannelView", 4, localStringBuilder.toString());
      }
      QQGuildChannelView.b(this.a, paramString);
    }
  }
  
  protected void a(String paramString, GuildUserAvatar paramGuildUserAvatar)
  {
    QQGuildChannelView.a(this.a, paramString, paramGuildUserAvatar);
  }
  
  protected void a(String paramString1, String paramString2)
  {
    QQGuildChannelView.a(this.a, paramString1, paramString2);
  }
  
  protected void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt)
  {
    QQGuildChannelView.a(this.a, paramString1, paramString2, paramInt);
  }
  
  protected void a(String paramString, List<String> paramList1, List<String> paramList2)
  {
    QQGuildChannelView.c(this.a, paramString);
  }
  
  protected void b(String paramString, List<String> paramList)
  {
    QQGuildChannelView.a(this.a, paramString, paramList);
  }
  
  protected void c(String paramString) {}
  
  protected void e(String paramString)
  {
    super.e(paramString);
    if (QQGuildChannelView.a(this.a) == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("#onChannelInfoUpdated mGuildInfo is null and channelUni is:");
      ((StringBuilder)localObject).append(paramString);
      QLog.w("QQGuildChannelView", 2, ((StringBuilder)localObject).toString());
      return;
    }
    Object localObject = this.a;
    QQGuildChannelView.b((QQGuildChannelView)localObject, QQGuildChannelView.a((QQGuildChannelView)localObject).getGuildID(), paramString);
  }
  
  protected void f(String paramString)
  {
    super.f(paramString);
    if ((!TextUtils.isEmpty(paramString)) && (QQGuildChannelView.a(this.a) != null) && (paramString.equals(QQGuildChannelView.a(this.a).getGuildID())))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onChannelListUpdated ");
        localStringBuilder.append(paramString);
        QLog.d("QQGuildChannelView", 1, localStringBuilder.toString());
      }
      this.a.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.main.QQGuildChannelView.7
 * JD-Core Version:    0.7.0.1
 */