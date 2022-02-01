package com.tencent.mobileqq.multiaio;

import com.tencent.mobileqq.multiaio.widget.MultiAIOViewPager;
import com.tencent.mobileqq.multiaio.widget.TabPageIndicator.OnPageChangeListener;
import com.tencent.qphone.base.util.QLog;

class MultiAIOFragment$8
  implements TabPageIndicator.OnPageChangeListener
{
  MultiAIOFragment$8(MultiAIOFragment paramMultiAIOFragment) {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAioFragment", 2, "Indicator onPageScrollStateChanged() called with: state = [" + paramInt + "]");
    }
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      MultiAIOFragment.a(this.a, MultiAIOFragment.a(this.a).a());
      return;
    case 1: 
      MultiAIOFragment.c(this.a);
      return;
    }
    MultiAIOFragment.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.multiaio.MultiAIOFragment.8
 * JD-Core Version:    0.7.0.1
 */