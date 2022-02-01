package com.tencent.mobileqq.gamecenter.media;

import android.os.Handler;
import android.widget.SeekBar;
import android.widget.TextView;
import aveq;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.GameInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;
import java.util.concurrent.atomic.AtomicInteger;
import pjr;

class GameCenterVideoViewController$4
  implements Runnable
{
  GameCenterVideoViewController$4(GameCenterVideoViewController paramGameCenterVideoViewController) {}
  
  public void run()
  {
    QLog.e("GameCenterVideoViewController", 1, "[onVideoPrepared] status:" + GameCenterVideoViewController.access$400(this.this$0).get() + ",sPlayCount = " + GameCenterVideoViewController.sPlayCount + ",ConfigCount=" + aveq.a);
    if (GameCenterVideoViewController.access$400(this.this$0).get() == 5) {
      return;
    }
    this.this$0.setCurrentStatus(2);
    this.this$0.start();
    if (GameCenterVideoViewController.access$500(this.this$0) == 2)
    {
      int i = GameCenterVideoViewController.sPlayCount + 1;
      GameCenterVideoViewController.sPlayCount = i;
      if ((i >= aveq.a) && (aveq.a(GameCenterVideoViewController.access$300(this.this$0).gameInfo.gameAppId)))
      {
        GameCenterVideoViewController.sPlayCount = 0;
        GameCenterVideoViewController.access$700(this.this$0).sendEmptyMessageDelayed(14, aveq.b - GameCenterVideoViewController.access$600(this.this$0));
      }
    }
    long l = GameCenterVideoViewController.access$800(this.this$0).getDurationMs();
    GameCenterVideoViewController.access$900(this.this$0).setMax((int)l);
    GameCenterVideoViewController.access$1000(this.this$0).setText(pjr.a((int)l / 1000));
    this.this$0.updateControlPanle();
    GameCenterVideoViewController.access$1100(this.this$0, 0L);
    this.this$0.hideControlPanel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController.4
 * JD-Core Version:    0.7.0.1
 */