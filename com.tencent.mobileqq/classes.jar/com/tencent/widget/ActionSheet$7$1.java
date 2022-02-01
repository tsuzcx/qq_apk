package com.tencent.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class ActionSheet$7$1
  implements Animation.AnimationListener
{
  ActionSheet$7$1(ActionSheet.7 param7) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.this$1.this$0.superDismiss();
    ActionSheet.access$702(this.this$1.this$0, true);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.widget.ActionSheet.7.1
 * JD-Core Version:    0.7.0.1
 */