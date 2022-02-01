package com.tencent.mobileqq.colornote.anim;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

final class CircularRevealAnimator$ChangeViewLayerTypeListener
  extends AnimatorListenerAdapter
{
  private View a;
  private int b;
  private int c;
  
  CircularRevealAnimator$ChangeViewLayerTypeListener(View paramView, int paramInt)
  {
    this.a = paramView;
    this.b = paramInt;
    this.c = paramView.getLayerType();
  }
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.a.setLayerType(this.c, null);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.setLayerType(this.c, null);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.a.setLayerType(this.b, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.anim.CircularRevealAnimator.ChangeViewLayerTypeListener
 * JD-Core Version:    0.7.0.1
 */