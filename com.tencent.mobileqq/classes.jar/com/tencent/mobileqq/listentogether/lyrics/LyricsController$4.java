package com.tencent.mobileqq.listentogether.lyrics;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.StatisticCollector;

class LyricsController$4
  implements Runnable
{
  LyricsController$4(LyricsController paramLyricsController, boolean paramBoolean) {}
  
  public void run()
  {
    StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance("", "listen_together_float_window_permission_quality", this.a, 0L, 0L, null, "", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.lyrics.LyricsController.4
 * JD-Core Version:    0.7.0.1
 */