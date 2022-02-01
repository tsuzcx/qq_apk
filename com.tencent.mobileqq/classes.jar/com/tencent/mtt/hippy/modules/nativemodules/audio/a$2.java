package com.tencent.mtt.hippy.modules.nativemodules.audio;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.util.Log;

class a$2
  implements MediaPlayer.OnCompletionListener
{
  a$2(a parama) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    Log.d(a.j(), "on completion");
    a.a(this.a, a.a.h);
    a.a(this.a).b(paramMediaPlayer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.modules.nativemodules.audio.a.2
 * JD-Core Version:    0.7.0.1
 */