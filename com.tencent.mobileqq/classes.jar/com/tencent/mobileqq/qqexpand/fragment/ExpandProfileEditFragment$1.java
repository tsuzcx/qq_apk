package com.tencent.mobileqq.qqexpand.fragment;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.XEditTextEx;

class ExpandProfileEditFragment$1
  implements TextWatcher
{
  int jdField_a_of_type_Int = 0;
  String jdField_a_of_type_JavaLangString;
  
  ExpandProfileEditFragment$1(ExpandProfileEditFragment paramExpandProfileEditFragment) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLineCount();
    if (i > 30)
    {
      if (this.jdField_a_of_type_JavaLangString != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment.jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection(this.jdField_a_of_type_Int);
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText("");
        this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment.jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection(0);
      }
      if (ExpandProfileEditFragment.a(this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment) == null)
      {
        paramEditable = this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment;
        ExpandProfileEditFragment.a(paramEditable, QQToast.a(paramEditable.getActivity(), "输入文字不要超过30行", 0));
      }
      if (!ExpandProfileEditFragment.a(this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment).d()) {
        ExpandProfileEditFragment.a(this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment).a();
      }
    }
    if (i != ExpandProfileEditFragment.a(this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment))
    {
      ExpandProfileEditFragment.a(this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment, i);
      this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLineCount() <= 30)
    {
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
      this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment.jdField_a_of_type_ComTencentWidgetXEditTextEx.getSelectionStart();
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment.jdField_a_of_type_JavaLangString == null) {
      this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment.jdField_a_of_type_JavaLangString = "";
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment.jdField_a_of_type_JavaLangString.equals(paramCharSequence.toString())) && (!ExpandProfileEditFragment.a(this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment)))
    {
      ExpandProfileEditFragment.a(this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment);
      return;
    }
    ExpandProfileEditFragment.b(this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExpandProfileEditFragment.1
 * JD-Core Version:    0.7.0.1
 */