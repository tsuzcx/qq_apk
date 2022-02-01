package com.tencent.mobileqq.guild.widget;

import com.tencent.mobileqq.widget.AnimationTextView;
import java.util.Stack;

class GuildMixedMsgLinearLayout$TextViewScrapHeap
{
  private Stack<AnimationTextView> b = new Stack();
  
  GuildMixedMsgLinearLayout$TextViewScrapHeap(GuildMixedMsgLinearLayout paramGuildMixedMsgLinearLayout) {}
  
  public AnimationTextView a()
  {
    if (this.b.isEmpty()) {
      return null;
    }
    return (AnimationTextView)this.b.pop();
  }
  
  public void a(AnimationTextView paramAnimationTextView)
  {
    this.b.push(paramAnimationTextView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.widget.GuildMixedMsgLinearLayout.TextViewScrapHeap
 * JD-Core Version:    0.7.0.1
 */