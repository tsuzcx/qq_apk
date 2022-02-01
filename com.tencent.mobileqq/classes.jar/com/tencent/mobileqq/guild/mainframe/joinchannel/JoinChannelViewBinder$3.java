package com.tencent.mobileqq.guild.mainframe.joinchannel;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;

class JoinChannelViewBinder$3
  implements TextWatcher
{
  JoinChannelViewBinder$3(JoinChannelViewBinder paramJoinChannelViewBinder) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    JoinChannelViewBinder.a(this.a, TextUtils.isEmpty(paramCharSequence.toString().trim()) ^ true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.joinchannel.JoinChannelViewBinder.3
 * JD-Core Version:    0.7.0.1
 */