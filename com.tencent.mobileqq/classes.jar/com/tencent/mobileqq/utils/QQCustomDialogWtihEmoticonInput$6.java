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
    if ((this.this$0.inputView.getText().length() == this.val$maxLength) && (paramCharSequence.charAt(this.val$maxLength - 1) == '\024'))
    {
      this.this$0.inputView.setText(paramCharSequence.subSequence(0, this.val$maxLength - 1));
      this.this$0.inputView.setSelection(this.val$maxLength - 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialogWtihEmoticonInput.6
 * JD-Core Version:    0.7.0.1
 */