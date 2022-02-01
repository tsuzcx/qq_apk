package com.tencent.mobileqq.guild.live.livemanager;

import com.tencent.mobileqq.qqguildsdk.callback.IFetchGuestGuildCallback;
import com.tencent.mobileqq.qqguildsdk.data.ICategoryInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class QQGuildLiveEventHelper$11
  implements IFetchGuestGuildCallback
{
  QQGuildLiveEventHelper$11(QQGuildLiveEventHelper paramQQGuildLiveEventHelper) {}
  
  public void a(int paramInt, String paramString, IGProGuildInfo paramIGProGuildInfo, List<ICategoryInfo> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fetchGuestGuild result:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" errMsg:");
    localStringBuilder.append(paramString);
    QLog.i("QGL.QQGuildLiveEventHelper", 1, localStringBuilder.toString());
    if (!QQGuildLiveEventHelper.j(this.a))
    {
      QLog.i("QGL.QQGuildLiveEventHelper", 1, "fetchGuestGuild, inited = false, ignore result.");
      return;
    }
    if (paramInt != 0)
    {
      QLog.i("QGL.QQGuildLiveEventHelper", 1, "fetchGuestGuild, result != SUCCESS, ignore result.");
      return;
    }
    if (paramIGProGuildInfo == null)
    {
      QLog.i("QGL.QQGuildLiveEventHelper", 1, "fetchGuestGuild, guildInfo == null, ignore result.");
      return;
    }
    QQGuildLiveEventHelper.a(this.a, paramIGProGuildInfo, paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.livemanager.QQGuildLiveEventHelper.11
 * JD-Core Version:    0.7.0.1
 */