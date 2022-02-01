import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.PoiMapActivity;

public class nht
  implements Animation.AnimationListener
{
  public nht(PoiMapActivity paramPoiMapActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = (FrameLayout.LayoutParams)PoiMapActivity.c(this.a).getLayoutParams();
    paramAnimation.bottomMargin = (this.a.p + this.a.q);
    PoiMapActivity.c(this.a).setLayoutParams(paramAnimation);
    if ((this.a.e != null) && (this.a.e.getVisibility() != 8)) {
      this.a.e.setVisibility(8);
    }
    PoiMapActivity.d(this.a).clearAnimation();
    this.a.a = true;
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nht
 * JD-Core Version:    0.7.0.1
 */