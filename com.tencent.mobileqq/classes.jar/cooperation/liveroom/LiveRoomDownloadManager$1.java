package cooperation.liveroom;

import bhhe;
import bhhf;

class LiveRoomDownloadManager$1
  extends bhhe
{
  LiveRoomDownloadManager$1(LiveRoomDownloadManager paramLiveRoomDownloadManager, LiveRoomDownloadManager.DownloadCallback paramDownloadCallback) {}
  
  public void onDone(bhhf parambhhf)
  {
    super.onDone(parambhhf);
    if (this.val$callback != null)
    {
      if (parambhhf.a() == 3) {
        this.val$callback.onSuccess(parambhhf.a(), parambhhf.a);
      }
    }
    else {
      return;
    }
    this.val$callback.onFailure(parambhhf.a(), parambhhf.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.liveroom.LiveRoomDownloadManager.1
 * JD-Core Version:    0.7.0.1
 */