package com.tencent.mobileqq.forward;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

class ForwardFileOption$12
  implements TextWatcher
{
  private String b;
  private int c;
  
  ForwardFileOption$12(ForwardFileOption paramForwardFileOption) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.b = paramCharSequence.toString();
    this.c = paramInt1;
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramCharSequence.toString().length() > 36)
    {
      ForwardFileOption.a(this.a, -4);
      if ((paramInt3 > 0) && (paramInt2 < paramInt3))
      {
        paramInt1 = this.c;
        if (!this.b.equals(""))
        {
          ForwardFileOption.e(this.a).setText(this.b);
          ForwardFileOption.e(this.a).setSelection(paramInt1);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardFileOption.12
 * JD-Core Version:    0.7.0.1
 */