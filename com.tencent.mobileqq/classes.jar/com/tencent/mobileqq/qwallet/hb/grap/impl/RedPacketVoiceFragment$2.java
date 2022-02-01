package com.tencent.mobileqq.qwallet.hb.grap.impl;

import com.tencent.mobileqq.qwallet.hb.grap.voice.impl.VoiceRecognizer;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;

class RedPacketVoiceFragment$2
  implements Runnable
{
  RedPacketVoiceFragment$2(RedPacketVoiceFragment paramRedPacketVoiceFragment, WeakReference paramWeakReference) {}
  
  public void run()
  {
    AppRuntime localAppRuntime = (AppRuntime)this.a.get();
    if (localAppRuntime != null) {
      VoiceRecognizer.a().a(localAppRuntime);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.impl.RedPacketVoiceFragment.2
 * JD-Core Version:    0.7.0.1
 */