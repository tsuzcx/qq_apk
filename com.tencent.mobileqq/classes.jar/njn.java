import android.view.View;
import android.view.animation.Transformation;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.PoiMapActivity;

public class njn
  implements bhtj<Integer>
{
  public njn(PoiMapActivity paramPoiMapActivity) {}
  
  public void a(bhtd<Integer> parambhtd, float paramFloat, Integer paramInteger, Transformation paramTransformation)
  {
    parambhtd = (FrameLayout.LayoutParams)this.a.b.getLayoutParams();
    parambhtd.bottomMargin = (this.a.o - paramInteger.intValue());
    this.a.b.setLayoutParams(parambhtd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     njn
 * JD-Core Version:    0.7.0.1
 */