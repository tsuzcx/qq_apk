package com.tencent.mobileqq.qwallet.hb.send.impl;

import android.text.Editable;
import android.widget.EditText;
import cooperation.qwallet.QwTextAdapter;

class EmojiFragment$1
  extends QwTextAdapter
{
  EmojiFragment$1(EmojiFragment paramEmojiFragment) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if ((this.a.b != null) && (this.a.b.getText() != null))
    {
      paramEditable = this.a;
      if (paramEditable.a(paramEditable.b.getText().toString())) {
        this.a.c();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.impl.EmojiFragment.1
 * JD-Core Version:    0.7.0.1
 */