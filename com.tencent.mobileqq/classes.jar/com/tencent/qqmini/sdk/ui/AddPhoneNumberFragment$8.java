package com.tencent.qqmini.sdk.ui;

import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class AddPhoneNumberFragment$8
  implements TextWatcher
{
  AddPhoneNumberFragment$8(AddPhoneNumberFragment paramAddPhoneNumberFragment) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if ((paramEditable != null) && (paramEditable.length() > 0))
    {
      AddPhoneNumberFragment.access$902(this.this$0, paramEditable.toString());
      AddPhoneNumberFragment.access$1000(this.this$0).setEnabled(true);
      AddPhoneNumberFragment.access$1000(this.this$0).setClickable(true);
      AddPhoneNumberFragment.access$1000(this.this$0).setTextColor(-1);
    }
    else
    {
      AddPhoneNumberFragment.access$902(this.this$0, null);
      AddPhoneNumberFragment.access$1000(this.this$0).setEnabled(false);
      AddPhoneNumberFragment.access$1000(this.this$0).setClickable(false);
      AddPhoneNumberFragment.access$1000(this.this$0).setTextColor(Color.parseColor("#3303081A"));
    }
    paramEditable = new StringBuilder();
    paramEditable.append("mSmsCode : ");
    paramEditable.append(AddPhoneNumberFragment.access$900(this.this$0));
    QMLog.d("AddPhoneNumberFragment", paramEditable.toString());
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.AddPhoneNumberFragment.8
 * JD-Core Version:    0.7.0.1
 */