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
    if ((this.a.d != null) && (this.a.d.getText() != null))
    {
      paramEditable = this.a;
      if (paramEditable.b(paramEditable.d.getText().toString())) {
        this.a.d();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.impl.EmojiFragment.1
 * JD-Core Version:    0.7.0.1
 */