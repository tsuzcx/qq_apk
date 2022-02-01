package com.tencent.mobileqq.richstatus;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class EditActivity$2
  implements TextWatcher
{
  EditActivity$2(EditActivity paramEditActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    EditActivity.d = true;
    ReportController.b(this.a.app, "CliOper", "", "", "signiture", "set_clk_mdf", 0, 0, "", "", "", "");
    if ((EditActivity.c(this.a).getSelectionStart() == 7) && (EditActivity.c(this.a).getText().toString().trim().length() == 7)) {
      EditActivity.c(this.a).setSelection(paramEditable.length());
    }
    EditActivity.d(this.a);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("beforeTextChanged CharSequence = ");
    localStringBuilder.append(paramCharSequence);
    localStringBuilder.append(", start = ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", count = ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(", after = ");
    localStringBuilder.append(paramInt3);
    QLog.d("EditActivity", 2, localStringBuilder.toString());
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onTextChanged CharSequence = ");
    localStringBuilder.append(paramCharSequence);
    localStringBuilder.append(", start = ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", count = ");
    localStringBuilder.append(paramInt3);
    QLog.d("EditActivity", 2, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.EditActivity.2
 * JD-Core Version:    0.7.0.1
 */