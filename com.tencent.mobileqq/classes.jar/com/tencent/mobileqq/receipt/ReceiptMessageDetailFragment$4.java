package com.tencent.mobileqq.receipt;

import bcsa;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class ReceiptMessageDetailFragment$4
  implements Runnable
{
  ReceiptMessageDetailFragment$4(ReceiptMessageDetailFragment paramReceiptMessageDetailFragment) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReceiptMessageDetailFragment", 2, "mSendReadReportRequestRunnable");
    }
    switch (ReceiptMessageDetailFragment.a(this.this$0).a)
    {
    default: 
      return;
    case 1: 
      ReceiptMessageDetailFragment.c(this.this$0);
      return;
    case 3000: 
      ReceiptMessageDetailFragment.d(this.this$0);
      return;
    }
    ReceiptMessageDetailFragment.a(this.this$0).addObserver(ReceiptMessageDetailFragment.a(this.this$0), false);
    QLog.d("ReceiptMessageDetailFragment", 4, "send read report in c2c");
    ReceiptMessageDetailFragment.a(this.this$0, ReceiptMessageDetailFragment.a(this.this$0).a().a(ReceiptMessageDetailFragment.a(this.this$0), ReceiptMessageDetailFragment.a(this.this$0, ReceiptMessageDetailFragment.a(this.this$0).getCurrentAccountUin()), ReceiptMessageDetailFragment.a(this.this$0), bcsa.a(ReceiptMessageDetailFragment.b(this.this$0))));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.receipt.ReceiptMessageDetailFragment.4
 * JD-Core Version:    0.7.0.1
 */