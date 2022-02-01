package com.tencent.widget;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;

class DynamicGridView$LSwitchCellAnimator$AnimateSwitchViewOnPreDrawListener
  implements ViewTreeObserver.OnPreDrawListener
{
  private final int b;
  private final int c;
  
  DynamicGridView$LSwitchCellAnimator$AnimateSwitchViewOnPreDrawListener(DynamicGridView.LSwitchCellAnimator paramLSwitchCellAnimator, int paramInt1, int paramInt2)
  {
    this.b = paramInt1;
    this.c = paramInt2;
  }
  
  public boolean onPreDraw()
  {
    this.a.a.getViewTreeObserver().removeOnPreDrawListener(this);
    DynamicGridView.a(this.a.a, DynamicGridView.c(this.a.a) + DynamicGridView.LSwitchCellAnimator.a(this.a));
    DynamicGridView.b(this.a.a, DynamicGridView.d(this.a.a) + DynamicGridView.LSwitchCellAnimator.b(this.a));
    if (DynamicGridView.e(this.a.a) != null) {
      DynamicGridView.e(this.a.a).setVisibility(0);
    }
    DynamicGridView.b(this.a.a, this.a.a.b(DynamicGridView.f(this.a.a)));
    if (DynamicGridView.e(this.a.a) != null) {
      DynamicGridView.e(this.a.a).setVisibility(4);
    }
    DynamicGridView.a(this.a.a, this.b, this.c);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.DynamicGridView.LSwitchCellAnimator.AnimateSwitchViewOnPreDrawListener
 * JD-Core Version:    0.7.0.1
 */