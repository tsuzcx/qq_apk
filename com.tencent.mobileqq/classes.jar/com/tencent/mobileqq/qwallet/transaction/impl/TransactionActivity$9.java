package com.tencent.mobileqq.qwallet.transaction.impl;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class TransactionActivity$9
  implements DialogInterface.OnClickListener
{
  TransactionActivity$9(TransactionActivity paramTransactionActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.a;
    paramDialogInterface.addUploadData(TransactionActivity.access$900(paramDialogInterface), 128, "transfer.amount.go", "", "", TransactionActivity.access$1000(this.a), "");
    this.a.sendTransferRequest();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.transaction.impl.TransactionActivity.9
 * JD-Core Version:    0.7.0.1
 */