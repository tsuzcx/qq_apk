package com.tencent.mobileqq.microapp.ui.a;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

final class b
  implements Animation.AnimationListener
{
  b(a parama) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    a.a(this.a, false);
    a.b(this.a).post(new c(this));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    a.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.ui.a.b
 * JD-Core Version:    0.7.0.1
 */