package com.tencent.mobileqq.kandian.biz.video.danmaku.render;

import com.tencent.mobileqq.danmaku.core.AbsWindow;
import com.tencent.mobileqq.danmaku.core.CacheDrawManager;
import com.tencent.mobileqq.danmaku.data.BaseDanmaku;
import com.tencent.mobileqq.danmaku.inject.DanmakuContext;
import com.tencent.mobileqq.danmaku.inject.IDanmakuUIConfig;
import com.tencent.mobileqq.danmaku.inject.IDanmakuWindowCreator;
import com.tencent.mobileqq.danmaku.tool.DanmakuDrawTimer;
import com.tencent.mobileqq.danmaku.tool.PlayerTimer;
import java.util.Comparator;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/danmaku/render/RIJDanmakuWindowCreator;", "Lcom/tencent/mobileqq/danmaku/inject/IDanmakuWindowCreator;", "()V", "createWindow", "Lcom/tencent/mobileqq/danmaku/core/AbsWindow;", "danmakuContext", "Lcom/tencent/mobileqq/danmaku/inject/DanmakuContext;", "cacheDrawManager", "Lcom/tencent/mobileqq/danmaku/core/CacheDrawManager;", "comparator", "Ljava/util/Comparator;", "Lcom/tencent/mobileqq/danmaku/data/BaseDanmaku;", "", "Lcom/tencent/mobileqq/danmaku/inject/IDanmakuUIConfig;", "playerTimer", "Lcom/tencent/mobileqq/danmaku/tool/PlayerTimer;", "drawTimer", "Lcom/tencent/mobileqq/danmaku/tool/DanmakuDrawTimer;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJDanmakuWindowCreator
  implements IDanmakuWindowCreator
{
  @NotNull
  public AbsWindow a(@Nullable DanmakuContext paramDanmakuContext, @Nullable CacheDrawManager paramCacheDrawManager, @Nullable Comparator<BaseDanmaku<Object, IDanmakuUIConfig>> paramComparator, @Nullable PlayerTimer paramPlayerTimer, @Nullable DanmakuDrawTimer paramDanmakuDrawTimer)
  {
    return (AbsWindow)new RIJDanmakuWindow(paramDanmakuContext, paramCacheDrawManager, paramComparator, paramPlayerTimer, paramDanmakuDrawTimer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.danmaku.render.RIJDanmakuWindowCreator
 * JD-Core Version:    0.7.0.1
 */