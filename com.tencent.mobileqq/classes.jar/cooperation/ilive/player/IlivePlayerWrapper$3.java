package cooperation.ilive.player;

import com.tencent.qphone.base.util.QLog;
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("CachePlayer onInfo : what = ");
      localStringBuilder.append(paramInt);
      QLog.i("CachePlayer", 2, localStringBuilder.toString());
    }
    if (IlivePlayerWrapper.d(this.a) != null) {
      IlivePlayerWrapper.d(this.a).onInfo(paramITPPlayer, paramInt, paramLong1, paramLong2, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.player.IlivePlayerWrapper.3
 * JD-Core Version:    0.7.0.1
 */