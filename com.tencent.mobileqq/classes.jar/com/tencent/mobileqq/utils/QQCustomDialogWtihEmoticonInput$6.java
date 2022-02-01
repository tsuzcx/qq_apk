package com.tencent.mobileqq.utils;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

class QQCustomDialogWtihEmoticonInput$6
  implements TextWatcher
{
  QQCustomDialogWtihEmoticonInput$6(QQCustomDialogWtihEmoticonInput paramQQCustomDialogWtihEmoticonInput, int paramInt) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt1 = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogWtihEmoticonInput.a.getText().length();
    paramInt2 = this.jdField_a_of_type_Int;
    if ((paramInt1 == paramInt2) && (paramCharSequence.charAt(paramInt2 - 1) == '\024'))
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogWtihEmoticonInput.a.setText(paramCharSequence.subSequence(0, this.jdField_a_of_type_Int - 1));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogWtihEmoticonInput.a.setSelection(this.jdField_a_of_type_Int - 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialogWtihEmoticonInput.6
 * JD-Core Version:    0.7.0.1
 */