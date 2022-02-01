package com.tencent.mobileqq.multicard;

import com.tencent.mobileqq.multiaio.widget.MultiAIOBaseViewPager.FlingListener;

class MultiCardFragment$5
  implements MultiAIOBaseViewPager.FlingListener
{
  MultiCardFragment$5(MultiCardFragment paramMultiCardFragment) {}
  
  public void a()
  {
    if (MultiCardFragment.a(this.a) != null) {
      MultiCardFragment.a(this.a).a();
    }
  }
  
  public void a(int paramInt)
  {
    if (MultiCardFragment.a(this.a) != null)
    {
      MultiCardFragment.a(this.a).setViewPagerBusy(false);
      MultiCardFragment.a(this.a).setScrollState(2);
      MultiCardFragment.a(this.a).fling(-paramInt);
    }
  }
  
  public boolean a()
  {
    if (MultiCardFragment.a(this.a) != null) {
      return MultiCardFragment.a(this.a).a();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardFragment.5
 * JD-Core Version:    0.7.0.1
 */