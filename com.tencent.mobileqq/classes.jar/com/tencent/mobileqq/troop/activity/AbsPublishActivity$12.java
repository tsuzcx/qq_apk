package com.tencent.mobileqq.troop.activity;

import android.text.Editable;
import android.text.Editable.Factory;
import com.tencent.mobileqq.text.QQTextBuilder;

final class AbsPublishActivity$12
  extends Editable.Factory
{
  public Editable newEditable(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof QQTextBuilder)) {
      return (Editable)paramCharSequence;
    }
    return new QQTextBuilder(paramCharSequence, 3, 20);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.AbsPublishActivity.12
 * JD-Core Version:    0.7.0.1
 */