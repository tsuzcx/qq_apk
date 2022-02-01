package com.tencent.mobileqq.extendfriend.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.extendfriend.utils.CampusHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ExtendFriendProfileEditFragment$8
  implements View.OnClickListener
{
  ExtendFriendProfileEditFragment$8(ExtendFriendProfileEditFragment paramExtendFriendProfileEditFragment, ExtendFriendProfileEditFragment.ExtendFriendInfo paramExtendFriendInfo) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.getActivity() != null) {
      CampusHelper.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.getActivity(), this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo.g, this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo.h, this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo.d, this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo.c);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendProfileEditFragment.8
 * JD-Core Version:    0.7.0.1
 */