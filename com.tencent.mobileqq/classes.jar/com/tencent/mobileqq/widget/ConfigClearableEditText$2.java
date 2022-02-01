package com.tencent.mobileqq.widget;

import android.text.Editable;
import android.text.TextWatcher;

class ConfigClearableEditText$2
  implements TextWatcher
{
  ConfigClearableEditText$2(ConfigClearableEditText paramConfigClearableEditText) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    paramCharSequence = this.a.getText().toString();
    if (this.a.isFocused())
    {
      if ((paramCharSequence != null) && (paramCharSequence.length() != 0))
      {
        if ((!ConfigClearableEditText.d(this.a)) && (!ConfigClearableEditText.e(this.a)))
        {
          this.a.setClearButtonVisible(false);
          return;
        }
        this.a.setClearButtonVisible(true);
        return;
      }
      this.a.setClearButtonVisible(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ConfigClearableEditText.2
 * JD-Core Version:    0.7.0.1
 */