package com.tencent.mobileqq.filemanager.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.filemanager.util.IReportVer51;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FMActivity$3
  implements RadioGroup.OnCheckedChangeListener
{
  FMActivity$3(FMActivity paramFMActivity) {}
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    if (this.a.jdField_b_of_type_AndroidWidgetTextView != null) {
      this.a.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    this.a.g();
    this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setVisibility(0);
    if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView != null)
    {
      this.a.jdField_c_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView.setVisibility(8);
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView.a();
      localObject = this.a;
      ((FMActivity)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView = null;
      ((FMActivity)localObject).jdField_c_of_type_AndroidWidgetRelativeLayout.addView(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView);
    }
    int j = -1;
    int i;
    if ((paramInt == 2131376173) && (this.a.jdField_b_of_type_AndroidWidgetRadioButton.isChecked()))
    {
      this.a.a().f();
      FMActivity.b(this.a);
      this.a.jdField_a_of_type_AndroidWidgetRadioButton.setSelected(false);
      this.a.jdField_c_of_type_AndroidWidgetRadioButton.setSelected(false);
      if (FMActivity.a(this.a)) {
        this.a.d.setSelected(false);
      }
      this.a.i(false);
      FMActivity.a(this.a, 1);
      i = 0;
    }
    else if ((paramInt == 2131370404) && (this.a.jdField_a_of_type_AndroidWidgetRadioButton.isChecked()))
    {
      this.a.a().e();
      FMActivity.c(this.a);
      if ((this.a.i == 0) && (this.a.f)) {
        this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      }
      this.a.jdField_b_of_type_AndroidWidgetRadioButton.setSelected(false);
      this.a.jdField_c_of_type_AndroidWidgetRadioButton.setSelected(false);
      if (FMActivity.a(this.a)) {
        this.a.d.setSelected(false);
      }
      this.a.i(false);
      FMActivity.a(this.a, 2);
      i = 1;
    }
    else if ((paramInt == 2131364749) && (this.a.jdField_c_of_type_AndroidWidgetRadioButton.isChecked()))
    {
      this.a.a().d();
      FMActivity.b(this.a, 2);
      this.a.jdField_a_of_type_AndroidWidgetRadioButton.setSelected(false);
      this.a.jdField_b_of_type_AndroidWidgetRadioButton.setSelected(false);
      if (FMActivity.a(this.a)) {
        this.a.d.setSelected(false);
      }
      this.a.i(false);
      FMActivity.a(this.a, 0);
      i = 2;
    }
    else
    {
      i = j;
      if (paramInt == 2131366485)
      {
        i = j;
        if (this.a.d.isChecked())
        {
          this.a.a().g();
          FMActivity.d(this.a);
          i = 1408041718;
          this.a.jdField_a_of_type_AndroidWidgetRadioButton.setSelected(false);
          this.a.jdField_b_of_type_AndroidWidgetRadioButton.setSelected(false);
          this.a.jdField_c_of_type_AndroidWidgetRadioButton.setSelected(false);
          this.a.i(false);
          FMActivity.a(this.a, 5);
          ReportController.b(this.a.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, "dc00898", "", "", "0X800AFA6", "0X800AFA6", 0, 0, "", "", "", "");
        }
      }
    }
    Object localObject = this.a.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getApplicationContext().getSharedPreferences("aio_last_select_file", 0).edit();
    ((SharedPreferences.Editor)localObject).putInt("last_select_tab_type", i);
    ((SharedPreferences.Editor)localObject).commit();
    EventCollector.getInstance().onCheckedChanged(paramRadioGroup, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FMActivity.3
 * JD-Core Version:    0.7.0.1
 */