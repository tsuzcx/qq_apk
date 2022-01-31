import android.view.View;
import android.view.animation.Transformation;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.PoiMapActivity;

public class mwi
  implements bble<Integer>
{
  public mwi(PoiMapActivity paramPoiMapActivity) {}
  
  public void a(bbky<Integer> parambbky, float paramFloat, Integer paramInteger, Transformation paramTransformation)
  {
    parambbky = (FrameLayout.LayoutParams)PoiMapActivity.c(this.a).getLayoutParams();
    parambbky.bottomMargin = (this.a.q + this.a.t);
    PoiMapActivity.c(this.a).setLayoutParams(parambbky);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mwi
 * JD-Core Version:    0.7.0.1
 */