package com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview;

import android.widget.RelativeLayout;
import com.tencent.mobileqq.data.ChatMessage;

public abstract interface IGuildTailProcessor
  extends IGuildMsgItemLayoutProcessor
{
  public abstract RelativeLayout a();
  
  public abstract void a(ChatMessage paramChatMessage);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview.IGuildTailProcessor
 * JD-Core Version:    0.7.0.1
 */