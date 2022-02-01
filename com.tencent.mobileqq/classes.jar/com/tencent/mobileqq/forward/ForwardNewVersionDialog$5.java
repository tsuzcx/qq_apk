package com.tencent.mobileqq.forward;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

class ForwardNewVersionDialog$5
  implements TextWatcher
{
  ForwardNewVersionDialog$5(ForwardNewVersionDialog paramForwardNewVersionDialog, int paramInt) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((ForwardNewVersionDialog.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardNewVersionDialog).getText().length() == this.jdField_a_of_type_Int) && (paramCharSequence.charAt(this.jdField_a_of_type_Int - 1) == '\024'))
    {
      ForwardNewVersionDialog.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardNewVersionDialog).setText(paramCharSequence.subSequence(0, this.jdField_a_of_type_Int - 1));
      ForwardNewVersionDialog.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardNewVersionDialog).setSelection(this.jdField_a_of_type_Int - 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardNewVersionDialog.5
 * JD-Core Version:    0.7.0.1
 */