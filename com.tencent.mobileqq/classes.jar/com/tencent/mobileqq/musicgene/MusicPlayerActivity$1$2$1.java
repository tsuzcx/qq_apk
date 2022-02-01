package com.tencent.mobileqq.musicgene;

import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.statistics.ReportController;

class MusicPlayerActivity$1$2$1
  implements Runnable
{
  MusicPlayerActivity$1$2$1(MusicPlayerActivity.1.2 param2) {}
  
  public void run()
  {
    ReportController.b(this.a.c.a.app, "CliOper", "", "", "0X800682D", "0X800682D", 0, 0, "", "", "", "");
    QQMusicConst.b(this.a.c.a, "https://misc.wcd.qq.com/app?packageName=com.tencent.qqmusic&channelId=10000435");
    Object localObject = this.a.a.getTag();
    int i;
    if ((localObject instanceof Integer)) {
      i = ((Integer)localObject).intValue();
    } else {
      i = -1;
    }
    Message.obtain(MusicPlayerActivity.b(this.a.c.a), 54, 2131892043, i, this.a.a).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.musicgene.MusicPlayerActivity.1.2.1
 * JD-Core Version:    0.7.0.1
 */