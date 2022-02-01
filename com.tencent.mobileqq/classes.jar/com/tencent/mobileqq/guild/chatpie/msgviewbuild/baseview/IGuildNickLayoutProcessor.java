package com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview;

import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview.nickitem.AbsGuildNickLayoutItem.Data;

public abstract interface IGuildNickLayoutProcessor
  extends IGuildMsgItemLayoutProcessor
{
  public abstract void a(int paramInt);
  
  public abstract void a(View.OnClickListener paramOnClickListener);
  
  public abstract void a(ChatMessage paramChatMessage);
  
  public abstract void a(AbsGuildNickLayoutItem.Data paramData);
  
  public abstract LinearLayout b();
  
  public abstract String c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview.IGuildNickLayoutProcessor
 * JD-Core Version:    0.7.0.1
 */