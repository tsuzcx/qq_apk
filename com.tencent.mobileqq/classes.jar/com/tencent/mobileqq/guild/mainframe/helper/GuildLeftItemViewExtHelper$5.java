package com.tencent.mobileqq.guild.mainframe.helper;

import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchGuildInfoCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class GuildLeftItemViewExtHelper$5
  implements IFetchGuildInfoCallback
{
  GuildLeftItemViewExtHelper$5(GuildLeftItemViewExtHelper paramGuildLeftItemViewExtHelper, JoinGuildParam paramJoinGuildParam, IGPSService paramIGPSService, IGProChannelInfo paramIGProChannelInfo, boolean paramBoolean) {}
  
  public void a(int paramInt, String paramString, IGProGuildInfo paramIGProGuildInfo)
  {
    QLog.d("GuildLeftItemViewExtHelper", 1, new Object[] { "onFetchGuildInfo, result=", Integer.valueOf(paramInt), ", errMsg=", paramString });
    if ((paramInt == 0) && (paramIGProGuildInfo != null))
    {
      paramString = new ArrayList();
      paramString.add(this.a.channelId);
      this.b.fetchAudioChannelUserListForGuest(this.a.guildId, paramString, new GuildLeftItemViewExtHelper.5.1(this, paramIGProGuildInfo));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.helper.GuildLeftItemViewExtHelper.5
 * JD-Core Version:    0.7.0.1
 */