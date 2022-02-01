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
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Indicator onPageScrollStateChanged() called with: state = [");
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.multiaio.MultiAIOFragment.8
 * JD-Core Version:    0.7.0.1
 */