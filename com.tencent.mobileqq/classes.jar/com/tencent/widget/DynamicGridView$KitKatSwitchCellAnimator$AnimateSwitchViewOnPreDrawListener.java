package com.tencent.widget;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;

class DynamicGridView$KitKatSwitchCellAnimator$AnimateSwitchViewOnPreDrawListener
  implements ViewTreeObserver.OnPreDrawListener
{
  private final View b;
  private final int c;
  private final int d;
  
  DynamicGridView$KitKatSwitchCellAnimator$AnimateSwitchViewOnPreDrawListener(DynamicGridView.KitKatSwitchCellAnimator paramKitKatSwitchCellAnimator, View paramView, int paramInt1, int paramInt2)
  {
    this.b = paramView;
    this.c = paramInt1;
    this.d = paramInt2;
  }
  
  public boolean onPreDraw()
  {
    this.a.a.getViewTreeObserver().removeOnPreDrawListener(this);
    DynamicGridView.a(this.a.a, DynamicGridView.c(this.a.a) + DynamicGridView.KitKatSwitchCellAnimator.a(this.a));
    DynamicGridView.b(this.a.a, DynamicGridView.d(this.a.a) + DynamicGridView.KitKatSwitchCellAnimator.b(this.a));
    View localView = this.b;
    if (localView != null) {
      localView.setVisibility(0);
    }
    DynamicGridView.b(this.a.a, this.a.a.b(DynamicGridView.f(this.a.a)));
    if (DynamicGridView.e(this.a.a) != null) {
      DynamicGridView.e(this.a.a).setVisibility(4);
    }
    DynamicGridView.a(this.a.a, this.c, this.d);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.DynamicGridView.KitKatSwitchCellAnimator.AnimateSwitchViewOnPreDrawListener
 * JD-Core Version:    0.7.0.1
 */