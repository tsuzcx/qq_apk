package com.tencent.mobileqq.guild.mainframe.container.facade;

import com.tencent.mobileqq.guild.api.IGuildAdapterService;
import com.tencent.mobileqq.guild.mainframe.GuildMainViewContext;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchGuestGuildCallback;
import com.tencent.mobileqq.qqguildsdk.data.ICategoryInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppRuntime;

class QQGuildFacadeFragment$5
  implements IFetchGuestGuildCallback
{
  QQGuildFacadeFragment$5(QQGuildFacadeFragment paramQQGuildFacadeFragment) {}
  
  public void a(int paramInt, String paramString, IGProGuildInfo paramIGProGuildInfo, List<ICategoryInfo> paramList)
  {
    paramString = (IGuildAdapterService)QQGuildFacadeFragment.f(this.a).a().getRuntimeService(IGuildAdapterService.class, "");
    if ((paramInt == 0) && (paramIGProGuildInfo != null) && (paramIGProGuildInfo.getGuildID().equals(QQGuildFacadeFragment.a(this.a).b)))
    {
      paramString.setVisitorGuildCardInfo(paramIGProGuildInfo.getGuildID(), paramIGProGuildInfo, paramList);
      QQGuildFacadeFragment.a(this.a, paramIGProGuildInfo.getGuildID(), paramIGProGuildInfo.getAvatarUrl(100), paramIGProGuildInfo.getGuildName());
      paramString = new StringBuilder();
      paramString.append("fetchGuildChannelInfo, 网络回包");
      paramString.append(paramIGProGuildInfo);
      QLog.i("GuildDiscover", 2, paramString.toString());
      QQGuildFacadeFragment.a(this.a, false, false);
    }
    else
    {
      paramString.setVisitorGuildCardInfo(QQGuildFacadeFragment.a(this.a).b, null, null);
      QQGuildFacadeFragment.a(this.a, false, false);
      QQToast.makeText(QQGuildFacadeFragment.f(this.a).b(), 2131890493, 0).show();
      paramString = new StringBuilder();
      paramString.append("fetchGuildChannelInfo error! result = ");
      paramString.append(paramInt);
      paramString.append(" guildId = ");
      paramString.append(QQGuildFacadeFragment.a(this.a).b);
      QLog.e("QQGuildFacadeFragment", 1, paramString.toString());
    }
    QLog.i("GuildDiscover", 2, "fetchGuildChannelInfo -> setMaskGone, 网络回包");
    QQGuildFacadeFragment.d(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.container.facade.QQGuildFacadeFragment.5
 * JD-Core Version:    0.7.0.1
 */