package com.tencent.mobileqq.qwallet.impl;

import Wallet.ReportHBGameRsp;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

final class QWalletTools$4
  implements BusinessObserver
{
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    paramBundle = (ReportHBGameRsp)paramBundle.getSerializable("rsp");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ReportHBGameRsp reportObserver:");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("|");
      localStringBuilder.append(paramBundle);
      QLog.d("QWalletTools", 2, localStringBuilder.toString());
    }
    if ((paramBoolean) && (paramBundle != null)) {
      paramInt = paramBundle.result;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.impl.QWalletTools.4
 * JD-Core Version:    0.7.0.1
 */