package com.tencent.mobileqq.listentogether.player;

import bdmc;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public final class QQMusicPlayReport$2
  implements Runnable
{
  public QQMusicPlayReport$2(int paramInt1, int paramInt2) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("qqmusicplay_report_key_seek_delay", String.valueOf(this.a));
    localHashMap.put("qqmusicplay_report_key_net_type", String.valueOf(this.b));
    bdmc.a(BaseApplication.getContext()).a("", "qqmusicplay_report_tag_seek_delay", true, 0L, 0L, localHashMap, "");
    if (QLog.isColorLevel()) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.player.QQMusicPlayReport.2
 * JD-Core Version:    0.7.0.1
 */