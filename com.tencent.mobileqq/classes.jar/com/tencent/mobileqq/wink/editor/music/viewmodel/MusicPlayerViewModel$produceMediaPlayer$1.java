package com.tencent.mobileqq.wink.editor.music.viewmodel;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.util.Log;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/media/MediaPlayer;", "kotlin.jvm.PlatformType", "onPrepared"}, k=3, mv={1, 1, 16})
final class MusicPlayerViewModel$produceMediaPlayer$1
  implements MediaPlayer.OnPreparedListener
{
  public static final 1 a = new 1();
  
  public final void onPrepared(MediaPlayer paramMediaPlayer)
  {
    Log.i(MusicPlayerViewModel.e(), "media player prepared");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.viewmodel.MusicPlayerViewModel.produceMediaPlayer.1
 * JD-Core Version:    0.7.0.1
 */