package com.tencent.mobileqq.qwallet.hb.send.busylogic.impl;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public abstract class BaseWatcher
  implements TextWatcher
{
  protected EditText a;
  
  public BaseWatcher(EditText paramEditText)
  {
    this.a = paramEditText;
  }
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.busylogic.impl.BaseWatcher
 * JD-Core Version:    0.7.0.1
 */