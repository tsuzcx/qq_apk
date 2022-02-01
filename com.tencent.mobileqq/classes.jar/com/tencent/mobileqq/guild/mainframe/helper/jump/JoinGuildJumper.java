package com.tencent.mobileqq.guild.mainframe.helper.jump;

import android.net.Uri;
import android.os.Bundle;
import com.tencent.mobileqq.guild.mainframe.GuildMainFrameConstants;
import com.tencent.mobileqq.guild.mainframe.GuildMainViewContext;
import com.tencent.mobileqq.guild.mainframe.helper.GuildLeftItemViewExtHelper;
import com.tencent.mobileqq.guild.mainframe.helper.JoinGuildParam;
import com.tencent.mobileqq.guild.source.QQGuildJumpSource;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class JoinGuildJumper
  implements IGuildBaseJumper
{
  private GuildMainViewContext a;
  
  public JoinGuildJumper(GuildMainViewContext paramGuildMainViewContext)
  {
    this.a = paramGuildMainViewContext;
  }
  
  private void a()
  {
    if (!QQGuildJumpSource.d())
    {
      QQGuildJumpSource.a("share");
      QQGuildJumpSource.b("others");
      QQGuildJumpSource.a(false);
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    ((IGPSService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IGPSService.class, "")).fetchGuildInfoByInviteCode(paramString1, new JoinGuildJumper.1(this, paramString2));
  }
  
  private void b(Bundle paramBundle)
  {
    a();
    paramBundle = paramBundle.getString("GuildShareUrl");
    if (paramBundle.isEmpty()) {
      return;
    }
    a(Uri.parse(paramBundle).getQueryParameter("inviteCode"), Uri.parse(paramBundle).getQueryParameter("from"));
  }
  
  private void c(Bundle paramBundle)
  {
    JoinGuildParam localJoinGuildParam = new JoinGuildParam();
    localJoinGuildParam.guildId = paramBundle.getString("guildId");
    localJoinGuildParam.joinSignature = paramBundle.getString("authSig");
    localJoinGuildParam.from = paramBundle.getInt("from");
    ((GuildLeftItemViewExtHelper)this.a.a(GuildMainFrameConstants.d)).a(localJoinGuildParam);
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle.isEmpty()) {
      return;
    }
    int i = paramBundle.getInt("jumpType");
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 3)
        {
          QLog.d("JoinGuildJumper", 1, new Object[] { "handleAction, extra error,jumpType=", Integer.valueOf(i) });
          return;
        }
        a(paramBundle.getString("inviteCode"), String.valueOf(paramBundle.getInt("from")));
        return;
      }
      c(paramBundle);
      return;
    }
    b(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.helper.jump.JoinGuildJumper
 * JD-Core Version:    0.7.0.1
 */