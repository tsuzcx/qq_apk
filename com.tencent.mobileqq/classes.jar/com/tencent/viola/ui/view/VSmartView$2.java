package com.tencent.viola.ui.view;

import java.util.List;

class VSmartView$2
  extends VPageSliderView.VPagerSliderScrollListener
{
  VSmartView$2(VSmartView paramVSmartView) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    VSmartView.access$200(this.this$0);
  }
  
  public void onPageSelected(int paramInt)
  {
    int i = 0;
    while (i < VSmartView.access$300(this.this$0).size())
    {
      VSmartView.RecyclerViewWrapper localRecyclerViewWrapper = (VSmartView.RecyclerViewWrapper)VSmartView.access$300(this.this$0).get(i);
      boolean bool;
      if (i != paramInt) {
        bool = true;
      } else {
        bool = false;
      }
      localRecyclerViewWrapper.ignoreScrollEvent = bool;
      localRecyclerViewWrapper.lastContentOffset = -1;
      i += 1;
    }
    VSmartView.access$402(this.this$0, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.view.VSmartView.2
 * JD-Core Version:    0.7.0.1
 */