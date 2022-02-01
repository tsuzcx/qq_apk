package com.tencent.mobileqq.guild.chatpie;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mobileqq.guild.chatpie.helper.GuildMsgMenuHelper;

class GuildChatPie$GuildOnGestureListener
  extends GestureDetector.SimpleOnGestureListener
{
  GuildChatPie$GuildOnGestureListener(GuildChatPie paramGuildChatPie) {}
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    super.onLongPress(paramMotionEvent);
    ((GuildMsgMenuHelper)this.a.q(156)).a(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.GuildChatPie.GuildOnGestureListener
 * JD-Core Version:    0.7.0.1
 */