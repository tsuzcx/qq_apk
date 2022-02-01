package com.tencent.mobileqq.danmaku.core;

import com.tencent.mobileqq.danmaku.data.BaseDanmaku;
import com.tencent.mobileqq.danmaku.util.DanmakuUtils;
import java.io.Serializable;
import java.util.Comparator;

public final class DanmakuManager$DanmakuComparator
  implements Serializable, Comparator<BaseDanmaku>
{
  public int compare(BaseDanmaku paramBaseDanmaku1, BaseDanmaku paramBaseDanmaku2)
  {
    return DanmakuUtils.a(paramBaseDanmaku1, paramBaseDanmaku2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.danmaku.core.DanmakuManager.DanmakuComparator
 * JD-Core Version:    0.7.0.1
 */