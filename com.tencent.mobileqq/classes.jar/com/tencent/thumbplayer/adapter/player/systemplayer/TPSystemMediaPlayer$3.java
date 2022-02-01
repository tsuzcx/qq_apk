package com.tencent.thumbplayer.adapter.player.systemplayer;

import android.media.MediaPlayer;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnErrorListener;
import com.tencent.thumbplayer.utils.TPLogUtil;

class TPSystemMediaPlayer$3
  implements Runnable
{
  TPSystemMediaPlayer$3(TPSystemMediaPlayer paramTPSystemMediaPlayer) {}
  
  public void run()
  {
    if ((TPSystemMediaPlayer.access$300(this.this$0) != TPSystemMediaPlayer.PlayerState.PAUSED) && (TPSystemMediaPlayer.access$1000(this.this$0)))
    {
      TPLogUtil.e(TPSystemMediaPlayer.access$400(this.this$0), "startCheckBufferTimeOutByInfo, buffer last too long");
      TPSystemMediaPlayer.access$500(this.this$0).reset();
      TPSystemMediaPlayer.access$500(this.this$0).release();
      TPSystemMediaPlayer.access$302(this.this$0, TPSystemMediaPlayer.PlayerState.ERROR);
      TPSystemMediaPlayer.access$1002(this.this$0, false);
      TPSystemMediaPlayer.access$1100(this.this$0);
      if (TPSystemMediaPlayer.access$700(this.this$0) != null) {
        TPSystemMediaPlayer.access$700(this.this$0).onError(2001, TPSystemMediaPlayer.access$800(this.this$0, -110), 0L, 0L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.player.systemplayer.TPSystemMediaPlayer.3
 * JD-Core Version:    0.7.0.1
 */