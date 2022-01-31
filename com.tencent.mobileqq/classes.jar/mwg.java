import android.view.View;
import android.view.animation.Transformation;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.PoiMapActivity;

public class mwg
  implements bble<Integer>
{
  public mwg(PoiMapActivity paramPoiMapActivity) {}
  
  public void a(bbky<Integer> parambbky, float paramFloat, Integer paramInteger, Transformation paramTransformation)
  {
    parambbky = (FrameLayout.LayoutParams)this.a.b.getLayoutParams();
    parambbky.bottomMargin = (this.a.o - paramInteger.intValue());
    this.a.b.setLayoutParams(parambbky);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mwg
 * JD-Core Version:    0.7.0.1
 */