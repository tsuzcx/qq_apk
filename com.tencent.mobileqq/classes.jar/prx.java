import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.LinearLayout;

class prx
  implements ValueAnimator.AnimatorUpdateListener
{
  prx(prr paramprr) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    prr.a(this.a, ((Integer)paramValueAnimator.getAnimatedValue()).intValue());
    prr.a(this.a).requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     prx
 * JD-Core Version:    0.7.0.1
 */