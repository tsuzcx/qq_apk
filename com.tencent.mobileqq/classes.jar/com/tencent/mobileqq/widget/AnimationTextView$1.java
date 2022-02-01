package com.tencent.mobileqq.widget;

import android.view.View;

class AnimationTextView$1
  implements Runnable
{
  AnimationTextView$1(AnimationTextView paramAnimationTextView) {}
  
  public void run()
  {
    boolean bool;
    if (this.this$0.getTag(2131435345) != null) {
      bool = ((Boolean)this.this$0.getTag(2131435345)).booleanValue();
    } else {
      bool = false;
    }
    if ((this.this$0.isSingleClick) && (this.this$0.onSingleClick != null) && (!bool)) {
      this.this$0.onSingleClick.a(this.this$0);
    }
    this.this$0.setTag(2131435345, Boolean.valueOf(false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.AnimationTextView.1
 * JD-Core Version:    0.7.0.1
 */