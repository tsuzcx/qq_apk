package com.tencent.mobileqq.richstatus;

import android.text.Editable;
import android.text.Editable.Factory;
import android.text.TextPaint;
import android.widget.EditText;
import com.tencent.mobileqq.text.QQTextBuilder;

class SignatureHistoryFragment$2
  extends Editable.Factory
{
  SignatureHistoryFragment$2(SignatureHistoryFragment paramSignatureHistoryFragment) {}
  
  public Editable newEditable(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof QQTextBuilder)) {
      return (Editable)paramCharSequence;
    }
    return new QQTextBuilder(paramCharSequence, 3, (int)(SignatureHistoryFragment.a(this.a).getTextSize() / SignatureHistoryFragment.a(this.a).getPaint().density));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignatureHistoryFragment.2
 * JD-Core Version:    0.7.0.1
 */