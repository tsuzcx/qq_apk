package com.tencent.mobileqq.guild.message.chatpie;

import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;

public abstract interface IGuildMenuEventCallBack
{
  public abstract void a(ChatMessage paramChatMessage);
  
  public abstract void a(QQCustomMenuItem paramQQCustomMenuItem, ChatMessage paramChatMessage);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.chatpie.IGuildMenuEventCallBack
 * JD-Core Version:    0.7.0.1
 */