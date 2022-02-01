package com.tencent.mobileqq.colornote.smallscreen;

import android.animation.Animator;
import android.graphics.Point;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.colornote.anim.MusicDanceImageView;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class ColorNoteSmallScreenRelativeLayout$5
  extends D8SafeAnimatorListener
{
  ColorNoteSmallScreenRelativeLayout$5(ColorNoteSmallScreenRelativeLayout paramColorNoteSmallScreenRelativeLayout) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = (LinearLayout.LayoutParams)ColorNoteSmallScreenRelativeLayout.h(this.a).getLayoutParams();
    if (!this.a.g())
    {
      paramAnimator.leftMargin = DisplayUtil.a(this.a.getContext(), 14.5F);
      paramAnimator.rightMargin = 0;
    }
    ColorNoteSmallScreenRelativeLayout.h(this.a).setLayoutParams(paramAnimator);
    ColorNoteSmallScreenRelativeLayout.i(this.a).setVisibility(0);
    ((LinearLayout.LayoutParams)ColorNoteSmallScreenRelativeLayout.i(this.a).getLayoutParams()).leftMargin = DisplayUtil.a(this.a.getContext(), 13.5F);
    ColorNoteSmallScreenRelativeLayout.j(this.a).x = this.a.getRealLeft();
    paramAnimator = this.a;
    int i;
    if (ColorNoteSmallScreenRelativeLayout.j(paramAnimator).x < 0) {
      i = 0;
    } else {
      i = 1;
    }
    ColorNoteSmallScreenRelativeLayout.b(paramAnimator, i);
    ColorNoteSmallScreenRelativeLayout.d(this.a, false);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    ColorNoteSmallScreenRelativeLayout.d(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenRelativeLayout.5
 * JD-Core Version:    0.7.0.1
 */