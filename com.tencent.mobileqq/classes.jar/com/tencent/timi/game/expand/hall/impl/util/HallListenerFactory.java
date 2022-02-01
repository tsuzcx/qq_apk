package com.tencent.timi.game.expand.hall.impl.util;

import com.tencent.timi.game.api.cb.ExpandHallListener;
import com.tencent.timi.game.api.param.ExpandHallLaunchParam;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/expand/hall/impl/util/HallListenerFactory;", "", "()V", "TAG", "", "createGuildDefaultListener", "Lcom/tencent/timi/game/api/cb/ExpandHallListener;", "param", "Lcom/tencent/timi/game/api/param/ExpandHallLaunchParam;", "createHallListener", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class HallListenerFactory
{
  public static final HallListenerFactory a = new HallListenerFactory();
  
  private final ExpandHallListener b(ExpandHallLaunchParam paramExpandHallLaunchParam)
  {
    return (ExpandHallListener)new HallListenerFactory.createGuildDefaultListener.obj.1();
  }
  
  @Nullable
  public final ExpandHallListener a(@NotNull ExpandHallLaunchParam paramExpandHallLaunchParam)
  {
    Intrinsics.checkParameterIsNotNull(paramExpandHallLaunchParam, "param");
    if (paramExpandHallLaunchParam.a != 2) {
      return null;
    }
    return b(paramExpandHallLaunchParam);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.expand.hall.impl.util.HallListenerFactory
 * JD-Core Version:    0.7.0.1
 */