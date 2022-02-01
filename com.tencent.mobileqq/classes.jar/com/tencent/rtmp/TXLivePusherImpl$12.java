package com.tencent.rtmp;

import com.tencent.liteav.audio.TXAudioEffectManagerImpl.TXAudioEffectManagerListener;

class TXLivePusherImpl$12
  implements TXAudioEffectManagerImpl.TXAudioEffectManagerListener
{
  TXLivePusherImpl$12(TXLivePusherImpl paramTXLivePusherImpl) {}
  
  public void onSwitchVoiceEarMonitor(boolean paramBoolean)
  {
    TXLivePusherImpl.d(this.a).mEnableAudioPreview = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rtmp.TXLivePusherImpl.12
 * JD-Core Version:    0.7.0.1
 */