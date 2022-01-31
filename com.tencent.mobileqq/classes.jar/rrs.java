import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyDynamicGridView;

public class rrs
  implements ValueAnimator.AnimatorUpdateListener
{
  public rrs(ReadInJoyDynamicGridView paramReadInJoyDynamicGridView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rrs
 * JD-Core Version:    0.7.0.1
 */