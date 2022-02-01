package com.tencent.mobileqq.qwallet.hb.grap.voice.impl;

import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.observer.BusinessObserver;

class VoiceRedPacketHelperImpl$2$1
  implements BusinessObserver
{
  VoiceRedPacketHelperImpl$2$1(VoiceRedPacketHelperImpl.2 param2, long paramLong) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    ThreadManager.postImmediately(new VoiceRedPacketHelperImpl.2.1.1(this, paramBoolean, paramBundle, paramInt), null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.voice.impl.VoiceRedPacketHelperImpl.2.1
 * JD-Core Version:    0.7.0.1
 */