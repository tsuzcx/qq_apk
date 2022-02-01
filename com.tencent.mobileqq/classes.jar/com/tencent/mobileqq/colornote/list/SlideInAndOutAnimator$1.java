package com.tencent.mobileqq.colornote.list;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import java.util.ArrayList;

class SlideInAndOutAnimator$1
  implements ViewPropertyAnimatorListener
{
  SlideInAndOutAnimator$1(SlideInAndOutAnimator paramSlideInAndOutAnimator, RecyclerView.ViewHolder paramViewHolder, ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat) {}
  
  public void onAnimationCancel(View paramView) {}
  
  public void onAnimationEnd(View paramView)
  {
    this.b.setListener(null);
    ViewCompat.setAlpha(paramView, 1.0F);
    this.c.dispatchRemoveFinished(this.a);
    SlideInAndOutAnimator.a(this.c).remove(this.a);
    SlideInAndOutAnimator.b(this.c);
  }
  
  public void onAnimationStart(View paramView)
  {
    this.c.dispatchRemoveStarting(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.list.SlideInAndOutAnimator.1
 * JD-Core Version:    0.7.0.1
 */