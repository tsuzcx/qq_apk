package com.tencent.mobileqq.utils;

import android.text.Editable;
import android.text.TextWatcher;

public class GroupManagerInputTextWatcher
  implements TextWatcher
{
  public void afterTextChanged(Editable paramEditable)
  {
    int i;
    if ((paramEditable != null) && (paramEditable.toString().getBytes().length > 24)) {
      i = 1;
    }
    for (;;)
    {
      if ((i >= paramEditable.length()) || (paramEditable.toString().substring(0, i).getBytes().length > 24))
      {
        paramEditable.replace(0, paramEditable.length(), paramEditable.toString().substring(0, i - 1));
        return;
      }
      i += 1;
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.GroupManagerInputTextWatcher
 * JD-Core Version:    0.7.0.1
 */