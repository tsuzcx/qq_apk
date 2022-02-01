package com.tencent.mobileqq.multicard;

import com.tencent.mobileqq.multiaio.widget.MultiAIOBaseViewPager.SimpleOnPageChangeListener;
import com.tencent.mobileqq.multiaio.widget.MultiAIOViewPager;
import com.tencent.qphone.base.util.QLog;

class MultiCardFragment$6
  extends MultiAIOBaseViewPager.SimpleOnPageChangeListener
{
  MultiCardFragment$6(MultiCardFragment paramMultiCardFragment) {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPageSelected() called with: position = [");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("]");
      QLog.d("MultiCardFragment", 2, localStringBuilder.toString());
    }
  }
  
  public void b(int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ViewPager onPageScrollStateChanged() called with: state = [");
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
      if (MultiCardFragment.g(this.a) != null)
      {
        localObject = this.a;
        MultiCardFragment.a((MultiCardFragment)localObject, MultiCardFragment.g((MultiCardFragment)localObject).getCurrentItem());
      }
    }
    else
    {
      MultiCardFragment.e(this.a);
      MultiCardFragment.a(this.a, true);
      if ((MultiCardFragment.g(this.a) != null) && (MultiCardFragment.g(this.a).getCurrentItem() > MultiCardFragment.d(this.a).a()))
      {
        MultiCardFragment.d(this.a).b(MultiCardFragment.g(this.a).getCurrentItem());
        MultiCardFragment.d(this.a).b();
      }
      if (MultiCardFragment.b(this.a) != null) {
        MultiCardFragment.b(this.a).setViewPagerBusy(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardFragment.6
 * JD-Core Version:    0.7.0.1
 */