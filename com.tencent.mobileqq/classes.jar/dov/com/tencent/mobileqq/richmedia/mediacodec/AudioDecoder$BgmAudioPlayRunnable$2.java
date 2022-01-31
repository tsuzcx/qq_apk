package dov.com.tencent.mobileqq.richmedia.mediacodec;

import android.media.MediaPlayer;
import java.util.TimerTask;

class AudioDecoder$BgmAudioPlayRunnable$2
  extends TimerTask
{
  AudioDecoder$BgmAudioPlayRunnable$2(AudioDecoder.BgmAudioPlayRunnable paramBgmAudioPlayRunnable) {}
  
  public void run()
  {
    if ((this.a.a != null) && (this.a.a.isPlaying())) {
      this.a.a.pause();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.mediacodec.AudioDecoder.BgmAudioPlayRunnable.2
 * JD-Core Version:    0.7.0.1
 */