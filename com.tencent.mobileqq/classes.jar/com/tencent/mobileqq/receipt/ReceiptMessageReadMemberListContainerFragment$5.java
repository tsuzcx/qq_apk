package com.tencent.mobileqq.receipt;

import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.Comparator;

class ReceiptMessageReadMemberListContainerFragment$5
  implements Comparator<ReceiptMessageReadMemberListFragment.MemberInfo>
{
  ReceiptMessageReadMemberListContainerFragment$5(ReceiptMessageReadMemberListContainerFragment paramReceiptMessageReadMemberListContainerFragment) {}
  
  public int a(ReceiptMessageReadMemberListFragment.MemberInfo paramMemberInfo1, ReceiptMessageReadMemberListFragment.MemberInfo paramMemberInfo2)
  {
    return ChnToSpell.a(paramMemberInfo1.b, 1).compareTo(ChnToSpell.a(paramMemberInfo2.b, 1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.receipt.ReceiptMessageReadMemberListContainerFragment.5
 * JD-Core Version:    0.7.0.1
 */