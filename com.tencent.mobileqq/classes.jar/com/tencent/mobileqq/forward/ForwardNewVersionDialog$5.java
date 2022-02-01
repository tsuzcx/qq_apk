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
    paramInt1 = ForwardNewVersionDialog.h(this.b).getText().length();
    paramInt2 = this.a;
    if ((paramInt1 == paramInt2) && (paramCharSequence.charAt(paramInt2 - 1) == '\024'))
    {
      ForwardNewVersionDialog.h(this.b).setText(paramCharSequence.subSequence(0, this.a - 1));
      ForwardNewVersionDialog.h(this.b).setSelection(this.a - 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardNewVersionDialog.5
 * JD-Core Version:    0.7.0.1
 */