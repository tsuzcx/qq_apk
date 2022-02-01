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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPageSelected() called with: position = [");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("]");
      QLog.d("MultiAioFragment", 2, localStringBuilder.toString());
    }
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ViewPager onPageScrollStateChanged() called with: state = [");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("]");
      QLog.d("MultiAioFragment", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return;
        }
        MultiAIOFragment.c(this.a);
        return;
      }
      MultiAIOFragment.c(this.a);
      return;
    }
    Object localObject = this.a;
    MultiAIOFragment.a((MultiAIOFragment)localObject, MultiAIOFragment.a((MultiAIOFragment)localObject).a());
    MultiAIOFragment.a(this.a).setViewPagerBusy(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.multiaio.MultiAIOFragment.6
 * JD-Core Version:    0.7.0.1
 */