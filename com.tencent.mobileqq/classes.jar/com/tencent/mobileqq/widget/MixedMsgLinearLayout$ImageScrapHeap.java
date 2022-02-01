package com.tencent.mobileqq.widget;

import com.tencent.mobileqq.activity.aio.item.ChatThumbView;
import java.util.Stack;

class MixedMsgLinearLayout$ImageScrapHeap
{
  private Stack<ChatThumbView> b = new Stack();
  
  MixedMsgLinearLayout$ImageScrapHeap(MixedMsgLinearLayout paramMixedMsgLinearLayout) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.MixedMsgLinearLayout.ImageScrapHeap
 * JD-Core Version:    0.7.0.1
 */