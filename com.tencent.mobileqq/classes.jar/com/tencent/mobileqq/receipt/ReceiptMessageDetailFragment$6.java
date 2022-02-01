package com.tencent.mobileqq.receipt;

import android.os.Handler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class ReceiptMessageDetailFragment$6
  extends MessageObserver
{
  ReceiptMessageDetailFragment$6(ReceiptMessageDetailFragment paramReceiptMessageDetailFragment) {}
  
  public void onReceiptMessageReadReportResult(long paramLong, int paramInt)
  {
    if (ReceiptMessageDetailFragment.b(this.a) == paramLong) {
      if (paramInt == 0)
      {
        QLog.d("ReceiptMessageDetailFragment", 4, "send read report in c2c succ");
        ReceiptMessageDetailFragment.a(this.a, 0, 0, false);
        ReceiptMessageDetailFragment.a(this.a).removeObserver(this);
        if (this.a.isAdded())
        {
          ReceiptMessageDetailFragment.a(this.a).sendEmptyMessage(4);
          ReceiptMessageDetailFragment.a(this.a, 1, true);
        }
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("send read report in c2c fail with reply codes: ");
        localStringBuilder.append(paramInt);
        QLog.d("ReceiptMessageDetailFragment", 4, localStringBuilder.toString());
        ReceiptMessageDetailFragment.a(this.a).removeObserver(this);
        if (this.a.isAdded()) {
          ReceiptMessageDetailFragment.a(this.a).sendEmptyMessage(5);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.receipt.ReceiptMessageDetailFragment.6
 * JD-Core Version:    0.7.0.1
 */