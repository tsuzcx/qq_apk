package com.tencent.mobileqq.colornote.list;

import android.animation.Animator;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class ColorNoteListController$6
  extends D8SafeAnimatorListener
{
  ColorNoteListController$6(ColorNoteListController paramColorNoteListController) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (ColorNoteListController.h(this.a) != null) {
      ColorNoteListController.h(this.a).c();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.list.ColorNoteListController.6
 * JD-Core Version:    0.7.0.1
 */