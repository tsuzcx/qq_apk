package com.tencent.mobileqq.multiaio;

import com.tencent.mobileqq.multiaio.widget.MultiAIOViewPager;
import com.tencent.mobileqq.multiaio.widget.TabPageIndicator;
import com.tencent.mobileqq.multiaio.widget.TabPageIndicator.OnActionUpNotFling;
import com.tencent.qphone.base.util.QLog;

class MultiAIOFragment$9
  implements TabPageIndicator.OnActionUpNotFling
{
  MultiAIOFragment$9(MultiAIOFragment paramMultiAIOFragment) {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onActionUpNotFling() called with: initialVelocity = [");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("]");
      QLog.d("MultiAioFragment", 2, localStringBuilder.toString());
    }
    MultiAIOFragment.c(this.a).setViewPagerBusy(true);
    MultiAIOFragment.d(this.a).e(paramInt);
    if (MultiAIOFragment.d(this.a).getScrollState() == 0) {
      MultiAIOFragment.c(this.a).setViewPagerBusy(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multiaio.MultiAIOFragment.9
 * JD-Core Version:    0.7.0.1
 */