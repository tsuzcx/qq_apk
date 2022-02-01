package com.tencent.mobileqq.gamecenter.media;

import android.os.Handler;
import android.widget.SeekBar;
import android.widget.TextView;
import avmc;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.GameInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;
import java.util.concurrent.atomic.AtomicInteger;
import ozc;

class GameCenterVideoViewController$3
  implements Runnable
{
  GameCenterVideoViewController$3(GameCenterVideoViewController paramGameCenterVideoViewController) {}
  
  public void run()
  {
    QLog.e("GameCenterVideoViewController", 1, "[onVideoPrepared] status:" + GameCenterVideoViewController.a(this.this$0).get() + ",sPlayCount = " + GameCenterVideoViewController.a + ",ConfigCount=" + avmc.a);
    if (GameCenterVideoViewController.a(this.this$0).get() == 5) {
      return;
    }
    this.this$0.setCurrentStatus(2);
    this.this$0.e();
    if (GameCenterVideoViewController.a(this.this$0) == 2)
    {
      int i = GameCenterVideoViewController.a + 1;
      GameCenterVideoViewController.a = i;
      if ((i >= avmc.a) && (avmc.a(GameCenterVideoViewController.a(this.this$0).gameInfo.gameAppId)))
      {
        GameCenterVideoViewController.a = 0;
        GameCenterVideoViewController.a(this.this$0).sendEmptyMessageDelayed(14, avmc.b - GameCenterVideoViewController.a(this.this$0));
      }
    }
    long l = GameCenterVideoViewController.a(this.this$0).getDurationMs();
    GameCenterVideoViewController.a(this.this$0).setMax((int)l);
    GameCenterVideoViewController.a(this.this$0).setText(ozc.a((int)l / 1000));
    this.this$0.a();
    if (GameCenterVideoViewController.a(this.this$0).type == 2) {
      GameCenterVideoViewController.a(this.this$0).sendEmptyMessage(5);
    }
    this.this$0.k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController.3
 * JD-Core Version:    0.7.0.1
 */