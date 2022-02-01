package com.tencent.mobileqq.multiaio;

import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.multiaio.widget.MultiAIOBaseViewPager.SimpleOnPageChangeListener;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ListView;

class MultiAIOItemFragment$5
  extends MultiAIOBaseViewPager.SimpleOnPageChangeListener
{
  MultiAIOItemFragment$5(MultiAIOItemFragment paramMultiAIOItemFragment, AbsListView.OnScrollListener paramOnScrollListener, ListView paramListView) {}
  
  public void b(int paramInt)
  {
    super.b(paramInt);
    int i = 2;
    boolean bool;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        bool = false;
        paramInt = 0;
      }
      else
      {
        bool = true;
        paramInt = i;
      }
    }
    else
    {
      bool = false;
      paramInt = 1;
    }
    this.a.onScrollStateChanged(this.b, paramInt);
    Object localObject = this.b;
    if ((localObject instanceof ChatXListView))
    {
      localObject = (ChatXListView)localObject;
      int[] arrayOfInt = MultiAIOItemFragment.d(this.c);
      ((ChatXListView)localObject).setDisableLayout(bool, arrayOfInt[0], arrayOfInt[1]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multiaio.MultiAIOItemFragment.5
 * JD-Core Version:    0.7.0.1
 */