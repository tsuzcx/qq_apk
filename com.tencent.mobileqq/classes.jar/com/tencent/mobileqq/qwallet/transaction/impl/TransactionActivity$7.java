package com.tencent.mobileqq.qwallet.transaction.impl;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.widget.EditText;

class TransactionActivity$7
  implements Runnable
{
  TransactionActivity$7(TransactionActivity paramTransactionActivity) {}
  
  public void run()
  {
    MotionEvent localMotionEvent1 = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 0, 0.0F, 0.0F, 0);
    TransactionActivity.access$1100(this.this$0).dispatchTouchEvent(localMotionEvent1);
    MotionEvent localMotionEvent2 = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 1, 0.0F, 0.0F, 0);
    TransactionActivity.access$1100(this.this$0).dispatchTouchEvent(localMotionEvent2);
    localMotionEvent1.recycle();
    localMotionEvent2.recycle();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.transaction.impl.TransactionActivity.7
 * JD-Core Version:    0.7.0.1
 */