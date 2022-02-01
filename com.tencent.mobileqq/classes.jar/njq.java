import android.widget.ImageView;
import com.tencent.avgame.gameroom.overlay.OverlayView;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.qphone.base.util.QLog;

public class njq
  implements nhz
{
  public njq(OverlayView paramOverlayView) {}
  
  public void a(LottieDrawable paramLottieDrawable)
  {
    if (paramLottieDrawable != null)
    {
      OverlayView.c(this.a, paramLottieDrawable);
      if (QLog.isColorLevel()) {
        QLog.d("OverlayView", 2, "loadLottieAnim success needRecoverSelfHeadCheerLottie = " + OverlayView.c(this.a));
      }
      if (OverlayView.c(this.a))
      {
        OverlayView.b(this.a).setImageDrawable(OverlayView.c(this.a));
        OverlayView.c(this.a).playAnimation();
        OverlayView.d(this.a, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     njq
 * JD-Core Version:    0.7.0.1
 */