package com.tencent.mobileqq.receipt;

import java.util.Comparator;

class ReceiptMessageReadMemberListContainerFragment$4
  implements Comparator<ReceiptMessageReadMemberListFragment.MemberInfo>
{
  ReceiptMessageReadMemberListContainerFragment$4(ReceiptMessageReadMemberListContainerFragment paramReceiptMessageReadMemberListContainerFragment) {}
  
  public int a(ReceiptMessageReadMemberListFragment.MemberInfo paramMemberInfo1, ReceiptMessageReadMemberListFragment.MemberInfo paramMemberInfo2)
  {
    if (paramMemberInfo1.c == paramMemberInfo2.c) {
      return 0;
    }
    if (paramMemberInfo1.c < paramMemberInfo2.c) {
      return -1;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.receipt.ReceiptMessageReadMemberListContainerFragment.4
 * JD-Core Version:    0.7.0.1
 */