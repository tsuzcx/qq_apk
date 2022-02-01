package com.tencent.mobileqq.qqexpand.fragment;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.profilesetting.InterestSwitchEditActivity;
import com.tencent.mobileqq.qqexpand.entrance.IExpandFragmentRouter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;

class ExtendFriendBaseFragment$8
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131363927)
    {
      if (i != 2131363990) {
        return;
      }
      if (!this.a.jdField_a_of_type_Boolean)
      {
        ((IExpandFragmentRouter)QRoute.api(IExpandFragmentRouter.class)).launchExpandEditFragmentForResult(this.a.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, null, 1033);
      }
      else
      {
        paramView = InterestSwitchEditActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
        this.a.startActivityForResult(paramView, 2);
      }
      if ((this.a.jdField_a_of_type_AndroidAppDialog != null) && (this.a.jdField_a_of_type_AndroidAppDialog.isShowing())) {
        this.a.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      if (!this.a.jdField_a_of_type_Boolean)
      {
        ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80092EB", "0X80092EB", 0, 0, "", "", "", "");
        return;
      }
      ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80092E8", "0X80092E8", 0, 0, "", "", "", "");
      return;
    }
    if ((this.a.jdField_a_of_type_AndroidAppDialog != null) && (this.a.jdField_a_of_type_AndroidAppDialog.isShowing())) {
      this.a.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    if (!this.a.jdField_a_of_type_Boolean)
    {
      ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80092EC", "0X80092EC", 0, 0, "", "", "", "");
      return;
    }
    ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80092E9", "0X80092E9", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExtendFriendBaseFragment.8
 * JD-Core Version:    0.7.0.1
 */