package com.tencent.mobileqq.fragment;

import android.text.TextUtils;
import android.view.Window;
import android.widget.EditText;
import com.tencent.mobileqq.app.BaseActivity;

class UnitedVerifyMsgEditFragment$1$1
  implements Runnable
{
  UnitedVerifyMsgEditFragment$1$1(UnitedVerifyMsgEditFragment.1 param1, String paramString1, String paramString2) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqFragmentUnitedVerifyMsgEditFragment$1.this$0.jdField_a_of_type_AndroidWidgetEditText.setText(this.jdField_a_of_type_JavaLangString);
    try
    {
      if (!TextUtils.isEmpty(this.b)) {
        this.jdField_a_of_type_ComTencentMobileqqFragmentUnitedVerifyMsgEditFragment$1.this$0.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_JavaLangString.lastIndexOf(this.b), this.jdField_a_of_type_JavaLangString.length());
      } else if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_ComTencentMobileqqFragmentUnitedVerifyMsgEditFragment$1.this$0.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_JavaLangString.length());
      }
    }
    catch (Throwable localThrowable)
    {
      label91:
      break label91;
    }
    this.jdField_a_of_type_ComTencentMobileqqFragmentUnitedVerifyMsgEditFragment$1.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow().setSoftInputMode(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.UnitedVerifyMsgEditFragment.1.1
 * JD-Core Version:    0.7.0.1
 */