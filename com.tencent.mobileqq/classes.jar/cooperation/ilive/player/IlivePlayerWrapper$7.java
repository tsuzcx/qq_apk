package cooperation.ilive.player;

import com.tencent.qphone.base.util.QLog;
import com.tencent.thumbplayer.api.ITPPlayer;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnStopAsyncCompleteListener;

class IlivePlayerWrapper$7
  implements ITPPlayerListener.IOnStopAsyncCompleteListener
{
  IlivePlayerWrapper$7(IlivePlayerWrapper paramIlivePlayerWrapper) {}
  
  public void onStopAsyncComplete(ITPPlayer paramITPPlayer)
  {
    QLog.i("CachePlayer", 1, "CachePlayer onStopAsyncComplete  ");
    if (IlivePlayerWrapper.i(this.a) != null) {
      IlivePlayerWrapper.i(this.a).onStopAsyncComplete(paramITPPlayer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.player.IlivePlayerWrapper.7
 * JD-Core Version:    0.7.0.1
 */