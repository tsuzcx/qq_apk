import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparedListener;

public class oxe
  implements TVK_IMediaPlayer.OnVideoPreparedListener
{
  public oxe(VideoView paramVideoView) {}
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if ((VideoView.a(this.a) != null) && (VideoView.a(this.a).getDuration() >= 200L))
    {
      VideoView.a(this.a, 6);
      VideoView.a(this.a, VideoView.a(this.a));
      VideoView.b(this.a, "");
      VideoView.b(this.a);
      if (VideoView.a(this.a) != null) {
        this.a.a.postDelayed(this.a, 500L);
      }
      return;
    }
    QLog.d("gifvideo.VideoView", 1, "invalid video");
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oxe
 * JD-Core Version:    0.7.0.1
 */