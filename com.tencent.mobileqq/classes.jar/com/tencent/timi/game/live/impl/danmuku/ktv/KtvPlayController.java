package com.tencent.timi.game.live.impl.danmuku.ktv;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/live/impl/danmuku/ktv/KtvPlayController;", "", "()V", "ktvPlayViewList", "", "Lcom/tencent/timi/game/live/impl/danmuku/ktv/KtvPlayView;", "queue", "Ljava/util/Queue;", "", "offerKtv", "", "ktv", "registerKtvPlayView", "", "release", "IKtvPlayController", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class KtvPlayController
{
  private final Queue<String> a = (Queue)new LinkedList();
  private final List<KtvPlayView> b = (List)new ArrayList();
  
  public final void a(@NotNull List<KtvPlayView> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "ktvPlayViewList");
    this.b.clear();
    this.b.addAll((Collection)paramList);
    Iterator localIterator = ((Iterable)paramList).iterator();
    while (localIterator.hasNext())
    {
      KtvPlayView localKtvPlayView = (KtvPlayView)localIterator.next();
      localKtvPlayView.setKtvPlayController((KtvPlayController.IKtvPlayController)new KtvPlayController.registerKtvPlayView..inlined.forEach.lambda.1(localKtvPlayView, this, paramList));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.live.impl.danmuku.ktv.KtvPlayController
 * JD-Core Version:    0.7.0.1
 */