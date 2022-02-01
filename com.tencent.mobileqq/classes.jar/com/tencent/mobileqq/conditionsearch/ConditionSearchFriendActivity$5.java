package com.tencent.mobileqq.conditionsearch;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.AccessibilityUtils;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.qphone.base.util.QLog;

class ConditionSearchFriendActivity$5
  implements DialogInterface.OnDismissListener
{
  ConditionSearchFriendActivity$5(ConditionSearchFriendActivity paramConditionSearchFriendActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConditionSearchFriendActivity", 2, "onDismiss|pickerType : " + this.a.i);
    }
    if (this.a.i == 0)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(2);
      this.a.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(this.a.jdField_b_of_type_Int, this.a.jdField_c_of_type_Int);
      paramDialogInterface = this.a.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(this.a.jdField_b_of_type_Int, this.a.jdField_c_of_type_Int);
      if (AppSetting.d)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(HardCodeUtil.a(2131702406) + paramDialogInterface);
        AccessibilityUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem, HardCodeUtil.a(2131702409) + paramDialogInterface);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ConditionSearchFriendActivity", 2, "onDismiss|mCurAgeIndex1 : " + this.a.f + ", mCurAgeIndex2 : " + this.a.g + ", mAgeSelectIndex1 : " + this.a.jdField_b_of_type_Int + ", mAgeSelectIndex2 : " + this.a.jdField_c_of_type_Int);
      }
      ReportController.b(this.a.app, "CliOper", "", "", "0X8004243", "0X8004243", 0, 0, this.a.jdField_b_of_type_Int + "", this.a.jdField_c_of_type_Int + "", "", "");
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView = null;
      if (ConditionSearchFriendActivity.a(this.a) > 0)
      {
        this.a.jdField_e_of_type_AndroidViewView.scrollBy(0, -ConditionSearchFriendActivity.a(this.a));
        ConditionSearchFriendActivity.c(this.a, 0);
      }
      return;
      if (this.a.i == 3)
      {
        this.a.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(2);
        this.a.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b(this.a.jdField_d_of_type_Int);
        if (AppSetting.d)
        {
          this.a.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(HardCodeUtil.a(2131702408) + ConditionSearchManager.c[this.a.jdField_d_of_type_Int]);
          AccessibilityUtils.a(this.a.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem, HardCodeUtil.a(2131702419) + ConditionSearchManager.c[this.a.jdField_d_of_type_Int]);
        }
        ReportController.b(this.a.app, "CliOper", "", "", "0X8006F0B", "0X8006F0B", 0, 0, this.a.jdField_d_of_type_Int + "", "", "", "");
      }
      else
      {
        this.a.jdField_d_of_type_AndroidWidgetTextView = null;
        paramDialogInterface = ConditionSearchFriendActivity.a(this.a);
        String[] arrayOfString = new String[4];
        arrayOfString[0] = this.a.jdField_b_of_type_JavaLangString;
        arrayOfString[1] = this.a.jdField_a_of_type_ArrayOfJavaLangString[0];
        arrayOfString[2] = this.a.jdField_a_of_type_ArrayOfJavaLangString[1];
        arrayOfString[3] = this.a.jdField_a_of_type_ArrayOfJavaLangString[2];
        if (this.a.i == 1)
        {
          this.a.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(2);
          this.a.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(0, paramDialogInterface);
          this.a.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b(arrayOfString);
          if (AppSetting.d)
          {
            this.a.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(HardCodeUtil.a(2131702405) + paramDialogInterface);
            AccessibilityUtils.a(this.a.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem, HardCodeUtil.a(2131702404) + paramDialogInterface);
          }
        }
        else if (this.a.i == 2)
        {
          this.a.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(2);
          this.a.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(1, paramDialogInterface);
          this.a.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.c(arrayOfString);
          if (AppSetting.d)
          {
            this.a.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(HardCodeUtil.a(2131702415) + paramDialogInterface);
            AccessibilityUtils.a(this.a.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem, HardCodeUtil.a(2131702416) + paramDialogInterface);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity.5
 * JD-Core Version:    0.7.0.1
 */