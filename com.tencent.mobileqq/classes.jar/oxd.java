import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoView;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoView.2;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

public class oxd
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public oxd(VideoView.2 param2) {}
  
  public void onGlobalLayout()
  {
    if ((VideoView.b(this.a.this$0) == VideoView.b) && (!this.a.this$0.a))
    {
      if ((this.a.this$0.isShown()) && (VideoView.a(this.a.this$0).get() != 3))
      {
        VideoView.a(this.a.this$0).set(3);
        QLog.d("gifvideo.VideoView", 1, "show to play");
        this.a.this$0.b();
      }
      if ((!this.a.this$0.isShown()) && (VideoView.a(this.a.this$0).get() != 5))
      {
        VideoView.a(this.a.this$0).set(5);
        QLog.d("gifvideo.VideoView", 1, "unshow to stop");
        this.a.this$0.b();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oxd
 * JD-Core Version:    0.7.0.1
 */