package com.tencent.tavcut.player;

import com.tencent.tav.player.OnCompositionUpdateListener;
import com.tencent.tav.player.Player;

class MoviePlayer$2
  implements OnCompositionUpdateListener
{
  MoviePlayer$2(MoviePlayer paramMoviePlayer, boolean paramBoolean) {}
  
  public void onUpdated(Player paramPlayer, boolean paramBoolean)
  {
    paramPlayer.setVolume(MoviePlayer.access$1200(this.this$0));
    if ((this.val$autoPlay) && (paramBoolean))
    {
      this.this$0.seekToTime(MoviePlayer.access$1300(this.this$0));
      this.this$0.play();
    }
    MoviePlayer.access$1400(this.this$0);
    MoviePlayer.access$1502(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tavcut.player.MoviePlayer.2
 * JD-Core Version:    0.7.0.1
 */