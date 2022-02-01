package com.tencent.mobileqq.together.clockin;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import java.util.List;

class HasClockView$3
  implements Animation.AnimationListener
{
  HasClockView$3(HasClockView paramHasClockView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (HasClockView.c(this.a) >= HasClockView.e(this.a).size())
    {
      this.a.a(4);
      return;
    }
    HasClockView.f(this.a);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (HasClockView.c(this.a) == 0) {
      this.a.a(3);
    }
    HasClockView.d(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.together.clockin.HasClockView.3
 * JD-Core Version:    0.7.0.1
 */