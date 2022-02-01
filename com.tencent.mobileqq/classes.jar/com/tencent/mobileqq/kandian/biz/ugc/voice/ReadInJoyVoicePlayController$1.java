package com.tencent.mobileqq.kandian.biz.ugc.voice;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import java.lang.ref.WeakReference;

class ReadInJoyVoicePlayController$1
  implements MediaPlayer.OnPreparedListener
{
  ReadInJoyVoicePlayController$1(ReadInJoyVoicePlayController paramReadInJoyVoicePlayController) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    try
    {
      paramMediaPlayer.start();
    }
    catch (Exception paramMediaPlayer)
    {
      paramMediaPlayer.printStackTrace();
    }
    ReadInJoyVoicePlayController.a(this.a).isPlaying = true;
    paramMediaPlayer = (ReadInJoyVoicePlayController.IPlayCallback)ReadInJoyVoicePlayController.b(this.a).get();
    if (paramMediaPlayer != null)
    {
      paramMediaPlayer.a(ReadInJoyVoicePlayController.a(this.a));
      this.a.a(true, "ugc voice play");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.voice.ReadInJoyVoicePlayController.1
 * JD-Core Version:    0.7.0.1
 */