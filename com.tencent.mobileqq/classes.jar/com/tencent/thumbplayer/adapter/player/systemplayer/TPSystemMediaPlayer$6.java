package com.tencent.thumbplayer.adapter.player.systemplayer;

import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnErrorListener;
import com.tencent.thumbplayer.log.TPBaseLogger;

class TPSystemMediaPlayer$6
  implements Runnable
{
  TPSystemMediaPlayer$6(TPSystemMediaPlayer paramTPSystemMediaPlayer) {}
  
  public void run()
  {
    if ((TPSystemMediaPlayer.access$400(this.this$0) != TPSystemMediaPlayer.PlayerState.PAUSED) && (TPSystemMediaPlayer.access$1500(this.this$0)))
    {
      TPSystemMediaPlayer.access$900(this.this$0).error("startCheckBufferTimeOutByInfo, buffer last too long");
      TPSystemMediaPlayer.access$402(this.this$0, TPSystemMediaPlayer.PlayerState.ERROR);
      TPSystemMediaPlayer.access$1000(this.this$0);
      TPSystemMediaPlayer.access$1502(this.this$0, false);
      TPSystemMediaPlayer.access$1600(this.this$0);
      ITPPlayerBaseListener.IOnErrorListener localIOnErrorListener = TPSystemMediaPlayer.access$1200(this.this$0);
      if (localIOnErrorListener != null) {
        localIOnErrorListener.onError(2001, TPSystemMediaPlayer.access$700(-110), 0L, 0L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.player.systemplayer.TPSystemMediaPlayer.6
 * JD-Core Version:    0.7.0.1
 */