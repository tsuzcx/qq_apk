package com.tencent.mobileqq.nearby.now.protocol.impl;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopGiftProtocolObserver;
import com.tencent.mobileqq.nearby.now.protocol.INowShortVideoProtoManager.Callback;

class NowShortVideoProtoManagerImpl$5
  extends ProtoUtils.TroopGiftProtocolObserver
{
  NowShortVideoProtoManagerImpl$5(NowShortVideoProtoManagerImpl paramNowShortVideoProtoManagerImpl, INowShortVideoProtoManager.Callback paramCallback) {}
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    INowShortVideoProtoManager.Callback localCallback = this.b;
    if (localCallback != null) {
      localCallback.a(paramInt, paramArrayOfByte, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.protocol.impl.NowShortVideoProtoManagerImpl.5
 * JD-Core Version:    0.7.0.1
 */