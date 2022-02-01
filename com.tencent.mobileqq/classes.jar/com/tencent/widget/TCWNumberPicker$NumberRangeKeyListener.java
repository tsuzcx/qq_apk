package com.tencent.widget;

import android.text.Spanned;
import android.text.method.NumberKeyListener;

class TCWNumberPicker$NumberRangeKeyListener
  extends NumberKeyListener
{
  private TCWNumberPicker$NumberRangeKeyListener(TCWNumberPicker paramTCWNumberPicker) {}
  
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    CharSequence localCharSequence2 = super.filter(paramCharSequence, paramInt1, paramInt2, paramSpanned, paramInt3, paramInt4);
    CharSequence localCharSequence1 = localCharSequence2;
    if (localCharSequence2 == null) {
      localCharSequence1 = paramCharSequence.subSequence(paramInt1, paramInt2);
    }
    paramCharSequence = new StringBuilder();
    paramCharSequence.append(String.valueOf(paramSpanned.subSequence(0, paramInt3)));
    paramCharSequence.append(localCharSequence1);
    paramCharSequence.append(paramSpanned.subSequence(paramInt4, paramSpanned.length()));
    paramCharSequence = paramCharSequence.toString();
    if ("".equals(paramCharSequence)) {
      return paramCharSequence;
    }
    if (TCWNumberPicker.a(this.a, paramCharSequence) > TCWNumberPicker.a(this.a)) {
      return "";
    }
    return localCharSequence1;
  }
  
  protected char[] getAcceptedChars()
  {
    return TCWNumberPicker.a();
  }
  
  public int getInputType()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.TCWNumberPicker.NumberRangeKeyListener
 * JD-Core Version:    0.7.0.1
 */