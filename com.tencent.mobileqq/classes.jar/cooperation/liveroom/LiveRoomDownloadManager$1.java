package cooperation.liveroom;

import bbwt;
import bbwu;

class LiveRoomDownloadManager$1
  extends bbwt
{
  LiveRoomDownloadManager$1(LiveRoomDownloadManager paramLiveRoomDownloadManager, LiveRoomDownloadManager.DownloadCallback paramDownloadCallback) {}
  
  public void onDone(bbwu parambbwu)
  {
    super.onDone(parambbwu);
    if (this.val$callback != null)
    {
      if (parambbwu.a() == 3) {
        this.val$callback.onSuccess(parambbwu.a(), parambbwu.a);
      }
    }
    else {
      return;
    }
    this.val$callback.onFailure(parambbwu.a(), parambbwu.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.liveroom.LiveRoomDownloadManager.1
 * JD-Core Version:    0.7.0.1
 */