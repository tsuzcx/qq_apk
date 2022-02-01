package com.tencent.timi.game.liveroom.impl.floating;

import android.content.Context;
import com.tencent.timi.game.float_window.IFloatView;
import com.tencent.timi.game.float_window.IFloatViewCreator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/liveroom/impl/floating/TGLiveFloatManager$showKeepAliveFloatView$1$1", "Lcom/tencent/timi/game/float_window/IFloatViewCreator;", "createFloatView", "Lcom/tencent/timi/game/float_window/IFloatView;", "roomId", "", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TGLiveFloatManager$showKeepAliveFloatView$1$1
  implements IFloatViewCreator
{
  @Nullable
  public IFloatView a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "roomId");
    paramString = MobileQQ.context;
    Intrinsics.checkExpressionValueIsNotNull(paramString, "MobileQQ.context");
    return (IFloatView)new TGAnchorKeepAliveFloatingWindow((Context)paramString, null, 0, 6, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.floating.TGLiveFloatManager.showKeepAliveFloatView.1.1
 * JD-Core Version:    0.7.0.1
 */