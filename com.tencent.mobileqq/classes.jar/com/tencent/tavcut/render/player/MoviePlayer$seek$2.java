package com.tencent.tavcut.render.player;

import com.tencent.tavkit.component.TAVPlayer;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class MoviePlayer$seek$2
  implements Runnable
{
  MoviePlayer$seek$2(MoviePlayer paramMoviePlayer, long paramLong) {}
  
  public final void run()
  {
    MoviePlayer.a(this.this$0).seekToTime(MoviePlayer.a(this.this$0, this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.render.player.MoviePlayer.seek.2
 * JD-Core Version:    0.7.0.1
 */