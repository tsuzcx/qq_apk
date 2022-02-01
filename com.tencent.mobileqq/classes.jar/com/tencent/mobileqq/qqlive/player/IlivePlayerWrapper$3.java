package com.tencent.mobileqq.qqlive.player;

import com.tencent.qqlive.module.videoreport.dtreport.video.playback.ReportThumbPlayer;
import com.tencent.thumbplayer.api.ITPPlayer;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnInfoListener;

class IlivePlayerWrapper$3
  implements ITPPlayerListener.IOnInfoListener
{
  IlivePlayerWrapper$3(IlivePlayerWrapper paramIlivePlayerWrapper) {}
  
  public void onInfo(ITPPlayer paramITPPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    ReportThumbPlayer.getInstance().onInfo(paramITPPlayer, paramInt, paramLong1, paramLong2);
    if (IlivePlayerWrapper.d(this.a) != null) {
      IlivePlayerWrapper.d(this.a).onInfo(paramITPPlayer, paramInt, paramLong1, paramLong2, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.player.IlivePlayerWrapper.3
 * JD-Core Version:    0.7.0.1
 */