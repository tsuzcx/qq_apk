import android.view.View;
import android.view.animation.Transformation;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.PoiMapActivity;

public class nlc
  implements bfzz<Integer>
{
  public nlc(PoiMapActivity paramPoiMapActivity) {}
  
  public void a(bfzt<Integer> parambfzt, float paramFloat, Integer paramInteger, Transformation paramTransformation)
  {
    parambfzt = (FrameLayout.LayoutParams)this.a.b.getLayoutParams();
    parambfzt.bottomMargin = (this.a.o - paramInteger.intValue());
    this.a.b.setLayoutParams(parambfzt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nlc
 * JD-Core Version:    0.7.0.1
 */