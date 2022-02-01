package com.tencent.open.base;

import android.text.InputFilter;
import android.text.Spanned;
import android.widget.EditText;

public class LengthInputFilter
  implements InputFilter
{
  protected EditText b;
  protected int c;
  
  public LengthInputFilter(EditText paramEditText, int paramInt)
  {
    this.b = paramEditText;
    this.c = paramInt;
  }
  
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    paramSpanned = new StringBuilder(this.b.getEditableText().toString());
    paramInt4 = this.c - StringAddition.c(paramSpanned.toString());
    paramInt3 = StringAddition.c(paramCharSequence.subSequence(paramInt1, paramInt2).toString());
    if (paramInt4 <= 0) {
      return "";
    }
    if (paramInt4 >= paramInt3) {
      return null;
    }
    paramInt3 = paramInt1;
    while (paramInt3 < paramInt2)
    {
      int j;
      int i;
      if (Character.isHighSurrogate(paramCharSequence.charAt(paramInt3)))
      {
        j = StringAddition.c(paramCharSequence.subSequence(paramInt3, paramInt3 + 2).toString());
        i = 2;
      }
      else
      {
        j = StringAddition.c(String.valueOf(paramCharSequence.charAt(paramInt3)));
        i = 1;
      }
      paramInt4 -= j;
      if (paramInt4 < 0) {
        break;
      }
      paramInt3 += i;
    }
    if (paramInt3 == paramInt1) {
      return "";
    }
    return paramCharSequence.subSequence(paramInt1, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.base.LengthInputFilter
 * JD-Core Version:    0.7.0.1
 */