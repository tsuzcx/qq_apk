package com.tencent.mobileqq.multiaio;

import com.tencent.mobileqq.multiaio.widget.MultiAIOBaseViewPager.FlingListener;
import com.tencent.mobileqq.multiaio.widget.TabPageIndicator;

class MultiAIOFragment$5
  implements MultiAIOBaseViewPager.FlingListener
{
  MultiAIOFragment$5(MultiAIOFragment paramMultiAIOFragment) {}
  
  public void a(int paramInt)
  {
    MultiAIOFragment.c(this.a).setViewPagerBusy(false);
    MultiAIOFragment.c(this.a).setScrollState(2);
    MultiAIOFragment.c(this.a).fling(-paramInt);
  }
  
  public boolean a()
  {
    return MultiAIOFragment.c(this.a).a();
  }
  
  public void b()
  {
    MultiAIOFragment.c(this.a).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multiaio.MultiAIOFragment.5
 * JD-Core Version:    0.7.0.1
 */