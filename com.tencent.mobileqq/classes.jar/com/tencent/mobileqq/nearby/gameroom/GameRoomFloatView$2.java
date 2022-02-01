package com.tencent.mobileqq.nearby.gameroom;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;

class GameRoomFloatView$2
  implements ValueAnimator.AnimatorUpdateListener
{
  GameRoomFloatView$2(GameRoomFloatView paramGameRoomFloatView, WindowManager.LayoutParams paramLayoutParams, ValueAnimator paramValueAnimator) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (this.c.g)
    {
      int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
      this.a.x = i;
      this.c.b.updateViewLayout(this.c.a, this.a);
      return;
    }
    this.b.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.GameRoomFloatView.2
 * JD-Core Version:    0.7.0.1
 */