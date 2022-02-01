package com.tencent.mtt.hippy.modules.nativemodules.audio;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.util.Log;

class a$3
  implements MediaPlayer.OnBufferingUpdateListener
{
  a$3(a parama) {}
  
  public void onBufferingUpdate(MediaPlayer paramMediaPlayer, int paramInt)
  {
    Log.d(a.j(), "on buffering update");
    a.a(this.a).a(paramMediaPlayer, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.modules.nativemodules.audio.a.3
 * JD-Core Version:    0.7.0.1
 */