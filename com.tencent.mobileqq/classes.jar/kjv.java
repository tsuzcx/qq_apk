import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.PoiMapActivity;
import com.tencent.mobileqq.widget.QQMapView;

public class kjv
  implements Animation.AnimationListener
{
  public kjv(PoiMapActivity paramPoiMapActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = PoiMapActivity.i(this.a).getLayoutParams();
    paramAnimation.height = this.a.o;
    PoiMapActivity.j(this.a).setLayoutParams(paramAnimation);
    paramAnimation = (RelativeLayout.LayoutParams)this.a.b.getLayoutParams();
    paramAnimation.bottomMargin = 0;
    this.a.b.setLayoutParams(paramAnimation);
    this.a.a((this.a.o - PoiMapActivity.e(this.a)) / 2 + this.a.t, false);
    if (this.a.e != null) {
      this.a.e.setVisibility(8);
    }
    PoiMapActivity.c(this.a).clearAnimation();
    this.a.a = true;
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kjv
 * JD-Core Version:    0.7.0.1
 */