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
    if (QLog.isColorLevel())
    {
      paramDialogInterface = new StringBuilder();
      paramDialogInterface.append("onDismiss|pickerType : ");
      paramDialogInterface.append(this.a.i);
      QLog.d("ConditionSearchFriendActivity", 2, paramDialogInterface.toString());
    }
    Object localObject;
    StringBuilder localStringBuilder;
    if (this.a.i == 0)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(2);
      this.a.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(this.a.jdField_b_of_type_Int, this.a.jdField_c_of_type_Int);
      paramDialogInterface = this.a.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(this.a.jdField_b_of_type_Int, this.a.jdField_c_of_type_Int);
      if (AppSetting.d)
      {
        localObject = this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(2131702538));
        localStringBuilder.append(paramDialogInterface);
        ((FormSimpleItem)localObject).setContentDescription(localStringBuilder.toString());
        localObject = this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(2131702541));
        localStringBuilder.append(paramDialogInterface);
        AccessibilityUtils.a((View)localObject, localStringBuilder.toString());
      }
      if (QLog.isColorLevel())
      {
        paramDialogInterface = new StringBuilder();
        paramDialogInterface.append("onDismiss|mCurAgeIndex1 : ");
        paramDialogInterface.append(this.a.f);
        paramDialogInterface.append(", mCurAgeIndex2 : ");
        paramDialogInterface.append(this.a.g);
        paramDialogInterface.append(", mAgeSelectIndex1 : ");
        paramDialogInterface.append(this.a.jdField_b_of_type_Int);
        paramDialogInterface.append(", mAgeSelectIndex2 : ");
        paramDialogInterface.append(this.a.jdField_c_of_type_Int);
        QLog.d("ConditionSearchFriendActivity", 2, paramDialogInterface.toString());
      }
      paramDialogInterface = this.a.app;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.a.jdField_b_of_type_Int);
      ((StringBuilder)localObject).append("");
      localObject = ((StringBuilder)localObject).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a.jdField_c_of_type_Int);
      localStringBuilder.append("");
      ReportController.b(paramDialogInterface, "CliOper", "", "", "0X8004243", "0X8004243", 0, 0, (String)localObject, localStringBuilder.toString(), "", "");
    }
    else if (this.a.i == 3)
    {
      this.a.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(2);
      this.a.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b(this.a.jdField_d_of_type_Int);
      if (AppSetting.d)
      {
        paramDialogInterface = this.a.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(HardCodeUtil.a(2131702540));
        ((StringBuilder)localObject).append(ConditionSearchManager.c[this.a.jdField_d_of_type_Int]);
        paramDialogInterface.setContentDescription(((StringBuilder)localObject).toString());
        paramDialogInterface = this.a.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(HardCodeUtil.a(2131702551));
        ((StringBuilder)localObject).append(ConditionSearchManager.c[this.a.jdField_d_of_type_Int]);
        AccessibilityUtils.a(paramDialogInterface, ((StringBuilder)localObject).toString());
      }
      paramDialogInterface = this.a.app;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.a.jdField_d_of_type_Int);
      ((StringBuilder)localObject).append("");
      ReportController.b(paramDialogInterface, "CliOper", "", "", "0X8006F0B", "0X8006F0B", 0, 0, ((StringBuilder)localObject).toString(), "", "", "");
    }
    else
    {
      paramDialogInterface = this.a;
      paramDialogInterface.jdField_d_of_type_AndroidWidgetTextView = null;
      paramDialogInterface = ConditionSearchFriendActivity.a(paramDialogInterface);
      localObject = new String[4];
      localObject[0] = this.a.jdField_b_of_type_JavaLangString;
      localObject[1] = this.a.jdField_a_of_type_ArrayOfJavaLangString[0];
      localObject[2] = this.a.jdField_a_of_type_ArrayOfJavaLangString[1];
      localObject[3] = this.a.jdField_a_of_type_ArrayOfJavaLangString[2];
      if (this.a.i == 1)
      {
        this.a.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(2);
        this.a.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(0, paramDialogInterface);
        this.a.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b((String[])localObject);
        if (AppSetting.d)
        {
          localObject = this.a.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(HardCodeUtil.a(2131702537));
          localStringBuilder.append(paramDialogInterface);
          ((FormSimpleItem)localObject).setContentDescription(localStringBuilder.toString());
          localObject = this.a.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(HardCodeUtil.a(2131702536));
          localStringBuilder.append(paramDialogInterface);
          AccessibilityUtils.a((View)localObject, localStringBuilder.toString());
        }
      }
      else if (this.a.i == 2)
      {
        this.a.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(2);
        this.a.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(1, paramDialogInterface);
        this.a.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.c((String[])localObject);
        if (AppSetting.d)
        {
          localObject = this.a.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(HardCodeUtil.a(2131702547));
          localStringBuilder.append(paramDialogInterface);
          ((FormSimpleItem)localObject).setContentDescription(localStringBuilder.toString());
          localObject = this.a.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(HardCodeUtil.a(2131702548));
          localStringBuilder.append(paramDialogInterface);
          AccessibilityUtils.a((View)localObject, localStringBuilder.toString());
        }
      }
    }
    paramDialogInterface = this.a;
    paramDialogInterface.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView = null;
    if (ConditionSearchFriendActivity.a(paramDialogInterface) > 0)
    {
      this.a.jdField_e_of_type_AndroidViewView.scrollBy(0, -ConditionSearchFriendActivity.a(this.a));
      ConditionSearchFriendActivity.c(this.a, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity.5
 * JD-Core Version:    0.7.0.1
 */