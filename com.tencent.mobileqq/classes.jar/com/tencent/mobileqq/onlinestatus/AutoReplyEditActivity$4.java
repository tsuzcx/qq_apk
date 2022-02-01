package com.tencent.mobileqq.onlinestatus;

import android.text.Editable;
import android.text.Editable.Factory;
import android.text.TextPaint;
import android.widget.EditText;
import com.tencent.mobileqq.text.QQTextBuilder;

class AutoReplyEditActivity$4
  extends Editable.Factory
{
  AutoReplyEditActivity$4(AutoReplyEditActivity paramAutoReplyEditActivity) {}
  
  public Editable newEditable(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof QQTextBuilder)) {
      return (Editable)paramCharSequence;
    }
    return new QQTextBuilder(paramCharSequence, 3, (int)(AutoReplyEditActivity.b(this.a).getTextSize() / AutoReplyEditActivity.b(this.a).getPaint().density));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AutoReplyEditActivity.4
 * JD-Core Version:    0.7.0.1
 */