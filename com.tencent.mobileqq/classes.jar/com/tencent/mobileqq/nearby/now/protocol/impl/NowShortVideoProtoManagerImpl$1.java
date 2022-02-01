package com.tencent.mobileqq.nearby.now.protocol.impl;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopGiftProtocolObserver;
import com.tencent.mobileqq.nearby.now.protocol.INowShortVideoProtoManager.Callback;

class NowShortVideoProtoManagerImpl$1
  extends ProtoUtils.TroopGiftProtocolObserver
{
  NowShortVideoProtoManagerImpl$1(NowShortVideoProtoManagerImpl paramNowShortVideoProtoManagerImpl, INowShortVideoProtoManager.Callback paramCallback) {}
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    INowShortVideoProtoManager.Callback localCallback = this.jdField_a_of_type_ComTencentMobileqqNearbyNowProtocolINowShortVideoProtoManager$Callback;
    if (localCallback != null) {
      localCallback.a(paramInt, paramArrayOfByte, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.protocol.impl.NowShortVideoProtoManagerImpl.1
 * JD-Core Version:    0.7.0.1
 */