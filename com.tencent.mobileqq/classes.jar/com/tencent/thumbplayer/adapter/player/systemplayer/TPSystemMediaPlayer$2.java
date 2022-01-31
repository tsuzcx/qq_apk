package com.tencent.thumbplayer.adapter.player.systemplayer;

import android.media.MediaPlayer;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnErrorListener;
import com.tencent.thumbplayer.utils.TPLogUtil;

class TPSystemMediaPlayer$2
  implements Runnable
{
  TPSystemMediaPlayer$2(TPSystemMediaPlayer paramTPSystemMediaPlayer) {}
  
  public void run()
  {
    if (TPSystemMediaPlayer.access$400(this.this$0) == TPSystemMediaPlayer.PlayerState.PREPARING) {
      TPLogUtil.e("TPThumbPlayer[TPSystemMediaPlayer.java]", "startCheckPrepareTimeoutTimer, post error");
    }
    try
    {
      TPSystemMediaPlayer.access$700(this.this$0).stop();
      TPSystemMediaPlayer.access$402(this.this$0, TPSystemMediaPlayer.PlayerState.ERROR);
      TPSystemMediaPlayer.access$800(this.this$0);
      if (TPSystemMediaPlayer.access$900(this.this$0) != null) {
        TPSystemMediaPlayer.access$900(this.this$0).onError(2001, TPSystemMediaPlayer.access$1000(this.this$0, -110), 0L, 0L);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        TPLogUtil.e("TPThumbPlayer[TPSystemMediaPlayer.java]", localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.player.systemplayer.TPSystemMediaPlayer.2
 * JD-Core Version:    0.7.0.1
 */