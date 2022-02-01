package com.tencent.mobileqq.receipt;

import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.mobileqq.widget.TabBarView;

class ReceiptMessageReadMemberListContainerFragment$8
  implements ViewPager.OnPageChangeListener
{
  ReceiptMessageReadMemberListContainerFragment$8(ReceiptMessageReadMemberListContainerFragment paramReceiptMessageReadMemberListContainerFragment) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    ReceiptMessageReadMemberListContainerFragment.m(this.a).setSelectedTab(paramInt, true);
    if (paramInt == 0)
    {
      ReceiptMessageReadMemberListContainerFragment.l(this.a).requestParentDisallowInterecptTouchEvent(false);
      return;
    }
    ReceiptMessageReadMemberListContainerFragment.l(this.a).requestParentDisallowInterecptTouchEvent(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.receipt.ReceiptMessageReadMemberListContainerFragment.8
 * JD-Core Version:    0.7.0.1
 */