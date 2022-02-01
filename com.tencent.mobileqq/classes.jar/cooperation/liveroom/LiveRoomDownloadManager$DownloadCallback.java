package cooperation.liveroom;

import java.io.File;
import java.util.Map;

public abstract interface LiveRoomDownloadManager$DownloadCallback
{
  public abstract void onFailure(int paramInt, Map<String, File> paramMap);
  
  public abstract void onSuccess(int paramInt, Map<String, File> paramMap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.liveroom.LiveRoomDownloadManager.DownloadCallback
 * JD-Core Version:    0.7.0.1
 */