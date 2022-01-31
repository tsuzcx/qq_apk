package com.tencent.mobileqq.receipt;

import axau;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
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
    switch (ReceiptMessageDetailFragment.a(this.this$0).jdField_a_of_type_Int)
    {
    default: 
      return;
    case 3000: 
      ReceiptMessageDetailFragment.e(this.this$0);
      return;
    case 0: 
      ReceiptMessageDetailFragment.a(this.this$0).addObserver(ReceiptMessageDetailFragment.b(this.this$0), false);
      ReceiptMessageDetailFragment.b(this.this$0, ReceiptMessageDetailFragment.a(this.this$0).a().b(ReceiptMessageDetailFragment.a(this.this$0), ReceiptMessageDetailFragment.a(this.this$0, ReceiptMessageDetailFragment.a(this.this$0).jdField_a_of_type_JavaLangString), ReceiptMessageDetailFragment.a(this.this$0), axau.a(ReceiptMessageDetailFragment.b(this.this$0))));
      return;
    }
    ReceiptMessageDetailFragment.f(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.receipt.ReceiptMessageDetailFragment.5
 * JD-Core Version:    0.7.0.1
 */