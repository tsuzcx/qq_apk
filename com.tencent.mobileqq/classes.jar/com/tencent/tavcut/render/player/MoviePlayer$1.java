package com.tencent.tavcut.render.player;

import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.player.Player;
import com.tencent.tavkit.component.TAVPlayer.PlayerListener;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tavcut/render/player/MoviePlayer$1", "Lcom/tencent/tavkit/component/TAVPlayer$PlayerListener;", "onPositionChanged", "", "cmTime", "Lcom/tencent/tav/coremedia/CMTime;", "playerDuration", "onStatusChanged", "playerStatus", "Lcom/tencent/tav/player/IPlayer$PlayerStatus;", "player", "Lcom/tencent/tav/player/Player;", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
public final class MoviePlayer$1
  implements TAVPlayer.PlayerListener
{
  public void onPositionChanged(@Nullable CMTime paramCMTime1, @Nullable CMTime paramCMTime2)
  {
    Object localObject = this.a;
    if (paramCMTime1 != null) {
      l1 = paramCMTime1.getTimeUs();
    } else {
      l1 = 0L;
    }
    MoviePlayer.b((MoviePlayer)localObject, l1);
    MoviePlayer.j(this.a);
    localObject = MoviePlayer.k(this.a);
    long l1 = MoviePlayer.h(this.a);
    if (paramCMTime2 != null) {
      paramCMTime1 = Long.valueOf(paramCMTime2.getTimeUs());
    } else {
      paramCMTime1 = null;
    }
    ((Function2)localObject).invoke(Long.valueOf(l1), paramCMTime1);
    paramCMTime1 = MoviePlayer.d(this.a).iterator();
    while (paramCMTime1.hasNext())
    {
      localObject = (IPlayer.PlayerListener)paramCMTime1.next();
      long l2 = MoviePlayer.h(this.a);
      if (paramCMTime2 != null) {
        l1 = paramCMTime2.getTimeUs();
      } else {
        l1 = 0L;
      }
      ((IPlayer.PlayerListener)localObject).a(l2, l1);
    }
  }
  
  public void onStatusChanged(@Nullable com.tencent.tav.player.IPlayer.PlayerStatus paramPlayerStatus, @Nullable Player paramPlayer)
  {
    paramPlayer = MoviePlayer.d(this.a).iterator();
    while (paramPlayer.hasNext()) {
      ((IPlayer.PlayerListener)paramPlayer.next()).a((IPlayer.PlayerStatus)MoviePlayer.i(this.a).get(paramPlayerStatus), (IPlayer)this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.render.player.MoviePlayer.1
 * JD-Core Version:    0.7.0.1
 */