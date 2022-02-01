package com.tencent.mobileqq.guild.widget;

import android.text.Editable;
import android.text.Editable.Factory;
import com.tencent.mobileqq.text.QQTextBuilder;

class CharacterCountEditText$1
  extends Editable.Factory
{
  CharacterCountEditText$1(CharacterCountEditText paramCharacterCountEditText) {}
  
  public Editable newEditable(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof QQTextBuilder)) {
      return (Editable)paramCharSequence;
    }
    return new QQTextBuilder(paramCharSequence, 2, 20);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.widget.CharacterCountEditText.1
 * JD-Core Version:    0.7.0.1
 */