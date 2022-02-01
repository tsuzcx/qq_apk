package com.tencent.qcircle.tavcut.player;

import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.tav.player.Player;

class MoviePlayer$3
  implements AudioManager.OnAudioFocusChangeListener
{
  MoviePlayer$3(MoviePlayer paramMoviePlayer) {}
  
  public void onAudioFocusChange(int paramInt)
  {
    if ((paramInt != -2) && (paramInt != -1))
    {
      if (paramInt != 1) {
        return;
      }
      if (MoviePlayer.access$900(this.this$0) != null) {
        MoviePlayer.access$900(this.this$0).play();
      }
    }
    else
    {
      if (!MoviePlayer.access$1600(this.this$0)) {
        return;
      }
      if (MoviePlayer.access$900(this.this$0) != null) {
        MoviePlayer.access$900(this.this$0).pause();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.player.MoviePlayer.3
 * JD-Core Version:    0.7.0.1
 */