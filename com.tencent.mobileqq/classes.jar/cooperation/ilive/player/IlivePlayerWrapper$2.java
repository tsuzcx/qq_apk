package cooperation.ilive.player;

import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.video.playback.ReportThumbPlayer;
import com.tencent.thumbplayer.api.ITPPlayer;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnPreparedListener;
import java.util.concurrent.atomic.AtomicBoolean;

class IlivePlayerWrapper$2
  implements ITPPlayerListener.IOnPreparedListener
{
  IlivePlayerWrapper$2(IlivePlayerWrapper paramIlivePlayerWrapper) {}
  
  public void onPrepared(ITPPlayer paramITPPlayer)
  {
    ReportThumbPlayer.getInstance().onPrepared(paramITPPlayer);
    IlivePlayerWrapper.b(this.a).set(true);
    this.a.c();
    QLog.i("CachePlayer", 1, "preloadTPPlayer hasPrepare ");
    if (IlivePlayerWrapper.c(this.a) != null) {
      IlivePlayerWrapper.c(this.a).onPrepared(paramITPPlayer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.player.IlivePlayerWrapper.2
 * JD-Core Version:    0.7.0.1
 */