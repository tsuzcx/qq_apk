package com.tencent.mobileqq.onlinestatus;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mobileqq.text.TextUtils;
import com.tencent.mobileqq.widget.QQToast;

class AutoReplyEditActivity$5
  implements TextWatcher
{
  private CharSequence b;
  private int c;
  private int d;
  
  AutoReplyEditActivity$5(AutoReplyEditActivity paramAutoReplyEditActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    Object localObject = this.b;
    if ((localObject != null) && (TextUtils.getQQTextCharCount(String.valueOf(localObject), 3) > 100))
    {
      QQToast.makeText(this.a.getQBaseActivity(), 1, 2131887156, 0).show();
      paramEditable.delete(this.c, this.d);
    }
    paramEditable = this.a.k;
    localObject = this.a;
    paramEditable.setEnabled(AutoReplyEditActivity.a((AutoReplyEditActivity)localObject, String.valueOf(AutoReplyEditActivity.b((AutoReplyEditActivity)localObject).getText())));
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.b = paramCharSequence;
    this.c = paramInt1;
    this.d = (paramInt1 + paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AutoReplyEditActivity.5
 * JD-Core Version:    0.7.0.1
 */