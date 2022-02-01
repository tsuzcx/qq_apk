package com.tencent.mobileqq.gamecenter.media;

import android.os.Handler;
import android.widget.SeekBar;
import android.widget.TextView;
import atzb;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.GameInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;
import java.util.concurrent.atomic.AtomicInteger;
import pai;

class GameCenterVideoViewController$2
  implements Runnable
{
  GameCenterVideoViewController$2(GameCenterVideoViewController paramGameCenterVideoViewController) {}
  
  public void run()
  {
    QLog.e("GameCenterVideoViewController", 1, "[onVideoPrepared] status:" + GameCenterVideoViewController.access$100(this.this$0).get() + ",sPlayCount = " + GameCenterVideoViewController.sPlayCount + ",ConfigCount=" + atzb.a);
    if (GameCenterVideoViewController.access$100(this.this$0).get() == 5) {
      return;
    }
    this.this$0.setCurrentStatus(2);
    this.this$0.start();
    if (GameCenterVideoViewController.access$200(this.this$0) == 2)
    {
      int i = GameCenterVideoViewController.sPlayCount + 1;
      GameCenterVideoViewController.sPlayCount = i;
      if ((i >= atzb.a) && (atzb.a(GameCenterVideoViewController.access$000(this.this$0).gameInfo.gameAppId)))
      {
        GameCenterVideoViewController.sPlayCount = 0;
        GameCenterVideoViewController.access$400(this.this$0).sendEmptyMessageDelayed(14, atzb.b - GameCenterVideoViewController.access$300(this.this$0));
      }
    }
    long l = GameCenterVideoViewController.access$500(this.this$0).getDurationMs();
    GameCenterVideoViewController.access$600(this.this$0).setMax((int)l);
    GameCenterVideoViewController.access$700(this.this$0).setText(pai.a((int)l / 1000));
    this.this$0.updateControlPanle();
    if (GameCenterVideoViewController.access$000(this.this$0).type == 2) {
      GameCenterVideoViewController.access$400(this.this$0).sendEmptyMessage(5);
    }
    this.this$0.hideControlPanel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController.2
 * JD-Core Version:    0.7.0.1
 */