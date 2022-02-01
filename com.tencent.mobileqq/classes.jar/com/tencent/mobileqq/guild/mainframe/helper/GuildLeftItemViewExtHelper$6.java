package com.tencent.mobileqq.guild.mainframe.helper;

import com.tencent.mobileqq.guild.api.ILaunchGuildChatPieApi;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchAudioChannelUserListCallback;
import com.tencent.mobileqq.qqguildsdk.data.IAudioChannelMemberInfos;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class GuildLeftItemViewExtHelper$6
  implements IFetchAudioChannelUserListCallback
{
  GuildLeftItemViewExtHelper$6(GuildLeftItemViewExtHelper paramGuildLeftItemViewExtHelper, IGProGuildInfo paramIGProGuildInfo, IGProChannelInfo paramIGProChannelInfo) {}
  
  public void a(int paramInt, String paramString, IAudioChannelMemberInfos paramIAudioChannelMemberInfos)
  {
    QLog.d("GuildLeftItemViewExtHelper", 1, new Object[] { "onFetchAudioChannelUserList, result=", Integer.valueOf(paramInt), ", errMsg=", paramString });
    if ((paramInt == 0) && (paramIAudioChannelMemberInfos != null)) {
      ((ILaunchGuildChatPieApi)QRoute.api(ILaunchGuildChatPieApi.class)).launchAudioChatPie(BaseApplication.getContext(), this.a, this.b, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.helper.GuildLeftItemViewExtHelper.6
 * JD-Core Version:    0.7.0.1
 */