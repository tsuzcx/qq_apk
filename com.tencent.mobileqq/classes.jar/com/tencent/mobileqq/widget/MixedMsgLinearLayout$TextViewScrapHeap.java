package com.tencent.mobileqq.widget;

import java.util.Stack;

class MixedMsgLinearLayout$TextViewScrapHeap
{
  private Stack<AnimationTextView> b = new Stack();
  
  MixedMsgLinearLayout$TextViewScrapHeap(MixedMsgLinearLayout paramMixedMsgLinearLayout) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.MixedMsgLinearLayout.TextViewScrapHeap
 * JD-Core Version:    0.7.0.1
 */