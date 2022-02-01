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
    if (QLog.isColorLevel()) {
      QLog.d("MultiAioFragment", 2, "onActionUpNotFling() called with: initialVelocity = [" + paramInt + "]");
    }
    MultiAIOFragment.a(this.a).setViewPagerBusy(true);
    MultiAIOFragment.a(this.a).c(paramInt);
    if (MultiAIOFragment.a(this.a).c() == 0) {
      MultiAIOFragment.a(this.a).setViewPagerBusy(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.multiaio.MultiAIOFragment.9
 * JD-Core Version:    0.7.0.1
 */