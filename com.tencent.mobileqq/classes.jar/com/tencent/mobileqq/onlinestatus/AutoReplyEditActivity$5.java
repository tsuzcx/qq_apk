package com.tencent.mobileqq.onlinestatus;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mobileqq.text.TextUtils;
import com.tencent.mobileqq.widget.QQToast;

class AutoReplyEditActivity$5
  implements TextWatcher
{
  private int jdField_a_of_type_Int;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private int b;
  
  AutoReplyEditActivity$5(AutoReplyEditActivity paramAutoReplyEditActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    Object localObject = this.jdField_a_of_type_JavaLangCharSequence;
    if ((localObject != null) && (TextUtils.getQQTextCharCount(String.valueOf(localObject), 3) > 100))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoReplyEditActivity.getQBaseActivity(), 1, 2131690245, 0).a();
      paramEditable.delete(this.jdField_a_of_type_Int, this.b);
    }
    paramEditable = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoReplyEditActivity.d;
    localObject = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoReplyEditActivity;
    paramEditable.setEnabled(AutoReplyEditActivity.a((AutoReplyEditActivity)localObject, String.valueOf(AutoReplyEditActivity.a((AutoReplyEditActivity)localObject).getText())));
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = (paramInt1 + paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AutoReplyEditActivity.5
 * JD-Core Version:    0.7.0.1
 */