package com.tencent.tavcut.render.player;

import com.tencent.tav.player.OnCompositionUpdateListener;
import com.tencent.tav.player.Player;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "player", "Lcom/tencent/tav/player/Player;", "kotlin.jvm.PlatformType", "succeed", "", "onUpdated"}, k=3, mv={1, 1, 16})
final class MoviePlayer$updateComposition$1
  implements OnCompositionUpdateListener
{
  MoviePlayer$updateComposition$1(MoviePlayer paramMoviePlayer) {}
  
  public final void onUpdated(Player paramPlayer, boolean paramBoolean)
  {
    MoviePlayer.a(this.a, paramPlayer);
    Object localObject = MoviePlayer.b(this.a);
    if (localObject != null) {
      ((Player)localObject).setIgnorePreparePosition(true);
    }
    while ((((Collection)MoviePlayer.c(this.a)).isEmpty() ^ true)) {
      ((Runnable)MoviePlayer.c(this.a).poll()).run();
    }
    localObject = MoviePlayer.d(this.a).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((IPlayer.PlayerListener)((Iterator)localObject).next()).a((IPlayer)this.a);
    }
    if ((MoviePlayer.e(this.a)) && (paramBoolean)) {
      paramPlayer.play();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.render.player.MoviePlayer.updateComposition.1
 * JD-Core Version:    0.7.0.1
 */