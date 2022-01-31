package com.tencent.viola.ui.component;

import android.text.Editable;
import android.text.TextWatcher;

class VInput$1
  implements TextWatcher
{
  VInput$1(VInput paramVInput) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    VInput.access$002(this.this$0, paramEditable.toString());
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.this$0.inputFireEvent("input", paramCharSequence.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.component.VInput.1
 * JD-Core Version:    0.7.0.1
 */