package com.tencent.mobileqq.kandian.base.view.widget;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;

class ReadInJoyDynamicGridView$LSwitchCellAnimator$AnimateSwitchViewOnPreDrawListener
  implements ViewTreeObserver.OnPreDrawListener
{
  private final int b;
  private final int c;
  
  ReadInJoyDynamicGridView$LSwitchCellAnimator$AnimateSwitchViewOnPreDrawListener(ReadInJoyDynamicGridView.LSwitchCellAnimator paramLSwitchCellAnimator, int paramInt1, int paramInt2)
  {
    this.b = paramInt1;
    this.c = paramInt2;
  }
  
  public boolean onPreDraw()
  {
    this.a.a.getViewTreeObserver().removeOnPreDrawListener(this);
    ReadInJoyDynamicGridView.a(this.a.a, ReadInJoyDynamicGridView.c(this.a.a) + ReadInJoyDynamicGridView.LSwitchCellAnimator.a(this.a));
    ReadInJoyDynamicGridView.b(this.a.a, ReadInJoyDynamicGridView.d(this.a.a) + ReadInJoyDynamicGridView.LSwitchCellAnimator.b(this.a));
    if (ReadInJoyDynamicGridView.e(this.a.a) != null) {
      ReadInJoyDynamicGridView.e(this.a.a).setVisibility(0);
    }
    ReadInJoyDynamicGridView.b(this.a.a, this.a.a.b(ReadInJoyDynamicGridView.f(this.a.a)));
    if (ReadInJoyDynamicGridView.e(this.a.a) != null) {
      ReadInJoyDynamicGridView.e(this.a.a).setVisibility(4);
    }
    ReadInJoyDynamicGridView.a(this.a.a, this.b, this.c);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.ReadInJoyDynamicGridView.LSwitchCellAnimator.AnimateSwitchViewOnPreDrawListener
 * JD-Core Version:    0.7.0.1
 */