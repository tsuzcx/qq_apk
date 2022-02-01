package com.tencent.mobileqq.danmaku.core;

import com.tencent.mobileqq.danmaku.data.BaseDanmaku;
import com.tencent.mobileqq.danmaku.tool.SortedLinkedList.TimeComparator;

class DanmakuDataSource$1
  implements SortedLinkedList.TimeComparator<BaseDanmaku>
{
  DanmakuDataSource$1(DanmakuDataSource paramDanmakuDataSource) {}
  
  public int a(BaseDanmaku paramBaseDanmaku, long paramLong)
  {
    if (paramBaseDanmaku == null) {
      return -1;
    }
    paramLong = paramBaseDanmaku.d() - paramLong;
    if (paramLong == 0L) {
      return 0;
    }
    if (paramLong > 0L) {
      return 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.danmaku.core.DanmakuDataSource.1
 * JD-Core Version:    0.7.0.1
 */