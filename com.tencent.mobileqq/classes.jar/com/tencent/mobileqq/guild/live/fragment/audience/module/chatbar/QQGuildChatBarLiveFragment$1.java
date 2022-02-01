package com.tencent.mobileqq.guild.live.fragment.audience.module.chatbar;

import android.util.Pair;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.live.QQGuildLiveRoomStartParams;
import com.tencent.mobileqq.guild.live.QQGuildLiveStartParamsCache;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qroute.QRoute;

class QQGuildChatBarLiveFragment$1
  implements Observer<Pair<Boolean, Boolean>>
{
  QQGuildChatBarLiveFragment$1(QQGuildChatBarLiveFragment paramQQGuildChatBarLiveFragment) {}
  
  public void a(Pair<Boolean, Boolean> paramPair)
  {
    if (paramPair.first == Boolean.TRUE)
    {
      paramPair = QQGuildLiveStartParamsCache.a().getChannelInfo();
      ((IGuildTempApi)QRoute.api(IGuildTempApi.class)).configLiveChannelGiftBgDrawable(QQGuildChatBarLiveFragment.a(this.a), QQGuildChatBarLiveFragment.a(this.a, paramPair.getBannedSpeak()), 2131890414);
      QQGuildChatBarLiveFragment.b(this.a);
      return;
    }
    if (paramPair.second == Boolean.TRUE)
    {
      ((IGuildTempApi)QRoute.api(IGuildTempApi.class)).configLiveChannelGiftBgDrawable(QQGuildChatBarLiveFragment.a(this.a), 2130840903, 2131890413);
      QQGuildChatBarLiveFragment.c(this.a);
      QQGuildChatBarLiveFragment.d(this.a);
      return;
    }
    ((IGuildTempApi)QRoute.api(IGuildTempApi.class)).configLiveChannelGiftBgDrawable(QQGuildChatBarLiveFragment.a(this.a), 2130840904, 2131890413);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.fragment.audience.module.chatbar.QQGuildChatBarLiveFragment.1
 * JD-Core Version:    0.7.0.1
 */