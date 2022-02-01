package cooperation.liveroom;

import bgod;
import bgoe;

class LiveRoomDownloadManager$1
  extends bgod
{
  LiveRoomDownloadManager$1(LiveRoomDownloadManager paramLiveRoomDownloadManager, LiveRoomDownloadManager.DownloadCallback paramDownloadCallback) {}
  
  public void onDone(bgoe parambgoe)
  {
    super.onDone(parambgoe);
    if (this.val$callback != null)
    {
      if (parambgoe.a() == 3) {
        this.val$callback.onSuccess(parambgoe.a(), parambgoe.a);
      }
    }
    else {
      return;
    }
    this.val$callback.onFailure(parambgoe.a(), parambgoe.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.liveroom.LiveRoomDownloadManager.1
 * JD-Core Version:    0.7.0.1
 */