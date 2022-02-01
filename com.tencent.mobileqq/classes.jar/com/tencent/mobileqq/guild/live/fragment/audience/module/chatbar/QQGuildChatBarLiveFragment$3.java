package com.tencent.mobileqq.guild.live.fragment.audience.module.chatbar;

import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.util.GuildLiveToast;
import com.tencent.mobileqq.qqguildsdk.callback.IResultWithSecurityCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

class QQGuildChatBarLiveFragment$3
  implements IResultWithSecurityCallback
{
  QQGuildChatBarLiveFragment$3(QQGuildChatBarLiveFragment paramQQGuildChatBarLiveFragment, int paramInt) {}
  
  public void a(int paramInt, String paramString, IGProSecurityResult paramIGProSecurityResult)
  {
    paramIGProSecurityResult = new StringBuilder();
    paramIGProSecurityResult.append("setChannelBannedSpeak");
    paramIGProSecurityResult.append(paramInt);
    paramIGProSecurityResult.append("-");
    paramIGProSecurityResult.append(paramString);
    QLog.d("QGL.QQGuildChatBarLiveFragment", 4, paramIGProSecurityResult.toString());
    if (paramInt == 0)
    {
      ((IGuildTempApi)QRoute.api(IGuildTempApi.class)).configLiveChannelGiftBgDrawable(QQGuildChatBarLiveFragment.a(this.b), QQGuildChatBarLiveFragment.a(this.b, this.a), 2131890414);
      if (this.a == 1)
      {
        GuildLiveToast.a(2131890443);
        return;
      }
      GuildLiveToast.a(2131890446);
      return;
    }
    GuildLiveToast.a(2131890548);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.fragment.audience.module.chatbar.QQGuildChatBarLiveFragment.3
 * JD-Core Version:    0.7.0.1
 */