package com.tencent.mobileqq.qwallet.impl;

import com.tencent.common.app.business.BaseQQAppInterface;

final class QWalletPushManager$1
  implements Runnable
{
  QWalletPushManager$1(BaseQQAppInterface paramBaseQQAppInterface) {}
  
  public void run()
  {
    if (QWalletPushManager.a(this.a)) {
      QWalletPushManager.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.impl.QWalletPushManager.1
 * JD-Core Version:    0.7.0.1
 */