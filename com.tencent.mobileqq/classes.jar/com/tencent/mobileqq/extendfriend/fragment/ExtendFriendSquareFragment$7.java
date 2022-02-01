package com.tencent.mobileqq.extendfriend.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendReport;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ExtendFriendSquareFragment$7
  implements View.OnClickListener
{
  ExtendFriendSquareFragment$7(ExtendFriendSquareFragment paramExtendFriendSquareFragment) {}
  
  public void onClick(View paramView)
  {
    ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009E2F", "0X8009E2F", 0, 0, "", "", "", "");
    if (this.a.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendFragment$OnTabRequiredListener != null)
    {
      ExtendFriendReport.a().b(3);
      this.a.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendFragment$OnTabRequiredListener.a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendSquareFragment.7
 * JD-Core Version:    0.7.0.1
 */