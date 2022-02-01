package com.tencent.mobileqq.receipt;

import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.mobileqq.widget.TabBarView.OnTabChangeListener;

class ReceiptMessageReadMemberListContainerFragment$7
  implements TabBarView.OnTabChangeListener
{
  ReceiptMessageReadMemberListContainerFragment$7(ReceiptMessageReadMemberListContainerFragment paramReceiptMessageReadMemberListContainerFragment) {}
  
  public void onTabSelected(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {
      return;
    }
    ReceiptMessageReadMemberListContainerFragment.a(this.a).setCurrentItem(paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.receipt.ReceiptMessageReadMemberListContainerFragment.7
 * JD-Core Version:    0.7.0.1
 */