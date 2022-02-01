package com.tencent.mobileqq.qwallet.transaction.impl;

import cooperation.qwallet.plugin.impl.QWalletHelperImpl;
import org.json.JSONObject;

class TransactionActivity$3
  implements Runnable
{
  TransactionActivity$3(TransactionActivity paramTransactionActivity) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = QWalletHelperImpl.loadUnifiedConfig(TransactionActivity.access$1300(this.this$0));
      if (localJSONObject != null)
      {
        localJSONObject = localJSONObject.optJSONObject("qpayment");
        if (localJSONObject != null)
        {
          TransactionActivity.access$702(this.this$0, localJSONObject.optInt("large_transfer_remind_fee"));
          TransactionActivity.access$802(this.this$0, localJSONObject.optString("large_transfer_remind_msg"));
          TransactionActivity.access$1402(this.this$0, localJSONObject.optInt("min_transfer_stranger_fee"));
          TransactionActivity.access$1502(this.this$0, localJSONObject.optString("min_transfer_stranger_msg"));
          TransactionActivity.access$1600(this.this$0);
          return;
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.transaction.impl.TransactionActivity.3
 * JD-Core Version:    0.7.0.1
 */