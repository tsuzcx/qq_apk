package com.tencent.mobileqq.multiaio;

import com.tencent.mobileqq.multiaio.widget.MultiAIOBaseViewPager.SimpleOnPageChangeListener;
import com.tencent.mobileqq.multiaio.widget.MultiAIOViewPager;
import com.tencent.mobileqq.multiaio.widget.TabPageIndicator;
import com.tencent.qphone.base.util.QLog;

class MultiAIOFragment$6
  extends MultiAIOBaseViewPager.SimpleOnPageChangeListener
{
  MultiAIOFragment$6(MultiAIOFragment paramMultiAIOFragment) {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAioFragment", 2, "onPageSelected() called with: position = [" + paramInt + "]");
    }
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAioFragment", 2, "ViewPager onPageScrollStateChanged() called with: state = [" + paramInt + "]");
    }
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      MultiAIOFragment.a(this.a, MultiAIOFragment.a(this.a).a());
      MultiAIOFragment.a(this.a).setViewPagerBusy(false);
      return;
    case 1: 
      MultiAIOFragment.c(this.a);
      return;
    }
    MultiAIOFragment.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.multiaio.MultiAIOFragment.6
 * JD-Core Version:    0.7.0.1
 */