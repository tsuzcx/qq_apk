package com.tencent.mobileqq.multicard;

import com.tencent.mobileqq.multiaio.widget.MultiAIOViewPager;
import com.tencent.mobileqq.multiaio.widget.TabPageIndicator.OnPageChangeListener;
import com.tencent.qphone.base.util.QLog;

class MultiCardFragment$8
  implements TabPageIndicator.OnPageChangeListener
{
  MultiCardFragment$8(MultiCardFragment paramMultiCardFragment) {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardFragment", 2, "Indicator onPageScrollStateChanged() called with: state = [" + paramInt + "]");
    }
    switch (paramInt)
    {
    default: 
    case 0: 
    case 1: 
      do
      {
        do
        {
          return;
          MultiCardFragment.a(this.a);
          MultiCardFragment.a(this.a, true);
        } while ((MultiCardFragment.a(this.a) == null) || (MultiCardFragment.a(this.a).a() <= MultiCardFragment.a(this.a).a()));
        MultiCardFragment.a(this.a).b(MultiCardFragment.a(this.a).a());
        MultiCardFragment.a(this.a).a();
        return;
        MultiCardFragment.b(this.a, true);
        MultiCardFragment.a(this.a, false);
      } while (MultiCardFragment.a(this.a) == null);
      MultiCardFragment.a(this.a, MultiCardFragment.a(this.a).a());
      return;
    }
    MultiCardFragment.b(this.a, true);
    MultiCardFragment.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardFragment.8
 * JD-Core Version:    0.7.0.1
 */