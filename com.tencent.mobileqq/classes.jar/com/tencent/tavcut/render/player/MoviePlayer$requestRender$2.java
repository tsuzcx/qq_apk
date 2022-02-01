package com.tencent.tavcut.render.player;

import com.tencent.tav.player.Player;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class MoviePlayer$requestRender$2
  implements Runnable
{
  MoviePlayer$requestRender$2(MoviePlayer paramMoviePlayer) {}
  
  public final void run()
  {
    Player localPlayer = MoviePlayer.b(this.this$0);
    if (localPlayer != null) {
      localPlayer.refresh();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.render.player.MoviePlayer.requestRender.2
 * JD-Core Version:    0.7.0.1
 */