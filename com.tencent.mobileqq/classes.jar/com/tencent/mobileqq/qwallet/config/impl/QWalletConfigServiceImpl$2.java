package com.tencent.mobileqq.qwallet.config.impl;

import Wallet.RspWalletConfig;
import android.os.Bundle;
import com.tencent.mobileqq.qwallet.config.IQWalletConfigService;
import com.tencent.mobileqq.qwallet.config.IQWalletConfigService.ConfigListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.observer.BusinessObserver;

class QWalletConfigServiceImpl$2
  implements BusinessObserver
{
  QWalletConfigServiceImpl$2(QWalletConfigServiceImpl paramQWalletConfigServiceImpl, long paramLong, IQWalletConfigService.ConfigListener paramConfigListener, WeakReference paramWeakReference) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramInt == 10)
    {
      if (!paramBoolean) {}
      try
      {
        if (QLog.isColorLevel())
        {
          paramBundle = new StringBuilder();
          paramBundle.append("fail get rsp:");
          paramBundle.append(this.jdField_a_of_type_Long);
          QLog.d("QWalletConfigServiceImpl", 2, paramBundle.toString());
        }
        QWalletConfigServiceImpl.access$102(this.jdField_a_of_type_ComTencentMobileqqQwalletConfigImplQWalletConfigServiceImpl, -1L);
        return;
      }
      catch (Throwable paramBundle)
      {
        StringBuilder localStringBuilder;
        paramBundle.printStackTrace();
      }
      paramBundle = (RspWalletConfig)paramBundle.getSerializable("rsp");
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("RspWalletConfig|");
        localStringBuilder.append(paramBundle);
        QLog.d("QWalletConfigServiceImpl", 2, localStringBuilder.toString());
      }
      QWalletConfigServiceImpl.access$200(this.jdField_a_of_type_ComTencentMobileqqQwalletConfigImplQWalletConfigServiceImpl).handleRsp(paramBundle, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqQwalletConfigIQWalletConfigService$ConfigListener, (IQWalletConfigService)this.jdField_a_of_type_JavaLangRefWeakReference.get());
    }
    QWalletConfigServiceImpl.access$102(this.jdField_a_of_type_ComTencentMobileqqQwalletConfigImplQWalletConfigServiceImpl, -1L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.config.impl.QWalletConfigServiceImpl.2
 * JD-Core Version:    0.7.0.1
 */