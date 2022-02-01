package cooperation.ilive.player;

import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.video.playback.ReportThumbPlayer;
import com.tencent.thumbplayer.api.ITPPlayer;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnCompletionListener;

class IlivePlayerWrapper$6
  implements ITPPlayerListener.IOnCompletionListener
{
  IlivePlayerWrapper$6(IlivePlayerWrapper paramIlivePlayerWrapper) {}
  
  public void onCompletion(ITPPlayer paramITPPlayer)
  {
    ReportThumbPlayer.getInstance().onCompletion(paramITPPlayer);
    QLog.i("CachePlayer", 1, "CachePlayer onCompletion  ");
    if (IlivePlayerWrapper.h(this.a) != null) {
      IlivePlayerWrapper.h(this.a).onCompletion(paramITPPlayer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.player.IlivePlayerWrapper.6
 * JD-Core Version:    0.7.0.1
 */