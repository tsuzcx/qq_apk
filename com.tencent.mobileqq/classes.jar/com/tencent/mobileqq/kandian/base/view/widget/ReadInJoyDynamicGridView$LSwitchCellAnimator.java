package com.tencent.mobileqq.kandian.base.view.widget;

import android.view.ViewTreeObserver;

class ReadInJoyDynamicGridView$LSwitchCellAnimator
  implements ReadInJoyDynamicGridView.SwitchCellAnimator
{
  private int b;
  private int c;
  
  public ReadInJoyDynamicGridView$LSwitchCellAnimator(ReadInJoyDynamicGridView paramReadInJoyDynamicGridView, int paramInt1, int paramInt2)
  {
    this.c = paramInt1;
    this.b = paramInt2;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.a.getViewTreeObserver().addOnPreDrawListener(new ReadInJoyDynamicGridView.LSwitchCellAnimator.AnimateSwitchViewOnPreDrawListener(this, paramInt1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.ReadInJoyDynamicGridView.LSwitchCellAnimator
 * JD-Core Version:    0.7.0.1
 */