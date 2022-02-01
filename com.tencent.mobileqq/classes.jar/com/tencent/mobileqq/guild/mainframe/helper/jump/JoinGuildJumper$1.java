package com.tencent.mobileqq.guild.mainframe.helper.jump;

import android.content.res.Resources;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.mainframe.GuildMainFrameConstants;
import com.tencent.mobileqq.guild.mainframe.GuildMainViewContext;
import com.tencent.mobileqq.guild.mainframe.helper.GuildLeftItemViewExtHelper;
import com.tencent.mobileqq.guild.mainframe.helper.JoinGuildParam;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchInviteInfoCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.IGuildInviteInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class JoinGuildJumper$1
  implements IFetchInviteInfoCallback
{
  JoinGuildJumper$1(JoinGuildJumper paramJoinGuildJumper, String paramString) {}
  
  public void a(int paramInt, String paramString, IGuildInviteInfo paramIGuildInviteInfo, IGProSecurityResult paramIGProSecurityResult)
  {
    QLog.d("JoinGuildJumper", 1, new Object[] { "fetchGuildInfoByInviteCode, errCode=", Integer.valueOf(paramInt), ", errMsg=", paramString });
    if ((paramInt == 0) && (QQGuildUtil.a(paramIGProSecurityResult)))
    {
      paramString = new JoinGuildParam();
      paramString.guildId = paramIGuildInviteInfo.a();
      paramString.channelId = paramIGuildInviteInfo.b();
      paramString.joinSignature = paramIGuildInviteInfo.f();
      paramString.channelId = paramIGuildInviteInfo.b();
    }
    try
    {
      paramString.from = Integer.parseInt(this.a);
    }
    catch (Exception paramIGuildInviteInfo)
    {
      label105:
      break label105;
    }
    QLog.e("JoinGuildJumper", 1, new Object[] { "from=", this.a });
    ((GuildLeftItemViewExtHelper)JoinGuildJumper.a(this.b).a(GuildMainFrameConstants.d)).a(paramString);
    return;
    if (paramInt == 300106)
    {
      QQToast.makeText(JoinGuildJumper.a(this.b).b(), 1, JoinGuildJumper.a(this.b).b().getResources().getString(2131890327), 1).show();
      return;
    }
    QQToast.makeText(JoinGuildJumper.a(this.b).b(), 1, JoinGuildJumper.a(this.b).b().getResources().getString(2131890217), 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.helper.jump.JoinGuildJumper.1
 * JD-Core Version:    0.7.0.1
 */