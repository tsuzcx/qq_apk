package com.tencent.mobileqq.emoticonview.anisticker;

import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.rlottie.AXrLottieCacheManager.CacheListener;
import java.util.HashMap;
import mqq.app.MobileQQ;

final class AniStickerLottie$1
  implements AXrLottieCacheManager.CacheListener
{
  public void onClearCache(long paramLong1, long paramLong2, long paramLong3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("timeInterval", String.valueOf(paramLong1));
    localHashMap.put("cacheSize", String.valueOf(paramLong2));
    localHashMap.put("cacheCount", String.valueOf(paramLong2));
    StatisticCollector.getInstance(MobileQQ.getContext()).collectPerformance("", "AniStickerCache", true, 0L, 0L, localHashMap, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.anisticker.AniStickerLottie.1
 * JD-Core Version:    0.7.0.1
 */