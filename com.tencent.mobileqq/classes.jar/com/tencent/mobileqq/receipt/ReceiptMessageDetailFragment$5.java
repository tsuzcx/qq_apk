package com.tencent.mobileqq.receipt;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.qphone.base.util.QLog;

class ReceiptMessageDetailFragment$5
  implements Runnable
{
  ReceiptMessageDetailFragment$5(ReceiptMessageDetailFragment paramReceiptMessageDetailFragment) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReceiptMessageDetailFragment", 2, "mSendFetchReadStatusRequestRunnable");
    }
    int i = ReceiptMessageDetailFragment.c(this.this$0).a;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 3000) {
          return;
        }
        ReceiptMessageDetailFragment.n(this.this$0);
        return;
      }
      ReceiptMessageDetailFragment.p(this.this$0);
      return;
    }
    ReceiptMessageDetailFragment.j(this.this$0).addObserver(ReceiptMessageDetailFragment.o(this.this$0), false);
    ReceiptMessageDetailFragment localReceiptMessageDetailFragment1 = this.this$0;
    MessageHandler localMessageHandler = ReceiptMessageDetailFragment.j(localReceiptMessageDetailFragment1).getMsgHandler();
    long l = ReceiptMessageDetailFragment.k(this.this$0);
    ReceiptMessageDetailFragment localReceiptMessageDetailFragment2 = this.this$0;
    ReceiptMessageDetailFragment.b(localReceiptMessageDetailFragment1, localMessageHandler.b(l, ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment2, ReceiptMessageDetailFragment.c(localReceiptMessageDetailFragment2).b), ReceiptMessageDetailFragment.l(this.this$0), MessageUtils.a(ReceiptMessageDetailFragment.m(this.this$0))));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.receipt.ReceiptMessageDetailFragment.5
 * JD-Core Version:    0.7.0.1
 */