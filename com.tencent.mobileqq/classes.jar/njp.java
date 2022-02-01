import android.view.View;
import android.view.animation.Transformation;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.PoiMapActivity;

public class njp
  implements bhtj<Integer>
{
  public njp(PoiMapActivity paramPoiMapActivity) {}
  
  public void a(bhtd<Integer> parambhtd, float paramFloat, Integer paramInteger, Transformation paramTransformation)
  {
    parambhtd = (FrameLayout.LayoutParams)PoiMapActivity.c(this.a).getLayoutParams();
    parambhtd.bottomMargin = (this.a.q + this.a.t);
    PoiMapActivity.c(this.a).setLayoutParams(parambhtd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     njp
 * JD-Core Version:    0.7.0.1
 */