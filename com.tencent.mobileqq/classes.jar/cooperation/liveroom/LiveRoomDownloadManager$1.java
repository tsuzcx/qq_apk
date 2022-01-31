package cooperation.liveroom;

import bead;
import beae;

class LiveRoomDownloadManager$1
  extends bead
{
  LiveRoomDownloadManager$1(LiveRoomDownloadManager paramLiveRoomDownloadManager, LiveRoomDownloadManager.DownloadCallback paramDownloadCallback) {}
  
  public void onDone(beae parambeae)
  {
    super.onDone(parambeae);
    if (this.val$callback != null)
    {
      if (parambeae.a() == 3) {
        this.val$callback.onSuccess(parambeae.a(), parambeae.a);
      }
    }
    else {
      return;
    }
    this.val$callback.onFailure(parambeae.a(), parambeae.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.liveroom.LiveRoomDownloadManager.1
 * JD-Core Version:    0.7.0.1
 */