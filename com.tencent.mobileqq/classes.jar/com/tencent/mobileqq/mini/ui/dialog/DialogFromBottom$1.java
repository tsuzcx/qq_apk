package com.tencent.mobileqq.mini.ui.dialog;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class DialogFromBottom$1
  implements Animation.AnimationListener
{
  DialogFromBottom$1(DialogFromBottom paramDialogFromBottom) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    DialogFromBottom.access$002(this.this$0, false);
    DialogFromBottom.access$200(this.this$0).post(new DialogFromBottom.1.1(this));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    DialogFromBottom.access$002(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.ui.dialog.DialogFromBottom.1
 * JD-Core Version:    0.7.0.1
 */