package com.tencent.thumbplayer.adapter.player.systemplayer;

import android.media.MediaPlayer;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnErrorListener;
import com.tencent.thumbplayer.utils.TPLogUtil;

class TPSystemMediaPlayer$1
  implements Runnable
{
  TPSystemMediaPlayer$1(TPSystemMediaPlayer paramTPSystemMediaPlayer) {}
  
  public void run()
  {
    if (TPSystemMediaPlayer.access$300(this.this$0) == TPSystemMediaPlayer.PlayerState.PREPARING) {
      TPLogUtil.e(TPSystemMediaPlayer.access$400(this.this$0), "startCheckPrepareTimeoutTimer, post error");
    }
    try
    {
      TPSystemMediaPlayer.access$500(this.this$0).reset();
      TPSystemMediaPlayer.access$500(this.this$0).release();
      TPSystemMediaPlayer.access$302(this.this$0, TPSystemMediaPlayer.PlayerState.ERROR);
      TPSystemMediaPlayer.access$600(this.this$0);
      if (TPSystemMediaPlayer.access$700(this.this$0) != null) {
        TPSystemMediaPlayer.access$700(this.this$0).onError(2001, TPSystemMediaPlayer.access$800(this.this$0, -110), 0L, 0L);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        TPLogUtil.e(TPSystemMediaPlayer.access$400(this.this$0), localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.player.systemplayer.TPSystemMediaPlayer.1
 * JD-Core Version:    0.7.0.1
 */