package cooperation.liveroom;

import biht;
import bihu;

class LiveRoomDownloadManager$1
  extends biht
{
  LiveRoomDownloadManager$1(LiveRoomDownloadManager paramLiveRoomDownloadManager, LiveRoomDownloadManager.DownloadCallback paramDownloadCallback) {}
  
  public void onDone(bihu parambihu)
  {
    super.onDone(parambihu);
    if (this.val$callback != null)
    {
      if (parambihu.a() == 3) {
        this.val$callback.onSuccess(parambihu.a(), parambihu.a);
      }
    }
    else {
      return;
    }
    this.val$callback.onFailure(parambihu.a(), parambihu.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.liveroom.LiveRoomDownloadManager.1
 * JD-Core Version:    0.7.0.1
 */