package com.tencent.mobileqq.text;

import android.text.Spannable;
import android.text.Spannable.Factory;

final class QQText$1
  extends Spannable.Factory
{
  public Spannable newSpannable(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof QQText)) {}
    try
    {
      QQText localQQText = (QQText)((QQText)paramCharSequence).clone();
      return localQQText;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      label20:
      break label20;
    }
    return super.newSpannable(paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.text.QQText.1
 * JD-Core Version:    0.7.0.1
 */