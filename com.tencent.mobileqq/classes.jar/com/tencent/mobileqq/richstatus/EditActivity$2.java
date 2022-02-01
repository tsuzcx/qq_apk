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
    EditActivity.a = true;
    ReportController.b(this.a.app, "CliOper", "", "", "signiture", "set_clk_mdf", 0, 0, "", "", "", "");
    if ((EditActivity.a(this.a).getSelectionStart() == 7) && (EditActivity.a(this.a).getText().toString().trim().length() == 7)) {
      EditActivity.a(this.a).setSelection(paramEditable.length());
    }
    EditActivity.a(this.a);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    QLog.d("EditActivity", 2, "beforeTextChanged CharSequence = " + paramCharSequence + ", start = " + paramInt1 + ", count = " + paramInt2 + ", after = " + paramInt3);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    QLog.d("EditActivity", 2, "onTextChanged CharSequence = " + paramCharSequence + ", start = " + paramInt1 + ", count = " + paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.EditActivity.2
 * JD-Core Version:    0.7.0.1
 */