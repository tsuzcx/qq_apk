package com.tencent.mobileqq.extendfriend.fragment;

import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.profilesetting.InterestSwitchEditActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ExtendFriendBaseFragment$7
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.a.jdField_a_of_type_AndroidAppDialog != null) && (this.a.jdField_a_of_type_AndroidAppDialog.isShowing())) {
        this.a.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      if (!this.a.jdField_a_of_type_Boolean)
      {
        ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80092EC", "0X80092EC", 0, 0, "", "", "", "");
      }
      else
      {
        ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80092E9", "0X80092E9", 0, 0, "", "", "", "");
        continue;
        if (!this.a.jdField_a_of_type_Boolean) {
          PublicFragmentActivity.a(this.a.getActivity(), ExtendFriendEditFragment.class, 1033);
        }
        for (;;)
        {
          if ((this.a.jdField_a_of_type_AndroidAppDialog != null) && (this.a.jdField_a_of_type_AndroidAppDialog.isShowing())) {
            this.a.jdField_a_of_type_AndroidAppDialog.dismiss();
          }
          if (this.a.jdField_a_of_type_Boolean) {
            break label273;
          }
          ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80092EB", "0X80092EB", 0, 0, "", "", "", "");
          break;
          Intent localIntent = InterestSwitchEditActivity.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
          this.a.startActivityForResult(localIntent, 2);
        }
        label273:
        ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80092E8", "0X80092E8", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendBaseFragment.7
 * JD-Core Version:    0.7.0.1
 */