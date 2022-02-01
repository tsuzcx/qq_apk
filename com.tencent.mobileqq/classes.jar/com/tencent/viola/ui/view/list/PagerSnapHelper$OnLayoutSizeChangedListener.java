package com.tencent.viola.ui.view.list;

import android.view.View;
import android.view.View.OnLayoutChangeListener;

class PagerSnapHelper$OnLayoutSizeChangedListener
  implements View.OnLayoutChangeListener
{
  private int lastHeight = 0;
  private int lastWidth = 0;
  
  private PagerSnapHelper$OnLayoutSizeChangedListener(PagerSnapHelper paramPagerSnapHelper) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if ((this.lastHeight > 0) && (this.lastWidth > 0)) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    if ((paramInt1 != 0) && (!PagerSnapHelper.access$100(this.this$0)) && ((this.lastHeight != paramView.getHeight()) || (this.lastWidth != paramView.getWidth())))
    {
      PagerSnapHelper localPagerSnapHelper = this.this$0;
      localPagerSnapHelper.offsetToTargetPosition(PagerSnapHelper.access$1200(localPagerSnapHelper));
    }
    this.lastHeight = paramView.getHeight();
    this.lastWidth = paramView.getWidth();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.view.list.PagerSnapHelper.OnLayoutSizeChangedListener
 * JD-Core Version:    0.7.0.1
 */