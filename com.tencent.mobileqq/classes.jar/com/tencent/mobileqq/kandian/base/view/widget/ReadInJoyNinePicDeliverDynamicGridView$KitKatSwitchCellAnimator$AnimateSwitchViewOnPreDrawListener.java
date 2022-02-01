package com.tencent.mobileqq.kandian.base.view.widget;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;

class ReadInJoyNinePicDeliverDynamicGridView$KitKatSwitchCellAnimator$AnimateSwitchViewOnPreDrawListener
  implements ViewTreeObserver.OnPreDrawListener
{
  private final View b;
  private final int c;
  private final int d;
  
  ReadInJoyNinePicDeliverDynamicGridView$KitKatSwitchCellAnimator$AnimateSwitchViewOnPreDrawListener(ReadInJoyNinePicDeliverDynamicGridView.KitKatSwitchCellAnimator paramKitKatSwitchCellAnimator, View paramView, int paramInt1, int paramInt2)
  {
    this.b = paramView;
    this.c = paramInt1;
    this.d = paramInt2;
  }
  
  public boolean onPreDraw()
  {
    this.a.a.getViewTreeObserver().removeOnPreDrawListener(this);
    ReadInJoyNinePicDeliverDynamicGridView.a(this.a.a, ReadInJoyNinePicDeliverDynamicGridView.c(this.a.a) + ReadInJoyNinePicDeliverDynamicGridView.KitKatSwitchCellAnimator.a(this.a));
    ReadInJoyNinePicDeliverDynamicGridView.b(this.a.a, ReadInJoyNinePicDeliverDynamicGridView.d(this.a.a) + ReadInJoyNinePicDeliverDynamicGridView.KitKatSwitchCellAnimator.b(this.a));
    View localView = this.b;
    if (localView != null) {
      localView.setVisibility(0);
    }
    ReadInJoyNinePicDeliverDynamicGridView.b(this.a.a, this.a.a.b(ReadInJoyNinePicDeliverDynamicGridView.f(this.a.a)));
    if (ReadInJoyNinePicDeliverDynamicGridView.e(this.a.a) != null) {
      ReadInJoyNinePicDeliverDynamicGridView.e(this.a.a).setVisibility(4);
    }
    ReadInJoyNinePicDeliverDynamicGridView.a(this.a.a, this.c, this.d);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.ReadInJoyNinePicDeliverDynamicGridView.KitKatSwitchCellAnimator.AnimateSwitchViewOnPreDrawListener
 * JD-Core Version:    0.7.0.1
 */