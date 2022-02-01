package com.tencent.mobileqq.guild.mainframe.container.facade;

import com.tencent.mobileqq.qqguildsdk.callback.IFetchGuildInfoCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.qphone.base.util.QLog;

class QQGuildFacadeFragment$2
  implements IFetchGuildInfoCallback
{
  QQGuildFacadeFragment$2(QQGuildFacadeFragment paramQQGuildFacadeFragment) {}
  
  public void a(int paramInt, String paramString, IGProGuildInfo paramIGProGuildInfo)
  {
    if ((paramInt == 0) && (paramIGProGuildInfo != null) && (QQGuildFacadeFragment.a(this.a).b.equals(paramIGProGuildInfo.getGuildID())))
    {
      paramString = new StringBuilder();
      paramString.append("showLocalGuildCard, 网络回包");
      paramString.append(paramIGProGuildInfo);
      QLog.i("GuildDiscover", 2, paramString.toString());
      QQGuildFacadeFragment.a(this.a, false, false);
    }
    else
    {
      paramString = new StringBuilder();
      paramString.append("fetchGuildInfo error! result = ");
      paramString.append(paramInt);
      paramString.append(" guildId = ");
      paramString.append(QQGuildFacadeFragment.a(this.a).b);
      QLog.e("QQGuildFacadeFragment", 1, paramString.toString());
    }
    QLog.i("GuildDiscover", 2, "showLocalGuildCard -> setMaskGone, 网络回包");
    QQGuildFacadeFragment.d(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.container.facade.QQGuildFacadeFragment.2
 * JD-Core Version:    0.7.0.1
 */