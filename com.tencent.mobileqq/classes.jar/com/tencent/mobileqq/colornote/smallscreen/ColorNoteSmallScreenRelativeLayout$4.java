package com.tencent.mobileqq.colornote.smallscreen;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Point;
import android.widget.LinearLayout.LayoutParams;

class ColorNoteSmallScreenRelativeLayout$4
  implements ValueAnimator.AnimatorUpdateListener
{
  ColorNoteSmallScreenRelativeLayout$4(ColorNoteSmallScreenRelativeLayout paramColorNoteSmallScreenRelativeLayout1, ColorNoteSmallScreenRelativeLayout paramColorNoteSmallScreenRelativeLayout2, Point paramPoint, LinearLayout.LayoutParams paramLayoutParams, int paramInt) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    int i = (int)(ColorNoteSmallScreenRelativeLayout.f(this.e) / 2 * f);
    paramValueAnimator = this.e;
    int j = ColorNoteSmallScreenRelativeLayout.a(paramValueAnimator, paramValueAnimator.getRealWidth());
    int k = ColorNoteSmallScreenRelativeLayout.g(this.e);
    if (ColorNoteSmallScreenRelativeLayout.a(this.e) != null) {
      ColorNoteSmallScreenRelativeLayout.a(this.e).a(this.a, this.b.x - i, this.b.y, this.b.x + j - i, this.b.y + k);
    }
    this.c.leftMargin = (this.d + i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenRelativeLayout.4
 * JD-Core Version:    0.7.0.1
 */