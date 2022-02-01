package com.tencent.mobileqq.receipt;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.service.message.MessageUtils;
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
    int i = ReceiptMessageDetailFragment.c(this.this$0).a;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 3000) {
          return;
        }
        ReceiptMessageDetailFragment.h(this.this$0);
        return;
      }
      ReceiptMessageDetailFragment.g(this.this$0);
      return;
    }
    ReceiptMessageDetailFragment.j(this.this$0).addObserver(ReceiptMessageDetailFragment.i(this.this$0), false);
    QLog.d("ReceiptMessageDetailFragment", 4, "send read report in c2c");
    ReceiptMessageDetailFragment localReceiptMessageDetailFragment1 = this.this$0;
    MessageHandler localMessageHandler = ReceiptMessageDetailFragment.j(localReceiptMessageDetailFragment1).getMsgHandler();
    long l = ReceiptMessageDetailFragment.k(this.this$0);
    ReceiptMessageDetailFragment localReceiptMessageDetailFragment2 = this.this$0;
    ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment1, localMessageHandler.a(l, ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment2, ReceiptMessageDetailFragment.j(localReceiptMessageDetailFragment2).getCurrentAccountUin()), ReceiptMessageDetailFragment.l(this.this$0), MessageUtils.a(ReceiptMessageDetailFragment.m(this.this$0))));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.receipt.ReceiptMessageDetailFragment.4
 * JD-Core Version:    0.7.0.1
 */