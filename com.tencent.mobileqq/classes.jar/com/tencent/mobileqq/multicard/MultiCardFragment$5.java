package com.tencent.mobileqq.multicard;

import com.tencent.mobileqq.multiaio.widget.MultiAIOBaseViewPager.FlingListener;

class MultiCardFragment$5
  implements MultiAIOBaseViewPager.FlingListener
{
  MultiCardFragment$5(MultiCardFragment paramMultiCardFragment) {}
  
  public void a(int paramInt)
  {
    if (MultiCardFragment.b(this.a) != null)
    {
      MultiCardFragment.b(this.a).setViewPagerBusy(false);
      MultiCardFragment.b(this.a).setScrollState(2);
      MultiCardFragment.b(this.a).fling(-paramInt);
    }
  }
  
  public boolean a()
  {
    if (MultiCardFragment.b(this.a) != null) {
      return MultiCardFragment.b(this.a).a();
    }
    return true;
  }
  
  public void b()
  {
    if (MultiCardFragment.b(this.a) != null) {
      MultiCardFragment.b(this.a).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardFragment.5
 * JD-Core Version:    0.7.0.1
 */