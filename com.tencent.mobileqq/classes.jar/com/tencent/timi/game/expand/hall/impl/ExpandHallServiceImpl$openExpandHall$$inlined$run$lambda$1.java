package com.tencent.timi.game.expand.hall.impl;

import com.tencent.timi.game.expand.hall.api.IExpandHall;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run", "com/tencent/timi/game/expand/hall/impl/ExpandHallServiceImpl$openExpandHall$1$1"}, k=3, mv={1, 1, 16})
final class ExpandHallServiceImpl$openExpandHall$$inlined$run$lambda$1
  implements Runnable
{
  ExpandHallServiceImpl$openExpandHall$$inlined$run$lambda$1(IExpandHall paramIExpandHall, ExpandHallServiceImpl paramExpandHallServiceImpl) {}
  
  public final void run()
  {
    ExpandHallServiceImpl localExpandHallServiceImpl = this.this$0;
    IExpandHall localIExpandHall = this.a;
    Intrinsics.checkExpressionValueIsNotNull(localIExpandHall, "this");
    localExpandHallServiceImpl.c(localIExpandHall);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.expand.hall.impl.ExpandHallServiceImpl.openExpandHall..inlined.run.lambda.1
 * JD-Core Version:    0.7.0.1
 */