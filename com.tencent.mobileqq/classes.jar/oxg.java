import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoView;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnSeekCompleteListener;

public class oxg
  implements TVK_IMediaPlayer.OnSeekCompleteListener
{
  public oxg(VideoView paramVideoView) {}
  
  public void onSeekComplete(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (VideoView.a(this.a) != null) {
      VideoView.a(this.a).start();
    }
    if (VideoView.a(this.a) != null) {
      this.a.a.postDelayed(this.a, 500L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oxg
 * JD-Core Version:    0.7.0.1
 */