import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparedListener;
import java.util.concurrent.atomic.AtomicInteger;

public class pci
  implements TVK_IMediaPlayer.OnVideoPreparedListener
{
  public pci(VideoView paramVideoView) {}
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    for (;;)
    {
      try
      {
        if (VideoView.a(this.a))
        {
          VideoView.a(this.a, 6);
          VideoView.a(this.a, VideoView.a(this.a));
          VideoView.b(this.a, "");
          VideoView.e(this.a);
          if (VideoView.a(this.a) != null) {
            this.a.a.postDelayed(this.a, 500L);
          }
          return;
        }
        QLog.d("gifvideo.VideoView", 1, "invalid state");
        VideoView.b(this.a, "");
        if (VideoView.a(this.a).get() == 5)
        {
          VideoView.f(this.a);
          continue;
        }
        if (VideoView.a(this.a).get() != 4) {
          continue;
        }
      }
      finally {}
      VideoView.g(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pci
 * JD-Core Version:    0.7.0.1
 */