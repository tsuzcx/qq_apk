package com.tencent.timi.game.liveroom.impl.view.head;

import com.tencent.timi.game.liveroom.impl.inscription.LivingInscriptionReportHelper.StatusListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/liveroom/impl/view/head/AnchorTopHeadView$mStatusListener$1", "Lcom/tencent/timi/game/liveroom/impl/inscription/LivingInscriptionReportHelper$StatusListener;", "onStatusChange", "", "roomId", "", "status", "", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class AnchorTopHeadView$mStatusListener$1
  implements LivingInscriptionReportHelper.StatusListener
{
  public void a(long paramLong, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "status");
    AnchorTopHeadView.g(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.view.head.AnchorTopHeadView.mStatusListener.1
 * JD-Core Version:    0.7.0.1
 */