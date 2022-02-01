package com.tencent.thumbplayer.adapter.player.systemplayer;

import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnErrorListener;
import com.tencent.thumbplayer.log.TPBaseLogger;

class TPSystemMediaPlayer$5
  implements Runnable
{
  TPSystemMediaPlayer$5(TPSystemMediaPlayer paramTPSystemMediaPlayer) {}
  
  public void run()
  {
    if ((TPSystemMediaPlayer.access$300(this.this$0) != TPSystemMediaPlayer.PlayerState.PAUSED) && (TPSystemMediaPlayer.access$1200(this.this$0)))
    {
      TPSystemMediaPlayer.access$500(this.this$0).error("startCheckBufferTimeOutByInfo, buffer last too long");
      TPSystemMediaPlayer.access$302(this.this$0, TPSystemMediaPlayer.PlayerState.ERROR);
      TPSystemMediaPlayer.access$600(this.this$0);
      TPSystemMediaPlayer.access$1202(this.this$0, false);
      TPSystemMediaPlayer.access$1300(this.this$0);
      ITPPlayerBaseListener.IOnErrorListener localIOnErrorListener = TPSystemMediaPlayer.access$800(this.this$0);
      if (localIOnErrorListener != null) {
        localIOnErrorListener.onError(2001, TPSystemMediaPlayer.access$900(-110), 0L, 0L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.player.systemplayer.TPSystemMediaPlayer.5
 * JD-Core Version:    0.7.0.1
 */