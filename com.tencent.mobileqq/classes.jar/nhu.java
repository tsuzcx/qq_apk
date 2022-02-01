import android.view.View;
import android.view.animation.Transformation;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.PoiMapActivity;

public class nhu
  implements bgtg<Integer>
{
  public nhu(PoiMapActivity paramPoiMapActivity) {}
  
  public void a(bgta<Integer> parambgta, float paramFloat, Integer paramInteger, Transformation paramTransformation)
  {
    parambgta = (FrameLayout.LayoutParams)PoiMapActivity.c(this.a).getLayoutParams();
    parambgta.bottomMargin = (this.a.q + this.a.t);
    PoiMapActivity.c(this.a).setLayoutParams(parambgta);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nhu
 * JD-Core Version:    0.7.0.1
 */