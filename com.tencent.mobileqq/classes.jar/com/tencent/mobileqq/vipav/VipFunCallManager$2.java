package com.tencent.mobileqq.vipav;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;

final class VipFunCallManager$2
  implements MediaPlayer.OnPreparedListener
{
  VipFunCallManager$2(VipFunCallMediaListener paramVipFunCallMediaListener) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    paramMediaPlayer.start();
    paramMediaPlayer.setLooping(true);
    if (this.a != null) {
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vipav.VipFunCallManager.2
 * JD-Core Version:    0.7.0.1
 */