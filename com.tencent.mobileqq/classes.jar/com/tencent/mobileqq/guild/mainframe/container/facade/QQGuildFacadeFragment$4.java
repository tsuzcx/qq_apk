package com.tencent.mobileqq.guild.mainframe.container.facade;

import com.tencent.mobileqq.guild.api.IGuildAdapterService;
import com.tencent.mobileqq.guild.mainframe.GuildMainViewContext;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchGuildInfoCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

class QQGuildFacadeFragment$4
  implements IFetchGuildInfoCallback
{
  QQGuildFacadeFragment$4(QQGuildFacadeFragment paramQQGuildFacadeFragment) {}
  
  public void a(int paramInt, String paramString, IGProGuildInfo paramIGProGuildInfo)
  {
    if ((paramInt == 0) && (paramIGProGuildInfo != null) && (paramIGProGuildInfo.getGuildID().equals(QQGuildFacadeFragment.a(this.a).b)))
    {
      ((IGuildAdapterService)QQGuildFacadeFragment.f(this.a).a().getRuntimeService(IGuildAdapterService.class, "")).setVisitorGuildCardInfo(paramIGProGuildInfo.getGuildID(), paramIGProGuildInfo, null);
      QQGuildFacadeFragment.a(this.a, paramIGProGuildInfo.getGuildID(), paramIGProGuildInfo.getAvatarUrl(100), paramIGProGuildInfo.getGuildName());
      paramString = new StringBuilder();
      paramString.append("fetchGuildInfoForGuest, 网络回包");
      paramString.append(paramIGProGuildInfo);
      QLog.i("GuildDiscover", 2, paramString.toString());
      QQGuildFacadeFragment.a(this.a, false, false);
    }
    else
    {
      paramString = new StringBuilder();
      paramString.append("fetchGuildInfoForGuest error! result = ");
      paramString.append(paramInt);
      paramString.append(" guildId = ");
      paramString.append(QQGuildFacadeFragment.a(this.a).b);
      QLog.e("QQGuildFacadeFragment", 1, paramString.toString());
    }
    QLog.i("GuildDiscover", 2, "fetchGuildInfoForGuest -> setMaskGone, 网络回包");
    QQGuildFacadeFragment.d(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.container.facade.QQGuildFacadeFragment.4
 * JD-Core Version:    0.7.0.1
 */