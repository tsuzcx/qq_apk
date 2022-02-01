package com.tencent.mobileqq.copyprompt;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;

class CopyPromptHelper$1
  implements TextWatcher
{
  CopyPromptHelper$1(CopyPromptHelper paramCopyPromptHelper) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!TextUtils.isEmpty(paramCharSequence)) {
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.copyprompt.CopyPromptHelper.1
 * JD-Core Version:    0.7.0.1
 */