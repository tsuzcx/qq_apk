package com.tencent.mobileqq.text;

import android.text.Editable;
import android.text.Editable.Factory;

final class QQTextBuilder$1
  extends Editable.Factory
{
  public Editable newEditable(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof QQTextBuilder)) {
      return (Editable)paramCharSequence;
    }
    return new QQTextBuilder(paramCharSequence, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.text.QQTextBuilder.1
 * JD-Core Version:    0.7.0.1
 */