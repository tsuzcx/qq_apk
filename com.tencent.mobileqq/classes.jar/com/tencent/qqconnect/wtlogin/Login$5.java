package com.tencent.qqconnect.wtlogin;

import android.text.Editable;
import android.text.TextWatcher;

class Login$5
  implements TextWatcher
{
  Login$5(Login paramLogin) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 < 2) {
      this.a.autoFillInPasswd = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqconnect.wtlogin.Login.5
 * JD-Core Version:    0.7.0.1
 */