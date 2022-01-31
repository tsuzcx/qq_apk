import android.view.View;
import android.view.animation.Transformation;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.PoiMapActivity;

public class myz
  implements bdoh<Integer>
{
  public myz(PoiMapActivity paramPoiMapActivity) {}
  
  public void a(bdob<Integer> parambdob, float paramFloat, Integer paramInteger, Transformation paramTransformation)
  {
    parambdob = (FrameLayout.LayoutParams)this.a.b.getLayoutParams();
    parambdob.bottomMargin = (this.a.o - paramInteger.intValue());
    this.a.b.setLayoutParams(parambdob);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     myz
 * JD-Core Version:    0.7.0.1
 */