import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.biz.qqstory.utils.TranslucentTitleBarHelper;

public class omv
  implements ValueAnimator.AnimatorUpdateListener
{
  public omv(TranslucentTitleBarHelper paramTranslucentTitleBarHelper) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    TranslucentTitleBarHelper.a(this.a, f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     omv
 * JD-Core Version:    0.7.0.1
 */