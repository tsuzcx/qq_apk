package com.tencent.mobileqq.nearby.now.protocol.impl;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopGiftProtocolObserver;
import com.tencent.mobileqq.nearby.now.protocol.INowShortVideoProtoManager.Callback;
import com.tencent.qphone.base.util.QLog;

class NowShortVideoProtoManagerImpl$4
  extends ProtoUtils.TroopGiftProtocolObserver
{
  NowShortVideoProtoManagerImpl$4(NowShortVideoProtoManagerImpl paramNowShortVideoProtoManagerImpl, String paramString, INowShortVideoProtoManager.Callback paramCallback) {}
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt != 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getMediaDetailInfo错误   errorCode=");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", data=");
      ((StringBuilder)localObject).append(paramArrayOfByte);
      ((StringBuilder)localObject).append(", mQueryString=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      QLog.i("getMediaDetailInfo", 1, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyNowProtocolINowShortVideoProtoManager$Callback;
    if (localObject != null) {
      ((INowShortVideoProtoManager.Callback)localObject).a(paramInt, paramArrayOfByte, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.protocol.impl.NowShortVideoProtoManagerImpl.4
 * JD-Core Version:    0.7.0.1
 */