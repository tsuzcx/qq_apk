package com.tencent.mtt.hippy.modules.nativemodules.audio;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import android.util.Log;

class a$4
  implements MediaPlayer.OnErrorListener
{
  a$4(a parama) {}
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    Log.d(a.j(), "on error");
    a.a(this.a, a.a.b);
    a.a(this.a).a(paramMediaPlayer, paramInt1, paramInt2);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.modules.nativemodules.audio.a.4
 * JD-Core Version:    0.7.0.1
 */