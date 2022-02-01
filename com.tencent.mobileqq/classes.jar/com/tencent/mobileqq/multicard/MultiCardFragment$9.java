package com.tencent.mobileqq.multicard;

import com.tencent.mobileqq.multiaio.widget.MultiAIOViewPager;
import com.tencent.mobileqq.multiaio.widget.TabPageIndicator.OnActionUpNotFling;
import com.tencent.qphone.base.util.QLog;

class MultiCardFragment$9
  implements TabPageIndicator.OnActionUpNotFling
{
  MultiCardFragment$9(MultiCardFragment paramMultiCardFragment) {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onActionUpNotFling() called with: initialVelocity = [");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("]");
      QLog.d("MultiCardFragment", 2, localStringBuilder.toString());
    }
    if (MultiCardFragment.a(this.a) != null) {
      MultiCardFragment.a(this.a).setViewPagerBusy(true);
    }
    if (MultiCardFragment.a(this.a) != null)
    {
      MultiCardFragment.a(this.a).c(paramInt);
      if ((MultiCardFragment.a(this.a).c() == 0) && (MultiCardFragment.a(this.a) != null)) {
        MultiCardFragment.a(this.a).setViewPagerBusy(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardFragment.9
 * JD-Core Version:    0.7.0.1
 */