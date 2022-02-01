package com.tencent.mobileqq.troop.activity.editinfo;

import android.text.Editable;
import android.text.TextWatcher;

class EditInfoActivity$5
  implements TextWatcher
{
  EditInfoActivity$5(EditInfoActivity paramEditInfoActivity) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.a.updateEditTextAndNum(paramCharSequence);
    if (this.a.editInfoApi != null) {
      this.a.editInfoApi.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.editinfo.EditInfoActivity.5
 * JD-Core Version:    0.7.0.1
 */