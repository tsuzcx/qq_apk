package com.tencent.mobileqq.copyprompt;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;

class LiteCopyPromptHelper$1
  implements TextWatcher
{
  LiteCopyPromptHelper$1(LiteCopyPromptHelper paramLiteCopyPromptHelper) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!TextUtils.isEmpty(paramCharSequence)) {
      LiteCopyPromptHelper.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.copyprompt.LiteCopyPromptHelper.1
 * JD-Core Version:    0.7.0.1
 */