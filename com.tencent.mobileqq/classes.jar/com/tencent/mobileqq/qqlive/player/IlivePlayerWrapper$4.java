package com.tencent.mobileqq.qqlive.player;

import com.tencent.qqlive.module.videoreport.dtreport.video.playback.ReportThumbPlayer;
import com.tencent.thumbplayer.api.ITPPlayer;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnErrorListener;

class IlivePlayerWrapper$4
  implements ITPPlayerListener.IOnErrorListener
{
  IlivePlayerWrapper$4(IlivePlayerWrapper paramIlivePlayerWrapper) {}
  
  public void onError(ITPPlayer paramITPPlayer, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    ReportThumbPlayer.getInstance().onError(paramITPPlayer, paramInt1, paramInt2);
    if (IlivePlayerWrapper.e(this.a) != null) {
      IlivePlayerWrapper.e(this.a).onError(paramITPPlayer, paramInt1, paramInt2, paramLong1, paramLong2);
    }
    IlivePlayerWrapper.f(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.player.IlivePlayerWrapper.4
 * JD-Core Version:    0.7.0.1
 */