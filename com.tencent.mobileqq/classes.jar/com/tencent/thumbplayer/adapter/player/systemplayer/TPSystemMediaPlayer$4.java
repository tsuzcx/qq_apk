package com.tencent.thumbplayer.adapter.player.systemplayer;

import android.media.MediaPlayer;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnErrorListener;
import com.tencent.thumbplayer.utils.TPLogUtil;

class TPSystemMediaPlayer$4
  implements Runnable
{
  TPSystemMediaPlayer$4(TPSystemMediaPlayer paramTPSystemMediaPlayer) {}
  
  public void run()
  {
    if ((TPSystemMediaPlayer.access$400(this.this$0) != TPSystemMediaPlayer.PlayerState.PAUSED) && (TPSystemMediaPlayer.access$1200(this.this$0)))
    {
      TPLogUtil.e("TPThumbPlayer[TPSystemMediaPlayer.java]", "startCheckBufferTimeOutByInfo, buffer last too long");
      TPSystemMediaPlayer.access$700(this.this$0).stop();
      TPSystemMediaPlayer.access$402(this.this$0, TPSystemMediaPlayer.PlayerState.ERROR);
      TPSystemMediaPlayer.access$1202(this.this$0, false);
      TPSystemMediaPlayer.access$1300(this.this$0);
      if (TPSystemMediaPlayer.access$900(this.this$0) != null) {
        TPSystemMediaPlayer.access$900(this.this$0).onError(2001, TPSystemMediaPlayer.access$1000(this.this$0, -110), 0L, 0L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.player.systemplayer.TPSystemMediaPlayer.4
 * JD-Core Version:    0.7.0.1
 */