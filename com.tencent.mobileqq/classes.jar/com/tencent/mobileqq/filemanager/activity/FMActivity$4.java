package com.tencent.mobileqq.filemanager.activity;

import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.filemanager.widget.QfileEditBottomBar;
import com.tencent.mobileqq.filemanager.widget.QfileTabBarView;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;

class FMActivity$4
  implements VerifyPwdView.VerifyPswEvent
{
  FMActivity$4(FMActivity paramFMActivity, int paramInt) {}
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.c();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.c()) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setVisibility(0);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.b.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.c.removeAllViews();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.c.addView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar.setTabType(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(16, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.getString(2131692579));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(15, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.getString(2131692587));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(17, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.getString(2131692589));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(18, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.getString(2131692584));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(19, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.getString(2131692586));
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.l) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.jdField_a_of_type_Int == 2) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.f >= 15) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.f <= 19)) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.f);
    } else {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(16);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView.a();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FMActivity.4
 * JD-Core Version:    0.7.0.1
 */