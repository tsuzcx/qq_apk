import com.tencent.biz.qqstory.playvideo.player.VideoViewTVKImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;
import mqq.os.MqqHandler;

public class npn
  implements TVK_IMediaPlayer.OnCompletionListener
{
  public npn(VideoViewTVKImpl paramVideoViewTVKImpl) {}
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    ThreadManager.getUIHandler().post(new npo(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     npn
 * JD-Core Version:    0.7.0.1
 */