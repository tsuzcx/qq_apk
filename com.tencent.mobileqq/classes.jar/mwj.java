import android.view.View;
import android.view.animation.Transformation;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.PoiMapActivity;

public class mwj
  implements bbkq<Integer>
{
  public mwj(PoiMapActivity paramPoiMapActivity) {}
  
  public void a(bbkk<Integer> parambbkk, float paramFloat, Integer paramInteger, Transformation paramTransformation)
  {
    parambbkk = (FrameLayout.LayoutParams)this.a.b.getLayoutParams();
    parambbkk.bottomMargin = (this.a.o - paramInteger.intValue());
    this.a.b.setLayoutParams(parambbkk);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mwj
 * JD-Core Version:    0.7.0.1
 */