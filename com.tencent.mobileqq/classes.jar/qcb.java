import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoView;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

public class qcb
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public qcb(VideoView paramVideoView) {}
  
  public void onGlobalLayout()
  {
    if ((VideoView.access$400(this.a) == VideoView.PLAYMODE_AUTO) && (!this.a.needInterceptGlobalLayoutChanged))
    {
      if ((this.a.isShown()) && (VideoView.access$500(this.a).get() != 3))
      {
        VideoView.access$500(this.a).set(3);
        QLog.d("gifvideo.VideoView", 1, "show to play");
        this.a.startPlay();
      }
      if ((!this.a.isShown()) && (VideoView.access$500(this.a).get() != 5))
      {
        VideoView.access$500(this.a).set(5);
        QLog.d("gifvideo.VideoView", 1, "unshow to stop");
        this.a.stop();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qcb
 * JD-Core Version:    0.7.0.1
 */