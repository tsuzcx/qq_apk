package com.tencent.mobileqq.guild.chatpie;

import android.app.Activity;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.AIOGuildLiveDTReportHelper;
import com.tencent.mobileqq.activity.aio.helper.GuildLiveSimpleUIAIOHelper;
import com.tencent.mobileqq.guild.activity.aio.helper.GuildLiveSelectToBottomHelper;
import com.tencent.mobileqq.guild.chatpie.helper.GuildLiveAIOMultiActionHelper;
import com.tencent.mobileqq.guild.chatpie.helper.GuildLiveChannelInputBarHelper;
import com.tencent.mobileqq.guild.chatpie.helper.GuildLiveMsgMenuHelper;
import com.tencent.mobileqq.guild.chatpie.helper.GuildLiveReplyHelper;

public class GuildLiveHelperProvider
  extends GuildHelperProvider
{
  public GuildLiveHelperProvider(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    super.a(paramBaseChatPie);
    a(147, new GuildLiveAIOMultiActionHelper(paramBaseChatPie));
    a(29, new GuildLiveSimpleUIAIOHelper(paramBaseChatPie));
    a(40, new GuildLiveSelectToBottomHelper(paramBaseChatPie));
    a(101, new AIOGuildLiveDTReportHelper(paramBaseChatPie));
  }
  
  protected void a(GuildChatContext paramGuildChatContext)
  {
    super.a(paramGuildChatContext);
    a(145, new GuildLiveChannelInputBarHelper(paramGuildChatContext));
    a(119, new GuildLiveReplyHelper(paramGuildChatContext));
    a(156, new GuildLiveMsgMenuHelper(paramGuildChatContext));
  }
  
  protected boolean b()
  {
    return true;
  }
  
  protected boolean b(BaseChatPie paramBaseChatPie)
  {
    return paramBaseChatPie instanceof GuildLiveChannelChatPie;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.GuildLiveHelperProvider
 * JD-Core Version:    0.7.0.1
 */