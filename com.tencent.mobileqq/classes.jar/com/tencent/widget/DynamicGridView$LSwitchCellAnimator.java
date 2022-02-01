package com.tencent.widget;

import android.view.ViewTreeObserver;

class DynamicGridView$LSwitchCellAnimator
  implements DynamicGridView.SwitchCellAnimator
{
  private int b;
  private int c;
  
  public DynamicGridView$LSwitchCellAnimator(DynamicGridView paramDynamicGridView, int paramInt1, int paramInt2)
  {
    this.c = paramInt1;
    this.b = paramInt2;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.a.getViewTreeObserver().addOnPreDrawListener(new DynamicGridView.LSwitchCellAnimator.AnimateSwitchViewOnPreDrawListener(this, paramInt1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.DynamicGridView.LSwitchCellAnimator
 * JD-Core Version:    0.7.0.1
 */