package com.tencent.mobileqq.highway.transaction;

import android.os.SystemClock;

class Transaction$TransTimeOutMonitor
  implements Runnable
{
  public volatile boolean isKilled = false;
  public long mStartTime = 0L;
  
  public Transaction$TransTimeOutMonitor(Transaction paramTransaction) {}
  
  public boolean needExtendTimeExceedLimit()
  {
    return SystemClock.uptimeMillis() - this.mStartTime >= 60000L;
  }
  
  public void run()
  {
    if (!this.isKilled) {
      this.this$0.onTransFailed(-1002, "TransTimeOut", -1002, -1002, 0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.transaction.Transaction.TransTimeOutMonitor
 * JD-Core Version:    0.7.0.1
 */