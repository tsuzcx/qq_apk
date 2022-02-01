package com.tencent.mobileqq.onlinestatus;

import android.text.Editable;
import android.text.Editable.Factory;
import android.text.TextPaint;
import android.widget.TextView;
import com.tencent.mobileqq.text.QQTextBuilder;

class AutoReplyAdapter$2
  extends Editable.Factory
{
  AutoReplyAdapter$2(AutoReplyAdapter paramAutoReplyAdapter, TextView paramTextView) {}
  
  public Editable newEditable(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof QQTextBuilder)) {
      return (Editable)paramCharSequence;
    }
    return new QQTextBuilder(paramCharSequence, 3, (int)(this.a.getTextSize() / this.a.getPaint().density));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AutoReplyAdapter.2
 * JD-Core Version:    0.7.0.1
 */