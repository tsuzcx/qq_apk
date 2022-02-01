package com.tencent.mobileqq.qwallet.red.impl;

import com.tencent.mobileqq.qwallet.impl.QWalletTools;

class QWRedConfig$1
  implements Runnable
{
  QWRedConfig$1(QWRedConfig paramQWRedConfig) {}
  
  public void run()
  {
    synchronized (QWRedConfig.access$000(this.this$0))
    {
      QWalletTools.a(this.this$0, QWRedConfig.access$100(this.this$0));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.red.impl.QWRedConfig.1
 * JD-Core Version:    0.7.0.1
 */