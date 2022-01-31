import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.SlideActiveAnimController;

public class qvq
  implements ValueAnimator.AnimatorUpdateListener
{
  public qvq(SlideActiveAnimController paramSlideActiveAnimController) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Float)paramValueAnimator.getAnimatedValue();
    SlideActiveAnimController.a(this.a).setAlpha(paramValueAnimator.floatValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qvq
 * JD-Core Version:    0.7.0.1
 */