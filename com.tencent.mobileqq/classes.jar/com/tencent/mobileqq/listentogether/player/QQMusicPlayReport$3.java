package com.tencent.mobileqq.listentogether.player;

import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

final class QQMusicPlayReport$3
  implements Runnable
{
  QQMusicPlayReport$3(boolean paramBoolean, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    String str;
    if (this.a) {
      str = "1";
    } else {
      str = "0";
    }
    localHashMap.put("qqmusicplay_report_key_play_cache", str);
    localHashMap.put("qqmusicplay_report_key_net_type", String.valueOf(this.b));
    localHashMap.put("qqmusicplay_report_key_seek_count_per_song", String.valueOf(this.c));
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "qqmusicplay_report_tag_seek_count_per_song", true, 0L, 0L, localHashMap, "");
    QLog.isColorLevel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.player.QQMusicPlayReport.3
 * JD-Core Version:    0.7.0.1
 */