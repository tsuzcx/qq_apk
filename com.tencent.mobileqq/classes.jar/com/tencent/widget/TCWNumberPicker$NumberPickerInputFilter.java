package com.tencent.widget;

import android.text.InputFilter;
import android.text.Spanned;

class TCWNumberPicker$NumberPickerInputFilter
  implements InputFilter
{
  private TCWNumberPicker$NumberPickerInputFilter(TCWNumberPicker paramTCWNumberPicker) {}
  
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    if (TCWNumberPicker.a(this.a) == null) {
      return TCWNumberPicker.a(this.a).filter(paramCharSequence, paramInt1, paramInt2, paramSpanned, paramInt3, paramInt4);
    }
    paramCharSequence = String.valueOf(paramCharSequence.subSequence(paramInt1, paramInt2));
    Object localObject = new StringBuilder();
    paramInt1 = 0;
    ((StringBuilder)localObject).append(String.valueOf(paramSpanned.subSequence(0, paramInt3)));
    ((StringBuilder)localObject).append(paramCharSequence);
    ((StringBuilder)localObject).append(paramSpanned.subSequence(paramInt4, paramSpanned.length()));
    paramSpanned = String.valueOf(((StringBuilder)localObject).toString()).toLowerCase();
    localObject = TCWNumberPicker.a(this.a);
    paramInt2 = localObject.length;
    while (paramInt1 < paramInt2)
    {
      if (localObject[paramInt1].toLowerCase().startsWith(paramSpanned)) {
        return paramCharSequence;
      }
      paramInt1 += 1;
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.TCWNumberPicker.NumberPickerInputFilter
 * JD-Core Version:    0.7.0.1
 */