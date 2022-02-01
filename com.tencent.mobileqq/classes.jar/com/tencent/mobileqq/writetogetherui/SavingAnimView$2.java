package com.tencent.mobileqq.writetogetherui;

import android.animation.Animator;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class SavingAnimView$2
  extends D8SafeAnimatorListener
{
  SavingAnimView$2(SavingAnimView paramSavingAnimView) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    SavingAnimView.a(this.a, 2);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (SavingAnimView.b(this.a) != null) {
      SavingAnimView.b(this.a).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.writetogetherui.SavingAnimView.2
 * JD-Core Version:    0.7.0.1
 */