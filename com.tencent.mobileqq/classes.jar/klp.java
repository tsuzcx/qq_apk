import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.PoiMapActivity;
import com.tencent.mobileqq.widget.QQMapView;

public class klp
  implements Animation.AnimationListener
{
  public klp(PoiMapActivity paramPoiMapActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = PoiMapActivity.m(this.a).getLayoutParams();
    paramAnimation.height = (this.a.o + this.a.p);
    PoiMapActivity.n(this.a).setLayoutParams(paramAnimation);
    paramAnimation = (RelativeLayout.LayoutParams)this.a.b.getLayoutParams();
    paramAnimation.bottomMargin = (-this.a.p);
    this.a.b.setLayoutParams(paramAnimation);
    this.a.a((this.a.o + this.a.p - PoiMapActivity.h(this.a) - this.a.s) / 2, false);
    if (this.a.e != null) {
      this.a.e.setVisibility(0);
    }
    PoiMapActivity.d(this.a).clearAnimation();
    this.a.a = false;
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     klp
 * JD-Core Version:    0.7.0.1
 */