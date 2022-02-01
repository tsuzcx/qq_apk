package com.tencent.mobileqq.guild.mainframe.helper;

import com.tencent.mobileqq.qqguildsdk.callback.IGetAudioChannelMemberInfosListCallback;
import com.tencent.mobileqq.qqguildsdk.data.IAudioChannelMemberInfos;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class GuildLeftItemViewExtHelper$5$1
  implements IGetAudioChannelMemberInfosListCallback
{
  GuildLeftItemViewExtHelper$5$1(GuildLeftItemViewExtHelper.5 param5, IGProGuildInfo paramIGProGuildInfo) {}
  
  public void a(int paramInt, String paramString, List<IAudioChannelMemberInfos> paramList)
  {
    QLog.d("GuildLeftItemViewExtHelper", 1, new Object[] { "onGetAudioChannelMemberInfosList2, result=", Integer.valueOf(paramInt), ", errMsg=", paramString });
    if ((paramInt == 0) && (paramList != null) && (paramList.size() > 0)) {
      GuildLeftItemViewExtHelper.a(this.b.e, (IAudioChannelMemberInfos)paramList.get(0), this.b.a, this.a, this.b.c, this.b.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.helper.GuildLeftItemViewExtHelper.5.1
 * JD-Core Version:    0.7.0.1
 */