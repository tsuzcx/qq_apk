package com.tencent.mobileqq.businessCard.views;

import android.text.Editable;
import android.text.TextWatcher;

class ClearEllipsisEditText$1
  implements TextWatcher
{
  ClearEllipsisEditText$1(ClearEllipsisEditText paramClearEllipsisEditText) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((ClearEllipsisEditText.a(this.a)) && (!ClearEllipsisEditText.b(this.a))) {
      ClearEllipsisEditText.a(this.a, paramCharSequence.toString());
    }
    ClearEllipsisEditText.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.businessCard.views.ClearEllipsisEditText.1
 * JD-Core Version:    0.7.0.1
 */