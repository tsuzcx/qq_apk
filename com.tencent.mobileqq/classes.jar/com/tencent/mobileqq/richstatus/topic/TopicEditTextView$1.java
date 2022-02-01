package com.tencent.mobileqq.richstatus.topic;

import android.text.Editable;
import android.text.Editable.Factory;
import com.tencent.mobileqq.text.QQTextBuilder;

final class TopicEditTextView$1
  extends Editable.Factory
{
  public Editable newEditable(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof QQTextBuilder)) {
      return (Editable)paramCharSequence;
    }
    return new QQTextBuilder(paramCharSequence, 1, 20);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.topic.TopicEditTextView.1
 * JD-Core Version:    0.7.0.1
 */