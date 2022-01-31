package com.tencent.mobileqq.widget;

import android.view.View;
import bena;

class AnimationTextView$1
  implements Runnable
{
  AnimationTextView$1(AnimationTextView paramAnimationTextView) {}
  
  public void run()
  {
    if (this.this$0.getTag(2131367915) != null) {}
    for (boolean bool = ((Boolean)this.this$0.getTag(2131367915)).booleanValue();; bool = false)
    {
      if ((this.this$0.isSingleClick) && (this.this$0.onSingleClick != null) && (!bool)) {
        this.this$0.onSingleClick.a(this.this$0);
      }
      this.this$0.setTag(2131367915, Boolean.valueOf(false));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.AnimationTextView.1
 * JD-Core Version:    0.7.0.1
 */