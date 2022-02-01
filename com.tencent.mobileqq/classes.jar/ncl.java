import android.widget.ImageView;
import com.tencent.avgame.gameroom.overlay.OverlayView;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.qphone.base.util.QLog;

public class ncl
  implements nbb
{
  public ncl(OverlayView paramOverlayView) {}
  
  public void a(LottieDrawable paramLottieDrawable)
  {
    if (paramLottieDrawable != null)
    {
      OverlayView.a(this.a, paramLottieDrawable);
      if (QLog.isColorLevel()) {
        QLog.d("OverlayView", 2, "loadLottieAnim success needRecoverCardStarLottie = " + OverlayView.a(this.a));
      }
      if (OverlayView.a(this.a))
      {
        OverlayView.a(this.a).setImageDrawable(OverlayView.a(this.a));
        OverlayView.a(this.a).playAnimation();
        OverlayView.b(this.a, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ncl
 * JD-Core Version:    0.7.0.1
 */