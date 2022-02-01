package com.tencent.mobileqq.qwallet.config.impl;

import Wallet.RspWalletConfig;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class QWalletConfigServiceImpl$3
  implements BusinessObserver
{
  QWalletConfigServiceImpl$3(QWalletConfigServiceImpl paramQWalletConfigServiceImpl) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramInt == 17)
    {
      if (!paramBoolean) {}
      try
      {
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.d("QWalletConfigServiceImpl", 2, "setConfigSession fail get rsp:");
        return;
      }
      catch (Exception paramBundle)
      {
        StringBuilder localStringBuilder;
        paramBundle.printStackTrace();
      }
      paramBundle = (RspWalletConfig)paramBundle.getSerializable("rsp");
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("setConfigSession RspWalletConfig|");
        localStringBuilder.append(paramBundle);
        QLog.d("QWalletConfigServiceImpl", 2, localStringBuilder.toString());
        return;
      }
    }
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.config.impl.QWalletConfigServiceImpl.3
 * JD-Core Version:    0.7.0.1
 */