package cooperation.ilive.player;

import com.tencent.qphone.base.util.QLog;
import com.tencent.thumbplayer.api.ITPPlayer;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnSeekCompleteListener;

class IlivePlayerWrapper$5
  implements ITPPlayerListener.IOnSeekCompleteListener
{
  IlivePlayerWrapper$5(IlivePlayerWrapper paramIlivePlayerWrapper) {}
  
  public void onSeekComplete(ITPPlayer paramITPPlayer)
  {
    QLog.i("CachePlayer", 1, "CachePlayer onSeekComplete  ");
    if (IlivePlayerWrapper.g(this.a) != null) {
      IlivePlayerWrapper.g(this.a).onSeekComplete(paramITPPlayer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.player.IlivePlayerWrapper.5
 * JD-Core Version:    0.7.0.1
 */