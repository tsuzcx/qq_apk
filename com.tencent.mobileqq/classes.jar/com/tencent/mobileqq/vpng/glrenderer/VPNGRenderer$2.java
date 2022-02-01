package com.tencent.mobileqq.vpng.glrenderer;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import cooperation.liveroom.LiveRoomGiftCallback;

class VPNGRenderer$2
  implements MediaPlayer.OnErrorListener
{
  VPNGRenderer$2(VPNGRenderer paramVPNGRenderer) {}
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if (VPNGRenderer.d(this.a) != null) {
      VPNGRenderer.d(this.a).onCall(2, "");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vpng.glrenderer.VPNGRenderer.2
 * JD-Core Version:    0.7.0.1
 */