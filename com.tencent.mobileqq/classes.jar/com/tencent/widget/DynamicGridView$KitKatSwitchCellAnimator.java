package com.tencent.widget;

import android.view.ViewTreeObserver;

class DynamicGridView$KitKatSwitchCellAnimator
  implements DynamicGridView.SwitchCellAnimator
{
  private int b;
  private int c;
  
  public DynamicGridView$KitKatSwitchCellAnimator(DynamicGridView paramDynamicGridView, int paramInt1, int paramInt2)
  {
    this.c = paramInt1;
    this.b = paramInt2;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.a.getViewTreeObserver().addOnPreDrawListener(new DynamicGridView.KitKatSwitchCellAnimator.AnimateSwitchViewOnPreDrawListener(this, DynamicGridView.e(this.a), paramInt1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.DynamicGridView.KitKatSwitchCellAnimator
 * JD-Core Version:    0.7.0.1
 */