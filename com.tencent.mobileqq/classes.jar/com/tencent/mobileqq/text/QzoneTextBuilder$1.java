package com.tencent.mobileqq.text;

import android.text.Editable;
import android.text.Editable.Factory;

final class QzoneTextBuilder$1
  extends Editable.Factory
{
  public Editable newEditable(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof QzoneTextBuilder)) {
      return (Editable)paramCharSequence;
    }
    return new QzoneTextBuilder(paramCharSequence, 3, 20);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.text.QzoneTextBuilder.1
 * JD-Core Version:    0.7.0.1
 */