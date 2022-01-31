import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.PoiMapActivity;
import com.tencent.mobileqq.widget.QQMapView;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.UiSettings;

public class mwj
  implements Animation.AnimationListener
{
  public mwj(PoiMapActivity paramPoiMapActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (PoiMapActivity.g(this.a) != null) {
      PoiMapActivity.h(this.a).getMap().getUiSettings().setLogoPositionWithMargin(0, 0, 0, 0, 0);
    }
    paramAnimation = (FrameLayout.LayoutParams)this.a.b.getLayoutParams();
    paramAnimation.bottomMargin = (-this.a.p);
    this.a.b.setLayoutParams(paramAnimation);
    if ((this.a.e != null) && (this.a.e.getVisibility() != 0)) {
      this.a.e.setVisibility(0);
    }
    PoiMapActivity.e(this.a).clearAnimation();
    this.a.a = false;
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mwj
 * JD-Core Version:    0.7.0.1
 */