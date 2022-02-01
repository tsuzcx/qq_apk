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
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Indicator onPageScrollStateChanged() called with: state = [");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("]");
      QLog.d("MultiCardFragment", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return;
        }
        MultiCardFragment.b(this.a, true);
        MultiCardFragment.a(this.a, false);
        return;
      }
      MultiCardFragment.b(this.a, true);
      MultiCardFragment.a(this.a, false);
      if (MultiCardFragment.a(this.a) != null)
      {
        localObject = this.a;
        MultiCardFragment.a((MultiCardFragment)localObject, MultiCardFragment.a((MultiCardFragment)localObject).a());
      }
    }
    else
    {
      MultiCardFragment.a(this.a);
      MultiCardFragment.a(this.a, true);
      if ((MultiCardFragment.a(this.a) != null) && (MultiCardFragment.a(this.a).a() > MultiCardFragment.a(this.a).a()))
      {
        MultiCardFragment.a(this.a).b(MultiCardFragment.a(this.a).a());
        MultiCardFragment.a(this.a).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardFragment.8
 * JD-Core Version:    0.7.0.1
 */