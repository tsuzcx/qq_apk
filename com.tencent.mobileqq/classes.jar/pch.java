import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoView;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

public class pch
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public pch(VideoView paramVideoView) {}
  
  public void onGlobalLayout()
  {
    if ((VideoView.a(this.a) == VideoView.b) && (!this.a.a))
    {
      if ((this.a.isShown()) && (VideoView.a(this.a).get() != 3))
      {
        VideoView.a(this.a).set(3);
        QLog.d("gifvideo.VideoView", 1, "show to play");
        this.a.c();
      }
      if ((!this.a.isShown()) && (VideoView.a(this.a).get() != 5))
      {
        VideoView.a(this.a).set(5);
        QLog.d("gifvideo.VideoView", 1, "unshow to stop");
        this.a.b();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pch
 * JD-Core Version:    0.7.0.1
 */