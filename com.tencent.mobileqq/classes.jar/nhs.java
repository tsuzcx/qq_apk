import android.view.View;
import android.view.animation.Transformation;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.PoiMapActivity;

public class nhs
  implements bgtg<Integer>
{
  public nhs(PoiMapActivity paramPoiMapActivity) {}
  
  public void a(bgta<Integer> parambgta, float paramFloat, Integer paramInteger, Transformation paramTransformation)
  {
    parambgta = (FrameLayout.LayoutParams)this.a.b.getLayoutParams();
    parambgta.bottomMargin = (this.a.o - paramInteger.intValue());
    this.a.b.setLayoutParams(parambgta);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nhs
 * JD-Core Version:    0.7.0.1
 */