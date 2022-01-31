package cooperation.liveroom;

import bdvu;
import bdvv;

class LiveRoomDownloadManager$1
  extends bdvu
{
  LiveRoomDownloadManager$1(LiveRoomDownloadManager paramLiveRoomDownloadManager, LiveRoomDownloadManager.DownloadCallback paramDownloadCallback) {}
  
  public void onDone(bdvv parambdvv)
  {
    super.onDone(parambdvv);
    if (this.val$callback != null)
    {
      if (parambdvv.a() == 3) {
        this.val$callback.onSuccess(parambdvv.a(), parambdvv.a);
      }
    }
    else {
      return;
    }
    this.val$callback.onFailure(parambdvv.a(), parambdvv.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.liveroom.LiveRoomDownloadManager.1
 * JD-Core Version:    0.7.0.1
 */