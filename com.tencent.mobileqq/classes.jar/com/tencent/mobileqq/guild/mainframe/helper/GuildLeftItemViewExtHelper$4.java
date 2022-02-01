package com.tencent.mobileqq.guild.mainframe.helper;

import com.tencent.mobileqq.qqguildsdk.callback.IGetAudioChannelMemberInfosListCallback;
import com.tencent.mobileqq.qqguildsdk.data.IAudioChannelMemberInfos;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class GuildLeftItemViewExtHelper$4
  implements IGetAudioChannelMemberInfosListCallback
{
  GuildLeftItemViewExtHelper$4(GuildLeftItemViewExtHelper paramGuildLeftItemViewExtHelper, JoinGuildParam paramJoinGuildParam, IGProGuildInfo paramIGProGuildInfo, IGProChannelInfo paramIGProChannelInfo, boolean paramBoolean) {}
  
  public void a(int paramInt, String paramString, List<IAudioChannelMemberInfos> paramList)
  {
    QLog.d("GuildLeftItemViewExtHelper", 1, new Object[] { "onGetAudioChannelMemberInfosList, result=", Integer.valueOf(paramInt), ", errMsg=", paramString });
    if ((paramInt == 0) && (paramList != null) && (paramList.size() > 0)) {
      GuildLeftItemViewExtHelper.a(this.e, (IAudioChannelMemberInfos)paramList.get(0), this.a, this.b, this.c, this.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.helper.GuildLeftItemViewExtHelper.4
 * JD-Core Version:    0.7.0.1
 */