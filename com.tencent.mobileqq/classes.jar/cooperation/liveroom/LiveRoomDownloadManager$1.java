package cooperation.liveroom;

import bbwf;
import bbwg;

class LiveRoomDownloadManager$1
  extends bbwf
{
  LiveRoomDownloadManager$1(LiveRoomDownloadManager paramLiveRoomDownloadManager, LiveRoomDownloadManager.DownloadCallback paramDownloadCallback) {}
  
  public void onDone(bbwg parambbwg)
  {
    super.onDone(parambbwg);
    if (this.val$callback != null)
    {
      if (parambbwg.a() == 3) {
        this.val$callback.onSuccess(parambbwg.a(), parambbwg.a);
      }
    }
    else {
      return;
    }
    this.val$callback.onFailure(parambbwg.a(), parambbwg.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.liveroom.LiveRoomDownloadManager.1
 * JD-Core Version:    0.7.0.1
 */