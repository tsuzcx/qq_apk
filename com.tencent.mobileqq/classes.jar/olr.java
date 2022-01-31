import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoView;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoView.2;

public class olr
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public olr(VideoView.2 param2) {}
  
  public void onGlobalLayout()
  {
    if (VideoView.b(this.a.this$0) == VideoView.b)
    {
      if ((this.a.this$0.isShown()) && (this.a.this$0.a() != 7)) {
        this.a.this$0.a();
      }
      if ((!this.a.this$0.isShown()) && (this.a.this$0.a() != 9)) {
        this.a.this$0.F_();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     olr
 * JD-Core Version:    0.7.0.1
 */