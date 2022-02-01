package com.tencent.mobileqq.qwallet.config.impl;

import com.tencent.mobileqq.qwallet.config.IQWalletConfigService;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class QWalletConfigServiceImpl$1
  implements Runnable
{
  QWalletConfigServiceImpl$1(QWalletConfigServiceImpl paramQWalletConfigServiceImpl, WeakReference paramWeakReference) {}
  
  public void run()
  {
    IQWalletConfigService localIQWalletConfigService = (IQWalletConfigService)this.a.get();
    if (localIQWalletConfigService != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QWalletConfigServiceImpl", 2, "getAllConfigAgain");
      }
      localIQWalletConfigService.tryGetConfig(QWalletConfigServiceImpl.access$000(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.config.impl.QWalletConfigServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */