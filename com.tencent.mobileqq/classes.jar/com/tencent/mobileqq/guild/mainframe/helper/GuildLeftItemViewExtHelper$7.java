package com.tencent.mobileqq.guild.mainframe.helper;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.mainframe.GuildMainViewContext;
import com.tencent.mobileqq.guild.mainframe.helper.jump.JoinGuildVoiceChannelWindow;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.qphone.base.util.QLog;

class GuildLeftItemViewExtHelper$7
  implements Runnable
{
  GuildLeftItemViewExtHelper$7(GuildLeftItemViewExtHelper paramGuildLeftItemViewExtHelper, JoinGuildParam paramJoinGuildParam, IGProGuildInfo paramIGProGuildInfo, IGProChannelInfo paramIGProChannelInfo, boolean paramBoolean) {}
  
  public void run()
  {
    QLog.d("GuildLeftItemViewExtHelper", 1, "showJoinVoiceChannelWindow");
    GuildLeftItemViewExtHelper.a(this.this$0, JoinGuildVoiceChannelWindow.a(this.a, this.b, this.c, this.d));
    GuildLeftItemViewExtHelper.b(this.this$0).show(GuildLeftItemViewExtHelper.a(this.this$0).b().getSupportFragmentManager(), "GuildLeftItemViewExtHelper");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.helper.GuildLeftItemViewExtHelper.7
 * JD-Core Version:    0.7.0.1
 */