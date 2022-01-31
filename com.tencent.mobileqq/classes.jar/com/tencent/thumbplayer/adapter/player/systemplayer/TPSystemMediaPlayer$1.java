package com.tencent.thumbplayer.adapter.player.systemplayer;

import android.media.MediaPlayer;
import com.tencent.thumbplayer.utils.TPLogUtil;

class TPSystemMediaPlayer$1
  implements Runnable
{
  TPSystemMediaPlayer$1(TPSystemMediaPlayer paramTPSystemMediaPlayer) {}
  
  public void run()
  {
    if ((!TPSystemMediaPlayer.access$300(this.this$0)) && (TPSystemMediaPlayer.access$400(this.this$0) != TPSystemMediaPlayer.PlayerState.PAUSED)) {
      TPSystemMediaPlayer.access$502(this.this$0, true);
    }
    try
    {
      TPLogUtil.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "position not change, so auto seek");
      TPSystemMediaPlayer.access$700(this.this$0).seekTo(TPSystemMediaPlayer.access$600(this.this$0) + 500);
      return;
    }
    catch (Exception localException)
    {
      TPLogUtil.e("TPThumbPlayer[TPSystemMediaPlayer.java]", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.player.systemplayer.TPSystemMediaPlayer.1
 * JD-Core Version:    0.7.0.1
 */