import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoView;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnSeekCompleteListener;

public class ptf
  implements TVK_IMediaPlayer.OnSeekCompleteListener
{
  public ptf(VideoView paramVideoView) {}
  
  public void onSeekComplete(TVK_IMediaPlayer arg1)
  {
    synchronized (this.a)
    {
      if (VideoView.access$900(this.a) != null) {
        VideoView.access$900(this.a).start();
      }
      if (VideoView.access$1900(this.a) != null) {
        this.a.mProgressHandler.postDelayed(this.a, 500L);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ptf
 * JD-Core Version:    0.7.0.1
 */