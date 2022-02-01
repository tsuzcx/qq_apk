package com.tencent.mobileqq.qwallet.hb.grap.impl;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

class RedPacketKSongFragment$6
  implements MediaPlayer.OnCompletionListener
{
  RedPacketKSongFragment$6(RedPacketKSongFragment paramRedPacketKSongFragment) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    RedPacketKSongFragment.a(this.a, false);
    paramMediaPlayer.release();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.impl.RedPacketKSongFragment.6
 * JD-Core Version:    0.7.0.1
 */