package com.tencent.timi.game.liveroom.impl.floating;

import android.content.Context;
import android.content.Intent;
import com.tencent.timi.game.float_window.IFloatView;
import com.tencent.timi.game.float_window.IFloatViewCreator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.ObjectRef;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/liveroom/impl/floating/TGLiveFloatManager$showFloatView$1$1", "Lcom/tencent/timi/game/float_window/IFloatViewCreator;", "createFloatView", "Lcom/tencent/timi/game/float_window/IFloatView;", "roomId", "", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TGLiveFloatManager$showFloatView$$inlined$let$lambda$1
  implements IFloatViewCreator
{
  TGLiveFloatManager$showFloatView$$inlined$let$lambda$1(long paramLong, Ref.ObjectRef paramObjectRef, boolean paramBoolean, Intent paramIntent) {}
  
  @Nullable
  public IFloatView a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "roomId");
    if (this.c)
    {
      paramString = MobileQQ.context;
      Intrinsics.checkExpressionValueIsNotNull(paramString, "MobileQQ.context");
      return new TGLiveAnchorFloatingView((Context)paramString, null, 0, 6, null).a(this.a);
    }
    paramString = MobileQQ.context;
    Intrinsics.checkExpressionValueIsNotNull(paramString, "MobileQQ.context");
    return new TGLiveAudienceFloatingView((Context)paramString, null, 0, 6, null).a(this.d).a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.floating.TGLiveFloatManager.showFloatView..inlined.let.lambda.1
 * JD-Core Version:    0.7.0.1
 */