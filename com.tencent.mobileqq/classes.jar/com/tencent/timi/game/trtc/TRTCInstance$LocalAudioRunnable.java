package com.tencent.timi.game.trtc;

import com.tencent.trtc.TRTCCloud;

class TRTCInstance$LocalAudioRunnable
  implements Runnable
{
  public boolean a;
  
  private TRTCInstance$LocalAudioRunnable(TRTCInstance paramTRTCInstance) {}
  
  public void run()
  {
    if (this.a)
    {
      TRTCInstance.a(this.this$0).startLocalAudio();
      return;
    }
    TRTCInstance.a(this.this$0).stopLocalAudio();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.trtc.TRTCInstance.LocalAudioRunnable
 * JD-Core Version:    0.7.0.1
 */