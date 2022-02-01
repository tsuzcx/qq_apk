package com.tencent.mobileqq.qqlive.player;

import com.tencent.thumbplayer.api.ITPPlayer;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnVideoSizeChangedListener;

class IlivePlayerWrapper$8
  implements ITPPlayerListener.IOnVideoSizeChangedListener
{
  IlivePlayerWrapper$8(IlivePlayerWrapper paramIlivePlayerWrapper) {}
  
  public void onVideoSizeChanged(ITPPlayer paramITPPlayer, long paramLong1, long paramLong2)
  {
    if (IlivePlayerWrapper.j(this.a) != null) {
      IlivePlayerWrapper.j(this.a).onVideoSizeChanged(paramITPPlayer, paramLong1, paramLong2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.player.IlivePlayerWrapper.8
 * JD-Core Version:    0.7.0.1
 */