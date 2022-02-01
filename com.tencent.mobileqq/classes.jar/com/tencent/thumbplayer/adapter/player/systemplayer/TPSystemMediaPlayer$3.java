package com.tencent.thumbplayer.adapter.player.systemplayer;

import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnInfoListener;

class TPSystemMediaPlayer$3
  implements ITPSysPlayerExternalSubtitle.IOnTrackSelectListener
{
  TPSystemMediaPlayer$3(TPSystemMediaPlayer paramTPSystemMediaPlayer) {}
  
  public void onTrackSelectFailure(int paramInt, long paramLong)
  {
    if (TPSystemMediaPlayer.access$600(this.this$0) != null) {
      TPSystemMediaPlayer.access$600(this.this$0).onInfo(4, TPSystemMediaPlayer.access$700(paramInt), 0L, Long.valueOf(paramLong));
    }
  }
  
  public void onTrackSelectSuccess(long paramLong)
  {
    if (TPSystemMediaPlayer.access$400(this.this$0) == TPSystemMediaPlayer.PlayerState.STARTED) {
      TPSystemMediaPlayer.access$500(this.this$0).startAsync();
    }
    if (TPSystemMediaPlayer.access$600(this.this$0) != null) {
      TPSystemMediaPlayer.access$600(this.this$0).onInfo(4, 1000L, 0L, Long.valueOf(paramLong));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.player.systemplayer.TPSystemMediaPlayer.3
 * JD-Core Version:    0.7.0.1
 */