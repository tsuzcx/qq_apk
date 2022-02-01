package com.tencent.timi.game.live.impl.danmuku.ktv;

import java.util.Collection;
import java.util.List;
import java.util.Queue;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/live/impl/danmuku/ktv/KtvPlayController$registerKtvPlayView$1$1", "Lcom/tencent/timi/game/live/impl/danmuku/ktv/KtvPlayController$IKtvPlayController;", "onPlayEnd", "", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class KtvPlayController$registerKtvPlayView$$inlined$forEach$lambda$1
  implements KtvPlayController.IKtvPlayController
{
  KtvPlayController$registerKtvPlayView$$inlined$forEach$lambda$1(KtvPlayView paramKtvPlayView, KtvPlayController paramKtvPlayController, List paramList) {}
  
  public void a()
  {
    String str = (String)KtvPlayController.a(this.b).poll();
    if (str != null)
    {
      int i = 0;
      int j = ((Collection)this.c).size();
      while (i < j)
      {
        this.a.a(str);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.live.impl.danmuku.ktv.KtvPlayController.registerKtvPlayView..inlined.forEach.lambda.1
 * JD-Core Version:    0.7.0.1
 */