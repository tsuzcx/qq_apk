package com.tencent.mobileqq.guild.mainframe.helper.jump;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.guild.data.QQGuildOpenData;
import com.tencent.mobileqq.guild.mainframe.GuildMainViewContext;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.GuildIdentityInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class JoinGuildByOpenDataJumper
  implements IGuildBaseJumper
{
  private GuildMainViewContext a;
  
  public JoinGuildByOpenDataJumper(GuildMainViewContext paramGuildMainViewContext)
  {
    this.a = paramGuildMainViewContext;
  }
  
  public void a(Activity paramActivity, AppRuntime paramAppRuntime, QQGuildOpenData paramQQGuildOpenData)
  {
    if (paramQQGuildOpenData == null) {
      QLog.e("QQGuild-JoinGuildByOpenDataJumper", 1, "getGuildJoinInfoByGuildOpenData error openData null");
    }
    ((IGPSService)paramAppRuntime.getRuntimeService(IGPSService.class, "")).fetchGuildInfoByAppIdentity(new GuildIdentityInfo(paramQQGuildOpenData.appId, paramQQGuildOpenData.orgId, paramQQGuildOpenData.worldId), paramQQGuildOpenData.guildOpenId, paramQQGuildOpenData.rawUrl, new JoinGuildByOpenDataJumper.1(this, paramQQGuildOpenData, paramActivity));
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle.isEmpty()) {
      return;
    }
    if (!paramBundle.containsKey("extra_open_guild_data")) {
      return;
    }
    paramBundle = (QQGuildOpenData)paramBundle.getSerializable("extra_open_guild_data");
    a(this.a.b(), this.a.a(), paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.helper.jump.JoinGuildByOpenDataJumper
 * JD-Core Version:    0.7.0.1
 */