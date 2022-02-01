package com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview;

import android.content.Context;
import mqq.app.AppRuntime;

public class GuildLiveChannelMsgItemLayoutViewFactory
  extends GuildMsgItemLayoutViewFactory
{
  public GuildLiveChannelMsgItemLayoutViewFactory(AppRuntime paramAppRuntime, GuildMsgItemLayout paramGuildMsgItemLayout, Context paramContext)
  {
    super(paramAppRuntime, paramGuildMsgItemLayout, paramContext);
  }
  
  protected IGuildMsgItemLayoutProcessor a()
  {
    return new GuildLiveChannelNickLayoutProcessor(this.c, this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview.GuildLiveChannelMsgItemLayoutViewFactory
 * JD-Core Version:    0.7.0.1
 */