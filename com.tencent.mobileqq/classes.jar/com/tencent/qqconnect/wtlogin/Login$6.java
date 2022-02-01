package com.tencent.qqconnect.wtlogin;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

class Login$6
  implements TextWatcher
{
  Login$6(Login paramLogin) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramCharSequence.length() == 0) {
      this.a.mDelBtn.setVisibility(4);
    } else if (paramInt3 < 2) {
      this.a.mDelBtn.setVisibility(0);
    }
    paramCharSequence = this.a;
    paramCharSequence.autoFillInPasswd = false;
    paramCharSequence.pswd.setText("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqconnect.wtlogin.Login.6
 * JD-Core Version:    0.7.0.1
 */