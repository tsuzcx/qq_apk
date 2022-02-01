package com.tencent.timi.game.live.impl.danmuku;

import com.tencent.common.danmaku.data.BaseDanmaku;
import java.util.ArrayList;
import java.util.List;

class TimiR2LWindow$1
  extends ArrayList<List<BaseDanmaku<DanmakuDataBean, DanmakuUIConfig>>>
{
  TimiR2LWindow$1(TimiR2LWindow paramTimiR2LWindow)
  {
    int i = 0;
    while (i < 3)
    {
      add(new ArrayList());
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.live.impl.danmuku.TimiR2LWindow.1
 * JD-Core Version:    0.7.0.1
 */