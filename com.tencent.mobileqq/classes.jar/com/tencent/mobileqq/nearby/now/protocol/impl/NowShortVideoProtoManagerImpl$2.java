package com.tencent.mobileqq.nearby.now.protocol.impl;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopGiftProtocolObserver;
import com.tencent.mobileqq.nearby.now.protocol.INowShortVideoProtoManager.Callback;
import com.tencent.qphone.base.util.QLog;

class NowShortVideoProtoManagerImpl$2
  extends ProtoUtils.TroopGiftProtocolObserver
{
  NowShortVideoProtoManagerImpl$2(NowShortVideoProtoManagerImpl paramNowShortVideoProtoManagerImpl, INowShortVideoProtoManager.Callback paramCallback) {}
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" reportPlay code:");
    ((StringBuilder)localObject).append(paramInt);
    QLog.i("reportPlay", 1, ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyNowProtocolINowShortVideoProtoManager$Callback;
    if (localObject != null) {
      ((INowShortVideoProtoManager.Callback)localObject).a(paramInt, paramArrayOfByte, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.protocol.impl.NowShortVideoProtoManagerImpl.2
 * JD-Core Version:    0.7.0.1
 */