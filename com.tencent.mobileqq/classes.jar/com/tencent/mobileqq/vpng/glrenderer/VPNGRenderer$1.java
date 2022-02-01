package com.tencent.mobileqq.vpng.glrenderer;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import cooperation.liveroom.LiveRoomGiftCallback;

class VPNGRenderer$1
  implements MediaPlayer.OnCompletionListener
{
  VPNGRenderer$1(VPNGRenderer paramVPNGRenderer) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (VPNGRenderer.a(this.a)) {
      this.a.a.start();
    }
    for (;;)
    {
      if (VPNGRenderer.a(this.a) != null) {
        VPNGRenderer.a(this.a).onCall(7, "");
      }
      return;
      VPNGRenderer.a(this.a, false);
      if (VPNGRenderer.a(this.a) != null) {
        VPNGRenderer.a(this.a).onCompletion(this.a.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vpng.glrenderer.VPNGRenderer.1
 * JD-Core Version:    0.7.0.1
 */