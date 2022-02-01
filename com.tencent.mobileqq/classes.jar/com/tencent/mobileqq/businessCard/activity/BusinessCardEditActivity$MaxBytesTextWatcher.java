package com.tencent.mobileqq.businessCard.activity;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.tencent.mobileqq.businessCard.views.ClearEllipsisEditText;

class BusinessCardEditActivity$MaxBytesTextWatcher
  implements TextWatcher
{
  boolean a = true;
  int b;
  EditText c;
  boolean d = false;
  int e;
  String f = "";
  
  public BusinessCardEditActivity$MaxBytesTextWatcher(BusinessCardEditActivity paramBusinessCardEditActivity, int paramInt, EditText paramEditText)
  {
    this.b = paramInt;
    this.c = paramEditText;
    this.e = 0;
  }
  
  public BusinessCardEditActivity$MaxBytesTextWatcher(BusinessCardEditActivity paramBusinessCardEditActivity, int paramInt1, EditText paramEditText, int paramInt2)
  {
    this.b = paramInt1;
    this.c = paramEditText;
    this.e = paramInt2;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if ((this.e == 1) && (!this.f.equals(paramEditable.toString())))
    {
      boolean bool;
      if (this.a) {
        bool = this.d;
      } else {
        bool = true;
      }
      this.d = bool;
    }
    this.a = false;
    paramEditable = this.c;
    if ((paramEditable instanceof ClearEllipsisEditText)) {
      paramEditable = ((ClearEllipsisEditText)paramEditable).getTotalText();
    } else {
      paramEditable = paramEditable.getText().toString();
    }
    int i = paramEditable.length();
    int j;
    if ((this.c.getTag() != null) && (((String)this.c.getTag()).equals("name")))
    {
      i = paramEditable.getBytes().length;
      j = 1;
    }
    else
    {
      j = 0;
    }
    if (i > this.b)
    {
      while (i > this.b)
      {
        paramEditable = paramEditable.substring(0, paramEditable.length() - 1);
        if (j != 0) {
          i = paramEditable.getBytes().length;
        } else {
          i = paramEditable.length();
        }
      }
      this.c.setText(paramEditable);
      this.c.setSelection(paramEditable.length());
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.f = paramCharSequence.toString();
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity.MaxBytesTextWatcher
 * JD-Core Version:    0.7.0.1
 */