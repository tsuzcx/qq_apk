package com.tencent.mobileqq.qwallet.hb.send.impl;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;

class BirthdayHbFragment$7
  implements TextWatcher
{
  BirthdayHbFragment$7(BirthdayHbFragment paramBirthdayHbFragment) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    TextView localTextView = BirthdayHbFragment.h(this.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramEditable.length());
    localStringBuilder.append("/");
    localStringBuilder.append(BirthdayHbFragment.g(this.a));
    localTextView.setText(localStringBuilder.toString());
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.impl.BirthdayHbFragment.7
 * JD-Core Version:    0.7.0.1
 */