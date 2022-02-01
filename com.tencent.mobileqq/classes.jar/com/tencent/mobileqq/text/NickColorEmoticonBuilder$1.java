package com.tencent.mobileqq.text;

import android.text.Editable;
import android.text.Editable.Factory;

final class NickColorEmoticonBuilder$1
  extends Editable.Factory
{
  public Editable newEditable(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof NickColorEmoticonBuilder)) {
      return (Editable)paramCharSequence;
    }
    return new NickColorEmoticonBuilder(paramCharSequence, 16);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.text.NickColorEmoticonBuilder.1
 * JD-Core Version:    0.7.0.1
 */