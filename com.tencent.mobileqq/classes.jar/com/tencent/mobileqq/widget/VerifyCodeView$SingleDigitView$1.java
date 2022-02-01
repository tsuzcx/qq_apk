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
      QQToast.makeText(this.a, 1, 2131892398, 0).show();
      return true;
    }
    this.b.c.setText(str);
    this.b.c.setSelection(this.b.c.getText().length());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.VerifyCodeView.SingleDigitView.1
 * JD-Core Version:    0.7.0.1
 */