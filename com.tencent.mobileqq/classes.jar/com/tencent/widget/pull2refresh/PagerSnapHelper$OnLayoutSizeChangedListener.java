package com.tencent.widget.pull2refresh;

import android.view.View;
import android.view.View.OnLayoutChangeListener;

class PagerSnapHelper$OnLayoutSizeChangedListener
  implements View.OnLayoutChangeListener
{
  private int b = 0;
  private int c = 0;
  
  private PagerSnapHelper$OnLayoutSizeChangedListener(PagerSnapHelper paramPagerSnapHelper) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if ((this.b > 0) && (this.c > 0)) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    if ((paramInt1 != 0) && (!PagerSnapHelper.n(this.a)) && ((this.b != paramView.getHeight()) || (this.c != paramView.getWidth())))
    {
      PagerSnapHelper localPagerSnapHelper = this.a;
      localPagerSnapHelper.g(PagerSnapHelper.j(localPagerSnapHelper));
    }
    this.b = paramView.getHeight();
    this.c = paramView.getWidth();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.pull2refresh.PagerSnapHelper.OnLayoutSizeChangedListener
 * JD-Core Version:    0.7.0.1
 */