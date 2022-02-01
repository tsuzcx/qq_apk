package com.tencent.mobileqq.kandian.biz.ugc.voice;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import java.lang.ref.WeakReference;

class ReadInJoyVoicePlayController$2
  implements MediaPlayer.OnCompletionListener
{
  ReadInJoyVoicePlayController$2(ReadInJoyVoicePlayController paramReadInJoyVoicePlayController) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    ReadInJoyVoicePlayController.a(this.a).isPlaying = false;
    paramMediaPlayer = (ReadInJoyVoicePlayController.IPlayCallback)ReadInJoyVoicePlayController.a(this.a).get();
    if (paramMediaPlayer != null)
    {
      paramMediaPlayer.b(ReadInJoyVoicePlayController.a(this.a));
      this.a.a(false, "ugc voice play");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.voice.ReadInJoyVoicePlayController.2
 * JD-Core Version:    0.7.0.1
 */