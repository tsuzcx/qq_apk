package com.tencent.mobileqq.selectmember;

import android.text.Editable;
import android.text.TextWatcher;

class SelectedAndSearchBar$3
  implements TextWatcher
{
  SelectedAndSearchBar$3(SelectedAndSearchBar paramSelectedAndSearchBar) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (SelectedAndSearchBar.b(this.a) != null) {
      SelectedAndSearchBar.b(this.a).a(paramEditable);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.SelectedAndSearchBar.3
 * JD-Core Version:    0.7.0.1
 */