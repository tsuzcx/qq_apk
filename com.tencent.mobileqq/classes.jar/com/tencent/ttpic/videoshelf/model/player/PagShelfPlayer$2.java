package com.tencent.ttpic.videoshelf.model.player;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.ttpic.videoshelf.utils.TTPTLogger;

class PagShelfPlayer$2
  implements MediaPlayer.OnErrorListener
{
  PagShelfPlayer$2(PagShelfPlayer paramPagShelfPlayer) {}
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("音频播放出错，code:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(",extrCode:");
    localStringBuilder.append(paramInt2);
    TTPTLogger.e("PagShelfPlayer", localStringBuilder.toString());
    PagShelfPlayer.access$202(this.this$0, true);
    if (paramMediaPlayer != null) {
      paramMediaPlayer.reset();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.videoshelf.model.player.PagShelfPlayer.2
 * JD-Core Version:    0.7.0.1
 */