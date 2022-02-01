package com.tencent.mobileqq.qwallet.transaction.impl;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

class TransactionActivity$2
  implements TextWatcher
{
  TransactionActivity$2(TransactionActivity paramTransactionActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (TransactionActivity.access$1100(this.a).getText().length() > 4)
    {
      if (!TransactionActivity.access$1200(this.a).isEnabled())
      {
        TransactionActivity.access$1200(this.a).setEnabled(true);
        TransactionActivity.access$1200(this.a).setClickable(true);
        paramEditable = this.a;
        paramEditable.addUploadData(TransactionActivity.access$900(paramEditable), 128, "transfer.qqid.enable", "", "", TransactionActivity.access$1000(this.a), "");
      }
    }
    else if (TransactionActivity.access$1200(this.a).isEnabled())
    {
      TransactionActivity.access$1200(this.a).setClickable(false);
      TransactionActivity.access$1200(this.a).setEnabled(false);
      paramEditable = this.a;
      paramEditable.addUploadData(TransactionActivity.access$900(paramEditable), 128, "transfer.qqid.disable", "", "", TransactionActivity.access$1000(this.a), "");
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.transaction.impl.TransactionActivity.2
 * JD-Core Version:    0.7.0.1
 */