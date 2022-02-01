package com.tencent.mobileqq.qqgamepub.utils;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.RotateAnimation;
import com.tencent.mobileqq.qqgamepub.view.GameSessionView;

class QQGameUIHelper$1$1
  implements Animation.AnimationListener
{
  QQGameUIHelper$1$1(QQGameUIHelper.1 param1, GameSessionView paramGameSessionView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.setVisibility(8);
    QQGameUIHelper.a(this.a, true);
    paramAnimation = new RotateAnimation(0.0F, -45.0F, 1, 0.5F, 1, 0.5F);
    paramAnimation.setRepeatMode(2);
    paramAnimation.setRepeatCount(1);
    paramAnimation.setDuration(80L);
    this.b.b.startAnimation(paramAnimation);
    this.a.a();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.utils.QQGameUIHelper.1.1
 * JD-Core Version:    0.7.0.1
 */