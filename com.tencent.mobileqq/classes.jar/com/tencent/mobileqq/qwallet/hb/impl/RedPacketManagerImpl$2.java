package com.tencent.mobileqq.qwallet.hb.impl;

import Wallet.GetSkinListRsp;
import android.os.Bundle;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.observer.BusinessObserver;

class RedPacketManagerImpl$2
  implements BusinessObserver
{
  RedPacketManagerImpl$2(RedPacketManagerImpl paramRedPacketManagerImpl, String paramString, BaseQQAppInterface paramBaseQQAppInterface) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject = (GetSkinListRsp)paramBundle.getSerializable("rsp");
    paramBundle.putBoolean("isCache", false);
    if (RedPacketManagerImpl.access$000(this.jdField_a_of_type_ComTencentMobileqqQwalletHbImplRedPacketManagerImpl).isEmpty()) {
      return;
    }
    Iterator localIterator = RedPacketManagerImpl.access$000(this.jdField_a_of_type_ComTencentMobileqqQwalletHbImplRedPacketManagerImpl).iterator();
    while (localIterator.hasNext()) {
      ((BusinessObserver)localIterator.next()).onReceive(paramInt, paramBoolean, paramBundle);
    }
    if (!this.jdField_a_of_type_JavaLangString.equals("100")) {
      ThreadManager.post(new RedPacketManagerImpl.2.1(this, (GetSkinListRsp)localObject), 5, null, false);
    }
    if (QLog.isColorLevel())
    {
      paramBundle = this.jdField_a_of_type_ComTencentMobileqqQwalletHbImplRedPacketManagerImpl.TAG;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("requestRedPacketSkinList onReceive isSuccess:");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d(paramBundle, 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.impl.RedPacketManagerImpl.2
 * JD-Core Version:    0.7.0.1
 */