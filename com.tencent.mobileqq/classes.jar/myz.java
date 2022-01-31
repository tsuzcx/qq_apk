import android.view.View;
import android.view.animation.Transformation;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.PoiMapActivity;

public class myz
  implements bdjy<Integer>
{
  public myz(PoiMapActivity paramPoiMapActivity) {}
  
  public void a(bdjs<Integer> parambdjs, float paramFloat, Integer paramInteger, Transformation paramTransformation)
  {
    parambdjs = (FrameLayout.LayoutParams)this.a.b.getLayoutParams();
    parambdjs.bottomMargin = (this.a.o - paramInteger.intValue());
    this.a.b.setLayoutParams(parambdjs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     myz
 * JD-Core Version:    0.7.0.1
 */