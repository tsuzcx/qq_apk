package com.tencent.mobileqq.extendfriend.fragment;

import android.support.v4.app.FragmentActivity;
import asfu;
import asjw;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendMultiLinesTagsView;
import java.util.ArrayList;
import java.util.List;

class ExtendFriendSearchFragment$3
  implements Runnable
{
  ExtendFriendSearchFragment$3(ExtendFriendSearchFragment paramExtendFriendSearchFragment) {}
  
  public void run()
  {
    ExtendFriendSearchFragment localExtendFriendSearchFragment;
    if ((this.this$0.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) && (!this.this$0.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()) && (this.this$0.isAdded()) && (this.this$0.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendMultiLinesTagsView != null))
    {
      List localList = this.this$0.jdField_a_of_type_Asfu.a().a();
      this.this$0.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendMultiLinesTagsView.setSearchTags((ArrayList)localList);
      localExtendFriendSearchFragment = this.this$0;
      if (localList.size() <= 0) {
        break label93;
      }
    }
    label93:
    for (boolean bool = true;; bool = false)
    {
      ExtendFriendSearchFragment.a(localExtendFriendSearchFragment, bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendSearchFragment.3
 * JD-Core Version:    0.7.0.1
 */