package com.tencent.mobileqq.multiaio;

import com.tencent.mobileqq.multiaio.widget.MultiAIOBaseViewPager;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

class MultiAIOItemFragment$4
  implements AbsListView.OnScrollListener
{
  private boolean c;
  
  MultiAIOItemFragment$4(MultiAIOItemFragment paramMultiAIOItemFragment, AbsListView.OnScrollListener paramOnScrollListener) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.a.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.a.onScrollStateChanged(paramAbsListView, paramInt);
    if (paramInt == 0)
    {
      paramAbsListView = MultiAIOItemFragment.b(this.b);
      if ((paramAbsListView != null) && (paramAbsListView.getCurrentItem() == MultiAIOItemFragment.c(this.b)) && (!this.c))
      {
        MultiAIOFragment.a("0X8009F80", 0);
        this.c = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multiaio.MultiAIOItemFragment.4
 * JD-Core Version:    0.7.0.1
 */