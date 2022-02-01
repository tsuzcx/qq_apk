package com.tencent.mobileqq.hotchat.anim;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import java.util.concurrent.atomic.AtomicInteger;

class HeartAnimator$1
  implements Animation.AnimationListener
{
  HeartAnimator$1(HeartAnimator paramHeartAnimator, ViewGroup paramViewGroup, View paramView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.c.d.post(new HeartAnimator.1.1(this));
    this.c.c.decrementAndGet();
    if (HeartAnimator.a(this.c) != null) {
      HeartAnimator.a(this.c).b(paramAnimation);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.c.c.incrementAndGet();
    if (HeartAnimator.a(this.c) != null) {
      HeartAnimator.a(this.c).a(paramAnimation);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotchat.anim.HeartAnimator.1
 * JD-Core Version:    0.7.0.1
 */