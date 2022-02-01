package com.tencent.timi.game.live.impl.danmuku;

import android.view.View;
import com.tencent.common.danmaku.core.DanmakuManager;
import com.tencent.common.danmaku.inject.DanmakuContext;
import com.tencent.common.danmaku.render.IDanmakuView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/live/impl/danmuku/CustomDanmakuManager;", "Lcom/tencent/common/danmaku/core/DanmakuManager;", "danmakuView", "Landroid/view/View;", "danmakuContext", "Lcom/tencent/common/danmaku/inject/DanmakuContext;", "(Landroid/view/View;Lcom/tencent/common/danmaku/inject/DanmakuContext;)V", "setDisableSync", "", "disable", "", "setUseUiTime", "enable", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class CustomDanmakuManager
  extends DanmakuManager
{
  public CustomDanmakuManager(@NotNull View paramView, @NotNull DanmakuContext paramDanmakuContext)
  {
    super(paramView, paramDanmakuContext);
  }
  
  public final void b(boolean paramBoolean)
  {
    IDanmakuView localIDanmakuView = this.a;
    Intrinsics.checkExpressionValueIsNotNull(localIDanmakuView, "mDanmakuView");
    localIDanmakuView.a(paramBoolean);
  }
  
  public final void c(boolean paramBoolean)
  {
    IDanmakuView localIDanmakuView = this.a;
    Intrinsics.checkExpressionValueIsNotNull(localIDanmakuView, "mDanmakuView");
    localIDanmakuView.b(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.live.impl.danmuku.CustomDanmakuManager
 * JD-Core Version:    0.7.0.1
 */