package com.tencent.mobileqq.kandian.biz.video.danmaku.render;

import com.tencent.common.danmaku.core.AbsWindow;
import com.tencent.common.danmaku.core.CacheDrawManager;
import com.tencent.common.danmaku.data.BaseDanmaku;
import com.tencent.common.danmaku.inject.DanmakuContext;
import com.tencent.common.danmaku.inject.IDanmakuUIConfig;
import com.tencent.common.danmaku.inject.IDanmakuWindowCreator;
import com.tencent.common.danmaku.tool.DanmakuDrawTimer;
import com.tencent.common.danmaku.tool.PlayerTimer;
import java.util.Comparator;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/danmaku/render/RIJDanmakuWindowCreator;", "Lcom/tencent/common/danmaku/inject/IDanmakuWindowCreator;", "()V", "createWindow", "Lcom/tencent/common/danmaku/core/AbsWindow;", "danmakuContext", "Lcom/tencent/common/danmaku/inject/DanmakuContext;", "cacheDrawManager", "Lcom/tencent/common/danmaku/core/CacheDrawManager;", "comparator", "Ljava/util/Comparator;", "Lcom/tencent/common/danmaku/data/BaseDanmaku;", "", "Lcom/tencent/common/danmaku/inject/IDanmakuUIConfig;", "playerTimer", "Lcom/tencent/common/danmaku/tool/PlayerTimer;", "drawTimer", "Lcom/tencent/common/danmaku/tool/DanmakuDrawTimer;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJDanmakuWindowCreator
  implements IDanmakuWindowCreator
{
  @NotNull
  public AbsWindow a(@Nullable DanmakuContext paramDanmakuContext, @Nullable CacheDrawManager paramCacheDrawManager, @Nullable Comparator<BaseDanmaku<Object, IDanmakuUIConfig>> paramComparator, @Nullable PlayerTimer paramPlayerTimer, @Nullable DanmakuDrawTimer paramDanmakuDrawTimer)
  {
    return (AbsWindow)new RIJDanmakuWindow(paramDanmakuContext, paramCacheDrawManager, paramComparator, paramPlayerTimer, paramDanmakuDrawTimer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.danmaku.render.RIJDanmakuWindowCreator
 * JD-Core Version:    0.7.0.1
 */