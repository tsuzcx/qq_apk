package com.tencent.mobileqq.guild.mainframe.helper;

import com.tencent.mobileqq.qqguildsdk.callback.IFetchGuestGuildCallback;
import com.tencent.mobileqq.qqguildsdk.data.ICategoryInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class GuildLeftItemViewExtHelper$3
  implements IFetchGuestGuildCallback
{
  GuildLeftItemViewExtHelper$3(GuildLeftItemViewExtHelper paramGuildLeftItemViewExtHelper, JoinGuildParam paramJoinGuildParam, boolean paramBoolean) {}
  
  public void a(int paramInt, String paramString, IGProGuildInfo paramIGProGuildInfo, List<ICategoryInfo> paramList)
  {
    paramString = new StringBuilder();
    paramString.append("checkJoinLiveChannel: fetch guild info. errCode[");
    paramString.append(paramInt);
    paramString.append("]");
    QLog.e("GuildLeftItemViewExtHelper", 1, paramString.toString());
    if ((paramInt == 0) && (paramIGProGuildInfo != null))
    {
      paramString = GuildLeftItemViewExtHelper.a(this.c, this.a, this.b);
      GuildLeftItemViewExtHelper.a(this.c, this.a, paramIGProGuildInfo, paramString);
      return;
    }
    QLog.e("GuildLeftItemViewExtHelper", 1, "checkJoinLiveChannel: null info.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.helper.GuildLeftItemViewExtHelper.3
 * JD-Core Version:    0.7.0.1
 */