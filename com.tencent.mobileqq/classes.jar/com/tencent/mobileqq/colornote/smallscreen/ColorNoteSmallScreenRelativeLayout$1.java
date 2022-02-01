package com.tencent.mobileqq.colornote.smallscreen;

import android.animation.Animator;
import android.view.ViewPropertyAnimator;
import android.widget.LinearLayout;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;
import java.util.Iterator;
import java.util.List;

class ColorNoteSmallScreenRelativeLayout$1
  extends D8SafeAnimatorListener
{
  ColorNoteSmallScreenRelativeLayout$1(ColorNoteSmallScreenRelativeLayout paramColorNoteSmallScreenRelativeLayout, LinearLayout paramLinearLayout) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ColorNoteSmallScreenRelativeLayout.c(this.b, false);
    paramAnimator = ColorNoteSmallScreenRelativeLayout.d(this.b).iterator();
    while (paramAnimator.hasNext()) {
      ((ColorNote)paramAnimator.next()).animate = false;
    }
    this.b.f();
    this.a.animate().setListener(null).translationX(0.0F).setDuration(200L).start();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenRelativeLayout.1
 * JD-Core Version:    0.7.0.1
 */