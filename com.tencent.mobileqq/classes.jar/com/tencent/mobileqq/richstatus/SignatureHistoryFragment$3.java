package com.tencent.mobileqq.richstatus;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import com.tencent.mobileqq.text.TextUtils;
import com.tencent.mobileqq.widget.QQToast;

class SignatureHistoryFragment$3
  implements TextWatcher
{
  private int jdField_a_of_type_Int;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private int b;
  
  SignatureHistoryFragment$3(SignatureHistoryFragment paramSignatureHistoryFragment) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    CharSequence localCharSequence = this.jdField_a_of_type_JavaLangCharSequence;
    if ((localCharSequence != null) && (TextUtils.getQQTextCharCount(String.valueOf(localCharSequence), 3) > 50))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment.getBaseActivity(), 1, 2131690245, 0).a();
      paramEditable.delete(this.jdField_a_of_type_Int, this.b);
    }
    if ((paramEditable != null) && (paramEditable.length() != 0))
    {
      SignatureHistoryFragment.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment).setEnabled(true);
      return;
    }
    SignatureHistoryFragment.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment).setEnabled(false);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = (paramInt1 + paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignatureHistoryFragment.3
 * JD-Core Version:    0.7.0.1
 */