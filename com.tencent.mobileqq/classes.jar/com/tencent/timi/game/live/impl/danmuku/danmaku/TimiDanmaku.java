package com.tencent.timi.game.live.impl.danmuku.danmaku;

import com.tencent.common.danmaku.data.R2LDanmaku;
import com.tencent.common.danmaku.inject.DanmakuContext;
import com.tencent.timi.game.live.impl.danmuku.DanmakuDataBean;
import com.tencent.timi.game.live.impl.danmuku.DanmakuUIConfig;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/live/impl/danmuku/danmaku/TimiDanmaku;", "Lcom/tencent/common/danmaku/data/R2LDanmaku;", "Lcom/tencent/timi/game/live/impl/danmuku/DanmakuDataBean;", "Lcom/tencent/timi/game/live/impl/danmuku/DanmakuUIConfig;", "danmakuContext", "Lcom/tencent/common/danmaku/inject/DanmakuContext;", "type", "", "(Lcom/tencent/common/danmaku/inject/DanmakuContext;I)V", "getAccurateLeft", "", "currTime", "", "getType", "Companion", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public abstract class TimiDanmaku
  extends R2LDanmaku<DanmakuDataBean, DanmakuUIConfig>
{
  public static final TimiDanmaku.Companion x = new TimiDanmaku.Companion(null);
  private final int y;
  
  public TimiDanmaku(@NotNull DanmakuContext paramDanmakuContext, int paramInt)
  {
    super(paramDanmakuContext);
    this.y = paramInt;
  }
  
  protected float i(long paramLong)
  {
    return super.i(paramLong);
  }
  
  public int q()
  {
    return this.y;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.live.impl.danmuku.danmaku.TimiDanmaku
 * JD-Core Version:    0.7.0.1
 */