package cooperation.liveroom;

import batl;
import batm;

class LiveRoomDownloadManager$1
  extends batl
{
  LiveRoomDownloadManager$1(LiveRoomDownloadManager paramLiveRoomDownloadManager, LiveRoomDownloadManager.DownloadCallback paramDownloadCallback) {}
  
  public void onDone(batm parambatm)
  {
    super.onDone(parambatm);
    if (this.val$callback != null)
    {
      if (parambatm.a() == 3) {
        this.val$callback.onSuccess(parambatm.a(), parambatm.a);
      }
    }
    else {
      return;
    }
    this.val$callback.onFailure(parambatm.a(), parambatm.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.liveroom.LiveRoomDownloadManager.1
 * JD-Core Version:    0.7.0.1
 */