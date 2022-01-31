import com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoView;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;

public class pcj
  implements TVK_IMediaPlayer.OnCompletionListener
{
  public pcj(VideoView paramVideoView) {}
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    try
    {
      VideoView.a(this.a, 10);
      if (VideoView.b(this.a)) {
        VideoView.h(this.a);
      }
      if (VideoView.a(this.a) != null) {
        VideoView.a(this.a).c();
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pcj
 * JD-Core Version:    0.7.0.1
 */