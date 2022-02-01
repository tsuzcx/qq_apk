package com.tencent.mobileqq.qqgamepub.web.delegate;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.RotateAnimation;
import com.tencent.mobileqq.qqgamepub.view.GameSessionView;

class GameContentViewDelegate$2$1
  implements Animation.AnimationListener
{
  GameContentViewDelegate$2$1(GameContentViewDelegate.2 param2) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    GameContentViewDelegate.b(this.a.this$0).setVisibility(8);
    GameContentViewDelegate.a(this.a.this$0, GameContentViewDelegate.b(this.a.this$0), true);
    paramAnimation = new RotateAnimation(0.0F, -45.0F, 1, 0.5F, 1, 0.5F);
    paramAnimation.setRepeatMode(2);
    paramAnimation.setRepeatCount(1);
    paramAnimation.setDuration(80L);
    GameContentViewDelegate.a(this.a.this$0).startAnimation(paramAnimation);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.web.delegate.GameContentViewDelegate.2.1
 * JD-Core Version:    0.7.0.1
 */