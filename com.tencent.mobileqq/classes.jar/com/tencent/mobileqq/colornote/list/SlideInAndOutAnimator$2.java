package com.tencent.mobileqq.colornote.list;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;

class SlideInAndOutAnimator$2
  extends AnimatorListenerAdapter
{
  SlideInAndOutAnimator$2(SlideInAndOutAnimator paramSlideInAndOutAnimator, RecyclerView.ViewHolder paramViewHolder, View paramView, ViewPropertyAnimator paramViewPropertyAnimator) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.b.setAlpha(1.0F);
    this.b.setTranslationY(0.0F);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.c.setListener(null);
    this.d.dispatchAddFinished(this.a);
    SlideInAndOutAnimator.c(this.d).remove(this.a);
    SlideInAndOutAnimator.b(this.d);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.d.dispatchAddStarting(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.list.SlideInAndOutAnimator.2
 * JD-Core Version:    0.7.0.1
 */