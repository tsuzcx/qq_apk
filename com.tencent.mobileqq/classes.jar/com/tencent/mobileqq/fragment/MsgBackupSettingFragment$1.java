package com.tencent.mobileqq.fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;

class MsgBackupSettingFragment$1
  implements TextWatcher
{
  MsgBackupSettingFragment$1(MsgBackupSettingFragment paramMsgBackupSettingFragment, TextView paramTextView1, TextView paramTextView2) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = paramEditable.toString();
    this.a.setText(String.format(MsgBackupSettingFragment.a(this.c), new Object[] { paramEditable }));
    this.b.setText(String.format(MsgBackupSettingFragment.b(this.c), new Object[] { paramEditable }));
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.MsgBackupSettingFragment.1
 * JD-Core Version:    0.7.0.1
 */