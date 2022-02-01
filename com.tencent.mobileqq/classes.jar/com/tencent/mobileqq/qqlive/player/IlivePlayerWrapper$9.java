package com.tencent.mobileqq.qqlive.player;

import com.tencent.thumbplayer.api.ITPPlayerListener.IOnStateChangeListener;

class IlivePlayerWrapper$9
  implements ITPPlayerListener.IOnStateChangeListener
{
  IlivePlayerWrapper$9(IlivePlayerWrapper paramIlivePlayerWrapper) {}
  
  public void onStateChange(int paramInt1, int paramInt2)
  {
    if (IlivePlayerWrapper.k(this.a) != null) {
      IlivePlayerWrapper.k(this.a).onStateChange(paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.player.IlivePlayerWrapper.9
 * JD-Core Version:    0.7.0.1
 */