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
    if (HasClockView.a(this.a) >= HasClockView.a(this.a).size())
    {
      this.a.a(4);
      return;
    }
    HasClockView.b(this.a);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (HasClockView.a(this.a) == 0) {
      this.a.a(3);
    }
    HasClockView.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.together.clockin.HasClockView.3
 * JD-Core Version:    0.7.0.1
 */