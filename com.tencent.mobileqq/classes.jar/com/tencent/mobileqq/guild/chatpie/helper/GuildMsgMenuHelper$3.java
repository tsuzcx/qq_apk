package com.tencent.mobileqq.guild.chatpie.helper;

import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.selectable.AIOSelectableDelegateImpl;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.guild.chatpie.GuildChatContext;
import com.tencent.mobileqq.guild.chatpie.GuildMsgItemBuildFactory;
import com.tencent.mobileqq.guild.chatpie.GuildPieAdapter;
import com.tencent.mobileqq.guild.message.chatpie.IGuildMenuEventCallBack;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.qphone.base.util.QLog;

class GuildMsgMenuHelper$3
  implements IGuildMenuEventCallBack
{
  GuildMsgMenuHelper$3(GuildMsgMenuHelper paramGuildMsgMenuHelper) {}
  
  public void a(ChatMessage paramChatMessage)
  {
    com.tencent.mobileqq.utils.BubbleContextMenu.a = false;
    GuildMsgMenuHelper.a(this.a, null);
    this.a.a.n().V.notifyDataSetChanged();
  }
  
  public void a(QQCustomMenuItem paramQQCustomMenuItem, ChatMessage paramChatMessage)
  {
    if (paramChatMessage != null)
    {
      GuildPieAdapter localGuildPieAdapter = (GuildPieAdapter)this.a.a.n().V;
      localGuildPieAdapter.r.a(paramChatMessage, localGuildPieAdapter).a(paramQQCustomMenuItem.b(), this.a.a.b(), paramChatMessage);
      if ((paramQQCustomMenuItem.b() != 2131445511) && (AIOSelectableDelegateImpl.a().l())) {
        AIOSelectableDelegateImpl.a().n();
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("ChatItemBuilder", 2, "bubble onClick() is called while the chatMessage is null.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.helper.GuildMsgMenuHelper.3
 * JD-Core Version:    0.7.0.1
 */