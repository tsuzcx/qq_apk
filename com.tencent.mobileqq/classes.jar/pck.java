import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoView;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnSeekCompleteListener;

public class pck
  implements TVK_IMediaPlayer.OnSeekCompleteListener
{
  public pck(VideoView paramVideoView) {}
  
  public void onSeekComplete(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    try
    {
      if (VideoView.a(this.a) != null) {
        VideoView.a(this.a).start();
      }
      if (VideoView.a(this.a) != null) {
        this.a.a.postDelayed(this.a, 500L);
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pck
 * JD-Core Version:    0.7.0.1
 */