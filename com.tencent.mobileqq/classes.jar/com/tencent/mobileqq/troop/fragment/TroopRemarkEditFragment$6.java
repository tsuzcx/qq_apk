package com.tencent.mobileqq.troop.fragment;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;

class TroopRemarkEditFragment$6
  implements TextWatcher
{
  TroopRemarkEditFragment$6(TroopRemarkEditFragment paramTroopRemarkEditFragment) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = new QQText(paramCharSequence, 3);
    try
    {
      if ((((QQText)localObject).toString().getBytes("utf-8").length > TroopRemarkEditFragment.a) && ((paramCharSequence instanceof Editable)))
      {
        TextUtils.backspace(TroopRemarkEditFragment.a(this.a));
        return;
      }
    }
    catch (UnsupportedEncodingException paramCharSequence)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("UnsupportedEncodingException");
        ((StringBuilder)localObject).append(paramCharSequence.getMessage());
        QLog.d("TroopRemarkEditFragment", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.fragment.TroopRemarkEditFragment.6
 * JD-Core Version:    0.7.0.1
 */