package com.tencent.thumbplayer.adapter.player.systemplayer;

import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnErrorListener;
import com.tencent.thumbplayer.log.TPBaseLogger;

class TPSystemMediaPlayer$3
  implements Runnable
{
  TPSystemMediaPlayer$3(TPSystemMediaPlayer paramTPSystemMediaPlayer) {}
  
  public void run()
  {
    if (TPSystemMediaPlayer.access$300(this.this$0) == TPSystemMediaPlayer.PlayerState.PREPARING)
    {
      TPSystemMediaPlayer.access$500(this.this$0).error("startCheckPrepareTimeoutTimer, post error");
      TPSystemMediaPlayer.access$302(this.this$0, TPSystemMediaPlayer.PlayerState.ERROR);
      TPSystemMediaPlayer.access$600(this.this$0);
      TPSystemMediaPlayer.access$700(this.this$0);
      ITPPlayerBaseListener.IOnErrorListener localIOnErrorListener = TPSystemMediaPlayer.access$800(this.this$0);
      if (localIOnErrorListener != null) {
        localIOnErrorListener.onError(2001, TPSystemMediaPlayer.access$900(-110), 0L, 0L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.player.systemplayer.TPSystemMediaPlayer.3
 * JD-Core Version:    0.7.0.1
 */