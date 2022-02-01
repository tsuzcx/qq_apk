package com.tencent.mobileqq.richstatus;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import com.tencent.mobileqq.text.TextUtils;
import com.tencent.mobileqq.widget.QQToast;

class SignatureHistoryFragment$3
  implements TextWatcher
{
  private CharSequence b;
  private int c;
  private int d;
  
  SignatureHistoryFragment$3(SignatureHistoryFragment paramSignatureHistoryFragment) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    CharSequence localCharSequence = this.b;
    if ((localCharSequence != null) && (TextUtils.getQQTextCharCount(String.valueOf(localCharSequence), 3) > 50))
    {
      QQToast.makeText(this.a.getBaseActivity(), 1, 2131887156, 0).show();
      paramEditable.delete(this.c, this.d);
    }
    if ((paramEditable != null) && (paramEditable.length() != 0))
    {
      SignatureHistoryFragment.b(this.a).setEnabled(true);
      return;
    }
    SignatureHistoryFragment.b(this.a).setEnabled(false);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.b = paramCharSequence;
    this.c = paramInt1;
    this.d = (paramInt1 + paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignatureHistoryFragment.3
 * JD-Core Version:    0.7.0.1
 */