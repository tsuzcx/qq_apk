package com.tencent.mobileqq.guild.chatpie.helper;

import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgListRefresher;
import com.tencent.mobileqq.activity.aio.oneclickjump.JumpState;
import com.tencent.mobileqq.activity.aio.oneclickjump.JumpStateMachineController;
import com.tencent.mobileqq.guild.chatpie.GuildChatContext;
import com.tencent.mobileqq.guild.chatpie.GuildListUI;

class GuildOneClickJumpHelper$1
  implements Runnable
{
  GuildOneClickJumpHelper$1(GuildOneClickJumpHelper paramGuildOneClickJumpHelper, boolean paramBoolean) {}
  
  public void run()
  {
    GuildListUI localGuildListUI = (GuildListUI)GuildOneClickJumpHelper.a(this.this$0).e().b();
    if (this.a) {
      localGuildListUI.a().a(JumpState.GRAY_TIP_BELOW);
    } else {
      localGuildListUI.a().a(JumpState.GRAY_TIP_ABOVE);
    }
    GuildOneClickJumpHelper.a(this.this$0).e().f().a(131072);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.helper.GuildOneClickJumpHelper.1
 * JD-Core Version:    0.7.0.1
 */