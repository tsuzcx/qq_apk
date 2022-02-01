package com.tencent.mobileqq.guild.setting;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;

public class QQGuildMemberFragment$SearchTextWatcher
  implements TextWatcher
{
  protected QQGuildMemberFragment$SearchTextWatcher(QQGuildMemberFragment paramQQGuildMemberFragment) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = QQGuildMemberFragment.h(this.a);
    if (TextUtils.isEmpty(paramEditable))
    {
      QQGuildMemberFragment.i(this.a);
      return;
    }
    QQGuildMemberFragment.a(this.a, paramEditable);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.setting.QQGuildMemberFragment.SearchTextWatcher
 * JD-Core Version:    0.7.0.1
 */