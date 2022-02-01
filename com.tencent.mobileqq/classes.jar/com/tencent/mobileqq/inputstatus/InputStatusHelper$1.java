package com.tencent.mobileqq.inputstatus;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;

class InputStatusHelper$1
  implements TextWatcher
{
  InputStatusHelper$1(InputStatusHelper paramInputStatusHelper) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (InputStatusHelper.c(this.a) != null) {
      if (!TextUtils.isEmpty(paramCharSequence))
      {
        if (!InputStatusHelper.e(this.a))
        {
          InputStatusHelper.b(this.a, true);
          InputStatusHelper.a(this.a, 1);
        }
      }
      else {
        this.a.c();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.inputstatus.InputStatusHelper.1
 * JD-Core Version:    0.7.0.1
 */