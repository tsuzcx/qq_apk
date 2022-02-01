package com.tencent.mobileqq.receipt;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.tencent.mobileqq.app.BaseFragment;
import java.util.ArrayList;
import javax.annotation.Nonnull;

class ReceiptMessageReadMemberListContainerFragment$MemberListTabAdapter
  extends FragmentPagerAdapter
{
  private ArrayList<ReceiptMessageReadMemberListFragment.MemberInfo> jdField_a_of_type_JavaUtilArrayList;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  private ArrayList<ReceiptMessageReadMemberListFragment.MemberInfo> b;
  
  private ReceiptMessageReadMemberListContainerFragment$MemberListTabAdapter(FragmentManager paramFragmentManager)
  {
    super(paramFragmentManager);
  }
  
  public BaseFragment a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return ReceiptMessageReadMemberListFragment.a(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ArrayOfJavaLangString[1]);
      }
      return ReceiptMessageReadMemberListFragment.a(this.b, this.jdField_a_of_type_ArrayOfJavaLangString[1]);
    }
    return ReceiptMessageReadMemberListFragment.a(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ArrayOfJavaLangString[0]);
  }
  
  public void a(@Nonnull ArrayList<ReceiptMessageReadMemberListFragment.MemberInfo> paramArrayList1, @Nonnull ArrayList<ReceiptMessageReadMemberListFragment.MemberInfo> paramArrayList2, @Nonnull String[] paramArrayOfString)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList1;
    this.b = paramArrayList2;
    this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
  }
  
  public int getCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.receipt.ReceiptMessageReadMemberListContainerFragment.MemberListTabAdapter
 * JD-Core Version:    0.7.0.1
 */