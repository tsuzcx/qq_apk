package com.tencent.mobileqq.guild.widget;

import com.tencent.mobileqq.activity.aio.item.ChatThumbView;
import java.util.Stack;

class GuildMixedMsgLinearLayout$ImageScrapHeap
{
  private Stack<ChatThumbView> b = new Stack();
  
  GuildMixedMsgLinearLayout$ImageScrapHeap(GuildMixedMsgLinearLayout paramGuildMixedMsgLinearLayout) {}
  
  public ChatThumbView a()
  {
    if (this.b.isEmpty()) {
      return null;
    }
    return (ChatThumbView)this.b.pop();
  }
  
  public void a(ChatThumbView paramChatThumbView)
  {
    this.b.push(paramChatThumbView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.widget.GuildMixedMsgLinearLayout.ImageScrapHeap
 * JD-Core Version:    0.7.0.1
 */