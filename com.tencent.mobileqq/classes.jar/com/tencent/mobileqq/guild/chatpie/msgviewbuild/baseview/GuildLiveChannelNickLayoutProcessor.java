package com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview;

import android.content.Context;
import com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview.nickitem.GuildLiveChannelNickLayoutNickNameItem;
import com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview.nickitem.GuildLiveChannelNickLayoutTimeStampItem;
import com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview.nickitem.GuildLiveNickLayoutGameItem;
import com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview.nickitem.GuildLiveNickLayoutRobotItem;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class GuildLiveChannelNickLayoutProcessor
  extends GuildNickLayoutProcessor
{
  public GuildLiveChannelNickLayoutProcessor(AppRuntime paramAppRuntime, GuildMsgItemLayout paramGuildMsgItemLayout, Context paramContext)
  {
    super(paramAppRuntime, paramGuildMsgItemLayout, paramContext);
  }
  
  public void a()
  {
    super.a();
    this.j.put(Integer.valueOf(b), new GuildLiveChannelNickLayoutNickNameItem(this.h, this.i));
    this.j.put(Integer.valueOf(c), new GuildLiveNickLayoutRobotItem(this.h, this.i));
    this.j.put(Integer.valueOf(e), new GuildLiveChannelNickLayoutTimeStampItem(this.h, this.i));
    this.j.put(Integer.valueOf(d), new GuildLiveNickLayoutGameItem(this.h, this.i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview.GuildLiveChannelNickLayoutProcessor
 * JD-Core Version:    0.7.0.1
 */