package com.tencent.mobileqq.kandian.base.view.widget;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;

class ReadInJoyDynamicGridView$KitKatSwitchCellAnimator$AnimateSwitchViewOnPreDrawListener
  implements ViewTreeObserver.OnPreDrawListener
{
  private final View b;
  private final int c;
  private final int d;
  
  ReadInJoyDynamicGridView$KitKatSwitchCellAnimator$AnimateSwitchViewOnPreDrawListener(ReadInJoyDynamicGridView.KitKatSwitchCellAnimator paramKitKatSwitchCellAnimator, View paramView, int paramInt1, int paramInt2)
  {
    this.b = paramView;
    this.c = paramInt1;
    this.d = paramInt2;
  }
  
  public boolean onPreDraw()
  {
    this.a.a.getViewTreeObserver().removeOnPreDrawListener(this);
    ReadInJoyDynamicGridView.a(this.a.a, ReadInJoyDynamicGridView.c(this.a.a) + ReadInJoyDynamicGridView.KitKatSwitchCellAnimator.a(this.a));
    ReadInJoyDynamicGridView.b(this.a.a, ReadInJoyDynamicGridView.d(this.a.a) + ReadInJoyDynamicGridView.KitKatSwitchCellAnimator.b(this.a));
    View localView = this.b;
    if (localView != null) {
      localView.setVisibility(0);
    }
    ReadInJoyDynamicGridView.b(this.a.a, this.a.a.b(ReadInJoyDynamicGridView.f(this.a.a)));
    if (ReadInJoyDynamicGridView.e(this.a.a) != null) {
      ReadInJoyDynamicGridView.e(this.a.a).setVisibility(4);
    }
    ReadInJoyDynamicGridView.a(this.a.a, this.c, this.d);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.ReadInJoyDynamicGridView.KitKatSwitchCellAnimator.AnimateSwitchViewOnPreDrawListener
 * JD-Core Version:    0.7.0.1
 */