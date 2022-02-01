package com.tencent.mobileqq.vas.vipav.api;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import com.tencent.mobileqq.vas.vipav.VipFunCallMediaListener;

final class VipFunCallUtil$2
  implements MediaPlayer.OnPreparedListener
{
  VipFunCallUtil$2(VipFunCallMediaListener paramVipFunCallMediaListener) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    paramMediaPlayer.start();
    paramMediaPlayer.setLooping(true);
    paramMediaPlayer = this.a;
    if (paramMediaPlayer != null) {
      paramMediaPlayer.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.vipav.api.VipFunCallUtil.2
 * JD-Core Version:    0.7.0.1
 */