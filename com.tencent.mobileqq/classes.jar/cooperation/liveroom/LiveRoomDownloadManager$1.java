package cooperation.liveroom;

import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;

class LiveRoomDownloadManager$1
  extends DownloadListener
{
  LiveRoomDownloadManager$1(LiveRoomDownloadManager paramLiveRoomDownloadManager, LiveRoomDownloadManager.DownloadCallback paramDownloadCallback) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    if (this.val$callback != null)
    {
      if (paramDownloadTask.a() == 3)
      {
        this.val$callback.onSuccess(paramDownloadTask.a(), paramDownloadTask.a);
        return;
      }
      this.val$callback.onFailure(paramDownloadTask.a(), paramDownloadTask.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.liveroom.LiveRoomDownloadManager.1
 * JD-Core Version:    0.7.0.1
 */