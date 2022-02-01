import android.widget.ImageView;
import com.tencent.avgame.gameroom.overlay.OverlayView;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.qphone.base.util.QLog;

public class ndr
  implements ncc
{
  public ndr(OverlayView paramOverlayView) {}
  
  public void a(LottieDrawable paramLottieDrawable)
  {
    if (paramLottieDrawable != null)
    {
      OverlayView.b(this.a, paramLottieDrawable);
      if (QLog.isColorLevel()) {
        QLog.d("OverlayView", 2, "loadLottieAnim success needRecoverFriendHeadCheerLottie = " + OverlayView.b(this.a));
      }
      if (OverlayView.b(this.a))
      {
        OverlayView.b(this.a).setImageDrawable(OverlayView.b(this.a));
        OverlayView.b(this.a).playAnimation();
        OverlayView.c(this.a, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ndr
 * JD-Core Version:    0.7.0.1
 */