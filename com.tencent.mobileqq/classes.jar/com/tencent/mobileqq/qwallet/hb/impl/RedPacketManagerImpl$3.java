package com.tencent.mobileqq.qwallet.hb.impl;

import Wallet.SetSelectedSkinRsp;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class RedPacketManagerImpl$3
  implements BusinessObserver
{
  RedPacketManagerImpl$3(RedPacketManagerImpl paramRedPacketManagerImpl, BusinessObserver paramBusinessObserver) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject = (SetSelectedSkinRsp)paramBundle.getSerializable("rsp");
    this.jdField_a_of_type_MqqObserverBusinessObserver.onReceive(paramInt, paramBoolean, paramBundle);
    if (QLog.isColorLevel())
    {
      paramBundle = this.jdField_a_of_type_ComTencentMobileqqQwalletHbImplRedPacketManagerImpl.TAG;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setSelectedSkin2ServerIfChanged onReceive isSuccess:");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d(paramBundle, 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.impl.RedPacketManagerImpl.3
 * JD-Core Version:    0.7.0.1
 */