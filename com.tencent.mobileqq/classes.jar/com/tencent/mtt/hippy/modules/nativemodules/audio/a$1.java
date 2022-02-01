package com.tencent.mtt.hippy.modules.nativemodules.audio;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.util.Log;

class a$1
  implements MediaPlayer.OnPreparedListener
{
  a$1(a parama) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    Log.d(a.j(), "on prepared");
    a.a(this.a, a.a.e);
    a.a(this.a).a(paramMediaPlayer);
    a.b(this.a).start();
    a.a(this.a, a.a.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.modules.nativemodules.audio.a.1
 * JD-Core Version:    0.7.0.1
 */