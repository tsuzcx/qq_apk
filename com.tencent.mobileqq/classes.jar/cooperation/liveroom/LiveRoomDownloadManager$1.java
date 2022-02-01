package cooperation.liveroom;

import bhyn;
import bhyo;

class LiveRoomDownloadManager$1
  extends bhyn
{
  LiveRoomDownloadManager$1(LiveRoomDownloadManager paramLiveRoomDownloadManager, LiveRoomDownloadManager.DownloadCallback paramDownloadCallback) {}
  
  public void onDone(bhyo parambhyo)
  {
    super.onDone(parambhyo);
    if (this.val$callback != null)
    {
      if (parambhyo.a() == 3) {
        this.val$callback.onSuccess(parambhyo.a(), parambhyo.a);
      }
    }
    else {
      return;
    }
    this.val$callback.onFailure(parambhyo.a(), parambhyo.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.liveroom.LiveRoomDownloadManager.1
 * JD-Core Version:    0.7.0.1
 */