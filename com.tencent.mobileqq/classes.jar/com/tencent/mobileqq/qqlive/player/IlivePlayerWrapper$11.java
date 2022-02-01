package com.tencent.mobileqq.qqlive.player;

import android.view.Surface;
import com.tencent.thumbplayer.api.ITPPlayer;

class IlivePlayerWrapper$11
  implements Runnable
{
  IlivePlayerWrapper$11(IlivePlayerWrapper paramIlivePlayerWrapper, Surface paramSurface) {}
  
  public void run()
  {
    if (IlivePlayerWrapper.l(this.this$0) != null) {
      IlivePlayerWrapper.l(this.this$0).setSurface(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.player.IlivePlayerWrapper.11
 * JD-Core Version:    0.7.0.1
 */