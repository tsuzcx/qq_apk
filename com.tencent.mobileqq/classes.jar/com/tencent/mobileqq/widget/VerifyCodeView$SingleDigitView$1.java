package com.tencent.mobileqq.widget;

import android.content.Context;
import android.text.Editable;
import android.widget.EditText;

class VerifyCodeView$SingleDigitView$1
  extends EditText
{
  VerifyCodeView$SingleDigitView$1(VerifyCodeView.SingleDigitView paramSingleDigitView, Context paramContext1, Context paramContext2)
  {
    super(paramContext1);
  }
  
  public boolean onTextContextMenuItem(int paramInt)
  {
    if (paramInt != 16908322) {
      return super.onTextContextMenuItem(paramInt);
    }
    String str = VerifyCodeView.a(getContext());
    if (str.length() == 0)
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131694705, 0).a();
      return true;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetVerifyCodeView$SingleDigitView.b.setText(str);
    this.jdField_a_of_type_ComTencentMobileqqWidgetVerifyCodeView$SingleDigitView.b.setSelection(this.jdField_a_of_type_ComTencentMobileqqWidgetVerifyCodeView$SingleDigitView.b.getText().length());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.VerifyCodeView.SingleDigitView.1
 * JD-Core Version:    0.7.0.1
 */