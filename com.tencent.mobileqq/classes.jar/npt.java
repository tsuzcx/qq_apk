import com.tencent.biz.qqstory.playvideo.player.VideoViewTVKImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparedListener;
import mqq.os.MqqHandler;

public class npt
  implements TVK_IMediaPlayer.OnVideoPreparedListener
{
  public npt(VideoViewTVKImpl paramVideoViewTVKImpl) {}
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    ThreadManager.getUIHandler().post(new npu(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     npt
 * JD-Core Version:    0.7.0.1
 */