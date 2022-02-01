package com.tencent.mobileqq.qwallet.red.impl;

import Wallet.RedInfoSyncRsp;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class QWalletRedServiceImpl$2
  implements BusinessObserver
{
  QWalletRedServiceImpl$2(QWalletRedServiceImpl paramQWalletRedServiceImpl) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("redInfoSyncReq onReceive");
      localStringBuilder.append(paramBoolean);
      QLog.d("QWalletRedService", 2, localStringBuilder.toString());
    }
    if ((paramBoolean) && (paramBundle != null))
    {
      paramBundle = (RedInfoSyncRsp)paramBundle.getSerializable("rsp");
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("RedInfoSyncRsp|");
        if (paramBundle != null) {
          paramBundle = Integer.valueOf(paramBundle.result);
        } else {
          paramBundle = "";
        }
        localStringBuilder.append(paramBundle);
        QLog.d("QWalletRedService", 2, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.red.impl.QWalletRedServiceImpl.2
 * JD-Core Version:    0.7.0.1
 */