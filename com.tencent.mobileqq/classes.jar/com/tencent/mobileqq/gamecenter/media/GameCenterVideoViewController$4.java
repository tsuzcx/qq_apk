package com.tencent.mobileqq.gamecenter.media;

import android.os.Handler;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.GameInfo;
import com.tencent.mobileqq.kandian.base.utils.api.IReadInJoyDisplayUtils;
import com.tencent.mobileqq.qqgamepub.api.IQQGameConfigUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;
import java.util.concurrent.atomic.AtomicInteger;

class GameCenterVideoViewController$4
  implements Runnable
{
  GameCenterVideoViewController$4(GameCenterVideoViewController paramGameCenterVideoViewController) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[onVideoPrepared] status:");
    ((StringBuilder)localObject).append(GameCenterVideoViewController.access$400(this.this$0).get());
    ((StringBuilder)localObject).append(",sPlayCount = ");
    ((StringBuilder)localObject).append(GameCenterVideoViewController.sPlayCount);
    ((StringBuilder)localObject).append(",ConfigCount=");
    ((StringBuilder)localObject).append(3);
    QLog.e("GameCenterVideoViewController", 1, ((StringBuilder)localObject).toString());
    if (GameCenterVideoViewController.access$400(this.this$0).get() == 5) {
      return;
    }
    this.this$0.setCurrentStatus(2);
    this.this$0.start();
    if (GameCenterVideoViewController.access$500(this.this$0) == 2)
    {
      i = GameCenterVideoViewController.sPlayCount + 1;
      GameCenterVideoViewController.sPlayCount = i;
      if ((i >= 3) && (((IQQGameConfigUtil)QRoute.api(IQQGameConfigUtil.class)).canShowFloatWindow(GameCenterVideoViewController.access$300(this.this$0).gameInfo.gameAppId)))
      {
        GameCenterVideoViewController.sPlayCount = 0;
        GameCenterVideoViewController.access$700(this.this$0).sendEmptyMessageDelayed(14, 30000L - GameCenterVideoViewController.access$600(this.this$0));
      }
    }
    long l = GameCenterVideoViewController.access$800(this.this$0).getDurationMs();
    localObject = GameCenterVideoViewController.access$900(this.this$0);
    int i = (int)l;
    ((SeekBar)localObject).setMax(i);
    GameCenterVideoViewController.access$1000(this.this$0).setText(((IReadInJoyDisplayUtils)QRoute.api(IReadInJoyDisplayUtils.class)).getDisplayDuration(i / 1000));
    this.this$0.updateControlPanle();
    GameCenterVideoViewController.access$1100(this.this$0, 0L);
    this.this$0.hideControlPanel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController.4
 * JD-Core Version:    0.7.0.1
 */