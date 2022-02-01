package com.tencent.qqmini.sdk.widget.actionsheet;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class ActionSheet$5$1
  implements Animation.AnimationListener
{
  ActionSheet$5$1(ActionSheet.5 param5) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.this$1.this$0.superDismiss();
    ActionSheet.access$1202(this.this$1.this$0, true);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.actionsheet.ActionSheet.5.1
 * JD-Core Version:    0.7.0.1
 */