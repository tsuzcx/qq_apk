package com.tencent.timi.game.live.impl.danmuku;

import com.tencent.common.danmaku.data.BaseDanmaku;
import com.tencent.common.danmaku.inject.DanmakuContext;
import com.tencent.common.danmaku.inject.IDanmakuCreator;
import com.tencent.common.danmaku.inject.IDanmakuUIConfig;
import com.tencent.timi.game.ex.LayoutExKt;
import com.tencent.timi.game.live.impl.danmuku.danmaku.LargeCharacterDanmaku;
import com.tencent.timi.game.live.impl.danmuku.danmaku.NormalBgDanmaku;
import com.tencent.timi.game.live.impl.danmuku.danmaku.NormalDanmaku;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/common/danmaku/data/BaseDanmaku;", "", "kotlin.jvm.PlatformType", "Lcom/tencent/common/danmaku/inject/IDanmakuUIConfig;", "danmakuContext", "Lcom/tencent/common/danmaku/inject/DanmakuContext;", "danmakuType", "", "createDanmaku"}, k=3, mv={1, 1, 16})
final class EsportsDanmakuView$generateDanmakuManager$2
  implements IDanmakuCreator
{
  public static final 2 a = new 2();
  
  public final BaseDanmaku<Object, IDanmakuUIConfig> a(DanmakuContext paramDanmakuContext, int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return null;
        }
        Intrinsics.checkExpressionValueIsNotNull(paramDanmakuContext, "danmakuContext");
        return (BaseDanmaku)new LargeCharacterDanmaku(paramDanmakuContext);
      }
      Intrinsics.checkExpressionValueIsNotNull(paramDanmakuContext, "danmakuContext");
      paramDanmakuContext = new NormalBgDanmaku(paramDanmakuContext);
      paramDanmakuContext.j(LayoutExKt.a(-2));
      return (BaseDanmaku)paramDanmakuContext;
    }
    Intrinsics.checkExpressionValueIsNotNull(paramDanmakuContext, "danmakuContext");
    paramDanmakuContext = new NormalDanmaku(paramDanmakuContext);
    paramDanmakuContext.j(0.0F);
    return (BaseDanmaku)paramDanmakuContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.live.impl.danmuku.EsportsDanmakuView.generateDanmakuManager.2
 * JD-Core Version:    0.7.0.1
 */