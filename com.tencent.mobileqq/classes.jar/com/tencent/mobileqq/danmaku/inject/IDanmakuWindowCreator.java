package com.tencent.mobileqq.danmaku.inject;

import com.tencent.mobileqq.danmaku.core.AbsWindow;
import com.tencent.mobileqq.danmaku.core.CacheDrawManager;
import com.tencent.mobileqq.danmaku.data.BaseDanmaku;
import com.tencent.mobileqq.danmaku.tool.DanmakuDrawTimer;
import com.tencent.mobileqq.danmaku.tool.PlayerTimer;
import java.util.Comparator;

public abstract interface IDanmakuWindowCreator
{
  public abstract AbsWindow a(DanmakuContext paramDanmakuContext, CacheDrawManager paramCacheDrawManager, Comparator<BaseDanmaku> paramComparator, PlayerTimer paramPlayerTimer, DanmakuDrawTimer paramDanmakuDrawTimer);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.danmaku.inject.IDanmakuWindowCreator
 * JD-Core Version:    0.7.0.1
 */