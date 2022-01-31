import com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoView;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;

public class olt
  implements TVK_IMediaPlayer.OnCompletionListener
{
  public olt(VideoView paramVideoView) {}
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    VideoView.a(this.a, 10);
    if (VideoView.b(this.a)) {
      VideoView.c(this.a);
    }
    if (VideoView.a(this.a) != null) {
      VideoView.a(this.a).c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     olt
 * JD-Core Version:    0.7.0.1
 */