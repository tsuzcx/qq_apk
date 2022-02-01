package com.tencent.mobileqq.qwallet.hb.impl;

import android.os.Bundle;
import mqq.observer.BusinessObserver;

class RedPacketManagerImpl$8
  implements BusinessObserver
{
  RedPacketManagerImpl$8(RedPacketManagerImpl paramRedPacketManagerImpl) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramInt != 18) {
      return;
    }
    this.a.onGetGroupAvailableList(paramBoolean, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.impl.RedPacketManagerImpl.8
 * JD-Core Version:    0.7.0.1
 */