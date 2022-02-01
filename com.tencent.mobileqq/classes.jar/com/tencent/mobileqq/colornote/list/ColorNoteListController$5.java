package com.tencent.mobileqq.colornote.list;

import android.animation.Animator;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class ColorNoteListController$5
  extends D8SafeAnimatorListener
{
  ColorNoteListController$5(ColorNoteListController paramColorNoteListController, boolean paramBoolean) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ColorNoteListController.g(this.b).scrollTo(0, 0);
    ColorNoteListController.g(this.b).setAlpha(1.0F);
    ColorNoteListController.g(this.b).setBackgroundColor(ColorNoteListController.c(this.b).getResources().getColor(ColorNoteListController.f()));
    paramAnimator = this.b.a;
    int i;
    if (this.a) {
      i = -this.b.a.getMeasuredWidth();
    } else {
      i = this.b.a.getMeasuredWidth();
    }
    paramAnimator.setX(i);
    this.b.a.setAlpha(0.0F);
    this.b.a.setVisibility(0);
    this.b.a.animate().setInterpolator(new DecelerateInterpolator()).alpha(1.0F).translationX(0.0F).setDuration(180L).start();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.list.ColorNoteListController.5
 * JD-Core Version:    0.7.0.1
 */