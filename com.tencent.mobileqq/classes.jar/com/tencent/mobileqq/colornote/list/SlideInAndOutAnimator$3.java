package com.tencent.mobileqq.colornote.list;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;

class SlideInAndOutAnimator$3
  extends AnimatorListenerAdapter
{
  SlideInAndOutAnimator$3(SlideInAndOutAnimator paramSlideInAndOutAnimator, RecyclerView.ViewHolder paramViewHolder, int paramInt, View paramView, ViewPropertyAnimator paramViewPropertyAnimator) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (this.b != 0) {
      this.c.setTranslationY(0.0F);
    }
    this.c.setAlpha(1.0F);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.d.setListener(null);
    this.e.dispatchMoveFinished(this.a);
    SlideInAndOutAnimator.d(this.e).remove(this.a);
    SlideInAndOutAnimator.b(this.e);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.e.dispatchMoveStarting(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.list.SlideInAndOutAnimator.3
 * JD-Core Version:    0.7.0.1
 */