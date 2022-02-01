package cooperation.ilive.player;

import com.tencent.qphone.base.util.QLog;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CachePlayer onError : what = ");
    localStringBuilder.append(paramInt1);
    QLog.e("CachePlayer", 1, localStringBuilder.toString());
    if (IlivePlayerWrapper.e(this.a) != null) {
      IlivePlayerWrapper.e(this.a).onError(paramITPPlayer, paramInt1, paramInt2, paramLong1, paramLong2);
    }
    IlivePlayerWrapper.f(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.player.IlivePlayerWrapper.4
 * JD-Core Version:    0.7.0.1
 */