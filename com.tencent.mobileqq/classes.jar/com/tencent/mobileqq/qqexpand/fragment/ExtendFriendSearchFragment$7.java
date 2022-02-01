package com.tencent.mobileqq.qqexpand.fragment;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.AdapterDataObserver;

class ExtendFriendSearchFragment$7
  extends RecyclerView.AdapterDataObserver
{
  ExtendFriendSearchFragment$7(ExtendFriendSearchFragment paramExtendFriendSearchFragment) {}
  
  public void onChanged()
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentRecyclerViewAdapter.a() == 0)
    {
      this.a.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.removeItemDecoration(this.a.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentRecyclerViewItemDecoration);
      return;
    }
    this.a.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.removeItemDecoration(this.a.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentRecyclerViewItemDecoration);
    this.a.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(this.a.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentRecyclerViewItemDecoration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExtendFriendSearchFragment.7
 * JD-Core Version:    0.7.0.1
 */