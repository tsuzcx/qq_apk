import android.view.View;
import android.view.animation.Transformation;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.PoiMapActivity;
import com.tencent.mobileqq.utils.ValueAnimation;
import com.tencent.mobileqq.utils.ValueAnimation.AnimationUpdateListener;
import com.tencent.mobileqq.widget.QQMapView;

public class kjf
  implements ValueAnimation.AnimationUpdateListener
{
  public kjf(PoiMapActivity paramPoiMapActivity) {}
  
  public void a(ValueAnimation paramValueAnimation, float paramFloat, Integer paramInteger, Transformation paramTransformation)
  {
    paramValueAnimation = PoiMapActivity.g(this.a).getLayoutParams();
    paramValueAnimation.height = paramInteger.intValue();
    PoiMapActivity.h(this.a).setLayoutParams(paramValueAnimation);
    paramValueAnimation = (RelativeLayout.LayoutParams)this.a.b.getLayoutParams();
    paramValueAnimation.bottomMargin = (this.a.o - paramInteger.intValue());
    this.a.b.setLayoutParams(paramValueAnimation);
    int i = (paramInteger.intValue() - PoiMapActivity.c(this.a) - this.a.s) / 2;
    if (i >= (this.a.o - PoiMapActivity.d(this.a)) / 2 + this.a.t) {
      this.a.a(i, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kjf
 * JD-Core Version:    0.7.0.1
 */