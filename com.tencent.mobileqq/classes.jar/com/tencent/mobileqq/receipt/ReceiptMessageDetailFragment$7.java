package com.tencent.mobileqq.receipt;

import android.os.Handler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class ReceiptMessageDetailFragment$7
  extends MessageObserver
{
  ReceiptMessageDetailFragment$7(ReceiptMessageDetailFragment paramReceiptMessageDetailFragment) {}
  
  public void onReceiptMessageFetchReadStatusResult(long paramLong1, int paramInt, long paramLong2)
  {
    if (ReceiptMessageDetailFragment.c(this.a) == paramLong1)
    {
      if (paramInt == 0)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("get read status in c2c succs with readtime: ");
        ((StringBuilder)localObject).append(paramLong2);
        QLog.d("ReceiptMessageDetailFragment", 4, ((StringBuilder)localObject).toString());
        if (paramLong2 > 0L) {
          ReceiptMessageDetailFragment.a(this.a, 1, 1, true);
        }
        if (this.a.isAdded())
        {
          localObject = this.a;
          if (paramLong2 > 0L) {
            paramInt = 1;
          } else {
            paramInt = 0;
          }
          ReceiptMessageDetailFragment.a((ReceiptMessageDetailFragment)localObject, paramInt, true);
        }
        ReceiptMessageDetailFragment.a(this.a).removeObserver(this);
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("get read status in c2c fail with reply code: ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("ReceiptMessageDetailFragment", 4, ((StringBuilder)localObject).toString());
      ReceiptMessageDetailFragment.a(this.a).removeObserver(this);
      if (this.a.isAdded()) {
        ReceiptMessageDetailFragment.a(this.a).sendEmptyMessage(20);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.receipt.ReceiptMessageDetailFragment.7
 * JD-Core Version:    0.7.0.1
 */