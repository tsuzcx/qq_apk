import com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoView;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;

public class pte
  implements TVK_IMediaPlayer.OnCompletionListener
{
  public pte(VideoView paramVideoView) {}
  
  public void onCompletion(TVK_IMediaPlayer arg1)
  {
    synchronized (this.a)
    {
      VideoView.access$000(this.a, 10);
      this.a.displayCover();
      if (VideoView.access$2200(this.a) != null) {
        VideoView.access$2200(this.a).c();
      }
      VideoView.access$2300(this.a);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pte
 * JD-Core Version:    0.7.0.1
 */