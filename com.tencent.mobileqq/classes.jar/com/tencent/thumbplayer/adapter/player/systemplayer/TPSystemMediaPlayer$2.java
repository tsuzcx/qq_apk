package com.tencent.thumbplayer.adapter.player.systemplayer;

class TPSystemMediaPlayer$2
  implements ITPSysPlayerExternalSubtitle.IPlayPositionListener
{
  TPSystemMediaPlayer$2(TPSystemMediaPlayer paramTPSystemMediaPlayer) {}
  
  public long getCurrentPosition()
  {
    if ((TPSystemMediaPlayer.access$300(this.this$0) != TPSystemMediaPlayer.PlayerState.PAUSED) && (TPSystemMediaPlayer.access$300(this.this$0) != TPSystemMediaPlayer.PlayerState.STARTED)) {
      return -1L;
    }
    return this.this$0.getCurrentPositionMs();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.player.systemplayer.TPSystemMediaPlayer.2
 * JD-Core Version:    0.7.0.1
 */