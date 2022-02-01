package com.tencent.mobileqq.conditionsearch;

import android.content.res.Resources;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.conditionsearch.data.AddressData.NO_LIMIT_ADDRESS;
import com.tencent.mobileqq.conditionsearch.data.BaseAddress;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;
import java.util.List;

class ConditionSearchFriendActivity$4
  implements IphonePickerView.IphonePickListener
{
  ConditionSearchFriendActivity$4(ConditionSearchFriendActivity paramConditionSearchFriendActivity) {}
  
  public void onConfirmBtClicked()
  {
    if ((this.a.i == 0) && (this.a.f > this.a.g) && (this.a.g != 0))
    {
      ConditionSearchFriendActivity localConditionSearchFriendActivity = this.a;
      QQToast.a(localConditionSearchFriendActivity, localConditionSearchFriendActivity.getResources().getString(2131691044), 0).b(this.a.getTitleBarHeight());
      return;
    }
    if ((this.a.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.a.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())) {
      this.a.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    }
  }
  
  public void onItemSelected(int paramInt1, int paramInt2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onItemSelected|pickerType : ");
      ((StringBuilder)localObject).append(this.a.i);
      ((StringBuilder)localObject).append(", column : ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", row : ");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("ConditionSearchFriendActivity", 2, ((StringBuilder)localObject).toString());
    }
    if (this.a.i == 0)
    {
      int i;
      if (paramInt2 >= 0)
      {
        i = paramInt2;
        if (paramInt2 < ConditionSearchManager.b.length) {}
      }
      else
      {
        i = 0;
      }
      if (paramInt1 != 0)
      {
        if (paramInt1 == 1) {
          this.a.g = i;
        }
      }
      else {
        this.a.f = i;
      }
      if ((this.a.f <= this.a.g) || (this.a.g == 0))
      {
        localObject = this.a;
        ((ConditionSearchFriendActivity)localObject).jdField_b_of_type_Int = ConditionSearchFriendActivity.b((ConditionSearchFriendActivity)localObject, ((ConditionSearchFriendActivity)localObject).f);
        localObject = this.a;
        ((ConditionSearchFriendActivity)localObject).jdField_c_of_type_Int = ConditionSearchFriendActivity.b((ConditionSearchFriendActivity)localObject, ((ConditionSearchFriendActivity)localObject).g);
      }
      localObject = this.a.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(this.a.jdField_b_of_type_Int, this.a.jdField_c_of_type_Int);
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText((CharSequence)localObject);
      return;
    }
    if (this.a.i == 3)
    {
      if (paramInt2 >= 0)
      {
        paramInt1 = paramInt2;
        if (paramInt2 < ConditionSearchManager.c.length) {}
      }
      else
      {
        paramInt1 = 0;
      }
      localObject = this.a;
      ((ConditionSearchFriendActivity)localObject).d = paramInt1;
      ((ConditionSearchFriendActivity)localObject).e.setRightText(ConditionSearchManager.c[paramInt1]);
      return;
    }
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1)
      {
        if ((paramInt1 == 2) && (this.a.h > 2) && (this.a.jdField_a_of_type_ArrayOfJavaLangObject[2] != null) && (((List)this.a.jdField_a_of_type_ArrayOfJavaLangObject[2]).size() > 0))
        {
          if (paramInt2 >= 0)
          {
            paramInt1 = paramInt2;
            if (paramInt2 < ((List)this.a.jdField_a_of_type_ArrayOfJavaLangObject[2]).size()) {}
          }
          else
          {
            paramInt1 = 0;
          }
          this.a.jdField_a_of_type_ArrayOfInt[2] = paramInt1;
          this.a.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[2] = ((BaseAddress)((List)this.a.jdField_a_of_type_ArrayOfJavaLangObject[2]).get(paramInt1));
          this.a.jdField_a_of_type_ArrayOfJavaLangString[2] = this.a.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[2].code;
        }
      }
      else if ((this.a.jdField_a_of_type_ArrayOfJavaLangObject.length > 1) && (this.a.jdField_a_of_type_ArrayOfJavaLangObject[1] != null) && (((List)this.a.jdField_a_of_type_ArrayOfJavaLangObject[1]).size() > 0))
      {
        if (paramInt2 >= 0)
        {
          paramInt1 = paramInt2;
          if (paramInt2 < ((List)this.a.jdField_a_of_type_ArrayOfJavaLangObject[1]).size()) {}
        }
        else
        {
          paramInt1 = 0;
        }
        this.a.jdField_a_of_type_ArrayOfInt[1] = paramInt1;
        this.a.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[1] = ((BaseAddress)((List)this.a.jdField_a_of_type_ArrayOfJavaLangObject[1]).get(paramInt1));
        this.a.jdField_a_of_type_ArrayOfJavaLangString[1] = this.a.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[1].code;
        localObject = this.a.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[1].getDataList();
        if (this.a.h > 2)
        {
          this.a.jdField_a_of_type_ArrayOfJavaLangObject[2] = localObject;
          this.a.jdField_a_of_type_ArrayOfInt[2] = 0;
          this.a.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[2] = new AddressData.NO_LIMIT_ADDRESS(2);
          this.a.jdField_a_of_type_ArrayOfJavaLangString[2] = "0";
          try
          {
            this.a.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(2);
            this.a.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(2, 0);
          }
          catch (Exception localException1)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ConditionSearchFriendActivity", 2, localException1, new Object[0]);
            }
            if (this.a.jdField_a_of_type_ComTencentWidgetActionSheet == null) {
              break label1162;
            }
          }
          if (this.a.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()) {
            this.a.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
          }
        }
      }
    }
    else if ((this.a.jdField_a_of_type_ArrayOfJavaLangObject.length > 0) && (this.a.jdField_a_of_type_ArrayOfJavaLangObject[0] != null) && (((List)this.a.jdField_a_of_type_ArrayOfJavaLangObject[0]).size() > 0))
    {
      if (paramInt2 >= 0)
      {
        paramInt1 = paramInt2;
        if (paramInt2 < ((List)this.a.jdField_a_of_type_ArrayOfJavaLangObject[0]).size()) {}
      }
      else
      {
        paramInt1 = 0;
      }
      this.a.jdField_a_of_type_ArrayOfInt[0] = paramInt1;
      this.a.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[0] = ((BaseAddress)((List)this.a.jdField_a_of_type_ArrayOfJavaLangObject[0]).get(paramInt1));
      this.a.jdField_a_of_type_ArrayOfJavaLangString[0] = this.a.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[0].code;
      ArrayList localArrayList = this.a.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[0].getDataList();
      if (this.a.h > 1)
      {
        this.a.jdField_a_of_type_ArrayOfJavaLangObject[1] = localArrayList;
        this.a.jdField_a_of_type_ArrayOfInt[1] = 0;
        this.a.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[1] = new AddressData.NO_LIMIT_ADDRESS(2);
        this.a.jdField_a_of_type_ArrayOfJavaLangString[1] = "0";
        try
        {
          this.a.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(1);
          this.a.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(1, 0);
        }
        catch (Exception localException2)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ConditionSearchFriendActivity", 2, localException2, new Object[0]);
          }
          if ((this.a.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.a.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())) {
            this.a.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
          }
        }
        if (this.a.h > 2)
        {
          this.a.jdField_a_of_type_ArrayOfJavaLangObject[2] = null;
          this.a.jdField_a_of_type_ArrayOfInt[2] = 0;
          this.a.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[2] = new AddressData.NO_LIMIT_ADDRESS(2);
          this.a.jdField_a_of_type_ArrayOfJavaLangString[2] = "0";
          try
          {
            this.a.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(2);
            this.a.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(2, 0);
          }
          catch (Exception localException3)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ConditionSearchFriendActivity", 2, localException3, new Object[0]);
            }
            if ((this.a.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.a.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())) {
              this.a.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
            }
          }
        }
      }
    }
    label1162:
    if (this.a.i == 1)
    {
      this.a.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(this.a.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.c(ConditionSearchFriendActivity.a(this.a)));
      return;
    }
    if (this.a.i == 2) {
      this.a.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(this.a.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.c(ConditionSearchFriendActivity.a(this.a)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity.4
 * JD-Core Version:    0.7.0.1
 */