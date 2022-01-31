import android.view.View;
import android.view.animation.Transformation;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.PoiMapActivity;

public class mzb
  implements bdjy<Integer>
{
  public mzb(PoiMapActivity paramPoiMapActivity) {}
  
  public void a(bdjs<Integer> parambdjs, float paramFloat, Integer paramInteger, Transformation paramTransformation)
  {
    parambdjs = (FrameLayout.LayoutParams)PoiMapActivity.c(this.a).getLayoutParams();
    parambdjs.bottomMargin = (this.a.q + this.a.t);
    PoiMapActivity.c(this.a).setLayoutParams(parambdjs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mzb
 * JD-Core Version:    0.7.0.1
 */