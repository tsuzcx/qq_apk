package com.tencent.mobileqq.receipt;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.tencent.mobileqq.app.BaseFragment;
import java.util.ArrayList;
import javax.annotation.Nonnull;

class ReceiptMessageReadMemberListContainerFragment$MemberListTabAdapter
  extends FragmentPagerAdapter
{
  private ArrayList<ReceiptMessageReadMemberListFragment.MemberInfo> a;
  private ArrayList<ReceiptMessageReadMemberListFragment.MemberInfo> b;
  private String[] c;
  
  private ReceiptMessageReadMemberListContainerFragment$MemberListTabAdapter(FragmentManager paramFragmentManager)
  {
    super(paramFragmentManager);
  }
  
  public BaseFragment a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return ReceiptMessageReadMemberListFragment.a(this.a, this.c[1]);
      }
      return ReceiptMessageReadMemberListFragment.a(this.b, this.c[1]);
    }
    return ReceiptMessageReadMemberListFragment.a(this.a, this.c[0]);
  }
  
  public void a(@Nonnull ArrayList<ReceiptMessageReadMemberListFragment.MemberInfo> paramArrayList1, @Nonnull ArrayList<ReceiptMessageReadMemberListFragment.MemberInfo> paramArrayList2, @Nonnull String[] paramArrayOfString)
  {
    this.a = paramArrayList1;
    this.b = paramArrayList2;
    this.c = paramArrayOfString;
  }
  
  public int getCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.receipt.ReceiptMessageReadMemberListContainerFragment.MemberListTabAdapter
 * JD-Core Version:    0.7.0.1
 */