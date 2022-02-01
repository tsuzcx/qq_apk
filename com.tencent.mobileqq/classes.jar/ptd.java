import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparedListener;
import java.util.concurrent.atomic.AtomicInteger;

public class ptd
  implements TVK_IMediaPlayer.OnVideoPreparedListener
{
  public ptd(VideoView paramVideoView) {}
  
  public void onVideoPrepared(TVK_IMediaPlayer arg1)
  {
    for (;;)
    {
      synchronized (this.a)
      {
        if (VideoView.access$1400(this.a))
        {
          VideoView.access$000(this.a, 6);
          VideoView.access$1502(this.a, VideoView.access$1600(this.a));
          VideoView.access$1702(this.a, "");
          VideoView.access$1800(this.a);
          if (VideoView.access$1900(this.a) != null) {
            this.a.mProgressHandler.postDelayed(this.a, 500L);
          }
          return;
        }
        QLog.d("gifvideo.VideoView", 1, "invalid state");
        VideoView.access$1702(this.a, "");
        if (VideoView.access$500(this.a).get() == 5) {
          VideoView.access$2000(this.a);
        }
      }
      if (VideoView.access$500(this.a).get() == 4) {
        VideoView.access$2100(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ptd
 * JD-Core Version:    0.7.0.1
 */