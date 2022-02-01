package com.tencent.mobileqq.qqexpand.fragment;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qqexpand.manager.ExtendFriendSearchHistoryManager;
import com.tencent.mobileqq.qqexpand.manager.IExpandManager;
import com.tencent.mobileqq.qqexpand.widget.ExtendFriendMultiLinesTagsView;
import java.util.ArrayList;
import java.util.List;

class ExtendFriendSearchFragment$3
  implements Runnable
{
  ExtendFriendSearchFragment$3(ExtendFriendSearchFragment paramExtendFriendSearchFragment) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity != null) && (!this.this$0.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.isFinishing()) && (this.this$0.isAdded()) && (this.this$0.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendMultiLinesTagsView != null))
    {
      List localList = this.this$0.jdField_a_of_type_ComTencentMobileqqQqexpandManagerIExpandManager.a().a();
      this.this$0.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendMultiLinesTagsView.setSearchTags((ArrayList)localList);
      ExtendFriendSearchFragment localExtendFriendSearchFragment = this.this$0;
      boolean bool;
      if (localList.size() > 0) {
        bool = true;
      } else {
        bool = false;
      }
      ExtendFriendSearchFragment.a(localExtendFriendSearchFragment, bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExtendFriendSearchFragment.3
 * JD-Core Version:    0.7.0.1
 */