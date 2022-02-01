package com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.data.ChatMessage;

class GuildTextItemBuild$1
  implements DialogInterface.OnClickListener
{
  GuildTextItemBuild$1(GuildTextItemBuild paramGuildTextItemBuild, ChatMessage paramChatMessage) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ChatActivityFacade.a(this.b.g, this.b.b, this.b.c, this.a.msg, this.a.uniseq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.GuildTextItemBuild.1
 * JD-Core Version:    0.7.0.1
 */