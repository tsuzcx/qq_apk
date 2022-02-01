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
    if (VPNGRenderer.a(this.a))
    {
      this.a.e.start();
      if (VPNGRenderer.b(this.a)) {
        this.a.k();
      }
    }
    else
    {
      VPNGRenderer.a(this.a, false);
      if (VPNGRenderer.c(this.a) != null) {
        VPNGRenderer.c(this.a).onCompletion(this.a.e);
      }
    }
    if (VPNGRenderer.d(this.a) != null) {
      VPNGRenderer.d(this.a).onCall(7, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vpng.glrenderer.VPNGRenderer.1
 * JD-Core Version:    0.7.0.1
 */