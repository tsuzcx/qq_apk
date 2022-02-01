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
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.superDismiss();
      return;
      if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.length() > 0))
      {
        paramView = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + this.jdField_a_of_type_JavaLangString));
        this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityBusinessCardEditActivity.getActivity().startActivity(paramView);
        this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityBusinessCardEditActivity.app.getCallFacade().b(this.jdField_a_of_type_JavaLangString);
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityBusinessCardEditActivity.a(2131693380, 1);
        continue;
        if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.length() > 0))
        {
          paramView = new Intent();
          paramView.setAction("android.intent.action.SENDTO");
          paramView.setData(Uri.parse("smsto:" + this.jdField_a_of_type_JavaLangString));
          this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityBusinessCardEditActivity.getActivity().startActivity(paramView);
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityBusinessCardEditActivity.a(2131693380, 1);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity.12
 * JD-Core Version:    0.7.0.1
 */