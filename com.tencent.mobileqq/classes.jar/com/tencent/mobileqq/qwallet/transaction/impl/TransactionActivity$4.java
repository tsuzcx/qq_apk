package com.tencent.mobileqq.qwallet.transaction.impl;

import android.widget.TextView;
import com.tencent.mobileqq.qqpay.ui.R.string;

class TransactionActivity$4
  implements Runnable
{
  TransactionActivity$4(TransactionActivity paramTransactionActivity, String paramString) {}
  
  public void run()
  {
    TextView localTextView = TransactionActivity.access$1700(this.this$0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.this$0.getString(R.string.M));
    localStringBuilder.append("（");
    localStringBuilder.append(this.a);
    localStringBuilder.append("）");
    localTextView.setText(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.transaction.impl.TransactionActivity.4
 * JD-Core Version:    0.7.0.1
 */