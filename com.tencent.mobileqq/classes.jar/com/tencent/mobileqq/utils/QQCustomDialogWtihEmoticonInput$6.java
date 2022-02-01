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
    paramInt1 = this.b.l.getText().length();
    paramInt2 = this.a;
    if ((paramInt1 == paramInt2) && (paramCharSequence.charAt(paramInt2 - 1) == '\024'))
    {
      this.b.l.setText(paramCharSequence.subSequence(0, this.a - 1));
      this.b.l.setSelection(this.a - 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialogWtihEmoticonInput.6
 * JD-Core Version:    0.7.0.1
 */