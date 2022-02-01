package com.tencent.tavcut.player;

import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.tav.player.Player;

class MoviePlayer$3
  implements AudioManager.OnAudioFocusChangeListener
{
  MoviePlayer$3(MoviePlayer paramMoviePlayer) {}
  
  public void onAudioFocusChange(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
      } while ((!MoviePlayer.access$1600(this.this$0)) || (MoviePlayer.access$900(this.this$0) == null));
      MoviePlayer.access$900(this.this$0).pause();
      return;
    } while (MoviePlayer.access$900(this.this$0) == null);
    MoviePlayer.access$900(this.this$0).play();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavcut.player.MoviePlayer.3
 * JD-Core Version:    0.7.0.1
 */