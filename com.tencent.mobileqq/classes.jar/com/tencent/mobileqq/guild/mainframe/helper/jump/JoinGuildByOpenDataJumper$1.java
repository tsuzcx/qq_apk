package com.tencent.mobileqq.guild.mainframe.helper.jump;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.guild.data.QQGuildOpenData;
import com.tencent.mobileqq.guild.mainframe.GuildMainFrameConstants;
import com.tencent.mobileqq.guild.mainframe.GuildMainViewContext;
import com.tencent.mobileqq.guild.mainframe.helper.GuildLeftItemViewExtHelper;
import com.tencent.mobileqq.guild.mainframe.helper.JoinGuildParam;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchGuildInfoByAppIdentityCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.IGuildJoinInfo;
import com.tencent.qphone.base.util.QLog;

class JoinGuildByOpenDataJumper$1
  implements IFetchGuildInfoByAppIdentityCallback
{
  JoinGuildByOpenDataJumper$1(JoinGuildByOpenDataJumper paramJoinGuildByOpenDataJumper, QQGuildOpenData paramQQGuildOpenData, Activity paramActivity) {}
  
  public void a(int paramInt, String paramString, IGuildJoinInfo paramIGuildJoinInfo, IGProSecurityResult paramIGProSecurityResult)
  {
    paramString = new StringBuilder();
    paramString.append("getGuildJoinInfoByGuildOpenData result:");
    paramString.append(paramInt);
    QLog.i("QQGuild-JoinGuildByOpenDataJumper", 1, paramString.toString());
    if ((QQGuildUtil.a(paramIGProSecurityResult)) && (paramInt == 0) && (paramIGuildJoinInfo != null))
    {
      paramString = new JoinGuildParam();
      paramString.from = 246615;
      paramString.joinSignature = paramIGuildJoinInfo.d();
      paramString.guildId = paramIGuildJoinInfo.a();
      paramIGuildJoinInfo = new Bundle();
      paramIGuildJoinInfo.putString("guild_from", "guildOpenJoin");
      paramIGuildJoinInfo.putString("guild_from_app_name", this.a.appName);
      paramString.extras = paramIGuildJoinInfo;
      ((GuildLeftItemViewExtHelper)JoinGuildByOpenDataJumper.a(this.c).a(GuildMainFrameConstants.d)).a(paramString);
      return;
    }
    QQGuildUtil.a(this.b, paramInt, null, paramIGProSecurityResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.helper.jump.JoinGuildByOpenDataJumper.1
 * JD-Core Version:    0.7.0.1
 */