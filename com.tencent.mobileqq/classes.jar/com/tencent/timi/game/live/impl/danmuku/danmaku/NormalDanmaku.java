package com.tencent.timi.game.live.impl.danmuku.danmaku;

import com.tencent.common.danmaku.inject.DanmakuContext;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/live/impl/danmuku/danmaku/NormalDanmaku;", "Lcom/tencent/timi/game/live/impl/danmuku/danmaku/TimiDanmaku;", "danmakuContext", "Lcom/tencent/common/danmaku/inject/DanmakuContext;", "(Lcom/tencent/common/danmaku/inject/DanmakuContext;)V", "offsetY", "", "getOffsetY", "()F", "setOffsetY", "(F)V", "getTop", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class NormalDanmaku
  extends TimiDanmaku
{
  private float y;
  
  public NormalDanmaku(@NotNull DanmakuContext paramDanmakuContext)
  {
    super(paramDanmakuContext, 1);
  }
  
  public final void j(float paramFloat)
  {
    this.y = paramFloat;
  }
  
  public float t()
  {
    return super.t() + this.y;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.live.impl.danmuku.danmaku.NormalDanmaku
 * JD-Core Version:    0.7.0.1
 */