package com.tencent.mobileqq.qqlive.player;

import com.tencent.thumbplayer.api.ITPPlayer;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnStopAsyncCompleteListener;

class IlivePlayerWrapper$7
  implements ITPPlayerListener.IOnStopAsyncCompleteListener
{
  IlivePlayerWrapper$7(IlivePlayerWrapper paramIlivePlayerWrapper) {}
  
  public void onStopAsyncComplete(ITPPlayer paramITPPlayer)
  {
    if (IlivePlayerWrapper.i(this.a) != null) {
      IlivePlayerWrapper.i(this.a).onStopAsyncComplete(paramITPPlayer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.player.IlivePlayerWrapper.7
 * JD-Core Version:    0.7.0.1
 */