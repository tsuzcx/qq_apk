package com.tencent.timi.game.live.impl.danmuku;

import com.tencent.common.danmaku.core.CacheDrawManager;
import com.tencent.common.danmaku.core.R2LWindow;
import com.tencent.common.danmaku.data.BaseDanmaku;
import com.tencent.common.danmaku.inject.DanmakuContext;
import com.tencent.common.danmaku.inject.IDanmakuUIConfig;
import com.tencent.common.danmaku.inject.IDanmakuWindowCreator;
import com.tencent.common.danmaku.tool.DanmakuDrawTimer;
import com.tencent.common.danmaku.tool.PlayerTimer;
import java.util.Comparator;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/common/danmaku/core/R2LWindow;", "danmakuContext", "Lcom/tencent/common/danmaku/inject/DanmakuContext;", "kotlin.jvm.PlatformType", "cacheDrawManager", "Lcom/tencent/common/danmaku/core/CacheDrawManager;", "comparator", "Ljava/util/Comparator;", "Lcom/tencent/common/danmaku/data/BaseDanmaku;", "", "Lcom/tencent/common/danmaku/inject/IDanmakuUIConfig;", "playerTimer", "Lcom/tencent/common/danmaku/tool/PlayerTimer;", "danmakuDrawTimer", "Lcom/tencent/common/danmaku/tool/DanmakuDrawTimer;", "createWindow"}, k=3, mv={1, 1, 16})
final class EsportsDanmakuView$generateDanmakuManager$1
  implements IDanmakuWindowCreator
{
  public static final 1 a = new 1();
  
  @NotNull
  public final R2LWindow b(DanmakuContext paramDanmakuContext, CacheDrawManager paramCacheDrawManager, Comparator<BaseDanmaku<Object, IDanmakuUIConfig>> paramComparator, PlayerTimer paramPlayerTimer, DanmakuDrawTimer paramDanmakuDrawTimer)
  {
    return new R2LWindow(paramDanmakuContext, paramCacheDrawManager, paramComparator, paramPlayerTimer, paramDanmakuDrawTimer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.live.impl.danmuku.EsportsDanmakuView.generateDanmakuManager.1
 * JD-Core Version:    0.7.0.1
 */