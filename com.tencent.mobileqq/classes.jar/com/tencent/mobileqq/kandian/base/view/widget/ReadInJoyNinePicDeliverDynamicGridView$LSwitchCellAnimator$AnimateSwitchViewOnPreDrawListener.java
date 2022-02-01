package com.tencent.mobileqq.kandian.base.view.widget;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;

class ReadInJoyNinePicDeliverDynamicGridView$LSwitchCellAnimator$AnimateSwitchViewOnPreDrawListener
  implements ViewTreeObserver.OnPreDrawListener
{
  private final int b;
  private final int c;
  
  ReadInJoyNinePicDeliverDynamicGridView$LSwitchCellAnimator$AnimateSwitchViewOnPreDrawListener(ReadInJoyNinePicDeliverDynamicGridView.LSwitchCellAnimator paramLSwitchCellAnimator, int paramInt1, int paramInt2)
  {
    this.b = paramInt1;
    this.c = paramInt2;
  }
  
  public boolean onPreDraw()
  {
    this.a.a.getViewTreeObserver().removeOnPreDrawListener(this);
    ReadInJoyNinePicDeliverDynamicGridView.a(this.a.a, ReadInJoyNinePicDeliverDynamicGridView.c(this.a.a) + ReadInJoyNinePicDeliverDynamicGridView.LSwitchCellAnimator.a(this.a));
    ReadInJoyNinePicDeliverDynamicGridView.b(this.a.a, ReadInJoyNinePicDeliverDynamicGridView.d(this.a.a) + ReadInJoyNinePicDeliverDynamicGridView.LSwitchCellAnimator.b(this.a));
    if (ReadInJoyNinePicDeliverDynamicGridView.e(this.a.a) != null) {
      ReadInJoyNinePicDeliverDynamicGridView.e(this.a.a).setVisibility(0);
    }
    ReadInJoyNinePicDeliverDynamicGridView.b(this.a.a, this.a.a.b(ReadInJoyNinePicDeliverDynamicGridView.f(this.a.a)));
    if (ReadInJoyNinePicDeliverDynamicGridView.e(this.a.a) != null) {
      ReadInJoyNinePicDeliverDynamicGridView.e(this.a.a).setVisibility(4);
    }
    ReadInJoyNinePicDeliverDynamicGridView.a(this.a.a, this.b, this.c);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.ReadInJoyNinePicDeliverDynamicGridView.LSwitchCellAnimator.AnimateSwitchViewOnPreDrawListener
 * JD-Core Version:    0.7.0.1
 */