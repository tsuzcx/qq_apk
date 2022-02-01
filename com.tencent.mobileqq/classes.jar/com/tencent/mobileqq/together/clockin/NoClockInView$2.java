package com.tencent.mobileqq.together.clockin;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;

class NoClockInView$2
  implements Animation.AnimationListener
{
  NoClockInView$2(NoClockInView paramNoClockInView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.b(8);
    if (NoClockInView.a(this.a) != null) {
      NoClockInView.a(this.a).setOnClickListener(null);
    }
    this.a.a(2);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.a.a(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.together.clockin.NoClockInView.2
 * JD-Core Version:    0.7.0.1
 */