package com.tencent.mobileqq.extendfriend.wiget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.widget.ImageView;
import com.tencent.mobileqq.bubble.QQAnimationDrawable;
import com.tencent.qphone.base.util.QLog;

class SignalBombAnimationView$3
  implements Animator.AnimatorListener
{
  SignalBombAnimationView$3(SignalBombAnimationView paramSignalBombAnimationView) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if ((this.a.a != null) && (SignalBombAnimationView.a(this.a) != null))
    {
      SignalBombAnimationView.a(this.a).setVisibility(0);
      SignalBombAnimationView.a(this.a).setImageDrawable(this.a.a);
      this.a.a.start();
      QLog.d("SignalBombAnimationView", 2, "mFireDrawable start");
    }
    paramAnimator = ObjectAnimator.ofFloat(SignalBombAnimationView.b(this.a), "alpha", new float[] { 1.0F, 1.0F });
    paramAnimator.setDuration(480L);
    paramAnimator.addListener(new SignalBombAnimationView.3.1(this));
    paramAnimator.start();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.wiget.SignalBombAnimationView.3
 * JD-Core Version:    0.7.0.1
 */