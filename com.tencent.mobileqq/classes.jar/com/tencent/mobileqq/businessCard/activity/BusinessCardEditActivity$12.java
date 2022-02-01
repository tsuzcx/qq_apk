package com.tencent.mobileqq.businessCard.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class BusinessCardEditActivity$12
  implements ActionSheet.OnButtonClickListener
{
  BusinessCardEditActivity$12(BusinessCardEditActivity paramBusinessCardEditActivity, String paramString, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt == 1)
      {
        paramView = this.jdField_a_of_type_JavaLangString;
        if ((paramView != null) && (paramView.length() > 0))
        {
          paramView = new Intent();
          paramView.setAction("android.intent.action.SENDTO");
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("smsto:");
          localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
          paramView.setData(Uri.parse(localStringBuilder.toString()));
          this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityBusinessCardEditActivity.getActivity().startActivity(paramView);
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityBusinessCardEditActivity.a(2131693335, 1);
        }
      }
    }
    else
    {
      paramView = this.jdField_a_of_type_JavaLangString;
      if ((paramView != null) && (paramView.length() > 0))
      {
        paramView = new StringBuilder();
        paramView.append("tel:");
        paramView.append(this.jdField_a_of_type_JavaLangString);
        paramView = new Intent("android.intent.action.DIAL", Uri.parse(paramView.toString()));
        this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityBusinessCardEditActivity.getActivity().startActivity(paramView);
        this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityBusinessCardEditActivity.app.getCallFacade().b(this.jdField_a_of_type_JavaLangString);
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityBusinessCardEditActivity.a(2131693335, 1);
      }
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.superDismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity.12
 * JD-Core Version:    0.7.0.1
 */