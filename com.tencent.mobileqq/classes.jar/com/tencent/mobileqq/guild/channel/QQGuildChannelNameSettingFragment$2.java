package com.tencent.mobileqq.guild.channel;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.TextView;

class QQGuildChannelNameSettingFragment$2
  implements TextWatcher
{
  QQGuildChannelNameSettingFragment$2(QQGuildChannelNameSettingFragment paramQQGuildChannelNameSettingFragment) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = paramEditable.toString();
    if ((!TextUtils.isEmpty(paramEditable)) && (!TextUtils.isEmpty(paramEditable.trim())))
    {
      this.a.d.setEnabled(true);
      return;
    }
    this.a.d.setEnabled(false);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.channel.QQGuildChannelNameSettingFragment.2
 * JD-Core Version:    0.7.0.1
 */