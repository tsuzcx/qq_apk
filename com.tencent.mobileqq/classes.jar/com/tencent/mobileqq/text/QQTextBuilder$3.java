package com.tencent.mobileqq.text;

import android.text.Editable;
import android.text.Editable.Factory;

final class QQTextBuilder$3
  extends Editable.Factory
{
  QQTextBuilder$3(int paramInt) {}
  
  public Editable newEditable(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof QQTextBuilder)) {
      return (Editable)paramCharSequence;
    }
    return new QQTextBuilder(paramCharSequence, 3, this.val$size);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.text.QQTextBuilder.3
 * JD-Core Version:    0.7.0.1
 */